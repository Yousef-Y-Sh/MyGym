package com.example.mygym.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mygym.R;
import com.example.mygym.Utils.Utils;
import com.example.mygym.database.MyDataBase;
import com.example.mygym.databinding.ActivityAddDayBinding;
import com.example.mygym.moudle.Day;
import com.example.mygym.moudle.Guide;
import com.example.mygym.moudle.GuideIntent;
import com.example.mygym.moudle.MyGuide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddDayActivity extends AppCompatActivity {
    ActivityAddDayBinding binding;
    Bundle bundle;
    MyGuide parentIntentCollection;
    Day parentDay;
    List<Guide> selectedList;
    List<Guide> _BackGuidsList;
    List<Guide> _BaycepsGuidsList;
    List<Guide> _ChestGuidsList;
    List<Guide> _ForemarsGuidsList;
    List<Guide> _LegsGuidsList;
    List<Guide> _ShouldersGuidsList;
    List<Guide> _StomashGuidsList;
    List<Guide> _TricepsGuidsList;

    MyDataBase myDataBase;
    boolean isError = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddDayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        bundle = getIntent().getExtras();
        myDataBase = new MyDataBase(this);
        selectedList = new ArrayList<>();

        _BackGuidsList = new ArrayList<>();
        _BaycepsGuidsList = new ArrayList<>();
        _ChestGuidsList = new ArrayList<>();
        _ForemarsGuidsList = new ArrayList<>();
        _LegsGuidsList = new ArrayList<>();
        _ShouldersGuidsList = new ArrayList<>();
        _StomashGuidsList = new ArrayList<>();
        _TricepsGuidsList = new ArrayList<>();
        binding.toolbar.title.setText("اضافة يوم تدريبي");
        binding.toolbar.backImg.setOnClickListener(view -> finish());
        binding.toolbar.save.setVisibility(View.VISIBLE);

        if (bundle.getParcelable(Utils.__INTENTCOLLECTION) != null) {
            parentIntentCollection = bundle.getParcelable(Utils.__INTENTCOLLECTION);
        }

        /////////////data on intent from AllDaysAdapter object,list,day

        if (bundle.getParcelable("list") != null) {
            binding.toolbar.save.setText("تعديل");
            GuideIntent guideIntent = bundle.getParcelable("list");
            _BackGuidsList.clear();
            _BaycepsGuidsList.clear();
            _ChestGuidsList.clear();
            _ForemarsGuidsList.clear();
            _LegsGuidsList.clear();
            _ShouldersGuidsList.clear();
            _StomashGuidsList.clear();
            _TricepsGuidsList.clear();
            filteringIntentList(guideIntent.getList());
        } else binding.toolbar.save.setText("إضافة");
        if (bundle.getParcelable("day") != null) {
            parentDay = bundle.getParcelable("day");
            binding.nameOfDay.setEnabled(false);
            binding.nameOfDay.setText(parentDay.getTitle());
        }
        binding.toolbar.save.setOnClickListener(view -> {
            selectedList.addAll(_BackGuidsList);
            selectedList.addAll(_BaycepsGuidsList);
            selectedList.addAll(_ChestGuidsList);
            selectedList.addAll(_ForemarsGuidsList);
            selectedList.addAll(_LegsGuidsList);
            selectedList.addAll(_ShouldersGuidsList);
            selectedList.addAll(_StomashGuidsList);
            selectedList.addAll(_TricepsGuidsList);
            if (!Utils._valideText(binding.nameOfDay)) {
                binding.nameOfDay.setError("هذا الحقل مطلوب");
                return;
            }
            if (selectedList.isEmpty()) {
                Utils._Toast(AddDayActivity.this, "يرجى اضافة تمارين");
                return;
            }
            if (bundle.getParcelable("list") == null) {

                int dayID = myDataBase.INSERT_DAY(new Day(Utils._GetText(binding.nameOfDay), parentIntentCollection.getId()));
                for (Guide guide : selectedList) {
                    if (!myDataBase.INSERT_EXECUTE(new Guide(guide.getImage(), guide.getTitle(), dayID, guide.getType())))
                        isError = false;
                }
                if (isError) {
                    Map<String, Object> map = Utils._showDialog(AddDayActivity.this, R.layout.complete_add);
                    View v = (View) map.get(Utils.__VIEW);
                    AlertDialog alertDialog = (AlertDialog) map.get(Utils.__BOTTOMSHEETDIALOG);
                    TextView dissbtn = (TextView) v.findViewById(R.id.dissbtn);
                    dissbtn.setOnClickListener(view1 -> {
                        alertDialog.dismiss();
                        Intent intent = new Intent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        setResult(RESULT_OK, intent);
                        finish();
                    });
                }

            } else {
                if (bundle.getParcelable("day") != null) {
                    parentDay = bundle.getParcelable("day");
                }
                for (Guide guide : myDataBase.GET_ALL_EXECUTES(parentDay.getId())) {
                    if (!myDataBase.DELETE_EXECUTE(guide.getId())) {
                        isError = false;
                    }
                }
                if (isError) {
                    for (Guide guide : selectedList) {
                        if (!myDataBase.INSERT_EXECUTE(new Guide(guide.getImage(), guide.getTitle(), parentDay.getId(), guide.getType()))) {
                            isError = false;
                        }
                    }
                    if (isError) {
                        Map<String, Object> map = Utils._showDialog(AddDayActivity.this, R.layout.complete_add);
                        View v = (View) map.get(Utils.__VIEW);
                        AlertDialog alertDialog = (AlertDialog) map.get(Utils.__BOTTOMSHEETDIALOG);
                        TextView title = (TextView) v.findViewById(R.id.title);
                        TextView subTitle = (TextView) v.findViewById(R.id.subTitle);
                        TextView dissbtn = (TextView) v.findViewById(R.id.dissbtn);
                        title.setText("تعديل يوم تدريبي");
                        subTitle.setText("لقد تم تعديل يومك التدريبي بنجاح يمكنك الاستمرار واستعراض تمارينك الجديدة");
                        dissbtn.setOnClickListener(view1 -> {
                            alertDialog.dismiss();
                            Intent intent = new Intent();
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            setResult(RESULT_OK, intent);
                            finish();
                        });
                    }
                }
            }
        });
        onClickItem();

    }

    void onClickItem() {
        binding.back.setOnClickListener(view -> goIntent(Utils.__BACKGUIDS, _BackGuidsList));
        binding.baycep.setOnClickListener(view -> goIntent(Utils.__BAYCEPSGUIDS, _BaycepsGuidsList));
        binding.chest.setOnClickListener(view -> goIntent(Utils.__CHESTGUIDS, _ChestGuidsList));
        binding.forearms.setOnClickListener(view -> goIntent(Utils.__FOREAMRMSGUIDS, _ForemarsGuidsList));
        binding.legs.setOnClickListener(view -> goIntent(Utils.__LEGSGUIDS, _LegsGuidsList));
        binding.shoulders.setOnClickListener(view -> goIntent(Utils.__SHOULDERSGUIDS, _ShouldersGuidsList));
        binding.stomach.setOnClickListener(view -> goIntent(Utils.__STOMACHGUIDS, _StomashGuidsList));
        binding.triceps.setOnClickListener(view -> goIntent(Utils.__TRICEPSGUIDS, _TricepsGuidsList));
        binding.nameOfDay.setOnFocusChangeListener((view, b) -> {
            if (b)
                binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape_foucse);
            else binding.textInputLayout.setBackgroundResource(R.drawable.text_input_layout_shape);
        });
        binding.nameOfDay.setOnKeyListener((view, i, keyEvent) -> {
            if (i == keyEvent.KEYCODE_ENTER) {
                Utils._HideKeyboard(AddDayActivity.this, binding.nameOfDay);
                binding.nameOfDay.clearFocus();
                return true;
            }
            return false;
        });

        KeyboardVisibilityEvent.setEventListener(AddDayActivity.this, new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                if (!isOpen) binding.nameOfDay.clearFocus();
            }
        });
    }

    private void goIntent(String type, List<Guide> list) {
        GuideIntent guideIntent = new GuideIntent(list);
        Intent intent = new Intent(getApplicationContext(), SelectGuideActivity.class);
        intent.putExtra("type", type);
        intent.putExtra("list", guideIntent);
        startActivityForResult(intent, 222);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == 222) {
                GuideIntent guideIntent = data.getParcelableExtra(Utils._DATA);
                String type = data.getStringExtra("type");
                shortImageController(type, guideIntent.getList());
            }
        }
    }

    void shortImageController(String type, List<Guide> myselectedList) {
        switch (type) {
            case Utils.__BACKGUIDS:
                _BackGuidsList.clear();
                _BackGuidsList.addAll(myselectedList);
                inflateShortImage(binding.one, binding.oneImage, R.drawable.daher);
                break;
            case Utils.__BAYCEPSGUIDS:
                _BaycepsGuidsList.clear();
                _BaycepsGuidsList.addAll(myselectedList);
                inflateShortImage(binding.two, binding.twoImage, R.drawable.bay);
                break;
            case Utils.__CHESTGUIDS:
                _ChestGuidsList.clear();
                _ChestGuidsList.addAll(myselectedList);
                inflateShortImage(binding.three, binding.threeImage, R.drawable.sader);
                break;
            case Utils.__FOREAMRMSGUIDS:
                _ForemarsGuidsList.clear();
                _ForemarsGuidsList.addAll(myselectedList);
                inflateShortImage(binding.four, binding.fourImage, R.drawable.formars_full);
                break;
            case Utils.__LEGSGUIDS:
                _LegsGuidsList.clear();
                _LegsGuidsList.addAll(myselectedList);
                inflateShortImage(binding.five, binding.fiveImage, R.drawable.leg);
                break;
            case Utils.__SHOULDERSGUIDS:
                _ShouldersGuidsList.clear();
                _ShouldersGuidsList.addAll(myselectedList);
                inflateShortImage(binding.sex, binding.sexImage, R.drawable.ketef);
                break;
            case Utils.__STOMACHGUIDS:
                _StomashGuidsList.clear();
                _StomashGuidsList.addAll(myselectedList);
                inflateShortImage(binding.seven, binding.sevenImage, R.drawable.meda);
                break;
            case Utils.__TRICEPSGUIDS:
                _TricepsGuidsList.clear();
                _TricepsGuidsList.addAll(myselectedList);
                inflateShortImage(binding.eight, binding.eightImage, R.drawable.tray_full);
                break;
        }
    }

    void inflateShortImage(LinearLayout linearLayout, ImageView imageView, int img) {
        linearLayout.setVisibility(View.VISIBLE);
        imageView.setImageResource(img);
    }

    void filteringIntentList(List<Guide> list) {
        for (Guide guide : list) {
            switch (guide.getType()) {
                case Utils.__BACKGUIDS:
                    _BackGuidsList.add(guide);
                    inflateShortImage(binding.one, binding.oneImage, R.drawable.daher);
                    break;
                case Utils.__BAYCEPSGUIDS:
                    _BaycepsGuidsList.add(guide);
                    inflateShortImage(binding.two, binding.twoImage, R.drawable.bay);
                    break;
                case Utils.__CHESTGUIDS:
                    _ChestGuidsList.add(guide);
                    inflateShortImage(binding.three, binding.threeImage, R.drawable.sader);
                    break;
                case Utils.__FOREAMRMSGUIDS:
                    _ForemarsGuidsList.add(guide);
                    inflateShortImage(binding.four, binding.fourImage, R.drawable.formars_full);
                    break;
                case Utils.__LEGSGUIDS:
                    _LegsGuidsList.add(guide);
                    inflateShortImage(binding.five, binding.fiveImage, R.drawable.leg);
                    break;
                case Utils.__SHOULDERSGUIDS:
                    _ShouldersGuidsList.add(guide);
                    inflateShortImage(binding.sex, binding.sexImage, R.drawable.ketef);
                    break;
                case Utils.__STOMACHGUIDS:
                    _StomashGuidsList.add(guide);
                    inflateShortImage(binding.seven, binding.sevenImage, R.drawable.meda);
                    break;
                case Utils.__TRICEPSGUIDS:
                    _TricepsGuidsList.add(guide);
                    inflateShortImage(binding.eight, binding.eightImage, R.drawable.tray_full);
                    break;
            }
        }

    }
}

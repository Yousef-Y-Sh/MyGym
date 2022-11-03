package com.example.mygym.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.mygym.R;
import com.example.mygym.activity.AddGuideActivity;
import com.example.mygym.moudle.Guide;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static final String __BACKGUIDS = "a1";
    public static final String __BAYCEPSGUIDS = "a2";
    public static final String __CHESTGUIDS = "a3";
    public static final String __FOREAMRMSGUIDS = "a4";
    public static final String __LEGSGUIDS = "a5";
    public static final String __SHOULDERSGUIDS = "a6";
    public static final String __STOMACHGUIDS = "a7";
    public static final String __TRICEPSGUIDS = "a8";

    public static final String __BOTTOMSHEETDIALOG = "bottomSheetDialog";
    public static final String __BOTTOMSHEETBEHAVIOR = "bottomSheetBehavior";
    public static final String __VIEW = "view";

    public static void _IntentWithClearTask(Activity activity, Class aClass) {
        Intent intent = new Intent(activity, aClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    public static void _Intent(Activity activity, Class aClass) {
        Intent intent = new Intent(activity, aClass);
        activity.startActivity(intent);
    }

    public static void _IntentForResult(Activity activity, Class aClass, int requestCode) {
        Intent intent = new Intent(activity, aClass);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void _IntentForResult(Activity activity, Class aClass, int requestCode, Bundle bundle) {
        Intent intent = new Intent(activity, aClass);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void _HideKeyboard(Activity activity, View v) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static boolean _valideText(EditText editText) {
        if (editText.getText().toString().trim().isEmpty()) return false;
        else return true;
    }

    public static void _Toast(Context contex, String text) {
        Toast.makeText(contex, text, Toast.LENGTH_LONG).show();
    }

    public static String _GetText(View view) {
        if (view instanceof EditText) {
            EditText editText = (EditText) view;
            return editText.getText().toString().trim();
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            return textView.getText().toString().trim();
        }
        if (view instanceof Spinner) {
            Spinner spinner = (Spinner) view;
            return spinner.getSelectedItem().toString().trim();
        }
        return null;
    }

    public static Map<String, Object> _showBottomSheet(Activity activity, int Layout, int container) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity, R.style.BottomSheetDialogTheme);
        View v = LayoutInflater.from(activity).inflate(Layout, activity.findViewById(container));
        bottomSheetDialog.setContentView(v);
        bottomSheetDialog.show();
        Map<String, Object> map = new HashMap<>();
        map.put(__BOTTOMSHEETDIALOG, bottomSheetDialog);
        map.put(__VIEW, v);
        return map;
    }

    public static Map<String, Object> _showBottomSheetFullScreen(Activity activity, int Layout, int container) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        BottomSheetBehavior<View> bottomSheetBehavior;
        View view = LayoutInflater.from(activity).inflate(Layout, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.setDraggable(false);
        CoordinatorLayout coordinatorLayout = bottomSheetDialog.findViewById(container);

        assert coordinatorLayout != null;
        coordinatorLayout.setMinimumHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        bottomSheetDialog.show();

        Map<String, Object> map = new HashMap<>();
        map.put("bottomSheetDialog", bottomSheetDialog);
        map.put("view", view);
        map.put("bottomSheetBehavior", bottomSheetBehavior);
        return map;
    }

    public static List<Guide> Chest() {
        List<Guide> chestList = new ArrayList<>();
        chestList.add(new Guide(R.drawable.img01, "تمرين الصدر بالبار سفلي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img02, "تمرين الصدر بالبار علوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img03, "تمرين الصدر بالبار مستوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img04, "تمرين الصدر بالدامبل سفلي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img05, "تمرين الصدر بالدامبل علوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img06, "تمرين الصدر بالدامبل مستوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img07, "تمرين الرفرفة بالدامبل سفلي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img08, "تمرين الرفرفة بالدامبل علوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img09, "تمرين الرفرفة بالدامبل مستوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img010, "تمرين الصدر بالكابل سفلي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img011, "تمرين الصدر بالكابل علوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img012, "تمرين الصدر بالكابل مستوي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img013, "تمرين الصدر بالكابل متوسط", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img014, "تمرين الصدر بجهاز الفراشة", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img015, "تمرين هامر بالدامبل سفلي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img016, "تمرين الغطس المتوازي", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img017, "تمرين SVEND PRESS", __CHESTGUIDS));
        chestList.add(new Guide(R.drawable.img018, "تمرين الصدر بالة الضغط", __CHESTGUIDS));
        return chestList;
    }

    public static List<Guide> Back() {
        List<Guide> backList = new ArrayList<>();
        backList.add(new Guide(R.drawable.img0001, "سحب خلفي واسع", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0002, "سحب امامي ضيق", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0003, "سحب امامي ضيق عكسي", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0004, "سحب امامي ضيق V", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0005, "تمرين سحب كابل V", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0006, "سحب امامي كابل واسع", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0007, "تمرين سحب بار", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0008, "سحب بار قبضة معكوسة", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img0009, "ديدليفت", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00010, "تمرين الحصان", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00011, "تمرين جذب البار", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00012, "تمرين سحب ضيق بالجهاز", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00013, "سحب افقي بالكابل", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00014, "سحب متوسط بالكابل", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00015, "تمرين سحب بالدامبل فردي", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00016, "تمرين سحب الدامبل زوجي", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00017, "دامبل بول اوفر", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00018, "تمرين العقلة واسع", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00019, "تمرين العقلة ضيق", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00020, "سحب متوسط بالكابل", __BACKGUIDS));
        backList.add(new Guide(R.drawable.img00021, "سحب بالبار معكوس", __BACKGUIDS));
        return backList;
    }

    public static List<Guide> BaycepsList() {
        List<Guide> baycepsList = new ArrayList<>();
        baycepsList.add(new Guide(R.drawable.img00000001, "تمرين بايسبس بالبار 1", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000002, "تمرين بايسبس بالبار 2", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000003, "تمرين بايسبس بالبار 3", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000004, "تمرين بايسبس بالبار 4", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000005, "تمرين بايسبس بالدامبل 1", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000006, "تمرين بايسبس بالدامبل 2", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000007, "تمرين بايسبس بالدامبل 3", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000008, "تمرين بايسبس بالدامبل 4", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img00000009, "تمرين بايسبس بالدامبل 5", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000010, "تمرين بايسبس بالدامبل 6", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000011, "تمرين بايسبس بالدامبل 7", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000012, "تمرين بايسبس بالكابل 1", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000013, "تمرين بايسبس بالكابل 2", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000014, "تمرين بايسبس بالكابل 3", __BAYCEPSGUIDS));
        baycepsList.add(new Guide(R.drawable.img000000015, "تمرين بايسبس بالكابل 4", __BAYCEPSGUIDS));
        return baycepsList;
    }

    public static List<Guide> ForearmsList() {
        List<Guide> forearmsList = new ArrayList<>();
        forearmsList.add(new Guide(R.drawable.img000000001, "تمرين سواعد بالبار جالس", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000002, "تمرين سواعد بالبار 1", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000003, "تمرين سواعد بالبار 2", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000004, "تمرين سواعد بالكابل", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000005, "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000006, "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000007, "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000008, "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img000000009, "تمرين سواعد بالبار", __FOREAMRMSGUIDS));
        forearmsList.add(new Guide(R.drawable.img0000000010, "تمرين سواعد", __FOREAMRMSGUIDS));
        return forearmsList;
    }

    public static List<Guide> LegList() {
        List<Guide> legList = new ArrayList<>();
        legList.add(new Guide(R.drawable.img00001, "تمرين احماء عضلة الرجل", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00002, "تمرين السكوات بالبار خلفي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00003, "تمرين السكوات بالبار امامي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00004, "تمرين سكوات بالبار امامي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00005, "تمرين المشي بالدامبل", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00006, "تمرين المشي بالبار", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00007, "تمرين الدرج بالدامبل", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00008, "تمرين مرجحة رجل امامي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img00009, "تمرين ضغط الرجلين", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000010, "تمرين السكوات سميث خلفي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000011, "مرجحة رجل خلفي بالدامبل", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000012, "تمرين مرجحة رجل خلفي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000013, "تمرين مرجحة رجل خلفي", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000014, "تمرين ضغط سمانة بالدامبل", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000015, "تمرين سمانة بالجهاز", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000016, "ضغط سمانة في الجهاز", __LEGSGUIDS));
        legList.add(new Guide(R.drawable.img000017, "ضغط سمانة في الجهاز", __LEGSGUIDS));
        return legList;
    }

    public static List<Guide> ShoulderList() {
        List<Guide> shoulderList = new ArrayList<>();
        shoulderList.add(new Guide(R.drawable.img001, "تمرين الكتف بالبار أمامي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img002, "تمرين الكتف بالبار خلفي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img003, "تمرين الكتف بالدامبل أمامي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img004, "تمرين أرنولد بريس", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img005, "تمرين أرنولد بريس مطرقة", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img006, "رفع أمامي دامبل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img007, "رفع أمامي كابل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img008, "رفع أمامي بالدامبل مطرقة", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img009, "رفع أمامي بالوزن", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0010, "تمرين رفرفة بالكابل خلفي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0011, "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0012, "تمرين سحب بالبار علوي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0013, "تمرين سحب خلفي بالكابل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0014, "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0015, "تمرين ارجاع خلفي بالبار", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0016, "تمرين رفرفة بالدامبل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0017, "تمرين رفرفة بالدامبل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0018, "تمرين رفرفة بالدامبل جانبي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0019, "تمرين سحب افقي بالبار", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0020, "تمرين رفرفة بالبار جانبي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0021, "تمرين رفرفة بالكابل جانبي", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0022, "تمرين سحب افقي بالدامبل", __SHOULDERSGUIDS));
        shoulderList.add(new Guide(R.drawable.img0023, "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS));
        return shoulderList;
    }

    public static List<Guide> StomachList() {
        List<Guide> stomachList = new ArrayList<>();
        stomachList.add(new Guide(R.drawable.img0000001, "تمرين معدة وسطى 1", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000002, "تمرين معدة وسطى 2", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000003, "تمرين معدة وسطى بالجهاز", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000004, "تمرين معدة وسطى بالكابل", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000005, "تمرين معدة وسطى 3", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000006, "تمرين معدة وسطى دحرجة", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000007, "تمرين معدة جانبية 1", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000008, "تمرين معدة جانبية بالدامبل", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img0000009, "تمرين معدة جانبية بالبار", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img00000010, "تمرين معدة جانبية 2", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img00000011, "تمرين معدة جانبية 3", __STOMACHGUIDS));
        stomachList.add(new Guide(R.drawable.img00000012, "تمرين معدة جانبية 4", __STOMACHGUIDS));
        return stomachList;
    }

    public static List<Guide> TricepesList() {
        List<Guide> tricepesList = new ArrayList<>();
        tricepesList.add(new Guide(R.drawable.img000001, "تمرين ترايسبس بالدامبل 1", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000002, "تمرين ترايسبس بالدامبل 2", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000003, "تمرين ترايسبس بالدامبل 3", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000004, "تمرين ترايسبس بالدامبل 4", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000005, "تمرين ترايسبس بالدامبل 5", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000006, "تمرين ترايسبس بالبار 1", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000007, "تمرين ترايسبس بالبار 2", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000008, "تمرين ترايسبس بالبار 3", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img000009, "تمرين ترايسبس بالبار 4", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000010, "تمرين ترايسبس بالبار 5", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000011, "تمرين ترايسبس بالبار 6", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000012, "تمرين ترايسبس بالكابل 1", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000013, "تمرين ترايسبس بالكابل 2", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000014, "تمرين ترايسبس بالكابل 3", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000015, "تمرين ترايسبس بالكابل 4", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000016, "تمرين ترايسبس بالبنك 1", __TRICEPSGUIDS));
        tricepesList.add(new Guide(R.drawable.img0000017, "تمرين ترايسبس بالبنك 2", __TRICEPSGUIDS));
        return tricepesList;
    }

    public static Map<String, Object> _showDialog(Activity activity, int layout) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(false);
        View itemView = LayoutInflater.from(activity).inflate(layout, null);
        builder.setView(itemView);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        Map<String, Object> map = new HashMap<>();
        map.put(__VIEW, itemView);
        map.put(__BOTTOMSHEETDIALOG, dialog);
        return map;
    }
}

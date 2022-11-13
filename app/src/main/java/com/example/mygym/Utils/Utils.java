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


    public static final String __INTENTCOLLECTION = "collectionParent";
    public static final String __INTENTDAY = "dayParent";
    public static final String __INTENTGUIDE = "guide";


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
    public static String _DATA = "data";

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
        chestList.add(new Guide("img01", "تمرين الصدر بالبار سفلي", __CHESTGUIDS, false));
        chestList.add(new Guide("img02", "تمرين الصدر بالبار علوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img03", "تمرين الصدر بالبار مستوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img04", "تمرين الصدر بالدامبل سفلي", __CHESTGUIDS, false));
        chestList.add(new Guide("img05", "تمرين الصدر بالدامبل علوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img06", "تمرين الصدر بالدامبل مستوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img07", "تمرين الرفرفة بالدامبل سفلي", __CHESTGUIDS, false));
        chestList.add(new Guide("img08", "تمرين الرفرفة بالدامبل علوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img09", "تمرين الرفرفة بالدامبل مستوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img010", "تمرين الصدر بالكابل سفلي", __CHESTGUIDS, false));
        chestList.add(new Guide("img011", "تمرين الصدر بالكابل علوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img012", "تمرين الصدر بالكابل مستوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img013", "تمرين الصدر بالكابل متوسط", __CHESTGUIDS, false));
        chestList.add(new Guide("img014", "تمرين الصدر بجهاز الفراشة", __CHESTGUIDS, false));
        chestList.add(new Guide("img015", "تمرين هامر بالدامبل سفلي", __CHESTGUIDS, false));
        chestList.add(new Guide("img016", "تمرين الغطس المتوازي", __CHESTGUIDS, false));
        chestList.add(new Guide("img017", "تمرين SVEND PRESS", __CHESTGUIDS, false));
        chestList.add(new Guide("img018", "تمرين الصدر بالة الضغط مستوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img020", "تمرين الصدر بالة الضغط علوي", __CHESTGUIDS, false));
        chestList.add(new Guide("img021", "تمرين الصدر بالة الضغط سفي", __CHESTGUIDS, false));
        chestList.add(new Guide("img019", "تمرين PULL OVER", __CHESTGUIDS, false));
        return chestList;
    }

    public static List<Guide> Back() {
        List<Guide> backList = new ArrayList<>();
        backList.add(new Guide("img0001", "سحب خلفي واسع", __BACKGUIDS, false));
        backList.add(new Guide("img0002", "سحب امامي ضيق", __BACKGUIDS, false));
        backList.add(new Guide("img0003", "سحب امامي ضيق عكسي", __BACKGUIDS, false));
        backList.add(new Guide("img0004", "سحب امامي ضيق V", __BACKGUIDS, false));
        backList.add(new Guide("img0005", "تمرين سحب كابل V", __BACKGUIDS, false));
        backList.add(new Guide("img0006", "سحب امامي كابل واسع", __BACKGUIDS, false));
        backList.add(new Guide("img0007", "تمرين سحب بار", __BACKGUIDS, false));
        backList.add(new Guide("img0008", "سحب بار قبضة معكوسة", __BACKGUIDS, false));
        backList.add(new Guide("img0009", "ديدليفت", __BACKGUIDS, false));
        backList.add(new Guide("img00010", "تمرين الحصان", __BACKGUIDS, false));
        backList.add(new Guide("img00011", "تمرين جذب البار", __BACKGUIDS, false));
        backList.add(new Guide("img00012", "تمرين سحب ضيق بالجهاز", __BACKGUIDS, false));
        backList.add(new Guide("img00022", "تمرين سحب واسع بالجهاز", __BACKGUIDS, false));
        backList.add(new Guide("img00013", "سحب افقي بالكابل", __BACKGUIDS, false));
        backList.add(new Guide("img00014", "سحب متوسط بالكابل", __BACKGUIDS, false));
        backList.add(new Guide("img00015", "تمرين سحب بالدامبل فردي", __BACKGUIDS, false));
        backList.add(new Guide("img00016", "تمرين سحب الدامبل زوجي", __BACKGUIDS, false));
        backList.add(new Guide("img00017", "دامبل بول اوفر", __BACKGUIDS, false));
        backList.add(new Guide("img00018", "تمرين العقلة واسع", __BACKGUIDS, false));
        backList.add(new Guide("img00019", "تمرين العقلة ضيق", __BACKGUIDS, false));
        backList.add(new Guide("img00020", "سحب متوسط بالكابل", __BACKGUIDS, false));
        backList.add(new Guide("img00021", "سحب بالبار معكوس", __BACKGUIDS, false));
        return backList;
    }

    public static List<Guide> BaycepsList() {
        List<Guide> baycepsList = new ArrayList<>();
        baycepsList.add(new Guide("img00000001", "تمرين بايسبس بالبار 1", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000002", "تمرين بايسبس بالبار 2", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000003", "تمرين بايسبس بالبار 3", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000004", "تمرين بايسبس بالبار 4", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000005", "تمرين بايسبس بالدامبل 1", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000006", "تمرين بايسبس بالدامبل 2", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000007", "تمرين بايسبس بالدامبل 3", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000008", "تمرين بايسبس بالدامبل 4", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img00000009", "تمرين بايسبس بالدامبل 5", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000010", "تمرين بايسبس بالدامبل 6", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000011", "تمرين بايسبس بالدامبل 7", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000012", "تمرين بايسبس بالكابل 1", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000013", "تمرين بايسبس بالكابل 2", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000014", "تمرين بايسبس بالكابل 3", __BAYCEPSGUIDS, false));
        baycepsList.add(new Guide("img000000015", "تمرين بايسبس بالكابل 4", __BAYCEPSGUIDS, false));
        return baycepsList;
    }

    public static List<Guide> ForearmsList() {
        List<Guide> forearmsList = new ArrayList<>();
        forearmsList.add(new Guide("img000000001", "تمرين سواعد بالبار جالس", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000002", "تمرين سواعد بالبار 1", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000003", "تمرين سواعد بالبار 2", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000004", "تمرين سواعد بالكابل", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000005", "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000006", "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000007", "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000008", "تمرين سواعد بالدامبل", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img000000009", "تمرين سواعد بالبار", __FOREAMRMSGUIDS, false));
        forearmsList.add(new Guide("img0000000010", "تمرين سواعد", __FOREAMRMSGUIDS, false));
        return forearmsList;
    }

    public static List<Guide> LegList() {
        List<Guide> legList = new ArrayList<>();
        legList.add(new Guide("img00001", "تمرين احماء عضلة الرجل", __LEGSGUIDS, false));
        legList.add(new Guide("img00002", "تمرين السكوات بالبار خلفي", __LEGSGUIDS, false));
        legList.add(new Guide("img00003", "تمرين السكوات بالبار امامي", __LEGSGUIDS, false));
        legList.add(new Guide("img00004", "تمرين سكوات بالبار امامي", __LEGSGUIDS, false));
        legList.add(new Guide("img00005", "تمرين المشي بالدامبل", __LEGSGUIDS, false));
        legList.add(new Guide("img00006", "تمرين المشي بالبار", __LEGSGUIDS, false));
        legList.add(new Guide("img00007", "تمرين الدرج بالدامبل", __LEGSGUIDS, false));
        legList.add(new Guide("img00008", "تمرين مرجحة رجل امامي", __LEGSGUIDS, false));
        legList.add(new Guide("img00009", "تمرين ضغط الرجلين", __LEGSGUIDS, false));
        legList.add(new Guide("img000010", "تمرين السكوات سميث خلفي", __LEGSGUIDS, false));
        legList.add(new Guide("img000011", "مرجحة رجل خلفي بالدامبل", __LEGSGUIDS, false));
        legList.add(new Guide("img000012", "تمرين مرجحة رجل خلفي", __LEGSGUIDS, false));
        legList.add(new Guide("img000013", "تمرين مرجحة رجل خلفي", __LEGSGUIDS, false));
        legList.add(new Guide("img000014", "تمرين ضغط سمانة بالدامبل", __LEGSGUIDS, false));
        legList.add(new Guide("img000015", "تمرين سمانة بالجهاز", __LEGSGUIDS, false));
        legList.add(new Guide("img000016", "ضغط سمانة في الجهاز", __LEGSGUIDS, false));
        legList.add(new Guide("img000017", "ضغط سمانة في الجهاز", __LEGSGUIDS, false));
        return legList;
    }

    public static List<Guide> ShoulderList() {
        List<Guide> shoulderList = new ArrayList<>();
        shoulderList.add(new Guide("img001", "تمرين الكتف بالبار أمامي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img002", "تمرين الكتف بالبار خلفي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img003", "تمرين الكتف بالدامبل أمامي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img004", "تمرين أرنولد بريس", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img005", "تمرين أرنولد بريس مطرقة", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img006", "رفع أمامي دامبل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img007", "رفع أمامي كابل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img008", "رفع أمامي بالدامبل مطرقة", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img009", "رفع أمامي بالوزن", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0010", "تمرين رفرفة بالكابل خلفي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0011", "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0012", "تمرين سحب بالبار علوي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0013", "تمرين سحب خلفي بالكابل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0014", "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0015", "تمرين ارجاع خلفي بالبار", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0016", "تمرين رفرفة بالدامبل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0017", "تمرين رفرفة بالدامبل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0018", "تمرين رفرفة بالدامبل جانبي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0019", "تمرين سحب افقي بالبار", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0020", "تمرين رفرفة بالبار جانبي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0021", "تمرين رفرفة بالكابل جانبي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0022", "تمرين سحب افقي بالدامبل", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0023", "تمرين رفرفة بالدامبل خلفي", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0024", "تمرين ترابيس بالبار", __SHOULDERSGUIDS, false));
        shoulderList.add(new Guide("img0025", "تمرين ترابيس بالدامبل", __SHOULDERSGUIDS, false));

        return shoulderList;
    }

    public static List<Guide> StomachList() {
        List<Guide> stomachList = new ArrayList<>();
        stomachList.add(new Guide("img0000001", "تمرين معدة وسطى 1", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000002", "تمرين معدة وسطى 2", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000003", "تمرين معدة وسطى بالجهاز", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000004", "تمرين معدة وسطى بالكابل", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000005", "تمرين معدة وسطى 3", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000006", "تمرين معدة وسطى دحرجة", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000007", "تمرين معدة جانبية 1", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000008", "تمرين معدة جانبية بالدامبل", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img0000009", "تمرين معدة جانبية بالبار", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img00000010", "تمرين معدة جانبية 2", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img00000011", "تمرين معدة جانبية 3", __STOMACHGUIDS, false));
        stomachList.add(new Guide("img00000012", "تمرين معدة جانبية 4", __STOMACHGUIDS, false));
        return stomachList;
    }

    public static List<Guide> TricepesList() {
        List<Guide> tricepesList = new ArrayList<>();
        tricepesList.add(new Guide("img000001", "تمرين ترايسبس بالدامبل 1", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000002", "تمرين ترايسبس بالدامبل 2", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000003", "تمرين ترايسبس بالدامبل 3", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000004", "تمرين ترايسبس بالدامبل 4", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000005", "تمرين ترايسبس بالدامبل 5", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000006", "تمرين ترايسبس بالبار 1", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000007", "تمرين ترايسبس بالبار 2", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000008", "تمرين ترايسبس بالبار 3", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img000009", "تمرين ترايسبس بالبار 4", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000010", "تمرين ترايسبس بالبار 5", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000011", "تمرين ترايسبس بالبار 6", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000012", "تمرين ترايسبس بالكابل 1", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000013", "تمرين ترايسبس بالكابل 2", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000014", "تمرين ترايسبس بالكابل 3", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000015", "تمرين ترايسبس بالكابل 4", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000016", "تمرين ترايسبس بالبنك 1", __TRICEPSGUIDS, false));
        tricepesList.add(new Guide("img0000017", "تمرين ترايسبس بالبنك 2", __TRICEPSGUIDS, false));
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

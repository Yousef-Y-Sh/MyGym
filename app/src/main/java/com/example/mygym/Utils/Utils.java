package com.example.mygym.Utils;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {
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

    public static void _HideKeyboard(Activity activity, View v) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }
}

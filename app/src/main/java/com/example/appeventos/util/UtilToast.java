package com.example.appeventos.util;

import android.content.Context;
import android.widget.Toast;

public class UtilToast {

    public static void showToast(Context context, String msg, int duracao) {
        Toast.makeText(context, msg, duracao).show();
    }

    public static void alertaCurto(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_SHORT);
    }

    public static void alertaLong(Context context, String msg) {
        showToast(context, msg, Toast.LENGTH_LONG);
    }
}

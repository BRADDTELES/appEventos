package com.example.appeventos.persistencia;

import android.content.Context;

import com.example.appeventos.ENUM.DEFAULT_VALUES;
import com.example.appeventos.ENUM.SHARED_PREFERENCES;
import com.example.appeventos.util.UtilSharedPreferences;

public class Persistencia {
    public static void setUsuario(Context context, String usuario) {
        UtilSharedPreferences.setString(context, SHARED_PREFERENCES.USUARIO_KEY.key, usuario);
    }

    public static String getUsuario(Context context) {
        return UtilSharedPreferences.getString(context, SHARED_PREFERENCES.USUARIO_KEY.key, DEFAULT_VALUES.USUARIO_DEFAULT_VALUE.value);
    }

    public static void setSenha(Context context, String senha) {
        UtilSharedPreferences.setString(context, SHARED_PREFERENCES.SENHA_KEY.key, senha);
    }

    public static String getSenha(Context context) {
        return UtilSharedPreferences.getString(context, SHARED_PREFERENCES.SENHA_KEY.key, DEFAULT_VALUES.SENHA_DEFAULT_VALUE.value);
    }
}

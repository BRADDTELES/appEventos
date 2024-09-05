package com.example.appeventos.util;

import java.util.Calendar;

public class UtilTime {

    public static int getHoraAtual() {
        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        return hora;
    }

    public static int getMinutoAtual() {
        Calendar calendar = Calendar.getInstance();
        int minuto = calendar.get(Calendar.MINUTE);
        return minuto;
    }

    public static int getSegundoAtual() {
        Calendar calendar = Calendar.getInstance();
        int segundo = calendar.get(Calendar.SECOND);
        return segundo;
    }
}

package com.example.appeventos.util;

import java.util.Calendar;

public class UtilDate {

    public int getAnoAtual(){
        Calendar calendar = Calendar.getInstance();
        int ano = calendar.get(Calendar.YEAR);
        return ano;
    }

    public int getMesAtual() {
        Calendar calendar = Calendar.getInstance();
        int mes = calendar.get(Calendar.MONTH);
        return mes;
    }

    public int getDiaAtual() {
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        return dia;
    }
}

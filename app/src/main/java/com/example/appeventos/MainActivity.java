package com.example.appeventos;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appeventos.util.UtilDate;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    TextView dataEscolhidaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEditText);
        dataEscolhidaTextView = findViewById(R.id.dataEscolhidaTextView);
    }

    public void escolherDataButtonAction(View view) {

        UtilDate utilDate = new UtilDate();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month++;
                dataEscolhidaTextView.setText("" + dayOfMonth + "/" + month + "/" + year);
            }
        }, utilDate.getAnoAtual(), utilDate.getMesAtual(), utilDate.getDiaAtual());
        datePickerDialog.show();
    }
}
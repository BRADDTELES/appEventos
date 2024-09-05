package com.example.appeventos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appeventos.util.UtilDate;
import com.example.appeventos.util.UtilTime;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    TextView dataEscolhidaTextView;
    TextView horaSelecionadaTextView;
    Button selecionarHoraButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEditText);
        dataEscolhidaTextView = findViewById(R.id.dataEscolhidaTextView);

        horaSelecionadaTextView = findViewById(R.id.horaSelecionadaTextView);
        selecionarHoraButton = findViewById(R.id.selecionarHoraButton);
//        horaSelecionadaTextView.setText("Hora selecionada: Nenhuma");
//        selecionarHoraButton.setText("Selecionar hora inicial");
    }

    public void escolherDataButtonAction(View view){

        UtilDate utilDate = new UtilDate();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month++;
                dataEscolhidaTextView.setText("" + dayOfMonth + "/" + month + "/" + year);
            }
        }, utilDate.getAnoAtual(), utilDate.getMesAtual(), utilDate.getDiaAtual() );
        datePickerDialog.show();
    }

    public void escolherHoraInicialButtonAction(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                horaSelecionadaTextView.setText("" + hourOfDay + ":" + minute);
            }
        }, UtilTime.getHoraAtual(), UtilTime.getMinutoAtual(), true);
        timePickerDialog.show();
    }

    public void escolherHoraFinalButtonAction(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                horaSelecionadaTextView.setText("" + hourOfDay + ":" + minute);
            }
        }, UtilTime.getHoraAtual(), UtilTime.getMinutoAtual(), true);
        timePickerDialog.show();
    }
}
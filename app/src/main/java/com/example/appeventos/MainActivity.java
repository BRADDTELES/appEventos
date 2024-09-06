package com.example.appeventos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appeventos.util.UtilDate;
import com.example.appeventos.util.UtilTime;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    TextView dataEscolhidaTextView;
    TextView horaInicialSelecionadaTextView;
    TextView horaFinalSelecionadaTextView;
    Button selecionarHoraInicialButton;
    Button selecionarHoraFinalButton;
    TextView numeracaoNivelTextView;
    SeekBar numeracaoNivelSeekBar;
    TextView convidadoTextView;
    NumberPicker convidadoNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeEditText = findViewById(R.id.nomeEditText);
        dataEscolhidaTextView = findViewById(R.id.dataEscolhidaTextView);

        horaInicialSelecionadaTextView = findViewById(R.id.horaInicialSelecionadaTextView);
        selecionarHoraInicialButton = findViewById(R.id.selecionarHoraInicialButton);
        horaFinalSelecionadaTextView = findViewById(R.id.horaFinalSelecionadaTextView);
        selecionarHoraFinalButton = findViewById(R.id.selecionarHoraFinalButton);

        numeracaoNivelTextView = findViewById(R.id.numeracaoNivelTextView);
        numeracaoNivelSeekBar = findViewById(R.id.numeracaoNivelSeekBar);

        numeracaoNivelSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String nivelFormatado;
                if (progress < 10) {
                    nivelFormatado = "00" + progress;
                } else {
                    if (progress > 99) {
                        nivelFormatado = "" + progress;
                    } else {
                        nivelFormatado = "0" + progress;
                    }
                }
                numeracaoNivelTextView.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        convidadoTextView = findViewById(R.id.convidadoTextView);
        convidadoNumberPicker = findViewById(R.id.convidadoNumberPicker);

        convidadoNumberPicker.setMinValue(0);
        convidadoNumberPicker.setMaxValue(500);

        convidadoNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
                convidadoTextView.setText("Número de convidados: \n" + newVal);
            }
        });
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
                horaInicialSelecionadaTextView.setText("" + hourOfDay + ":" + minute);
            }
        }, UtilTime.getHoraAtual(), UtilTime.getMinutoAtual(), true);
        timePickerDialog.show();
    }

    public void escolherHoraFinalButtonAction(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                horaFinalSelecionadaTextView.setText("" + hourOfDay + ":" + minute);
            }
        }, UtilTime.getHoraAtual(), UtilTime.getMinutoAtual(), true);
        timePickerDialog.show();
    }

}
package com.example.appeventos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appeventos.persistencia.Persistencia;
import com.example.appeventos.util.UtilDate;
import com.example.appeventos.util.UtilTime;
import com.example.appeventos.util.UtilToast;

public class MainActivity extends AppCompatActivity {

    EditText nomeEditText;
    TextView dataEscolhidaTextView;
    TextView horaInicialSelecionadaTextView;
    TextView horaFinalSelecionadaTextView;
    Button selecionarHoraInicialButton;
    Button selecionarHoraFinalButton;
    TextView numeracaoNivelTextView;
    SeekBar numeracaoNivelSeekBar;

    String [] eventos = new String[3];
    TextView eventoTextView;
    ImageView eventoImageView;
    NumberPicker eventoNumberPicker;

    TextView convidadoTextView;
    NumberPicker convidadoNumberPicker;

    TextView confirmacaoTextView;
    CheckBox confirmacaoCheckBox;

    Switch lembreteSwitch;

    RadioGroup tipoEventoRadioGroup;
    TextView tpEventoSelecionadoTextView;

    EditText usuarioEditText;
    EditText senhaEditText;

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

//        eventoTextView = findViewById(R.id.eventoTextView);
        eventoImageView = findViewById(R.id.eventoImageView);
        eventoNumberPicker = findViewById(R.id.eventoNumberPicker);

        eventos[0] = "Pessoal";
        eventos[1] = "Corporativo";
        eventos[2] = "Festivo";

        eventoNumberPicker.setDisplayedValues(eventos);

        eventoNumberPicker.setMinValue(0);
        eventoNumberPicker.setMaxValue(2);

        eventoNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String eventoSelecionado = eventos[newVal];
                if (eventoSelecionado.equalsIgnoreCase("Festivo")){
                    eventoImageView.setImageResource(R.drawable.pessoal);
//                    eventoTextView.setText("Pessoal");
                } else {
                    if (eventoSelecionado.equalsIgnoreCase("Corporativo")){
                        eventoImageView.setImageResource(R.drawable.corporativo);
//                        eventoTextView.setText("Corporativo");
                    } else {
                        eventoImageView.setImageResource(R.drawable.festivo);
//                        eventoTextView.setText("Festivo");
                    }
                }
            }
        });

        confirmacaoTextView = findViewById(R.id.confirmacaoTextView);
        confirmacaoCheckBox = findViewById(R.id.confirmacaoCheckBox);

        confirmacaoCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    confirmacaoTextView.setText("Confirmação de Evento: Confirmado");
                } else {
                    confirmacaoTextView.setText("Confirmação de Evento: Nenhuma");
                }
            }
        });

        lembreteSwitch = findViewById(R.id.lembreteSwitch);
        lembreteSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    lembreteSwitch.setText(R.string.label_ligado);
                } else {
                    lembreteSwitch.setText(R.string.label_desligado);
                }
            }
        });

        tipoEventoRadioGroup = findViewById(R.id.tipoEventoRadioGroup);
        tpEventoSelecionadoTextView = findViewById(R.id.tpEventoSelecionadoTextView);

        tipoEventoRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                String opcaoSelecionada = radioButton.getText().toString();
                tpEventoSelecionadoTextView.setText(opcaoSelecionada);
            }
        });

        usuarioEditText = findViewById(R.id.usuarioEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
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

    public void salvarButtonAction(View view) {
        String usuario = usuarioEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        Persistencia.setUsuario(this, usuario);
        Persistencia.setSenha(this, senha);
        UtilToast.alertaLong(this, "Registro Salvo com sucesso!!! ");
    }

    public void carregarButtonAction(View view) {
        String usuario = Persistencia.getUsuario(this);
        String senha = Persistencia.getSenha(this);
        usuarioEditText.setText(usuario);
        senhaEditText.setText(senha);
    }

}

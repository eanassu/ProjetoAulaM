package br.fmu.projetoaulam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText editTextValor;
    private SeekBar seekBar;
    private TextView textViewPct;
    private TextView textViewGorjeta;
    private TextView textViewTotal;

    private double valor;
    private double porcentagem = 0;
    private double gorjeta = 0;
    private double total;

    private static final NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat =
            NumberFormat.getPercentInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        editTextValor = findViewById(R.id.editTextValor);
        seekBar = findViewById(R.id.seekBar);
        textViewPct = findViewById(R.id.textViewPct);
        textViewGorjeta = findViewById(R.id.textViewGorjeta);
        textViewTotal = findViewById(R.id.textViewTotal);
        textViewPct.setText(percentFormat.format(porcentagem));
        editTextValor.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    valor = Double.parseDouble(editTextValor.getText().toString());
                } catch( NumberFormatException e ) {
                    valor = 0;
                }
                recalcular();
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                porcentagem = i/100.0;
                textViewPct.setText(percentFormat.format(porcentagem));
                recalcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void recalcular() {
        gorjeta = valor * porcentagem;
        total = valor + gorjeta;
        textViewGorjeta.setText(currencyFormat.format(gorjeta));
        textViewTotal.setText(currencyFormat.format(total));
    }
}
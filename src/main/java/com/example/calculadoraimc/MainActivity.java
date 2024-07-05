package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etPeso, etAltura;
    private Button btnCalcular;
    private TextView tvResultado;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        String strPeso = etPeso.getText().toString();
        String strAltura = etAltura.getText().toString();

        if (strPeso.isEmpty() || strAltura.isEmpty()) {
            tvResultado.setText("Por favor ingrese su peso y altura.");
            return;
        }

        float peso = Float.parseFloat(strPeso);
        float altura = Float.parseFloat(strAltura);

        float imc = peso / (altura * altura);
        String clasificacion = clasificarIMC(imc);

        String resultado = String.format("IMC: %.2f - %s", imc, clasificacion);
        tvResultado.setText(resultado);
    }

    private String clasificarIMC(float imc) {
        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }
}
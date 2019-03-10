package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class ParametrosPesoActivity extends AppCompatActivity {
    private Button btnVoltarPrinpal;
    private Button btnHistParaPressao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_peso);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(ParametrosPesoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnHistParaPressao = (Button) findViewById(R.id.btnHistParaPressao);
        btnHistParaPressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisPara= new Intent(ParametrosPesoActivity.this, HistoricoParametroPesoActivity.class);
                startActivity(intentIrHisPara);
            }
        });
    }
}

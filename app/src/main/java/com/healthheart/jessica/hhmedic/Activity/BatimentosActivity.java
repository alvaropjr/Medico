package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class BatimentosActivity extends AppCompatActivity {
    private Button btnVoltarPrinpal;
    private Button btnAddInfoBatimentos;
    private Button btnAddParametrosBati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batimentos);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(BatimentosActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoBatimentos = (Button) findViewById(R.id.btnAddInfoBatimentos);
        btnAddInfoBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoBat = new Intent(BatimentosActivity.this, AddInfoBatimentosActivity.class);
                startActivity(intentAbriAddInfoBat);
            }
        });

        btnAddParametrosBati  = (Button) findViewById(R.id.btnAddParametrosBati);
        btnAddParametrosBati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddParamBat = new Intent(BatimentosActivity.this, ParametrosBatimentosActivity.class);
                startActivity(intentAbriAddParamBat);
            }
        });
    }
}

package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class PesoActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private Button btnAddParametrosPeso;
    private Button btnAddInfoPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso);



       //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(PesoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoPeso = (Button) findViewById(R.id.btnAddInfoPeso);
        btnAddInfoPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoBat = new Intent(PesoActivity.this, AddInfoPesoActivity.class);
                startActivity(intentAbriAddInfoBat);
            }
        });

        btnAddParametrosPeso  = (Button) findViewById(R.id.btnAddParametrosPeso);
        btnAddParametrosPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddParamBat = new Intent(PesoActivity.this, ParametrosPesoActivity.class);
                startActivity(intentAbriAddParamBat);
            }
        });
    }
}

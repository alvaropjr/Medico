package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class GlicoseActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private Button btnAddInfoGlico;
    private Button btnAddParametrosGlico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glicose);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(GlicoseActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoGlico = (Button) findViewById(R.id.btnAddInfoGlico);
        btnAddInfoGlico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoBat = new Intent(GlicoseActivity.this, AddInfoGlicoseActivity.class);
                startActivity(intentAbriAddInfoBat);
            }
        });

        btnAddParametrosGlico  = (Button) findViewById(R.id.btnAddParametrosGlico);
        btnAddParametrosGlico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddParamBat = new Intent(GlicoseActivity.this, ParametrosGlicoseActivity.class);
                startActivity(intentAbriAddParamBat);
            }
        });


    }
}

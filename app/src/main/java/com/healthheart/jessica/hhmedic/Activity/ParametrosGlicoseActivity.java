package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class ParametrosGlicoseActivity extends AppCompatActivity {


    private Button btnVoltarPrinpal;
    private Button btnHistParaGlicose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_glicose);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(ParametrosGlicoseActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnHistParaGlicose = (Button) findViewById(R.id.btnHistParaGlicose);
        btnHistParaGlicose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfOxi = new Intent(ParametrosGlicoseActivity.this, HistoricoParametroGlicoseActivity.class);
                startActivity(intentIrHisInfOxi);
            }
        });

    }
}

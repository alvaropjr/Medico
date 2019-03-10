package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class ParametrosOxigenacaoActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private Button btnHistParaOxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_oxigenacao);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(ParametrosOxigenacaoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnHistParaOxi = (Button) findViewById(R.id.btnHistParaOxi);
        btnHistParaOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfOxi = new Intent(ParametrosOxigenacaoActivity.this, HistoricoOxigenacaoActivity.class);
                startActivity(intentIrHisInfOxi);
            }
        });

    }
}

package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class HistoricoOxigenacaoActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private Button btnAddInfoOxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_oxigenacao);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(HistoricoOxigenacaoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoOxi = (Button) findViewById(R.id.btnAddInfoOxi);
        btnAddInfoOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfOxi = new Intent(HistoricoOxigenacaoActivity.this, ParametrosOxigenacaoActivity.class);
                startActivity(intentIrHisInfOxi);
            }
        });

    }
}

package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.healthheart.jessica.hhmedic.R;

public class PrincipalActivity extends AppCompatActivity {
    private ImageButton imgbntBatimento;
    private ImageButton imgbntOxigenacao;
    private ImageButton imgbtnPressao;
    private ImageButton imgbtnGlicose;
    private ImageButton imgbtnPeso;
    private ImageButton imgbtnSaude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        imgbntBatimento = (ImageButton) findViewById(R.id.imgbntBatimento);

        imgbntBatimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaBatimento = new Intent(PrincipalActivity.this, BatimentosActivity.class);
                startActivity(intentAbrieTelaBatimento);
            }
        });


        //recupera a imgageButton abrir oxigenação
        imgbntOxigenacao = (ImageButton) findViewById(R.id.imgbntOxigenacao);

        imgbntOxigenacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaOxigenacao = new Intent(PrincipalActivity.this, OxigenacaoActivity.class);
                startActivity(intentAbrieTelaOxigenacao);
            }
        });

        //recupera a imgageButton abrir pressao
        imgbtnPressao = (ImageButton) findViewById(R.id.imgbtnPressao);

        imgbtnPressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaPressao = new Intent(PrincipalActivity.this, PressaoActivity.class);
                startActivity(intentAbrieTelaPressao);
            }
        });

        imgbtnGlicose = (ImageButton) findViewById(R.id.imgbtnGlicose);

        imgbtnGlicose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaGlicose = new Intent(PrincipalActivity.this, GlicoseActivity.class);
                startActivity(intentAbrieTelaGlicose);
            }
        });

        imgbtnPeso = (ImageButton) findViewById(R.id.imgbtnPeso);

        imgbtnPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaPeso = new Intent(PrincipalActivity.this, PesoActivity.class);
                startActivity(intentAbrieTelaPeso);
            }
        });


        //recupera a imgageButton abrir pressao
        imgbtnSaude = (ImageButton) findViewById(R.id.imgbtnSaude);

        imgbtnSaude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrieTelaPressao = new Intent(PrincipalActivity.this, SaudeActivity.class);
                startActivity(intentAbrieTelaPressao);
            }
        });
    }
}

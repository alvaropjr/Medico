package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.healthheart.jessica.hhmedic.R;

public class SaudeActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private ImageButton imgbntMedicamento;
    private ImageButton imgbntHisDoencaCardi;
    private ImageButton imgbntVicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(SaudeActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        imgbntMedicamento  = (ImageButton) findViewById(R.id.imgbntMedicamento);
        imgbntMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoOxi = new Intent(SaudeActivity.this, AddInfoMedicamentoActivity.class);
                startActivity(intentAbriAddInfoOxi);
            }
        });


        imgbntHisDoencaCardi  = (ImageButton) findViewById(R.id.imgbntHisDoencaCardi);
        imgbntHisDoencaCardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoOxi = new Intent(SaudeActivity.this, AddInfoDoencasCardiActivity.class);
                startActivity(intentAbriAddInfoOxi);
            }
        });


    }
}

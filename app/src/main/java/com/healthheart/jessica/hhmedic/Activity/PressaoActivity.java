package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class PressaoActivity extends AppCompatActivity {

    private Button btnVoltarPrinpal;
    private Button btnAddInfoPressao;
    private Button btnAddParaPressao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressao);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(PressaoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });


        btnAddInfoPressao = (Button) findViewById(R.id.btnAddInfoPressao);
        btnAddInfoPressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddInfo = new Intent(PressaoActivity.this, AddInfoPressaoActivity.class);
                startActivity(intentAddInfo);
            }
        });


        btnAddParaPressao = (Button) findViewById(R.id.btnAddParaPressao);
        btnAddParaPressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddInfo = new Intent(PressaoActivity.this, ParametrosPressaoActivity.class);
                startActivity(intentAddInfo);
            }
        });




    }
}

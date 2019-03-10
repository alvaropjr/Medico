package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class HistoricoInfoPesoActivity extends AppCompatActivity {
    private Button btnAddInfoPeso;
    private Button btnVoltarPrinpal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_info_peso);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(HistoricoInfoPesoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });



        btnAddInfoPeso = (Button) findViewById(R.id.btnAddInfoPeso);
        btnAddInfoPeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddInf = new Intent(HistoricoInfoPesoActivity.this, AddInfoPesoActivity.class);
                startActivity(intentAddInf);
            }
        });
    }
}

package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class AddInfoGlicoseActivity extends AppCompatActivity {

    private Button btnHistInfoGlicose;
    private Button btnVoltarPrinpal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_glicose);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(AddInfoGlicoseActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });



        btnHistInfoGlicose = (Button) findViewById(R.id.btnHistInfoGlicose);
        btnHistInfoGlicose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistInf = new Intent(AddInfoGlicoseActivity.this, HistoricoInfoGlicoseActivity.class);
                startActivity(intentHistInf);
            }
        });


    }
}

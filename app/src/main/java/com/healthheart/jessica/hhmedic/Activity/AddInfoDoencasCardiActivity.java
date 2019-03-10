package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class AddInfoDoencasCardiActivity extends AppCompatActivity {

    private Button btnHistInfoDoencaCardi;
    private Button btnVoltarPrinpal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_doencas_cardi);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(AddInfoDoencasCardiActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });



        btnHistInfoDoencaCardi = (Button) findViewById(R.id.btnHistInfoDoencaCardi);
        btnHistInfoDoencaCardi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistInf = new Intent(AddInfoDoencasCardiActivity.this, HistoricoInfoDoeCardiActivity.class);
                startActivity(intentHistInf);
            }
        });
    }
}

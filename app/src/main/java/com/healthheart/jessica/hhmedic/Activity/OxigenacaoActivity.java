package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.healthheart.jessica.hhmedic.R;

public class OxigenacaoActivity extends AppCompatActivity {
    private Button btnAddInfoOxi;
    private Button btnAddParametrosOxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxigenacao);

        btnAddInfoOxi  = (Button) findViewById(R.id.btnAddInfoOxi);
        btnAddInfoOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddInfoOxi = new Intent(OxigenacaoActivity.this, AddInfoOxigenacaoActivity.class);
                startActivity(intentAbriAddInfoOxi);
            }
        });


        btnAddParametrosOxi  = (Button) findViewById(R.id.btnAddParametrosOxi);
        btnAddParametrosOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbriAddParaOxi = new Intent(OxigenacaoActivity.this, ParametrosOxigenacaoActivity.class);
                startActivity(intentAbriAddParaOxi);
            }
        });
    }
}

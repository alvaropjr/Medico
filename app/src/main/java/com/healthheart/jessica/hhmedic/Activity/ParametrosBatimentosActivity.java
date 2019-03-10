package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;
import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.Entidades.ParametroBatimentos;
import com.healthheart.jessica.hhmedic.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParametrosBatimentosActivity extends AppCompatActivity {
    private EditText edttxBradicardiaBaixo;
    private EditText edttxBradicardiaAlta;
    private EditText edttxBatMinNormal;
    private EditText edttxBatMaxNormal;
    private EditText edttxTaquicardiaMin;
    private EditText edttxTaquicardiaMax;
    private EditText edttxDataParBat;
    private EditText edttxMotivoAltParBati;
    private Button btnSalvaParaBatimentos;
    private Button btnCancParaBatimentos;
    private Button btnVoltarPrinpal;
    private Button btnHistParaBatimentos;

    private ParametroBatimentos parametroBatimentos;

    //Objeto de conexao
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_batimentos);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(ParametrosBatimentosActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });



         btnHistParaBatimentos = (Button) findViewById(R.id.btnHistParaBatimentos);
         btnHistParaBatimentos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intentIrHistParaBat = new Intent(ParametrosBatimentosActivity.this, HistoricoParamentroBatimentosActivity.class);
                 startActivity(intentIrHistParaBat);
             }
         });

        // cancelar info
        btnCancParaBatimentos = (Button) findViewById(R.id.btnCancParaBatimentos);
        btnCancParaBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCanParameBat = new Intent(ParametrosBatimentosActivity.this, ParametrosBatimentosActivity.class);
                startActivity(intentCanParameBat);
            }
        });


        edttxBradicardiaBaixo = (EditText) findViewById(R.id.edttxBradicardiaBaixo);
        edttxBradicardiaAlta = (EditText) findViewById(R.id.edttxBradicardiaAlta);
        edttxBatMinNormal = (EditText) findViewById(R.id.edttxBatMinNormal);
        edttxBatMaxNormal = (EditText) findViewById(R.id.edttxBatMaxNormal);
        edttxTaquicardiaMin = (EditText) findViewById(R.id.edttxTaquicardiaMin);
        edttxTaquicardiaMax = (EditText) findViewById(R.id.edttxTaquicardiaMax);
         edttxDataParBat = (EditText) findViewById(R.id.edttxDataParBat);
         edttxMotivoAltParBati = (EditText) findViewById(R.id.edttxMotivoAltParBati);
         btnSalvaParaBatimentos = (Button) findViewById(R.id.btnSalvaParaBatimentos);

         //Inicializa banco
         inicializarFirebase();

         btnSalvaParaBatimentos.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if (!edttxBradicardiaBaixo.getText().toString().equals("") && !edttxBradicardiaAlta.getText().toString().equals("") && !edttxBatMinNormal.getText().toString().equals("")
                         && !edttxBatMaxNormal.getText().toString().equals("") && !edttxTaquicardiaMin.getText().toString().equals("") && !edttxTaquicardiaMax.getText().toString().equals("")){
                     parametroBatimentos = new ParametroBatimentos();
                     parametroBatimentos.setIdParaBatimentos(UUID.randomUUID().toString());
                     parametroBatimentos.setBradicardiaAlta(Double.parseDouble(edttxBradicardiaBaixo.getText().toString()));
                     parametroBatimentos.setBradicardiaBaixo(Double.parseDouble(edttxBradicardiaAlta.getText().toString()));
                     parametroBatimentos.setBatMinNormal(Double.parseDouble(edttxBatMinNormal.getText().toString()));
                     parametroBatimentos.setBatMaxNormal(Double.parseDouble(edttxBatMaxNormal.getText().toString()));
                     parametroBatimentos.setTaquicardiaMin(Double.parseDouble(edttxTaquicardiaMin.getText().toString()));
                     parametroBatimentos.setTaquicardiaMax(Double.parseDouble(edttxTaquicardiaMax.getText().toString()));
                     parametroBatimentos.setDataParaBatimentos(edttxDataParBat.getText().toString());
                     parametroBatimentos.setMotivoAltValorParBat(edttxMotivoAltParBati.getText().toString());
                     databaseReference = ConfiguracaoFirebase.getFirebase().child("ParametroBatimentos");
                     databaseReference.child(parametroBatimentos.getIdParaBatimentos()).setValue(parametroBatimentos);
                     Toast.makeText(ParametrosBatimentosActivity.this, "Informações Batimentos registrado com sucesso", Toast.LENGTH_SHORT).show();
                 }else{
                     Toast.makeText(ParametrosBatimentosActivity.this, "Preenchimento de Todos os campos são Obrigatórios", Toast.LENGTH_SHORT).show();
                 }
             }
         });


     }



    private void inicializarFirebase() {
        FirebaseApp.initializeApp(ParametrosBatimentosActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


}

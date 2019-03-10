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
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;
import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.Entidades.InfoOxigenacao;
import com.healthheart.jessica.hhmedic.R;

import java.util.UUID;

public class AddInfoOxigenacaoActivity extends AppCompatActivity {
    private EditText edttxInfoDataOxi;
    private EditText edttxTituloInfoOxi;
    private EditText edttxTextoInfoOxi;
    private Button btnSalvaInfoOxi;
    private Button btnCancInfoOxi;
    private Button btnHistInfoOxige;
    private Button btnVoltarPrinpal;


    private InfoOxigenacao infoOxigenacao;


    //Objeto de conexao
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_oxigenacao);


        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(AddInfoOxigenacaoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });


        // cancelar info
        btnCancInfoOxi = (Button) findViewById(R.id.btnCancInfoOxi);
        btnCancInfoOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCanInfBat = new Intent(AddInfoOxigenacaoActivity.this, AddInfoOxigenacaoActivity.class);
                startActivity(intentCanInfBat);
            }
        });

        btnHistInfoOxige = (Button) findViewById(R.id.btnHistInfoOxige);
        btnHistInfoOxige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistInfOx = new Intent(AddInfoOxigenacaoActivity.this, HistoricoInfoOxigenacaoActivity.class);
                startActivity(intentHistInfOx);
            }
        });


        edttxInfoDataOxi = (EditText) findViewById(R.id.edttxInfoDataOxi);
        edttxTituloInfoOxi = (EditText) findViewById(R.id.edttxTituloInfoOxi);
        edttxTextoInfoOxi = (EditText) findViewById(R.id.edttxTextoInfoOxi);
        btnSalvaInfoOxi = (Button) findViewById(R.id.btnSalvaInfoOxi);

        //Inicializa banco
        inicializarFirebase();

        btnSalvaInfoOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edttxInfoDataOxi.getText().toString().equals("")
                        && !edttxTituloInfoOxi.getText().toString().equals("")
                        && !edttxTextoInfoOxi.getText().toString().equals("")){
                    infoOxigenacao = new InfoOxigenacao();
                    infoOxigenacao.setIdInfoOxi(UUID.randomUUID().toString());
                    infoOxigenacao.setInfoDataOxi(edttxInfoDataOxi.getText().toString());
                    infoOxigenacao.setTituloInfoOxi(edttxTituloInfoOxi.getText().toString());
                    infoOxigenacao.setTextoInfoOxi(edttxTextoInfoOxi.getText().toString());

                    databaseReference = ConfiguracaoFirebase.getFirebase().child("InfoOxigenacao");
                    databaseReference.child(infoOxigenacao.getIdInfoOxi()).setValue(infoOxigenacao);
                    Toast.makeText(AddInfoOxigenacaoActivity.this, "Informações sobre Oxigenação registrado com sucesso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddInfoOxigenacaoActivity.this, "Preenchimento de Todos os campos são Obrigatórios", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(AddInfoOxigenacaoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}

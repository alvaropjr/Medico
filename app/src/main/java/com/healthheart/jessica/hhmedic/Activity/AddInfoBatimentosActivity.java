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
import com.healthheart.jessica.hhmedic.R;

import java.util.UUID;

public class AddInfoBatimentosActivity extends AppCompatActivity {
    private EditText edttxTituloInfoBati;
    private EditText edttxTextoInfoBati;
    private Button btnSalvaInfoBtimentos;
    private Button btnCancInfoBatimentos;
    private Button btnVoltarPrinpal;
    private Button btnHistInfoBatimentos;

    private InfoBatimentos infoBatimentos;

    //Objeto de conexao
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_batimentos);

        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(AddInfoBatimentosActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnHistInfoBatimentos = (Button) findViewById(R.id.btnHistInfoBatimentos);
        btnHistInfoBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfBati = new Intent(AddInfoBatimentosActivity.this, HistoricoInfoatimentoActivity.class);
                startActivity(intentIrHisInfBati);
            }
        });

        // cancelar info
        btnCancInfoBatimentos = (Button) findViewById(R.id.btnCancInfoBatimentos);
        btnCancInfoBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCanInfBat = new Intent(AddInfoBatimentosActivity.this, AddInfoBatimentosActivity.class);
                startActivity(intentCanInfBat);
            }
        });

        edttxTituloInfoBati = (EditText) findViewById(R.id.edttxTituloInfoBati);
        edttxTextoInfoBati = (EditText) findViewById(R.id.edttxTextoInfoBati);
        btnSalvaInfoBtimentos = (Button) findViewById(R.id.btnSalvaInfoBtimentos);

        //Inicializa banco
        inicializarFirebase();

        btnSalvaInfoBtimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edttxTituloInfoBati.getText().toString().equals("") && !edttxTextoInfoBati.getText().toString().equals("")){
                    infoBatimentos = new InfoBatimentos();
                    infoBatimentos.setIdInfoBati(UUID.randomUUID().toString());
                    infoBatimentos.setTituloInfoBati(edttxTituloInfoBati.getText().toString());
                    infoBatimentos.setTextoInfoBati(edttxTextoInfoBati.getText().toString());
                    databaseReference = ConfiguracaoFirebase.getFirebase().child("InfoBatimentos");
                    databaseReference.child(infoBatimentos.getIdInfoBati()).setValue(infoBatimentos);
                    Toast.makeText(AddInfoBatimentosActivity.this, "Informações Batimentos registrado com sucesso", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddInfoBatimentosActivity.this, "Preenchimento de Todos os campos são Obrigatórios", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(AddInfoBatimentosActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}

package com.healthheart.jessica.hhmedic.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import com.healthheart.jessica.hhmedic.Adapter.InfoBatimentosAdapter;
import com.healthheart.jessica.hhmedic.Adapter.ParametroBatimentoAdapter;
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;
import com.healthheart.jessica.hhmedic.Entidades.ParametroBatimentos;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

public class HistoricoParamentroBatimentosActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<ParametroBatimentos> adapter;
    private ArrayList<ParametroBatimentos> parametroBatimentos;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerParametrBat;


    private Button btnVoltarPrinpal;
    private Button btnVoltaParaBatimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_paramentro_batimentos);


        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(HistoricoParamentroBatimentosActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnVoltaParaBatimentos = (Button) findViewById(R.id.btnVoltaParaBatimentos);
        btnVoltaParaBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarAddPara = new Intent(HistoricoParamentroBatimentosActivity.this, ParametrosBatimentosActivity.class);
                startActivity(intentVoltarAddPara);
            }
        });


        parametroBatimentos = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lvHisParatBatimentos);
        adapter = new ParametroBatimentoAdapter(this, parametroBatimentos);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("ParametroBatimentos");

        valueEventListenerParametrBat = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                parametroBatimentos.clear();
                /* for (DataSnapshot dados : dataSnapshot.getChildren()){
                    InfoBatimentos infoBatimentosNovo = dados.getValue(InfoBatimentos.class);

                    infoBatimentos.add(infoBatimentosNovo);
                }*/
                for (DataSnapshot dados : dataSnapshot.getChildren()){
                    ParametroBatimentos parametroBatimentosNovo = dados.getValue(ParametroBatimentos.class);
                    parametroBatimentos.add(parametroBatimentosNovo);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

    }

    @Override
    protected void onStop() {
        super.onStop();
        firebase.removeEventListener(valueEventListenerParametrBat);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerParametrBat);
    }
}

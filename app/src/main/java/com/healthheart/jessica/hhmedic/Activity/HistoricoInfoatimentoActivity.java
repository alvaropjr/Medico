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
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;
import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

public class HistoricoInfoatimentoActivity extends AppCompatActivity {
//lvInfoBati
    private ListView listView;
    private ArrayAdapter<InfoBatimentos> adapter;
    private ArrayList<InfoBatimentos> infoBatimentos;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerInfoBatimentos;


    private Button btnVoltarPrinpal;
    private Button btnAddInfoBatimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_infoatimento);


        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(HistoricoInfoatimentoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoBatimentos = (Button) findViewById(R.id.btnAddInfoBatimentos);
        btnAddInfoBatimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfBati = new Intent(HistoricoInfoatimentoActivity.this, AddInfoBatimentosActivity.class);
                startActivity(intentIrHisInfBati);
            }
        });

        infoBatimentos = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lvInfoBati);
        adapter = new InfoBatimentosAdapter(this, infoBatimentos);
        listView.setAdapter(adapter);

        //firebase = ConfiguracaoFirebase.getFirebase().child("PressaoInfo");
        firebase = ConfiguracaoFirebase.getFirebase().child("InfoBatimentos");

        valueEventListenerInfoBatimentos = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                infoBatimentos.clear();
                for (DataSnapshot dados : dataSnapshot.getChildren()){
                    InfoBatimentos infoBatimentosNovo = dados.getValue(InfoBatimentos.class);

                    infoBatimentos.add(infoBatimentosNovo);
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
        firebase.removeEventListener(valueEventListenerInfoBatimentos);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerInfoBatimentos);
    }




}

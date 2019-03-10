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
import com.healthheart.jessica.hhmedic.Adapter.InfoOxigenacaoAdapter;
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;
import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.Entidades.InfoOxigenacao;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

public class HistoricoInfoOxigenacaoActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<InfoOxigenacao> adapter;
    private ArrayList<InfoOxigenacao> infoOxigenacao;
    private DatabaseReference firebase;
    private ValueEventListener valueEventListenerInfoOxi;


    private Button btnVoltarPrinpal;
    private Button btnAddInfoOxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_info_oxigenacao);


        //Voltar Tela principal
        btnVoltarPrinpal = (Button) findViewById(R.id.btnVoltarPrinpal);
        btnVoltarPrinpal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVoltarTelaPrinci = new Intent(HistoricoInfoOxigenacaoActivity.this, PrincipalActivity.class);
                startActivity(intentVoltarTelaPrinci);
            }
        });

        btnAddInfoOxi = (Button) findViewById(R.id.btnAddInfoOxi);
        btnAddInfoOxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentIrHisInfBati = new Intent(HistoricoInfoOxigenacaoActivity.this, AddInfoOxigenacaoActivity.class);
                startActivity(intentIrHisInfBati);
            }
        });

        infoOxigenacao = new ArrayList<>();
        listView = (ListView) findViewById(R.id.lvInfoOxi);
        adapter = new InfoOxigenacaoAdapter(this, infoOxigenacao);
        listView.setAdapter(adapter);

        firebase = ConfiguracaoFirebase.getFirebase().child("InfoOxigenacao");

        valueEventListenerInfoOxi = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                infoOxigenacao.clear();
                for (DataSnapshot dados : dataSnapshot.getChildren()){
                    InfoOxigenacao infoOxigenacaoNovo = dados.getValue(InfoOxigenacao.class);
                    infoOxigenacao.add(infoOxigenacaoNovo);
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
        firebase.removeEventListener(valueEventListenerInfoOxi);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebase.addValueEventListener(valueEventListenerInfoOxi);
    }
}

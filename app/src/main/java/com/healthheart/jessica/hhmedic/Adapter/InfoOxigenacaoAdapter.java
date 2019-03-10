package com.healthheart.jessica.hhmedic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.Entidades.InfoOxigenacao;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

/**
 * Created by Jessica on 10/11/2017.
 */

public class InfoOxigenacaoAdapter extends ArrayAdapter<InfoOxigenacao> {
    private ArrayList<InfoOxigenacao> infoOxigenacao;
    private Context context;

    public InfoOxigenacaoAdapter(Context c, ArrayList<InfoOxigenacao> objects){
        super(c,0,objects);
        this.context = c;
        this.infoOxigenacao = objects;
    }

    @Override

    //    public View getView(int position, View convertView, ViewGroup parent){
    public View getView(int position, View converView, ViewGroup parent){
        View view = null;
        if (infoOxigenacao != null){
            /*LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_infor_batimentos, parent, false);*/
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            //view = inflater.inflate(R.layout.)
            view = inflater.inflate(R.layout.lista_info_oxi, parent, false);

            TextView textViewDataInfOxi = (TextView) view.findViewById(R.id.textViewDataInfOxi);
            TextView textViewTutiloInfoOxi = (TextView) view.findViewById(R.id.textViewTutiloInfoOxi);
            TextView textViewTextoInfOxi = (TextView) view.findViewById(R.id.textViewTextoInfOxi);

            InfoOxigenacao infoOxigenacaoInfo2 = infoOxigenacao.get(position);

            textViewDataInfOxi.setText(infoOxigenacaoInfo2.getInfoDataOxi());
            textViewTutiloInfoOxi.setText(infoOxigenacaoInfo2.getTituloInfoOxi());
            textViewTextoInfOxi.setText(infoOxigenacaoInfo2.getTextoInfoOxi());
        }


        return view;
    }


}

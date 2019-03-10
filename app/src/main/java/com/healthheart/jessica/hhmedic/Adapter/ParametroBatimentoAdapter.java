package com.healthheart.jessica.hhmedic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.healthheart.jessica.hhmedic.Entidades.ParametroBatimentos;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

/**
 * Created by Jessica on 26/10/2017.
 */

public class ParametroBatimentoAdapter extends ArrayAdapter<ParametroBatimentos> {

    private ArrayList<ParametroBatimentos> parametroBatimentos;
    private Context context;

    public ParametroBatimentoAdapter(Context c, ArrayList<ParametroBatimentos> objects){
        super(c, 0, objects);
        this.context = c;
        this.parametroBatimentos = objects;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent){
        View view = null;
        if (parametroBatimentos != null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_parametro_batimentos, parent, false);

            TextView txtDataParBat = (TextView) view.findViewById(R.id.txtDataParBat);
            TextView txtBradicardiaBaixo = (TextView) view.findViewById(R.id.txtBradicardiaBaixo);
            TextView txtBradicardiaAlta = (TextView) view.findViewById(R.id.txtBradicardiaAlta);
            TextView txtBatMinNormal = (TextView) view.findViewById(R.id.txtBatMinNormal);
            TextView txtBatMaxNormal = (TextView) view.findViewById(R.id.txtBatMaxNormal);
            TextView txtTaquicardiaMin = (TextView) view.findViewById(R.id.txtTaquicardiaMin);
            TextView txtTaquicardiaMax = (TextView) view.findViewById(R.id.txtTaquicardiaMax);
            TextView txtMotivoAltParBati = (TextView) view.findViewById(R.id.txtMotivoAltParBati);

            ParametroBatimentos parametroBatimentos2 = parametroBatimentos.get(position);

             txtDataParBat .setText("Data Inserção dos dados: " + parametroBatimentos2.getDataParaBatimentos());
             txtBradicardiaBaixo.setText("Bradicardia Baixa: " + parametroBatimentos2.getBradicardiaBaixo() + "BPM");
             txtBradicardiaAlta.setText("Bradicardia Alta: " + parametroBatimentos2.getBradicardiaAlta() + "BPM");
             txtBatMinNormal.setText("Batimentos Minímo Normal: " + parametroBatimentos2.getBatMinNormal() + "BPM");
             txtBatMaxNormal.setText("Batimentos Máxima Normal: " + parametroBatimentos2.getBatMaxNormal() + "BPM");
             txtTaquicardiaMin.setText("Taquicardia Miníma: " + parametroBatimentos2.getTaquicardiaMin() + "BPM");
             txtTaquicardiaMax.setText("Taquicardia Máxima: " + parametroBatimentos2.getTaquicardiaMax() + "BPM");
             txtMotivoAltParBati.setText("Motivo Alteração Parametros: " + parametroBatimentos2.getMotivoAltValorParBat());



        }

        return view;
    }

/*
*/

}

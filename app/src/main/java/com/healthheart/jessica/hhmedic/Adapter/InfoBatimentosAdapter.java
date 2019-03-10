package com.healthheart.jessica.hhmedic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.healthheart.jessica.hhmedic.Entidades.InfoBatimentos;
import com.healthheart.jessica.hhmedic.R;

import java.util.ArrayList;

/**
 * Created by Jessica on 28/10/2017.
 */

public class InfoBatimentosAdapter extends ArrayAdapter<InfoBatimentos> {
    private ArrayList<InfoBatimentos> infoBatimentoses;
    private Context context;

    public InfoBatimentosAdapter(Context c, ArrayList<InfoBatimentos> objects){
        super(c,0,objects);
        this.context = c;
        this.infoBatimentoses = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = null;
        if(infoBatimentoses != null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lista_infor_batimentos, parent, false);

            TextView txtViewTituInfBati = (TextView) view.findViewById(R.id.txtViewTituInfBati);
            TextView txtViewTexInfBati = (TextView) view.findViewById(R.id.txtViewTexInfBati);

            InfoBatimentos infoBatimentosesInfo2 = infoBatimentoses.get(position);

            txtViewTituInfBati.setText(infoBatimentosesInfo2.getTituloInfoBati());
            txtViewTexInfBati.setText(infoBatimentosesInfo2.getTextoInfoBati());
        }
        return view;
    }

}

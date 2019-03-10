package com.healthheart.jessica.hhmedic.Entidades;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.healthheart.jessica.hhmedic.DAO.ConfiguracaoFirebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jessica on 26/10/2017.
 */

public class ParametroBatimentos {
    private String IdParaBatimentos;
    private String DataParaBatimentos;
    private double BradicardiaBaixo;
    private double BradicardiaAlta;
    private double BatMinNormal;
    private double BatMaxNormal;
    private double TaquicardiaMin;
    private double TaquicardiaMax;
    private String MotivoAltValorParBat;

    public ParametroBatimentos() {
    }

    public String getDataParaBatimentos() {
        return DataParaBatimentos;
    }

    public void setDataParaBatimentos(String dataParaBatimentos) {
        DataParaBatimentos = dataParaBatimentos;
    }

    public String getMotivoAltValorParBat() {
        return MotivoAltValorParBat;
    }

    public void setMotivoAltValorParBat(String motivoAltValorParBat) {
        MotivoAltValorParBat = motivoAltValorParBat;
    }

    public String getIdParaBatimentos() {
        return IdParaBatimentos;
    }

    public void setIdParaBatimentos(String idParaBatimentos) {
        IdParaBatimentos = idParaBatimentos;
    }

    public double getBradicardiaBaixo() {
        return BradicardiaBaixo;
    }

    public void setBradicardiaBaixo(double bradicardiaBaixo) {
        BradicardiaBaixo = bradicardiaBaixo;
    }

    public double getBradicardiaAlta() {
        return BradicardiaAlta;
    }

    public void setBradicardiaAlta(double bradicardiaAlta) {
        BradicardiaAlta = bradicardiaAlta;
    }

    public double getBatMinNormal() {
        return BatMinNormal;
    }

    public void setBatMinNormal(double batMinNormal) {
        BatMinNormal = batMinNormal;
    }

    public double getBatMaxNormal() {
        return BatMaxNormal;
    }

    public void setBatMaxNormal(double batMaxNormal) {
        BatMaxNormal = batMaxNormal;
    }

    public double getTaquicardiaMin() {
        return TaquicardiaMin;
    }

    public void setTaquicardiaMin(double taquicardiaMin) {
        TaquicardiaMin = taquicardiaMin;
    }

    public double getTaquicardiaMax() {
        return TaquicardiaMax;
    }

    public void setTaquicardiaMax(double taquicardiaMax) {
        TaquicardiaMax = taquicardiaMax;
    }


}

package com.jard.testretrofit.restApi.model;

import com.jard.testretrofit.pojo.Foto;

import java.util.ArrayList;

/**
 * Created by jarodrig on 01/06/2017.
 */

public class MediaResponse {
    private ArrayList<Foto> fotos;

    public ArrayList<Foto> getFotos(){
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos){
        this.fotos = fotos;
    }
}

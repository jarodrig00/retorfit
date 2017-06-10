package com.jard.testretrofit.fragment;

import com.jard.testretrofit.adapter.FotoAdapter;
import com.jard.testretrofit.pojo.Foto;

import java.util.ArrayList;

/**
 * Created by jarodrig on 01/06/2017.
 */

public interface IRecyclerViewFotos {
    public void generarLayout();
    public FotoAdapter generarAdaptador(ArrayList<Foto> fotos);
    public FotoAdapter generarAdptador();
    public void inicializaAdaptador(FotoAdapter fotoAdapter);
}

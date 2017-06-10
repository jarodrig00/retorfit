package com.jard.testretrofit.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.jard.testretrofit.DB.ConstructorFoto;
import com.jard.testretrofit.fragment.IRecyclerViewFotos;
import com.jard.testretrofit.pojo.Foto;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jarodrig on 01/06/2017.
 */

public class RecyclerViewPresenter implements IRecyclerViewPresenter {
    private IRecyclerViewFotos iRecyclerViewFotos;
    private Context context;
    private ConstructorFoto constructorFoto;
    private ArrayList<Foto> fotos;

    public RecyclerViewPresenter(IRecyclerViewFotos iRecyclerViewFotos, Context context) {
        this.iRecyclerViewFotos = iRecyclerViewFotos;
        this.context = context;
        getFoto();
    }

    @Override
    public void getFoto()  {
        constructorFoto = new ConstructorFoto(context);
        //fotos = constructorFoto.getDataInstagram();
        fotos = constructorFoto.getDataDummy();
        showFotoRecyclerView();
    }

    @Override
    public void showFotoRecyclerView() {
        //iRecyclerViewFotos.inicializaAdaptador(iRecyclerViewFotos.generarAdaptador(fotos));
        //Se pasa al terminar la carga de datos
        iRecyclerViewFotos.generarAdptador();
        /*
        iRecyclerViewFotos.inicializaAdaptador(iRecyclerViewFotos.generarAdptador());
        iRecyclerViewFotos.generarLayout();*/
    }

    @Override
    public ArrayList<Foto> getFotos() {
        return fotos;
    }
}

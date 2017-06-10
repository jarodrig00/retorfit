package com.jard.testretrofit.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jard.testretrofit.DB.ConstructorFoto;
import com.jard.testretrofit.R;
import com.jard.testretrofit.adapter.FotoAdapter;
import com.jard.testretrofit.pojo.Foto;
import com.jard.testretrofit.pojo.UserInstagram;
import com.jard.testretrofit.presenter.IRecyclerViewPresenter;
import com.jard.testretrofit.presenter.RecyclerViewPresenter;
import com.jard.testretrofit.restApi.EndPointApi;
import com.jard.testretrofit.restApi.RestApiConstant;
import com.jard.testretrofit.restApi.adapter.RestApiAdapter;
import com.jard.testretrofit.restApi.model.MediaResponse;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecyclerViewFotos extends Fragment implements IRecyclerViewFotos {
    FotoAdapter fotoAdapter;
    RecyclerView rvFotos;
    //ArrayList<Foto> fotos;
    private IRecyclerViewPresenter presenter;

    public RecyclerViewFotos() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvFotos = (RecyclerView) v.findViewById(R.id.rvFotos);
        presenter = new RecyclerViewPresenter(this, getContext());


        return v;
    }


    @Override
    public void generarLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        rvFotos.setLayoutManager(gridLayoutManager);
    }

    @Override
    public FotoAdapter generarAdaptador(ArrayList<Foto> fotos) {
        if (fotoAdapter == null){
            fotoAdapter = new FotoAdapter(fotos);
        }else{
            fotoAdapter.swap(fotos);
        }

        return fotoAdapter;
    }

    @Override
    public FotoAdapter generarAdptador() {


        Log.e("GetData", "Iniciando actividad");
        UserInstagram userInstagram = new UserInstagram();

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMedia = restApiAdapter.construyeGsonDeserializadorMedia();

        Log.e("GetData", "Se llama a getMedia");
        /*
        Por default no deja llamar una petición a red en el hilo principal
        EndPointApi endPointApi = restApiAdapter.establecerConexionApiInstagram(gsonMedia);
        Call<MediaResponse> call = endPointApi.getMedia(userInstagram.getId());
        Response<MediaResponse> mediaResponse = null;
        try {
            mediaResponse = call.execute();
        } catch (Exception e) {
            Log.e("Call : ", e.toString());
        }
        if (mediaResponse != null)
            if(mediaResponse.isSuccessful()){
                fotos = mediaResponse.body().getFotos();
        }else{
                //restApiAdapter(mediaResponse);
            }

    */

        EndPointApi endPointApi = restApiAdapter.establecerConexionApiInstagram(gsonMedia);
        Call<MediaResponse> mediaResponseCall = endPointApi.getMedia(userInstagram.getId());
        Log.i("URL ", RestApiConstant.ROOT_URL + RestApiConstant.URL_MEDIA);
        mediaResponseCall.enqueue(new Callback<MediaResponse>() {
            @Override
            public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                Log.i("Media ", "OnResponse " + Integer.toString(response.code()));
                //Log.i("Media ", "OnResponse " + response.body().toString());
                MediaResponse mediaResponse = response.body();
                if (fotoAdapter == null) {
                    fotoAdapter = new FotoAdapter(mediaResponse.getFotos());
                } else {
                    fotoAdapter.swap(mediaResponse.getFotos());
                }
                inicializaAdaptador(fotoAdapter);
                generarLayout();

            }

            @Override
            public void onFailure(Call<MediaResponse> call, Throwable t) {
                Log.i("Media Error", t.toString());
                Toast.makeText(getContext(), "Algo paso, intenta nuevamente", Toast.LENGTH_SHORT);
                ConstructorFoto constructorFoto = new ConstructorFoto(getContext());
                if (fotoAdapter == null) {
                    fotoAdapter = new FotoAdapter(constructorFoto.getDataDummy());
                } else {
                    fotoAdapter.swap(constructorFoto.getDataDummy());
                }
            }
        });
        Log.e("Media", "Se termino de cargar datos");
        return fotoAdapter;
    }



    @Override
    public void inicializaAdaptador(FotoAdapter fotoAdapter) {
        rvFotos.setAdapter(fotoAdapter);
        //fotoAdapter.notifyDataSetChanged();
    }
}

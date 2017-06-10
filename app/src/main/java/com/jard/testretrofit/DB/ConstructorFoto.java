package com.jard.testretrofit.DB;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jard.testretrofit.pojo.Foto;
import com.jard.testretrofit.pojo.UserInstagram;
import com.jard.testretrofit.restApi.EndPointApi;
import com.jard.testretrofit.restApi.RestApiConstant;
import com.jard.testretrofit.restApi.adapter.RestApiAdapter;
import com.jard.testretrofit.restApi.model.MediaResponse;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jarodrig on 01/06/2017.
 */

public class ConstructorFoto {
    private Context context;
    private ArrayList<Foto> fotos;

    public ConstructorFoto(Context context){
        this.context = context;
    }

    public ArrayList<Foto> getDataDummy(){
        fotos = new ArrayList<>();
        fotos.add(new Foto("01","Aurelio", 10, ""));
        fotos.add(new Foto("01","Miguel", 8, ""));
        fotos.add(new Foto("01","Laura", 6, ""));
        fotos.add(new Foto("01","Mary", 13, ""));
        fotos.add(new Foto("01","Vero", 5, ""));
        fotos.add(new Foto("01","Pancho", 1, ""));
        fotos.add(new Foto("01","Benito", 9, ""));
        fotos.add(new Foto("01","Chole", 3, ""));
        fotos.add(new Foto("01","Lola", 3, ""));
        fotos.add(new Foto("01","Lucy", 3, ""));
        fotos.add(new Foto("01","Luis", 3, ""));
        fotos.add(new Foto("01","Martin", 3, ""));

        return fotos;
    }

    public ArrayList<Foto> getDataInstagram() {

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
                Log.i("Media ", "OnResponse " + response.body());
                MediaResponse mediaResponse = response.body();
                fotos = mediaResponse.getFotos();
                this.notify();
            }

            @Override
            public void onFailure(Call<MediaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo paso, intenta nuevamente", Toast.LENGTH_SHORT);
                fotos = new ArrayList<Foto>();
            }
        });

        return fotos;
    }
}

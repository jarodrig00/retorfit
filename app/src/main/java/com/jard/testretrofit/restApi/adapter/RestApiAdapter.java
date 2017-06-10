package com.jard.testretrofit.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jard.testretrofit.restApi.EndPointApi;
import com.jard.testretrofit.restApi.RestApiConstant;
import com.jard.testretrofit.restApi.deserializer.MediaDeserializer;
import com.jard.testretrofit.restApi.model.MediaResponse;

import java.io.IOException;
import java.util.logging.Level;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jarodrig on 01/06/2017.
 */

public class RestApiAdapter {
    public EndPointApi establecerConexionApiInstagram(Gson gson){
        /*
        HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggin);
        */


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestApiConstant.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                //.client(httpClient.build())
                .build();
        return retrofit.create(EndPointApi.class);
    }

    public Gson construyeGsonDeserializadorMedia(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MediaResponse.class, new MediaDeserializer());
        return gsonBuilder.create();
    }
}

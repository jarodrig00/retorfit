package com.jard.testretrofit.pojo;

/**
 * Created by jarodrig on 01/06/2017.
 */

public class Foto {
    private String id;
    private String nombre;
    private int count;
    private String urlFoto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Foto(){
        id = "";
        nombre = "";
        count = 0;
        urlFoto = "";
    }

    public Foto(String id, String nombre, int count, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.count = count;
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }


}

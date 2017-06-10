package com.jard.testretrofit.pojo;

/**
 * Created by jarodrig on 02/06/2017.
 */

public class UserInstagram {
    private String id;
    private String name;
    private String full_name;

    public UserInstagram(){
        id = "5518916073";
        name = "jaurelio_rodriguez";
        full_name = "Aurelio Rodriguez";
    }
    public UserInstagram(String id, String name, String full_name) {
        this.id = id;
        this.name = name;
        this.full_name = full_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}

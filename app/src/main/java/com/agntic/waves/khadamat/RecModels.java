package com.agntic.waves.khadamat;

/**
 * Created by root on 2/3/16.
 */
public class RecModels {

    private String Name;
    private String Url_img;
    //int Position;

    public RecModels(String name, String url_img) {
        Name = name;
        Url_img = url_img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl_img() {
        return Url_img;
    }

    public void setUrl_img(String numb) {
        Url_img = numb;
    }



}

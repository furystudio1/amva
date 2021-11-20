package com.agntic.waves.Model;

/**
 * Created by FURY on 12/1/2017.
 */

public class Video implements Comparable<Video> {

    String Name;
    String Url;
    String Numb;

    private Float val;

    public Video(Float val,String name, String url,String numb) {
        Name = name;
        Url = url;
        Numb = numb;
        this.val = val;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumb() {
        return Numb;
    }

    public void setNumb(String numb) {
        Numb = numb;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    @Override
    public int compareTo(Video f) {
        if (val.floatValue() > f.val.floatValue()) {
            return 1;
        }
        else if (val.floatValue() <  f.val.floatValue()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

package com.example.cedricdevries.webservices;

import java.io.Serializable;

public class Filter implements Serializable {

    private String type;
    private String park;

    public Filter(){

    }

    public Filter(String type, String park) {
        this.type = type;
        this.park = park;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPark() {
        return park;
    }

    public void setPark(String park) {
        this.park = park;
    }

}

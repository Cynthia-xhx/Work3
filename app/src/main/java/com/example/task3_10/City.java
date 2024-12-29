package com.example.task3_10;

import java.util.List;

public class City {

    private String name;
    private int picId;
    private List<Sight> sights;

    public City(String name, int picId, List<Sight> sights) {
        this.name = name;
        this.picId = picId;
        this.sights = sights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public List<Sight> getSights() {
        return sights;
    }

    public void setSights(List<Sight> sights) {
        this.sights = sights;
    }
}

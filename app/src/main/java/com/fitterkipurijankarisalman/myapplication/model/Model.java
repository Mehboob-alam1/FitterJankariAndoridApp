package com.fitterkipurijankarisalman.myapplication.model;

public class Model {
    private String name;
    private Integer clickIndex;

    public Model(String name, Integer clickIndex) {
        this.name = name;
        this.clickIndex = clickIndex;
    }

    public Integer getClickIndex() {
        return clickIndex;
    }

    public void setClickIndex(Integer clickIndex) {
        this.clickIndex = clickIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

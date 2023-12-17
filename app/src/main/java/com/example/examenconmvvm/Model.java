package com.example.examenconmvvm;

public class Model {
    private String name;
    private int ir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIr() {
        return ir;
    }

    public void setIr(int ir) {
        this.ir = ir;
    }

    public Model(String name, int ir) {
        this.name = name;
        this.ir = ir;
    }
}
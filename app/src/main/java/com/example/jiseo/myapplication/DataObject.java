package com.example.jiseo.myapplication;

import java.util.List;

public class DataObject {
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<IdPair> getIdPairs() {
        return idPairs;
    }

    public void setIdPairs(List<IdPair> idPairs) {
        this.idPairs = idPairs;
    }

    private int code;
    private List<IdPair> idPairs;
    }

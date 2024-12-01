package com.example.mozimusorbeadando.model;

import java.io.Serializable;

public class HelyId implements Serializable {

    private Integer fkod;
    private Integer moziazon;

    public Integer getFkod() {
        return fkod;
    }

    public void setFkod(Integer fkod) {
        this.fkod = fkod;
    }

    public Integer getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Integer moziazon) {
        this.moziazon = moziazon;
    }
}

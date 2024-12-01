package com.example.mozimusorbeadando.model;

import jakarta.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "mozi")
public class Mozi {

    @Id
    @Column(name = "moziazon")
    private Integer moziazon;

    @Column(name = "mozinev")
    private String mozinev;

    @Column(name = "irszam")
    private String irszam;

    @Column(name = "cim")
    private String cim;

    @Column(name = "telefon")
    private String telefon;

    // Getters and setters

    public Integer getMoziazon() {
        return moziazon;
    }

    public void setMoziazon(Integer moziazon) {
        this.moziazon = moziazon;
    }

    public String getMozinev() {
        return mozinev;
    }

    public void setMozinev(String mozinev) {
        this.mozinev = mozinev;
    }

    public String getIrszam() {
        return irszam;
    }

    public void setIrszam(String irszam) {
        this.irszam = irszam;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}

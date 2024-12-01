package com.example.mozimusorbeadando.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @Column(name = "fkod")
    private Integer fkod;

    @Column(name = "filmcim")
    private String filmcim;

    @Column(name = "szines")
    private Integer szines;

    @Column(name = "szinkron")
    private String szinkron;

    @Column(name = "szarmazas")
    private String szarmazas;

    @Column(name = "mufaj")
    private String mufaj;

    @Column(name = "hossz")
    private Integer hossz;

    // Getters and setters

    public Integer getFkod() {
        return fkod;
    }

    public void setFkod(Integer fkod) {
        this.fkod = fkod;
    }

    public String getFilmcim() {
        return filmcim;
    }

    public void setFilmcim(String filmcim) {
        this.filmcim = filmcim;
    }

    public Integer getSzines() {
        return szines;
    }

    public void setSzines(Integer szines) {
        this.szines = szines;
    }

    public String getSzinkron() {
        return szinkron;
    }

    public void setSzinkron(String szinkron) {
        this.szinkron = szinkron;
    }

    public String getSzarmazas() {
        return szarmazas;
    }

    public void setSzarmazas(String szarmazas) {
        this.szarmazas = szarmazas;
    }

    public String getMufaj() {
        return mufaj;
    }

    public void setMufaj(String mufaj) {
        this.mufaj = mufaj;
    }

    public Integer getHossz() {
        return hossz;
    }

    public void setHossz(Integer hossz) {
        this.hossz = hossz;
    }
}

package com.example.mozimusorbeadando.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hely")
@IdClass(HelyId.class)
public class Hely {

    @Id
    @Column(name = "fkod")
    private Integer fkod;

    @Id
    @Column(name = "moziazon")
    private Integer moziazon;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "fkod", insertable = false, updatable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "moziazon", insertable = false, updatable = false)
    private Mozi mozi;

    // Getters and setters

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

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Mozi getMozi() {
        return mozi;
    }

    public void setMozi(Mozi mozi) {
        this.mozi = mozi;
    }
}

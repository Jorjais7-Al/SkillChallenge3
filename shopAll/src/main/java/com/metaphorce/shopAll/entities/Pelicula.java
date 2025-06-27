package com.metaphorce.shopAll.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre_pelicula;

    @Column
    private boolean disponible;

    public Pelicula(Integer id, String nombre_pelicula, Boolean disponible) {
        this.id = id;
        this.nombre_pelicula = nombre_pelicula;
        this.disponible = disponible;
    }

    public Pelicula() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_pelicula() {
        return nombre_pelicula;
    }

    public void setNombre_pelicula(String nombre_pelicula) {
        this.nombre_pelicula = nombre_pelicula;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}

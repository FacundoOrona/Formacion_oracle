package com.alura.screenmatch.modelos;

import com.alura.screenmatch.calculos.Clasificable;

public class Pelicula extends Titulo implements Clasificable {
    private String director;

    public Pelicula() {
    }

    public Pelicula(String director, String nombre) {
        super(nombre);
        this.director = director;
    }

    public Pelicula(int fechaDeLanzamiento, String nombre) {
        super(fechaDeLanzamiento, nombre);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMediaEvaluaciones() / 2;
    }

    @Override
    public String toString() {
        return  "Nombre de pelicula: " + this.getNombre() +
                " (Fecha de lanzamiento: " + this.getFechaDeLanzamiento() + ")";
    }
}

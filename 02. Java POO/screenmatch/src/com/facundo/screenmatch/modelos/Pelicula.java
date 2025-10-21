package com.facundo.screenmatch.modelos;

import com.facundo.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {

    private String director;

    public String getDirector() {
        return director;
    }

    public Pelicula() {
        this.director = director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getDuracionMinutos() {
        return super.getDuracionMinutos();
    }

}

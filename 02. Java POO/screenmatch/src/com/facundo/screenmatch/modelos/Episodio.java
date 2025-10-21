package com.facundo.screenmatch.modelos;

import com.facundo.screenmatch.calculos.Clasificacion;

public class Episodio implements Clasificacion {
    private int numeroEp;
    private String nombre;
    private Serie serie;
    private int totalVisualizaciones;

    public int getNumeroEp() {
        return numeroEp;
    }

    public void setNumeroEp(int numeroEp) {
        this.numeroEp = numeroEp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones > 100){
            return 4;
        }
        else {
            return 2;
        }
    }
}

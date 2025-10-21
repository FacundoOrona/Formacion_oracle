package com.facundo.screenmatch.modelos;
import com.facundo.screenmatch.calculos.Clasificacion;
public class Episodio implements Clasificacion {
    private int numeroEp;
    private String nombre;
    private Serie serie;
    private int totalVisualizaciones;

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

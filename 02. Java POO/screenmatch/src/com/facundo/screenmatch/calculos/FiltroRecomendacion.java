package com.facundo.screenmatch.calculos;

public class FiltroRecomendacion {
    public void filtro(Clasificacion clasificacion) {
        if (clasificacion.getClasificacion() >= 4) {
            System.out.println("Muy bien evaluado");
        } else if (clasificacion.getClasificacion() == 2) {
            System.out.println("Menos evaluado");
        } else if (clasificacion.getClasificacion() == 1){
            System.out.println("ashe");
        } else {
            System.out.println("MALARDA");
        }
    }
}

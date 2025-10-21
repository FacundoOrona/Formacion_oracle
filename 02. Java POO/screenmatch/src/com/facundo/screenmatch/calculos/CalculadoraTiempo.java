package com.facundo.screenmatch.calculos;

import com.facundo.screenmatch.modelos.Pelicula;
import com.facundo.screenmatch.modelos.Titulo;

public class CalculadoraTiempo {
    private int tiempoTotal;

    public void incluye(Titulo titulo) {
        tiempoTotal+=titulo.getDuracionMinutos();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}

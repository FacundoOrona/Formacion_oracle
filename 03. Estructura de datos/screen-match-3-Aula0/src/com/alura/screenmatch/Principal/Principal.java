package com.alura.screenmatch.Principal;

import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula(2021, "Encanto");
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

    }
}
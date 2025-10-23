package com.alura.screenmatch.Principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula otraPelicula = new Pelicula(2023, "Avatar");
        otraPelicula.evalua(9);
        Pelicula miPelicula = new Pelicula(2021, "Encanto");
        miPelicula.evalua(8);
        var pelicula = new Pelicula(2021, "Señor de los anillos");
        pelicula.evalua(7);

        Serie lost = new Serie(2000, "Lost" );
        lost.evalua(2);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(pelicula);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(lost);

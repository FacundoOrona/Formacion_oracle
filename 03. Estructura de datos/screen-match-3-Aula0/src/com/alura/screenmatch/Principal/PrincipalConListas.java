package com.alura.screenmatch.Principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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

        for (Titulo Item: lista){
            System.out.println(Item.getNombre());
            if (Item instanceof Pelicula peliculaIt){
                //Pelicula peliculaIt = (Pelicula) Item;
                System.out.println(peliculaIt.getClasificacion());
            } else if (Item instanceof Serie) {
                Serie serieIt = (Serie) Item;
                System.out.println(serieIt.getFechaDeLanzamiento());
            }
        }

//        System.out.println("*****************");
//        lista.forEach(titulo -> System.out.println(titulo));
//        System.out.println("*****************");
//        lista.forEach(System.out::println);

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Zell");
        listaDeArtistas.add("Cero*");
        listaDeArtistas.add("EnzoCeroBulto");
        listaDeArtistas.add("Cluster");
        listaDeArtistas.add("Pabloxo");
        System.out.println("Lista de artistas: " + listaDeArtistas);
        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ord por nombre: " + lista);

    }
}

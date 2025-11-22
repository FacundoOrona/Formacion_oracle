package com.aluracursos.screenmatch.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploStreams {
    public void muestraEjemplo() {
        List<String> nombres = Arrays.asList("Facundo", "Fernanda", "David", "Genesys", "Santiago");

        nombres.stream()
                .sorted() // ordenarlos alfabeticamente
                .limit(4) //muestra solo los primeros 4
                .filter(n -> n.startsWith("F")) //muestra los q empiecen con F. n representa el objeto de la lista
                .map(n -> n.toUpperCase()) //pasa todo a mayus
                .forEach(System.out::println);
    }
}

package com.aluracursos.desafioBooks.Principal;

import com.aluracursos.desafioBooks.model.Datos;
import com.aluracursos.desafioBooks.model.DatosLibro;
import com.aluracursos.desafioBooks.service.ConsumoAPI;
import com.aluracursos.desafioBooks.service.ConvierteDatos;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos convierteDatos = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://gutendex.com/books/";

    public void muestraMenu() {
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = convierteDatos.obtenerDatos(json, Datos.class);
        System.out.println("Datos convertidos: ");
        System.out.println(datos);

        //Top 10 libros mas descargados
        System.out.println("TOP 10 MAS DESCARGADOS");
        datos.resultados().stream()
                .sorted(Comparator.comparing(DatosLibro::numeroDescargas).reversed())
                .limit(10)
                .map(l -> l.titulo().toUpperCase())
                .forEach(System.out::println);

        //Busqueda de libro por nombre
        System.out.println("Ingrese nombre del libro que desee buscar");
        var busqueda = teclado.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE +"?search="+ busqueda.replace(" ", "+"));
        var datosBusqueda = convierteDatos.obtenerDatos(json, Datos.class);
        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                        .filter(l -> l.titulo().toUpperCase().contains(l.titulo().toUpperCase()))
                        .findFirst();
        if (libroBuscado.isPresent()){
            System.out.println("Resultado:");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Resultado no encontrado");
        }

        DoubleSummaryStatistics est = datos.resultados().stream()
                .filter(d -> d.numeroDescargas() > 0)
                .collect(Collectors.summarizingDouble(DatosLibro::numeroDescargas));

        System.out.println("Cantidad media de descargas: " + est.getAverage());
        System.out.println("Libro con maximas descargas " + est.getMax());
        System.out.println("Libro con minimas descargas " + est.getMin());
        System.out.println("Cantidad de regisros evaluados para calcular las estadisticas " + est.getCount());
    }
}

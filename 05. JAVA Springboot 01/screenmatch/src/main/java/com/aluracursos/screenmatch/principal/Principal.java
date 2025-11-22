package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPIService;
import com.aluracursos.screenmatch.service.ConvierteDatosService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPIService consumoAPI = new ConsumoAPIService();
    private ConvierteDatosService conversorAPI = new ConvierteDatosService();
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=a1de3692";

    public void mostrarMenu () {
        System.out.println("Escribe el nombre de la serie que desee buscar");
        var nombreSerie = scanner.nextLine();
        var jsonSerie = consumoAPI.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datosSerie = conversorAPI.obtenerDatos(jsonSerie, DatosSerie.class);
        System.out.println(datosSerie);

        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i <= datosSerie.totalDeTemporadas(); i++) {
            var jsonTemporada = consumoAPI.obtenerDatos( URL_BASE +
                    nombreSerie.replace(" ", "+") +
                    "&season="+ i + API_KEY);
            var datosTemporadas = conversorAPI.obtenerDatos(jsonTemporada, DatosTemporada.class);
            temporadas.add(datosTemporadas);
        }
        //temporadas.forEach(System.out::println);

        System.out.println("********************************************");
        System.out.println("******** TITULO DE LOS EPISODIOS ***********");
        System.out.println("********************************************");
//        for (int i = 0; i < datosSerie.totalDeTemporadas(); i++) {
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size() ; j++) {
//                System.out.println(episodiosTemporada.get(j).tiulo());
//            }
//        }

        // CON LAMBDA
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.tiulo())));
    }
}

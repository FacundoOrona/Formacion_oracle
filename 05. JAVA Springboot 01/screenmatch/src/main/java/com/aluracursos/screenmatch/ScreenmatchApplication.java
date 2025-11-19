package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.service.ConsumoAPIService;
import com.aluracursos.screenmatch.service.ConvierteDatosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        var consumoAPIService = new ConsumoAPIService();
        var jsonSerie = consumoAPIService.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=a1de3692");
        var jsonEpisodio = consumoAPIService.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&season=1&episode=1&apikey=a1de3692");

        System.out.println("**** JSON SIN CONVERTIR ****");
        System.out.println(jsonSerie);
        System.out.println(jsonEpisodio);

        System.out.println("**** JSON CON CONVERSION ****");
        ConvierteDatosService conversor = new ConvierteDatosService();
        var datosSerie = conversor.obtenerDatos(jsonSerie, DatosSerie.class);
        System.out.println(datosSerie);

        var datosEpisodio = conversor.obtenerDatos(jsonEpisodio, DatosEpisodio.class);
        System.out.println(datosEpisodio);
    }
}

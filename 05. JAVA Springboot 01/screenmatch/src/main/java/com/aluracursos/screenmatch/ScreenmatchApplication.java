package com.aluracursos.screenmatch;

import com.aluracursos.screenmatch.service.consumoAPIService;
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
        var consumoAPIService = new consumoAPIService();
        var json = consumoAPIService.obtenerDatos("http://www.omdbapi.com/?t=game+of+thrones&apikey=a1de3692");
        System.out.println(json);
    }
}

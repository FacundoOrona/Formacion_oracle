package com.aluracursos.desafioBooks;

import com.aluracursos.desafioBooks.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioBooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBooksApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.muestraMenu();
    }
}

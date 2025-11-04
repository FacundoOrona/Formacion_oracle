package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnConversionDuracionException;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusquedaAPI {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        List<Titulo> listaTitulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escriba el nombre la pelicula que desee buscar");
            var busqueda = scanner.nextLine();

            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }

            String direccion = "https://www.omdbapi.com/?t=" +
                    busqueda.replace(" ","+") +
                    "&apikey=a1de3692";

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                //System.out.println(json);


                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                //System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                listaTitulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error: NumberFormatException");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Ocurrio un error: IllegalArgumentException");
                System.out.println(e.getMessage());
            } catch (ErrorEnConversionDuracionException e) {
                System.out.println(e.getMessage() );
            }
        }

        System.out.println(listaTitulos);

        FileWriter escritura = new FileWriter("Peliculas.json");
        escritura.write(gson.toJson(listaTitulos));
        escritura.close();

        System.out.println("**********************");
        System.out.println("Finalizo la ejecucion");
        System.out.println("**********************");

    }

}

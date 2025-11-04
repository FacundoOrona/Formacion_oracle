package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusquedaAPI {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el nombre la pelicula que desee buscar");
        var busqueda = scanner.nextLine();
        scanner.close();

        String direccion = "https://www.omdbapi.com/?t=" + busqueda + "&apikey=a1de3692";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(miTituloOmdb);

            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Titulo ya convertido: " + miTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Ocurrio un error: NumberFormatException");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ocurrio un error: IllegalArgumentException");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un erro inesperado");
            System.out.println(e.getMessage() );
        }

        System.out.println("Finalizo la ejecucion");

    }

}

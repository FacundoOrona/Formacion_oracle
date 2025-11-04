import modelos.Pelicula;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;


public class FetchAPI {

    public Pelicula buscarPelicula (int numeroDePelicula) {

        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+numeroDePelicula+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No se encontro la pelicula deseada");
        }

        return new Gson().fromJson(response.body(), Pelicula.class);
    }
}

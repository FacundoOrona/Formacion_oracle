import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.Pelicula;

import java.io.FileWriter;
import java.io.IOException;

public class ArchiveGenerator {

    public void guardarJson (Pelicula pelicula) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting().
                create();

        FileWriter archivo = new FileWriter(pelicula.title() + ".json");

        archivo.write(gson.toJson(pelicula));
        archivo.close();
    }

}

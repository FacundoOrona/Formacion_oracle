import modelos.Pelicula;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el numero de la pelicula de Star Wars que desee obtener informacion");

        FetchAPI consulta = new FetchAPI();

        try {
            int numeroDePelicula = scanner.nextInt();
            Pelicula pelicula = consulta.buscarPelicula(numeroDePelicula);

            System.out.println(pelicula);

            ArchiveGenerator generator = new ArchiveGenerator();
            generator.guardarJson(pelicula);

        } catch (NumberFormatException e) {
            System.out.println("Numero no encontrado");
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
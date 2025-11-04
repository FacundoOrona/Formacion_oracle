import modelos.Pelicula;

public class Main {
    public static void main(String[] args) {
        FetchAPI consulta = new FetchAPI();

        Pelicula pelicula = consulta.buscarPelicula(1);

        System.out.println(pelicula);
    }
}
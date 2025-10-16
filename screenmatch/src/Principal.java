public class Principal {

    public static void main(String[] args) {

        Pelicula pelicula = new Pelicula();
        pelicula.nombre = "Encanto";
        pelicula.fechaLanzamiento = 2021;
        pelicula.duracionMinutos = 120;
        pelicula.incluidoPlan = true;

        pelicula.muestraPelicula();

        Pelicula pelicula2 = new Pelicula();
        pelicula2.nombre = "Encanto2";
        pelicula2.fechaLanzamiento = 2021;
        pelicula2.duracionMinutos = 120;
        pelicula2.incluidoPlan = true;

        pelicula2.muestraPelicula();
        pelicula2.evaluarPelicula(2.2);
        pelicula2.evaluarPelicula(9.2);
        pelicula2.evaluarPelicula(8.2);
        pelicula2.evaluarPelicula(8.3);
        pelicula2.promedioNotasPelicula();
    }

}

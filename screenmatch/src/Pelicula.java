public class Pelicula {

    String nombre;
    int fechaLanzamiento;
    int duracionMinutos;
    boolean incluidoPlan;
    double sumaNotas;
    static double mediaNotas;



    void muestraPelicula() {
        System.out.println("Mi pelicula es: " + nombre);
    }

    void evaluarPelicula(double nota) {
        sumaNotas += nota;
        mediaNotas++;

    }

    void promedioNotasPelicula() {
        System.out.println("Nota promedio final: " + sumaNotas/mediaNotas);
    }

}

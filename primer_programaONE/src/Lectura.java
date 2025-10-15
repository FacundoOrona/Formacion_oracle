import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe el nombre de tu pelicula favorita");
        String peliculaNombre = teclado.nextLine();
        System.out.println("Ingrese la fecha de lanzamiento:");
        int fechaLanzamiento = teclado.nextInt();
        System.out.println("Ingrese nota: ");
        double notaPelicula = teclado.nextDouble();

        System.out.println("Nombre: " + peliculaNombre);
        System.out.println("Fecha de lanzamiento: " + fechaLanzamiento);
        System.out.println("Nota de pelicula: " + notaPelicula);

        teclado.close();
    }

}

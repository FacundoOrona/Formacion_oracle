import java.util.Scanner;

public class Loops {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double notaInicial = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Califica la pelicula Matrix: ");
            double nota = teclado.nextDouble();
            notaInicial = notaInicial + nota;
        }
    }

}

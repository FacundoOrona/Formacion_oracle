import java.util.Scanner;

public class Evaluaciones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double nota = 0;
        double notaPromedio = 0;
        int cantNotas = 0;

        while (nota != -1 ){
            System.out.println("Califica la pelicula Matrix: ");
            nota = teclado.nextDouble();
            notaPromedio = notaPromedio + nota;
            cantNotas++;
        }

        double notaFinal = notaPromedio / cantNotas;
        System.out.println("Nota final de Matrix: " + notaFinal );
    }

}

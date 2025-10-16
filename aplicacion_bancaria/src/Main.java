import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double saldo = 0;
        int opcion;

        System.out.println("Nombre del cliente: Facundo");
        System.out.println("Tipo de cuenta: Corriente");
        System.out.println("Saldo disponible: $" + saldo);

        do {
            System.out.println("""
                    *****************************************
                    Ingrese el número de la opción que quiera accionar:
                    1 - Consultar saldo
                    2 - Retirar
                    3 - Depositar
                    4 - Salir
                    *****************************************
                    """);

    }
}
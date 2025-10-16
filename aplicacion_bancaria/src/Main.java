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

            System.out.print("Opción: ");
            opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nElegiste la Opción 1 - Consultar saldo");
                    System.out.println("Saldo disponible: $" + saldo);
                    break;

                case 2:
                    System.out.println("\nElegiste la Opción 2 - Retirar");
                    System.out.print("Ingrese monto que quiera retirar: $");
                    double retiro = s.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("Fondos insuficientes. Saldo actual: $" + saldo);
                    } else {
                        saldo -= retiro;
                        System.out.println("Usted retiró $" + retiro);
                        System.out.println("Saldo restante: $" + saldo);
                    }
                    break;
    }
}
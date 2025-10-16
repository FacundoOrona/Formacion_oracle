public class Decision {

    public static void main(String[] args) {
        int fechaDeLanzamiento = 2024;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.1;
        double media = (8.1 + 8.6 + 1.0 + notaPelicula) / 3;
        String tipoPlan = "plus";

//        if (fechaDeLanzamiento > 2022) {
//            System.out.println("Peliculas recientes");
//        } else {
//            System.out.println("Pelicula antigua");
//        }

        if (incluidoEnElPlan || tipoPlan.equals("plus")) {
            System.out.println("Esta incluida en el plan o es plus");
        }else {
            System.out.println("No esta incluida en el plan");
        }
    }
}

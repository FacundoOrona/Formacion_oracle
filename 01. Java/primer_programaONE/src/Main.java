public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a Screen Match");
        System.out.println("Pelicula: Matrix");

        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaPelicula = 8.1;
        double media = (8.1 + 8.6 + 1.0 + notaPelicula) / 3;
        System.out.println("Media: " + media);

        String sinopsis = """
                Sinopsis de Matrix (1999):
                Thomas Anderson, un programador de computadoras que lleva una vida doble como hacker bajo el alias Neo, comienza a sospechar que el mundo que lo rodea no es lo que parece. Su vida cambia por completo cuando conoce a Morfeo y Trinity, quienes le revelan una impactante verdad: la realidad que conoce es una simulación virtual llamada Matrix, creada por máquinas inteligentes para mantener a la humanidad bajo control mientras usan sus cuerpos como fuente de energía.                
                Decidido a descubrir la verdad y liberar a la humanidad, Neo se une a la resistencia y enfrenta una lucha épica contra los agentes del sistema, especialmente el implacable Agente Smith. En el proceso, deberá aceptar su destino como El Elegido, capaz de alterar las reglas de la Matrix y desafiar el dominio de las máquinas.    
                Matrix combina acción, filosofía y ciencia ficción en una historia que cuestiona la realidad, la libertad y el poder de la mente.
                """+ "Fue lanzada en: " + fechaDeLanzamiento;

        System.out.println(sinopsis);

        if (incluidoEnElPlan) {
            System.out.println("Esta incluida en el plan");
        }else {
            System.out.println("No esta incluida en el plan");
        }

        //casteo explicito
        int clasificacion = (int) (media / 2);
        System.out.println("Clasificacion: " + clasificacion);
    }
}
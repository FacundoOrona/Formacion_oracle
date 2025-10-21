import com.facundo.screenmatch.calculos.CalculadoraTiempo;
import com.facundo.screenmatch.calculos.FiltroRecomendacion;
import com.facundo.screenmatch.modelos.Pelicula;
import com.facundo.screenmatch.modelos.Serie;

public class Principal {

    public static void main(String[] args) {

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre("Encanto");
        pelicula.setFechaLanzamiento(2021);
        pelicula.setDuracionMinutos(120);
        pelicula.setIncluidoPlan(true);

        pelicula.muestraPelicula();

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setNombre("Encanto2");
        pelicula2.setFechaLanzamiento(2021);
        pelicula2.setDuracionMinutos(120);
        pelicula2.setIncluidoPlan(true);

        //pelicula2.muestraPelicula();

        pelicula2.evaluarPelicula(2.2);
        pelicula2.evaluarPelicula(9.2);
        pelicula2.evaluarPelicula(8.2);
        pelicula2.evaluarPelicula(8.3);

        pelicula2.promedioNotasPelicula();
        //pelicula2.promedioNotasPelicula();

        Serie serie = new Serie();
        serie.setNombre("Casa del Dragon");
        serie.setTemporadas(1);
        serie.setEpisidosPorTemporada(15);
        serie.setDuracionMinutos(106);

        //System.out.println(serie.getDuracionMinutos());

        CalculadoraTiempo calculadoraTiempo = new CalculadoraTiempo();
        calculadoraTiempo.incluye(pelicula);
        calculadoraTiempo.incluye(pelicula2);
        calculadoraTiempo.incluye(serie);
    }

}

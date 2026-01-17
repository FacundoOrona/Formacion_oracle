package med.vol.api.validaciones;

import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidarFueraDelHorarioConsultas implements ValidadorDeConsultas {

    public void validar (DatosReservaConsulta datos) {

        var fechaConsulta = datos.fecha();
        //consulta si es domingo (SUNDAY) devuelve true, si no es domingo, devuelve false.
        var domingo = fechaConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        //consulta si es menor a las 7am horario de apertura, si es menor true, si es mayor false.
        var horarioAntesDeApertura = fechaConsulta.getHour() < 7;
        //consulta si es mayor al horario de cierre (19:00, pero las consultas duran 1hr max
        //asi que 18hs seria el maximo.
        var horarioDespuesDeCierre = fechaConsulta.getHour() > 18;

        if (domingo || horarioAntesDeApertura || horarioDespuesDeCierre) {
            throw new ValidationException("Horario seleccionado fuera del rango de atencion");
        }



    }
}

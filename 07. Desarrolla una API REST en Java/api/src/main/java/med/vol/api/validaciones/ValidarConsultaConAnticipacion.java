package med.vol.api.validaciones;

import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosReservaConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarConsultaConAnticipacion implements ValidadorDeConsultas {

    public void validar (DatosReservaConsulta datos) {
        var ahora = LocalDateTime.now();
        var fechaConsulta = datos.fecha();
        var diferenciaEnMinutos = Duration.between(ahora, fechaConsulta).toMinutes();

        if(diferenciaEnMinutos < 30) {
            throw new ValidationException("Horario seleccionado con menos de 30 minutos de anticipacion");
        }
    }
}

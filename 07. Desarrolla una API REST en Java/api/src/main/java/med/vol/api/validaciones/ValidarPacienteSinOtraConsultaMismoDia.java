package med.vol.api.validaciones;

import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.repository.ConsultaRepository;
import med.vol.api.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteSinOtraConsultaMismoDia implements ValidadorDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {
        var primerHorario = datos.fecha().withHour(7);
        var ultimoHorario = datos.fecha().withHour(18);
        var pacienteTieneOtraConsultaEnElDia = consultaRepository.
                existsByPacienteIdAndFechaBetween(datos.idPaciente(),
                primerHorario,
                ultimoHorario);

        if (pacienteTieneOtraConsultaEnElDia) {
            throw new ValidationException("Paciente ya tiene una consulta medica ese mismo dia");
        }
    }
}

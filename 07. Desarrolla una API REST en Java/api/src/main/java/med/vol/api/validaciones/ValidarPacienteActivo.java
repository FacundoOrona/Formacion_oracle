package med.vol.api.validaciones;

import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.model.Paciente;
import med.vol.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteActivo implements ValidadorDeConsultas {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosReservaConsulta datos) {
        if (datos.idPaciente() == null) {
            return;
        }
        Paciente paciente = pacienteRepository.findById(datos.idPaciente())
                .orElseThrow(() -> new ValidationException("Paciente no encontrado"));

        if (!Boolean.TRUE.equals(paciente.getActivo())) {
            throw new ValidationException("Consulta no puede ser reservada con paciente excluido");
        }
    }


}

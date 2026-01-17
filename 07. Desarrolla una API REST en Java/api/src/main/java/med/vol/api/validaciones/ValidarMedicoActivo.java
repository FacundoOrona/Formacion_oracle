package med.vol.api.validaciones;

import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarMedicoActivo implements ValidadorDeConsultas {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DatosReservaConsulta datos) {
        if (datos.idMedico() == null) {
            return;
        }
        var medico = medicoRepository.findById(datos.idMedico()).orElseThrow(() -> new ValidationException("Médico no encontrado"));
        Boolean activo = medico.getActivo();
        if (!Boolean.TRUE.equals(activo)) {
            throw new ValidationException("La consulta no puede realizarse con un médico excluido");
        }

    }
}

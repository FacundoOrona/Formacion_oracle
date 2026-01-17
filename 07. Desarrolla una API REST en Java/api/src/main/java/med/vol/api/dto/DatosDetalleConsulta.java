package med.vol.api.dto;

import med.vol.api.model.Consulta;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime fecha
) {
    public DatosDetalleConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(),
                consulta.getPaciente().getId(),
                consulta.getFecha());
    }
}

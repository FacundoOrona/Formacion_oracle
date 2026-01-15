package med.vol.api.dto;

import med.vol.api.model.Especialidad;
import med.vol.api.model.Medico;

public record DatosListaMedico(
        Long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    public DatosListaMedico(Medico medico) {
        this(   medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }
}

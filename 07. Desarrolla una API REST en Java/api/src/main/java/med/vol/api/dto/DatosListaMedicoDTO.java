package med.vol.api.dto;

import med.vol.api.model.Especialidad;
import med.vol.api.model.Medico;

public record DatosListaMedicoDTO(
        Long id,
        String nombre,
        String email,
        String documento,
        Especialidad especialidad
) {
    public DatosListaMedicoDTO(Medico medico) {
        this(   medico.getId(),
                medico.getNombre(),
                medico.getEmail(),
                medico.getDocumento(),
                medico.getEspecialidad());
    }
}

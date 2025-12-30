package med.vol.api.dto;

import med.vol.api.model.Especialidad;

public record DatosRegistroMedicoDTO(
        String nombre,
        String email,
        String documento,
        Especialidad especialidad,
        DireccionDTO direccion
) {
}

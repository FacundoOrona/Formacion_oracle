package med.vol.api.dto;

import jakarta.validation.constraints.NotNull;

public record DatosActulizarMedicoDTO(
        @NotNull
        Long id,
        String nombre,
        String telefono,
        DatosDireccion direccion
) {
}

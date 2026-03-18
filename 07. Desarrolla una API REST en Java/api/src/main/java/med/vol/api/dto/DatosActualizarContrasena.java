package med.vol.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarContrasena(
        @NotBlank
        String contrasenaActual,
        @NotBlank
        String contrasenaNueva
) {
}

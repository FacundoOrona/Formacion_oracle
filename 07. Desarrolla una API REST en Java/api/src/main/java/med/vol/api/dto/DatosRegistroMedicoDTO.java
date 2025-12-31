package med.vol.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.model.Especialidad;

public record DatosRegistroMedicoDTO(
        @NotBlank
        String nombre,
        @NotBlank @Email
        String email,
        @NotBlank String telefono,
        @NotBlank @Pattern(regexp = "\\d{7,9}")
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull @Valid
        DatosDireccion direccion
) {
}

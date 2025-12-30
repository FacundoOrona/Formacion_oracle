package med.vol.api.dto;

import jakarta.persistence.Embeddable;

@Embeddable
public record DatosDireccion(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String codigo_postal,
        String ciudad,
        String estado
) {
}

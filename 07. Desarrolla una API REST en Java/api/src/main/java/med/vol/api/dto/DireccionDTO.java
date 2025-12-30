package med.vol.api.dto;

public record DireccionDTO(
        String calle,
        String numero,
        String complemento,
        String barrio,
        String codigo_postal,
        String ciudad,
        String estado
) {
}

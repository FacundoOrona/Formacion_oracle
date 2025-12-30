package med.vol.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.vol.api.dto.DatosDireccion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String numero;
    private String complemento;
    private String barrio;
    private String codigo_postal;
    private String ciudad;
    private String estado;

    public Direccion(DatosDireccion direccion) {
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
        this.barrio = direccion.barrio();
        this.ciudad = direccion.ciudad();
        this.codigo_postal = direccion.codigo_postal();
        this.estado = direccion.estado();
    }
}

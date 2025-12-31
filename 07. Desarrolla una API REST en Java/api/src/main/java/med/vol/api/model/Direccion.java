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

    public void actualizarDireccion(DatosDireccion direccion) {
        if (direccion.calle() != null) {
            this.calle = direccion.calle();
        }
        if (direccion.numero() != null) {
            this.numero = direccion.numero();
        }
        if (direccion.complemento() != null) {
            this.complemento = direccion.complemento();
        }
        if (direccion.barrio() != null) {
            this.barrio = direccion.barrio();
        }
        if (direccion.ciudad() != null) {
            this.ciudad = direccion.ciudad();
        }
        if (direccion.codigo_postal() != null) {
            this.codigo_postal = direccion.codigo_postal();
        }
        if (direccion.estado() != null) {
            this.estado = direccion.estado();
        }
    }
}

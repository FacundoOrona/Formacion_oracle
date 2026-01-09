package med.vol.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuarios")
@Entity(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100, message = "El login no puede superar 100 caracteres")
    @Column(name = "login", length = 100, nullable = false, unique = true)
    private String login;

    @Size(max = 255, message = "La contraseña no puede superar 255 caracteres")
    @Column(name = "contrasena", length = 255, nullable = false)
    private String contrasena;
}

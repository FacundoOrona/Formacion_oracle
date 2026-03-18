package med.vol.api.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import med.vol.api.dto.DatosActualizarContrasena;
import med.vol.api.model.Usuario;
import med.vol.api.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioController(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PutMapping("/contrasena")
    @Transactional
    public ResponseEntity actualizarContrasena(@AuthenticationPrincipal Usuario usuarioAutenticado,
                                               @RequestBody @Valid DatosActualizarContrasena datos) {
        var usuario = usuarioRepository.getReferenceById(usuarioAutenticado.getId());

        if (!passwordEncoder.matches(datos.contrasenaActual(), usuario.getContrasena())) {
            throw new ValidationException("La contraseña actual es incorrecta");
        }

        usuario.setContrasena(passwordEncoder.encode(datos.contrasenaNueva()));

        return ResponseEntity.noContent().build();
    }
}

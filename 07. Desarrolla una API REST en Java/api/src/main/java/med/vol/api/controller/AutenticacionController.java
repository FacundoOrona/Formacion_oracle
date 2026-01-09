package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosAutenticacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    private final AuthenticationManager manager;

    public AutenticacionController(AuthenticationManager manager) {
        this.manager = manager;
    }

    @PostMapping("/login")
    public ResponseEntity iniciarSesion(@Valid @RequestBody DatosAutenticacionDTO datos) {

        var token = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var auth = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}

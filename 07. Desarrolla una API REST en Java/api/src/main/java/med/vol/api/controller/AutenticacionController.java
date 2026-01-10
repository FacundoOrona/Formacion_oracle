package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosAutenticacionDTO;
import med.vol.api.dto.DatosTokenJWTDTO;
import med.vol.api.infra.security.TokenService;
import med.vol.api.model.Usuario;
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

    private final TokenService tokenService;
    private final AuthenticationManager manager;

    public AutenticacionController(AuthenticationManager manager,
                                   TokenService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity iniciarSesion(@Valid @RequestBody DatosAutenticacionDTO datos) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWTDTO(tokenJWT));
    }
}

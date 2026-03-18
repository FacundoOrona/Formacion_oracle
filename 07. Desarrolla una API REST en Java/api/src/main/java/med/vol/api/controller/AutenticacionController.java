package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosAutenticacion;
import med.vol.api.dto.DatosListadoPaciente;
import med.vol.api.dto.DatosRegistroPaciente;
import med.vol.api.dto.DatosTokenJWT;
import med.vol.api.infra.security.TokenService;
import med.vol.api.model.Paciente;
import med.vol.api.model.Usuario;
import med.vol.api.repository.PacienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    private final TokenService tokenService;
    private final AuthenticationManager manager;
    private final PacienteRepository pacienteRepository;

    public AutenticacionController(AuthenticationManager manager,
                                   TokenService tokenService,
                                   PacienteRepository pacienteRepository) {
        this.manager = manager;
        this.tokenService = tokenService;
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping("/login")
    public ResponseEntity iniciarSesion(@Valid @RequestBody DatosAutenticacion datos) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(datos.login(), datos.contrasena());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

    @PostMapping("/pacientes")
    @Transactional
    public ResponseEntity registrarPaciente(@Valid @RequestBody DatosRegistroPaciente datos,
                                            UriComponentsBuilder uriComponentsBuilder) {
        var paciente = new Paciente(datos);
        pacienteRepository.save(paciente);
        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosListadoPaciente(paciente));
    }
}

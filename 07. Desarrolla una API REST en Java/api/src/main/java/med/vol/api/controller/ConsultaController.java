package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosDetalleConsulta;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.service.ConsultasService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultasService service;

    public ConsultaController(ConsultasService consultasService) {
        this.service = consultasService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity reservar(@RequestBody @Valid DatosReservaConsulta datos) {
        service.reservar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null, null, null));
    }
}

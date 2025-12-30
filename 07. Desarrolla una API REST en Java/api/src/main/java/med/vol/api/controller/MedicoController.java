package med.vol.api.controller;

import med.vol.api.dto.DatosRegistroMedicoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void registar(@RequestBody DatosRegistroMedicoDTO datos) {

    }


}

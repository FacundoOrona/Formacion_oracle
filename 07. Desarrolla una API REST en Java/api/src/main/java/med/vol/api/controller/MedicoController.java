package med.vol.api.controller;

import med.vol.api.dto.DatosRegistroMedicoDTO;
import med.vol.api.model.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    public void registar(@RequestBody DatosRegistroMedicoDTO datos) {
        medicoRepository.save(new Medico(datos));
    }


}

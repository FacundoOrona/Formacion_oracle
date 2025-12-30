package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosRegistroMedicoDTO;
import med.vol.api.model.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    @PostMapping
    public void registar(@RequestBody @Valid DatosRegistroMedicoDTO datos) {
        medicoRepository.save(new Medico(datos));
    }


}

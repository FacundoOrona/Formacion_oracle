package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosActulizarMedicoDTO;
import med.vol.api.dto.DatosListaMedicoDTO;
import med.vol.api.dto.DatosRegistroMedicoDTO;
import med.vol.api.model.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /// medicos?size=10&page=1
    @GetMapping
    public Page<DatosListaMedicoDTO> listar(@PageableDefault(size = 10, page = 0,
                                                sort = {"nombre"})
                                                Pageable paginacion) {
        return medicoRepository.findAll(paginacion).map(DatosListaMedicoDTO::new);
    }

    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActulizarMedicoDTO datos) {
        var medico = medicoRepository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);
    }

}

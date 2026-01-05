package med.vol.api.controller;

import jakarta.validation.Valid;
import med.vol.api.dto.DatosActulizarMedicoDTO;
import med.vol.api.dto.DatosDetalleMedico;
import med.vol.api.dto.DatosListaMedicoDTO;
import med.vol.api.dto.DatosRegistroMedicoDTO;
import med.vol.api.model.Medico;
import med.vol.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity registar(@RequestBody @Valid DatosRegistroMedicoDTO datos) {
        medicoRepository.save(new Medico(datos));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaMedicoDTO>> listar(@PageableDefault(size = 10, page = 0,
                                                sort = {"nombre"})
                                                Pageable paginacion) {
        var page = medicoRepository.findAllByActivoTrue(paginacion).map(DatosListaMedicoDTO::new);

        return ResponseEntity.ok(page); //200
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActulizarMedicoDTO datos) {
        var medico = medicoRepository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosDetalleMedico(medico));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity darBaja(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.darBaja();

        return ResponseEntity.noContent().build(); //204
    }

}

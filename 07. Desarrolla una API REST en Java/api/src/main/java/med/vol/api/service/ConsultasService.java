package med.vol.api.service;

import jakarta.persistence.EntityNotFoundException;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.model.Consulta;
import med.vol.api.model.Especialidad;
import med.vol.api.model.Medico;
import med.vol.api.model.Paciente;
import med.vol.api.repository.ConsultaRepository;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultasService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public void reservar (DatosReservaConsulta datos) {
        Medico medico = medicoRepository.findById(datos.idMedico())
                .orElseThrow(()-> new EntityNotFoundException("Medico no encontrado con ID: "+datos.idMedico()));
        Paciente paciente = pacienteRepository.findById(datos.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente no encontrado con ID: "+datos.idPaciente()));
        Especialidad especialidad = datos.especialidad();

        var consulta = new Consulta(null, medico, paciente, datos.fecha(), especialidad);

        consultaRepository.save(consulta);
    }
}

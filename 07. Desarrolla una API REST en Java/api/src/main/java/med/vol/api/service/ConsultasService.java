package med.vol.api.service;

import jakarta.persistence.EntityNotFoundException;
import med.vol.api.dto.DatosDetalleConsulta;
import med.vol.api.dto.DatosReservaConsulta;
import med.vol.api.model.Consulta;
import med.vol.api.model.Especialidad;
import med.vol.api.model.Medico;
import med.vol.api.model.Paciente;
import med.vol.api.repository.ConsultaRepository;
import med.vol.api.repository.MedicoRepository;
import med.vol.api.repository.PacienteRepository;
import med.vol.api.validaciones.ValidadorDeConsultas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultasService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final List<ValidadorDeConsultas> validadores;

    public ConsultasService(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository, List<ValidadorDeConsultas> validadorDeConsultas) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
        this.validadores = validadorDeConsultas;
    }

    public DatosDetalleConsulta reservar (DatosReservaConsulta datos) {

        //Hacemos un for each por la lista de clases que implementan la interfaz de validaciones,
        //que todos unan la funcion validar()
        validadores.forEach(v -> v.validar(datos));

        Medico medico = medicoRepository.findById(datos.idMedico())
                .orElseThrow(()-> new EntityNotFoundException("Medico no encontrado con ID: "+datos.idMedico()));
        Paciente paciente = pacienteRepository.findById(datos.idPaciente())
                .orElseThrow(() -> new EntityNotFoundException("Paciente no encontrado con ID: "+datos.idPaciente()));

        var consulta = new Consulta(null, medico, paciente, datos.fecha());

        consultaRepository.save(consulta);

        return new DatosDetalleConsulta(consulta);
    }
}

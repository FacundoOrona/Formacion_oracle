package med.vol.api.repository;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.vol.api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta,Long> {

    boolean existsByPacienteIdAndFechaBetween(Long idPaciente,
                                              LocalDateTime primerHorario,
                                              LocalDateTime ultimoHorario);

    boolean existsByMedicoIdAndFecha(Long idMedico,LocalDateTime fecha);
}

package med.vol.api.dto;

import med.vol.api.model.Paciente;

public record DatosListadoPaciente(Long id, String nombre, String email, String documento) {

    public DatosListadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNombre(), paciente.getEmail(), paciente.getDocumento());
    }
}

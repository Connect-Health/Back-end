package br.com.doctordevs.connecthealth.dto;

import br.com.doctordevs.connecthealth.model.Paciente;

public class PacienteLoginDTO {

    private boolean success;
    private Paciente paciente;

    public PacienteLoginDTO(boolean success, Paciente paciente) {
        this.success = success;
        this.paciente = paciente;
    }

    public boolean isSuccess() {
        return success;
    }

    public Paciente getPaciente() {
        return paciente;
    }

}

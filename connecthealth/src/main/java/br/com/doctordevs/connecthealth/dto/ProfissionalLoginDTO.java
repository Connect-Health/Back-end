package br.com.doctordevs.connecthealth.dto;

import br.com.doctordevs.connecthealth.model.Profissional;

public class ProfissionalLoginDTO {

    private boolean success;
    private Profissional profissional;

    public ProfissionalLoginDTO(boolean success, Profissional profissional) {
        this.success = success;
        this.profissional = profissional;
    }

    public boolean isSuccess() {
        return success;
    }

    public Profissional getProfissional() {
        return profissional;
    }
}

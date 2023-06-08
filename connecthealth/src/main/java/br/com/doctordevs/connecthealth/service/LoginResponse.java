package br.com.doctordevs.connecthealth.service;

import br.com.doctordevs.connecthealth.model.Profissional;

public class LoginResponse {
    private boolean authenticated;
    private Profissional profissional;

    public LoginResponse(boolean authenticated, Profissional profissional) {
        this.authenticated = authenticated;
        this.profissional = profissional;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public Profissional getProfissional() {
        return profissional;
    }
}
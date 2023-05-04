package br.com.doctordevs.connecthealth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }
}

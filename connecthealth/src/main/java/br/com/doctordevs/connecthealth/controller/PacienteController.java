package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.service.PacienteService;

@RestController
@CrossOrigin(origins = "*")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public List<Paciente> listarTodos() {
        return pacienteService.listarTodos();
    }
}

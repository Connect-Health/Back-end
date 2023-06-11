package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.dto.PacienteLoginDTO;
import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.service.PacienteService;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping
    public List<Paciente> getAllPaciente() {
        return pacienteService.getAllPaciente();
    }

    @GetMapping("/{pacienteId}")
    public Paciente getPaciente(@PathVariable("pacienteId") int pacienteId) {
        return pacienteService.getPacienteId(pacienteId);

    }

    @DeleteMapping("/{pacienteId}")
    private void deletePaciente(@PathVariable("pacienteId") int pacienteId) {
        pacienteService.delete(pacienteId);
    }

    @PostMapping
    private String savePaciente(@RequestBody Paciente paciente) {
        if (pacienteService.existsByEmail(paciente.getEmail())) {
            Error error = new Error("Email já cadastrado");
            return error.getMessage();
        }

        if (pacienteService.existsByCpf(paciente.getCpf())) {
            Error error = new Error("CPF já cadastrado");
            return error.getMessage();
        }

        if (pacienteService.existsByTelefone(paciente.getTelefone())) {
            Error error = new Error("Telefone já cadastrado");
            return error.getMessage();
        }

        String senhaCriptografada = encoder.encode(paciente.getSenha());
        paciente.setSenha(senhaCriptografada);
        pacienteService.save(paciente);
        return "Paciente cadastrado com sucesso, O ID do paciente é: " + paciente.getPacienteId();
    }

    @PostMapping("/login")
    private PacienteLoginDTO login(@RequestBody Paciente paciente) {
        String email = paciente.getEmail();
        String senha = paciente.getSenha();

        Paciente pacienteEncontrado = pacienteService.findByEmail(email);

        if (pacienteEncontrado != null && encoder.matches(senha, pacienteEncontrado.getSenha())) {
            return new PacienteLoginDTO(true, pacienteEncontrado);
        }

        return new PacienteLoginDTO(false, null);
    }

    @PutMapping
    private Paciente update(@RequestBody Paciente paciente) {
        String senhaCriptografada = encoder.encode(paciente.getSenha());
        paciente.setSenha(senhaCriptografada);
        pacienteService.save(paciente);
        return paciente;
    }

}

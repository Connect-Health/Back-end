package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Paciente;
import br.com.doctordevs.connecthealth.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> getAllPaciente() {
        List<Paciente> paciente = new ArrayList<Paciente>();
        pacienteRepository.findAll().forEach(paciente1 -> paciente.add(paciente1));
        return paciente;
    }

    public Paciente getPacienteId(int pacienteId) {
        return pacienteRepository.findById(pacienteId).get();
    }

    public void delete(int pacienteId) {
        pacienteRepository.deleteById(pacienteId);
    }

    public void save(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public void update(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    public boolean login(String email, String senha) {
        Paciente paciente = pacienteRepository.findByEmail(email);
        if (paciente != null) {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.matches(senha, paciente.getSenha());
        }
        return false;
    }

    public boolean existsByEmail(String email) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByCpf(String cpf) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByTelefone(String telefone) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getTelefone().equals(telefone)) {
                return true;
            }
        }
        return false;
    }

    public Paciente findByEmail(String email) {
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getEmail().equals(email)) {
                return paciente;
            }
        }
        return null;
    }
}

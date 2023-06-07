package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    @Autowired
    ProfissionalRepository profissionalRepository;

    public List<Profissional> getAllProfissional() {
        List<Profissional> profissional = new ArrayList<Profissional>();
        profissionalRepository.findAll().forEach(profissional1 -> profissional.add(profissional1));
        return profissional;
    }

    public Profissional getProfissionalId(int profissionalId) {
        return profissionalRepository.findById(profissionalId).get();
    }

    public List<Profissional> getAllPsicologos() {
        List<Profissional> psicologos = new ArrayList<>();
        List<Profissional> profissionais = profissionalRepository.findAll();
        for (Profissional profissional : profissionais) {
            if (profissional.getAreaAtuacao().getAreaId() == 1) {
                psicologos.add(profissional);
            }
        }
        return psicologos;
    }

    public List<Profissional> getAllNutricionistas() {
        List<Profissional> nutricionistas = new ArrayList<>();
        List<Profissional> profissionais = profissionalRepository.findAll();
        for (Profissional profissional : profissionais) {
            if (profissional.getAreaAtuacao().getAreaId() == 2) {
                nutricionistas.add(profissional);
            }
        }
        return nutricionistas;
    }

    public void delete(int profissionalId) {
        profissionalRepository.deleteById(profissionalId);
    }

    public void save(Profissional profissional) {
        profissionalRepository.save(profissional);
    }

    public void update(Profissional profissional, int profissionalId) {
        profissionalRepository.save(profissional);
    }

    public boolean login(String email, String senha) {
        Profissional profissional = profissionalRepository.findByEmail(email);
        if (profissional != null) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.matches(senha, profissional.getSenha());
        }
        return false;
    }

    public boolean existsByEmail(String email) {
        List<Profissional> profissionais = profissionalRepository.findAll();
        for (Profissional profissional : profissionais) {
            if (profissional.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByCpf(String cpf) {
        List<Profissional> profissionais = profissionalRepository.findAll();
        for (Profissional profissional : profissionais) {
            if (profissional.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsByUrlCertificado(String urlCertificado) {
        List<Profissional> profissionais = profissionalRepository.findAll();
        for (Profissional profissional : profissionais) {
            if (profissional.getUrlCertificado().equals(urlCertificado)) {
                return true;
            }
        }
        return false;
    }

    public Profissional findByEmail(String email) {
        return profissionalRepository.findByEmail(email);
    }
}

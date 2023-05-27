package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
}

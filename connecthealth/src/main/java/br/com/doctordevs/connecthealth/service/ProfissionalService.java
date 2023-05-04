package br.com.doctordevs.connecthealth.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    @Autowired
    public ProfissionalService(ProfissionalRepository profissionalRepository) {
        this.profissionalRepository = profissionalRepository;
    }

    public List<Profissional> listarProfissionais() {
        return profissionalRepository.getProfissionais();
    }

    public Optional<Profissional> buscarProfissionalPorId(int id) {
        return profissionalRepository.getProfissionais().stream()
                .filter(profissional -> profissional.getId() == id)
                .findFirst();
    }

    public List<Profissional> buscarProfissionaisPorEspecialidade(String especialidade) {
        return profissionalRepository.getProfissionais().stream()
                .filter(profissional -> profissional.getEspecialidade().contains(especialidade))
                .toList();
    }

    public List<Profissional> buscarProfissionaisPorAvaliacao(double avaliacao) {
        return profissionalRepository.getProfissionais().stream()
                .filter(profissional -> profissional.getAvaliacao() >= avaliacao)
                .toList();
    }

    public List<Profissional> buscarNutricionistas() {
        return profissionalRepository.getNutricionistas();
    }

    public List<Profissional> buscarPsicologos() {
        return profissionalRepository.getPsicologos();
    }
}

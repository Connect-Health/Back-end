package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Especialidade;
import br.com.doctordevs.connecthealth.repository.EspecialidadeRepository;

@Service
public class EspecialidadeService {

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    public List<Especialidade> getAllEspecialidade() {
        List<Especialidade> especialidade = new ArrayList<Especialidade>();
        especialidadeRepository.findAll().forEach(especialidade1 -> especialidade.add(especialidade1));
        return especialidade;
    }

    public Especialidade getEspecialidadeId(int especialidadeId) {
        return especialidadeRepository.findById(especialidadeId).get();
    }

    public void delete(int especialidadeId) {
        especialidadeRepository.deleteById(especialidadeId);
    }

    public void save(Especialidade especialidade) {
        especialidadeRepository.save(especialidade);
    }

    public void update(Especialidade especialidade, int especialidadeId) {
        especialidadeRepository.save(especialidade);
    }
}

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

    public List<Especialidade> getEspecialidadePsicologia() {
        List<Especialidade> especialidadePsicologia = new ArrayList<>();
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        for (Especialidade especialidade : especialidades) {
            if (especialidade.getArea().getAreaId() == 1) {
                especialidadePsicologia.add(especialidade);
            }
        }
        return especialidadePsicologia;
    }

    public List<Especialidade> getEspecialidadeNutricao() {
        List<Especialidade> especialidadeNutricao = new ArrayList<>();
        List<Especialidade> especialidades = especialidadeRepository.findAll();
        for (Especialidade especialidade : especialidades) {
            if (especialidade.getArea().getAreaId() == 2) {
                especialidadeNutricao.add(especialidade);
            }
        }
        return especialidadeNutricao;
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

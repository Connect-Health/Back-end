package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.Especialidade;
import br.com.doctordevs.connecthealth.service.EspecialidadeService;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin(origins = "*")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService especialidadeService;

    @GetMapping
    public List<Especialidade> getAllEspecialidade() {
        return especialidadeService.getAllEspecialidade();
    }

    @GetMapping("/{especialidadeId}")
    public Especialidade getEspecialidade(@PathVariable("especialidadeId") int especialidadeId) {
        return especialidadeService.getEspecialidadeId(especialidadeId);
    }

    @GetMapping("/psicologia")
    public List<Especialidade> getEspecialidadePsicologia() {
        return especialidadeService.getEspecialidadePsicologia();
    }

    @GetMapping("/nutricao")
    public List<Especialidade> getEspecialidadeNutricao() {
        return especialidadeService.getEspecialidadeNutricao();
    }

    @DeleteMapping("/{especialidadeId}")
    private void deleteEspecialidade(@PathVariable("especialidadeId") int especialidadeId) {
        especialidadeService.delete(especialidadeId);
    }

    @PostMapping
    private int saveEspecialidade(Especialidade especialidade) {
        especialidadeService.save(especialidade);
        return especialidade.getEspecialidadeId();
    }

    @PutMapping
    private Especialidade update(Especialidade especialidade) {
        especialidadeService.save(especialidade);
        return especialidade;
    }

}

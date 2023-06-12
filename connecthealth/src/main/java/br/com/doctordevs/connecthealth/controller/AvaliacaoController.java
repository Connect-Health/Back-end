package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.Avaliacao;
import br.com.doctordevs.connecthealth.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> getAllAvaliacao() {
        return avaliacaoService.getAllAvaliacao();
    }

    @GetMapping("/{avaliacaoId}")
    public Avaliacao getAvaliacao(@PathVariable("avaliacaoId") int avaliacaoId) {
        return avaliacaoService.getAvaliacaoId(avaliacaoId);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Avaliacao> getAvaliacaoByPaciente(@PathVariable("pacienteId") int pacienteId) {
        return avaliacaoService.getAvaliacaoByPaciente(pacienteId);
    }

    @GetMapping("/profissional/{profissionalId}")
    public List<Avaliacao> getAvaliacaoByProfissional(@PathVariable("profissionalId") int profissionalId) {
        return avaliacaoService.getAvaliacaoByProfissional(profissionalId);
    }

    @DeleteMapping("/{avaliacaoId}")
    private void deletePaciente(@PathVariable("avaliacaoId") int avaliacaoId) {
        avaliacaoService.delete(avaliacaoId);
    }

    @PostMapping
    private int saveAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.save(avaliacao);
        return avaliacao.getAvaliacaoId();
    }

    @PutMapping
    private Avaliacao update(@RequestBody Avaliacao avaliacao) {
        avaliacaoService.save(avaliacao);
        return avaliacao;
    }

}

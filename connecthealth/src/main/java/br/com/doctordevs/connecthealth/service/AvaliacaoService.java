package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Avaliacao;
import br.com.doctordevs.connecthealth.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> getAllAvaliacao() {
        List<Avaliacao> avaliacao = new ArrayList<Avaliacao>();
        avaliacaoRepository.findAll().forEach(avaliacao1 -> avaliacao.add(avaliacao1));
        return avaliacao;
    }

    public Avaliacao getAvaliacaoId(int avaliacaoId) {
        return avaliacaoRepository.findById(avaliacaoId).get();
    }

    public void delete(int avaliacaoId) {
        avaliacaoRepository.deleteById(avaliacaoId);
    }

    public void save(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }

    public void update(Avaliacao avaliacao, int avaliacaoId) {
        avaliacaoRepository.save(avaliacao);
    }

}

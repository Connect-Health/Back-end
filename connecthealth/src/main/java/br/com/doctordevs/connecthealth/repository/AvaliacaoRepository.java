package br.com.doctordevs.connecthealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doctordevs.connecthealth.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository <Avaliacao, Integer> {
    
}

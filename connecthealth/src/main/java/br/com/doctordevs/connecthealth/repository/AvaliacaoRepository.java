package br.com.doctordevs.connecthealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doctordevs.connecthealth.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {
    List<Avaliacao> findByPacienteIdPacienteId(int pacienteId);

    List<Avaliacao> findByProfissionalIdProfissionalId(int profissionalId);
}

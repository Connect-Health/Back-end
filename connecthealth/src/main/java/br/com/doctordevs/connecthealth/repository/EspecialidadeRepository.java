package br.com.doctordevs.connecthealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doctordevs.connecthealth.model.Especialidade;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {
}

package br.com.doctordevs.connecthealth.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doctordevs.connecthealth.model.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Integer> {
    List<Calendario> findByProfissionalProfissionalId(int profissionalId);

    List<Calendario> findByPacientePacienteId(int pacienteId);

    List<Calendario> findByProfissionalProfissionalIdAndData(int profissionalId, Date data);
}

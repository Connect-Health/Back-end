package br.com.doctordevs.connecthealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doctordevs.connecthealth.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    List<Comentario> findByPacientePacienteId(int pacienteId);

    List<Comentario> findByPostPostId(int postId);

    void deleteByPostPostId(int postId);
}

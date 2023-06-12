package br.com.doctordevs.connecthealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.doctordevs.connecthealth.model.Comentario;
import br.com.doctordevs.connecthealth.repository.ComentarioRepository;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    public List<Comentario> getAllComentario() {
        List<Comentario> comentario = new ArrayList<Comentario>();
        comentarioRepository.findAll().forEach(comentario1 -> comentario.add(comentario1));
        return comentario;
    }

    public Comentario getComentarioId(int comentarioId) {
        return comentarioRepository.findById(comentarioId).get();
    }

    public List<Comentario> getComentarioByPaciente(int pacienteId) {
        return comentarioRepository.findByPacientePacienteId(pacienteId);
    }

    public List<Comentario> getComentarioByPost(int postId) {
        return comentarioRepository.findByPostPostId(postId);
    }

    public void delete(int comentarioId) {
        comentarioRepository.deleteById(comentarioId);
    }

    public void save(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public void update(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public void removeComentarios(int postId) {
        List<Comentario> comentarios = comentarioRepository.findByPostPostId(postId);
        for (Comentario comentario : comentarios) {
            if (comentario.getPost().getPostId() == postId) {
                comentarioRepository.delete(comentario);
            }

        }
    }

}

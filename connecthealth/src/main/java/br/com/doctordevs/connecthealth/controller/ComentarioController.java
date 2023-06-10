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

import br.com.doctordevs.connecthealth.model.Comentario;
import br.com.doctordevs.connecthealth.service.ComentarioService;

@RestController
@RequestMapping("/comentario")
@CrossOrigin(origins = "*")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> getAllComentario() {
        return comentarioService.getAllComentario();
    }

    @GetMapping("/{comentarioId}")
    public Comentario getComentario(@PathVariable("comentarioId") int comentarioId) {
        return comentarioService.getComentarioId(comentarioId);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<Comentario> getComentarioByPaciente(@PathVariable("pacienteId") int pacienteId) {
        return comentarioService.getComentarioByPaciente(pacienteId);
    }

    @GetMapping("/post/{postId}")
    public List<Comentario> getComentarioByPost(@PathVariable("postId") int postId) {
        return comentarioService.getComentarioByPost(postId);
    }

    @PostMapping
    public void save(Comentario comentario) {
        comentarioService.save(comentario);
    }

    @PutMapping
    public void update(Comentario comentario) {
        comentarioService.update(comentario);
    }

    @DeleteMapping("/{comentarioId}")
    public void delete(@PathVariable("comentarioId") int comentarioId) {
        comentarioService.delete(comentarioId);
    }
}

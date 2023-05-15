package br.com.doctordevs.connecthealth.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.service.ProfissionalService;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin(origins = "*")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    public ProfissionalController(ProfissionalService profissionalService) {
        this.profissionalService = profissionalService;
    }

    @GetMapping("/profissionais")
public List<Profissional> listarProfissionais(
        @RequestParam(name = "page", defaultValue = "0") int page,
        @RequestParam(name = "size", defaultValue = "4") int size,
        HttpServletResponse response) {
    response.setHeader("Access-Control-Allow-Origin", "*");

    List<Profissional> profissionais = profissionalService.listarProfissionais();

    int totalPages = (int) Math.ceil((double) profissionais.size() / (double) size);
    if (page < 0) {
        page = 0;
    } else if (page >= totalPages) {
        page = totalPages - 1;
    }

    List<Profissional> paginatedProfissionais = IntStream.range(page * size, Math.min((page + 1) * size, profissionais.size()))
            .mapToObj(i -> profissionais.get(i))
            .collect(Collectors.toList());

    return paginatedProfissionais;
}
    
    @GetMapping("/profissionais/nutricionistas")
    public List<Profissional> listarNutricionistas() {
        return profissionalService.buscarNutricionistas();
    }

    @GetMapping("/profissionais/psicologos")
    public List<Profissional> listarPsicologos() {
        return profissionalService.buscarPsicologos();
    }

    @GetMapping("/profissionais/avaliacao/{avaliacao}")
    public List<Profissional> listarProfissionaisPorAvaliacao(@PathVariable("avaliacao") Double avaliacao) {
        return profissionalService.buscarProfissionaisPorAvaliacao(avaliacao);
    }

    @GetMapping("/profissionais/especialidade")
    public List<Profissional> listarProfissionaisPorEspecialidade(String especialidade) {
        return profissionalService.buscarProfissionaisPorEspecialidade(especialidade);
    }

    @GetMapping("/profissionais/{id}")
    public Profissional buscarProfissionalPorId(@PathVariable("id") int id) {
        return profissionalService.buscarProfissionalPorId(id).orElseThrow();
    }

}

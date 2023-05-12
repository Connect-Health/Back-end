// package br.com.doctordevs.connecthealth.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RestController;
// import br.com.doctordevs.connecthealth.model.Profissional;
// import br.com.doctordevs.connecthealth.service.ProfissionalService;
// import jakarta.servlet.http.HttpServletResponse;

// @RestController
// @CrossOrigin(origins = "*")
// public class ProfissionalController {

//     @Autowired
//     private final ProfissionalService profissionalService;

//     public ProfissionalController(ProfissionalService profissionalService) {
//         this.profissionalService = profissionalService;
//     }

//     @GetMapping("/profissionais")
//     public List<Profissional> listarProfissionais(HttpServletResponse response) {
//         response.setHeader("Access-Control-Allow-Origin", "*");
//         return profissionalService.listarProfissionais();
//     }

//     @GetMapping("/profissionais/nutricionistas")
//     public List<Profissional> listarNutricionistas() {
//         return profissionalService.buscarNutricionistas();
//     }

//     @GetMapping("/profissionais/psicologos")
//     public List<Profissional> listarPsicologos() {
//         return profissionalService.buscarPsicologos();
//     }

//     @GetMapping("/profissionais/avaliacao/{avaliacao}")
//     public List<Profissional> listarProfissionaisPorAvaliacao(@PathVariable("avaliacao") Double avaliacao) {
//         return profissionalService.buscarProfissionaisPorAvaliacao(avaliacao);
//     }

//     @GetMapping("/profissionais/especialidade/{especialidade}")
//     public List<Profissional> listarProfissionaisPorEspecialidade(@PathVariable("especialidade") String especialidade) {
//         return profissionalService.buscarProfissionaisPorEspecialidade(especialidade);
//     }

//     @GetMapping("/profissionais/{id}")
//     public Profissional buscarProfissionalPorId(@PathVariable("id") int id) {
//         return profissionalService.buscarProfissionalPorId(id).orElseThrow();
//     }

// }

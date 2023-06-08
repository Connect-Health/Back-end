package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import br.com.doctordevs.connecthealth.dto.ProfissionalLoginDTO;
import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.service.ProfissionalService;

@RestController
@RequestMapping("/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    private final ProfissionalService profissionalService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ProfissionalController(ProfissionalService profissionalService, PasswordEncoder passwordEncoder) {
        this.profissionalService = profissionalService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public List<Profissional> getAllPaciente() {
        return profissionalService.getAllProfissional();
    }

    @GetMapping("/psicologos")
    public List<Profissional> getAllPsicologos() {
        return profissionalService.getAllPsicologos();
    }

    @GetMapping("/nutricionistas")
    public List<Profissional> getAllNutricionistas() {
        return profissionalService.getAllNutricionistas();
    }

    @GetMapping("/{profissionalId}")
    public Profissional getProfissional(@PathVariable("profissionalId") int profissionalId) {
        return profissionalService.getProfissionalId(profissionalId);
    }

    @DeleteMapping("/{profissionalId}")
    private void deleteProfissional(@PathVariable("profissionalId") int profissionalId) {
        profissionalService.delete(profissionalId);
    }

    @PostMapping
    private String saveProfissional(@RequestBody Profissional profissional) {
        if (profissionalService.existsByEmail(profissional.getEmail())) {
            Error error = new Error("Email já cadastrado");
            return error.getMessage();
        }

        if (profissionalService.existsByCpf(profissional.getCpf())) {
            Error error = new Error("CPF já cadastrado");
            return error.getMessage();
        }

        if (profissionalService.existsByUrlCertificado(profissional.getUrlCertificado())) {
            Error error = new Error("URL do certificado já cadastrado");
            return error.getMessage();
        }

        String senhaCriptografada = passwordEncoder.encode(profissional.getSenha());
        profissional.setSenha(senhaCriptografada);
        profissionalService.save(profissional);
        return "Profissional cadastrado com sucesso, o ID é: " + profissional.getprofissionalId();
    }

    @PostMapping("/login")
    private ProfissionalLoginDTO login(@RequestBody Profissional profissional) {
        String email = profissional.getEmail();
        String senha = profissional.getSenha();

        Profissional profissionalEncontrado = profissionalService.findByEmail(email);

        if (profissionalEncontrado != null && passwordEncoder.matches(senha, profissionalEncontrado.getSenha())) {
            return new ProfissionalLoginDTO(true, profissionalEncontrado);
        }

        return new ProfissionalLoginDTO(false, null);
    }

    @PostMapping("/loginGoogle")
    private boolean loginGoogle(@RequestBody Profissional profissional) {
        String email = profissional.getEmail();

        Profissional profissionalEncontrado = profissionalService.findByEmail(email);

        return profissionalEncontrado != null;
    }

    @PutMapping("/{profissionalId}")
    private Profissional updateProfissionalEmail(@PathVariable("profissionalId") int profissionalId,
            @RequestBody Profissional profissional) {
        Profissional profissionalExistente = profissionalService.getProfissionalId(profissionalId);
        if (profissionalExistente == null) {
            return null;
        }
        if (profissional.getEmail() != null) {
            profissionalExistente.setEmail(profissional.getEmail());
        }
        profissionalService.save(profissionalExistente);
        return profissionalExistente;
    }

    @PutMapping
    private Profissional update(@RequestBody Profissional profissional) {
        String senhaCriptografada = passwordEncoder.encode(profissional.getSenha());
        profissional.setSenha(senhaCriptografada);
        profissionalService.save(profissional);
        return profissional;
    }
}

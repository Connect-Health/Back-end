package br.com.doctordevs.connecthealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import br.com.doctordevs.connecthealth.dto.ProfissionalLoginDTO;
import br.com.doctordevs.connecthealth.handler.BusinessException;
import br.com.doctordevs.connecthealth.model.Endereco;
import br.com.doctordevs.connecthealth.model.Profissional;
import br.com.doctordevs.connecthealth.service.EnderecoService;
import br.com.doctordevs.connecthealth.service.ProfissionalService;

@RestController
@RequestMapping("/profissional")
@CrossOrigin(origins = "*")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EnderecoService enderecoService;

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
            throw new BusinessException("Email já cadastrado");
        }

        if (profissionalService.existsByCpf(profissional.getCpf())) {
           throw new BusinessException("CPF já cadastrado");
        }

        if (profissionalService.existsByUrlCertificado(profissional.getUrlCertificado())) {
            throw new BusinessException("Certificado já cadastrado");
        }

        String senhaCriptografada = passwordEncoder.encode(profissional.getSenha());
        profissional.setSenha(senhaCriptografada);

        Endereco enderecoAtual = profissional.getEndereco();
        int enderecoId = enderecoService.save(enderecoAtual);
        profissional.getEndereco().setEnderecoId(enderecoId);

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
    private ProfissionalLoginDTO loginGoogle(@RequestBody Profissional profissional) {
        String email = profissional.getEmail();

        Profissional profissionalEncontrado = profissionalService.findByEmail(email);

        if (profissionalEncontrado != null) {
            return new ProfissionalLoginDTO(true, profissionalEncontrado);
        }

        return new ProfissionalLoginDTO(false, null);
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

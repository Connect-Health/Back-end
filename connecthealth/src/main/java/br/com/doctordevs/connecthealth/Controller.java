package br.com.doctordevs.connecthealth;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    private List<Paciente> pacientes = List.of(
        new Paciente("João", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail", "https://avatars.githubusercontent.com/u/87583563?v=4"),
        new Paciente("Maria", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail", "https://avatars.githubusercontent.com/u/125367739?s=64&v=4"),
        new Paciente("José", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail", "https://avatars.githubusercontent.com/u/104914975?v=4")
    );
    
    @GetMapping(value = "/pacientes")
    public List<Paciente> pacientes() {
        return pacientes;
    }

    @GetMapping(value = "/profissionais")
    public String profissionais() {
        return "Olá, profissionais!";
    }
}

package br.com.doctordevs.connecthealth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.doctordevs.connecthealth.model.Paciente;

@Repository
public class PacienteRepository {

        private List<Paciente> pacientes = List.of(
                        new Paciente("João", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail",
                                        "https://avatars.githubusercontent.com/u/125038606?s=96&v=4"),
                        new Paciente("Gabriela", "Mendes", "1199999999", "1999-01-01", "11111111111", "Rua 1",
                                        "joao@gmail",
                                        "https://avatars.githubusercontent.com/u/92945219?s=96&v=4"),
                        new Paciente("Guilherme", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1",
                                        "joao@gmail",
                                        "https://avatars.githubusercontent.com/u/125367739?s=64&v=4"),
                        new Paciente("Pedro", "Carvalho", "11933333333", "1993-03-15", "77777777777", "Rua 7",
                                        "pedro@gmail",
                                        "https://avatars.githubusercontent.com/u/125279606?s=96&v=4"),
                        new Paciente("Rafael", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1",
                                        "rafael@gmail",
                                        "https://avatars.githubusercontent.com/u/104914975?s=96&v=4"),
                        new Paciente("Julia", "Souza", "11988888888", "1995-12-10", "22222222222", "Rua 2",
                                        "julia@gmail",
                                        "https://avatars.githubusercontent.com/u/125279572?s=96&v=4"),
                        new Paciente("Gabriel", "Almeida", "11977777777", "1989-06-18", "33333333333", "Rua 3",
                                        "gabriel@gmail",
                                        "https://avatars.githubusercontent.com/u/99509845?s=96&v=4"),
                        new Paciente("Isabela", "Fernandes", "11922222222", "1998-11-29", "88888888888", "Rua 8",
                                        "isabela@gmail",
                                        "https://avatars.githubusercontent.com/u/104914975?s=96&v=4"),
                        new Paciente("Renato", "Santos", "11911111111", "1980-04-05", "99999999999", "Rua 9",
                                        "renato@gmail",
                                        "https://avatars.githubusercontent.com/u/125279606?s=96&v=4"));

        public List<Paciente> findAll() {
                return pacientes;
        }

}

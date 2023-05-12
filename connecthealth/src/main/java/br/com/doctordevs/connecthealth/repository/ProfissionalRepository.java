package br.com.doctordevs.connecthealth.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.doctordevs.connecthealth.model.Profissional;

@Repository
public class ProfissionalRepository {

   

//     public List<Profissional> getProfissionais() {
//         return getProfissionais();
//     }

//     public Profissional getProfissionalById(int id) {
//         return profissionais.stream().filter(profissional -> profissional.getId() == id).findFirst().orElse(null);
//     }

//     public List<Profissional> getProfissionaisByEspecialidade(String especialidade) {
//         return profissionais.stream().filter(profissional -> profissional.getEspecialidade().equals(especialidade))
//                 .collect(Collectors.toList());
//     }

//     public List<Profissional> getProfissionaisByAvaliacao(double avaliacao) {
//         return profissionais.stream().filter(profissional -> profissional.getAvaliacao() >= avaliacao)
//                 .collect(Collectors.toList());
//     }

//     public List<Profissional> getProfissionaisByNome(String nome) {
//         return profissionais.stream().filter(profissional -> profissional.getNome().equals(nome))
//                 .collect(Collectors.toList());
//     }

//     public List<Profissional> getNutricionistas() {
//         return profissionais.stream().filter(p -> p.getAreaAtuacao().equals("Nutrição"))
//                 .collect(Collectors.toList());
//     }

//     public List<Profissional> getPsicologos() {
//         return profissionais.stream().filter(p -> p.getAreaAtuacao().equals("Psicologia"))
//                 .collect(Collectors.toList());
//     }

}

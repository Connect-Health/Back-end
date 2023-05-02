package br.com.doctordevs.connecthealth;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {

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

    private List<Profissional> profissionais = List.of(
            new Profissional(1, "João", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail",
                    "https://avatars.githubusercontent.com/u/125279572?s=96&v=4",
                    List.of("Familia", "Depressao", "Ansiedade", "Constipação", "Diarréia", "Disbiose", "Dislipidemia",
                            "Enxaqueca",
                            "Fibromialgia", "Insônia", "Menopausa", "TPM", "Infertilidade", "Gestação", "Lactação",
                            "Crianças", "Adolescentes"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    "60min", "R$ 100,00",
                    "Descrição", "Nutrição", "5"),
            new Profissional(2, "Maria", "Souza", "11988888888", "1990-05-21", "22222222222", "Rua 2", "maria@gmail",
                    "https://avatars.githubusercontent.com/u/125279606?s=96&v=4",
                    List.of("Depressao", "Estresse", "Autoestima",
                            "Ansiedade", "Relacionamento", "Familia", "Luto", "Sexualidade", "Transtorno Alimentar",
                            "Vícios", "Orientação Profissional", "Orientação Vocacional", "Orientação de Carreira"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    "45min", "R$ 80,00",
                    "Descrição", "Psicologia", "4.9"),
            new Profissional(3, "Pedro", "Rodrigues", "11977777777", "1985-12-10", "33333333333", "Rua 3", "pedro@gmail",
                    "https://avatars.githubusercontent.com/u/99509845?s=96&v=4",
                    List.of("Obesidade", "Diabetes", "Hipertensão",
                            "Doença Celíaca", "Doença de Crohn", "Intolerância à Lactose", "Gastrite", "Refluxo",
                            "Síndrome do Intestino Irritável", "Anemia", "Colesterol Alto", "Gota", "Osteoporose",
                            "Câncer", "Alergias"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    "45min", "R$ 120,00",
                    "Descrição", "Nutrição", "4.5"),
            new Profissional(4, "Camila", "Almeida", "11999999999", "1990-03-10", "22222222222", "Rua 2",
                    "camila@gmail.com",
                    "https://avatars.githubusercontent.com/u/125279740?s=96&v=4",
                    List.of("Depressão", "Ansiedade", "Estresse", "Fobias", "Transtornos Alimentares", "Autoestima",
                            "Relacionamentos", "Sexualidade"),
                    "https://www.linkedin.com/in/camila-almeida-71b53028/",
                    "60min", "R$ 120,00",
                    "Descrição", "Psicologia", "4"),

            new Profissional(5, "Gabriela", "Santos", "11999999999", "1995-05-20", "33333333333", "Rua 3",
                    "gabriela@gmail.com",
                    "https://avatars.githubusercontent.com/u/125279977?s=96&v=4",
                    List.of("Emagrecimento", "Ganho de Massa Muscular", "Reeducação Alimentar", "Doenças Metabólicas",
                            "Intolerâncias e Alergias Alimentares", "Dificuldades com a Alimentação"),
                    "https://www.linkedin.com/in/gabriela-santos-23198310b/",
                    "1h30min", "R$ 150,00",
                    "Descrição", "Nutrição", "5"),

                        new Profissional(6, "Roberto", "Oliveira", "11999999999", "1985-12-01", "44444444444", "Rua 4",
                                        "roberto@gmail.com",
                                        "https://avatars.githubusercontent.com/u/125280164?s=96&v=4",
                                        List.of("Depressão", "Ansiedade", "Burnout", "Transtornos de Personalidade",
                                                        "Estresse Pós-Traumático", "Insônia",
                                                        "Transtornos Alimentares"),
                                        "https://www.linkedin.com/in/roberto-oliveira-99a46626/",
                                        "50min", "R$ 200,00",
                                        "Descrição", "Psicologia", "4"),

            new Profissional(7, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    "1h", "R$ 130,00",
                    "Descrição", "Nutrição", "5"),

                new Profissional(8, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    "1h", "R$ 130,00",
                    "Descrição", "Nutrição", "5"),

                    new Profissional(9, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    "1h", "R$ 130,00",
                    "Descrição", "Nutrição", "5"),

                    new Profissional(10, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças"),
                    "https://www.linkedin.com/in/marianalima/",
                    "60", "R$ 130,00",
                    "Descrição", "Nutrição", "5"),

                    new Profissional(11, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    "60", "R$ 130,00",
                    "Descrição", "Nutrição", "5"));
                    

    @GetMapping(value = "/pacientes")
    public List<Paciente> pacientes(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return pacientes;
    }

        @GetMapping(value = "/nutricionistas")
        public List<Profissional> nutricionistas(HttpServletResponse response) {
                response.setHeader("Access-Control-Allow-Origin", "*");

                return profissionais.stream()
                                .filter(p -> p.getAreaAtuacao().equals("Nutrição"))
                                .collect(Collectors.toList());
        }

        @GetMapping(value = "/psicologos")
        public List<Profissional> psicologos(HttpServletResponse response) {
                response.setHeader("Access-Control-Allow-Origin", "*");

                return profissionais.stream()
                                .filter(p -> p.getAreaAtuacao().equals("Psicologia"))
                                .collect(Collectors.toList());
        }

        @GetMapping(value = "/profissional/{id}")
        public Profissional profissional(HttpServletResponse response, @PathVariable("id") int id) {
                response.setHeader("Access-Control-Allow-Origin", "*");
                return profissionais.get(id - 1);
        }
}

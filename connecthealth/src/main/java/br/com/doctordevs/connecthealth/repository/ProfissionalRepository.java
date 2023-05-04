package br.com.doctordevs.connecthealth.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.doctordevs.connecthealth.model.Profissional;

@Repository
public class ProfissionalRepository {

    private List<Profissional> profissionais = List.of(
            new Profissional(1, "João", "Silva", "11999999999", "1999-01-01", "11111111111", "Rua 1", "joao@gmail",
                    "https://avatars.githubusercontent.com/u/125279572?s=96&v=4",
                    List.of("Familia", "Depressao", "Ansiedade", "Constipação", "Diarréia", "Disbiose", "Dislipidemia",
                            "Enxaqueca",
                            "Fibromialgia", "Insônia", "Menopausa", "TPM", "Infertilidade", "Gestação", "Lactação",
                            "Crianças", "Adolescentes"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    60, "R$ 100,00",
                    "Descrição", "Nutrição", 5.0),
            new Profissional(2, "Maria", "Souza", "11988888888", "1990-05-21", "22222222222", "Rua 2", "maria@gmail",
                    "https://avatars.githubusercontent.com/u/125279606?s=96&v=4",
                    List.of("Depressao", "Estresse", "Autoestima",
                            "Ansiedade", "Relacionamento", "Familia", "Luto", "Sexualidade", "Transtorno Alimentar",
                            "Vícios", "Orientação Profissional", "Orientação Vocacional", "Orientação de Carreira"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    45, "R$ 80,00",
                    "Descrição", "Psicologia", 4.5),
            new Profissional(3, "Pedro", "Rodrigues", "11977777777", "1985-12-10", "33333333333", "Rua 3",
                    "pedro@gmail",
                    "https://avatars.githubusercontent.com/u/99509845?s=96&v=4",
                    List.of("Obesidade", "Diabetes", "Hipertensão",
                            "Doença Celíaca", "Doença de Crohn", "Intolerância à Lactose", "Gastrite", "Refluxo",
                            "Síndrome do Intestino Irritável", "Anemia", "Colesterol Alto", "Gota", "Osteoporose",
                            "Câncer", "Alergias"),
                    "https://conhecimento.sti.ufpb.br/uploads/images/gallery/2022-08/scaled-1680-/1Mnt48ERQnwewxg2-image-1661441161358.png",
                    45, "R$ 120,00",
                    "Descrição", "Nutrição", 4.5),
            new Profissional(4, "Camila", "Almeida", "11999999999", "1990-03-10", "22222222222", "Rua 2",
                    "camila@gmail.com",
                    "https://avatars.githubusercontent.com/u/125279740?s=96&v=4",
                    List.of("Depressão", "Ansiedade", "Estresse", "Fobias", "Transtornos Alimentares", "Autoestima",
                            "Relacionamentos", "Sexualidade"),
                    "https://www.linkedin.com/in/camila-almeida-71b53028/",
                    55, "R$ 120,00",
                    "Descrição", "Psicologia", 1.5),

            new Profissional(5, "Gabriela", "Santos", "11999999999", "1995-05-20", "33333333333", "Rua 3",
                    "gabriela@gmail.com",
                    "https://avatars.githubusercontent.com/u/125279977?s=96&v=4",
                    List.of("Emagrecimento", "Ganho de Massa Muscular", "Reeducação Alimentar", "Doenças Metabólicas",
                            "Intolerâncias e Alergias Alimentares", "Dificuldades com a Alimentação"),
                    "https://www.linkedin.com/in/gabriela-santos-23198310b/",
                    60, "R$ 150,00",
                    "Descrição", "Nutrição", 1.1),

            new Profissional(6, "Roberto", "Oliveira", "11999999999", "1985-12-01", "44444444444", "Rua 4",
                    "roberto@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280164?s=96&v=4",
                    List.of("Depressão", "Ansiedade", "Burnout", "Transtornos de Personalidade",
                            "Estresse Pós-Traumático", "Insônia",
                            "Transtornos Alimentares"),
                    "https://www.linkedin.com/in/roberto-oliveira-99a46626/",
                    50, "R$ 200,00",
                    "Descrição", "Psicologia", 4.6),

            new Profissional(7, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    50, "R$ 130,00",
                    "Descrição", "Nutrição", 3.6),

            new Profissional(8, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    45, "R$ 130,00",
                    "Descrição", "Nutrição", 2.4),

            new Profissional(9, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    60, "R$ 130,00",
                    "Descrição", "Nutrição", 5.0),

            new Profissional(10, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças"),
                    "https://www.linkedin.com/in/marianalima/",
                    60, "R$ 130,00",
                    "Como especialista em marketing digital, eu ajudo empresas a aumentar sua presença online e a alcançar seus objetivos de negócios. Tenho experiência em gerenciamento de campanhas de publicidade, SEO, mídia social e email marketing. Além disso, sou hábil em análise de dados e utilizo esses insights para tomar decisões estratégicas. Sempre me dedico a encontrar a melhor maneira de ajudar meus clientes a ter sucesso online.",
                    "Nutrição", 4.1),

            new Profissional(11, "Mariana", "Lima", "11999999999", "1988-08-15", "55555555555", "Rua 5",
                    "mariana@gmail.com",
                    "https://avatars.githubusercontent.com/u/125280336?s=96&v=4",
                    List.of("Gestantes", "Puérperas", "Crianças", "Adolescentes", "Obesidade Infantil",
                            "Alimentação Saudável", "Nutrição Esportiva"),
                    "https://www.linkedin.com/in/marianalima/",
                    60, "R$ 110,00",
                    "Sou um desenvolvedor web experiente com mais de 5 anos de experiência em projetos de larga escala. Trabalho com uma variedade de tecnologias, incluindo React, Angular, Node.js e AWS, e tenho habilidades em design responsivo e desenvolvimento móvel. Sou apaixonado por encontrar soluções criativas e eficazes para problemas complexos e estou sempre buscando aprender mais.",
                    "Nutrição", 4.6));

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public Profissional getProfissionalById(int id) {
        return profissionais.stream().filter(profissional -> profissional.getId() == id).findFirst().orElse(null);
    }

    public List<Profissional> getProfissionaisByEspecialidade(String especialidade) {
        return profissionais.stream().filter(profissional -> profissional.getEspecialidade().equals(especialidade))
                .collect(Collectors.toList());
    }

    public List<Profissional> getProfissionaisByAvaliacao(double avaliacao) {
        return profissionais.stream().filter(profissional -> profissional.getAvaliacao() >= avaliacao)
                .collect(Collectors.toList());
    }

    public List<Profissional> getProfissionaisByNome(String nome) {
        return profissionais.stream().filter(profissional -> profissional.getNome().equals(nome))
                .collect(Collectors.toList());
    }

    public List<Profissional> getNutricionistas() {
        return profissionais.stream().filter(p -> p.getAreaAtuacao().equals("Nutrição"))
                .collect(Collectors.toList());
    }

    public List<Profissional> getPsicologos() {
        return profissionais.stream().filter(p -> p.getAreaAtuacao().equals("Psicologia"))
                .collect(Collectors.toList());
    }

}

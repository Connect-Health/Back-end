package br.com.doctordevs.connecthealth.model;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
public class Profissional {
    
    @Id
    private Integer id;
    
    @Column
    private String nome;

    @Column
    private String sobrenome;

    @Column
    private String telefone;

    @Column
    private String dataNascimento;
    
    @Column
    private String cpf;

    @Column
    private String endereco;
    
    @Column
    private String email;
    
    @Column
    private String avatar;
    
    @Column
    private List<String> especialidade;
    
    @Column
    private String certificado;
    
    @Column
    private Time duracao;

    @Column
    private String preco;
    
    @Column
    private String descricao;
    
    @Column
    private String areaAtuacao;
    
    @Column
    private Double avaliacao;
}

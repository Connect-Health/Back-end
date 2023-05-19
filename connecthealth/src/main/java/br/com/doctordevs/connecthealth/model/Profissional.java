package br.com.doctordevs.connecthealth.model;

import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
public class Profissional {
    
    @Id
    private Integer id;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true, length = 11)
    private String telefone;

    @Column
    private String dataNascimento;
    
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @ManyToOne
    @JoinColumn(nullable = false, name = "endereco_id")
    private Endereco endereco;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String urlAvatar;
    
    @Column(nullable = false, unique = true)
    private String urlCertificado;
    
    @Column(nullable = false)
    private Time duracao;

    @Column(nullable = false)
    private Float preco;
    
    @Column(nullable = false)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(nullable = false, name = "area_id")
    private Area areaAtuacao;
    
    @Column
    private Float avaliacao;
}

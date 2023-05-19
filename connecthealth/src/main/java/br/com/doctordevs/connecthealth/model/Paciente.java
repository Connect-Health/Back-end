package br.com.doctordevs.connecthealth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Date;

import jakarta.persistence.Column;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    private Integer pacienteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private Date dataNascimento;

    @Column(nullable = false)
    private String cpf;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Endereco endereco;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String urlAvatar;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String sexo;


}

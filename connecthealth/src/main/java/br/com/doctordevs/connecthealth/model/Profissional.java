package br.com.doctordevs.connecthealth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_profissional")
public class Profissional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer profissionalId;
    
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
    private String duracao;

    @Column(nullable = false)
    private Float preco;
    
    @Column(nullable = false)
    private String descricao;
    
    @ManyToOne
    @JoinColumn(nullable = false, name = "area_id")
    private Area areaAtuacao;
    
    @Column
    private Float avaliacao;

    @ManyToOne
    @JoinColumn(nullable = false, name = "especialidade_id")
    private Especialidade especialidade;

    public Integer getprofissionalId() {
        return profissionalId;
    }

    public void setId(Integer profissionalId) {
        this.profissionalId = profissionalId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getUrlCertificado() {
        return urlCertificado;
    }

    public void setUrlCertificado(String urlCertificado) {
        this.urlCertificado = urlCertificado;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Area getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(Area areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public Float getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Float avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

}

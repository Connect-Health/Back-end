package br.com.doctordevs.connecthealth;

import java.util.List;

public class Profissional {

    private Number id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String dataNascimento;
    private String cpf;
    private String endereco;
    private String email;
    private String avatar;
    private List especialidade;
    private String certificado;
    private String duracao;
    private String preco;
    private String descricao;
    private String areaAtuacao;
    private String avaliacao;

    public Profissional(Number id, String nome, String sobrenome, String telefone, String dataNascimento, String cpf,
            String endereco, String email, String avatar, List especialidade, String certificado, String duracao,
            String preco, String descricao, String areaAtuacao, String avaliacao) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.avatar = avatar;
        this.especialidade = especialidade;
        this.certificado = certificado;
        this.duracao = duracao;
        this.preco = preco;
        this.descricao = descricao;
        this.areaAtuacao = areaAtuacao;
        this.avaliacao = avaliacao;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(List especialidade) {
        this.especialidade = especialidade;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

}

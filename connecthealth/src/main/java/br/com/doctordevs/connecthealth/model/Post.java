package br.com.doctordevs.connecthealth.model;

import java.sql.Blob;
import java.sql.Date;

public class Post {
    private int postId;
    private String titulo;
    private String conteudo;
    private Blob imagem;
    private Date dataPublicacao;
    private int profissionalId;

    
   public int getPostId() {
    return postId;
 }

 public void setPostId(int postId) {
    this.postId = postId;
 }

 public String getTitulo() {
    return titulo;
 }

 public void setTitulo(String titulo) {
    this.titulo = titulo;
 }

 public String getConteudo() {
    return conteudo;
 }

 public void setConteudo(String conteudo) {
    this.conteudo = conteudo;
 }

 public Blob getImagem() {
    return imagem;
 }

 public void setImagem(Blob imagem) {
    this.imagem = imagem;
 }

 public Date getDataPublicacao() {
    return dataPublicacao;
 }

 public void setDataPublicacao(Date dataPublicacao) {
    this.dataPublicacao = dataPublicacao;
 }

 public int getProfissionalId() {
    return profissionalId;
 }

 public void setProfissionalId(int profissionalId) {
    this.profissionalId = profissionalId;
 }
}

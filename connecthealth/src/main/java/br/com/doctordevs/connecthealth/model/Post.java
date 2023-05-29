package br.com.doctordevs.connecthealth.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_post")
public class Post {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int postId;

   @Column
   private String titulo;

   @Column
   private String conteudo;

   @Column
   private String imagem;

   @Column
   private Date dataPublicacao;

   @Column
   private Time horaPublicacao;

   @ManyToOne
   @JoinColumn(name = "profissional_id")
   private Profissional profissional;

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

   public String getImagem() {
      return imagem;
   }

   public void setImagem(String imagem) {
      this.imagem = imagem;
   }

   public Date getDataPublicacao() {
      return dataPublicacao;
   }

   public void setDataPublicacao(Date dataPublicacao) {
      this.dataPublicacao = dataPublicacao;
   }

   public Profissional getProfissional() {
      return profissional;
   }

   public void setProfissional(Profissional profissional) {
      this.profissional = profissional;
   }

   public Time getHoraPublicacao() {
      return horaPublicacao;
   }

   public void setHoraPublicacao(Time horaPublicacao) {
      this.horaPublicacao = horaPublicacao;
   }
}

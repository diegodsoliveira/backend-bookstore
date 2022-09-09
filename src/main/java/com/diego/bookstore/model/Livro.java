package com.diego.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

   private static final long serialVersionUID = -358539280123462305L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String nome;
   private String descricao;

   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private Categoria categoria;

   public Livro() {
   }

   public Livro(Integer id, String nome, String descricao, Categoria categoria) {
      this.id = id;
      this.nome = nome;
      this.descricao = descricao;
      this.categoria = categoria;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getDescricao() {
      return descricao;
   }

   public void setDescricao(String descricao) {
      this.descricao = descricao;
   }

   public Categoria getCategoria() {
      return categoria;
   }

   public void setCategoria(Categoria categoria) {
      this.categoria = categoria;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Livro)) return false;
      Livro livro = (Livro) o;
      return getId().equals(livro.getId());
   }

   @Override
   public int hashCode() {
      return Objects.hash(getId());
   }
}

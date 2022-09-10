package com.diego.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = -5303364689501973300L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "O campo TÍTULO é requerido")
    @Length(min = 3, max = 50, message = "O campo TÍTULO deve ter entre 3 e 50 caracteres")
    private String titulo;
    @NotEmpty(message = "O campo NOME DO AUTOR é requerido")
    @Length(min = 3, max = 50, message = "O campo NOME DO AUTOR deve ter entre 3 e 50 caracteres")
    private String nomeAutor;
    @NotEmpty(message = "O campo TEXTO é requerido")
    @Length(min = 10, max = 2000000, message = "O campo TEXTO deve ter entre 3 e 2.000.000 caracteres")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        return Objects.equals(getId(), livro.getId()) && Objects.equals(getTitulo(), livro.getTitulo()) && Objects.equals(getNomeAutor(), livro.getNomeAutor()) && Objects.equals(getTexto(), livro.getTexto()) && Objects.equals(getCategoria(), livro.getCategoria());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getNomeAutor(), getTexto(), getCategoria());
    }
}

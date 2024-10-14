package br.org.serratec.biblioteca.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity //Criei sem @Table porque o nome solicitado é o mesmo da classe. Então achei que ficaria redundante.
public class Livro {

    @Column(name = "id_livro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column (name = "nome", nullable = false, length = 30)
    @NotBlank(message= "Por favor, informe o título do livro que você deseja cadastrar!")
    @Size (max = 30, message = "Por favor, digite um nome que tenha até 30 caracteres") //Testar isso depois.
    private String titulo;

    @Column
    private Integer qtdPaginas;

    @Embedded
    @Valid
    public Publicacao publicacao;

    public Livro() {
    }

    public Livro(Long id, String titulo, Integer qtdPaginas) {
        this.id = id;
        this.titulo = titulo;
        this.qtdPaginas = qtdPaginas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

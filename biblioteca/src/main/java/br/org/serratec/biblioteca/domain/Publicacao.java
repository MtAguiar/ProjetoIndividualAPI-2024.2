package br.org.serratec.biblioteca.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Embeddable //Criei sem @Table porque o nome solicitado é o mesmo da classe. Então achei que ficaria redundante.
public class Publicacao {

    @NotBlank(message= "Por favor, informe o título do livro que você deseja cadastrar!")
    @Size(max = 20, message = "Por favor, digite um nome que tenha até 20 caracteres")
    private String autor;

    private LocalDate dataPublicacao;

    private String editora;

    public Publicacao() {}
    public Publicacao(String autor, LocalDate dataPublicacao, String editora) {
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}

package com.casaDoCodigo.casaDoCodigo.Autor;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank(message = "Por favor informe o nome do autor.")
    private String nome;

    @NotBlank(message = "Por favor, informe o email.")
    @Email(message = "Formato inválido")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Por favor, informe a descrição.")
    @Size(max = 400, message = "Tamanho máximo de 400 caracteres.")
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Deprecated
    protected NovoAutorRequest() {
    }

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
        Assert.hasText(nome, "Informe o nome.");
        Assert.hasText(email, "Informe o email.");
        Assert.hasText(descricao, "Informe a descrição.");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}

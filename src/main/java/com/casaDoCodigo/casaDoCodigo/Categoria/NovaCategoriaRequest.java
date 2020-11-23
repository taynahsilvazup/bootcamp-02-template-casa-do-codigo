package com.casaDoCodigo.casaDoCodigo.Categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "Por favor, informe o nome da categoria.")
    private String nome;

    public String getNome() {
        return nome;
    }

    @Deprecated
    protected NovaCategoriaRequest() {
    }

    public NovaCategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}

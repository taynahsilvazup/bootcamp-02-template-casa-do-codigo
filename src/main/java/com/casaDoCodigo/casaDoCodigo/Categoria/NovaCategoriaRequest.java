package com.casaDoCodigo.casaDoCodigo.Categoria;

import com.casaDoCodigo.casaDoCodigo.ValidationUtils.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank(message = "Por favor, informe o nome da categoria.")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome já existente.")
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

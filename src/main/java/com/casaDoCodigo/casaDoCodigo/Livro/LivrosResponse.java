package com.casaDoCodigo.casaDoCodigo.Livro;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LivrosResponse {

    private Long id;

    private String nome;


    @Deprecated
    protected LivrosResponse() {}

    public LivrosResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}

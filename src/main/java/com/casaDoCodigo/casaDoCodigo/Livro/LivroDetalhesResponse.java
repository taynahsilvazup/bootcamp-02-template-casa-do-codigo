package com.casaDoCodigo.casaDoCodigo.Livro;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LivroDetalhesResponse {

    private LivroDTO livro;

    private AutorDTO autor;

    private CategoriaDTO categoria;

    @Deprecated
    public LivroDetalhesResponse() {
    }

    public LivroDetalhesResponse(LivroDTO livro, AutorDTO autor, CategoriaDTO categoria) {
        this.livro = livro;
        this.autor = autor;
        this.categoria = categoria;
    }
}

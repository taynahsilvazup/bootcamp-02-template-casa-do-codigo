package com.casaDoCodigo.casaDoCodigo.Livro;

import com.casaDoCodigo.casaDoCodigo.Categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CategoriaDTO {

    private String nome;

    @Deprecated
    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.nome = categoria.getNome();
    }
}

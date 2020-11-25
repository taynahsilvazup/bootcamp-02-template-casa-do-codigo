package com.casaDoCodigo.casaDoCodigo.Livro;

import com.casaDoCodigo.casaDoCodigo.Autor.Autor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AutorDTO {

    private String nome;

    private String descricao;

    @Deprecated
    public AutorDTO() {
    }

    public AutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }
}

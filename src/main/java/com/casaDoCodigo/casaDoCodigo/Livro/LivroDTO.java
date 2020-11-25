package com.casaDoCodigo.casaDoCodigo.Livro;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LivroDTO {

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal preco;

    private Integer paginas;

    private String lsbn;

    private LocalDate dataPublicacao;

    @Deprecated
    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {

        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.lsbn = livro.getLsbn();
        this.dataPublicacao = livro.getDataPublicacao();
    }
}

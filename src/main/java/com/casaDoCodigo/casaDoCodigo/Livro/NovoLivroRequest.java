package com.casaDoCodigo.casaDoCodigo.Livro;

import com.casaDoCodigo.casaDoCodigo.Autor.Autor;
import com.casaDoCodigo.casaDoCodigo.Categoria.Categoria;
import com.casaDoCodigo.casaDoCodigo.ValidationUtils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já existente.")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(value = 20L)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100L)
    private Integer paginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "lsbn", message = "Lsbn já existente.")
    private String lsbn;

    @NotNull
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    private Long categoriaId;

    @NotNull
    private Long autorId;

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public String getLsbn() {
        return lsbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }

    @Deprecated
    protected NovoLivroRequest() {}

    public NovoLivroRequest(@NotBlank String titulo,
                            @NotBlank String resumo,
                            String sumario,
                            @NotBlank BigDecimal preco,
                            @NotBlank Integer paginas,
                            @NotBlank String lsbn,
                            @NotBlank LocalDate dataPublicacao,
                            @NotBlank Long categoria,
                            @NotBlank Long autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.lsbn = lsbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoria;
        this.autorId = autor;
    }

    public Livro toModel(EntityManager manager) {
        Categoria categoria = manager.find(Categoria.class, categoriaId);
        Assert.state(categoria != null, "Categoria " + categoriaId + " não encontrada.");

        Autor autor = manager.find(Autor.class, autorId);
        Assert.state(autor != null, "Autor(a) " + autorId + " não encontrado(a)");

        return  new Livro(titulo, resumo, sumario, preco, paginas, lsbn, dataPublicacao, categoria, autor);
    }
}

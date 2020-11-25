package com.casaDoCodigo.casaDoCodigo.Livro;

import com.casaDoCodigo.casaDoCodigo.Autor.Autor;
import com.casaDoCodigo.casaDoCodigo.Categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "TITULO")
    private String titulo;

    @NotBlank
    @Column(name = "RESUMO")
    @Size(max = 500)
    private String resumo;

    @Column(name = "SUMARIO")
    private String sumario;

    @NotNull
    @Min(value = 20L)
    @Column(name = "PRECO")
    @Positive
    private BigDecimal preco;

    @NotNull
    @Min(value = 100L)
    @Column(name = "PAGINAS")
    @Positive
    private Integer paginas;

    @NotBlank
    @Column(name = "LSBN")
    private String lsbn;

    @NotNull
    @Column(name = "DATA_PUBLICACAO")
    @Future
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @JoinColumn(name = "CATEGORIA_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Categoria categoriaId;

    @JoinColumn(name = "AUTOR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Autor autorId;

    @Column(name = "DATA_CADASTRO")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public Long getId() {
        return id;
    }

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

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public Autor getAutorId() {
        return autorId;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    @Deprecated
    protected Livro() {
    }

    public Livro(@NotBlank String titulo,
                 @NotBlank String resumo,
                 String sumario,
                 @NotNull BigDecimal preco,
                 @NotNull Integer paginas,
                 @NotBlank String lsbn,
                 @NotNull LocalDate dataPublicacao,
                 @NotNull Categoria categoria,
                 @NotNull Autor autor) {

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
}

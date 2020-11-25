package com.casaDoCodigo.casaDoCodigo.Categoria;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Por favor, informe o nome da categoria.")
    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    @Deprecated
    protected Categoria(){
    }

    public Categoria(@NotBlank String nome) {
        Assert.hasLength(nome, "Informe o nome.");

        this.nome = nome;
    }
}

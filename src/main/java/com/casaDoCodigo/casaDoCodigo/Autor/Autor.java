package com.casaDoCodigo.casaDoCodigo.Autor;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AUTOR")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "Por favor informe o nome do autor.")
    @Column(name = "NOME")
    private String nome;

    @NotBlank(message = "Por favor, informe o email.")
    @Email(message = "Formato inválido")
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotBlank(message = "Por favor, informe a descrição.")
    @Size(max = 400, message = "Tamanho máximo de 400 caracteres.")
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_CADASTRO")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    @Deprecated
    protected Autor(){
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
        Assert.hasLength(nome, "Informe o nome.");
        Assert.hasLength(email, "Informe o email.");
        Assert.hasLength(descricao, "Informe a descrição.");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}

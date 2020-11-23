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
    @Column(name = "EMAIL")
    private String email;

    @NotBlank(message = "Por favor, informe a descrição.")
    @Size(max = 400, message = "Tamanho máximo de 400 caracteres.")
    @Column(name = "DESCRICAO")
    private String descricao;

    @NotBlank
    @Column(name = "DATA_CADASTRO")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    @Deprecated
    private Autor(){
    }

    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank String descricao) {
        Assert.hasText(nome, "Informe o nome.");
        Assert.hasText(email, "Informe o email.");
        Assert.hasText(descricao, "Informe a descrição.");

        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

}

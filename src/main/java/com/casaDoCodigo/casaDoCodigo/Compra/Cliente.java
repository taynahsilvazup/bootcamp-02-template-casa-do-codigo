package com.casaDoCodigo.casaDoCodigo.Compra;

import com.casaDoCodigo.casaDoCodigo.Localidade.Estado.Estado;
import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*@NotBlank
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    private Pais pais;

    private Estado estado;

    private String telefone;

    private String cep;*/
}

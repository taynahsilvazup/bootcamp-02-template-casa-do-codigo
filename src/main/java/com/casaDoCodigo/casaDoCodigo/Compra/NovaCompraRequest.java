package com.casaDoCodigo.casaDoCodigo.Compra;

import com.casaDoCodigo.casaDoCodigo.Localidade.Estado.Estado;
import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;
import com.casaDoCodigo.casaDoCodigo.ValidationUtils.ExistsId;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCompraRequest {

    @NotBlank
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
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "")
    private Long pais;

    private Long estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    @Deprecated
    public NovaCompraRequest() {
    }

    public NovaCompraRequest(@NotBlank @Email String email,
                             @NotBlank String nome,
                             @NotBlank String sobrenome,
                             @NotBlank String documento,
                             @NotBlank String endereco,
                             @NotBlank String complemento,
                             @NotBlank String cidade,
                             @NotNull Long pais, Long estado,
                             @NotBlank String telefone,
                             @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public boolean documentoValido() {
        Assert.hasLength(documento, "Documento não informado.");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(documento, null)
                || cnpjValidator.isValid(documento, null);

    }
}

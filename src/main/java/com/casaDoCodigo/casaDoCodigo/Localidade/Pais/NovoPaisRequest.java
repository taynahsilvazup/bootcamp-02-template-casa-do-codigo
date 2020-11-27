package com.casaDoCodigo.casaDoCodigo.Localidade.Pais;

import com.casaDoCodigo.casaDoCodigo.ValidationUtils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.validation.constraints.NotBlank;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Pais já cadastrado.")
    private String nome;

    @Deprecated
    public NovoPaisRequest() {
    }

    public NovoPaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toModel() {
        return new Pais(nome);
    }
}

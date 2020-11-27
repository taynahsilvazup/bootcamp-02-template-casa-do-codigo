package com.casaDoCodigo.casaDoCodigo.Localidade.Estado;

import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;
import com.casaDoCodigo.casaDoCodigo.ValidationUtils.UniqueValue;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NovoEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado já cadastrado.")
    private String nome;

    @NotNull
    private Long paisId;

    @Deprecated
    public NovoEstadoRequest() {
    }

    public NovoEstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public Estado toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class, this.paisId);
        Assert.state(pais != null, "Pais " + paisId + " não encontrado.");

        return new Estado(nome, pais);
    }
}

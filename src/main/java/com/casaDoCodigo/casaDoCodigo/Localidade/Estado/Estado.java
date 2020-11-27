package com.casaDoCodigo.casaDoCodigo.Localidade.Estado;

import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "ESTADO")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @JoinColumn(name = "PAIS_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais pais;

    @Column(name = "data_cadastro")
    private final LocalDateTime dataCadastro = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }
}

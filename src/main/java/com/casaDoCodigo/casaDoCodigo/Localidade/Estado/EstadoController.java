package com.casaDoCodigo.casaDoCodigo.Localidade.Estado;

import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.NovoPaisRequest;
import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class EstadoController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping("/estado")
    @Transactional
    public ResponseEntity<?> criaEstado(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest, UriComponentsBuilder uriComponentsBuilder) {

        Estado estado = novoEstadoRequest.toModel(manager);
        manager.persist(estado);

        URI location = uriComponentsBuilder
                .path("/estado/{id}")
                .buildAndExpand(estado.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

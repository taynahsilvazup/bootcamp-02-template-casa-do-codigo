package com.casaDoCodigo.casaDoCodigo.Localidade.Pais;

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
public class PaisController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping("/pais")
    @Transactional
    public ResponseEntity<?> criaPais(@RequestBody @Valid NovoPaisRequest novoPaisRequest, UriComponentsBuilder uriComponentsBuilder) {

        Pais pais = novoPaisRequest.toModel();
        manager.persist(pais);

        URI location = uriComponentsBuilder
                .path("/pais/{id}")
                .buildAndExpand(pais.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

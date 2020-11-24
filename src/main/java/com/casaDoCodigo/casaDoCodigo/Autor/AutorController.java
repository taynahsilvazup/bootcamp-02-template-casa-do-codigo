package com.casaDoCodigo.casaDoCodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/autor")
    @Transactional
    public ResponseEntity<?> cadastraAutor(@RequestBody @Valid NovoAutorRequest novoAutor, UriComponentsBuilder uriBuilder) {

        Autor autor = novoAutor.toModel();
        manager.persist(autor);

        URI location = uriBuilder
                .path("/autor/{id}")
                .buildAndExpand(autor.getId())
                .toUri();

        return ResponseEntity.ok().location(location).build();
    }


}

package com.casaDoCodigo.casaDoCodigo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
public class CategoriaController {

    @PersistenceContext
    EntityManager manager;


    @PostMapping("/categoria")
    @Transactional
    public ResponseEntity<?> cadastraCategoria(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest, UriComponentsBuilder uriBuilder) {

        Categoria categoria = novaCategoriaRequest.toModel();
        manager.persist(categoria);

        URI location = uriBuilder
                .path("/categoria/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();

        return ResponseEntity.ok().location(location).build();
    }
}

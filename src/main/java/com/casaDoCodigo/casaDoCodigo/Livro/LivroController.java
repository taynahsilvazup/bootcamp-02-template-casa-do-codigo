package com.casaDoCodigo.casaDoCodigo.Livro;

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
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/livro")
    @Transactional
    public ResponseEntity<?> cadadastraLivro(@RequestBody @Valid NovoLivroRequest novoLivroRequest, UriComponentsBuilder uriComponentsBuilder) {
        Livro livro = novoLivroRequest.toModel(entityManager);
        entityManager.persist(livro);

        URI location = uriComponentsBuilder
                .path("/livro/{id}")
                .buildAndExpand(livro.getId())
                .toUri();

        return ResponseEntity.ok().location(location).build();
    }
}

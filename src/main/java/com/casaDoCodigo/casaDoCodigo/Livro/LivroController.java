package com.casaDoCodigo.casaDoCodigo.Livro;

import com.casaDoCodigo.casaDoCodigo.Autor.Autor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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



    @GetMapping("/livro")
    @Transactional
    public ResponseEntity<List<LivrosResponse>> buscaLivros() {

        String querySql = "select new com.casaDoCodigo.casaDoCodigo.Livro.LivrosResponse(l.id, l.titulo) from Livro l";

        List<LivrosResponse> livros = this.entityManager.createQuery(querySql).getResultList();

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/livro/{id}")
    @Transactional
    public ResponseEntity<LivroDetalhesResponse> buscaLivro(@PathVariable Long id) {

        Livro livro = entityManager.find(Livro.class, id);
        if(livro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        LivroDTO livroDTO = new LivroDTO(livro);
        AutorDTO autorDTO = new AutorDTO(livro.getAutorId());
        CategoriaDTO categoriaDTO = new CategoriaDTO(livro.getCategoriaId());

        return ResponseEntity.ok(new LivroDetalhesResponse(livroDTO, autorDTO, categoriaDTO));
    }
}
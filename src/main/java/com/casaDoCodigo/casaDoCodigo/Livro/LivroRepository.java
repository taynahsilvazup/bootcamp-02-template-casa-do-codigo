package com.casaDoCodigo.casaDoCodigo.Livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}

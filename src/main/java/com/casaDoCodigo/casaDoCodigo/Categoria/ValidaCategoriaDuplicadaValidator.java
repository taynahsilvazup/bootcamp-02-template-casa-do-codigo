package com.casaDoCodigo.casaDoCodigo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ValidaCategoriaDuplicadaValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCategoriaRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NovaCategoriaRequest request = (NovaCategoriaRequest) o;
        Optional<Categoria> categoria = categoriaRepository.findByNome(request.getNome());

        if(categoria.isPresent()) {
            errors.rejectValue("nome", null, "Categoria " + request.getNome() + " já cadastrada.");
        }
    }
}

package com.casaDoCodigo.casaDoCodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.Optional;

@Component
public class ValidaEmailAutorDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovoAutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovoAutorRequest request = (NovoAutorRequest) o;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if(autor.isPresent()) {
            errors.rejectValue("email", null, "Email " + request.getEmail() + " já cadastrado.");
        }
    }
}

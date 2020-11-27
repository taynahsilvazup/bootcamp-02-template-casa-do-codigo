package com.casaDoCodigo.casaDoCodigo.ValidationUtils;

import com.casaDoCodigo.casaDoCodigo.Compra.NovaCompraRequest;
import com.casaDoCodigo.casaDoCodigo.Localidade.Pais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) o;

        Pais pais = manager.find(Pais.class, request.getPais());

    }
}

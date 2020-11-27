package com.casaDoCodigo.casaDoCodigo.ValidationUtils;

import com.casaDoCodigo.casaDoCodigo.Compra.NovaCompraRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VerificaCpfCnpjValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NovaCompraRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        NovaCompraRequest request = (NovaCompraRequest) o;
        if(!request.documentoValido()) {
            errors.rejectValue("Documento", null, "Informe CPF ou CNPJ.");
        }
    }
}

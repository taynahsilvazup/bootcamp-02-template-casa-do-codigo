package com.casaDoCodigo.casaDoCodigo.Compra;

import com.casaDoCodigo.casaDoCodigo.ValidationUtils.VerificaCpfCnpjValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CompraParteUmController {

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new VerificaCpfCnpjValidator());
    }

    @PostMapping("/compra")
    public ResponseEntity<?> criaCompra(@RequestBody @Valid NovaCompraRequest request) {
        return null;
    }
}

package com.caiojacinthodev.patrimonio.infra.security;

import com.caiojacinthodev.patrimonio.Exception.PatrimonioDuplicado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PatrimonioDuplicado.class)
    private ResponseEntity<String> EventNotFoundHandler(PatrimonioDuplicado exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("patrimonio duplicado");
    }
}

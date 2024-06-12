package com.bancodedados.atividadeindividual.handler;

import com.bancodedados.atividadeindividual.exceptions.not_found.UsuarioNotFoundException;
import com.bancodedados.atividadeindividual.exceptions.not_found.UsuarioNotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice(basePackages = "com.bancodedados.atividadeindividual.controller")
public class UsuarioExceptionHandler {

    @ExceptionHandler(UsuarioNotFoundException.class)
    public ResponseEntity<UsuarioNotFoundExceptionDetails> usuarioNotFoundExceptionHandler(UsuarioNotFoundException usuarioNotFoundException) {
        UsuarioNotFoundExceptionDetails placeNotFoundExceptionDetails = new UsuarioNotFoundExceptionDetails(
                LocalDateTime.now(),
                "UsuarioNotFoundExceptionDetails",
                usuarioNotFoundException.getMessage()
        );
        return new ResponseEntity<>(placeNotFoundExceptionDetails, HttpStatus.NOT_FOUND);
    }

}

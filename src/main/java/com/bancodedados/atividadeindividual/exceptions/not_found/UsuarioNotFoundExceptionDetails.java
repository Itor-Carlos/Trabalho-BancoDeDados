package com.bancodedados.atividadeindividual.exceptions.not_found;

import com.bancodedados.atividadeindividual.exceptions.ExceptionDetails;

import java.time.LocalDateTime;

public class UsuarioNotFoundExceptionDetails extends ExceptionDetails {

    private String message;

    public UsuarioNotFoundExceptionDetails(LocalDateTime timeStamp, String exception, String message){
        super(404,timeStamp,exception);//call the ExceptionDetails class constructor
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

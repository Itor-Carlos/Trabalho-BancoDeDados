package com.bancodedados.atividadeindividual.exceptions.not_found;

public class UsuarioNotFoundException extends RuntimeException{

    private String message = "Usuario not found";

    public UsuarioNotFoundException(){
    }

    public String getMessage(){
        return this.message;
    }
}

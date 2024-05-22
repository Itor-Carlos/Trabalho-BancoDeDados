package com.bancodedados.atividadeindividual.controller;

import com.bancodedados.atividadeindividual.model.Usuario;
import com.bancodedados.atividadeindividual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        ArrayList<String> errorList = new ArrayList<>();

        if(usuario.getCpf() == null) errorList.add("Cpf is a required field");
        if(usuario.getNome() == null) errorList.add("Nome is a required field");
        if(usuario.getDataAniversario() == null){
            errorList.add("Data de aniversário is a required field");
        }

        if(!errorList.isEmpty()){
           return ResponseEntity.badRequest().body(errorList);
        }
        this.usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

}

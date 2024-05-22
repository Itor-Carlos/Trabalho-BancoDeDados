package com.bancodedados.atividadeindividual.controller;

import com.bancodedados.atividadeindividual.model.Usuario;
import com.bancodedados.atividadeindividual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll(){
        System.out.println("fodase");
        return ResponseEntity.ok(usuarioService.findAll());
    }

}

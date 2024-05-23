package com.bancodedados.atividadeindividual.controller;

import com.bancodedados.atividadeindividual.model.Usuario;
import com.bancodedados.atividadeindividual.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(usuario.getdataNascimento() == null){
            errorList.add("Data de nascimento is a required field");
        }

        if(!errorList.isEmpty()){
           return ResponseEntity.badRequest().body(errorList);
        }
        this.usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> getUsuario(@PathVariable("cpf") String cpf) {
        if(cpf == null) ResponseEntity.badRequest().body("Cpf is a required field");

        Optional<Usuario> usuario = usuarioService.findByCpf(cpf);
        return usuario.isPresent() ? ResponseEntity.ok().body(usuario.get()) : ResponseEntity.notFound().build();
    }

}

package com.bancodedados.atividadeindividual.controller;

import com.bancodedados.atividadeindividual.exceptions.not_found.UsuarioNotFoundException;
import com.bancodedados.atividadeindividual.exceptions.not_found.UsuarioNotFoundExceptionDetails;
import com.bancodedados.atividadeindividual.model.Usuario;
import com.bancodedados.atividadeindividual.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Retorna todos os usuarios cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todos os usuarios cadastros com sucesso",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class, type = "array")) }),
    })
    public ResponseEntity<List<Usuario>> findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @PostMapping
    @Operation(summary = "Cadastra um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro efetudo com sucesso",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class)) }),
    })
    public ResponseEntity<?> saveUsuario(@RequestBody Usuario usuario){
        ArrayList<String> errorList = new ArrayList<>();

        if(usuario.getCpf() == null) errorList.add("Cpf is a required field");
        if(usuario.getNome() == null) errorList.add("Nome is a required field");
        if(usuario.getDataNascimento() == null){
            errorList.add("Data de nascimento is a required field");
        }

        if(!errorList.isEmpty()){
           return ResponseEntity.badRequest().body(errorList);
        }
        this.usuarioService.saveUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Busca um usuário com base no CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuario com o CPF utilizado com sucesso",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class)) }),
            @ApiResponse(responseCode = "404", description = "Não foi encontrado usuário com o CPF utilizado",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioNotFoundExceptionDetails.class))}),
    })
    public ResponseEntity<?> getUsuario(@PathVariable("cpf") String cpf) {
        if(cpf == null) ResponseEntity.badRequest().body("Cpf is a required field");
        Optional<Usuario> usuario = usuarioService.findByCpf(cpf);
        return ResponseEntity.ok().body(usuario.get());
    }

}

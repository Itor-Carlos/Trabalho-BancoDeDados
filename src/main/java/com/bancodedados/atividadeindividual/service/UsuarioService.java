package com.bancodedados.atividadeindividual.service;

import com.bancodedados.atividadeindividual.model.Usuario;
import com.bancodedados.atividadeindividual.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public void saveUsuario(Usuario usuario){
        this.usuarioRepository.saveUsuario(usuario);
    }

}

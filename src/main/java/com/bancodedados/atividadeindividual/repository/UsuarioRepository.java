package com.bancodedados.atividadeindividual.repository;

import com.bancodedados.atividadeindividual.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}

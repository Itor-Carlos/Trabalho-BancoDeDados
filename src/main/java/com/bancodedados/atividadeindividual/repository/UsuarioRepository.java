package com.bancodedados.atividadeindividual.repository;

import com.bancodedados.atividadeindividual.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> findAll(){
        String sql = "FROM Usuario";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }
}

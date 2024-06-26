package com.bancodedados.atividadeindividual.repository;

import com.bancodedados.atividadeindividual.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Usuario> findAll(){
        String sql = "FROM Usuario";
        Query query = entityManager.createQuery(sql);
        return query.getResultList();
    }

    @Transactional
    public void saveUsuario(Usuario usuario){
        Query query = entityManager.createNativeQuery("INSERT INTO Usuario (cpf, nome, data_nascimento) VALUES (?,?,?) RETURNING nome, data_aniversario")
                .setParameter(1, usuario.getCpf())
                .setParameter(2, usuario.getNome())
                .setParameter(3, usuario.getDataNascimento());
        query.getResultList();
    }

    public Optional<Usuario> findByCpf(String cpf) {
        TypedQuery<Usuario> query = entityManager.createQuery("FROM Usuario WHERE cpf = :cpf", Usuario.class)
                .setParameter("cpf", cpf);
        return query.getResultStream().findFirst();
    }
}

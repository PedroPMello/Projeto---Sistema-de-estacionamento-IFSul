/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lpooestacionamento;

import java.util.ArrayList;
import modelo.Pessoa;

/**
 *
 * @author pedro
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import modelo.VinculoPessoa;

/**
 *
 * @author vanessalagomachado
 */
public class PersistenciaJPA implements InterfaceBD {

    EntityManager entity;
    EntityManagerFactory factory;

    public PersistenciaJPA() {
        //parametro: é o nome da unidade de persistencia (Persistence Unit)
        factory
                = Persistence.createEntityManagerFactory("pu_lpoo_estacionamento");
        //conecta no bd e executa a estratégia de geração.
        entity = factory.createEntityManager();
    }

    public Boolean conexaoAberta() {

        return entity.isOpen();
    }

    public void fecharConexao() {
        entity.close();
    }

    public Object find(Class c, Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }

    /*
    Todos os métodos agora chamam getEntityManager() 
    para garantir que o EntityManager esteja sempre aberto e 
    pronto para uso.
     */
    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }

    // funções para listar dados 
    public List<Pessoa> getPessoas() {
        entity = getEntityManager();

        try {
            TypedQuery<Pessoa> query
                    = entity.createQuery("Select p from Pessoa p", Pessoa.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Pessoas: " + e);
            return null;
        }

    }
    
    public List<Pessoa> buscarPessoasPorNome(String nome) {
    return entity.createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE :nome", Pessoa.class)
             .setParameter("nome", "%" + nome + "%")
             .getResultList();
}

public List<Pessoa> buscarPessoasPorNomeEVinculo(String nome, VinculoPessoa vinculo) {
    return entity.createQuery("SELECT p FROM Pessoa p WHERE p.nome LIKE :nome AND p.vinculo = :vinculo", Pessoa.class)
             .setParameter("nome", "%" + nome + "%")
             .setParameter("vinculo", vinculo)
             .getResultList();
}

}

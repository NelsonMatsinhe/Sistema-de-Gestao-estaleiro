/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.Producao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */

public class ProducaoDAO {

    // Método para salvar uma produção
    public void salvar(Producao producao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(producao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para buscar produção por ID
    public Producao buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Producao producao = null;
        try {
            producao = em.find(Producao.class, id);
        } finally {
            em.close();
        }
        return producao;
    }

    // Método para listar todas as produções
    public List<Producao> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Producao> producoes = null;
        try {
            TypedQuery<Producao> query = em.createQuery(
                "SELECT p FROM Producao p", Producao.class
            );
            producoes = query.getResultList();
        } finally {
            em.close();
        }
        return producoes;
    }
    
    // Método para atualizar uma produção
    public void atualizar(Producao producao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(producao);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    // Método para remover uma produção
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producao producao = em.find(Producao.class, id);
            if (producao != null) {
                em.remove(producao);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}


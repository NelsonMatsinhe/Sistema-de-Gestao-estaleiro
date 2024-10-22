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
 * DAO para gerenciar operações CRUD da entidade Producao
 * 
 * @author Nelson
 */
public class ProducaoDAO {

    // Método para salvar uma produção no banco de dados
    public void salvar(Producao producao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(producao);  // Persiste a entidade Producao
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();  // Faz rollback se ocorrer algum erro
            }
            e.printStackTrace();
        } finally {
            em.close();  // Fecha o EntityManager
        }
    }

    // Método para buscar uma produção pelo ID
    public Producao buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Producao producao = null;
        try {
            producao = em.find(Producao.class, id);  // Busca uma produção por ID
        } catch (Exception e) {
            e.printStackTrace();
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
            );  // Query JPQL para listar todas as produções
            producoes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return producoes;
    }

    // Método para atualizar uma produção existente
    public void atualizar(Producao producao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(producao);  // Atualiza a entidade Producao
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

    // Método para remover uma produção pelo ID
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producao producao = em.find(Producao.class, id);  // Busca a produção pelo ID
            if (producao != null) {
                em.remove(producao);  // Remove a produção se ela existir
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

    // Método para remover uma produção, mas apenas atualizando seu estado (não excluir diretamente)
    public void desativar(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Producao producao = em.find(Producao.class, id);
            if (producao != null) {
                producao.setAtiva(false);  // Atualiza o estado para desativado
                em.merge(producao);        // Salva a alteração no banco
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

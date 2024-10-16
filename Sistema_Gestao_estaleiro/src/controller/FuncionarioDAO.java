/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */


public class FuncionarioDAO {

    public void salvar(Funcionario funcionario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(funcionario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Funcionario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Funcionario funcionario = null;
        try {
            funcionario = em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
        return funcionario;
    }

    public List<Funcionario> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            funcionarios = query.getResultList();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    public void atualizar(Funcionario funcionario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(funcionario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                em.remove(funcionario);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.Fornecedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class FornecedorDAO {

    public void salvar(Fornecedor fornecedor) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(fornecedor);
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

    public Fornecedor buscarPorId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Fornecedor fornecedor = null;
        try {
            fornecedor = em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
        return fornecedor;
    }

    public List<Fornecedor> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Fornecedor> fornecedores = null;
        try {
            TypedQuery<Fornecedor> query = em.createQuery("SELECT f FROM Fornecedor f", Fornecedor.class);
            fornecedores = query.getResultList();
        } finally {
            em.close();
        }
        return fornecedores;
    }

    public void atualizar(Fornecedor fornecedor) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(fornecedor);
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

    public void remover(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Fornecedor fornecedor = em.find(Fornecedor.class, id);
            if (fornecedor != null) {
                em.remove(fornecedor);
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


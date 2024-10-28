/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * DAO para a entidade Produto.
 *
 * @author Nelson
 */
public class ProdutoDAO {

    // Método para salvar um produto
    public void salvar(Produto produto) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(produto);
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

    // Método para buscar produto por ID
    public Produto buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Produto produto = null;
        try {
            produto = em.find(Produto.class, id);
        } finally {
            em.close();
        }
        return produto;
    }

    // Método para listar todos os produtos
    public List<Produto> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Produto> produtos = null;
        try {
            TypedQuery<Produto> query = em.createQuery(
                "SELECT p FROM Produto p", Produto.class
            );
            produtos = query.getResultList();
        } finally {
            em.close();
        }
        return produtos;
    }

    // Método para remover um produto
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
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

    // Método para atualizar um produto
    public void atualizar(Produto produto) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(produto); // Atualiza o produto existente no banco de dados
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.Categoria;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */

public class CategoriaDAO {

    // Método para salvar uma categoria
    public void salvar(Categoria categoria) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(categoria);
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

    // Método para buscar categoria por ID
    public Categoria buscarPorId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Categoria categoria = null;
        try {
            categoria = em.find(Categoria.class, id);
        } finally {
            em.close();
        }
        return categoria;
    }

    // Método para listar todas as categorias
    public List<Categoria> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Categoria> categorias = null;
        try {
            TypedQuery<Categoria> query = em.createQuery(
                "SELECT c FROM Categoria c", Categoria.class
            );
            categorias = query.getResultList();
        } finally {
            em.close();
        }
        return categorias;
    }

    // Método para remover uma categoria
    public void remover(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Categoria categoria = em.find(Categoria.class, id);
            if (categoria != null) {
                em.remove(categoria);
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


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.Material;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */



public class MaterialDAO {

    public void salvar(Material material) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(material);
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

    public Material buscarPorId(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Material material = null;
        try {
            material = em.find(Material.class, id);
        } finally {
            em.close();
        }
        return material;
    }

    public List<Material> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Material> materiais = null;
        try {
            materiais = em.createQuery("SELECT m FROM Material m", Material.class).getResultList();
        } finally {
            em.close();
        }
        return materiais;
    }

    public void remover(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Material material = em.find(Material.class, id);
            if (material != null) {
                em.remove(material);
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

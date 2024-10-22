package controller;

import model.Material;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Classe DAO para gerenciar operações de Material.
 *
 * @author Nelson Matsinhe
 */
public class MaterialDAO {

    // Método para salvar um novo material
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

    // Método para buscar material por ID
    public Material buscarPorId(long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Material material = null;
        try {
            material = em.find(Material.class, id);
        } finally {
            em.close();
        }
        return material;
    }

    // Método para listar todos os materiais
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

    // Método para remover um material por ID
    public void remover(long  id) {
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

    // Método para atualizar um material existente
    public void atualizar(Material material) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(material); // Atualiza o material existente no banco de dados
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

    // Método para contar o número total de materiais
    public int contarMaterial() {
        EntityManager em = JpaUtil.getEntityManager();
        int total = 0;
        try {
            total = ((Long) em.createQuery("SELECT COUNT(m) FROM Material m").getSingleResult()).intValue();
        } finally {
            em.close();
        }
        return total;
    }
}

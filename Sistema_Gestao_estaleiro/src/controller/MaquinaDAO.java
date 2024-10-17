/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import model.Maquina;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
/**
 *
 * @author Nelson Matsinhe
 */


public class MaquinaDAO {

    // Método para salvar uma máquina
    public void salvar(Maquina maquina) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(maquina);
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

    // Método para buscar máquina por ID
    public Maquina buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Maquina maquina = null;
        try {
            maquina = em.find(Maquina.class, id);
        } finally {
            em.close();
        }
        return maquina;
    }

    // Método para listar todas as máquinas
    public List<Maquina> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Maquina> maquinas = null;
        try {
            TypedQuery<Maquina> query = em.createQuery(
                "SELECT m FROM Maquina m", Maquina.class
            );
            maquinas = query.getResultList();
        } finally {
            em.close();
        }
        return maquinas;
    }

    // Método para remover uma máquina
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Maquina maquina = em.find(Maquina.class, id);
            if (maquina != null) {
                em.remove(maquina);
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

package controller;

import model.LoteProducao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoteProducaoDAO {

    // Método para salvar um novo lote de produção
    public void salvar(LoteProducao loteProducao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(loteProducao);
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

    // Método para buscar um lote de produção pelo ID
    public LoteProducao buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        LoteProducao loteProducao = null;
        try {
            loteProducao = em.find(LoteProducao.class, id);
        } finally {
            em.close();
        }
        return loteProducao;
    }

    // Método para listar todos os lotes de produção
    public List<LoteProducao> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<LoteProducao> lotes = null;
        try {
            TypedQuery<LoteProducao> query = em.createQuery("SELECT l FROM LoteProducao l", LoteProducao.class);
            lotes = query.getResultList();
        } finally {
            em.close();
        }
        return lotes;
    }

    // Método para atualizar um lote de produção existente
    public void atualizar(LoteProducao loteProducao) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(loteProducao);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
    }}

    // Método para remover um lote de produção pelo ID
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            LoteProducao loteProducao = em.find(LoteProducao.class, id);
            if (loteProducao != null) {
                em.remove(loteProducao);
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

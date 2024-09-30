package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {

    public void salvar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(usuario); // salva o usuário
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

    public Usuario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = null;
        try {
            usuario = em.find(Usuario.class, id); // busca usuário por ID
        } finally {
            em.close();
        }
        return usuario;
    }

    public List<Usuario> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> usuarios = null;
        try {
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
            usuarios = query.getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }

    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
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

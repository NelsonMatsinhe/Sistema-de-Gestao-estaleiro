package controller;

import model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class UsuarioDAO {

    // Método para verificar se um nome de usuário já existe
    public boolean existePorUserName(String userName) {
        EntityManager em = JpaUtil.getEntityManager();
        boolean existe = false;
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.userName = :userName AND u.estado = true", Long.class
            );
            query.setParameter("userName", userName);
            Long count = query.getSingleResult();
            existe = count > 0;
        } finally {
            em.close();
        }
        return existe;
    }

    // Método para salvar um usuário, verificando duplicidade de nome de usuário
    public void salvar(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            if (existePorUserName(usuario.getUserName())) {
                System.out.println("Usuário com o mesmo nome já existe.");
                return;
            }
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

    // Método para buscar usuário por ID, considerando apenas usuários ativos
    public Usuario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = null;
        try {
            usuario = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.codigoUsuario = :id AND u.estado = true", Usuario.class
            ).setParameter("id", id).getSingleResult();
        } finally {
            em.close();
        }
        return usuario;
    }

    // Método para listar todos os usuários ativos
    public List<Usuario> listarTodosAtivos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> usuarios = null;
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.estado = true", Usuario.class
            );
            usuarios = query.getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }

    // Método para atualizar o status de um usuário para inativo (ao invés de removê-lo)
    public void desativarUsuario(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                usuario.setEstado(false); // Marca o usuário como inativo
                em.merge(usuario); // Atualiza o status
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

    // Método para pesquisar usuário por nome, apenas ativos
    public List<Usuario> pesquisarPorNome(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> usuarios = null;
        try {
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.nome LIKE :nome AND u.estado = true", Usuario.class
            );
            query.setParameter("nome", "%" + nome + "%");
            usuarios = query.getResultList();
        } finally {
            em.close();
        }
        return usuarios;
    }

    // Método para contar o número de usuários ativos
    public long contarUsuariosAtivos() {
        EntityManager em = JpaUtil.getEntityManager();
        long count = 0;
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM Usuario u WHERE u.estado = true", Long.class
            );
            count = query.getSingleResult();
        } finally {
            em.close();
        }
        return count;
    }
}

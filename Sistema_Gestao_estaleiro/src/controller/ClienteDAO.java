package controller;


import model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {

    
    public void inserir(Cliente cliente) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

   
    public void alterar(Cliente cliente) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    
    public void excluir(Cliente cliente) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente c = em.find(Cliente.class, cliente.getId());
            if (c != null) {
                em.remove(c);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

  
    public List<Cliente> listarTodos() throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("FROM Cliente");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente buscarPorCodigo(Long codigo) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Cliente.class, codigo);
        } finally {
            em.close();
        }
    }

    public List<Cliente> pesquisarPorNome(String nome) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("FROM Cliente WHERE nome = :nome");
            query.setParameter("nome", nome);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

 
    public Cliente recuperar(int codigo) throws Exception {
        return buscarPorCodigo((long) codigo);
    }

    public int contarCliente() throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(c) FROM Cliente c");
            return ((Long) query.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}

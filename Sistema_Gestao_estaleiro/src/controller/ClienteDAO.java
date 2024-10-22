package controller;

import model.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ClienteDAO {

    // Método para inserir um novo cliente
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

    // Método para alterar um cliente existente
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

    // Método para atualizar um cliente (funciona de forma semelhante ao alterar)
    public void atualizar(Cliente cliente) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cliente);  // Atualiza o cliente existente
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // Método para excluir um cliente
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

    // Método para listar todos os clientes
    public List<Cliente> listarTodos() throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("FROM Cliente");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para buscar um cliente pelo código
    public Cliente buscarPorCodigo(Long codigo) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            return em.find(Cliente.class, codigo);
        } finally {
            em.close();
        }
    }

    // Método para pesquisar clientes pelo nome
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

    // Método para recuperar um cliente pelo código
    public Cliente recuperar(int codigo) throws Exception {
        return buscarPorCodigo((long) codigo);
    }

    // Método para contar o número total de clientes
    public int contarCliente() throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(c) FROM Cliente c");
            return ((Long) query.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

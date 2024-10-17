/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nelson Matsinhe
 */


public class FuncionarioDAO {
    private static final Logger LOGGER = Logger.getLogger(FuncionarioDAO.class.getName());

    // Método para obter um EntityManager
    private EntityManager getEntityManager() {
        return JpaUtil.getEntityManager();
    }

    // Método para salvar um novo funcionário
    public void salvar(Funcionario funcionario) {
    EntityManager em = JpaUtil.getEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {
        tx.begin();
        
        // Verifica se existe um funcionário com o mesmo nome ativo
        TypedQuery<Long> query = em.createQuery(
            "SELECT COUNT(f) FROM Funcionario f WHERE f.nome = :nome AND f.estado = true", Long.class);
        query.setParameter("nome", funcionario.getNome());
        Long count = query.getSingleResult();

        if (count > 0) {
            throw new IllegalArgumentException("Já existe um funcionário com este nome ativo.");
        }

        // Se não existir duplicidade, salva o novo funcionário
        em.merge(funcionario); // Use merge aqui
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


    // Método para buscar um funcionário pelo ID
    public Funcionario buscarPorId(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    // Método para listar todos os funcionários ativos
    public List<Funcionario> listarTodos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.estado = true", Funcionario.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para listar todos os funcionários inativos
    public List<Funcionario> listarInativos() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.estado = false", Funcionario.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para pesquisar funcionários ativos pelo nome
    public List<Funcionario> pesquisarAtivosPorNome(String nome) {
        return pesquisarPorNome(nome, true);
    }

    // Método para pesquisar funcionários inativos pelo nome
    public List<Funcionario> pesquisarInativosPorNome(String nome) {
        return pesquisarPorNome(nome, false);
    }

    private List<Funcionario> pesquisarPorNome(String nome, boolean estado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.nome LIKE :nome AND f.estado = :estado", Funcionario.class);
            query.setParameter("nome", "%" + nome + "%");
            query.setParameter("estado", estado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para atualizar as informações de um funcionário
    public void atualizar(Funcionario funcionario) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(funcionario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erro ao atualizar funcionário", e);
        } finally {
            em.close();
        }
    }

    // Método para desativar um funcionário (não remover do banco de dados)
    public void remover(Long id) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Funcionario funcionario = em.find(Funcionario.class, id);
            if (funcionario != null) {
                funcionario.setEstado(false); // Define o estado como inativo
                em.merge(funcionario);       // Atualiza o funcionário no banco de dados
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            LOGGER.log(Level.SEVERE, "Erro ao remover funcionário", e);
        } finally {
            em.close();
        }
    }

    // Método para verificar se um funcionário com o mesmo nome já existe e está ativo
    public boolean existeFuncionarioAtivoComNome(String nome) {
        EntityManager em = getEntityManager();
        Long count;
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(f) FROM Funcionario f WHERE f.nome = :nome AND f.estado = true", Long.class);
            query.setParameter("nome", nome);
            count = query.getSingleResult();
        } finally {
            em.close();
        }
        return count > 0; // Retorna true se existir funcionário ativo com o mesmo nome
    }
    
    // Método para contar o número de funcionários ativos
    public Long contarFuncionariosAtivos() {
        EntityManager em = getEntityManager();
        Long count;
        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(f) FROM Funcionario f WHERE f.estado = true", Long.class);
            count = query.getSingleResult();
        } finally {
            em.close();
        }
        return count;
    }
}

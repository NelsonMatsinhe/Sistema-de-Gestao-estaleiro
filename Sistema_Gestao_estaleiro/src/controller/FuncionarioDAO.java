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

/**
 *
 * @author Nelson Matsinhe
 */



public class FuncionarioDAO {

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
            em.persist(funcionario);
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
        EntityManager em = JpaUtil.getEntityManager();
        Funcionario funcionario = null;
        try {
            funcionario = em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
        return funcionario;
    }

    // Método para listar todos os funcionários ativos
    public List<Funcionario> listarTodos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.estado = true", Funcionario.class);
            funcionarios = query.getResultList();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    // Método para listar todos os funcionários inativos
    public List<Funcionario> listarInativos() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.estado = false", Funcionario.class);
            funcionarios = query.getResultList();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    // Método para pesquisar funcionários ativos pelo nome
    public List<Funcionario> pesquisarAtivosPorNome(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.nome LIKE :nome AND f.estado = true", Funcionario.class);
            query.setParameter("nome", "%" + nome + "%");
            funcionarios = query.getResultList();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    // Método para pesquisar funcionários inativos pelo nome
    public List<Funcionario> pesquisarInativosPorNome(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Funcionario> funcionarios = null;
        try {
            TypedQuery<Funcionario> query = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.nome LIKE :nome AND f.estado = false", Funcionario.class);
            query.setParameter("nome", "%" + nome + "%");
            funcionarios = query.getResultList();
        } finally {
            em.close();
        }
        return funcionarios;
    }

    // Método para atualizar as informações de um funcionário
    public void atualizar(Funcionario funcionario) {
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(funcionario);
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

    // Método para desativar um funcionário (não remover do banco de dados)
    public void remover(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
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
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Método para verificar se um funcionário com o mesmo nome já existe e está ativo
    public boolean existeFuncionarioAtivoComNome(String nome) {
        EntityManager em = JpaUtil.getEntityManager();
        Long count = null;
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
        EntityManager em = JpaUtil.getEntityManager();
        Long count = null;
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

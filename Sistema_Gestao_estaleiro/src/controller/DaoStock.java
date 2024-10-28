/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;
import controller.JpaUtil;
import model.Material;
import model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import java.util.List;

import javax.persistence.EntityManager;

/**
 *
 * @author Nelson Matsinhe
 */
public class DaoStock {

    // Lista todos os produtos
    public List<Produto> listarTodosProdutos() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Produto> query = entityManager.createQuery("SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Lista todos os materiais
    public List<Material> listarTodosMateriais() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Material> query = entityManager.createQuery("SELECT m FROM Material m", Material.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Conta o total de produtos
    public long contarProdutos() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(p) FROM Produto p", Long.class);
            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    // Conta o total de materiais
    public long contarMateriais() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(m) FROM Material m", Long.class);
            return query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    // Lista produtos com quantidade abaixo de 50
    public List<Produto> listarProdutosComQuantidadeBaixa() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Produto> query = entityManager.createQuery(
                    "SELECT p FROM Produto p WHERE p.quantidade < 50", Produto.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    // Lista materiais com quantidade abaixo de 50
    public List<Material> listarMateriaisComQuantidadeBaixa() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        try {
            TypedQuery<Material> query = entityManager.createQuery(
                    "SELECT m FROM Material m WHERE m.quantidade < 50", Material.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}

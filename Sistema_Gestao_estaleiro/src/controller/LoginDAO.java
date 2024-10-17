/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Usuario;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoginDAO {

    public Usuario autenticar(String userName, String senha) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = null;

        try {
            // Consulta para autenticação, verificando se o usuário está ativo (estado = true)
            TypedQuery<Usuario> query = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.userName = :userName AND u.senha = :senha AND u.estado = true",
                    Usuario.class
            );
            query.setParameter("userName", userName);
            query.setParameter("senha", senha);

            usuario = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Usuário ou senha inválidos, ou usuário inativo.");
        } finally {
            em.close();
        }

        return usuario;
    }

    public String verificarPerfil(Usuario usuario) {
        String perfil = usuario.getFuncionario().getCargo().name();

        switch (perfil.toLowerCase()) {
            case "operador":
                return "Operador";
            case "gerente":
                return "Gerente";
            case "administrador":
                return "Administrador";
            default:
                return "Perfil desconhecido";
        }
    }
}

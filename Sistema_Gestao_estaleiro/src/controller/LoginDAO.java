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
            // Consulta para autenticação
            TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u WHERE u.userName = :userName AND u.senha = :senha", 
                Usuario.class
            );
            query.setParameter("userName", userName);
            query.setParameter("senha", senha);

            usuario = query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Usuário ou senha inválidos.");
        } finally {
            em.close();
        }

        return usuario;
    }

    public String verificarPerfil(Usuario usuario) {
        String perfil = usuario.getPerfil();

        switch (perfil.toLowerCase()) {
            case "admin":
                return "Admin";
            case "superadmin":
                return "SuperAdmin";
            case "user":
                return "User";
            default:
                return "Perfil desconhecido";
        }
    }
}

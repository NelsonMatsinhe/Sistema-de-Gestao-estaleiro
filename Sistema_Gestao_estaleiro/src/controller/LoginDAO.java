package controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import model.Usuario;

/**
 * Classe responsável pela autenticação de usuários.
 */
public class LoginDAO {

    /**
     * Método para autenticar o usuário com base no nome de usuário e senha.
     * 
     * @param userName Nome de usuário
     * @param senha Senha do usuário
     * @return O objeto Usuario autenticado ou null se falhar
     */
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

    /**
     * Método para verificar o perfil do usuário com base no cargo do funcionário.
     * 
     * @param usuario O usuário autenticado
     * @return Uma string representando o perfil do usuário
     */
    public String verificarPerfil(Usuario usuario) {
        if (usuario == null || usuario.getFuncionario() == null) {
            return "Perfil desconhecido";
        }

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

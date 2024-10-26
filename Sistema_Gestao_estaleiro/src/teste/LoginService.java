package teste;

import controller.LoginDAO;
import model.Usuario;

/**
 * Classe de teste para autenticação de usuários.
 */
public class LoginService {
    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();

        String userName = "vasco123";
        String senha = "senha123";

        // Autentica o usuário com base nas credenciais fornecidas
        Usuario usuarioAutenticado = loginDAO.autenticar(userName, senha);

        if (usuarioAutenticado != null) {
            // Verifica se o usuário está ativo
            if (usuarioAutenticado.getEstado()) {
                String perfil = loginDAO.verificarPerfil(usuarioAutenticado);
                System.out.println("Usuário autenticado como: " + perfil);

                // Ações com base no perfil
                switch (perfil) {
                    case "operador":
                        System.out.println("Bem-vindo Operador");
                        break;
                    case "gerente":
                        System.out.println("Bem-vindo Gerente");
                        break;
                    case "administrador":
                        System.out.println("Bem-vindo Administrador");
                        break;
                    default:
                        System.out.println("Perfil desconhecido.");
                }
            } else {
                System.out.println("Usuário inativo. Entre em contato com o administrador.");
            }
        } else {
            System.out.println("Falha na autenticação. Verifique o nome de usuário e a senha.");
        }
    }
}

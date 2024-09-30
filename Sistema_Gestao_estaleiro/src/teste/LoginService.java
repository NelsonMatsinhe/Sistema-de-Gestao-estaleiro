/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package teste;

import controller.LoginDAO;
import model.Usuario;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoginService {
    public static void main(String[] args) {
        LoginDAO loginDAO = new LoginDAO();

        String userName = "vasco123";
        String senha = "senha123";

        Usuario usuarioAutenticado = loginDAO.autenticar(userName, senha);

        if (usuarioAutenticado != null) {
            String perfil = loginDAO.verificarPerfil(usuarioAutenticado);
            System.out.println("Usuário autenticado como: " + perfil);
            
            // Ações com base no perfil
            if (perfil.equals("Admin")) {
                System.out.println("Bem vendo Admin ");
            } else if (perfil.equals("SuperAdmin")) {
                System.out.println("Bem vendo SuperAdmin ");
            } else if (perfil.equals("User")) {
               System.out.println("Bem vendo User ");
            }
        } else {
            System.out.println("Falha na autenticação.");
        }
    }
}

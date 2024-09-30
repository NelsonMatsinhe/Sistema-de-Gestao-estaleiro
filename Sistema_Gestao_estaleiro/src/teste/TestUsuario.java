/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package teste;
import controller.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Nelson Matsinhe
 */

public class TestUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Criar novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome("vasco");
        novoUsuario.setUserName("vasco123");
        novoUsuario.setSenha("senha123");
        novoUsuario.setPerfil("user");
        novoUsuario.setEstado(true);

        // Inserir usuário
        usuarioDAO.salvar(novoUsuario);
        System.out.println("Usuário inserido com sucesso!");

        // Listar todos os usuários para verificar se a inserção foi bem-sucedida
        for (Usuario usuario : usuarioDAO.listarTodos()) {
            System.out.println("ID: " + usuario.getCodigoUsuario() + " Nome: " + usuario.getNome());
        }
    }
}

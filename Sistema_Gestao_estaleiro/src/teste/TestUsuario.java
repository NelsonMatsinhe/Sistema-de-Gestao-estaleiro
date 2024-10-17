package teste;

import controller.UsuarioDAO;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Nelson Matsinhe
 */
public class TestUsuario {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Criar um novo funcionário para associar ao usuário
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome("Vasco Oliveira");
        novoFuncionario.setCargo(model.Cargo.OPERADOR); // Exemplo de cargo

        // Criar novo usuário
        Usuario novoUsuario = new Usuario();
        novoUsuario.setUserName("vasco123");
        novoUsuario.setSenha("senha123");
        novoUsuario.setEstado(true); // Ativo
        novoUsuario.setFuncionario(novoFuncionario); // Associa o funcionário ao usuário

        // Inserir usuário
        usuarioDAO.salvar(novoUsuario);
        System.out.println("Usuário inserido com sucesso!");

        // Listar todos os usuários ativos para verificar se a inserção foi bem-sucedida
        for (Usuario usuario : usuarioDAO.listarTodosAtivos()) {
            System.out.println("ID: " + usuario.getCodigoUsuario() + " Nome: " + usuario.getFuncionario().getNome() + " Username: " + usuario.getUserName());
        }
    }
}

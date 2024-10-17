/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package teste;

import controller.FuncionarioDAO;
import java.util.List;
import model.Cargo;
import model.Funcionario;

/**
 *
 * @author Nelson Matsinhe
 */
public class TestFuncionario {

 

    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        // 1. Cadastrar novos funcionários
        cadastrarFuncionarios(funcionarioDAO);

        // 2. Listar todos os funcionários ativos
        listarFuncionariosAtivos(funcionarioDAO);

        // 3. Listar todos os funcionários inativos
        listarFuncionariosInativos(funcionarioDAO);

        // 4. Pesquisar funcionários ativos por nome
        pesquisarFuncionariosAtivosPorNome(funcionarioDAO, "João");

        // 5. Pesquisar funcionários inativos por nome
        pesquisarFuncionariosInativosPorNome(funcionarioDAO, "João");

        // 6. Atualizar um funcionário
        atualizarFuncionario(funcionarioDAO, 1L, "João Silva", Cargo.OPERADOR);

        // 7. Desativar (remover) um funcionário
        desativarFuncionario(funcionarioDAO, 2L);

        // 8. Contar o número de funcionários ativos
        contarFuncionariosAtivos(funcionarioDAO);
    }

    // Método para cadastrar novos funcionários
    private static void cadastrarFuncionarios(FuncionarioDAO funcionarioDAO) {
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNome("João da Silva");
        funcionario1.setCargo(Cargo.OPERADOR);
        funcionario1.setEstado(true); // Ativo

        Funcionario funcionario2 = new Funcionario();
        funcionario2.setNome("Maria Oliveira");
        funcionario2.setCargo(Cargo.SUPERVISOR);
        funcionario2.setEstado(true); // Ativo

        Funcionario funcionario3 = new Funcionario();
        funcionario3.setNome("Pedro Sousa");
        funcionario3.setCargo(Cargo.OPERADOR);
        funcionario3.setEstado(false); // Inativo

        // Salvando os funcionários
        funcionarioDAO.salvar(funcionario1);
        funcionarioDAO.salvar(funcionario2);
        funcionarioDAO.salvar(funcionario3);
        
        System.out.println("Funcionários cadastrados com sucesso!");
    }

    // Método para listar todos os funcionários ativos
    private static void listarFuncionariosAtivos(FuncionarioDAO funcionarioDAO) {
        List<Funcionario> funcionariosAtivos = funcionarioDAO.listarTodos();
        System.out.println("\nFuncionários Ativos:");
        for (Funcionario f : funcionariosAtivos) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    // Método para listar todos os funcionários inativos
    private static void listarFuncionariosInativos(FuncionarioDAO funcionarioDAO) {
        List<Funcionario> funcionariosInativos = funcionarioDAO.listarInativos();
        System.out.println("\nFuncionários Inativos:");
        for (Funcionario f : funcionariosInativos) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    // Método para pesquisar funcionários ativos por nome
    private static void pesquisarFuncionariosAtivosPorNome(FuncionarioDAO funcionarioDAO, String nome) {
        List<Funcionario> funcionariosAtivos = funcionarioDAO.pesquisarAtivosPorNome(nome);
        System.out.println("\nFuncionários Ativos com nome semelhante a '" + nome + "':");
        for (Funcionario f : funcionariosAtivos) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    // Método para pesquisar funcionários inativos por nome
    private static void pesquisarFuncionariosInativosPorNome(FuncionarioDAO funcionarioDAO, String nome) {
        List<Funcionario> funcionariosInativos = funcionarioDAO.pesquisarInativosPorNome(nome);
        System.out.println("\nFuncionários Inativos com nome semelhante a '" + nome + "':");
        for (Funcionario f : funcionariosInativos) {
            System.out.println("ID: " + f.getId() + " | Nome: " + f.getNome() + " | Cargo: " + f.getCargo());
        }
    }

    // Método para atualizar um funcionário
    private static void atualizarFuncionario(FuncionarioDAO funcionarioDAO, Long id, String novoNome, Cargo novoCargo) {
        Funcionario funcionario = funcionarioDAO.buscarPorId(id);
        if (funcionario != null) {
            funcionario.setNome(novoNome);
            funcionario.setCargo(novoCargo);
            funcionarioDAO.atualizar(funcionario);
            System.out.println("\nFuncionário atualizado: ID = " + funcionario.getId() + " | Nome: " + funcionario.getNome());
        } else {
            System.out.println("\nFuncionário não encontrado.");
        }
    }

    // Método para desativar um funcionário
    private static void desativarFuncionario(FuncionarioDAO funcionarioDAO, Long id) {
        funcionarioDAO.remover(id);
        System.out.println("\nFuncionário desativado com ID = " + id);
    }

    // Método para contar o número de funcionários ativos
    private static void contarFuncionariosAtivos(FuncionarioDAO funcionarioDAO) {
        Long totalAtivos = funcionarioDAO.contarFuncionariosAtivos();
        System.out.println("\nTotal de Funcionários Ativos: " + totalAtivos);
    }
}


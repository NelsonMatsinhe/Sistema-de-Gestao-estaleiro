import controller.ProducaoDAO;
import model.Funcionario;
import model.Maquina;
import model.Produto;
import model.Producao;

import java.util.Date;
import java.util.Scanner;

/**
 * Classe Main para registrar uma produção no sistema.
 * Coleta dados de entrada e salva no banco de dados.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProducaoDAO producaoDAO = new ProducaoDAO();
        
        // Coletando dados para registrar uma produção
        System.out.println("=== Registro de Produção ===");

        // Produto
        System.out.print("Informe o ID do produto: ");
        Long produtoId = scanner.nextLong();
        Produto produto = buscarProdutoPorId(produtoId);  // Supondo que exista um método para buscar Produto
        
        // Funcionário
        System.out.print("Informe o ID do funcionário: ");
        Long funcionarioId = scanner.nextLong();
        Funcionario funcionario = buscarFuncionarioPorId(funcionarioId);  // Supondo que exista um método para buscar Funcionário

        // Máquina
        System.out.print("Informe o ID da máquina: ");
        Long maquinaId = scanner.nextLong();
        Maquina maquina = buscarMaquinaPorId(maquinaId);  // Supondo que exista um método para buscar Máquina
        
        // Quantidade produzida
        System.out.print("Informe a quantidade produzida: ");
        int quantidadeProduzida = scanner.nextInt();
        
        // Data de produção (usando a data atual)
        Date dataProducao = new Date();
        
        // Criação de uma nova produção
        Producao producao = new Producao();
        producao.setProduto(produto);
        producao.setFuncionario(funcionario);
        producao.setMaquina(maquina);
        producao.setQuantidadeProduzida(quantidadeProduzida);
        producao.setDataProducao(dataProducao);
        producao.setProntaParaUso(false);  // Inicialmente, produção não está pronta
        
        // Salvando a produção no banco de dados
        producaoDAO.salvar(producao);
        System.out.println("Produção registrada com sucesso!");

        scanner.close();
    }
    
    // Método simulado para buscar produto pelo ID
    private static Produto buscarProdutoPorId(Long id) {
        // Simulação de busca de produto - aqui você implementaria a lógica real de busca
        Produto produto = new Produto();
        produto.setId(id );
        produto.setNome("Produto Teste");
        return produto;
    }

    // Método simulado para buscar funcionário pelo ID
    private static Funcionario buscarFuncionarioPorId(Long id) {
        // Simulação de busca de funcionário - aqui você implementaria a lógica real de busca
        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setNome("Funcionario Teste");
        return funcionario;
    }

    // Método simulado para buscar máquina pelo ID
    private static Maquina buscarMaquinaPorId(Long id) {
        // Simulação de busca de máquina - aqui você implementaria a lógica real de busca
        Maquina maquina = new Maquina();
        maquina.setId(id);
        maquina.setNome("Máquina Teste");
        maquina.setDisponivel(true);
        return maquina;
    }
}

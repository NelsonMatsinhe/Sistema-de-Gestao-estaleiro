import controller.ProducaoDAO;
import model.Funcionario;
import model.Maquina;
import model.Produto;
import model.Producao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Classe Main para registrar uma produção no sistema.
 * Coleta dados de entrada e salva no banco de dados.
 */
public class Main {

    public static void main(String[] args) {
 ProducaoDAO producaoDAO = new ProducaoDAO();
List<Object[]> producoesComAtributos = producaoDAO.listarProducoesComAtributos();

for (Object[] linha : producoesComAtributos) {
    System.out.println("Produção ID: " + linha[0]);
    System.out.println("Produto Nome: " + linha[1]);
    System.out.println("Categoria: " + linha[2]);
    System.out.println("Quantidade Produzida: " + linha[3]);
    System.out.println("Data de Produção: " + linha[4]);
    System.out.println("Funcionário Nome: " + linha[5]);
    System.out.println("Máquina Nome: " + linha[6]);
    System.out.println("Estado: " + linha[7]);
    System.out.println("Lote ID: " + linha[8]);
    System.out.println("Número do Lote: " + linha[9]);
    System.out.println("Quantidade Inicial: " + linha[10]);
    System.out.println("Quantidade Atual: " + linha[11]);
    System.out.println("Data de Criação: " + linha[12]);
    System.out.println("Data Final de Cura: " + linha[13]);
    System.out.println("Pronta Para Uso: " + linha[14]);
    System.out.println("----------------------------");
}

}
}
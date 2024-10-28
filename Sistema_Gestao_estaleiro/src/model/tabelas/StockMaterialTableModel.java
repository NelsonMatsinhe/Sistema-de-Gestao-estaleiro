/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.tabelas;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Material;

/**
 * Classe que define o modelo para a tabela contendo dados de Material no estoque.
 * Exibe as informações: Código, Nome e Quantidade.
 * 
 * @author Nelson Matsinhe
 */
public class StockMaterialTableModel extends AbstractTableModel {

    private String colunas[] = {"Código", "Nome", "Quantidade"};
    private List<Material> dados;

    @Override
    public int getRowCount() {
        if (dados == null) {
            return 0;
        }
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Material material = dados.get(linha);
        switch (coluna) {
            case 0:
                return material.getId(); // Código do material
            case 1:
                return material.getNome();   // Nome do material
            case 2:
                return material.getQuantidade(); // Quantidade disponível
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public boolean isCellEditable(int linha, int coluna) {
        return false;
    }

    // Define os dados da tabela e notifica a mudança
    public void setDados(List<Material> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    // Retorna um objeto Material da linha especificada
    public Material getRowValue(int linha) {
        return dados.get(linha);
    }
}

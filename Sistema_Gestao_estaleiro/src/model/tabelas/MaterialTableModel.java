package model.tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Material;

/**
 * Classe que define o modelo para tabela contendo dados de Material.
 *
 * @author Nelson Matsinhe
 */
public class MaterialTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome", "Quantidade", "Unidade", "Preço", "Fornecedor"};
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
    public Object getValueAt(int l, int c) {
        Material material = dados.get(l);
        switch (c) {
            case 0:
                return material.getId(); // ID do material
            case 1:
                return material.getNome(); // Nome do material
            case 2:
                return material.getQuantidade(); // Quantidade disponível
            case 3:
                return material.getUnidade(); // Unidade de medida (ex: kg, m3, etc.)
            case 4:
                return material.getPreco(); // Preço do material
            case 5:
                return material.getFornecedor() != null ? material.getFornecedor().getNome() : "Sem Fornecedor"; // Nome do fornecedor
            default:
                throw new IndexOutOfBoundsException("Coluna inexistente!");
        }
    }

    @Override
    public String getColumnName(int c) {
        return colunas[c];
    }

    @Override
    public boolean isCellEditable(int l, int c) {
        return false;
    }

    // Define os dados da tabela e notifica a mudança
    public void setDados(List<Material> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    // Retorna um objeto Material da linha especificada
    public Material getRowValue(int l) {
        return dados.get(l);
    }
}

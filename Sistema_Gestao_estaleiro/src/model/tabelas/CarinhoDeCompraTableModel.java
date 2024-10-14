package model.tabelas;

import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.CarinhoDeCompra;

/**
 * Classe que define o modelo para tabela contendo dados dos itens da venda
 *
 * @author Nelson Matsinhe
 */
public class CarinhoDeCompraTableModel extends AbstractTableModel {

    private final NumberFormat NF = NumberFormat.getNumberInstance();
    
    private String colunas[] = {"Produto", "Quantidade", "Valor Unitário"};
    private List<CarinhoDeCompra> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
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
        CarinhoDeCompra itemVenda = dados.get(l);
        switch (c) {
            case 0:
                return itemVenda.getProduto().getNome();
            case 1:
                return NF.format(itemVenda.getQuantidade());
            case 2:
                return (itemVenda.getValorUnitario());
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

    public void setDados(List<CarinhoDeCompra> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public CarinhoDeCompra getRowValue(int l) {
        return dados.get(l);
    }
}

package model.tabelas;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Produto;

/**
 * Classe que define o modelo para tabela contendo dados do produto
 *
 * @author Nelson Matsinhe
 */
public class ProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"Codigo","Nome","Tipo","Categoria","Quantidade","Preco"};
    private List<Produto> dados;

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
        Produto produto = dados.get(l);
        switch (c) {
            case 0:
                return produto.getId();
                case 1:
                return produto.getNome();
                case 2:
                return produto.getTipo();
                case 3:
                return produto.getCategoria();
                case 4:
                return produto.getQuantidadeDisponivel();
                case 5:
                return produto.getPreco();
                
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

    public void setDados(List<Produto> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Produto getRowValue(int l) {
        return dados.get(l);
    }
}

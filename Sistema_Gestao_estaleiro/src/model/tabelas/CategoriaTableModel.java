package model.tabelas;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Categoria;
import model.Cliente;

/**
 * Classe que define o modelo para tabela contendo dados do cliente
 *
 * @author Nelson Matsinhe
 */
public class CategoriaTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome"};
    private List<Categoria> dados;

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
    Categoria categoria = dados.get(l);
    switch (c) {
        case 0:
            return categoria .getId();
        case 1:
            return categoria .getNome();
        
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

    public void setDados(List<Categoria> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Categoria getRowValue(int l) {
        return dados.get(l);
    }
}

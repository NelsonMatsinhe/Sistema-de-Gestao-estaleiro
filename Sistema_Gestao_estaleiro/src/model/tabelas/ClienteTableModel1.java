package model.tabelas;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Cliente;

/**
 * Classe que define o modelo para tabela contendo dados do cliente
 *
 * @author Timana
 */
public class ClienteTableModel1 extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome","Telefone","Endereco"};
    private List<Cliente> dados;

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
    Cliente cliente = dados.get(l);
    switch (c) {
        case 0:
            return cliente.getId();
        case 1:
            return cliente.getNome();
        case 2:
            return cliente.getTelefone();
        case 3:
            return cliente.getEndereco();
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

    public void setDados(List<Cliente> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Cliente getRowValue(int l) {
        return dados.get(l);
    }
}

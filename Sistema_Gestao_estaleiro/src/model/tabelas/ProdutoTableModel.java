package model.tabelas;

import model.Produto;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ProdutoTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome", "Categoria", "Tempo de Cura", "Data de Registro"};
    private List<Produto> dados;

    public ProdutoTableModel() {
        this.dados = new ArrayList<>(); // Inicializa a lista
    }

    @Override
    public int getRowCount() {
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
                return produto.getCategoria(); // Adiciona categoria
            case 3:
                return produto.getTempoCura(); // Adiciona tempo de cura
            case 4:
                return produto.getDataRegistro(); // Adiciona data de registro

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
        return false; // Tabela não editável diretamente
    }

    public void setDados(List<Produto> dados) {
        this.dados = dados != null ? new ArrayList<>(dados) : new ArrayList<>();
        fireTableDataChanged(); // Notifica a tabela de que os dados mudaram
    }

    public void addProduto(Produto produto) {
        dados.add(produto);
        fireTableRowsInserted(dados.size() - 1, dados.size() - 1); // Notifica a inserção
    }

    public void updateProduto(int index, Produto produto) {
        if (index >= 0 && index < dados.size()) {
            dados.set(index, produto);
            fireTableRowsUpdated(index, index); // Notifica a atualização
        }
    }

    public void removeProduto(int index) {
        if (index >= 0 && index < dados.size()) {
            dados.remove(index);
            fireTableRowsDeleted(index, index); // Notifica a remoção
        }
    }

    public Produto getRowValue(int l) {
        return dados.get(l);
    }
}

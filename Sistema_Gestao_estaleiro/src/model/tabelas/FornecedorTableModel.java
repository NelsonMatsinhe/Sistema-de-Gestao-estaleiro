/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Fornecedor;

/**
 *
 * @author Nelson Matsinhe
 */


/**
 * Classe que define o modelo para tabela contendo dados do fornecedor.
 *
 * @author Nelson Matsinhe
 */
public class FornecedorTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome", "Nuit", "Morada", "Telefone", "Email"};
    private List<Fornecedor> dados;

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
        Fornecedor fornecedor = dados.get(l);
        switch (c) {
            case 0:
                return fornecedor.getId();
            case 1:
                return fornecedor.getNome();
            case 2:
                return fornecedor.getNuit();
            case 3:
                return fornecedor.getMorada();
            case 4:
                return fornecedor.getTelefone();
            case 5:
                return fornecedor.getEmail();
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

    public void setDados(List<Fornecedor> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Fornecedor getRowValue(int l) {
        return dados.get(l);
    }
}

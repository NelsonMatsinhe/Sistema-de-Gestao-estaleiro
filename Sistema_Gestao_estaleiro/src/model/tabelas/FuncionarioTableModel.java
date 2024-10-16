/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tabelas;

import model.Funcionario;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */

public class FuncionarioTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome", "Função"};
    private List<Funcionario> dados;

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
        Funcionario funcionario = dados.get(l);
        switch (c) {
            case 0:
                return funcionario.getId();
            case 1:
                return funcionario.getNome();
            case 2:
                return funcionario.getCargo();
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

    public void setDados(List<Funcionario> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Funcionario getRowValue(int l) {
        return dados.get(l);
    }
}

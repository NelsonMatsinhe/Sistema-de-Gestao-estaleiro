/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tabelas;

import model.Maquina;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class MaquinaTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome ", "Tipo", "Alocada"};
    private List<Maquina> dados;

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
        Maquina maquina = dados.get(l);
        switch (c) {
            case 0:
                return maquina.getId();
            case 1:
                return maquina.getNome();
            case 2:
                return maquina.getTipo();
            case 3:
                return maquina.isEstado() ? "Activo" : "Não Acivo";
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

    public void setDados(List<Maquina> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Maquina getRowValue(int l) {
        return dados.get(l);
    }
}

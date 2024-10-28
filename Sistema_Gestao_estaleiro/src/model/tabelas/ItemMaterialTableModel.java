/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.tabelas;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.ItemMaterial;

/**
 *
 * @author Nelson Matsinhe
 */

public class ItemMaterialTableModel extends AbstractTableModel {

    private String[] colunas = {"Código", "Nome do Material", "Quantidade"};
    private List<ItemMaterial> dados;

    @Override
    public int getRowCount() {
        return (dados == null) ? 0 : dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int l, int c) {
        ItemMaterial item = dados.get(l);
        switch (c) {
            case 0:
                return item.getCodigo(); // Código do item
            case 1:
                return item.getMaterial().getNome(); // Nome do material
            case 2:
                return item.getQuantidade(); // Quantidade do item
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
    public void setDados(List<ItemMaterial> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    // Retorna um objeto ItemMaterial da linha especificada
    public ItemMaterial getRowValue(int l) {
        return dados.get(l);
    }
}

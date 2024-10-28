/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.tabelas;

/**
 *
 * @author Nelson Matsinhe
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class LowStockCellRenderer extends DefaultTableCellRenderer {

    private int limiteEstoque;

    public LowStockCellRenderer(int limiteEstoque) {
        this.limiteEstoque = limiteEstoque;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        // Renderiza a célula normalmente
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Obtenha o valor da quantidade
        int quantidade = (int) table.getModel().getValueAt(row, 2); // Coluna de Quantidade

        // Condição para pintar a linha
        if (quantidade < limiteEstoque) {
            cell.setBackground(Color.RED); // Define a cor vermelha para estoque baixo
            cell.setForeground(Color.WHITE); // Define o texto em branco para contraste
        } else {
            cell.setBackground(Color.WHITE); // Cor padrão de fundo
            cell.setForeground(Color.BLACK); // Cor padrão de texto
        }

        return cell;
    }
}


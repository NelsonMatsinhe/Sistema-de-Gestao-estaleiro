/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.tabelas;
import model.Producao;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */


public class ProducaoTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Produto", "Funcionário", "Quantidade Produzida", "Data de Produção"};
    private List<Producao> dados;

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
        Producao producao = dados.get(l);
        switch (c) {
            case 0:
                return producao.getId();
            case 1:
                return producao.getProduto().getNome(); // Supondo que Produto tenha um método getNome
            case 2:
                return producao.getFuncionario().getNome(); // Supondo que Funcionario tenha um método getNome
            case 3:
                return producao.getQuantidadeProduzida();
            case 4:
                return producao.getDataProducao();
//            case 5:
//                return producao.getDiasParaCura();
////            case 6:
//                return producao.isProntaParaUso() ? "Sim" : "Não";
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

    public void setDados(List<Producao> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Producao getRowValue(int l) {
        return dados.get(l);
    }
}

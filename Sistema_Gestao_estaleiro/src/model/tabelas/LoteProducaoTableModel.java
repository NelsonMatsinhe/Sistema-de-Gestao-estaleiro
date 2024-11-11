package model.tabelas;

import model.LoteProducao;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoteProducaoTableModel extends AbstractTableModel {

    private String colunas[] = {
        "ID", "Número do Lote", "Produto", "Quantidade Inicial", 
        "Quantidade Atual", "Quantidade Quebrada", "Data Criação", 
        "Data Final de Cura", "Percentual de Quebra", "Pronto para Uso"
    };
    
    private List<LoteProducao> dados;

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
        LoteProducao loteProducao = dados.get(l);
        switch (c) {
            case 0:
                return loteProducao.getId();
            case 1:
                return loteProducao.getNumeroLote();
            case 2:
                return loteProducao.getProducao().getProduto().getNome(); // Supondo que Produto tenha um método getNome
            case 3:
                return loteProducao.getQuantidadeInicial();
            case 4:
                return loteProducao.getQuantidadeAtual();
            case 5:
                return loteProducao.getQuantidadeQuebrada();
            case 6:
                return loteProducao.getDataCriacao();
            case 7:
                return loteProducao.getDataFinalCura();
            case 8:
                return String.format("%.2f%%", loteProducao.getPercentualQuebra()); // Percentual de Quebra
            case 9:
                return loteProducao.isProntaParaUso() ? "Sim" : "Não";
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

    public void setDados(List<LoteProducao> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public LoteProducao getRowValue(int l) {
        return dados.get(l);
    }
}

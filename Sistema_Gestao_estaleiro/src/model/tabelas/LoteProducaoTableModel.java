package model.tabelas;

import model.LoteProducao;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoteProducaoTableModel extends AbstractTableModel {

    private String colunas[] = {"Número do Lote", "Produto", "Quantidade Inicial", "Quantidade Atual", 
                                "Quantidade Quebrada", "Data Final de Cura", "Pronto para Uso"};
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
                return loteProducao.getNumeroLote();
            case 1:
                return loteProducao.getProducao().getProduto().getNome(); // Supondo que Produto tenha um método getNome
            case 2:
                return loteProducao.getQuantidadeInicial();
            case 3:
                return loteProducao.getQuantidadeAtual();
            case 4:
                return loteProducao.getQuantidadeQuebrada();
            case 5:
                return loteProducao.getDataFinalCura();
            case 6:
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

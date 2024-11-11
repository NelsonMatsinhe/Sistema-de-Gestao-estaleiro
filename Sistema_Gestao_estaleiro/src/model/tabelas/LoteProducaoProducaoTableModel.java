package model.tabelas;

import model.LoteProducao;
import model.Producao;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Nelson Matsinhe
 */
public class LoteProducaoProducaoTableModel extends AbstractTableModel {

    private String[] colunas = {
        "Número do Lote", "Produto", "Funcionário", "Quantidade Inicial", 
        "Quantidade Atual", "Quantidade Quebrada", "Data Final de Cura", "Pronto para Uso"
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
        Producao producao = loteProducao.getProducao(); // Acessando a produção associada ao lote
        
        switch (c) {
            case 0:
                return loteProducao.getNumeroLote();
            case 1:
                return producao.getProduto().getNome(); // Nome do Produto, que está em Producao
            case 2:
                return producao.getFuncionario().getNome(); // Nome do Funcionário
            case 3:
                return loteProducao.getQuantidadeInicial();
            case 4:
                return loteProducao.getQuantidadeAtual();
            case 5:
                return loteProducao.getQuantidadeQuebrada();
            case 6:
                return loteProducao.getDataFinalCura();
            case 7:
                return loteProducao.isProntaParaUso() ? "Sim" : "Não";
//            case 8:
//                return producao.getQuantidadeProduzida(); // Quantidade Produzida, que está em Producao
//            case 9:
//                return producao.getDataProducao(); // Data de Produção, que está em Producao
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

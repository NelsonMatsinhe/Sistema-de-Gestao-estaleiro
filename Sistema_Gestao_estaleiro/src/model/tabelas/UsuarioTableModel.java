package model.tabelas;


import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

/**
 * Classe que define o modelo para tabela contendo dados do cliente
 *
 * @author Nelson Matsinhe
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome","UserName","Senha","Perfil","Estado",};
    private List<Usuario> dados;

    @Override
    public int getRowCount() {
        if(dados == null){
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
    Usuario cliente = dados.get(l);
    switch (c) {
        case 0:
            return cliente.getCodigoUsuario();
        case 1:
            return cliente.getNome();
        case 2:
            return cliente.getUserName();
        case 3:
            return cliente.getSenha();
            case 4:
            return cliente.getPerfil();
            case 5:
            return cliente.getEstado();
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

    public void setDados(List<Usuario> dados) {
        this.dados = dados;
        fireTableDataChanged();
    }

    public Usuario getRowValue(int l) {
        return dados.get(l);
    }
}

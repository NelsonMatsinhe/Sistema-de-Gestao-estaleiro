        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.tabelas;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Usuario;

/**
 *
 * @author Nelson Matsinhe
 */


/**
 * Classe que define o modelo para tabela contendo dados do usuário.
 *
 * @author Nelson Matsinhe
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String colunas[] = {"Id", "Nome de Funcionário", "Nome de Usuário", "Senha", "Estado"};
    private List<Usuario> dados;

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
        Usuario usuario = dados.get(l);
        switch (c) {
            case 0:
                return usuario.getCodigoUsuario(); // Código do usuário
            case 1:
                return usuario.getFuncionario() != null ? usuario.getFuncionario().getNome() : "Sem Funcionário"; // Nome do funcionário
            case 2:
                return usuario.getUserName(); // Nome de usuário
            case 3:
                return usuario.getSenha(); // Senha
            case 4:
                return usuario.getEstado() ? "Ativo" : "Inativo"; // Estado (Ativo/Inativo)
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

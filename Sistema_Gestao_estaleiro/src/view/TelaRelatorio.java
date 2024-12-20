/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FuncionarioDAO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cargo;
import model.Cliente;
import model.Funcionario;
import model.tabelas.FuncionarioTableModel;
import model.tabelas.UsuarioTableModel;

//import model.Produto;
/**
 * class tela de registros das produto
 *
 * @author Nelson Matsinhe
 */
public class TelaRelatorio extends javax.swing.JInternalFrame {

    /**
     * Creates new form Produto
     */
    //GenericDAO prod = new GenericDAO<>(Produto.class);
    public TelaRelatorio() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        habilitarFormulario(false);
        carregarGrade();
         txtNome.requestFocus();

        // Adicionando os valores da enum Cargo no combo box
        for (Cargo cargo : Cargo.values()) {
            comboCargo.addItem(cargo.name());
        }

        // Botão Novo habilita o formulário
        btNovo.addActionListener(e -> habilitarFormulario(true));

        // Ação do botão Salvar
        btSalvar.addActionListener(e -> {
            if (validarFormulario()) {
                //    btEditarActionPerformed();
            }
        });

        // Ação do botão Editar
        // btEditar.addActionListener(e -> btEditarActionPerformed());
        // Validação ao mudar os campos
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                habilitarSalvar();
            }
        });

        comboCargo.addActionListener(e -> habilitarSalvar());

        rbtnAtivo.addActionListener(e -> habilitarSalvar());
        rbtnInativo.addActionListener(e -> habilitarSalvar());

        TbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectRegistryTable();
            }
        });

    }
    /**
     *
     * as cores da campos
     */
    Color d = new Color(255, 0, 51);
    Color f = new Color(219, 220, 252);

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    Funcionario funcionario = new Funcionario();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoGroup = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbFuncionario = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        comboCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        rbtnAtivo = new javax.swing.JRadioButton();
        rbtnInativo = new javax.swing.JRadioButton();
        lblMessagem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(51, 102, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtID.setPreferredSize(new java.awt.Dimension(300, 25));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");

        txtNome.setPreferredSize(new java.awt.Dimension(300, 25));
        txtNome.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        TbFuncionario.setModel(new FuncionarioTableModel());
        TbFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbFuncionario);

        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.setFocusable(false);
        btNovo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btNovo.setPreferredSize(new java.awt.Dimension(64, 22));
        btNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.setFocusable(false);
        btSalvar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btSalvar.setPreferredSize(new java.awt.Dimension(64, 22));
        btSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.setFocusable(false);
        btEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btEditar.setPreferredSize(new java.awt.Dimension(64, 22));
        btEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.setFocusable(false);
        btExcluir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btExcluir.setPreferredSize(new java.awt.Dimension(64, 22));
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(btSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        comboCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cargo:");

        rbtnAtivo.setBackground(new java.awt.Color(51, 102, 0));
        estadoGroup.add(rbtnAtivo);
        rbtnAtivo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAtivo.setText("Activo");
        rbtnAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAtivoActionPerformed(evt);
            }
        });

        rbtnInativo.setBackground(new java.awt.Color(51, 102, 0));
        estadoGroup.add(rbtnInativo);
        rbtnInativo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnInativo.setText("inactivo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1)
                .addGap(41, 41, 41))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addGap(403, 403, 403))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnAtivo)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnInativo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(lblMessagem, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(rbtnAtivo)
                    .addComponent(rbtnInativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMessagem, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(55, 55, 55)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)))
                .addGap(31, 31, 31))
        );

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registro de Relatorio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 960, 620);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed

    }//GEN-LAST:event_btNovoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {
            // Certifique-se de que o funcionário foi instanciado corretamente
            if (funcionario == null) {
                funcionario = new Funcionario();
            }

            funcionario.setNome(txtNome.getText());
            funcionario.setCargo(Cargo.valueOf(comboCargo.getSelectedItem().toString()));

            if (rbtnAtivo.isSelected()) {
                funcionario.setEstado(true);  // Ativo
            } else if (rbtnInativo.isSelected()) {
                funcionario.setEstado(false); // Inativo
            }

            // Verificar se o id é nulo e inicializá-lo se for o caso
            if (funcionario.getId() == null) {
                funcionario.setId(0L);  // Define o id como 0 (novo funcionário)
            }

            // Operação de salvar ou atualizar o funcionário
            if (funcionario.getId() == 0) {
                try {
                    funcionarioDAO.salvar(funcionario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o funcionário.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                // Código para atualizar o funcionário, caso seja necessário
            }

            habilitarFormulario(false);
            carregarGrade();
            limpaFormulario();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        if (!txtID.getText().isEmpty()) {
            Long id = Long.parseLong(txtID.getText());

            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este funcionário?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    funcionarioDAO.remover(id);  // Desativa o funcionário
                    JOptionPane.showMessageDialog(this, "Funcionário desativado com sucesso.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao desativar o funcionário.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                habilitarFormulario(false);
                carregarGrade();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um funcionário para excluir.");
        }


    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed

        if (validarFormulario()) {
            System.out.println("Formulário validado com sucesso."); // Adicione esta linha

            Long id;
            try {
                id = Long.parseLong(txtID.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Retorna se o ID não for válido
            }

            Funcionario funcionario = funcionarioDAO.buscarPorId(id);
            if (funcionario != null) {
                System.out.println("Funcionário encontrado: " + funcionario.getNome()); // Adicione esta linha

                funcionario.setNome(txtNome.getText());
                funcionario.setCargo(Cargo.valueOf(comboCargo.getSelectedItem().toString()));

                funcionario.setEstado(rbtnAtivo.isSelected());

                try {
                    funcionarioDAO.atualizar(funcionario); // Atualiza o funcionário
                    JOptionPane.showMessageDialog(this, "Funcionário atualizado com sucesso.");
                    limpaFormulario();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar o funcionário.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                habilitarFormulario(false);
                carregarGrade();
            } else {
                JOptionPane.showMessageDialog(this, "Funcionário não encontrado para edição.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Formulário inválido. Verifique os campos.");
        }


    }//GEN-LAST:event_btEditarActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyPressed

    private void TbFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbFuncionarioMouseClicked

    }//GEN-LAST:event_TbFuncionarioMouseClicked

    private void comboCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCargoActionPerformed

    private void rbtnAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnAtivoActionPerformed

    /**
     * Seleciona o registro da tabela e preenche o formulário.
     */
    public void selectRegistryTable() {
        int selectedRow = TbFuncionario.getSelectedRow();
        if (selectedRow != -1) {
            txtID.setText(TbFuncionario.getValueAt(selectedRow, 0).toString());
            txtNome.setText(TbFuncionario.getValueAt(selectedRow, 1).toString());

            String cargo = TbFuncionario.getValueAt(selectedRow, 2).toString();
            for (int i = 0; i < comboCargo.getItemCount(); i++) {
                if (comboCargo.getItemAt(i).toString().equals(cargo)) {
                    comboCargo.setSelectedIndex(i);
                    break;
                }
            }

            String estado = TbFuncionario.getValueAt(selectedRow, 3).toString();
            if (estado.equalsIgnoreCase("Ativo")) {
                rbtnAtivo.setSelected(true);
            } else {
                rbtnInativo.setSelected(true);
            }

            habilitarFormulario(true); // Habilita o formulário para edição
        }
    }

    /**
     * Método para habilitar ou desabilitar o formulário.
     */
    private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);
        btSalvar.setEnabled(ativo && validarFormulario()); // Habilitado apenas se for válido
        btCancelar.setEnabled(ativo);
        btExcluir.setEnabled(ativo);
        txtID.setEnabled(ativo);
        txtNome.setEnabled(ativo);
        comboCargo.setEnabled(ativo);
        rbtnAtivo.setEnabled(ativo);
        rbtnInativo.setEnabled(ativo);

        btEditar.setEnabled(TbFuncionario.getSelectedRow() >= 0 && ativo); // Habilitado se houver uma linha selecionada

        TbFuncionario.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }

    /**
     * Habilita o botão salvar se o formulário for válido.
     */
    private void habilitarSalvar() {
        btSalvar.setEnabled(validarFormulario());
    }

    /**
     * Limpa os campos do formulário.
     */
    private void limpaFormulario() {
        txtID.setText("");
        txtNome.setText("");
        comboCargo.setSelectedIndex(-1); // Nenhum cargo selecionado
        estadoGroup.clearSelection(); // Limpa a seleção dos botões de estado
        lblMessagem.setText("");
    }

    /**
     * Validação do formulário.
     */
    private boolean validarFormulario() {
        Border borderError = BorderFactory.createLineBorder(Color.RED, 2);  // Borda vermelha para erros
        Border borderNormal = BorderFactory.createLineBorder(Color.GRAY, 1); // Borda normal

        boolean isValid = true;

        // Validação do campo Nome
        if (txtNome.getText().isEmpty()) {
            txtNome.setBorder(borderError);
            lblMessagem.setText("Preencha o campo com um nome.");
            txtNome.requestFocus();
            isValid = false;
        } else if (txtNome.getText().trim().length() < 2) {
            txtNome.setBorder(borderError);
            lblMessagem.setText("Preencha o campo com um nome válido.");
            txtNome.requestFocus();
            isValid = false;
        } else {
            txtNome.setBorder(borderNormal);
        }

        // Validação do combo Cargo
        if (comboCargo.getSelectedItem() == null) {
            comboCargo.setBorder(borderError);
            lblMessagem.setText("Selecione um cargo.");
            isValid = false;
        } else {
            comboCargo.setBorder(borderNormal);
        }

        // Validação dos botões de rádio (estado)
        if (!rbtnAtivo.isSelected() && !rbtnInativo.isSelected()) {
            lblMessagem.setText("Selecione o estado (Ativo ou Inativo).");
            isValid = false;
        }

        return isValid;
    }

    private void carregarGrade() {
        FuncionarioTableModel tm = (FuncionarioTableModel) TbFuncionario.getModel();
        try {
            tm.setDados(funcionarioDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbFuncionario;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> comboCargo;
    private javax.swing.ButtonGroup estadoGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessagem;
    private javax.swing.JRadioButton rbtnAtivo;
    private javax.swing.JRadioButton rbtnInativo;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}

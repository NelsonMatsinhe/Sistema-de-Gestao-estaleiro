/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MaquinaDAO;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import model.Maquina;
import model.tabelas.MaquinaTableModel;

//import model.Produto;
/**
 * class tela de registros das produto
 *
 * @author Nelson Matsinhe
 */
public class TelaMaquina extends javax.swing.JInternalFrame {

    /**
     * Creates new form Maquina
     */
    //GenericDAO prod = new GenericDAO<>(Produto.class);
    public TelaMaquina() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        habilitarFormulario(false);
        carregarGrade();
        //  txtNome.requestFocus();

        // Botão Novo habilita o formulário
        btNovo.addActionListener(e -> habilitarFormulario(true));
        rbtnAtivo.addActionListener(e -> habilitarSalvar());
        rbtnInativo.addActionListener(e -> habilitarSalvar());
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

        TbMaquina.addMouseListener(new java.awt.event.MouseAdapter() {
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

    MaquinaDAO maquinaDAO = new MaquinaDAO();
    Maquina maquina = new Maquina();

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
        TbMaquina = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        rbtnAtivo = new javax.swing.JRadioButton();
        rbtnInativo = new javax.swing.JRadioButton();
        lblMessagem = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(51, 102, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setPreferredSize(new java.awt.Dimension(320, 30));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel6.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 320, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        txtNome.setPreferredSize(new java.awt.Dimension(320, 30));
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
        jPanel6.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 320, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Estado:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 50, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 203, 1, -1));

        TbMaquina.setModel(new MaquinaTableModel());
        TbMaquina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbMaquinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbMaquina);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 820, 310));

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 245));

        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setPreferredSize(new java.awt.Dimension(60, 30));
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
        btNovo.setPreferredSize(new java.awt.Dimension(60, 30));
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
        btSalvar.setPreferredSize(new java.awt.Dimension(60, 30));
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
        btEditar.setPreferredSize(new java.awt.Dimension(60, 30));
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
        btExcluir.setPreferredSize(new java.awt.Dimension(60, 30));
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
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 310));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tipo");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 30, -1));

        rbtnAtivo.setBackground(new java.awt.Color(51, 102, 0));
        estadoGroup.add(rbtnAtivo);
        rbtnAtivo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnAtivo.setText("Activo");
        rbtnAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAtivoActionPerformed(evt);
            }
        });
        jPanel6.add(rbtnAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, -1, -1));

        rbtnInativo.setBackground(new java.awt.Color(51, 102, 0));
        estadoGroup.add(rbtnInativo);
        rbtnInativo.setForeground(new java.awt.Color(255, 255, 255));
        rbtnInativo.setText("inactivo");
        jPanel6.add(rbtnInativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));
        jPanel6.add(lblMessagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(407, 174, 529, 23));

        txtTipo.setPreferredSize(new java.awt.Dimension(320, 30));
        txtTipo.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoKeyPressed(evt);
            }
        });
        jPanel6.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 320, 30));

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(627, 86));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registro de Maquina");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
            // Certifique-se de que a máquina foi instanciada corretamente
            if (maquina == null) {
                maquina = new Maquina();
            }
            maquina.setNome(txtNome.getText());
            maquina.setTipo(txtTipo.getText());

            if (rbtnAtivo.isSelected()) {
                maquina.setEstado(true);  // Ativo
            } else if (rbtnInativo.isSelected()) {
                maquina.setEstado(false); // Inativo
            }

            // Verificar se o id é nulo e inicializá-lo se for o caso
            if (maquina.getId() == null) {
                maquina.setId(0L);  // Define o id como 0 (nova máquina)
            }

            // Operação de salvar ou atualizar a máquina
            if (maquina.getId() == 0) {
                try {
                    maquinaDAO.salvar(maquina);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir a máquina.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            habilitarFormulario(false);
            carregarGrade();
            limpaFormulario();
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (!txtID.getText().isEmpty()) {
            Long id = Long.parseLong(txtID.getText());

            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir esta máquina?", "Confirmação", JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                try {
                    maquinaDAO.remover(id);  // Desativa a máquina
                    JOptionPane.showMessageDialog(this, "Máquina desativada com sucesso.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao desativar a máquina.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                habilitarFormulario(false);
                carregarGrade();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma máquina para excluir.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (validarFormulario()) {
            Long id;
            try {
                id = Long.parseLong(txtID.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return; // Retorna se o ID não for válido
            }

            Maquina maquina = maquinaDAO.buscarPorId(id);
            if (maquina != null) {
                maquina.setNome(txtNome.getText());
                maquina.setTipo(txtTipo.getText());
                if (rbtnAtivo.isSelected()) {
                    maquina.setEstado(true);  // Ativo
                } else if (rbtnInativo.isSelected()) {
                    maquina.setEstado(false); // Inativo
                }

                try {
                    maquinaDAO.atualizar(maquina); // Atualiza a máquina
                    JOptionPane.showMessageDialog(this, "Máquina atualizada com sucesso.");
                    limpaFormulario();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar a máquina.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

                habilitarFormulario(false);
                carregarGrade();
            } else {
                JOptionPane.showMessageDialog(this, "Máquina não encontrada para edição.");
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

    private void TbMaquinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMaquinaMouseClicked

    }//GEN-LAST:event_TbMaquinaMouseClicked

    private void rbtnAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnAtivoActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoKeyPressed

    private void limpaFormulario() {
        txtID.setText("");
        txtTipo.setText("");
        txtNome.setText("");
        estadoGroup.clearSelection(); // Limpa a seleção dos botões de estado
        lblMessagem.setText("");
    }

    private void habilitarSalvar() {
        btSalvar.setEnabled(validarFormulario());
    }

    private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);               // Botão "Novo" desativado quando ativo
        btSalvar.setEnabled(ativo && validarFormulario()); // "Salvar" habilitado apenas se o formulário for válido
        btCancelar.setEnabled(ativo);            // Botão "Cancelar" habilitado quando ativo
        btExcluir.setEnabled(ativo);
        btEditar.setEnabled(ativo);
        txtID.setEnabled(ativo);                 // Campo ID habilitado/desabilitado
        txtNome.setEnabled(ativo);               // Campo Nome habilitado/desabilitado
        txtTipo.setEnabled(ativo);               // Campo NUIT habilitado/desabilitado
        TbMaquina.setEnabled(!ativo);         // Desabilita tabela quando formulário estiver ativo
        rbtnAtivo.setEnabled(ativo);
        rbtnInativo.setEnabled(ativo);
        if (!ativo) {
            limpaFormulario();                   // Limpa o formulário se desativado
        }
    }

    public void selectRegistryTable() {
        int selectedRow = TbMaquina.getSelectedRow();
        if (selectedRow != -1) {
            txtID.setText(TbMaquina.getValueAt(selectedRow, 0).toString());
            txtNome.setText(TbMaquina.getValueAt(selectedRow, 1).toString());
            txtTipo.setText(TbMaquina.getValueAt(selectedRow, 2).toString());
            String estado = TbMaquina.getValueAt(selectedRow, 3).toString();
            if (estado.equalsIgnoreCase("Ativo")) {
                rbtnAtivo.setSelected(true);
            } else {
                rbtnInativo.setSelected(true);
            }

            habilitarFormulario(true); // Habilita o formulário para edição
        }
    }

    private boolean validarFormulario() {
        Border borderError = BorderFactory.createLineBorder(Color.RED, 2);  // Borda vermelha para erros
        Border borderNormal = BorderFactory.createLineBorder(Color.GRAY, 1); // Borda normal

        boolean isValid = true;

        // Validação do campo Tipo
        if (txtNome.getText().isEmpty()) {
            txtNome.setBorder(borderError);
            lblMessagem.setText("Preencha o campo com o tipo.");
            txtNome.requestFocus();
            isValid = false;
        } else {
            txtTipo.setBorder(borderNormal);
        }
        // Validação do campo Tipo
        if (txtTipo.getText().isEmpty()) {
            txtTipo.setBorder(borderError);
            lblMessagem.setText("Preencha o campo com o tipo.");
            txtTipo.requestFocus();
            isValid = false;
        } else {
            txtTipo.setBorder(borderNormal);
        }
// Validação dos botões de rádio (estado)
        if (!rbtnAtivo.isSelected() && !rbtnInativo.isSelected()) {
            lblMessagem.setText("Selecione o estado (Ativo ou Inativo).");
            isValid = false;
        }

        return isValid;
    }

    private void carregarGrade() {
        MaquinaTableModel tm = (MaquinaTableModel) TbMaquina.getModel();
        try {
            tm.setDados(maquinaDAO.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbMaquina;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
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
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

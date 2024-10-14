package view;

import controller.UsuarioDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import model.Usuario;
import model.tabelas.ClienteTableModel;
import model.tabelas.UsuarioTableModel;

/**
 *
 * @author Nelson Matsinhe
 */
public class TelaUsuario extends javax.swing.JInternalFrame {

    /** class tela de  registro do usuario
     * Creates new form Cadastrar
     *
     */
    //UsuarioDao adaoUsuario= new UsuarioDao();
    private Usuario usuario = null;
    private final UsuarioDAO daoUsuario= new UsuarioDAO();

    public TelaUsuario() throws Exception {
        initComponents(); 
        this.setBorder(null);
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
       // txtID.setFocusable(false);
         habilitarFormulario(false);
        carregarGrade();
    }

   
   



    @SuppressWarnings("unchecked")

    Color d = new Color(255, 0, 51);
    Color f = new Color(219, 220, 252);

   
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bsexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblMessagem = new javax.swing.JLabel();
        txsenha = new javax.swing.JPasswordField();
        txtID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txttipoUsuario = new javax.swing.JComboBox<>();
        lblMessagem1 = new javax.swing.JLabel();
        lblMessagem2 = new javax.swing.JLabel();
        lblMessagem4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btNovo1 = new javax.swing.JButton();
        btSalvar1 = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btCancelar3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(219, 220, 252));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 255)))); // NOI18N

        btNovo.setBackground(new java.awt.Color(219, 220, 252));
        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/novo-foco.png"))); // NOI18N
        btNovo.setText("Adicionar");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanel1.add(btNovo);

        btSalvar.setBackground(new java.awt.Color(219, 220, 252));
        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/salvar.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btSalvar);

        btCancelar.setBackground(new java.awt.Color(219, 220, 252));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/cancelar-foco.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar);

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/excluir.png"))); // NOI18N
        btExcluir.setText("Remover");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btExcluir);

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(710, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder()));
        jPanel6.setToolTipText("");
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_person_74px.png"))); // NOI18N
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 699, 10, 20));

        jCheckBox1.setBackground(new java.awt.Color(219, 220, 252));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel6.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nome:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txtnome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        txtnome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnomeKeyPressed(evt);
            }
        });
        jPanel6.add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 330, 32));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Usuario:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel6.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 330, 32));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("password:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        lblMessagem.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblMessagem.setForeground(new java.awt.Color(255, 0, 51));
        jPanel6.add(lblMessagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 1034, 322, 39));

        txsenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txsenha.setForeground(new java.awt.Color(102, 102, 102));
        txsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txsenhaActionPerformed(evt);
            }
        });
        txsenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txsenhaKeyPressed(evt);
            }
        });
        jPanel6.add(txsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 330, 32));

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel6.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 140, 32));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Id:");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 20, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tipo de Usuario:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        txttipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "normal" }));
        txttipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipoUsuarioActionPerformed(evt);
            }
        });
        jPanel6.add(txttipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 310, 40));

        lblMessagem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMessagem1.setForeground(new java.awt.Color(255, 0, 51));
        jPanel6.add(lblMessagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 322, 30));

        lblMessagem2.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblMessagem2.setForeground(new java.awt.Color(255, 0, 51));
        jPanel6.add(lblMessagem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 330, 34));

        lblMessagem4.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        lblMessagem4.setForeground(new java.awt.Color(255, 0, 51));
        jPanel6.add(lblMessagem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 330, 34));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        btNovo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_add_32px.png"))); // NOI18N
        btNovo1.setFocusable(false);
        btNovo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btNovo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btNovo1.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btNovo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btNovo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovo1ActionPerformed(evt);
            }
        });
        jPanel4.add(btNovo1);

        btSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_save_32px.png"))); // NOI18N
        btSalvar1.setFocusable(false);
        btSalvar1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btSalvar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSalvar1.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btSalvar1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btSalvar1);

        btEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_edit_property_22px.png"))); // NOI18N
        btEditar.setFocusable(false);
        btEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btEditar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });
        jPanel4.add(btEditar);

        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_cancel_32px.png"))); // NOI18N
        btnApagar.setFocusable(false);
        btnApagar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnApagar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnApagar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btnApagar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });
        jPanel4.add(btnApagar);

        btCancelar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/icons8_cancel_32px.png"))); // NOI18N
        btCancelar3.setFocusable(false);
        btCancelar3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar3.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar3ActionPerformed(evt);
            }
        });
        jPanel4.add(btCancelar3);

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 460, 60));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 480, 530));

        jScrollPane1.setBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setFocusCycleRoot(true);

        jTable1.setBackground(new java.awt.Color(219, 220, 252));
        jTable1.setModel(new UsuarioTableModel()
        );
        jTable1.setSelectionForeground(new java.awt.Color(219, 220, 252));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 370, 530));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro do Usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 100));

        setBounds(0, 0, 887, 697);
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            txsenha.setEchoChar((char) 0);
        } else {
            txsenha.setEchoChar('*');
        }


    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btNovoActionPerformed

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed

        if (txtnome.getText().isEmpty()) {
            txtnome.requestFocus();
            txtnome.setBackground(d);

        } else {
            txtnome.setBackground(f);
            txtUsuario.setBackground(f);
        }
    }//GEN-LAST:event_txtnomeActionPerformed

    private void txtnomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomeKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }
    }//GEN-LAST:event_txtnomeKeyPressed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.requestFocus();
            txtUsuario.setBackground(d);

        } else {
            txtUsuario.setBackground(f);
      
        }
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

// End of variables declaration                 
        }

    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txsenhaActionPerformed
        // TODO add your handling code here: 

    }//GEN-LAST:event_txsenhaActionPerformed

    private void btNovo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovo1ActionPerformed
        usuario = new Usuario();
        habilitarFormulario(true);
        btExcluir.setEnabled(false);
        
    }//GEN-LAST:event_btNovo1ActionPerformed

    private void btSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvar1ActionPerformed
       
          if (validarFormulario()) {
             usuario.setNome(txtnome.getText());
                usuario.setUserName(txtUsuario.getText());
               
                usuario.setSenha(txsenha.getText());
               // usuario.setEstado(Boolean.parseBoolean((String) txtEstado.getSelectedItem()));
                usuario.setPerfil((String) txttipoUsuario.getSelectedItem());
               // usuario.setEstado((Boolean) txtEstado.getSelectedItem());

           if (usuario.getCodigoUsuario() == 0) {
                try {
                    daoUsuario.inserir(usuario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o fornecedor.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } 

            habilitarFormulario(false);
            carregarGrade();
        }
          
    }//GEN-LAST:event_btSalvar1ActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    if (validarFormulario()) {
            usuario.setNome(txtnome.getText());
                usuario.setUserName(txtUsuario.getText());
               
                usuario.setSenha(txsenha.getText());
              //  usuario.setEstado(Boolean.parseBoolean((String) txtEstado.getSelectedItem()));
                usuario.setPerfil((String) txttipoUsuario.getSelectedItem());
               // usuario.setEstado((Boolean) txtEstado.getSelectedItem());
            if (usuario.getCodigoUsuario() == 0) {
                try {
                     daoUsuario.alterar(usuario);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao inserir o cliente.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
                
            }

            habilitarFormulario(false);
            carregarGrade();
        }
          
    }//GEN-LAST:event_btEditarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o Usuario" + usuario + "?");
        if (opcao == 0) {
            try {
                daoUsuario.excluir(usuario);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir o cliente.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            habilitarFormulario(false);
            carregarGrade();
        }
                                             

    }//GEN-LAST:event_btnApagarActionPerformed

    private void txsenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txsenhaKeyPressed
        validarFormulario();

    }//GEN-LAST:event_txsenhaKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (evt.getClickCount() == 2) {
            UsuarioTableModel  tm = (UsuarioTableModel ) jTable1.getModel();
            usuario = tm.getRowValue(jTable1.getRowSorter().convertRowIndexToModel(jTable1.getSelectedRow()));

            
             
           txtUsuario.setText(usuario.getNome());
         // txttipoUsuario.setValue(usuario.getNome());
           txsenha.setText(usuario.getSenha());

            habilitarFormulario(true);
        }             // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txttipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipoUsuarioActionPerformed

    private void btCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar3ActionPerformed
       habilitarFormulario(false);
    }//GEN-LAST:event_btCancelar3ActionPerformed
 private void habilitarFormulario(boolean ativo) {
        btNovo.setEnabled(!ativo);
        btSalvar.setEnabled(ativo);
        btExcluir.setEnabled(ativo);
        btCancelar.setEnabled(ativo);
        btnApagar.setEnabled(ativo);
        txtID.setEnabled(ativo);
        txtnome.setEnabled(ativo);
        txtUsuario.setEnabled(ativo);
        txsenha.setEnabled(ativo);
         jTable1.setEnabled(!ativo);

        if (!ativo) {
            limpaFormulario();
        }
    }
/**
 * metodo que limpa o formulario
 */
    private void limpaFormulario() {
       usuario = null;
        txtID.setText("");
        txtnome.setText("");
        txtUsuario.setText("");
        
        txsenha.setText("");
  
    }
/**
 * 
 * @return   true se todos os campos estiverem validados
 */
    private boolean validarFormulario() {
       
        if (txtnome.getText().isEmpty()) {
            txtnome.requestFocus();
            // txtnome.setBackground(d);
            lblMessagem1.setText("Prenche o campo com um nome ");
            return false;
        } else if (txtnome.getText().trim().length() < 2) {
            lblMessagem1.setText("Prenche o campo com um nome valido");
            txtnome.setBackground(d);
            txtnome.requestFocus();
            return false;
        } else {
            txtnome.setBackground(f);
            txtUsuario.setBackground(f);
            lblMessagem1.setText("");

        }

        if (txtUsuario.getText().isEmpty()) {
            txtUsuario.requestFocus();
            txtUsuario.setBackground(d);
            lblMessagem2.setText("Prenche o campo com User Name ");
            return false;
        } else if (txtUsuario.getText().trim().length() < 2) {
            lblMessagem2.setText("Prenche o campo com User Name Valido ");
            txtUsuario.setBackground(d);
            txtUsuario.requestFocus();
            return false;
        } else {
             txsenha.requestFocus();
            lblMessagem2.setText("");
        }

        
 

        if (txsenha.getText().isEmpty()) {
            //txsenha.setBackground(d);
            txsenha.requestFocus();
            lblMessagem4.setText("Prenche o campo com Senha ");
            return false;
        } else {
            txsenha.setBackground(f);
            lblMessagem4.setText("");
        }
        return true;
    }

    private void carregarGrade() {
         UsuarioTableModel  tm = (   UsuarioTableModel )  jTable1.getModel();
        try {
            tm.setDados(daoUsuario.listarTodos());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar grade.\n" + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bsexo;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar3;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btNovo1;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton btSalvar1;
    private javax.swing.JButton btnApagar;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblMessagem;
    private javax.swing.JLabel lblMessagem1;
    private javax.swing.JLabel lblMessagem2;
    private javax.swing.JLabel lblMessagem4;
    private javax.swing.JPasswordField txsenha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtnome;
    private javax.swing.JComboBox<String> txttipoUsuario;
    // End of variables declaration//GEN-END:variables


}

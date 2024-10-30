/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Cliente;


//import model.Produto;


/**
 * class tela de registros das produto
 * @author Nelson Matsinhe
 */
public class TelaProduto extends javax.swing.JInternalFrame {
    


    /**
     * Creates new form Produto
     */

       //GenericDAO prod = new GenericDAO<>(Produto.class);
   
    public TelaProduto() {
        initComponents();
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
      habilitarFormulario(false);
       
      // setCategoria();
    }
    /**
     * 
     *  as cores da campos
     */
 Color d = new Color(255, 0, 51);
    Color f = new Color(219, 220, 252);
    


 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTempoCura = new javax.swing.JSpinner();
        txtTipo = new javax.swing.JTextField();
        txtPreco = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbProduto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btCancelar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        lblMessagem = new javax.swing.JLabel();
        txtCategoria1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 102));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(51, 102, 0));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtID.setPreferredSize(new java.awt.Dimension(300, 30));
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel6.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 273, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 33, -1));

        txtNome.setPreferredSize(new java.awt.Dimension(300, 30));
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
        jPanel6.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 273, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 50, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tempo cura:");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Categoria:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 70, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 40, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Preco:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 50, -1));

        txtTempoCura.setPreferredSize(new java.awt.Dimension(300, 30));
        txtTempoCura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTempoCuraKeyPressed(evt);
            }
        });
        jPanel6.add(txtTempoCura, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        txtTipo.setPreferredSize(new java.awt.Dimension(300, 30));
        txtTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTipoKeyPressed(evt);
            }
        });
        jPanel6.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 273, -1));

        txtPreco.setColumns(10);
        txtPreco.setPreferredSize(new java.awt.Dimension(300, 30));
        txtPreco.setValue(new Double(0));
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecoKeyPressed(evt);
            }
        });
        jPanel6.add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 300, -1));

        TbProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbProduto);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 205, 757, 250));

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 245));

        btCancelar.setText("Cancelar");
        btCancelar.setFocusable(false);
        btCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 8, 2, 8));
        btCancelar.setPreferredSize(new java.awt.Dimension(300, 30));
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
        btNovo.setPreferredSize(new java.awt.Dimension(300, 30));
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
        btSalvar.setPreferredSize(new java.awt.Dimension(300, 30));
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
        btEditar.setPreferredSize(new java.awt.Dimension(300, 30));
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
        btExcluir.setPreferredSize(new java.awt.Dimension(300, 30));
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
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 205, -1, -1));
        jPanel6.add(lblMessagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 173, 722, 26));

        txtCategoria1.setPreferredSize(new java.awt.Dimension(300, 30));
        txtCategoria1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtCategoria1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoria1ActionPerformed(evt);
            }
        });
        txtCategoria1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCategoria1KeyPressed(evt);
            }
        });
        jPanel6.add(txtCategoria1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("REGISTRO DE PRODUTO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
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
     
       
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
       
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        habilitarFormulario(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
    
    }//GEN-LAST:event_btEditarActionPerformed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
   if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtTempoCuraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTempoCuraKeyPressed
   if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempoCuraKeyPressed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void txtTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoKeyPressed

    private void txtPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyPressed
if (evt.getKeyCode() == evt.VK_ENTER) {
            validarFormulario();

            // End of variables declaration                 
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoKeyPressed

    private void TbProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProdutoMouseClicked
   
    }//GEN-LAST:event_TbProdutoMouseClicked

    private void txtCategoria1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtCategoria1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoria1AncestorAdded

    private void txtCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoria1ActionPerformed

    private void txtCategoria1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoria1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoria1KeyPressed
public void selectRegistryTable() {
    // Preenchendo os campos do formulário com os dados da tabela
    txtID.setText(TbProduto.getValueAt(TbProduto.getSelectedRow(), 0).toString());
    txtNome.setText(TbProduto.getValueAt(TbProduto.getSelectedRow(), 1).toString());
    txtTipo.setText(TbProduto.getValueAt(TbProduto.getSelectedRow(), 2).toString()); // Presumindo que 'Tipo' se refere à 'Categoria'
    txtTempoCura.setValue(TbProduto.getValueAt(TbProduto.getSelectedRow(), 3)); // Campo para 'Tempo de Cura'
    txtTempoCura.setValue(TbProduto.getValueAt(TbProduto.getSelectedRow(), 4));
    txtPreco.setValue(TbProduto.getValueAt(TbProduto.getSelectedRow(), 5));
    // Preenchendo o campo da data de registro se houver uma coluna correspondente
}

private void habilitarFormulario(boolean ativo) {
    btNovo.setEnabled(!ativo);
    btSalvar.setEnabled(ativo);
    btExcluir.setEnabled(ativo);
    btCancelar.setEnabled(ativo);
    txtID.setEnabled(ativo);
    txtNome.setEnabled(ativo);
    txtPreco.setEnabled(ativo);
    txtTempoCura.setEnabled(ativo);
    txtTipo.setEnabled(ativo);
    txtTempoCura.setEnabled(ativo); // Habilitando o campo 'Tempo de Cura'
    
    btEditar.setEnabled(ativo);
    
    TbProduto.setEnabled(!ativo);

    if (!ativo) {
        limpaFormulario();
    }
}

private void limpaFormulario() {
    txtID.setText("");
    txtNome.setText("");
    txtTipo.setText("");
    txtTempoCura.setValue(0); // Resetando o tempo de cura
    txtTempoCura.setValue(0);
}

private boolean validarFormulario() {
    if (txtNome.getText().isEmpty()) {
        txtNome.requestFocus();
        lblMessagem.setText("Preencha o campo com um nome");
        return false;
    } else if (txtNome.getText().trim().length() < 2) {
        lblMessagem.setText("Preencha o campo com um nome válido");
        txtNome.setBackground(d); // Presumindo que 'd' é uma cor de erro
        txtNome.requestFocus();
        return false;
    } else {
        txtNome.setBackground(f); // Presumindo que 'f' é uma cor de sucesso
        lblMessagem.setText("");
    }

    if (txtTipo.getText().isEmpty()) {
        txtTipo.requestFocus();
        lblMessagem.setText("Preencha o campo com Tipo");
        return false;
    } else if (txtTipo.getText().trim().length() < 2) {
        lblMessagem.setText("Preencha o campo com Tipo válido");
        txtTipo.requestFocus();
        return false;
    } else {
        lblMessagem.setText("");
    }

    if ((int) (txtTempoCura.getValue()) < 0) { // Verificando se o tempo de cura é válido
        lblMessagem.setText("Tempo de cura inválido."); 
        txtTempoCura.requestFocus();
        return false;
    } else {
        lblMessagem.setText("");
    }

    if ((int) (txtTempoCura.getValue()) <= 0) {
        lblMessagem.setText("Quantidade inválida."); 
        txtTempoCura.requestFocus();
        return false;
    } else {
        lblMessagem.setText("");
    }

    
    return true;
}

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbProduto;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessagem;
    private javax.swing.JComboBox txtCategoria1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPreco;
    private javax.swing.JSpinner txtTempoCura;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}

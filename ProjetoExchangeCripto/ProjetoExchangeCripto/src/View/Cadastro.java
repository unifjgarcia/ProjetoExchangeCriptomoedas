/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JOptionPane;

/**
 *
 * @author Jpsab
 */
public class Cadastro extends javax.swing.JFrame {

    /**
     * Creates new form Cadastro
     */
    public Cadastro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloCadastro = new javax.swing.JLabel();
        lblNomeCadastro = new javax.swing.JLabel();
        txtNomeCadastro = new javax.swing.JTextField();
        lblIdadeCadastro = new javax.swing.JLabel();
        lblCpfCadastro = new javax.swing.JLabel();
        lblSenhaCadastro = new javax.swing.JLabel();
        txtIdadeCadastro = new javax.swing.JTextField();
        txtCpfCadastro = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        txtSenhaCadastro = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloCadastro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTituloCadastro.setText("Faça seu cadastro e se torne um Investidor em Criptomoedas");

        lblNomeCadastro.setText("Nome: ");

        lblIdadeCadastro.setText("Idade: ");

        lblCpfCadastro.setText("CPF: ");

        lblSenhaCadastro.setText("Senha: ");

        txtIdadeCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdadeCadastroActionPerformed(evt);
            }
        });

        txtCpfCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfCadastroActionPerformed(evt);
            }
        });

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        txtSenhaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaCadastroActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSenhaCadastro)
                                .addComponent(lblNomeCadastro)
                                .addComponent(lblTituloCadastro)
                                .addComponent(lblIdadeCadastro)
                                .addComponent(lblCpfCadastro)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNomeCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtIdadeCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCpfCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(290, 290, 290)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btCadastrar)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btVoltar)
                                    .addGap(10, 10, 10))))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTituloCadastro)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeCadastro))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdadeCadastro)
                    .addComponent(txtIdadeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfCadastro)
                    .addComponent(txtCpfCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaCadastro)
                    .addComponent(txtSenhaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdadeCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdadeCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdadeCadastroActionPerformed

    private void txtCpfCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCadastroActionPerformed
        
    }//GEN-LAST:event_txtCpfCadastroActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        String cpf = txtCpfCadastro.getText();
        String senha = txtSenhaCadastro.getText();
        if (cpf.contains("-") || cpf.contains(".")){
            JOptionPane.showMessageDialog(Cadastro.this, "Cpf não pode ter caracteres especiais e a senha deve conter 6 digitos!");
        } else if(senha.length() != 6 && senha.matches("[0-9]+")){
            JOptionPane.showMessageDialog(Cadastro.this, "Cpf não pode ter caracteres especiais e a senha deve conter 6 digitos!");
        } else{
            JOptionPane.showMessageDialog(Cadastro.this, "Parabéns, você se cadastrou como um novo investidor de criptomoedas");
        }
            
        
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void txtSenhaCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaCadastroActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        Login janelaLogin = new Login();
        janelaLogin.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel lblCpfCadastro;
    private javax.swing.JLabel lblIdadeCadastro;
    private javax.swing.JLabel lblNomeCadastro;
    private javax.swing.JLabel lblSenhaCadastro;
    private javax.swing.JLabel lblTituloCadastro;
    private javax.swing.JTextField txtCpfCadastro;
    private javax.swing.JTextField txtIdadeCadastro;
    private javax.swing.JTextField txtNomeCadastro;
    private javax.swing.JTextField txtSenhaCadastro;
    // End of variables declaration//GEN-END:variables
}

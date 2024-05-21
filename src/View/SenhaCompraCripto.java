/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.VerificarSenhaCompra;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jpsab
 */
public class SenhaCompraCripto extends javax.swing.JFrame {

    /**
     * Creates new form SenhaCompraCripto
     */
    public SenhaCompraCripto() {
        initComponents();
        verificar = new VerificarSenhaCompra(this);
    }

    public JButton getBtConfirmarSenha() {
        return btConfirmarSenha;
    }

    public void setBtConfirmarSenha(JButton btConfirmarSenha) {
        this.btConfirmarSenha = btConfirmarSenha;
    }

    public JLabel getLblConfirmaSenha() {
        return lblConfirmaSenha;
    }

    public void setLblConfirmaSenha(JLabel lblConfirmaSenha) {
        this.lblConfirmaSenha = lblConfirmaSenha;
    }

    public JLabel getLblDigitaSenha() {
        return lblDigitaSenha;
    }

    public void setLblDigitaSenha(JLabel lblDigitaSenha) {
        this.lblDigitaSenha = lblDigitaSenha;
    }

    public JTextField getTxtConfirmaSenha() {
        return txtConfirmaSenha;
    }

    public void setTxtConfirmaSenha(JTextField txtConfirmaSenha) {
        this.txtConfirmaSenha = txtConfirmaSenha;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConfirmaSenha = new javax.swing.JLabel();
        lblDigitaSenha = new javax.swing.JLabel();
        txtConfirmaSenha = new javax.swing.JTextField();
        btConfirmarSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConfirmaSenha.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblConfirmaSenha.setText("CONFIRME SUA SENHA");

        lblDigitaSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDigitaSenha.setText("Confirme sua senha para acessar a aba de compra de cripto:");

        btConfirmarSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btConfirmarSenha.setText("Confirmar");
        btConfirmarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblDigitaSenha)
                        .addGap(43, 43, 43)
                        .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(btConfirmarSenha))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblConfirmaSenha)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblConfirmaSenha)
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigitaSenha)
                    .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btConfirmarSenha)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConfirmarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarSenhaActionPerformed
        verificar.verificaSenha();
    }//GEN-LAST:event_btConfirmarSenhaActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(SenhaCompraCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SenhaCompraCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SenhaCompraCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SenhaCompraCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SenhaCompraCripto().setVisible(true);
            }
        });
    }
    
    private VerificarSenhaCompra verificar;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmarSenha;
    private javax.swing.JLabel lblConfirmaSenha;
    private javax.swing.JLabel lblDigitaSenha;
    private javax.swing.JTextField txtConfirmaSenha;
    // End of variables declaration//GEN-END:variables
}

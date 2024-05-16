/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.DepositoInvestidor;
import Controller.SessaoInvestidor;
import DAO.ConexaoBancoDados;
import DAO.InvestidorConectado;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jpsab
 */
public class Deposito extends javax.swing.JFrame {

    /**
     * Creates new form Deposito
     */
    public Deposito() {
        initComponents();
        
    }

    public DepositoInvestidor getDepositoInvestidor() {
        return depositoInvestidor;
    }

    public void setDepositoInvestidor(DepositoInvestidor depositoInvestidor) {
        this.depositoInvestidor = depositoInvestidor;
    }

    public JButton getBtDepositar() {
        return btDepositar;
    }

    public void setBtDepositar(JButton btDepositar) {
        this.btDepositar = btDepositar;
    }

    public JLabel getLblDigitaDeposito() {
        return lblDigitaDeposito;
    }

    public void setLblDigitaDeposito(JLabel lblDigitaDeposito) {
        this.lblDigitaDeposito = lblDigitaDeposito;
    }

    public JLabel getLblTituloDepositar() {
        return lblTituloDepositar;
    }

    public void setLblTituloDepositar(JLabel lblTituloDepositar) {
        this.lblTituloDepositar = lblTituloDepositar;
    }

    public JTextField getTxtValorDeposito() {
        return txtValorDeposito;
    }

    public void setTxtValorDeposito(JTextField txtValorDeposito) {
        this.txtValorDeposito = txtValorDeposito;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloDepositar = new javax.swing.JLabel();
        lblDigitaDeposito = new javax.swing.JLabel();
        btDepositar = new javax.swing.JButton();
        txtValorDeposito = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloDepositar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTituloDepositar.setText("DEPOSITAR");

        lblDigitaDeposito.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDigitaDeposito.setText("Digite o valor que deseja depositar em reais:");

        btDepositar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDepositar.setText("Depositar");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });

        txtValorDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorDepositoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(lblTituloDepositar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lblDigitaDeposito)
                        .addGap(45, 45, 45)
                        .addComponent(txtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btDepositar)
                .addGap(291, 291, 291))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloDepositar)
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigitaDeposito)
                    .addComponent(txtValorDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(btDepositar)
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
        String valorDeposito = txtValorDeposito.getText();
        double valor = Double.parseDouble(valorDeposito);
        String investidorId = SessaoInvestidor.getInvestidorId();
    }//GEN-LAST:event_btDepositarActionPerformed

    private void txtValorDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorDepositoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorDepositoActionPerformed

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
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Deposito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Deposito().setVisible(true);
            }
        });
    }
    
    private DepositoInvestidor depositoInvestidor;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDepositar;
    private javax.swing.JLabel lblDigitaDeposito;
    private javax.swing.JLabel lblTituloDepositar;
    private javax.swing.JTextField txtValorDeposito;
    // End of variables declaration//GEN-END:variables
}
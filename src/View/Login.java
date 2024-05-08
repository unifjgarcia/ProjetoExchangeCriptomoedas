/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.CadastroCorreto;
import Controller.LoginSucesso;
import Model.Investidor;
import Model.Pessoa;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Jpsab
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        investidorLogado = new LoginSucesso(this);
    }

    

    public JButton getBtCadastro() {
        return btCadastro;
    }

    public void setBtCadastro(JButton btCadastro) {
        this.btCadastro = btCadastro;
    }

    public JButton getBtEntrar() {
        return btEntrar;
    }

    public void setBtEntrar(JButton btEntrar) {
        this.btEntrar = btEntrar;
    }

    public JLabel getLblBV() {
        return lblBV;
    }

    public void setLblBV(JLabel lblBV) {
        this.lblBV = lblBV;
    }

    public JLabel getLblDigitaCPF() {
        return lblDigitaCPF;
    }

    public void setLblDigitaCPF(JLabel lblDigitaCPF) {
        this.lblDigitaCPF = lblDigitaCPF;
    }

    public JLabel getLblDigitaSenha() {
        return lblDigitaSenha;
    }

    public void setLblDigitaSenha(JLabel lblDigitaSenha) {
        this.lblDigitaSenha = lblDigitaSenha;
    }

    public JLabel getLblLogin() {
        return lblLogin;
    }

    public void setLblLogin(JLabel lblLogin) {
        this.lblLogin = lblLogin;
    }

    public JLabel getLblSubTitulo() {
        return lblSubTitulo;
    }

    public void setLblSubTitulo(JLabel lblSubTitulo) {
        this.lblSubTitulo = lblSubTitulo;
    }

    public JLabel getLblTxtCadastro() {
        return lblTxtCadastro;
    }

    public void setLblTxtCadastro(JLabel lblTxtCadastro) {
        this.lblTxtCadastro = lblTxtCadastro;
    }

    public JTextField getTxtCPF() {
        return txtCPF;
    }

    public void setTxtCPF(JTextField txtCPF) {
        this.txtCPF = txtCPF;
    }

    public JTextField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JTextField txtSenha) {
        this.txtSenha = txtSenha;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBV = new javax.swing.JLabel();
        lblSubTitulo = new javax.swing.JLabel();
        lblDigitaCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        lblDigitaSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        lblTxtCadastro = new javax.swing.JLabel();
        btCadastro = new javax.swing.JButton();
        btEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBV.setText("Bem Vindo Investidor!");

        lblSubTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSubTitulo.setText("Faça seu login para acompanhar seu saldo de criptomoedas e suas variações");

        lblDigitaCPF.setText("Digite seu CPF: ");

        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });

        lblLogin.setText("LOGIN");

        lblDigitaSenha.setText("Digite sua senha: ");

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        lblTxtCadastro.setText("Não tem cadastro?");

        btCadastro.setText("Cadastre-se");
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });

        btEntrar.setText("ENTRAR");
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(lblSubTitulo)
                .addGap(52, 52, 52))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDigitaCPF)
                    .addComponent(lblDigitaSenha))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCPF)
                    .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(lblBV))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(lblLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCadastro)
                            .addComponent(lblTxtCadastro)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btEntrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblBV)
                .addGap(18, 18, 18)
                .addComponent(lblSubTitulo)
                .addGap(30, 30, 30)
                .addComponent(lblLogin)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigitaCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDigitaSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(lblTxtCadastro)
                .addGap(18, 18, 18)
                .addComponent(btCadastro)
                .addGap(28, 28, 28))
        );

        lblBV.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed
        Cadastro janelaCadastro = new Cadastro();
        janelaCadastro.setVisible(true);
    }//GEN-LAST:event_btCadastroActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        investidorLogado.LoginInvestidor();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    private LoginSucesso investidorLogado;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JButton btEntrar;
    private javax.swing.JLabel lblBV;
    private javax.swing.JLabel lblDigitaCPF;
    private javax.swing.JLabel lblDigitaSenha;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSubTitulo;
    private javax.swing.JLabel lblTxtCadastro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}

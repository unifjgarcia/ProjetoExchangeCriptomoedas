/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.VenderCriptomoedas;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *A classe CotacoesVendeCripto é a janela que o investidor pode vender a 
 * criptomoeda que deseja. Ela possui um metodo que seta os valores em uma area
 * de texto, possui um objeto da classe VenderCriptomoedas, recebendo o metodo
 * que faz a venda das criptomoedas.
 *
 * @author João Pedro Sabino Garcia
 * @version 1.0
 */
public class CotacoesVendeCripto extends javax.swing.JFrame {

    /**
     * Creates new form CotacoesVendeCripto
     */
    public CotacoesVendeCripto(String cotacoes) {
        initComponents();
        venderCripto = new VenderCriptomoedas(this);
        txtMostraCotacoes.setText(cotacoes);
        
    }

    public VenderCriptomoedas getVenderCripto() {
        return venderCripto;
    }

    public void setVenderCripto(VenderCriptomoedas venderCripto) {
        this.venderCripto = venderCripto;
    }

    public JButton getBtVenderCripto() {
        return btVenderCripto;
    }

    public void setBtVenderCripto(JButton btVenderCripto) {
        this.btVenderCripto = btVenderCripto;
    }

    public JComboBox<String> getCbEscolhaCripto() {
        return cbEscolhaCripto;
    }

    public void setCbEscolhaCripto(JComboBox<String> cbEscolhaCripto) {
        this.cbEscolhaCripto = cbEscolhaCripto;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLblDigiteValor() {
        return lblDigiteValor;
    }

    public void setLblDigiteValor(JLabel lblDigiteValor) {
        this.lblDigiteValor = lblDigiteValor;
    }

    public JLabel getLblEscolha() {
        return lblEscolha;
    }

    public void setLblEscolha(JLabel lblEscolha) {
        this.lblEscolha = lblEscolha;
    }

    public JLabel getLblTituloCotacoesCompra() {
        return lblTituloCotacoesCompra;
    }

    public void setLblTituloCotacoesCompra(JLabel lblTituloCotacoesCompra) {
        this.lblTituloCotacoesCompra = lblTituloCotacoesCompra;
    }

    public JTextArea getTxtMostraCotacoes() {
        return txtMostraCotacoes;
    }

    public void setTxtMostraCotacoes(JTextArea txtMostraCotacoes) {
        this.txtMostraCotacoes = txtMostraCotacoes;
    }

    public JTextField getTxtValorVendaCripto() {
        return txtValorVendaCripto;
    }

    public void setTxtValorVendaCripto(JTextField txtValorVendaCripto) {
        this.txtValorVendaCripto = txtValorVendaCripto;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloCotacoesCompra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMostraCotacoes = new javax.swing.JTextArea();
        cbEscolhaCripto = new javax.swing.JComboBox<>();
        lblEscolha = new javax.swing.JLabel();
        lblDigiteValor = new javax.swing.JLabel();
        txtValorVendaCripto = new javax.swing.JTextField();
        btVenderCripto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloCotacoesCompra.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloCotacoesCompra.setText("COTAÇÕES CRIPTOMOEDAS");

        txtMostraCotacoes.setColumns(20);
        txtMostraCotacoes.setRows(5);
        jScrollPane1.setViewportView(txtMostraCotacoes);

        cbEscolhaCripto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbEscolhaCripto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bitcoin", "Ethereum", "Ripple" }));
        cbEscolhaCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEscolhaCriptoActionPerformed(evt);
            }
        });

        lblEscolha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEscolha.setText("Escolha qual Criptomoeda deseja vender:");

        lblDigiteValor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDigiteValor.setText("Digite quanto deseja vender:");

        btVenderCripto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btVenderCripto.setText("VENDER");
        btVenderCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderCriptoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDigiteValor)
                        .addGap(37, 37, 37)
                        .addComponent(txtValorVendaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEscolha)
                        .addGap(45, 45, 45)
                        .addComponent(cbEscolhaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTituloCotacoesCompra)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btVenderCripto)
                        .addGap(284, 284, 284))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloCotacoesCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEscolha)
                    .addComponent(cbEscolhaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorVendaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDigiteValor))
                .addGap(35, 35, 35)
                .addComponent(btVenderCripto)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbEscolhaCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEscolhaCriptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbEscolhaCriptoActionPerformed

    private void btVenderCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderCriptoActionPerformed
       venderCripto.vendeCripto();
    }//GEN-LAST:event_btVenderCriptoActionPerformed
    
    public void setCotacoes(String cotacoes) {
        txtMostraCotacoes.setText(cotacoes);
    }
    
    public String getCriptomoeda() {
        return (String) cbEscolhaCripto.getSelectedItem();
    }
    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CotacoesVendeCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CotacoesVendeCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CotacoesVendeCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CotacoesVendeCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CotacoesVendeCripto().setVisible(true);
//            }
//        });
//    }

    private VenderCriptomoedas venderCripto;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVenderCripto;
    private javax.swing.JComboBox<String> cbEscolhaCripto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDigiteValor;
    private javax.swing.JLabel lblEscolha;
    private javax.swing.JLabel lblTituloCotacoesCompra;
    private javax.swing.JTextArea txtMostraCotacoes;
    private javax.swing.JTextField txtValorVendaCripto;
    // End of variables declaration//GEN-END:variables
}

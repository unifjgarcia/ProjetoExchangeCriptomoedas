/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Carteira;

/**
 *
 * @author Jpsab
 */
public class ComprarCriptomoedas extends javax.swing.JFrame {

    /**
     * Creates new form ComprarCriptomoedas
     */
    public ComprarCriptomoedas() {
        initComponents();
        this.carteira = carteira;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloComprarCripto = new javax.swing.JLabel();
        txtEscolhaCripto = new javax.swing.JTextField();
        lblQualCripto = new javax.swing.JLabel();
        lblOpcoes = new javax.swing.JLabel();
        lblPerguntaQuantidade = new javax.swing.JLabel();
        txtQuantidadeCripto = new javax.swing.JTextField();
        btComprarCripto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTituloComprarCripto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTituloComprarCripto.setText("COMPRAR CRIPTOMOEDAS");

        txtEscolhaCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEscolhaCriptoActionPerformed(evt);
            }
        });

        lblQualCripto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblQualCripto.setText("Qual criptomoeda você deseja comprar?");

        lblOpcoes.setText("Bitcoin, Ethereum, Ripple");

        lblPerguntaQuantidade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPerguntaQuantidade.setText("Quantos reais você deseja comprar dessa moeda? ");

        btComprarCripto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btComprarCripto.setText("Comprar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPerguntaQuantidade)
                        .addGap(131, 131, 131))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btComprarCripto)
                        .addGap(245, 245, 245))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(lblOpcoes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTituloComprarCripto)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtQuantidadeCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEscolhaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(lblQualCripto)))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloComprarCripto)
                .addGap(18, 18, 18)
                .addComponent(lblQualCripto)
                .addGap(31, 31, 31)
                .addComponent(lblOpcoes)
                .addGap(18, 18, 18)
                .addComponent(txtEscolhaCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblPerguntaQuantidade)
                .addGap(36, 36, 36)
                .addComponent(txtQuantidadeCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btComprarCripto)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEscolhaCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEscolhaCriptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEscolhaCriptoActionPerformed

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
            java.util.logging.Logger.getLogger(ComprarCriptomoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprarCriptomoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprarCriptomoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprarCriptomoedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprarCriptomoedas().setVisible(true);
            }
        });
    }
    
    private Carteira carteira;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComprarCripto;
    private javax.swing.JLabel lblOpcoes;
    private javax.swing.JLabel lblPerguntaQuantidade;
    private javax.swing.JLabel lblQualCripto;
    private javax.swing.JLabel lblTituloComprarCripto;
    private javax.swing.JTextField txtEscolhaCripto;
    private javax.swing.JTextField txtQuantidadeCripto;
    // End of variables declaration//GEN-END:variables
}
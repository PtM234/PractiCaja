/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    private Cuenta cliente;
    private Socket socketCliente;
    private DataInputStream entrada;
    private DataOutputStream salida;

    /**
     * Creates new form Cliente
     */
    public PantallaPrincipal() {
        initComponents();
        cliente = new Cuenta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jButtonRetirarEfectivo = new javax.swing.JButton();
        jButtonDepositarEfectivo = new javax.swing.JButton();
        jButtonPagoServicios = new javax.swing.JButton();
        jButtonMovsySaldo = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bienvenido:");

        jLabelNombreUsuario.setText("(Username)");

        jButtonRetirarEfectivo.setText("Retirar Efectivo");
        jButtonRetirarEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRetirarEfectivoActionPerformed(evt);
            }
        });

        jButtonDepositarEfectivo.setText("Depositar Efectivo");
        jButtonDepositarEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepositarEfectivoActionPerformed(evt);
            }
        });

        jButtonPagoServicios.setText("Pago de Servicios");
        jButtonPagoServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagoServiciosActionPerformed(evt);
            }
        });

        jButtonMovsySaldo.setText("Movimientos y Saldo");
        jButtonMovsySaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMovsySaldoActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonMovsySaldo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(jButtonPagoServicios))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRetirarEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDepositarEfectivo)))
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNombreUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jButtonSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelNombreUsuario))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRetirarEfectivo)
                    .addComponent(jButtonDepositarEfectivo))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPagoServicios)
                    .addComponent(jButtonMovsySaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRetirarEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRetirarEfectivoActionPerformed
        try {
            // TODO add your handling code here:
            salida.writeInt(1);
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRetirarEfectivoActionPerformed

    private void jButtonDepositarEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepositarEfectivoActionPerformed
        try{
            salida.writeInt(2);
        }catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonDepositarEfectivoActionPerformed

    private void jButtonMovsySaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMovsySaldoActionPerformed
        try{
            salida.writeInt(3);
        } catch(IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonMovsySaldoActionPerformed

    private void jButtonPagoServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagoServiciosActionPerformed
        try{
            salida.writeInt(4);
        } catch (IOException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButtonPagoServiciosActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        try {
            // TODO add your handling code here:
            salida.writeInt(5);
            this.dispose();
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    public void setCliente(Cuenta cliente) {
        this.cliente = cliente;
        jLabelNombreUsuario.setText(cliente.getNombreCliente());
    }
    
    public void setSocketCliente(Socket socketCliente) {
        try {
            this.socketCliente = socketCliente;
            entrada = new DataInputStream(socketCliente.getInputStream());
            salida = new DataOutputStream(socketCliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(PantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDepositarEfectivo;
    private javax.swing.JButton jButtonMovsySaldo;
    private javax.swing.JButton jButtonPagoServicios;
    private javax.swing.JButton jButtonRetirarEfectivo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @param socketCliente the socketCliente to set
     */
    
}

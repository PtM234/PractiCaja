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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author PtM
 */
public class DepositarEfectivo extends javax.swing.JFrame {
    private Cuenta cliente;
    private Socket socketCliente;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null; 
    private static ResultSetMetaData rsmd = null;
    private DataOutputStream salida;
    private DataInputStream entrada;
    private String seleccionjCombo;
    private int indexCombo;


    /**
     * Creates new form depositar
     */
    public DepositarEfectivo() {
        initComponents();
        cliente = new Cuenta();
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
            poblarLista();
        } catch (SQLException ex) {
            Logger.getLogger(DepositarEfectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxUsuarios = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMonto = new javax.swing.JTextField();
        jButtonDepositar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUsuario.setText("¡Bienvenido (username)! Tu saldo es: (saldo)");

        jButton1.setText("<Regresar a Pantalla Principal");

        jLabel2.setText("Selecciona una cuenta a la cual depositar:");

        jComboBoxUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuariosActionPerformed(evt);
            }
        });

        jLabel3.setText("Inserta el monto a depositar:");

        jButtonDepositar.setText("Depositar");
        jButtonDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDepositarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabelUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonDepositar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldMonto)))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabelUsuario)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jButtonDepositar)
                .addGap(21, 21, 21)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUsuariosActionPerformed

    private void jButtonDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDepositarActionPerformed
        if(revisarDeposito()){
            try {
                salida.writeBoolean(true);
//                indexCombo = jComboBoxUsuarios.getSelectedIndex();
//                String eleccion = jComboBoxUsuarios.getItemAt(indexCombo);
                salida.writeUTF((String)jComboBoxUsuarios.getSelectedItem());   //A quien se le está depositando
                salida.writeInt(Integer.parseInt(jTextFieldMonto.getText()));   //Cuanto se está depositando
                salida.writeUTF(cliente.getNombreCliente());                    //Quien está depositando
                PantallaPrincipal p = new PantallaPrincipal();
                p.setCliente(cliente);
                p.setSocketCliente(socketCliente);
                p.setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(DepositarEfectivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonDepositarActionPerformed

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
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepositarEfectivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepositarEfectivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonDepositar;
    private javax.swing.JComboBox<String> jComboBoxUsuarios;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JTextField jTextFieldMonto;
    // End of variables declaration//GEN-END:variables

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cuenta cliente) {
        this.cliente = cliente;
        jLabelUsuario.setText("¡Bienvenido " + cliente.getNombreCliente() + " Tu saldo es: " + cliente.getSaldo() + "!");
    }

    /**
     * @param socketCliente the socketCliente to set
     */
    public void setSocketCliente(Socket socketCliente) {
        try {
            this.socketCliente = socketCliente;
            salida = new DataOutputStream(socketCliente.getOutputStream());
            entrada = new DataInputStream(socketCliente.getInputStream());
            System.out.println("Se pasó el Socket: " + socketCliente.toString());
        } catch (IOException ex) {
            Logger.getLogger(DepositarEfectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void poblarLista(){
        try {
            jComboBoxUsuarios.removeAllItems();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from cuentas");
            while(rs.next()){
                jComboBoxUsuarios.addItem(rs.getString("nombreCliente"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepositarEfectivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean revisarDeposito(){
        if(jComboBoxUsuarios.getSelectedIndex() == -1){
                JOptionPane.showMessageDialog(null, "Selecciona un Cliente!");
                return false;
            }else{
            if(cliente.getNombreCliente().equals((String)jComboBoxUsuarios.getSelectedItem())){
                return true;
        }else{
              if(cliente.getSaldo()<Integer.parseInt(jTextFieldMonto.getText())){
                  JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para hacer eso!");
                  return false;
              }else{
                  return true;
              }  
            }
        }
    }
}

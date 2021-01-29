/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class Login extends javax.swing.JFrame implements Serializable{
    
    private boolean usuarioRegistro = false, passRegistro = false, usuarioLogin = false, passLogin = false;
    private String nombre;
    private Cuenta cliente;
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null; 
    private static ResultSetMetaData rsmd = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        jButtonRegistro.setEnabled(false);
        jButtonLogin.setEnabled(false);
    }

    
    public boolean revisarUser(String usuario){
        try {
            //Revisamos en BD si el usuario existe:
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from cuentas WHERE nombreCliente = '" + usuario + "'");
            rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            
            if (rs.getString("nombreCliente").equals(usuario)){
                System.out.println(rs.getString("nombreCliente"));
                return true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
    public void enviarDatosRegistro(Cuenta c, String password){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUsuarioRegistro = new javax.swing.JTextField();
        jPasswordRegistro = new javax.swing.JPasswordField();
        jButtonRegistro = new javax.swing.JButton();
        jLabelRevisarUsuario = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldUsuarioLogin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldLogin = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Usuario:");

        jLabel4.setText("Contraseña:");

        jTextFieldUsuarioRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioRegistroKeyPressed(evt);
            }
        });

        jPasswordRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordRegistroKeyPressed(evt);
            }
        });

        jButtonRegistro.setText("Registrarme");
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsuarioRegistro))
                        .addGap(18, 18, 18)
                        .addComponent(jLabelRevisarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jButtonRegistro)
                        .addGap(0, 190, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUsuarioRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRevisarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButtonRegistro)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registro", jPanel1);

        jLabel5.setText("Usuario:");

        jTextFieldUsuarioLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldUsuarioLoginKeyPressed(evt);
            }
        });

        jLabel6.setText("Contraseña:");

        jPasswordFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldLoginKeyPressed(evt);
            }
        });

        jButtonLogin.setText("Entrar");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsuarioLogin, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jButtonLogin)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButtonLogin)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUsuarioRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioRegistroKeyPressed
        usuarioRegistro = true;
    }//GEN-LAST:event_jTextFieldUsuarioRegistroKeyPressed

    private void jPasswordRegistroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordRegistroKeyPressed
        passRegistro = true;
        if (usuarioRegistro && passRegistro){
            jButtonRegistro.setEnabled(true);
        }
    }//GEN-LAST:event_jPasswordRegistroKeyPressed

    private void jTextFieldUsuarioLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioLoginKeyPressed
        usuarioLogin = true;
    }//GEN-LAST:event_jTextFieldUsuarioLoginKeyPressed

    private void jPasswordFieldLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldLoginKeyPressed
        passLogin = true;
        if (usuarioLogin && passLogin){
            jButtonLogin.setEnabled(true);
        }
    }//GEN-LAST:event_jPasswordFieldLoginKeyPressed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed
        // TODO add your handling code here:
        //Como se va a registrar, necesitamos mandar los datos a la BD
        //Como apenas se registró el saldo que tendrá la cuenta es de 0
        //Mandar la contraseña a la BD
        if(revisarUser(jTextFieldUsuarioRegistro.getText())){
                jLabelRevisarUsuario.setText("El Usuario ya existe!");
            } else{
            cliente.setSaldo(0);
            cliente.setNombreCliente(jTextFieldUsuarioRegistro.getText());
        }
        
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        //Obtener datos de la BD
        //Si los datos son iguales a los que el cliente metió, acceder a la siguiente pantalla.
        //Si no, necesitamos sacar un Alert
        //Si las credenciales de acceso son validas, dar estas al objeto cliente
    }//GEN-LAST:event_jButtonLoginActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelRevisarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldLogin;
    private javax.swing.JPasswordField jPasswordRegistro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldUsuarioLogin;
    private javax.swing.JTextField jTextFieldUsuarioRegistro;
    // End of variables declaration//GEN-END:variables
}

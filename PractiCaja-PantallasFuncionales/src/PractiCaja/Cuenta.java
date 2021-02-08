/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.Serializable;
import java.sql.Connection;
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
public class Cuenta implements Serializable{
    
    private int id_Cuenta;
    private String nombreCliente;
    private static ResultSet rs = null; 
    private static ResultSetMetaData rsmd = null;
    private int saldo;
    
    public Cuenta(int cuenta, String Cliente, int saldoCliente){
        this.id_Cuenta = cuenta;
        this.nombreCliente = Cliente;
        this.saldo = saldoCliente;
    }
    
    public Cuenta(){
        System.out.println("Se inició en blanco");
    }

    /**
     * @return the id_Cuenta
     */
    public int getId_Cuenta() {
        return id_Cuenta;
    }

    /**
     * @param id_Cuenta the id_Cuenta to set
     */
    public void setId_Cuenta(int id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

    /**
     * @return the nombreCliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * @param nombreCliente the nombreCliente to set
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * @return the saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public void insertarUsuario(Connection conn, Statement stmt, String password){
        try {
            stmt.executeUpdate("INSERT INTO cuentas VALUES (null, '"+ this.nombreCliente +"', '"+ password +"', 0)");
        } catch (SQLException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    public boolean revisarUsuario(Connection conn, Statement stmt, String password){
        try {
            //Revisamos en BD si el usuario existe:
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from cuentas WHERE nombreCliente = '" + this.nombreCliente + "'");
            rsmd = rs.getMetaData();
            rs.next(); //Se posiciona el cursor en la columna donde está el resultado
            
            if (rs.getString("nombreCliente").equals(nombreCliente)){
                if(rs.getString("password").equals(password)){
                    this.id_Cuenta = Integer.parseInt(rs.getString("idCuenta"));
                    this.saldo = Integer.parseInt(rs.getString("saldo"));
                    return true;
                }
            } else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
    
    public void revisarSaldo(Connection conn, Statement stmt){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from cuentas WHERE nombreCliente = '" + this.nombreCliente + "'");
            rsmd = rs.getMetaData();
            rs.next();
            this.saldo = Integer.parseInt(rs.getString("saldo"));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PtM
 */
public class testSQL {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null; 
    private static ResultSetMetaData rsmd = null;
    
    public testSQL(){
        
    }
    
    private void conectarYVer() throws ClassNotFoundException{
        try{
            // load and register JDBC driver for MySQL
            String user = "Pedro Perez";
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * from cuentas WHERE nombreCliente = '" + user + "'");
            rsmd = rs.getMetaData();
            int columnas = rsmd.getColumnCount();
            
//            if (stmt.execute("SELECT * FROM cuentas")){
//                rs = stmt.getResultSet();
//            }
            
            while(rs.next()){
                for(int i = 1; i <= columnas; i++){
//                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                    System.out.println("");
                } 
            }
            
        }catch (SQLException e){
            System.out.println("Creo que entró aquí");
            System.out.println("SQLException:" + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        testSQL ts = new testSQL();
        ts.conectarYVer();
    }
    
}

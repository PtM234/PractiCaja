/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class HiloServidor{
    
    private Socket cliente;
    private Connection conn;
    private Statement stmt;
    private Cuenta cuenta;
    private DataInputStream entrada;
    private InputStream inputStream;
    private DataOutputStream salida;
    private OutputStream outputStream;
//    private ObjectInputStream objectInputStream;
    private String pass;
    private int opcMenu, opcLog;
    private boolean exito = false;
    
    public HiloServidor(Socket c){
        try {
            this.cliente = c;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
            stmt = conn.createStatement();
            cuenta = new Cuenta(0, "", 0);
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());    
            
            
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void run(){
        menuLog();
        menuPrincipal();
    }
    
    public void menuLog(){
        try{
            
            opcLog = entrada.readInt();
            System.out.println("Opción #: " + opcLog);

            
            /* En este caso va a haber 2 opciones disponibles:
                1.- Registrar al Usuario 
                2.- Loggear al Usuario
            */
            switch(opcLog){
                case 1: //Registrar usuario
                    System.out.println("Registrando usuario!");
                    cuenta.setId_Cuenta(entrada.readInt());
                    cuenta.setNombreCliente(entrada.readUTF());
                    pass = entrada.readUTF();
                    cuenta.setSaldo(entrada.readInt());
                    cuenta.insertarUsuario(conn, stmt, pass);
                    cuenta.revisarUsuario(conn, stmt, pass);
                    salida.writeBoolean(true);
                    salida.writeInt(cuenta.getId_Cuenta());
                    break;
                case 2: //Loggear usuario
                    do{
                        System.out.println("Tratando de loggear Usuario");
                        cuenta.setNombreCliente(entrada.readUTF());
                        pass = entrada.readUTF();
                        if(cuenta.revisarUsuario(conn, stmt, pass)){
                            exito = true;
                            salida.writeBoolean(true);
                            salida.writeInt(cuenta.getId_Cuenta());
                            salida.writeInt(cuenta.getSaldo());
                            
                        }else{
                            salida.writeBoolean(exito);
                        }
                        

                    }while(!exito);
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println("Fin del Loggeo" );
        }
    }
    
    public void menuPrincipal(){
        try{
            do{
                opcMenu = entrada.readInt();
                switch(opcMenu){
                    case 1:
                        //Retirar efectivo
                        System.out.println("opción 1");
                        break;
                    case 2:
                        //Depositar efectivo
                        System.out.println("opción 2");
                        break;
                        
                    case 3:
                        //Movimientos y Saldo
                        System.out.println("opción 3");
                        break;
                        
                    case 4:
                        //Pagar servicios
                        System.out.println("opción 4");
                        break;
                }
            }while(opcMenu!=5);
            System.out.println("Adios!");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

    

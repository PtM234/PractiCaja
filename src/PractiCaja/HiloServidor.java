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
import java.io.Serializable;
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
    private DataInputStream dataInput;
    private InputStream inputStream;
    private DataOutputStream dataOutput;
    private OutputStream outputStream;
    private ObjectInputStream objectInputStream;
    private String pass;
    private int opcLog, opcMenu;
    private boolean exito = false;
    
    public HiloServidor(Socket c){
        try {
            this.cliente = c;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/clientes","root","");
            stmt = conn.createStatement();
            System.out.println("Entró aquí 11111");
        } catch (SQLException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        try{
            dataInput = new DataInputStream(cliente.getInputStream());
            dataOutput = new DataOutputStream(cliente.getOutputStream());
            
            opcLog = dataInput.readInt();
            System.out.println("Entró aquí");
            
            /* En este caso va a haber 2 opciones disponibles:
                1.- Registrar al Usuario 
                2.- Loggear al Usuario
            */
            switch(opcLog){
                case 1: //Registrar usuario
                    inputStream = cliente.getInputStream();
                    objectInputStream = new ObjectInputStream(inputStream);
                    cuenta = (Cuenta) objectInputStream.readObject();
                    System.out.println("Recibí el objeto");
                    pass = dataInput.readUTF();
                    cuenta.insertarUsuario(conn, stmt, pass);
                    dataOutput.writeBoolean(true);
                    break;
                case 2: //Loggear usuario
                    do{
                    inputStream = cliente.getInputStream();
                    objectInputStream = new ObjectInputStream(inputStream);
                    cuenta = (Cuenta) objectInputStream.readObject();
                    pass = dataInput.readUTF();
                    if(cuenta.revisarUsuario(conn, stmt, pass)){
                        dataOutput.writeBoolean(true);
                        exito = true;
                    } else{
                        dataOutput.writeBoolean(false);
                    }
                    }while(!exito);
                    break;
            }
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

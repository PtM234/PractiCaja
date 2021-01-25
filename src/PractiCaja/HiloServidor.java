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

/**
 *
 * @author PtM
 */
public class HiloServidor {
    
    private Socket cliente;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;
    
    public HiloServidor(Socket client){
        this.cliente = client;
    }
    
    public void run(){
        try{
            dataInput = new DataInputStream(cliente.getInputStream());
            dataOutput = new DataOutputStream(cliente.getOutputStream());
            
            
            
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

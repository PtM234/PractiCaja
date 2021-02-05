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
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class Prueba {
    private int numero;
    private Socket cliente;
    private InputStream inputStream;
    private DataInputStream entrada;
    private OutputStream outputStream;
    private DataOutputStream salida;
    
        public Prueba(int unNumero){
        try {
            this.numero = unNumero;
            cliente = new Socket("localhost", 1234);
        } catch (IOException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
        public void enviarNumero(){
        try {
            inputStream = cliente.getInputStream();
            outputStream = cliente.getOutputStream();
            entrada = new DataInputStream(inputStream);
            salida = new DataOutputStream(outputStream);
            
            salida.writeInt(numero);
            System.out.println("Se envió");
            salida.writeInt(numero+1);
            salida.writeUTF("Esta es una prueba");
            
        } catch (IOException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    public static void main(String[] args) {
        Prueba test = new Prueba(1);
        test.enviarNumero();
    }
    
}

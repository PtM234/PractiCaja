/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaObjetos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class Cliente {
    private Socket clienteSocket;
    private OutputStream output;
    private ObjectOutputStream salida;

    public Cliente() {
        try {
            clienteSocket = new Socket("localhost", 1234);
            output = clienteSocket.getOutputStream();
            salida = new ObjectOutputStream(output);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        private void enviarObjeto(ObjetoPrueba obj){
        try {
            salida.writeObject(obj);
            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public static void main(String[] args) {
        ObjetoPrueba op = new ObjetoPrueba("Hola!");
        Cliente c = new Cliente();
        c.enviarObjeto(op);
        
    }
    
}

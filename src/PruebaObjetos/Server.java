/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaObjetos;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PtM
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket clienteSocket;
    private InputStream inputStream;
    private ObjectInputStream entrada;

    public Server() {
        try {
            serverSocket = new ServerSocket(1234);
            clienteSocket = serverSocket.accept();
            inputStream = clienteSocket.getInputStream();
            entrada = new ObjectInputStream(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void recibirObjeto(){
        try {
            ObjetoPrueba op = (ObjetoPrueba) entrada.readObject();
            System.out.println(op.getMsg());
            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Server s = new Server();
        s.recibirObjeto();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author PtM
 */
public class Servidor {
    private ServerSocket serv;
    private Socket client;
    private int contador;
    
    public Servidor(){
        try{
            serv = new ServerSocket(1234);
            System.out.println("Server a la escucha en puerto 1234");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void iniciar(){
        while(true){
            try{
                client = serv.accept();
                contador++;
                System.out.println("Se conectó el cliente:" + contador+ " Desde ip: " + client.getInetAddress());
                HiloServidor hs = new HiloServidor(client);
                hs.run();
            } catch (IOException e){
                e.printStackTrace();
            }
            
            
        }
    }
    public static void main(String[] args) {
        Servidor s = new Servidor();
        s.iniciar();
    }
}
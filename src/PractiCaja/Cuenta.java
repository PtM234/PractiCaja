/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

/**
 *
 * @author PtM
 */
public class Cuenta {
    
    private int id_Cuenta;
    private String nombreCliente;
    private int saldo;
    
    public Cuenta(int cuenta, String Cliente, int saldoCliente){
        this.id_Cuenta = cuenta;
        this.nombreCliente = Cliente;
        this.saldo = saldoCliente;
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
    
}

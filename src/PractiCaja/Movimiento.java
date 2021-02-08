/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PractiCaja;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PtM
 */
public class Movimiento implements Serializable{
    private String nombreCliente, tipoMovimiento, fecha;

    public Movimiento(String nombreCliente, String tipoMovimiento, String fecha) {
        this.nombreCliente = nombreCliente;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    
    
}

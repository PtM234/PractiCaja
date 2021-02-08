/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebaObjetos;

import java.io.Serializable;

/**
 *
 * @author PtM
 */
public class ObjetoPrueba implements Serializable{
    private String msg;

    public ObjetoPrueba(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    
    
}

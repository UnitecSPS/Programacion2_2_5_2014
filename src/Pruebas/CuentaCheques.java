/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import java.util.ArrayList;

/**
 *
 * @author Docente
 */
public class CuentaCheques extends CuentaBancaria {
    private ArrayList<Cheque> cheques;
    private int numChequera;
    
    public CuentaCheques(int n,String no,int nc){
        super(n,no);
        cheques = new ArrayList<>();
        numChequera = nc;
    }
    
    @Override
    public String toString(){
        return super.toString() + " NC: "+numChequera;
    }
}

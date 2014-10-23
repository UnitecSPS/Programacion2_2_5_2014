/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Docente
 */
public class CuentaBancaria {
    protected int numero;
    protected String nombre;
    protected double saldo;
    
    public CuentaBancaria(int n, String no){
        numero = n;
        nombre = no;
        saldo = 500;
    }
    
    @Override
    public String toString(){
        return numero + " - " + nombre + " Lps."+saldo;
    }
}

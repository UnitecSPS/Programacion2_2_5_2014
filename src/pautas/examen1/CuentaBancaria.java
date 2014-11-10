/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

/**
 *
 * @author Docente
 */
public abstract class CuentaBancaria {
    protected int numero;
    protected String nombre;
    protected double saldo;
    
    public CuentaBancaria(int n,String no){
        numero = n;
        nombre = no;
        saldo = 500;
    }

    public int getNumero() {
        return numero;
    }
    
    public void deposito(double m){
        saldo += m;
    }
    
    public abstract boolean retiro(double m);
    
    @Override
    public String toString(){
        return numero + nombre + saldo;
    }
}

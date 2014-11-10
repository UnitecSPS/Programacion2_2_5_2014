/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente
 */
public final class CuentaAhorro extends CuentaBancaria {
    private boolean activo;
    private Date fecha;
    public static final double TASA_INTERES=0.3;
    
    public CuentaAhorro(int n,String no){
        super(n,no);
        activo = true;
        fecha = new Date();
    }
    
    @Override
    public void deposito(double m){
        if(!activo){
            activo = true;
            m *= 0.9;
        }
        saldo += m;
        fecha = new Date();
    }
    
    @Override
    public boolean retiro(double m){
        if(activo && saldo > m){
            saldo -= m;
            fecha = new Date();
            return true;
        }
        return false;
    }
    
    public final void desactivar(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -6);
        
        if(fecha.before(c.getTime())){
            activo = false;
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + "AHORRO " +
                (activo ? "ACTIVO" : "DESACTIVADO");
    }
}

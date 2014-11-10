    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class Banco {
    ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
    
    public CuentaBancaria search(int nc){
        for(CuentaBancaria cb : cuentas){
            if(cb.getNumero() == nc)
                return cb;
        }
        return null;
    }
    
    public void addCuenta(TipoCuenta tipo){
        Scanner lea = new Scanner(System.in);
        int num = lea.nextInt();
        
        if(search(num) == null){
            String c = lea.next();
            
            if(tipo == TipoCuenta.AHORRO)
                cuentas.add( new CuentaAhorro(num,c));
            else
                cuentas.add( new CuentaCheque(num,c));
        }
    }
    
    public boolean transferir(int nc1, int nc2, double m){
        CuentaBancaria c1 = search(nc1);
        CuentaBancaria c2 = search(nc2);
        
        if(c1 != null && c2 != null){
            if(c1.retiro(m)){
                c2.deposito(m);
                return true;
            }
        }
        return false;
    }
    
    public void evaluarDesactivar(int pos){
        if(pos < cuentas.size()){
            if( cuentas.get(pos) instanceof CuentaAhorro)
                ((CuentaAhorro)cuentas.get(pos)).desactivar();
            evaluarDesactivar(pos+1);
        }
    }
    
    public void printInfo(int nc){
        CuentaBancaria cb = search(nc);
        if(cb != null){
            System.out.println(cb);
            if( cb instanceof CuentaCheque)
                ((CuentaCheque)cb).listar();
        }
    }
}

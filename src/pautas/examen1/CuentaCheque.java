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
public final class CuentaCheque extends CuentaBancaria {
    private ArrayList<Cheque> cheques;
    
    public CuentaCheque(int n,String no){
        super(n,no);
        cheques = new ArrayList<>();
    }
    
    @Override
    public boolean retiro(double m){
        Scanner lea = new Scanner(System.in);
        String bene = lea.next();
        boolean rebotado = true;
        
        if(saldo > m){
            saldo -= m;
            rebotado = false;
        }
        cheques.add(new Cheque(bene,m,rebotado));
        return !rebotado;
    }
    
    public void listar(){
        for(int p=0; p < cheques.size(); p++){
            Cheque ch = cheques.get(p);
            System.out.println(p+ch.beneficiario+
                    ch.monto+ (ch.rebotado ? "REBOTADO" : "COBRADO") );
        }
    }
    
    @Override
    public String toString(){
        return super.toString()+ "CHEQUES";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.prestamos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author raim
 */
public class Prestamo implements Loanable, Serializable{
    private int codigo;
    private String nombre;
    private double montoTotal;
    private Calendar fechaCreacion;
    private Calendar fechaMaxima;
    private double balance;

    public int getCodigo() {
        return codigo;
    }    
    
    public Prestamo(int cod, String nom, double monto) throws LoanInvalidException{
        codigo = cod;
        nombre = nom;
        if (monto < 10000)
            throw new LoanInvalidException(monto);
        
        montoTotal = monto;
        balance = monto;
        fechaCreacion = Calendar.getInstance();
        fechaMaxima = Calendar.getInstance();
        fechaMaxima.set(fechaCreacion.get(Calendar.YEAR) + 5, 
                fechaCreacion.get(Calendar.MONTH), 
                fechaCreacion.get(Calendar.DAY_OF_MONTH));        
    }
    
    @Override
    public void pay(double monto) throws AlreadyPaidException {
        if (balance == 0)
            throw new AlreadyPaidException();
        
        Calendar fechaActual = Calendar.getInstance();
        if (fechaActual.after(fechaMaxima))
            monto *= 0.8;
        
        if (monto > balance)
            balance = 0; 
        else
            balance -= monto;
        
        System.out.printf("El balance actual es de L. %.2f\n", balance);
    }

    @Override
    public double balanceDue() {
        return balance;
    }
    
    public void print(){        
        System.out.printf("Codigo: %d - Cliente: %s - Monto total: %.2f - " + 
                "Balance: %.2f - Fecha de creacion: %tD - Fecha maxima para pagar: %tD  %s %n",
                codigo, nombre, montoTotal, balance, fechaCreacion, fechaMaxima, 
                new Date().getTime() > fechaMaxima.getTimeInMillis() ? " - Esta en mora" : "");
    }
    
    public void updateFechaMaxima(String date){
        try{    
            String [] datosFecha = date.split("/");   
            int day = Integer.parseInt(datosFecha[0]);                             
            int month = Integer.parseInt(datosFecha[1]); 
            int year = Integer.parseInt(datosFecha[2]);                            
            fechaMaxima.set(year, month, day);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Fecha enviada con formato incorrecto.");
        }           
        
    }
}

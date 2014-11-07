/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.barcos;

import java.util.Scanner;
/**
 *
 * @author Raim
 */
public class BarcoPasajero extends Barco{
    private String [] nombres;
    private double precioPorBoleto;
    private int cantPasajeros;
    private final static Scanner lea = new Scanner(System.in);
    
    public BarcoPasajero(String nom, int size, double precio) {
        super(nom);
        nombres = new String[size];
        cantPasajeros = 0;
        precioPorBoleto = precio;
    }

    public int buscarPosicionLibre(){        
        for (int i = 0; i < nombres.length; i++){
            if (nombres[i] == null)
                return i;
        }
        
        return -1;
    }
    
    @Override
    public void agregarElemento() {
        int pos = buscarPosicionLibre();
        if (pos > -1){
            System.out.print("Ingrese el nombre del pasajero: ");
            nombres[pos] = lea.next();
            cantPasajeros++;
        }else
            System.out.println("Ya no hay más espacio para los pasajeros.");
    }

    @Override
    public double vaciarCobrar() {
        int totalPas = cantPasajeros;
        cantPasajeros = 0;
        
        return totalPas * precioPorBoleto;
    }
    
    public void listarPasajeros(){
        System.out.println("**PASAJEROS QUE COMPRARON BOLETOS**");
        for(String pas : nombres){
            if (pas != null)
                System.out.println("Nombre: " + pas);
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nCantidad de pasajeros que compraron boleto: #" + cantPasajeros;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.barcos;

/**
 *
 * @author Raim
 */
public class BarcoPesquero extends Barco{
    private int pecesCapturados;
    public final double precioPorPescado;
    
    public BarcoPesquero(String nom, double precio) {
        super(nom);
        precioPorPescado = precio;
        pecesCapturados = 0;
    }    
    
    @Override
    public void agregarElemento() {
        pecesCapturados++;
    }

    @Override
    public double vaciarCobrar() {
        int totalPeces = pecesCapturados;
        pecesCapturados = 0;
        return totalPeces * precioPorPescado;
    }
    
    public void agregarCardumen(int cant){
        pecesCapturados += cant;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nPeces Capturados: #" + pecesCapturados;
    }
    
}

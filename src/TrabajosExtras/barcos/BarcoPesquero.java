/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.barcos;

import errores.CardumenException;

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
    
    /**
     * Agregar una <code>Cant</code> especifica de peces
     * @param cant la cantidad del cardumen
     * @throws CardumenException Si la cantidad es negativa
     */
    public void agregarCardumen(int cant)throws CardumenException {
        if( cant < 0 )
            throw new CardumenException(cant);
        pecesCapturados += cant;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nPeces Capturados: #" + pecesCapturados;
    }
    
}

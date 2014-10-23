/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public class Mago extends Heroe {

    public Mago(String n) {
        super(70, n);
    }

    @Override
    public String toString() {
        return "Mago{"+ super.toString() + "}"; 
    }
    
    public void spellsDisponibles(){
        System.out.println("-Abracadabra Patas de Cabra");
        System.out.println("-Wingardium Leviosa");
        System.out.println("-Esprectro Patronum");
        System.out.println("-Sectusempra");
    }

    @Override
    public void atacar() {
        System.out.println("Agito la varita y le tiro un spell");
    }
    
    
    
}

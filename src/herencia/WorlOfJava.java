/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;

/**
 *
 * @author Docente
 */
public class WorlOfJava {
    public static void main(String[] args) {
        ArrayList<Heroe> heroes = new ArrayList<>();
        
        heroes.add( new Guerrero("Aragorn")  );
        heroes.add( new Mago("Gandalf") );
        heroes.add( new Arquero("Legolas","Envenenada") );
        
        for(Heroe h : heroes){
            h.atacar();
            //downcasting directo
            if( h instanceof Guerrero){
                int scp = ((Guerrero)h).getEscudop();
                System.out.println("Escudo: " + scp);
            }
            else if( h instanceof Mago ){
                ((Mago)h).spellsDisponibles();
            }
        }
    }
}

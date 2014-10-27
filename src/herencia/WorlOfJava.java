/** To change this license header, choose Licnse Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Docente
 */
public class WorlOfJava {
    public static void main(String[] args) {
        ArrayList<Heroe> heroes = new ArrayList<>();
        Calendar c = Calendar.getInstance();//new Calendar();
        //heroes.add( new Heroe(10,"Patito") );
        heroes.add( new Guerrero("Aragorn")  );
        heroes.add( new Mago("Gandalf") );
        heroes.add( new Arquero("Legolas","Envenenada") );
        heroes.add( new Jedi("Obi Wan-kenobi"));
        
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

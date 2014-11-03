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
    static ArrayList<Heroe> heroes = new ArrayList<>();
    
    public static void main(String[] args) {
        
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
    
    public static void addHeroe(TipoHeroe tipo){
        //como comparar un enum
        if( tipo == TipoHeroe.GUERRERO )
            System.out.println("Seleccione un Guerrero");
        else if( tipo.name().equals(TipoHeroe.ARQUERO.name())){
            System.out.println("Seleccione un Arquero");
        }
        else if( tipo.ordinal() == TipoHeroe.MAGO.ordinal() ){
            System.out.println("Seleccione un Mago");
        }
        
        switch(tipo){
            case JEDI:
                System.out.println("Seleccione un Jedi");
                break;
        }
        
    }
}

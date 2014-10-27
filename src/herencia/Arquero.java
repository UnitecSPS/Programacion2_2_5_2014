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
public class Arquero extends Heroe {
    private String flecha;
    
    public Arquero(String n, String f) {
        super(60, n);
        flecha = f;
    }
    
    public String getFlecha(){
        return flecha;
    }

    @Override
    public String toString() {
        return "Arquero{"+super.toString()+"}"; 
    }

    @Override
    public void defensa(Heroe heroe) {
        //super.defensa(heroe); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atacar() {
        System.out.println("Agarro mi arco, selecciono una flecha y se lanzo a mi blanco.");
    }
    
    
}

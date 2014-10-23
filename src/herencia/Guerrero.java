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
public class Guerrero extends Heroe {
    public int escudop;

    public Guerrero(String n){
        super(100,n);
        escudop = 200;
    }
    
    public int getEscudop() {
        return escudop;
    }

    @Override
    public String toString() {
        return "Guerrero{" + super.toString() +
                " escudop=" + escudop + '}';
    }

    @Override
    public void atacar() {
        System.out.println("Agarro mi espada y me cubro con mi escudo");
    }

    @Override
    public void defensa(Heroe heroe) {
        //TODO
    }
    
    
    
}

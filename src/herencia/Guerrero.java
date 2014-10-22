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
        atacar();
        escudop = 200;
        //super.hp+=escudop;
        hp+=escudop;
        //this.hp+=escudop;
    }
    
    public int getEscudop() {
        return escudop;
    }

    @Override
    public String toString() {
        return "Guerrero{" + super.toString() +
                " escudop=" + escudop + '}';
    }
    
    
}

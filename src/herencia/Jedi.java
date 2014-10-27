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
public class Jedi extends Guerrero {

    public Jedi(String n) {
        super(n);
        escudop = 500;
    }
    
    @Override
    public void atacar(){
        System.out.println("BLUM! se prendio mi lightsaber");
    }
    
}

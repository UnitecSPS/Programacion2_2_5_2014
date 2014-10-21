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
public class Battle {
    public static void main(String[] args) {
        Heroe knight = new Guerrero("Aragorn");
        //knight = new Mago("Gandalf");
        knight.atacar();
        System.out.println("name: " + knight.name);
        
        //obj instanceof Clase
        if(knight instanceof Heroe)
            System.out.println("Soy Heroe!");
        if(knight instanceof Guerrero)
            System.out.println("Soy Guerrro!");
        if(knight instanceof Mago)
            System.out.println("Abracadabra");
    }
}

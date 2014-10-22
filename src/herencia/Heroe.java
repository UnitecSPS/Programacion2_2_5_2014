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
public class Heroe {
    protected int hp;
    protected String name;
    
    public Heroe(int hp,String n){
        this.hp = hp;
        name = n;
    }
    
    public void atacar(){
        System.out.println("Especifique su heroe");
    }
    
    public void defensa(Heroe heroe){
        hp = 0;
    }
    
    @Override
    public String toString(){
        return "Nombre: " + name + " - "+hp+" hp";
    }
}

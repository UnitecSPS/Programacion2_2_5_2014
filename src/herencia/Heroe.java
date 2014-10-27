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
public abstract class Heroe {
    protected int hp;
    protected String name;
    
    public Heroe(int hp,String n){
        this.hp = hp;
        name = n;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public abstract void atacar();
    
    public abstract void defensa(Heroe heroe);
    
    @Override
    public String toString(){
        return "Nombre: " + name + " - "+hp+" hp";
    }
}

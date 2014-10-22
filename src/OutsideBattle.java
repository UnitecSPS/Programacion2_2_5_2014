
import herencia.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Docente
 */
public class OutsideBattle {
    public static void main(String[] args) {
        Heroe knight = new Guerrero("Aragorn");
        //knight = new Mago("Gandalf");
        knight.atacar();
        System.out.println(knight.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author raim
 */
public class TestNodos {
    public static void main(String[] args) {
        NodoList list = new NodoList();
        
        list.add(new Nodo("Raim"));
        list.add(new Nodo("Jose"));
        list.add(new Nodo("Nexer"));
        list.add(new Nodo("Luis"));
        list.add(new Nodo("Andrea"));
        
        list.print();
        
        System.out.println("");
        
        list.remove("Raim");                
        list.remove("Lui");
        list.remove("Nexer");
        list.remove("Andrea");           

        list.print();
    }
}

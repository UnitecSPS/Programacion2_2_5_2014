/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import java.util.Scanner;

/**
 *
 * @author raim
 */
public class TestLists {
    public static void main(String[] args) {
        NodoList list = new NodoList();        
        Scanner lea = new Scanner(System.in);

        list.add(new Nodo("Raim"));
        list.add(new Nodo("Jose"));
        list.add(new Nodo("Nexer"));
        list.add(new Nodo("Luis"));
        list.add(new Nodo("Andrea"));
        list.append(new Nodo("Doppel"), "Raim");
        list.print();
        
        System.out.println("\nSize: " + list.size());
        
        System.out.println("");
        
        list.remove("Raim");                
        list.remove("Lui");
        list.remove("Nexer");
        list.remove("Andrea");           
        
        list.print();    
        System.out.println("\nSize: " + list.size());

        //list.clear();
        list.append(new Nodo("Hola"), "Jose");
        System.out.println("");
        list.print();    
        System.out.println("\nSize: " + list.size());
        
        System.out.print("\nIngrese el texto a buscar: ");
        String txt = lea.next();
        System.out.printf("\nContains %s: %s\n", txt, list.contains(txt));
    }
}

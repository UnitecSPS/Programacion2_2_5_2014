/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Docente
 */
public class FundamentoBasico {
    public static void main(String[] args) {
        int x = 5;
        int y = x;
        y = 10;
        System.out.println(x+"-"+y);
        
        Nodo nx = new Nodo("5");
        Nodo ny = nx;
        ny.texto = "10";
        System.out.println(nx.texto+"-"+ny.texto);
        
        //ahora con funciones
        modifyInt(y);
        System.out.println("Ahora Y: "+y);
        
        modifyNodo(nx);
        System.out.println(nx.texto+"-"+ny.texto);
        
        //ny = new Nodo("aqui ya no");
        if( ny == nx )
            System.out.println("SI SON EL MISMO ESPACIO!");
        
        
        String s1 = "hola";
        String s2 = new String("hola");
        System.out.println(s1+s2);
        if( s1 == s2)
            System.out.println("SI SON IGUALES!");
    }
    
    public static void modifyInt(int x){
        x++;
        System.out.println("x cambiado: "+x);
    }
    
    public static void modifyNodo(Nodo x){
        x.texto = "Modify!";
        System.out.println("Nodo en la func: "+x.texto);
    }
}

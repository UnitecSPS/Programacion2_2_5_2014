/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Docente
 */
public class AlReves {
    
    public static void alReves(int n){
        if (n < 10)
            System.out.print(n);
        else{
            System.out.print(n % 10);
            alReves(n / 10);
        }
    }
    
    private static void vuelta(int x){
    
        String y = Integer.toString(x);
        int z = y.length()-1;
        vuelta(y, z);
    }
        
    public static void vuelta(String a, int c){
        
        if (c >= 0){
            System.out.print(a.charAt(c));
            vuelta(a, c-1);
        }
    }
            
    public static void main(String[] args) {
        alReves(320);
        System.out.println("   ");
        vuelta(201);
    }
}

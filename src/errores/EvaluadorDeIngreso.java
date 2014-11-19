/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errores;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class EvaluadorDeIngreso {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        int x;
        
        while(true){
            try{
                x = lea.nextInt();
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Ingrese un entero por favor");
                lea.next();
            }
        }
    }
}

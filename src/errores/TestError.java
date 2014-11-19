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
public class TestError {
    public static void main(String[] args) {
        System.out.println("Inicio Main");
    
        try{
            A();
            System.out.println("Terminando Try");
        }
        catch(ArithmeticException e){
            System.out.println("No dividas entre 0 vo!");
        }
        catch(InputMismatchException e){
            System.out.println("Ingrese un entero");
        }
        finally{
            System.out.println("Ejecutando Finally");
        }
        /*catch(Exception e){
            System.out.println("ERROR: "+
                    e.getMessage());
            //e.printStackTrace();
        }*/
            
        
        System.out.println("Finalizo Main");
    }

    private static void A() {
        System.out.println("Inicio A");
        B();
        System.out.println("Finalizo A");
    }

    private static void B() {
        System.out.println("Inicio B");        
        Scanner lea = new Scanner(System.in)/*null*/;
        int x = lea.nextInt();
        int vals[] = {1,2,0};
        int y = 5/vals[x];
        System.out.println("Y: " + y);
        System.out.println("Finalizo B");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.prestamos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author raim
 */
public class GestionPrestamos {    
    static Scanner lea = new Scanner(System.in);          
    static ArrayList<Prestamo> prestamos = new ArrayList<>();    
    
    public static void main(String[] args) {
        
        byte op = 0;
           
        do{             
            System.out.print("\n\t***GESTION DE PRESTAMOS*\n1. Agregar Prestamos.\n" +              
                    "2. Pagar cuota.\n3. Ver informacion de prestamo.\n4. Salir.\n" +              
                    "Ingrese el numero de su opcion: ");   
            try{
                op = lea.nextByte();
                          
                switch (op){               
                    case 1:               
                        agregarPrestamo();                 
                        break;                
                    case 2:                 
                        pagarCuota();                  
                        break;                  
                    case 3:                   
                        infoPrestamo();                   
                        break;                
                    case 4:                     
                        System.out.println("SALIENDO...");                      
                        break;
                    default:                     
                        System.out.println("Opcion invalida.");                
                }
            }catch (LoanInvalidException lie){
                System.out.println(lie.getMessage());                
            }catch (InputMismatchException ime){
                System.out.println("Ingrese un entero por favor.");
                lea.next();
            }catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
                        
        }while (op != 4); 
    }
    
    //a. AGREGAR PRÉSTAMOS.  Se ingresan los datos necesarios y se valida que el código sea único.
    private static void agregarPrestamo() throws LoanInvalidException{
        int code = ingresoCodigo();
        System.out.print("Ingrese el nombre del cliente del prestamo: ");
        String nom = lea.next();
        System.out.print("Ingrese el monto del prestamo: ");
        double monto = lea.nextDouble();
        
        if (searchPrestamo(code) != null)
            System.out.println("El codigo no es unico. Regresando al menu.");
        else{
           prestamos.add(new Prestamo(code, nom, monto));
           System.out.println("Prestamo agregado exitosamente.");
        }
    }

    private static int ingresoCodigo(){        
        System.out.print("Ingrese el codigo del prestamo: ");
        return lea.nextInt();
    }
    
    //b. PAGAR CUOTA. Se pide el  código, y si existe, se ingresa el monto a pagar.
    private static void pagarCuota() {
        int code = ingresoCodigo();
        Prestamo loan = searchPrestamo(code);
        if (loan == null)
            System.out.println("El codigo no existe. Regresando al menu.");
        else{
            System.out.print("Ingrese el monto a pagar: ");
            double monto = lea.nextDouble();
            loan.pay(monto);            
        }
    }

    /*
    c. VER INFORMACIÓN DE PRESTAMO. Ingresando el código y si existe, 
    se imprime todos los datos del mismo.
    */
    private static void infoPrestamo() {
        int code = ingresoCodigo();
        Prestamo loan = searchPrestamo(code);
        if (loan != null)
            loan.print();
        else
            System.out.println("El prestamo no existe. Regresando al menu.");
    }
    
    private static Prestamo searchPrestamo(int code){
        for(Prestamo p : prestamos){
            if (p.getCodigo() == code)
                return p;
        }
        return null;
    }
}

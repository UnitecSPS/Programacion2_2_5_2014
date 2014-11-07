/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.barcos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Raim
 */
public class Muelle {
    static ArrayList<Barco> boats = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int op = 0;
        
        do{              
            System.out.print("\t***MENU***\n1. Agregar barco.\n2. Agregar elemento.\n" + 
                "3. Vaciar Barco.\n4. Listar pasajeros.\n5. Agregar cardumen.\n6. Salir." +
                    "\nIngrese su opcion: ");
            op = lea.nextInt();
            switch(op){
                case 1:
                    System.out.print("1. PESQUERO.\n2. PASAJERO.\n" +
                            "Ingresé el tipo de barco que desea agregar: ");
                    agregarBarco(TipoBarco.valueOf(lea.next().toUpperCase()));
                    break;
                case 2:                
                    agregarElemento(llamarBuscar());
                    break;
                case 3:                    
                    double tot = vaciarBarco(llamarBuscar());
                    System.out.println("Total generado: " + tot);
                    break;
                case 4:
                    listarPasajeros();
                    break;
                case 5:
                    String ba = llamarBuscar();
                    System.out.print("Ingrese la cantidad de peces que se van a agregar: ");
                    int peces = lea.nextInt();
                    agregarCardumen(ba, peces);
                    break;
                case 6:
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese de nuevo.");
            }
 
        }while(op != 6);
       
    }
    
    public static void agregarBarco(TipoBarco tipo){
        Barco b = null;
        String n = "";
        do{
            System.out.print("Ingrese el nombre del barco que desea crear: ");
            n = lea.next();
            b = buscarBarco(n);
        }while(b != null);
        if (tipo == TipoBarco.PASAJERO){
            System.out.print("Ingrese el precio del pasaje: ");
            double precio = lea.nextDouble();
            System.out.print("Ingrese la cantidad de pasajeros que puede tener la nave: ");
            int c = lea.nextInt();
            boats.add(new BarcoPasajero(n, c, precio));
        }
        else{
            System.out.print("Ingrese el precio de los pescados: ");
            double precio = lea.nextDouble();
            boats.add(new BarcoPesquero(n, precio));
        }
    }
    
    public static void agregarElemento(String nombre){
        Barco barc = buscarBarco(nombre);
        if (barc != null)                      
            barc.agregarElemento();        
        else
            System.out.println("Barco no encontrado.");
    }
    
    public static String llamarBuscar(){
        System.out.print("Ingrese el nombre del barco a buscar: ");
            return lea.next();
    }
    
    public static Barco buscarBarco(String n){
        for(Barco b : boats){
            if(b.getNombre().equals(n))
                return b;
        }
        
        return null;
    }
    
    public static double vaciarBarco(String n){
        Barco b = buscarBarco(n);
        if (b != null){
            System.out.println(b);
            return b.vaciarCobrar();
        }else
            System.out.println("Barco no encontrado.");
        
        return 0;
   }

    public static void listarPasajeros() {
        for(Barco b : boats){
            if (b instanceof BarcoPasajero)
                ((BarcoPasajero)b).listarPasajeros();
        }
    }

    public static void agregarCardumen(String nombre, int cantidad) {
        Barco b = buscarBarco(nombre);
        
        if(b instanceof BarcoPesquero){
            ((BarcoPesquero)b).agregarCardumen(cantidad);
            System.out.println("AGREGADO CORRECTAMENTE");
        }else
            System.out.println("Barco pesquero no encontrado.");
    }
}

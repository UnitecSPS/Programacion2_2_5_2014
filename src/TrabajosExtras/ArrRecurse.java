/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras;

import java.util.Scanner;

/**
 *
 * @author raim
 */
public class ArrRecurse {
    private int [] arreg;
    public static Scanner lea = new Scanner(System.in);
    
    public ArrRecurse(int len){
        arreg = new int[len];
    }
    
    private void llenar(int i){
        if(i < arreg.length){
            System.out.printf("%nIngresar el valor: ");
            arreg[i] = lea.nextInt();
            llenar(i + 1);
        }
    }
    
    public void llenar(){
        llenar(0);
    }
    
    private int suma(int i){
        if (i < arreg.length - 1){
            return arreg[i] + suma(i + 1);
            
        }
                    
        return arreg[i];
    } 
    
    public int suma(){
        return suma(0);
    }
    
    private boolean buscar(int n, int i){
        if (i < arreg.length){
            if (arreg[i] != n)
                return buscar(n, i + 1);
            
            return true;
        }
        
        return false;
    }
    
    public boolean buscar(int n){
        return buscar(n, 0);
    }
    
    private int maximo(int n, int i){
        if (i < arreg.length){
            return maximo(Math.max(n, arreg[i]), i + 1);
        }
        
        return n;
    }
        
    public int maximo(){
        return maximo(arreg[0], 1);
    }
    
    private void print(int i){
        if (i < arreg.length){
            System.out.printf("[%d]: %d %n", i, arreg[i]);    
            print(i + 1);
        }    
    }
    
    public void print(){
        print(0);
    }
    
    public int factorialDePos(int i, int n){
        if (n < arreg[i])
            return n * factorialDePos(i, n + 1);
        return n;
    }
    
    public int factorialDePos(int i){
        return factorialDePos(i, 1);
    }
    
    public static void main(String[] args) {
        ArrRecurse arr = new ArrRecurse(10);
//        arr.llenar();
//        System.out.printf("%nSUMA: %d %n", arr.suma());
//        System.out.println("EXISTE: " + arr.buscar(10));
//        System.out.println("MAXIMO: " + arr.maximo());
//        arr.print();
//        for(int i = 0; i < 10; i++)
//            System.out.printf("Factorial [%d]: %d %n", i, arr.factorialDePos(i));
        int res = 0;
        
        do{
            System.out.printf("%n%n***MENU***%n1. Llenar arreglo. %n2. Suma. %n3. Buscar. %n4. Maximo. %n5. Imprimir elementos. %n6. Factorial de la posicion. %n7. Salir.%nIngrese el numero de su seleccion: ");
            res = lea.nextInt();
            int n = 0;
            switch(res){
                case 1:
                    arr.llenar();
                    break;
                case 2:
                    System.out.println("La suma de todos los elementos es: " + arr.suma());
                    break;
                case 3:
                    System.out.print("Inserte un valor de busqueda: ");
                    n = lea.nextInt();
                    System.out.println("Existe: " + arr.buscar(n));
                    break;
                case 4:
                    System.out.print("El valor maximo del arreglo es: " + arr.maximo());
                    break;
                case 5:
                    arr.print();
                    break;
                case 6:
                    do{
                       System.out.print("Buscar el factorial de la posicion (0 - 9): ");
                       n = lea.nextInt();
                    }while(n < 0 || n > 9);
                    System.out.printf("Factorial de la posicion %d es: %d ", n, arr.factorialDePos(n));
                    break;
                case 7:
                    System.out.println("SALIENDO...");
                    break;
                default:
                    System.out.println("Ingreso incorrecto");
            }
        }while (res != 7);
                
    }
}



import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Docente
 */
public class Recursiva {
    int arr[];
    Scanner lea = new Scanner(System.in);
    
    public Recursiva(int lo){
        arr = new int[lo];
    }
    
    public void llenar(){
        llenar(0);
    }

    private void llenar(int pos) {
        if( pos < arr.length ){
            System.out.println("Valor: ");
            arr[pos] = lea.nextInt();
            llenar(pos+1);
        }
    }
    
    public int suma(){
        return suma(0);
    }

    private int suma(int pos) {
        if(pos < arr.length){
            return arr[pos]+suma(pos+1);
        }
        return 0;
    }
    
    public boolean buscar(int n){
        return buscar(n,0);
    }

    private boolean buscar(int n, int pos) {
        if(pos < arr.length){
            if(n == arr[pos])
                return true;
            return buscar(n,pos+1);
        }
        return false;
    }
        
}

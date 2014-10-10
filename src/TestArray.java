
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Docente
 */
public class TestArray {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        ArrayList<Alumno> als = new ArrayList<>();
        
        numeros.add(2);
        numeros.add(5);
        numeros.add(7);
        als.add( new Alumno("Carlos") );
        als.add( new Alumno("Ricardo") );
        
        //size
        System.out.println("Size: " + numeros.size());
        
        //sacar un elemento de acuerdo a su pos
        System.out.println(als.get(0).getNombre());
        
        //remover
        numeros.remove(0);
        System.out.println("Size: " + numeros.size());
        
        //recorrer
        for(Alumno al : als)
            System.out.println(al.getNombre());
        for(int p=0; p < numeros.size(); p++)
            System.out.println(numeros.get(p));
    }
}

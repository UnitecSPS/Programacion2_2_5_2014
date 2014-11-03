/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class TestEnum {
    public static void main(String[] args) {
        //ver ordinal
        System.out.println("Enero: " +
                Mes.ENERO.ordinal());

        //comparar un enum
        WorlOfJava.addHeroe(TipoHeroe.MAGO);
        
        //manejar valores del teclado
        Scanner lea = new Scanner(System.in);
        String tipo = lea.next().toUpperCase();
        WorlOfJava.addHeroe( TipoHeroe.valueOf(tipo) );
        
        //llamar funciones o atributos del enum
        System.out.println("Dias de Febrero: " + 
                Mes.FEBRERO.dias);
    }
}

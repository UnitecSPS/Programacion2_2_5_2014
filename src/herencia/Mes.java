/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public enum Mes {
    ENERO(31), FEBRERO(28), MARZO(31), ABRIL(30), MAYO(31), DICIEMBRE(31);
    final int dias;
    
    Mes(int d){
        dias = d;
    }
    
    int getDias(){
        return dias;
    }
}

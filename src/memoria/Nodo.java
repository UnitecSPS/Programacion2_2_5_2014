/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author Docente
 */
public class Nodo {
    protected String texto;
    protected Nodo siguiente;
    
    public Nodo(String txt){
        texto = txt;
        siguiente = null;
    }
}

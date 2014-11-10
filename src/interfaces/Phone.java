/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Docente
 */
public class Phone {
    protected int numero;
    
    public void call(int nd){
        System.out.println("Llamando a "+nd);
    }
    
    public void sendMsg(int nd,String body){
        System.out.println("Mandando "+body+" a "+nd);
    }
    
    boolean connection(){
        return true;
    }
            
}

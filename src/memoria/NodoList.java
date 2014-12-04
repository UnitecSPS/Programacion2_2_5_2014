/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

/**
 *
 * @author raim
 */
public class NodoList {
    private Nodo inicio = null;
    
    public boolean isEmpty(){
        return inicio == null;
    }
    
    public void add(Nodo obj){
        if (isEmpty())
            inicio = obj;
        else{
            Nodo tmp = inicio;
            
            while(tmp.siguiente != null)
                tmp = tmp.siguiente;
            
            tmp.siguiente = obj;
        }
    }
    
    public void print(){
        Nodo tmp = inicio;
        while (tmp != null){
            System.out.println("-" + tmp.texto);
            tmp = tmp.siguiente;
        }
    }
    
    public void remove (String txt){
        Nodo tmp = inicio;
        
        if (!isEmpty()){
            if(tmp.texto.equals(txt))
                inicio = tmp.siguiente;
            else{                
                while(tmp.siguiente != null){                    
                    if (tmp.siguiente.texto.equals(txt)){          
                        tmp.siguiente = tmp.siguiente.siguiente;       
                        break;                    
                    }else                
                        tmp = tmp.siguiente;                
                }                   
            }            
        }
        
    }
            
    
}
    
    

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
                    if (tmp.siguiente.texto.equalsIgnoreCase(txt)){          
                        tmp.siguiente = tmp.siguiente.siguiente;       
                        break;                    
                    }else                
                        tmp = tmp.siguiente;                
                }                   
            }            
        }
        
    }
     
    /**
     * Busca si el texto a buscar existe en la lista
     * @param txt Texto a buscar dentro de la lista
     * @return <code>true</code> si el objeto es encontrado en la lista
     */
    public boolean contains (String txt){
        Nodo tmp = inicio;
        while(tmp != null){
            if (tmp.texto.equalsIgnoreCase(txt))
                return true;
            
            tmp = tmp.siguiente;
        }
        return false;
    }
    
    /**
     * Devuelve el tamaño de la Lista
     * @return <code>int</code> indicando el tamaño
     */
    public int size(){
        int size = 0;
        
        Nodo tmp = inicio;
        
        while(tmp != null){            
            size++;
            tmp = tmp.siguiente;
        }
        
        return size;
    }
    
    /**
     * Agrega el nodo después del que se ha especificado
     * @param obj Nodo a agregar
     * @param despuesDe Nodo después del cual se agregará el nodo
     * @return <code>true</code> si se pudo agregar
     */
    public boolean append(Nodo obj, String despuesDe){
        Nodo tmp = inicio;
        
        while(tmp != null){
            if(tmp.texto.equalsIgnoreCase(despuesDe)){
                obj.siguiente = tmp.siguiente;
                tmp.siguiente = obj;
                return true;
            }else                
                tmp = tmp.siguiente;            
        }            
        
        return false;
    }
    
    /**
     * Limpia toda la lista
     */
    public void clear(){
        inicio = null;
    }
    
}
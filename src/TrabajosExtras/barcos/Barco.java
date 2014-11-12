/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrabajosExtras.barcos;

import java.util.Calendar;
import java.util.Formatter;

/**
 *
 * @author Raim
 */
public abstract class Barco {
    protected String nombre;
    protected Calendar fechaCirculacion;
    
    public Barco(String nom){
        nombre = nom;
        fechaCirculacion = Calendar.getInstance();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaCirculacion() {
        return fechaCirculacion;
    }

    public void setFechaCirculacion(Calendar fechaCirculacion) {
        this.fechaCirculacion = fechaCirculacion;
    }
    
    public abstract void agregarElemento();
    
    public abstract double vaciarCobrar();
    
    @Override
    public String toString(){
        Formatter formato = new Formatter();
        formato.format("%tF", fechaCirculacion);
        return "Nombre: " + nombre + " - Fecha de Circulación: " + formato.toString();
    }
}

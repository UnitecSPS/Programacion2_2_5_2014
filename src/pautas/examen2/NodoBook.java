/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen2;

/**
 *
 * @author Docente
 */
public class NodoBook {
    public int bookCode;
    public long bookByte;
    public NodoBook nextBook;

    public NodoBook(int bookCode, long bookByte) {
        this.bookCode = bookCode;
        this.bookByte = bookByte;
        nextBook = null;
    }
    
    
}
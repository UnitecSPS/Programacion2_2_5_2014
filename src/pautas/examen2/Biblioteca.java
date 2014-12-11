/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pautas.examen2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.imageio.IIOException;

/**
 *
 * @author Docente
 */
public class Biblioteca {
    private NodoBook root = null;
    private RandomAccessFile rBooks;
    
    public Biblioteca(){
        try{
            new File("library").mkdir();
            rBooks = new RandomAccessFile("library/books.boo", "rw");
            reloadList();
        }
        catch(IOException e){
            
        }
    }

    private void reloadList() throws IOException {
        rBooks.seek(0);
        while(rBooks.getFilePointer() < rBooks.length()){
            long pos = rBooks.getFilePointer();
            int cod = rBooks.readInt();
            rBooks.readUTF();
            rBooks.skipBytes(12);
            addNodo(new NodoBook(cod, pos));
        }
    }

    private void addNodo(NodoBook nodoBook) {
        if(root == null){
            root = nodoBook;
        }
        else{
            NodoBook tmp = root;
            while(tmp.nextBook != null)
                tmp = tmp.nextBook;
            tmp.nextBook = nodoBook;
        }
    }
    
    public long search(int cb){
        NodoBook tmp = root;
        
        while(tmp != null){
            if(tmp.bookCode == cb)
                return tmp.bookByte;
            tmp = tmp.nextBook;
        }
        
        return -1;
    }
    
    public void addBook(int cb, String nb, double pb) throws IOException{
        if(search(cb) == -1){
            rBooks.seek(rBooks.length());
            long pos = rBooks.getFilePointer();
            rBooks.writeInt(cb);
            rBooks.writeUTF(nb);
            rBooks.writeDouble(pb);
            rBooks.writeInt(5);
            addNodo( new NodoBook(cb, pos));
        }
    }
    
    public double rentBook(int code) throws IOException{
        long pos = search(code);
        
        if(pos >= 0){
            rBooks.seek(pos+4);
            String title = rBooks.readUTF();
            double precio = rBooks.readDouble();
            int copias = rBooks.readInt();
            
            if(copias > 0){
                System.out.println(title + " rentado");
                rBooks.seek(rBooks.getFilePointer()-4);
                rBooks.writeInt(copias-1);
                return precio;
            }
        }
        
        return 0;
    }
    
    public void statistics() throws IOException{
        rBooks.seek(0);
        int libros=0,prestados=0,totales;
        double monto=0;
        
        while(rBooks.getFilePointer() < rBooks.length()){
            libros++;
            rBooks.readInt();
            rBooks.readUTF();
            monto += rBooks.readDouble() * 5;
            prestados += (5 - rBooks.readInt());
        }
        
        totales = libros * 5;
        System.out.println("Libros: " + libros);
        System.out.println("Prestados: " + prestados);
        System.out.println("Totales: " + totales);
        System.out.println("Monto: " + monto);
    }
    
    public void report(String filename) throws IOException{
        rBooks.seek(0);
        FileWriter fw = new FileWriter(filename);
        while(rBooks.getFilePointer() < rBooks.length()){
            int co = rBooks.readInt();
            String t = rBooks.readUTF();
            double p = rBooks.readDouble();
            int c = rBooks.readInt();
            
            fw.write(co+t+p+c);
        }
        fw.close();
    }
}

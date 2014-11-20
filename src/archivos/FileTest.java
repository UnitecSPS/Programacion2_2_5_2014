/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package archivos;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Docente 17082011
 */
public class FileTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        String pathname = lea.nextLine();
        
        File file = new File(pathname);
        
        if(file.exists()){
            System.out.println("Existe!");
            //info
            System.out.println("Nombre: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute: " + file.getAbsolutePath());
            System.out.println("Bytes: " + length(file));
            System.out.println("Parent: " + file.getAbsoluteFile().getParentFile().getName());
            
            if(file.isDirectory()){
                System.out.println("Es Un directorio");
                System.out.println("Quieres listar su contenido: ");
                String resp = lea.next();
                
                if(resp.equalsIgnoreCase("si"))
                    dir(file);
                
                System.out.println("Quieres imprimir el tree: ");
                resp = lea.next();
                
                if(resp.equalsIgnoreCase("si"))
                    tree(file);
            }
            if(file.isFile())
                System.out.println("Es un archivo");
            if(file.isHidden())
                System.out.println("Esta escondido");
            if(file.isAbsolute())
                System.out.println("Fue instanciado con una direccion absoluta");
            
            System.out.println("Lo queres borrar");
            String resp = lea.next();
             
            if(resp.equals("SI")){
                if(delete(file))
                    System.out.println("Se borro bien");
            }
            
        }
        else{
            System.out.println("No existe!");
            
            System.out.println("lo quiere crear?");
            String resp = lea.next();
            
            if(resp.equals("SI")){
                System.out.println("FILE o DIR");
                resp = lea.next();
                
                boolean creado = false;
                if(resp.equalsIgnoreCase("file")){
                    try {
                        creado = file.createNewFile();
                    } catch (IOException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
                else{
                    creado = file.mkdirs();
                }
                
                if(creado)
                    System.out.println("Se creo bien");
            }
            
        }
    }

    private static void dir(File file) {
        File children[] = file.listFiles();
        int files=0,dirs=0,tbytes=0;
        
        for(File chi : children){
            if(!chi.isHidden()){
                //ultima modificacion
                System.out.print(new Date(chi.lastModified()));
                //tipó
                if(chi.isDirectory()){
                    System.out.print("\t<DIR>\t");
                    dirs++;
                }
                if(chi.isFile()){
                    System.out.print("\t     \t");
                    files++;
                    System.out.print(chi.length());
                    tbytes += chi.length();
                }
                //nombre
                System.out.println(" " + chi.getName());
            }
        }
        System.out.println(files + " files\t\t" + tbytes + " bytes" );
        System.out.println(dirs + " dirs\t\t" + file.getFreeSpace()+"\n\n\n");
    }
    
    //seudocodigo del tree
        public static void tree(File dir){
        /*1-si es archivo no imprimo nada y la funcion termina
          2-si es directorio, imprimo el nombre y luego
              saco su contenido con listfiles
          3-recorrer con un foreach ese contenido
          4-y cada objeto hijo se manda a la recursion
                */
        if(dir.isDirectory()){
            tree(dir,"");
        }
    }
    
    private static void tree(File dir, String tab) {
        if( dir.isDirectory() && !dir.isHidden()){
            System.out.println(tab+dir.getName());

            for(File chi : dir.listFiles()){
                tree(chi,tab+"\t");
            }
        }
    }

    private static long length(File file) {
        if(file.isFile()){
            return file.length();
        }
        else if(file.isDirectory()){
            File children[] = file.listFiles();
            long len = 0;
            for(File fi : children){
                len += length(fi);
            }
            return len;
        }
        return 0;
    }

    private static boolean delete(File file) {
        try{
            boolean interno = true;
            
            if(file.isDirectory()){
                for(File chi : file.listFiles())
                    interno = delete(chi);
            }
            
            return file.delete() && interno;
            
        }catch(SecurityException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
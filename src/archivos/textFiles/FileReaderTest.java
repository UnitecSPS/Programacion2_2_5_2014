/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.textFiles;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author raim
 */
public class FileReaderTest {
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        System.out.print("Nombre de archivo a leer: ");
        String filename = lea.nextLine();
        
        try{
            File fi = new File(filename);
            FileReader fr = new FileReader(fi);
            
            char [] buffer = new char[(int)fi.length()];
            
            int bytesLeidos = fr.read(buffer);
            
            System.out.println("Bytes leidos: " + bytesLeidos);
            System.out.println("Contenido: \n --------------");
            System.out.println(buffer);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.textFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author raim
 */
public class FileTextTest {
    public static void main(String[] args) throws IOException{
        Scanner lea = new Scanner(System.in);
        System.out.print("Nombre archivo: ");
        String filename = lea.nextLine();
        System.out.print("Lo quiere append? S/N: ");
        char resp = lea.next().toUpperCase().charAt(0);
    
        //hacerlo con try catch with resources
        try(FileWriter fw = new FileWriter(filename, resp == 'S')){
            
            do{
                String dato = lea.nextLine();
                if (dato.equals("#$%"))
                    break;

                fw.write(dato + "\n");                  
                fw.flush();
                //fw.append(dato + "\n");            

            }while(true);

        }       
                    
        //fw.close();
        
    }
}

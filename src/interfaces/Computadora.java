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
public class Computadora implements InternetConnection {

    @Override
    public boolean connection() {
        System.out.println("LLamando a la Tarjeta de Red");
        System.out.println("Enviando solicitud");
        System.out.println("Conectado!");
        return true;
    }

    @Override
    public String getIp() {
        return "192.168.10.3";
    }

    @Override
    public void setIp(String ip) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

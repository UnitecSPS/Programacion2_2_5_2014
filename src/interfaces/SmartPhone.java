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
public class SmartPhone extends Phone implements IConsolidation {
    private String ip=null;
    private String modelo;

    public SmartPhone(String modelo) {
        this.modelo = modelo;
    }
    
    @Override
    public boolean connection(){
        if(ip != null)
            System.out.println("Conectado!");
        else
            System.out.println("No se puede conectar, no tienes una ip");
        return ip != null;
    }
    
    @Override
    public String getIp() {
        return ip;
    }

    @Override
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String getDNS() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void codec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goLive() {
        System.out.println("LIIIIVEEE! "+modelo);
    }

    @Override
    public String videoExtension() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

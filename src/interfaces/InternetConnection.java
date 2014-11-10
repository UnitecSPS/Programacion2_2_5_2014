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
public interface InternetConnection  {
    int version = 1;
    boolean connection();
    String getIp();
    void setIp(String ip);
}

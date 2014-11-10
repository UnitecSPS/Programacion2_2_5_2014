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
public class WWW{
    public static void main(String[] args) {
        InternetConnection ic = new Computadora();
        InternetConnection ic2 = new SmartPhone("IPhone 6");
        
        ic.connection();
        
        ic2.setIp("1111");
        ic2.connection();
        ((SmartPhone)ic2).call(123);
        
        //llamar go live
        ((IStream)ic2).goLive();
        ((IConsolidation)ic2).goLive();
        ((SmartPhone)ic2).goLive();
        
        ((IConsolidation)ic2).getDNS();
        
        
        IStream m = new IStream() {

            @Override
            public void codec() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void goLive() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String videoExtension() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}

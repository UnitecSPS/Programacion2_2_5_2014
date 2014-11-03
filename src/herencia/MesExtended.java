/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author Docente
 */
public class MesExtended {
    final int ordinal;
    int dias;
    static final MesExtended ENERO = new MesExtended(0,31);
    static final MesExtended FEBRERO = new MesExtended(1,28);
    
    public MesExtended(int op,int di){
        ordinal = op;
        dias = di;
    }
            
}

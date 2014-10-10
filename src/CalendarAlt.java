
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raim
 */
public class CalendarAlt {
    public static void main(String[] args) {
        Calendar fech = Calendar.getInstance();
        fech.set(1995, Calendar.MAY, 5);
        /*
         * 
         */
        
        System.out.println("Año: " + fech.get(Calendar.YEAR));
        System.out.println("Mes: " + fech.get(Calendar.MONTH));
        System.out.println("Dia de semana: " + fech.get(Calendar.DAY_OF_WEEK));
        fech.add(Calendar.YEAR, 2);
        fech.add(Calendar.MONTH, -2);
        
        
    }
}

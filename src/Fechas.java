
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Docente
 */
public class Fechas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(1982,Calendar.AUGUST,10);
        System.out.println(c.getTime());
    }
}

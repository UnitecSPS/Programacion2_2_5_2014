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
public class Battle {
    public static void main(String[] args) {
        //UPCASTING
        Heroe knight = new Guerrero("Aragorn");
        //knight = new Mago("Gandalf");
        knight.atacar();
        System.out.println("name: " + knight.name + 
                " hp: " + knight.hp );
        
        //obj instanceof Clase
        if(knight instanceof Guerrero){
            //downcasting indirecto
            Guerrero gue = (Guerrero)knight;
            System.out.println("Escudo: " + gue.getEscudop());
            gue.name = "Patito";
            System.out.println(knight.name);
        }
        else if(knight instanceof Mago)
            System.out.println("Abracadabra");
        else if(knight instanceof Arquero)
            System.out.println("Flechaa");
        else
            System.out.println("Soy Heroe!");
       
        //Funciones On-Demand
        Heroe lempira = new Heroe(23,"Lempira")
        {
            public void test(){
                System.out.println("Bumba Bumba Flechazo al español");
            }
                    
            @Override
            public void atacar(){
                test();
            }
            
            @Override
            public void defensa(Heroe e){
                System.out.println("Me subo a Congolon");
            }
        };
        lempira.atacar();
    }
}

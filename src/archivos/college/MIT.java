/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.college;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class MIT {
    static Instituto mit = new Instituto();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int op=0;
        do{
            System.out.println("1- Agregar Maestro");
            System.out.println("2- Agregar Alumno");
            System.out.println("3- Listar Maestros disponibles");
            System.out.println("4- Listar Alumnos");
            System.out.println("5- Crear Seccion");
            System.out.println("6- Matricular Alumno");
            System.out.println("7- Imprimir Seccion");
            System.out.println("8- Buscar alumno en seccion");
            System.out.println("11- Salir");
            System.out.print("Escoja opcion: ");
            
            try{
                op = lea.nextInt();
                
                switch(op){
                    case 1:
                        addMaestro();
                        break;
                    case 2:
                        addAlumno();
                        break;
                    case 3:
                        mit.listarMaestrosDisponibles();
                        break;
                    case 4:
                        listarAlumnos();
                        break;
                    case 5:
                        crearSeccion();
                        break;
                    case 6:
                        matricular();
                        break;
                    case 7:
                        imprimirSeccion();
                        break;
                    case 8:
                        actualizarNotaAlumno();
                        break;
                }
                
            }catch(InputMismatchException e){
                System.out.println("Ingrese un entero");
                lea.next();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
            catch(IllegalArgumentException e){
                System.out.println("Carrera no es aceptada");
            }
            
        }while(op != 11);
    }

    private static void addMaestro()throws IOException {
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Fecha d/m/anio: ");
        String fecha = lea.next();
        mit.addMaestro(n, getfecha(fecha));
    }

    private static void addAlumno()throws IOException {
        System.out.print("Nombre: ");
        String n = lea.next();
        System.out.print("Fecha d/m/anio: ");
        String fecha = lea.next();
        System.out.print("Carrera: ");
        Carrera car = Carrera.valueOf(lea.next().toUpperCase());
        mit.addAlumno(n, getfecha(fecha), car);
    }

    private static Date getfecha(String fecha) {
        String data[] = fecha.split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);
        Calendar c = Calendar.getInstance();
        c.set(year, mes-1, dia);
        return c.getTime();
    }

    private static void listarAlumnos()throws IOException {
        System.out.print("Listar Todos (T) o segun el estado A,G o R: ");
        mit.listarAlumnos(lea.next().charAt(0));
    }

    private static void crearSeccion()throws IOException {
        System.out.print("Nombre: ");
        String nom = lea.next();
        System.out.print("Numero Maestro: ");
        int nm = lea.nextInt();
        mit.crearSeccion(nom, nm);
    }

    private static void matricular()throws IOException {
        System.out.print("Numero Seccion: ");
        int ns = lea.nextInt();
        System.out.print("Numero Alumno: ");
        int na = lea.nextInt();
        if(mit.inscribirAlumnoEnSeccion(ns, na)){
            System.out.println("Se pudo inscribir");
        }
        else{
            System.out.println("No se pudo inscribir");
        }
    }

    private static void imprimirSeccion() throws IOException{
        System.out.print("Numero de la seccion: ");
        mit.printSeccion(lea.nextInt());
    }

    private static void buscarAlumnoEnSeccion() throws IOException{
        System.out.print("Ingrese el numero de seccion: ");        
        int ns = lea.nextInt();
        System.out.print("Ingrese el numero de alumno: ");
        int na = lea.nextInt();
        
        System.out.println(mit.isAlumnoEnSeccion(na, ns));
    }

    private static void actualizarNotaAlumno() throws IOException{
        System.out.print("Ingrese el numero de seccion: ");        
        int ns = lea.nextInt();
        System.out.print("Ingrese el numero de alumno: ");
        int na = lea.nextInt();
        System.out.println("Ingrese la nota final del alumno");
        double nf  =lea.nextDouble();
        mit.actualizarNotaDeAlumno(ns, na, nf);
    }
}

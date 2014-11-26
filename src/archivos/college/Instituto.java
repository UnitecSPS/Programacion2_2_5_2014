/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.college;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Docente
 * 
 * Formatos
 * >>> maestros.col
CONTIENE:
int numero
string nombre
long fecha
int contador de clases dadas
boolean disponible

>>> alumnos.col
CONTIENE:
int numero
string nombre
long fecha
double promedio
string carrera >> Enum
char estado:
> A activo
> G graduado
> R retirado

>>> alumnos/historial_numeroalumno.col
CONTIENE:
string seccion
double nota
char estado:
>A aprobado
>R reprobado
>P pendiente 

 
>>> secciones/numero#.col
CONTIENE
int año
string nombre clase
int numero de profesor
int cantidad-alumnos
*
int numero de alumno
double notaFinal
char estado


>>> codigos.col
CONTIENE:
int codigo maestros
int codigo alumnos
int codigo secciones

 */
public class Instituto {
    private RandomAccessFile rMaistros, rAlumns;
    public static final String DIR_ROOT = "College";
    
    public Instituto(){
        try{
            new File(DIR_ROOT+"/secciones").mkdirs();
            rMaistros = new RandomAccessFile(DIR_ROOT+"/maestros.col", "rw");
            rAlumns = new RandomAccessFile(DIR_ROOT+"/alumnos.col", "rw");
            initCodesFile();
        }
        catch(IOException e){
            
        }
    }

    private void initCodesFile()throws IOException {
        try (RandomAccessFile rCods = new RandomAccessFile(DIR_ROOT+"/codigos.col", "rw")) {
            if(rCods.length() == 0){
                rCods.writeInt(1);
                rCods.writeInt(1);
                rCods.writeInt(1);
            }
        }
    }
    
    private int getMaestroCodigo() throws IOException{
        return getCodigo(0);
    }
    
    private int getAlumnoCodigo() throws IOException{
        return getCodigo(4);
    }
    
    private int getSeccionCodigo() throws IOException{
        return getCodigo(8);
    }

    private int getCodigo(int offset)throws IOException {
        try (RandomAccessFile rCods = new RandomAccessFile(DIR_ROOT+"/codigos.col", "rw")) {
            rCods.seek(offset);
            int codigo = rCods.readInt();
            rCods.seek(offset);
            rCods.writeInt(codigo+1);
            return codigo;
        }
    }
    
    /**
     * Agrega un nuevo maestro al archivo de maestros
     * @param n Nombre del maestro
     * @param fecha Fecha de nacimiento
     * @throws IOException Si hay algun error con los archivos
     */
    public void addMaestro(String n, Date fecha)throws IOException{
        rMaistros.seek(rMaistros.length());
        //codigo
        rMaistros.writeInt(getMaestroCodigo());
        //nombre
        rMaistros.writeUTF(n);
        //fecha nac
        rMaistros.writeLong(fecha.getTime());
        //contador de clases
        rMaistros.writeInt(0);
        //disponible
        rMaistros.writeBoolean(true);
    }
    
    /**
     * Agrega un nuevo alumno al archivo
     * @param n Nombre del alumno
     * @param fecha Fecha de nacimiento
     * @param car carrera que estudia
     * @throws IOException Si hay algun error con los archivos
     */
    public void addAlumno(String n, Date fecha, Carrera car)throws IOException{
        rAlumns.seek(rAlumns.length());
        //codigo
        int numero = getAlumnoCodigo();
        rAlumns.writeInt(numero);
        //nombre
        rAlumns.writeUTF(n);
        //fecha
        rAlumns.writeLong(fecha.getTime());
        //promedio
        rAlumns.writeDouble(0);
        //carrera
        rAlumns.writeUTF(car.name());
        //estado
        rAlumns.writeChar('A');
        //crear folder de alumno dentro de dir root
        new File(DIR_ROOT+"/alumnos/"+numero).mkdirs();
    }
    
    /**
     * Listar los maestros disponibles
     * @throws IOException Si hay algun error con los archivos
     */
    public void listarMaestrosDisponibles()throws IOException{
        rMaistros.seek(0);
        
        while(rMaistros.getFilePointer() < rMaistros.length()){
            int cod = rMaistros.readInt();
            String n = rMaistros.readUTF();
            //rMaistros.skipBytes(8);
            Date d = new Date(rMaistros.readLong());
            int cont = rMaistros.readInt();
            
            if(rMaistros.readBoolean()){
                System.out.printf("%d - %s - ha dado %d clases ",
                        cod,n,cont);
                System.out.println("nacido en: " + d);
            }
        }
    }
    
    /**
     * Busca un maestro dentro del archivo 
     * @param nm Numero del Maestro
     * @return <code>true</code> si lo encontro o no
     * @throws IOException Si falla el archivo
     */
    public boolean searchMaestro(int nm)throws IOException{
        rMaistros.seek(0);
        while(rMaistros.getFilePointer() < rMaistros.length()){
            if(rMaistros.readInt() == nm){
                return true;
            }
            rMaistros.readUTF();
            rMaistros.skipBytes(13);
        }
        return false;
    }
    
    /**
     * Busca si un maestro esta disponible
     * @param nm Numero de Maestro
     * @return Si esta disponible o no
     * @throws IOException 
     */
    private boolean isMaestroDisponible(int nm)throws IOException{
        if(searchMaestro(nm)){
            rMaistros.readUTF();
            rMaistros.skipBytes(12);
            return rMaistros.readBoolean();
        }
        return false;
    }
    
    /**
     * Lista todos los alumnos segun el estado
     * @param estado 'A' todos los activos
     *              'R' todos los retirados
     *              'G' todos los graduados
     *              'T' TODOS sin importar su estado
     * @throws IOException 
     */
    public void listarAlumnos(char estado)throws IOException{
        rAlumns.seek(0);
        while(rAlumns.getFilePointer() < rAlumns.length()){
            int cod = rAlumns.readInt();
            String no = rAlumns.readUTF();
            Date fecha = new Date(rAlumns.readLong());
            double prom = rAlumns.readDouble();
            String carr = rAlumns.readUTF();
            char state = rAlumns.readChar();
            
            if(estado == 'T' || estado == state){
                System.out.printf("%d - %n - nacido en %s - matriculado en %s - promedio: %.1f%n",
                        cod,no,fecha.toString(),carr,prom);
            }
        }
    }
    
    /**
     * Busca un alumno en el archivo
     * @param na Numero de Alumnos
     * @return Si existe o no
     * @throws IOException 
     */
    public boolean searchAlumno(int na)throws IOException{
        rAlumns.seek(0);
        
        while(rAlumns.getFilePointer() < rAlumns.length()){
            if( rAlumns.readInt() == na )
                return true;
            
            rAlumns.readUTF();
            rAlumns.skipBytes(16);
            rAlumns.readUTF();
            rAlumns.readChar();
        }
               
        return false;
    }
    
    private String seccionFilename(int ns){
        return DIR_ROOT+"/secciones/numero"+ns+".col";
    }
    
    /**
     * Crea una nueva seccion
     * @param nom Nombre de Seccion
     * @param nm Numero de Maestro
     * @throws IOException 
     */
    public void crearSeccion(String nom, int nm)throws IOException{
        /*
        Resticciones:
            - Que el maestro este disponible
            - mostrar en pantalla el nombre del maestro
                si esta disponibles
        */
        int ns = getSeccionCodigo();
        
        if(isMaestroDisponible(nm)){
            RandomAccessFile rsecc = new RandomAccessFile(seccionFilename(ns), "rw");
            //año
            rsecc.writeInt(Calendar.getInstance().get(Calendar.YEAR));
            //nombre
            rsecc.writeUTF(nom);
            //numero de maestro
            rsecc.writeInt(nm);
            //cantidad de alumnos
            rsecc.writeInt(0);
            
            rsecc.close();
        }
        else
            System.out.println("Maestro NO existe o NO esta disponible");
    }
    
    /**
     * Averigua si una seccion existe
     * @param ns Numero de Seccion
     * @return Si existe o no
     */
    private boolean existeSeccion(int ns) {
        File f = new File(seccionFilename(ns));
        return f.exists();
    }
    
    /**
     * Inscribe a un alumno a una seccion
     * @param ns Numero de Seccion
     * @param na Numero de Alumno
     * @return Si se pudo inscribir o no
     * @throws java.io.IOException
     */
    public boolean inscribirAlumnoEnSeccion(int ns,int na)throws IOException{
        /**
         * Restricciones:
         *   - Que el alumno exista
         *   - Que la seccion exista
         */
        if(searchAlumno(na) && existeSeccion(ns)){
            RandomAccessFile rsecc = new RandomAccessFile(seccionFilename(ns), "rw");
            rsecc.readInt();
            rsecc.readUTF();
            rsecc.readInt();
            int cals = rsecc.readInt();
            rsecc.seek(rsecc.getFilePointer()-4);
            //actualizo la cant de alumnos+1
            rsecc.writeInt(cals+1);
            //me voy al final para agregar al alumnos
            rsecc.seek(rsecc.length());
            //numero alumno
            rsecc.writeInt(na);
            //nota
            rsecc.writeDouble(0);
            //estado
            rsecc.writeChar('P');
            rsecc.close();
            return true;
        }
        return false;
    }
    
    
}

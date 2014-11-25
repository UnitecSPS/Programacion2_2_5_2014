/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.college;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
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

>>> numero/historial.col
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
int numero
int cantidad-alumnos
*
int normal
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
            new File(DIR_ROOT).mkdir();
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
        rAlumns.writeInt(getAlumnoCodigo());
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
    
}

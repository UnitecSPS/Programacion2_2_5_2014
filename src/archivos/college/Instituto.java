/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.college;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

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
int contador
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

    private void initCodesFile() {
    }
}

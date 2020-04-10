package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.t_archivos_directorios_class_File;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Greacion_escritura_eliminacion {
    public static void main(String[] args) {
        //Creacion_escritura_eliminacion
        //Ya vimos como acceder a un directorio, listar los ficheros que hay en su interior
        //Veremos como crear nuevos directorios, ficheros, como escribir en esos ficheros
        //incluir archivos en esos directorios y tambien como eliminar esos archivos y esos directorios

        //**************************************************************************************************************
        //DEPENDIENDO DEL SISTEMA OPERATIVO
        //**************************************************************************************************************
        /*
        la barra separadora es d ena forma u otra /
        puede ser tb invertida \
        con una barra invertida \ talvez funcione en windows pero no en linux u otros
         File aver = new File("C:/Users/Jorge/Desktop/Test");

        QUE HACER?

        Fields
        ------
        Modifier and Type	Field and Description
        -----------------------------------------
        static String	                          pathSeparator
                                                  The system-dependent path-separator character, represented as a
                                                  string for convenience.

        static char	                              pathSeparatorChar
                                                  The system-dependent path-separator character.

        static String	                          separator
                                                  The system-dependent default name-separator character, represented
                                                  as a string for convenience.

        static char	                              separatorChar
                                                  The system-dependent default name-separator character.
        ----------------------------------------------------------------------------------------------------------------
        Pues en vez de utilizar / la barra de turno valida para nuestro sistema operativo, lo que debemos hacer es
        recurrir a un Field (campo) de la clase File el 3ero

        separator
        public static final String separator
                         The system-dependent default name-separator character, represented as a string for convenience.
                         This string contains a single character, namely separatorChar.
         ----------------------------------------------------------------------------------------------------------------
         Con esto aseguramos la compatibilidad en cualquier sistema operativo.

         Lo que tenemos que hacer es ir concatenando este campo de clase File.separator con el resto de la ruta

         File aver = new File("C:/Users/Jorge/Desktop/Test");
        */

        //**************************************************************************************************************
        //                                   CREAR CARPETA
        //**************************************************************************************************************
        File prueba = new File("C:" + File.separator + "Users" + File.separator + "Jorge" +
                File.separator + "Desktop" + File.separator + "Test" + File.separator + "nuevoDirectorio");

        prueba.mkdir();//se crea o System.out.println(prueba.mkdir()); pa que nos de true
        //nuevodirectorio sera la nueva carpeta
        //**************************************************************************************************************
        //                                  CREAR Archivo
        //**************************************************************************************************************
        File prueba2 = new File("C:" + File.separator + "Users" + File.separator + "Jorge" +
                File.separator + "Desktop" + File.separator + "Test" + File.separator + "prueba.txt");

        //se screara un archivo en funcion de la extension   .txt  etc
        /*
        boolean	                                  createNewFile()
                                                  Atomically creates a new, empty file named by this abstract pathname
                                                  if and only if a file with this name does not yet exist.

        public boolean createNewFile()
                      throws IOException
        */
        try {
            prueba2.createNewFile();//lo crea solo si no existe
        } catch (IOException e) {
            e.printStackTrace();
        }
        //**************************************************************************************************************
        //                                  Escribimos en el interior del archivo
        //**************************************************************************************************************
        String archivoDestino = prueba2.getAbsolutePath();//almacenamos la ruta en un string

        EscribirFichero escribe = new EscribirFichero();
        escribe.escribir(archivoDestino);//el argumento seria la ruta donde esta el archivo un File

        //**************************************************************************************************************
        //                                  Borrar archivo o directorio que acabamos de llenar
        //**************************************************************************************************************
        //BUEN APORTE
        String s = File.separator;
        String prueba3 = prueba2.getAbsolutePath();//ou  "C:/Users/Jorge/Desktop/Test/prueba.txt"
        prueba3.replace("/", s);//replace  (Char oldChar, Char newChar)   metodo de la clase String

        File fCarpeta = new File(prueba3);
        fCarpeta.delete();

        // File prueba3 = new File("C:" + s+ "Users" + s + "Jorge" +
        //         s + "Desktop" + s + "Test" + s + "prueba.txt");

        //EliminarFichero elimino = new EliminarFichero();
        //elimino.eliminar(prueba3);
        //Eliminamos el finchero puesto en parametro , el File
        //o simplement si pasar por esta clase  prueba3.delete();

    }
}


//**********************************************************************************************************************
//                              Clase afuera de mi clase principal
//**********************************************************************************************************************
class EscribirFichero {
    public void escribir(String destino) {
        String frase = JOptionPane.showInputDialog("Inserte un mensaje de prueba");
        try {
            FileWriter salida = new FileWriter(destino);
            salida.write(frase);
            salida.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo ");
        }
    }
}

class EliminarFichero {//clase

    public void eliminar(File f) {//metodo para borrar el archivo definido en parametro
        f.delete();
    }
}
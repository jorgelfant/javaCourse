package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_I_Reader_Writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoFichero {
    public static void main(String[] args) {
        EscribirFichero escribiendo = new EscribirFichero();
        escribiendo.escribir();

        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();
        //imprime los int de cada int que represente cada caracter y al llegar al ultimo imprime 86
        //..etc
        //65
        //-1

        //esta informacion no nos sirve ya que no se puede leer el contenido, solo tenemos los enteros de cada caracter
        //debemos tranformar estos codigos enteros a su correspondientes caracteres UNICODE  con un CASTING (char)
        System.out.println();

        //**************************************************************************************************************
        //              Desde java 7 tenemos una mejor forma de abrir y cerrar stream, ahorrándonos trabajo.
        //**************************************************************************************************************

        try (FileWriter fw = new FileWriter("C:/Users/Jorge/Desktop/StreamDeOtraForma.txt");
             FileReader fr = new FileReader("C:/Users/Jorge/Desktop/StreamDeOtraForma.txt")) {
            //Escribimos en el fichero un String y un caracter 97 (a)
            fw.write("Esto es una prueba");
            //Guardamos los cambios del fichero
            fw.flush();
            //Leemos el fichero y lo mostramos por pantalla
            int valor = fr.read();
            do {
                System.out.print((char) valor);
                valor = fr.read();
            } while (valor != -1);
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
        /*
        Como vemos, en el try creamos los objetos que queremos manejar, separados con un ; por objeto, con esta forma los
        streams se cierran automáticamente.

        Por último, si queremos añadir mas texto a un fichero de texto que ya tenga contenido, al construir el objeto
        de la clase FileWriter añadimos como segundo parámetro un true. Si no lo hacemos, sobrescribiremos el fichero
        entero al escribir algo nuevo.﻿
        */
    }
}

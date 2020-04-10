package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_I_Reader_Writer;

import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {
    public void escribir() {
        //ponemos la frase que queremos escribir en el archivo externo
        String frase = "Hola esta es una prueba de escritura en un archivo externo";
        try {//si le doy un nombre de fichero existente escribira en el, si le doy un nombre de fichero que no existe
            //este lo creara y escribira en el   (SOBRECARGA CONSTRUCTORES), en este caso crearemos uno nuevo
            //en el caso del constructor con parametros, (, ) hay uno con 2 parametros el segundo es un boolean
            //true o false, si el fichiero existe escribira la frase sin borrar el contenido del fichier
            //sin es false creara uno nuevo y escribira la frase, si es false
            FileWriter salida = new FileWriter("C:/Users/Jorge/Desktop/NuevoEjemploStream.txt", true);
            for (int i = 0; i < frase.length(); i++) {//para escribir un archivo no es necesario un for, se puede hacer
                salida.write(frase.charAt(i));        //de frente con salida.write("fdgdfg");
            }
            salida.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo ");
        }
    }
}
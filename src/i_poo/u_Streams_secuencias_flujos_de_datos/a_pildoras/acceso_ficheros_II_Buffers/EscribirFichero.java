package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_II_Buffers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichero {

    public void escribir() {
        try {//FileReader entrada = new FileReader("C:/Users/Jorge/Desktop/ejemploStream.txt"); y poner luego (entrada) o
            BufferedWriter entrada = new BufferedWriter(new FileWriter("C:/Users/Jorge/Desktop/ejemploBufferedWriteraaa.txt"));
            entrada.write("Estamos estudiando Streams de Java\n" +
                    "en este caso estamos viendo ya no \n" +
                    "los FileReader que son eficaces en\n" +
                    "archivos de frases cortas, sino el\n" +
                    "BufferedReader que sirve para ser\n" +
                    "mas eficace al momento de leer archivos\n" +
                    "que contienen gran cantidad de informaciion.\n" +
                    "Esto es posible gracias a la creacion de una\n" +
                    "memoria intermedia llamado Buffer que almacena\n" +
                    "la informacion que va recibiendo del servidor.\n" +
                    "y asi puedo acceder a ella y ya no directamente\n" +
                    "al servidor.");
            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo ");
        }

    }
}

package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_II_Buffers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    public void lee() {
        try {//FileReader entrada = new FileReader("C:/Users/Jorge/Desktop/ejemploStream.txt"); y poner luego (entrada) o
            BufferedReader entrada = new BufferedReader(new FileReader("C:/Users/Jorge/Desktop/ejemploBufferedReader.txt"));
            String linea = entrada.readLine();//asi podemos leer directamente un String y ya no caracter por caracter
            do {//hacemos esto para que no imprima al final el null que envia el metodo cuando ya ha acabado
                System.out.println(linea);
                linea = entrada.readLine();
            } while (linea != null);
            entrada.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo ");
        }

    }
}

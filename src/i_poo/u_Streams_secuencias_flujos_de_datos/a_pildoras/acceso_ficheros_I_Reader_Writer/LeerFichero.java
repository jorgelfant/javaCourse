package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_I_Reader_Writer;

import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {
    //esta clase va permitirnos acceder a nuestro fichero
    //Vamos a la API de JAVA a ver el ECOSISTEMA DE HERENCIA que parte de la clase Reader
    /*
    java.io    (paquete java.io)
    Class Reader

    java.lang.Object
           java.io.Reader

    All Implemented Interfaces:
    --------------------------
    Closeable, AutoCloseable, Readable

    Direct Known Subclasses:
    -----------------------
    BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader


    public abstract class Reader
    extends Object
    implements Readable, Closeable


    InputStreamReader es una subClass de Reader que es importante para lo que queremos hacer
       esto traduce los bytes correspondientes a un caracter a su correspondiente codigo

    An InputStreamReader is a bridge from byte streams to character streams: It reads bytes and decodes them
    into characters using a specified charset. The charset that it uses may be specified by name or may be given
    explicitly, or the platform's default charset may be accepted.

    Each invocation of one of an InputStreamReader's read() methods may cause one or more bytes to be read from
    the underlying byte-input stream. To enable the efficient conversion of bytes to characters, more bytes may
    be read ahead from the underlying stream than are necessary to satisfy the current read operation.

    For top efficiency, consider wrapping an InputStreamReader within a BufferedReader. For example:

     BufferedReader in
         = new BufferedReader(new InputStreamReader(System.in));


    Class InputStreamReader

    java.lang.Object
          java.io.Reader
                java.io.InputStreamReader

    All Implemented Interfaces:
    --------------------------
    Closeable, AutoCloseable, Readable

    Direct Known Subclasses:
    -----------------------
    FileReader


    public class InputStreamReader
    extends Reader



    la subClass FileReader es la que vamos a usar en principio para decirle a nuestro programa JAVA donde se encuentra
    nuestro archivo

    Convenience class for reading character files. The constructors of this class assume that the default character
    encoding and the default byte-buffer size are appropriate. To specify these values yourself, construct an
    InputStreamReader on a FileInputStream.

    FileReader is meant for reading streams of characters. For reading streams of raw bytes, consider using a FileInputStream.


    Constructors
    ------------
    Constructor and Description
    ---------------------------
      FileReader(File file)
         Creates a new FileReader, given the File to read from.
      FileReader(FileDescriptor fd)
         Creates a new FileReader, given the FileDescriptor to read from.
      FileReader(String fileName)
         Creates a new FileReader, given the name of the file to read from.


     Usaremos el primer constructor que lanza una excepcion

     public FileReader(File file)
           throws FileNotFoundException


           Parameters:
           file - the File to read from
           Throws:
           FileNotFoundException - if the file does not exist, is a directory rather than a regular file,
           or for some other reason cannot be opened for reading.

           esta exception hereda de IOException lo que quiere decir que estamos obligados a capturar esa exception
    */

    //FileReader entrada;
    //CREAMOS UN METODO
    public void lee() {
        try {
            FileReader entrada = new FileReader("C:/Users/Jorge/Desktop/ejemploStream.txt");//entre parentesis indicamos la ruta
            int c = entrada.read();
            do {//do while pa no tener que iniciar c antes  c=0;
                char letra = (char) c;
                System.out.print(letra);//esto dara los codigos int de cada caracter del texto que tenemos dentro del fichier
                c = entrada.read();
                //hacemos un casting justo despues de haber almacenado en la variable el int del caracter
            } while (c != -1);
            entrada.close();
        } catch (IOException e) {//ponemos IOException pa captura la except que podira lanzar Filereader o read()
            //e.printStackTrace();//imprime estado de la fila   pero mejor le diremos que imprila otra cosa
            System.out.println("No se ha encontrado el archivo ");
        } /*finally {//no necesario en este caso , seria necesario si entrada estuviera fuera del try
        }   pero no es posible ya que la creacion de un objeto FileReader me obliga a implementar una exception
            aunque si podriamos si declaramos FileReader entrada; afuera del metodo y luego ya en el try lo inicializamos
            en el finally deberiamois tb tratar la exception que generaria entrada.close()     bueno es mas complicado
            y en este caso innecesario */

        //lo siguiente seria leer el fichero que va a almacenarse en el objeto entrada. eso lo hacemos utilizando
        //un metodo read()  que es un metodo d ela clase FileReader  heredado de InputStreamReader
        //hay varios read() unos heredados del papa  InputStreamReader y otros de la interface abuelo Reader

        /*El que nos interesa y que hereda de InputStreamReader
             public int read()
                      throws IOException

             Reads a single character.
             Overrides:
                    read in class Reader
             Returns:
                    The character read, or -1 if the end of the stream has been reached
             Throws:
                    IOException - If an I/O error occurs

        * */

    }
}

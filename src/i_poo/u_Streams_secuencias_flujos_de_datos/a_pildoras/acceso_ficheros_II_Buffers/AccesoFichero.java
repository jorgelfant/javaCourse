package i_poo.u_Streams_secuencias_flujos_de_datos.a_pildoras.acceso_ficheros_II_Buffers;

public class AccesoFichero {
    public static void main(String[] args) {
        //Buffers que es esto y porque son necesarios ?
        //Lo que hicimos antes con FileReader y FileWriter era comunicarnos con un archivo de texto pequenio
        //es decir que tenia una unica frase, pocos caracteres

        //si el archivo es pequeno pues la tecnica utilizada puede ser la que vimos en el ejemplo anterior
        //El problema surge cuando ese archivo externo suele tener muchas frases.
        //miles y miles de caracteres, en ese caso el sistema visto en el ejemplo anterior se vuelve poco
        //eficiente, el leia caracter a caracter y traducia los int recibidos en char

        //Es decir que por un solo caracter contactamos el archivo regresamos al codigo, contactamos el archivo pal
        //segundo caracter, volvemos al programa etc y asi sucesivamente. osea es una operacion que deberia repetirse
        //millones de veces , es poco eficiente, consume muhcos recursos y es lentto


        /*
          ---------------                                                   ---------------
         |             |                   STREAM                          |  fghfghfg    |
         |             | ------------------------------------------------  |  gfhgfhfg    |
         |    CODIGO   | ------------------------------------------------  |  trytryrt    |
         |             |                  PA escribir o leer               |  gfhgfhgfh   |
         |             |                  informacion en un archivo        |              |
         --------------                   de texto                         ----------------

          SOLUTION:
          ********

          CREAR un Buffer

          Un Buffer es como una especie de memoria interna que se coloca fisicamente entre
          nuestro programa de java y un archivo externo al que queremos acceder

          Por ejemplo en internet hemos visto peliculas en Streaming, video que a la par que lo
          vas viendo, se va descargando y seguramente al ver videos de este tipo la reproduccion
          se ha visto interrumpida, y cuando esto ocurria es muy probable que hayamos visto el
          mensaje de "Buffering" que significa que para que podamos ve el video mientras se va descargando
          la informacion a la que accedes realmente no esta en el servidor del que viene el archivo
          sino que se encuentra en una memoria intermedia denominada Buffer.en nuestro caso es lo mismo.

          Su objetivo es que en vez de acceder directamente al archivo desde nuestro codigo Java,*
          accedamos a esta memoria intermedia, de tal forma que lo que ocurre cuando creamos un Buffer
          la informacion contenida en el archivo externo de texto, se vuelca enteramente al buffer,
          se almacena en ese Buffer. Y una vez que la informacion del archivo integramente esta en el
          Buffer, es nuestro programa Java que accede a ese Buffer para ir descargando poco a poco esa informacion!

          con esto se gana en rapidez, se gana en eficiencia, y en el caso de que hubiera algun problema
          con la comunicacion, con el Stream del archivo externo, no se veria interrumpida esa COMUNICACION.

          El Buffer lo podemos usar tanto para leer informacion de un archivo externo como para escribir
          informacion en un archivo externo. Da igual la direccion INPUT o OUTPUT .

         ---------------                                                    ---------------
         |             |                                                   |  fghfghfg    |
         |             | ------------------Buffer ----------------------   |  gfhgfhfg    |
         |    CODIGO   | ------------------       ----------------------   |  trytryrt    |
         |             |                                                   |  gfhgfhgfh   |
         |             |                                                   |              |
         --------------                                                    ----------------
------------------------------------------------------------------------------------------------------------------------
         Class Reader
         java.lang.Object
               java.io.Reader

         All Implemented Interfaces:
            Closeable, AutoCloseable, Readable
         Direct Known Subclasses:
             BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader

        Reads text from a character-input stream, buffering characters so as to provide for the efficient reading
        of characters, arrays, and lines.

        The buffer size may be specified, or the default size may be used. The default is large enough for most purposes.

        In general, each read request made of a Reader causes a corresponding read request to be made of the underlying
        character or byte stream. It is therefore advisable to wrap a BufferedReader around any Reader whose read()
        operations may be costly, such as FileReaders and InputStreamReaders. For example,

         BufferedReader in
             = new BufferedReader(new FileReader("foo.in"));

         Constructores: 2

         BufferedReader(Reader in)
             Creates a buffering character-input stream that uses a default-sized input buffer.
         BufferedReader(Reader in, int sz)
             Creates a buffering character-input stream that uses an input buffer of the specified size.



         Tenemos varios metodos entre ellos

         int	read()
            Reads a single character.

         String	readLine()
            Reads a line of text.


         public String readLine()
                throws IOException   este metodo lanza una exception

         Reads a line of text. A line is considered to be terminated by any one of a line feed ('\n'), a carriage
         return ('\r'), or a carriage return followed immediately by a linefeed.

         Returns:
             A String containing the contents of the line, not including any line-termination characters,
             or null if the end of the stream has been reached

         Throws:
             IOException - If an I/O error occurs


------------------------------------------------------------------------------------------------------------------------

         Para utilizar un Buffer debemos usar la clase BufferedReader que es una subclase de Reader
         en el caso de que querramos crear un buffer para leer informacion, BuffferdReader,
         Para escribir informacion BufferedWriter  de la clase Abstracta Writer
                                                        C
                                       ******************
                                       * BufferedReader *
                                       ******************
                                               |
                                               |        M
                                       ******************
                                       *   readLine()   *
                                       ******************

         Ademas de ganar en eficiencia esta clase BufferReader tiene metodos que nos pueden resultar interesantes
         como por ejemplo readLine() que es un metodo que lee linea a linea el texto que hay en un archivo, de tal
         forma de que devuelve una LINEA ENTERA, y no caracter a caracter.

         BufferedWriter tiene tb un metodo writLine() para hacer excatamente la misma operacion pero de escritura

        */
        LeerFichero lectura = new LeerFichero();
        lectura.lee();

        //Al Buffer tambien se le denomina en muchas ocasiones "FILTRO"
        EscribirFichero Escritura = new EscribirFichero();
        Escritura.escribir();

    }
}

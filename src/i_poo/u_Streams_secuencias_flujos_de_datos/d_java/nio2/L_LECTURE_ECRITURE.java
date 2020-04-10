package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

public class L_LECTURE_ECRITURE {
  public static void main(String[] args) {
    /*
      La lecture et l'écriture dans un fichier se font toujours de la même façon avec NIO2 mais l'API
      propose des méthodes utilitaires pour faciliter le travail.

      La gestion des opérations de types entrées/sorties a évolué au fur et à mesure des versions de Java.

      IO                                   NIO                                 NIO2
      --------------------------------------------------------------------------------------------------
      Java 1.0 et 1.1                      Java 1.4 (JSR 151)                  Java 7 (JSR 203)
      --------------------------------------------------------------------------------------------------
      Synchrone bloquant                   Synchrone non bloquant              Asynchrone non bloquant
      --------------------------------------------------------------------------------------------------
       File

       InputStream                         FileChannel                         Path

       OutputStream                        SocketChannel                       AsynchronousFileChannel

       Reader (Java 1.1)                   ServerSocketChannel                 AsynchronousByteChannel

       Writer (Java 1.1)                   (Charset, Selector,ByteBuffer)      AsynchronousSocketChannel

       Socket                                                                  AsynchronousServerSocketChannel

       RandomAccessFile                                                        SeekableByteChannel

       //****************************************************************************************************************

       La classe Files propose plusieurs méthodes pour faciliter la lecture ou l'écriture de fichiers
       et de flux selon les besoins allant des plus simples aux plus complexes.


                readAllBytes()        new BufferedReader()       new InputStream()
                readAllLines()        new BufferedWriter()       new OutputStream()      new ByteChannel()
 Besoins <------------------------------------------------------------------------------------------------------>Besoins
 Simples        Lecture de l'         Fichier texte              Flux sans buffer        Channel et ByteBuffer   avancés
                intégralité du
                fichier


      //****************************************************************************************************************
      //                               readAllBytes() et readAllLines()
      //****************************************************************************************************************

      Les méthodes readAllBytes() et readAllLines() permettent de lire l'intégralité du contenu d'un fichier
      respectivement d'octets et texte. Deux surcharges de la méthode write() permettent d'écrire l'intégralité
      d'un fichier. Ces méthodes sont à réserver pour de petits fichiers.

      Metodos de la class Files de java.A_nio.file
      ------------------------------------------

      static byte[]	                                      readAllBytes(Path path)
                                                             Reads all the bytes from a file.

      static List<String>	                                readAllLines(Path path, Charset cs)
                                                             Read all lines from a file.

      static Path	                                        write(Path path, byte[] bytes, OpenOption... options)
                                                             Writes bytes to a file.

      static Path	                                        write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options)
                                                             Write lines of text to a file.
      //****************************************************************************************************************
      //                               newBufferedReader() et newBufferedWriter()
      //****************************************************************************************************************

      Les méthodes newBufferedReader() et newBufferedWriter() sont des helpers pour faciliter la création d'objets
      de types BufferedReader et BufferedWriter permettant la lecture et l'écriture de fichiers de type texte en
      utilisant un tampon.

      static BufferedReader	                              newBufferedReader(Path path, Charset cs)
                                                             Opens a file for reading, returning a BufferedReader
                                                             that may be used to read text from the file in an efficient manner.

      static BufferedWriter	                              newBufferedWriter(Path path, Charset cs, OpenOption... options)
                                                             Opens or creates a file for writing, returning
                                                             a BufferedWriter that may be used to write text to
                                                             the file in an efficient manner.

      //****************************************************************************************************************
      //                               newInputStream() et newOutputStream()
      //****************************************************************************************************************

      Les méthodes newInputStream() et newOutputStream() sont des helpers pour faciliter la création d'objets
      permettant la lecture et l'écriture de fichiers d'octets.

      static InputStream	                                newInputStream(Path path, OpenOption... options)
                                                             Opens a file, returning an input stream to read from the file.

      static OutputStream                               	newOutputStream(Path path, OpenOption... options)
                                                             Opens or creates a file, returning an output stream that
                                                             may be used to write bytes to the file.

      //****************************************************************************************************************
      //                                       new ByteChannel()
      //****************************************************************************************************************

      Ces quatre méthodes sont des helpers pour créer des objets du package java.io.

      La méthode newByteChannel() est un helper pour créer un objet de type SeekableByteChannel.

      static SeekableByteChannel	                         newByteChannel(Path path, OpenOption... options)
                                                              Opens or creates a file, returning a seekable byte channel
                                                              to access the file.

      static SeekableByteChannel	                         newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs)
                                                              Opens or creates a file, returning a
                                                              seekable byte channel to access the file.

      La classe FileChannel propose des fonctionnalités avancées sur l'utilisation d'un fichier
      (verrous, mapping direct à une zone de la mémoire, ...) : cette classe a été enrichie pour
      fonctionner avec NIO2.
    */

  }
}

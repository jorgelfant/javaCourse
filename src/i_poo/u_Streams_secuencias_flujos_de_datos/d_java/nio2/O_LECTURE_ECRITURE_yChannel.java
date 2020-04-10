package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class O_LECTURE_ECRITURE_yChannel {
  public static void main(String[] args) throws IOException {
    /*L'API Java NIO propose de réaliser des opérations d'entrées/sorties utilisant des channels et
    des tampons (ByteBuffer) ce qui améliore les performances par rapport à l'API Java IO.

    Par défaut les flux de java.io lisent ou écrivent uniquement un octet ou un caractère à la fois.

    Les opérations de lectures/écritures de java.nio utilisent un tampon (ByteBuffer). L'interface ByteChannel
    propose des fonctionnalités de base pour de telles lectures ou écritures.

    La méthode newByteChannel() de la classe Files renvoie une instance d'un channel NIO de type SeekableByteChannel.
    Elle possède deux surcharges:

        .SeekableByteChannel newByteChannel(Path path, OpenOption... options)
        .SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs)

    Ces deux surcharges permettent d'ouvrir ou de créer un fichier et de lui associer un channel en fonction des
    paramètres d'ouverture de type OpenOption fournis. Par défaut le channel est ouvert en lecture (option READ).

    La méthode newByteChannel() est un helper pour créer un objet de type SeekableByteChannel.

      static SeekableByteChannel	                         newByteChannel(Path path, OpenOption... options)
                                                              Opens or creates a file, returning a seekable byte channel
                                                              to access the file.

      static SeekableByteChannel	                         newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs)
                                                              Opens or creates a file, returning a
                                                              seekable byte channel to access the file.

      La classe FileChannel propose des fonctionnalités avancées sur l'utilisation d'un fichier
      (verrous, mapping direct à une zone de la mémoire, ...) : cette classe a été enrichie pour
      fonctionner avec NIO2.*/

/*
                      final Path path = Paths.get("C:/Users/Jorge/Desktop/test2/nuevoTexto.txt");
                      Files.deleteIfExists(path);


                      try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE, StandardOpenOption.SYNC)) {

                  // ...
                      } catch (IOException e) {
                        e.printStackTrace();
                      }
*/
    /*L'interface java.nio.channels.SeekableByteChannel ajoute à l'interface ByteChannel la possibilité de gérer une
    position dans le channel, de vider un channel et d'obtenir la taille du fichier associé au channel.
    Cela permet de se déplacer dans le channel pour réaliser une opération de lecture ou d'écriture sans avoir
    à parcourir les données jusqu'à la position désirée. Un SeekableByteChannel est donc un channel qui possède des
    fonctionnalités similaires à celles proposées par la classe java.io.RandomAccessFile.

    L'interface SeekableByteChannel hérite des interfaces : AutoCloseable, ByteChannel, Channel, Closeable, ReadableByteChannel et WritableByteChannel.

    Elle propose plusieurs méthodes pour permettre de se déplacer dans le fichier avant de réaliser une opération de lecture ou d'écriture.

    <<public interface SeekableByteChannel extends ByteChannel>>

    ********************************************************************************************************************

    Méthode                                                      Rôle
    --------------------------------------------------------------------------------------------------------------------
    long                                                       position()
                                                                 Retourner la position courante dans le channel
    --------------------------------------------------------------------------------------------------------------------
    SeekableByteChannel                                        position(long newPosition)
                                                                 Changer la position dans le channel
    --------------------------------------------------------------------------------------------------------------------
    int                                                        read(ByteBuffer dst)
                                                                 Lire un ensemble d'octets du channel dans le tampon
                                                                 fourni en paramètre. Retourne le nombre d'octets lus
                                                                 ou -1 si la fin du channel est atteinte
    --------------------------------------------------------------------------------------------------------------------
    long                                                       size()
                                                                 Retourner la taille en octets du flux auquel le
                                                                 channel est connecté
    --------------------------------------------------------------------------------------------------------------------
    SeekableByteChannel                                        truncate(long size)
                                                                 Tronquer le contenu de l'élément sur lequel le
                                                                 channel est connecté à la taille fournie en paramètre.
                                                                 Cela permet de redimensionner la taille du flux associé
                                                                 au channel avec la valeur fournie en paramètre
    --------------------------------------------------------------------------------------------------------------------
    int                                                        write(ByteBuffer src)
                                                                 Ecrire les octets fournis en paramètre à la position
                                                                 courante dans le channel
    ********************************************************************************************************************

    La méthode read() tente une lecture pour remplir le nombre d'octets du tampon passé en paramètre.
    Elle renvoie -1 si la fin du flux est atteinte. La position courante dans le channel est augmentée
    de la taille des données lues.

    La méthode write() écrit les octets du tampon passé en paramètre à partir de la position courante dans le channel.
    Si le fichier est ouvert avec l'option APPEND, alors la position courante est située à la fin du fichier.
    Elle renvoie le nombre d'octets écrits. La position courante dans le channel est augmentée de la taille des
    données écrites.

    La surcharge de la méthode position() qui attend un paramètre de type long permet de déplacer la position courante
    dans le channel. Elle renvoie le channel lui-même pour permettre un chaînage des appels de cette méthode.
    La taille du flux connecté au channel n'est pas modifiée si la valeur fournie en paramètre est supérieure
    à sa taille totale. L'utilisation de cette méthode n'est pas recommandée avec un channel ouvert avec
    l'option APPEND.

    La méthode truncate() permet de réduire la taille totale du flux connecté au channel. Si la taille fournie en
    paramètre est inférieure à la taille totale courante, alors les octets entre la taille fournie et la taille
    totale sont perdus. Si la taille fournie est supérieure ou égale à la taille du flux connecté au channel alors
    l'invocation de la méthode n'a aucun effet. Une implémentation de cette interface peut interdire l'utilisation
    de cette méthode si le channel est ouvert avec l'option APPEND.*/

    /*wrap = envolver   metodos estaticos de ByteBuffer

      static ByteBuffer	                         wrap(byte[] array)
                                                    Wraps a byte array into a buffer.

      static ByteBuffer	                         wrap(byte[] array, int offset, int length)
                                                    Wraps a byte array into a buffer.
      ------------------------------------------------------------------------------------------------------------------
                    Metodo de String
      byte[]	                                   getBytes()
                                                 Encodes this String into a sequence of bytes using the platform's
                                                 default charset, storing the result into a new byte array.*/
/*
    final ByteBuffer donneesBonjour = ByteBuffer.wrap("Bonjour".getBytes());//getBytes() me da los bytes del string en forma de byte[]
    final ByteBuffer donneesBonsoir = ByteBuffer.wrap("Bonsoir".getBytes());
*/




    final Path path = Paths.get("C:/Users/Jorge/Desktop/test2/dicoRivo.txt");

    final ByteBuffer donneesBonjour = ByteBuffer.wrap("Bonjour".getBytes());
    final ByteBuffer donneesBonsoir = ByteBuffer.wrap("Bonsoir".getBytes());
    Files.deleteIfExists(path);//borra el archivo si existe

    try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.SYNC)) {
      //desde donde comienza a leer en este caso desde la posicion 100, se sale tons no escribira nada
      fileChannel.write(donneesBonjour);//int	    write(ByteBuffer src)   Writes a sequence of bytes to this channel from the given buffer.

    }
      //          StandardOpenOption.WRITE, StandardOpenOption.APPEND  para escribir sin borrar el contenido del fichier
    try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE, StandardOpenOption.SYNC)) {//el archivo debe existir pa escribir
      //desde donde comienza a leer en este caso desde la posicion 200, se sale tons no escribira nada
      sbc.write(donneesBonsoir);
    }

    /*La méthode Files.newByteChannel() permet de créer une instance de type SeekableByteChannel. Si le fichier connecté
      au channel est sur le système de fichiers par défaut, il est possible de caster l'objet retourné en un objet de
      type FileChannel.

      public abstract class FileChannel extends AbstractInterruptibleChannel implements SeekableByteChannel, GatheringByteChannel, ScatteringByteChannel

      La classe abstraite FileChannel propose des fonctionnalités avancées à utiliser sur un channel connecté à un fichier :

         .des octets peuvent être lus ou écrits sans modifier la position courante dans le channel

         .une région du fichier peut être mappée directement en mémoire (cette fonctionnalité est intéressante pour
          manipuler de gros fichiers)

         .l'écriture de données peut être forcée pour être faite directement sur le système de stockage afin
          d'éviter une perte de données en cas de crash du système

         .une région du fichier peut être verrouillée pour empêcher l'accès par d'autres applications                     */
  }
}
/*
    ""public enum StandardOpenOption extends Enum<StandardOpenOption> implements OpenOption""

    L'énumération StandardOpenOption implémente l'interface OpenOption et définit les options d'ouverture
    standard d'un fichier :

    Enum constantes

    Valeur                                      Rôle
   -----------------------------------------------------------------------------
   APPEND                                       Si le fichier est ouvert en écriture alors les données sont ajoutées
                                                au fichier. Cette option doit être utilisée avec les options CREATE ou WRITE

   CREATE                                       Créer un nouveau fichier s'il n'existe pas sinon le fichier est ouvert

   CREATE_NEW                                   Créer un nouveau fichier : si le fichier existe déjà alors une exception
                                                est levée

   DELETE_ON_CLOSE                              Supprimer le fichier lorsque son flux associé est fermé : cette option
                                                est utile pour des fichiers temporaires

   DSYNC                                        Demander l'écriture synchronisée des données dans le système de
                                                stockage sous-jacent (pas d'utilisation des tampons du système)

   READ                                         Ouvrir le fichier en lecture

   SPARSE                                       Indiquer au système que le fichier est clairsemé ce qui peut lui
                                                permettre de réaliser certaines optimisations si l'option est supportée
                                                par le système de fichiers (c'est notamment le cas avec NTFS)

   SYNC                                         Demander l'écriture synchronisée des données et des métadonnées dans
                                                le système de stockage sous-jacent

   TRUNCATE_EXISTING                            Si le fichier existe et qu'il est ouvert en écriture alors il est vidé.
                                                Cette option doit être utilisée avec l'option WRITE

   WRITE                                        Ouvrir le fichier en écriture

   Ces options sont utilisables avec toutes les méthodes qui ouvrent des fichiers. Elles ne sont pas toutes
   mutuellement exclusives.
*/

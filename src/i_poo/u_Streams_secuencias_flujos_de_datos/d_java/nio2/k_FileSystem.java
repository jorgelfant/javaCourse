package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.nio.file.FileSystems;

public class k_FileSystem {
  public static void main(String[] args) {
  /* L'utilisation de systèmes de gestion de fichiers
    --------------------------------------------------
     Un système de gestion de fichiers est encapsulé par un objet de type FileSystem qui permet de créer
     des objets qui pourront interagir avec lui.

     Il faut utiliser la fabrique FileSystems pour obtenir une instance de type FileSystem.

     La classe FileSystems
     ----------------------
     La classe FileSystems est une fabrique pour obtenir des instances de type FileSystem.

     La méthode getDefault() renvoie une instance de type FileSystem qui encapsule le système de fichiers de la JVM.

     La méthode getFileSystem() renvoie une instance de type FileSystem qui encapsule le système de fichiers dont l'URI est fourni en paramètre.

     Plusieurs surcharges de la méthode newFileSystem() permettent de créer une instance spécifique de type FileSystem


     Methods
     Modifier and Type	                                 Method and Description
     static FileSystem	                                 getDefault()
                                                          Returns the default FileSystem.

     static FileSystem	                                 getFileSystem(URI uri)
                                                          Returns a reference to an existing FileSystem.

     static FileSystem	                                 newFileSystem(Path path, ClassLoader loader)
                                                          Constructs a new FileSystem to access the contents of a file as a file system.

     static FileSystem	                                 newFileSystem(URI uri, Map<String,?> env)
                                                           Constructs a new file system that is identified by a URI

     static FileSystem	                                 newFileSystem(URI uri, Map<String,?> env, ClassLoader loader)
                                                           Constructs a new file system that is identified by a URI
     *******************************************************************************************************************

     Class FileSystem
     ----------------
     java.lang.Object
          java.A_nio.file.FileSystem

     All Implemented Interfaces:
     Closeable, AutoCloseable

     public abstract class FileSystem extends Object implements Closeable

     Provides an interface to a file system and is the factory for objects to access files and other objects
     in the file system.

     The default file system, obtained by invoking the FileSystems.getDefault method, provides access to the file
     system that is accessible to the Java virtual machine. The FileSystems class defines methods to create file
     systems that provide access to other types of (custom) file systems.

     A file system is the factory for several types of objects:

     The getPath method converts a system dependent path string, returning a Path object that may be used to locate and access a file.

     The getPathMatcher method is used to create a PathMatcher that performs match operations on paths.

     The getFileStores method returns an iterator over the underlying file-stores.

     The getUserPrincipalLookupService method returns the UserPrincipalLookupService to lookup users or groups by name.

     The newWatchService method creates a WatchService that may be used to watch objects for changes and events.

     CONSTRUCTOR
     ----------
     protected	FileSystem()
     Initializes a new instance of this class.


     La classe FileSystem encapsule un système de fichiers. C'est essentiellement une fabrique d'instances d'objets
     dépendants du système encapsulé notamment : Path, PathMatcher, FileStores, WatchService, ...

     Pour obtenir une instance de la classe FileSystem qui encapsule le système de fichiers par défaut, il faut
     utiliser la méthode getDefault() de la classe FileSystems.

     Les systèmes de fichiers n'utilisent pas tous le même séparateur dans les chemins de leurs éléments : par exemple,
     Windows utilise le caractère antislash, les systèmes de type Unix utilisent le caractère slash, ...

     Pour connaître le séparateur utilisé par le système, il est possible d'invoquer la méthode getSeparator()
     de la classe FileSystem.

     *******************************************************************************************************************
  */
    System.out.println(FileSystems.getDefault());
    testGetSeparator();//obtenemos el separador
    //La méthode getRootDirectories() permet d'obtenir un objet de type Iterable<Path> qui permet d'obtenir
    //les éléments racine du système de fichiers par défaut.
    System.out.println(FileSystems.getDefault().getRootDirectories());

    /*La création d'une implémentation de FileSystem
      ----------------------------------------------
      La classe FileSystem est extensible.

      Il est par exemple possible de développer ses propres implémentations permettant d'offrir différentes vues
      d'un système de fichiers (cacher des fichiers sensibles, accès en lecture seule à tous les éléments du système, ...).

      Il faut créer une classe qui hérite de la classe FileSystemProvider et une classe qui hérite de la classe FileSystem.

       public class MonFileSystem extends FileSystem {
       // ...
       }

       La prise en compte du FileSystem se fait en utilisant le service Provider de la JVM. Il faut donc
       packager le Filesystem dans une archive de type jar contenant un sous-répertoire META-INF/services avec
       un fichier java.A_nio.file.spi.FileSystemProvider listant les noms pleinement qualifiés des sous-classes de
       type FileSystemProvider.

       L'implémentation d'un FileSystem n'a pas besoin d'être liée à un «vrai» système de fichiers.

    */



  }
  //********************************************************************************************************************
  //METODOS FUERA DEL MAIN
  //********************************************************************************************************************
  private static void testGetSeparator() {
    String separator = FileSystems.getDefault().getSeparator();//nos dice cual es el separador de nuestro sistema de explotacion
    System.out.println(separator);//nos da :    \

  }
}

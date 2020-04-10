package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class K_FileSystem_zip {
  public static void main(String[] args) {
    /*
    L'implémentation du JDK propose en standard une implémentation spéciale de la classe FileSystem pour faciliter
    la manipulation de fichiers compressés au format ZIP. Son utilisation rend la manipulation d'archives de type
    zip beaucoup plus aisée que l'utilisation des classes du package java.util.zip.

    Il faut utiliser la fabrique FileSystems pour créer une instance de type FileSystem en invoquant la méthode
    newFileSystem() et en lui passant en paramètre une instance de type Path qui encapsule le chemin de l'archive à manipuler.

    Il est alors possible d'utiliser cette instance de FileSystem pour obtenir des chemins contenus dans l'archive
    puisque l'archive est vue elle-même comme un système de fichiers particulier. L'utilisation de ces chemins se
    fait de la même manière que pour les chemins obtenus d'une instance de type FileSystem encapsulant un système
    de fichiers du système d'exploitation.

    L'exemple ci-dessous affiche le contenu d'un fichier contenu dans une archive de type jar.

    */
    try {
      testZip();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
       L'extraction d'un fichier d'une archive de type zip se fait simplement en invoquant la méthode copy() de la
       classe Files en lui passant en paramètres une instance de type Path du chemin dans l'archive et une instance
       de type Path du chemin cible.

       L'exemple ci-dessous extrait un fichier contenu dans une archive de type jar.
    */
    try {
      testZip2();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
    Pour créer une archive de type zip vide, il faut créer une instance de type FileSystem en utilisant la méthode
    newFileSystem() et en lui passant en paramètre :

     .une URI du chemin de l'archive dont le protocole est jar:file:
     .une collection de type Map qui contienne une occurrence ayant pour clé "create" et pour valeur "true"

     METODOS DE FileSystems
     ----------------------
     static FileSystem	                                   getDefault()
                                                            Returns the default FileSystem.

     static FileSystem	                                   getFileSystem(URI uri)
                                                            Returns a reference to an existing FileSystem.

     static FileSystem	                                   newFileSystem(Path path, ClassLoader loader)
                                                            Constructs a new FileSystem to access the contents of a
                                                            file as a file system.

     static FileSystem	                                   newFileSystem(URI uri, Map<String,?> env)
                                                            Constructs a new file system that is identified by a URI

     static FileSystem	                                  newFileSystem(URI uri, Map<String,?> env, ClassLoader loader)
                                                            Constructs a new file system that is identified by a URI
  */
    Path path = Paths.get("C:/Users/Jorge/Desktop/test2/pruebita.zip");
    try {
      FileSystem prueba = creerZipFileSystem(path);//me retorna un FileSystems.newFileSystem(uri, env) pa crear objeto FileSystem
      //luego podemos hacer ajouts, por ejemplo    Files.copy(source,prueba.getPath("/nuevoArchiv.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
      L'ajout d'un fichier dans une archive se fait en utilisant la méthode copy() de la classe Files avec
      comme paramètres le chemin de la source et le chemin dans l'archive.

      L'exemple ci-dessous ajoute un nouveau fichier dans une nouvelle archive de type zip.
    */
    try {
      testAjouterZip();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //********************************************************************************************************************
  //                          LEER ARCHIVO QUE SE ENCUENTRA DENTRO DE UN ZIP
  //********************************************************************************************************************
  public static void testZip() throws IOException {
    // Path de l'archive
    final Path source = Paths.get("C:/Users/Jorge/Desktop/creed.zip");//sabemos donde esta
    // création d'une instance de FileSystem pour gérer les zip
    final FileSystem fs = FileSystems.newFileSystem(source, null);//creamos un FileSystem , pongo el path
    // Path du fichier à accéder dans l'archive
    final Path mf = fs.getPath("/dictionnaire.txt");//OU fs.getPath("C:/Users/Jorge/Desktop/creed.zip/dictionnaire.txt").getFileName()
    //                                                             este funciona   StandardCharsets.ISO_8859_1 Y Charset.forName("ISO-8859-1")
    // lecture et affichage du fichier contenu dans l'archive       Charset.defaultCharset() me daba error talvez pk algunos
    try (BufferedReader readBuffer = Files.newBufferedReader(mf, Charset.forName("ISO-8859-1"))) {//caracteres tenian ^ è etc ( no soportados=
      String ligne;
      while ((ligne = readBuffer.readLine()) != null) {//es buffer da null cuando acaba , Reader -1
        System.out.println(ligne);
      }
    }
  }

  //********************************************************************************************************************
  //                          COPIAR ARCHIVO QUE SE ENCUENTRA DENTRO DE UN ZIP A OTRO LADO
  //********************************************************************************************************************
  public static void testZip2() throws IOException {
    // Path de l'archive
    final Path source = Paths.get("C:/Users/Jorge/Desktop/creed.zip");
    // creation d'une instance de FileSystem pour gérer les zip
    final FileSystem fs = FileSystems.newFileSystem(source, null);
    // Path du fichier cible
    final Path cible = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    Files.deleteIfExists(cible);//lo va a borrar si existe en el destino, antes de que yo lo copie pa no sobreescribir
    // extraire l'élément de l'archive
    Files.copy(fs.getPath("/dictionnaire.txt"), cible);
    if (Files.exists(cible)) {
      System.out.println("fichier " + cible.getFileName() + " extrait de l'archive " + source);
    }
  }

  //********************************************************************************************************************
  //                          CREAR ARCHIVO DE TIPO ZIP VACIO
  //********************************************************************************************************************
  private static FileSystem creerZipFileSystem(Path zipFile) throws IOException {
    final URI uri = URI.create("jar:file:" + zipFile.toUri().getPath());//String en parametro
    final Map<String, String> env = new HashMap<>();
    env.put("create", "true");
    return FileSystems.newFileSystem(uri, env);
  }
  //*******************************************************************************************************************+
  //                          CREAR UN ARCHIVO VACIO Y AGREGAR un ELEMENTO
  //********************************************************************************************************************

  public static void testAjouterZip() throws IOException {
    final Path pathZip = Paths.get("C:/Users/Jorge/Desktop/test2/prueba.zip");//crea el .zip
    Files.deleteIfExists(pathZip);
    // important : invoquer la méthode close() du FS
    try (FileSystem fs = creerZipFileSystem(pathZip)) {
      Path source = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
      Path dest = fs.getPath("/", "monfichier.txt");//lo va a pegar en prueba , con el nombre de monfichier.txt

      Files.copy(source, dest, StandardCopyOption.COPY_ATTRIBUTES);
    }
  }
  /*
    Pour que le fichier soit correctement ajouté, il est important d'invoquer la méthode close() sur l'instance
    de type FileSystem qui encapsule l'archive. Dans l'exemple ci-dessus, cette invocation est assurée par
    l'utilisation d'un try-with-resource.

*/

}

package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class B_Nio_Files {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                                           Class   Files
    //******************************************************************************************************************
    /*
    La classe java.A_nio.file.Files est un helper qui contient une cinquantaine de méthodes statiques permettant
    de réaliser des opérations sur des fichiers ou des répertoires dont le chemin est encapsulé dans un objet de type Path.

    La classe Files permet de réaliser des opérations de base sur les fichiers et les répertoires : création,
    ouverture, suppression, test d'existence, changement des permissions, ...

    Ces méthodes concernent notamment :

    .La création d'éléments : createDirectory(), createFile(), createLink(), createSymbolicLink(), createTempFile(), createTempDirectory(), ...

    .La manipulation d'éléments : delete(), move(), copy(), ...

    .L'obtention du type d'un élément : isRegularFile(), isDirectory(), probeContentType(), ...

    .L'obtention de métadonnées et la gestion des permissions : getAttributes(), getPosixFilePermissions(), isReadable(),
     isWriteable(), size(), getFileAttributeView(), ...

   NIO 2 propose une API qui facilite la manipulation des éléments du système de fichiers pour par exemple créer,
   supprimer, déplacer, renommer ou copier un fichier. La manipulation des fichiers et des répertoires est assurée
   par la classe java.A_nio.file.Files..

   Les méthodes de la classe Files attendent généralement en paramètre au moins une instance de type Path.
   Certaines méthodes de la classe Files effectuent des opérations atomiques qui doivent être réalisées dans leur
   entièreté ou pas du tout : elles réussissent ou échouent.

    */
    Path monFichier = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    boolean estLisible = Files.isRegularFile(monFichier) & Files.isReadable(monFichier);
    System.out.println(monFichier + " est lisible : " + estLisible);
    System.out.println();
    /*
    resultado:
    C:\Users\Jorge\Desktop\dictionnaire.txt est lisible : true
    */

    //La classe Files propose aussi plusieurs méthodes pour faire d'autres vérifications sur des éléments de type Path.
    Path lien = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    Path cible = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    try {
      if (Files.isSameFile(lien, cible)) {
        System.out.println("Fichiers identiques");
      } else {
        System.out.println("Fichiers différents");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    //resultado: Fichiers identiques
    //******************************************************************************************************************
    //La création d'un fichier ou d'un répertoire
    //L'API permet la création de fichiers, de répertoires permanents ou temporaires en utilisant plusieurs méthodes
    // de la classe File :
    /*
    Path                                    createFile(Path path, FileAttribute<?>... attrs)
                                              Créer un fichier dont le chemin est encapsulé par l'instance de type Path
                                              fournie en paramètre

    Path                                    createDirectory(Path dir, FileAttribute<?>... attrs)
                                              Créer un répertoire dont le chemin est encapsulé par l'instance de type
                                              Path fournie en paramètre

    Path                                    createDirectories(Path dir, FileAttribute<?>... attrs)
                                              Créer dans le répertoire dont le chemin est fourni en paramètre un
                                              sous-répertoire avec les attributs fournis

    Path                                    createTempDirectory(Path dir, String prefix, FileAttribute<?>... attrs)
                                              Créer dans le répertoire dont le chemin est fourni en paramètre un
                                              sous-répertoire temporaire dont le nom utilisera le préfixe fourni

    Path                                    createTempDirectory(String prefix, FileAttribute<?>... attrs)
                                              Créer dans le répertoire temporaire par défaut du système, un
                                              sous-répertoire temporaire dont le nom utilisera la préfixe fourni

    Path                                   createTempFile(Path dir, String prefix, String suffix, FileAttribute<?>... attrs)
                                              Créer dans le répertoire dont le chemin est fourni en paramètre un
                                              fichier temporaire dont le nom utilisera le préfixe fourni

    Path                                   createTempFile(String prefix, String suffix, FileAttribute<?>... attrs)
                                              Créer dans le répertoire temporaire par défaut du système un fichier
                                              temporaire dont le nom utilisera le préfixe et le suffixe fournis

    La méthode Files.createFile() permet de créer un fichier dont le chemin est encapsulé dans son paramètre de type Path.

    La méthode createFile() attend en paramètres un objet de type Path et un varargs de type FileAttribute< ?> qui
    permet de préciser les attributs du fichier créé.
    */
    /*
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
    FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
    try {
      Files.createFile(fichier, attr);
    } catch (IOException e) {
      e.printStackTrace();
    }
*/
    //Si le chemin est uniquement fourni en paramètre de la méthode createFile(), le fichier est créé
    //avec les attributs par défaut du système.
    Path fichier2 = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    try {
      Path file = Files.createFile(fichier2);
    } catch (IOException e) {
      e.printStackTrace();//dara la exception porque esto ya existe
    }
    System.out.println();
    //Par défaut, une exception de type FileAlreadyExistsException est levée si le fichier à créer existe déjà.
    //La méthode createTempFile() permet de créer un fichier temporaire.

    /******************************************************************************************************************
     createTempFile(Path dir, String prefix, String suffix, FileAttribute< ?>... attrs)
     Créer un fichier temporaire dans le répertoire dont le chemin est fourni en paramètre

     createTempFile(String prefix, String suffix, FileAttribute< ?>... attrs)
     Créer un fichier temporaire dans le répertoire par défaut du système

     Les deux surcharges attendent en paramètres un préfixe et un suffixe qui seront utilisés pour déterminer
     le nom du fichier et les attributs à utiliser lors de la création du fichier. Le préfixe et le suffixe peuvent
     être null : s'ils sont fournis, ils seront utilisés par l'implémentation de manière spécifique pour déterminer
     le nom du fichier. Le format du nom du fichier créé est dépendant de la plate-forme.
     *******************************************************************************************************************/
    Path tempFile = null;
    try {
      tempFile = Files.createTempFile("monapp_", ".tmp");
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.format("Fichier créé : %s%n", tempFile);
    System.out.println();
    /*
    Résultat :
       1.
       Fichier créé : C:\DOCUME~1\jm\LOCALS~1\Temp\monapp_242180026059597956.tmp
    */

    //*******************************************************************************************************************
    //                                       createDirectory()
    //*******************************************************************************************************************
   /*
   static Path	                                createDirectories(Path dir, FileAttribute<?>... attrs)
                                                    Creates a directory by creating all nonexistent parent directories first.

   static Path	                                createDirectory(Path dir, FileAttribute<?>... attrs)
                                                    Creates a new directory.

   La méthode createDirectory() permet de créer un répertoire : elle attend en paramètre un objet de type Path
   qui encapsule le chemin ou le sous-chemin du répertoire et un varargs de type FileAttribute< ?> qui permet de
   préciser les attributs du nouveau répertoire.

   Si aucun attribut n'est fourni en paramètre, alors le répertoire est créé avec les attributs par défaut du système.
   */
    Path monRepertoire = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire");//damos la ruta y al ultimo el nombre
    try {
      Path file = Files.createDirectory(monRepertoire);//lo creamos en esa ruta
    } catch (IOException e) {
      e.printStackTrace();//Si le répertoire à créer existe déjà alors une exception de type FileAlreadyExistsException est levée.
    }
    System.out.println();
    /*
    La méthode createDirectory() ne permet que de créer un seul sous-répertoire : le chemin ou le sous-chemin fourni
    ne doit donc correspondre qu'à un nouveau sous-répertoire à créer dans un répertoire existant. Dans le cas contraire,
    une exception de type NoSuchFileException est levée.
    */

    Path monRepertoire2 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire2");
    try {
      Path file = Files.createDirectory(monRepertoire2);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    //******************************************************************************************************************
    // Pour créer toute l'arborescence fournie dans le chemin, incluant la création d'un ou plusieurs
    // sous-répertoires manquants dans l'arborescence, il faut utiliser la méthode createDirectories().
    //static Path	                          createDirectories(Path dir, FileAttribute<?>... attrs)
    //                                            Creates a directory by creating all nonexistent parent directories first.
    //******************************************************************************************************************

    Path monRepertoire3 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoireNuevo/hola2");//crea monRepetoireNuevo y hoa2 dentro
    try {
      Path file = Files.createDirectories(monRepertoire3);
    } catch (IOException e) {
      e.printStackTrace();
    }

    //*******************************************************************************************************************
    //                       La copie d'un fichier ou d'un répertoire
    //*******************************************************************************************************************
    /*
    Ecrire sa propre méthode pour une fonctionnalité aussi basique que la copie d'un fichier ne présente pas
    beaucoup d'intérêt. Il est préférable d'utiliser une bibliothèque tierce comme Apache Commons IO ou Google Guava
    car cette fonctionnalité n'est pas proposée par l'API Java Core avant Java 7.

    La classe Files propose plusieurs surcharges de la méthode copy() pour copier un fichier ou un répertoire.

    Méthode                                                                     Rôle
    -------                                                                     ----

    Path    copy(Path source, Path target, CopyOption... options)     Copier un élément avec les options précisées

    long    copy(InputStream in, Path target, CopyOption... options)  Copier  tous les octets d'un flux de type InputStream vers un fichier

    long    copy(Path source, OutputStream out)    Copier tous les octets d'un fichier dans un flux de type OutputStream

    La méthode Files.copy() permet de copier un fichier dont les chemins source et cible sont encapsulés dans ses deux
    paramètres de type Path.

    Une surcharge de la méthode copy() permet de préciser les options de copie du fichier en utilisant
    son troisième paramètre qui est un varargs de type CopyOption.
    */

    Path monFichier4 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3");
    Path monFichierCopie = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3-copia");
    try {
      Path file = Files.copy(monFichier4, monFichierCopie);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*******************************************************************************************************************
     Une surcharge de la méthode copy() permet de préciser les options de copie du fichier en utilisant
     son troisième paramètre qui est un varargs de type CopyOption.

     Plusieurs valeurs des énumérations StandardCopyOption et LinkOption qui implémentent
     l'interface CopyOption peuvent être utilisées avec la méthode copy() :

     Valeur                                                    Rôle
     ------                                                    -----

     StandardCopyOption.COPY_ATTRIBUTES                       La copie se fait en conservant les attributs du fichier :
     ceux-ci sont dépendants du système sous-jacent

     StandardCopyOption.REPLACE_EXISTING                      Remplacer le fichier cible s'il existe. Si le chemin cible
     est un répertoire non vide, une exception de type
     FileAlreadyExistsException est levée

     LinkOption.NOFOLLOW_LINKS                                Ne pas suivre les liens symboliques. Si le chemin à copier
     est un lien symbolique, c'est le lien lui-même qui est copié
     *******************************************************************************************************************/

    Path monFichier5 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoireNuevo");
    Path monFichierCopie5 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoireNuevo--nuevo");
    try {
      Path file = Files.copy(monFichier5, monFichierCopie5, REPLACE_EXISTING);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
    Faute d'option indiquée, une exception est levée si le fichier cible existe déjà. La copie échoue si la
    destination existe sauf si l'option StandardCopyOption.REPLACE_EXISTING est utilisée.

    Attention : il est possible d'utiliser la méthode copy() sur un répertoire cependant, le répertoire sera créé
    sans que les fichiers et les sous-répertoires ne le soient : quoi que contienne le répertoire, la méthode copy
    ne créé qu'un répertoire vide. Pour copier le contenu du répertoire, il faut parcourir son contenu et copier
    chacun des éléments un par un.

    La méthode copy() possède deux surcharges qui permettent d'utiliser respectivement un objet de type InputStream
    comme source et un objet de type OutputStream comme cible.
    */

    Path cible2 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoireNuevooo");
    URI uri = new File("C:/Users/Jorge/Desktop/test/monRepetoireNuevo").toURI();

    try (InputStream in = uri.toURL().openStream()) {
      Files.copy(in, cible2);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    //******************************************************************************************************************
    //                     Le déplacement d'un fichier ou d'un répertoire
    //******************************************************************************************************************
    /*
    Avant Java 7, la méthode rename() de la classe java.io.File ne fonctionnait pas sur tous les systèmes
    d'exploitation et généralement pas au travers du réseau. Bien que peu performante, la solution la plus sûre
    était de copier chaque octet du fichier source puis de supprimer ce fichier.

    La méthode Files.move() permet de déplacer ou de renommer un fichier dont les chemins source et cible
    sont encapsulés dans ses deux paramètres de type Path.

    Méthode                                                    Rôle
    -------                                                    ----

    move(Path source, Path target, CopyOption... options)     Déplacer ou renommer un élément avec les options précisées
    */
    Path monFichier6 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire2");
    Path monFichierCopie6 = Paths.get("C:/Users/Jorge/Desktop/test2/monRepetoire22");
    try {
      Path file = Files.move(monFichier6, monFichierCopie6);
    } catch (IOException e) {
      e.printStackTrace();
    }
   /*
     Con Files.move si se trata de un directorio este si se desplaza con su contenido (fichiers et directorios etc)
     y desaparece en el fichier de base

     Les options de déplacement du fichier peuvent être précisées en utilisant son troisième paramètre de type CopyOption.

     Plusieurs valeurs de l'énumération StandardCopyOption qui implémente l'interface CopyOption peuvent être utilisées
     avec la méthode move() :

     Valeur                                                  Rôle

     StandardCopyOption.REPLACE_EXISTING                     Remplacement du fichier s'il existe

     StandardCopyOption.ATOMIC_MOVE                          Assure que le déplacement est réalisé sous la forme d'une
                                                             opération atomique. Si l'atomicité de l'opération ne peut
                                                             être garantie alors une exception de type
                                                             AtomicMoveNotSupportedException est levée
   */
    Path monFichier7 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3");
    Path monFichierCopie7 = Paths.get("C:/Users/Jorge/Desktop/test2/monRepetoire3_new");
    try {
      Path file = Files.move(monFichier7, monFichierCopie7, REPLACE_EXISTING, COPY_ATTRIBUTES);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
    Si la méthode move() est invoquée avec l'option StandardCopyOption.COPY_ATTRIBUTES alors une exception de
    type UnsupportedOperationException est levée.

    Par défaut, l'invocation de la méthode move() dont le chemin cible existe déjà lève une exception de type
    FileAlreadyExistException. Pour écraser le fichier existant, il faut utiliser l'option StandardCopyOption.REPLACE_EXISTING.

    Si le chemin source est un lien alors c'est le lien lui-même et non sa cible qui est déplacé.

    Si les chemins cible et source fournis en paramètres de la méthode move() sont identiques alors
    l'invocation de la méthode n'a aucun effet.
    */

    Path source = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3");
    Path cible3 = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3");
    try {
      Files.move(source, cible3);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    /*
    La méthode move() peut être utilisée sur un répertoire vide ou sur un répertoire non vide dont la cible
    est sur le même système de fichiers. Dans ce cas le répertoire est simplement renommé et il n'est pas nécessaire
    de déplacer récursivement le contenu du répertoire.
    */

    Path tic = Paths.get("C:/Users/Jorge/Desktop/test/monRepetoire3");
    Path toc = Paths.get("C:/Users/Jorge/Desktop/test2/monRepetoire33");
    try {
      Files.move(tic, toc);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
   /*
   Si le répertoire cible existe et n'est pas vide, alors une exception de type DirectoryNotEmptyException est levée.

   Une exception de type AtomicNotSupportedException est levée si le déplacement du répertoire implique deux
   systèmes de fichiers différents entre la cible et la source et que l'option ATOMIC_MOVE est utilisée.


                             // déplacer un fichier dans une autre unité de stockage

                             source = Paths.get("c:/temp/cible.txt");
                             cible = Paths.get("s:/cible.txt");

                             try {
                             Files.move(source, cible, ATOMIC_MOVE);
                             } catch (final IOException ioe) {
                             ioe.printStackTrace();
                             }

   Les répertoires vides peuvent être déplacés. Si le répertoire n'est pas vide alors il est possible de le
   déplacer à condition que son contenu n'est pas besoin de l'être : ceci dépend du système d'exploitation
   sous-jacent qui peut simplement renommer le répertoire si celui-ci reste sur la même unité de stockage.

   Sur la plupart des systèmes, le déplacement d'un répertoire vers une cible sur le même système de stockage
   se fait simplement en modifiant des entrées dans la table d'allocations des fichiers.

   Par contre, le déplacement vers une autre unité de stockage implique forcément le déplacement du contenu du répertoire.

   Pour tout autre problème lors de l'invocation de la méthode move(), comme pour toute opération d'entrée/sortie,
   une erreur peut survenir : dans ce cas, la méthode lève une exception de type IOException.

   L'exécution de la méthode move() se fait de manière synchrone et bloquante.

   Par défaut, lors de la copie ou du déplacement d'un fichier :

     .la copie échoue si le fichier cible existe déjà
     .les attributs du fichier peuvent être conservés entièrement, partiellement ou pas du tout
     .lors de la copie d'un lien symbolique, c'est la cible du lien qui est copiée et non le lien lui-même
     .lors du déplacement d'un lien symbolique, le lien lui-même est déplacé mais le fichier cible n'est pas déplacé
     .un répertoire est déplacé seulement s'il est vide ou si le déplacement consiste simplement à le renommer
   */
    //*******************************************************************************************************************
    //                La suppression d'un fichier ou d'un répertoire
    //*******************************************************************************************************************
    /*
    L'API permet la suppression de fichiers, de répertoires ou de liens en utilisant l'une des deux méthodes
    de la classe Files :

     Méthode                                                    Rôle

     void delete(Path path)                                     Supprimer un élément du système de fichiers

     boolean deleteIfExist(Path path)                           Supprimer un élément du système de fichiers s'il existe

     La méthode Files.delete() permet de supprimer un fichier dont le chemin est encapsulé dans son paramètre
     de type Path. Elle lève une exception si la suppression échoue. Par exemple, une exception de type
     NoSuchFileException est levée si le fichier à supprimer n'existe pas dans le système de fichiers.

     La suppression d'un lien symbolique supprime le lien mais ne supprime pas le fichier cible.

     La suppression d'un répertoire échoue si le répertoire n'est pas vide.
    */

    Path path = Paths.get("C:/Users/Jorge/Desktop/test2/monRepetoire33");

    try {
      Files.delete(path);
    } catch (NoSuchFileException nsfe) {
      System.err.println("Fichier ou repertoire " + path + " n'existe pas");
    } catch (DirectoryNotEmptyException dnee) {
      System.err.println("Le repertoire " + path + " n'est pas vide");
    } catch (IOException ioe) {
      System.err.println("Impossible de supprimer " + path + " : " + ioe);
    }
    //La méthode deleteIfExist() permet de supprimer un élément du système de fichiers sans lever d'exception si celui-ci n'existe pas.


    Path path2 = Paths.get("c:/java/test.txt");
    try {
      Files.deleteIfExists(path2);
    } catch (DirectoryNotEmptyException dnee) {
      System.err.println("Le repertoire " + path2 + " n'est pas vide");
    } catch (IOException ioe) {
      System.err.println("Impossible de supprimer " + path2 + " : " + ioe);
    }
    //******************************************************************************************************************
    //                              L'obtention du type de fichier
    //******************************************************************************************************************
    /*
    NIO2 propose une fonctionnalité pour obtenir le type du contenu d'un fichier en utilisant la méthode
    probeContentType() de la classe Files

    Méthode                                                  Rôle

    String probeContentType(Path path)                       Retourner le type du contenu du fichier dont le chemin
                                                             est passé en paramètre

         public static void main(String[] args) {
         try {
         Path source = Paths.get("c:/java/temp/monfichier.txt");
         testProbeContent(source);
         source = Paths.get("c:/java/temp/monfichier.bin");
         testProbeContent(source);
         source = Paths.get("c:/java/temp/monfichier");
         testProbeContent(source);
         } catch (IOException e) {
         e.printStackTrace();
         }
         }

         public static void testProbeContent(Path fichier) throws IOException {
         String type = Files.probeContentType(fichier);
         if (type == null) {
         System.out.println("Impossible de déteminer le type du fichier :"+ fichier);
         } else {
         System.out.println("le fichier " + fichier + " est du type : " + type);
         }
         }

        Résultat:
          le fichier c:\java\temp\monfichier.txt est du type : text/plain
          Impossible de déteminer le type du fichier : c:\java\temp\monfichier.bin
          Impossible de déteminer le type du fichier : c:\java\temp\monfichier


          La méthode probeContentType() renvoie null si le type de contenu ne peut pas être déterminé.

          L'implémentation de cette méthode est dépendante de la plate-forme : sa fiabilité n'est donc pas garantie.

          Il est possible de fournir une implémentation du type FileTypeDetector pour déterminer le type du contenu d'un fichier.

          Si aucune implémentation de type FileTypeDetector ne peut déterminer le type, alors la méthode
          probeContentType() va demander au système de déterminer le type du contenu.

          Pour définir sa propre implémentation, il faut créer une classe qui hérite de la classe abstraite FileTypeDetector
          et redéfinir sa méthode abstraite probeContentType() qui attend en paramètre un objet de type Path et renvoie
          une chaîne de caractères.

          L'implémentation doit avoir un constructeur sans argument.


    */

  }
}

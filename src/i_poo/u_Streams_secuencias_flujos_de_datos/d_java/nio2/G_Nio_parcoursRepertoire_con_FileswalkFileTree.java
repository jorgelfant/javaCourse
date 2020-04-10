package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.*;

public class G_Nio_parcoursRepertoire_con_FileswalkFileTree {
  public static void main(String[] args) {
    /*
    Le parcours d'une hiérarchie de répertoires
    ------------------------------------------
    La méthode Files.walkFileTree() permet de parcourir la hiérarchie d'un ensemble de répertoires en utilisant
    le motif de conception visiteur. Ce type de parcours peut être utilisé pour rechercher, copier, déplacer, supprimer, ...
    des éléments de la hiérarchie parcourue.

    Files.walkFileTree()
    -------------------
    The Files.walkFileTree() method contains functionality for traversing a directory tree recursively.
    The walkFileTree() method takes a Path instance and a FileVisitor as parameters. The Path instance
    points to the directory you want to traverse. The FileVisitor is called during traversion.

    Il faut écrire une classe qui implémente l'interface java.A_nio.file.FileVisitor<T>. Cette interface définit des
    méthodes qui seront des callbacks lors du parcours de la hiérarchie.
    --------------------------------------------------------------------------------------------------------------------
    Méthode                                                         Rôle
    FileVisitResult                                                 postVisitDirectory(T dir, IOException exc)
                                                                     Le parcours sort d'un répertoire qui vient
                                                                     d'être parcouru ou une exception est survenue
                                                                     durant le parcours

    FileVisitResult                                                 preVisitDirectory(T dir, BasicFileAttributes attrs)
                                                                     Le parcours rencontre un répertoire, cette
                                                                     méthode est invoquée avant de parcourir son
                                                                     contenu

    FileVisitResult                                                 visitFile(T file, BasicFileAttributes attrs)
                                                                     Le parcours rencontre un fichier

    FileVisitResult                                                 visitFileFailed(T file, IOException exc)
                                                                     La visite d'un des fichiers durant le
                                                                     parcours n'est pas possible et une exception
                                                                     a été levée



    Enum Constants
    --------------
    Enum Constant and Description
    ------------------------------
    CONTINUE                         public static final FileVisitResult CONTINUE
       Continue.
    SKIP_SIBLINGS                   public static final FileVisitResult TERMINATE
       Continue without visiting the siblings of this file or directory.
    SKIP_SUBTREE                    public static final FileVisitResult SKIP_SUBTREE
       Continue without visiting the entries in this directory.
    TERMINATE                       public static final FileVisitResult SKIP_SIBLINGS
       Terminate.
    --------------------------------------------------------------------------------------------------------------------
    Il est possible de contrôler les traitements du parcours en utilisant les objets de type FileVisitResult retournés
    par les méthodes de l'interface FileVisitor.

    Les méthodes de l'interface FileVisitor renvoient toutes une valeur qui appartient à l'énumération FileVisitResult.
    Cette valeur permet de contrôler le processus de parcours de l'arborescence :
    FileVisitResult.

    . CONTINUE : poursuite du parcours

    . TERMINATE : arrêt immédiat du parcours

    . SKIP_SUBTREE : inhibe le parcours de la sous-arborescence. Si la méthode preVisitDirectory() renvoie cette valeur,
                     le parcours du répertoire est ignoré

    . SKIP_SIBLING : inhibe le parcours des répertoires frères. Si la méthode preVisitDirectory() renvoie cette valeur
                     alors le répertoire n'est pas parcouru et la méthode postVisitDirectory() n'est pas invoquée.
                     Si la méthode postVisitDirectory() renvoie cette valeur, alors les autres répertoires frères qui
                     n'ont pas encore été parcourus sont ignorés
    */
   Path repertoire = Paths.get(("C:/Users/Jorge/Desktop/test2"));
    try {
      testWalkFileTree(repertoire);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  //********************************************************************************************************************
  //METODOS FUERA DEL MAIN   tendria que crear un objeto de clase G_Nio_parcoursRepertoire_con_FileswalkFileTree
  // y luego usar estos 2 primeros metodos  preVisitDirectory   y visitFile
  //********************************************************************************************************************
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    if (dir.getFileName().toString().equals("target")) {
      return SKIP_SUBTREE;
    }
    return CONTINUE;
  }
  //********************************************************************************************************************
  // L'exemple ci-dessous parcourt l'arborescence et s'arrête dès que le fichier test.txt est trouvé.
  //********************************************************************************************************************

  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {

    if (file.getFileName().equals("test.txt")) {
      System.out.println("Fichier trouve");
      return TERMINATE;
    }
    return CONTINUE;
  }

  //*******************************************************************************************************************+
  //     L'API propose la classe java.A_nio.file.SimpleFileVisitor qui est une implémentation de l'interface FileVisitor.
  //     Le plus simple est donc de créer une classe fille qui hérite de la classe SimpleFileVisitor et de redéfinir
  //     les méthodes utiles selon les besoins.
  //
  //     L'exemple ci-dessous affiche tous les fichiers .java en ignorant les répertoires target.
  //********************************************************************************************************************
  public static void testWalkFileTree(Path repertoire) throws IOException {
    Files.walkFileTree(repertoire, new SimpleFileVisitor<Path>() {

      @Override//me va imprimir los archivos y CONTINUA leyendo
      public FileVisitResult visitFile(Path file, final BasicFileAttributes attrs) throws IOException {
        //String nom = file.getFileName().toString();
        System.out.println("Fichier : " + file.getFileName());
        return FileVisitResult.CONTINUE;//dice que continua a leer los files
      }
      @Override//me va imprimir los repertorios y CONTINUA leyendo
      public FileVisitResult preVisitDirectory(Path dir, final BasicFileAttributes attrs) throws IOException {
        FileVisitResult result = FileVisitResult.CONTINUE;
        System.out.println("Répertoire : " + dir.getFileName());
        return result;//dice que continua a leer los directorios
      }
    });
  }
}
/*
Pour lancer le parcours de la hiérarchie d'un répertoire, il faut utiliser la méthode walkFileTree() de la
classe Files qui propose deux surcharges :

   .Path walkFileTree(Path start, FileVisitor<? super Path> visitor)

   .Path walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, FileVisitor<? super Path> visitor)

La première surcharge attend en paramètres le chemin du répertoire qui doit être parcouru et une instance de
type FileVisitor qui va encapsuler les traitements du parcours.

La seconde surcharge attend deux paramètres supplémentaires qui permettent de préciser des options sous la forme
d'un ensemble de type FileVisitOption et un entier qui permet de limiter le niveau de profondeur du parcours dans
la hiérarchie.

L'énumération FileVisitOption ne contient que la valeur FOLLOW_LINKS qui permet de demander de suivre les liens
rencontrés lors du parcours. Par défaut, les liens symboliques ne sont pas suivis par le WalkFileTree.
Pour suivre les liens symboliques, il faut préciser l'utilisation de l'option FOLLOW_LINKS.
*/

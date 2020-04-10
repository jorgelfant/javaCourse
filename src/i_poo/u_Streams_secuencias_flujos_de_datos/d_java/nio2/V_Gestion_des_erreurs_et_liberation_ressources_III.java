package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class V_Gestion_des_erreurs_et_liberation_ressources_III {
  public static void main(String[] args) {
    /*
    Plusieurs exceptions héritent de l'exception FileSystemException qui hérite elle-même de l'exception IOException.

    La classe FileSystemException encapsule plusieurs attributs qui sont des chaînes de caractères:

        .file : le nom du fichier impliqué
        .message : un message détaillé sur l'exception
        .reason : la raison pour laquelle l'opération a échoué
        .otherFile : renvoie le nom d'un second fichier impliqué
    */
    copierFichier();
    /*resultado
      Copie impossible : le fichier C:\Users\Jorge\Desktop\hola.txt existe déjà
  */
  }

  //fuera del main
  public static void copierFichier() {
    Path source = Paths.get("C:/Users/Jorge/Desktop/test2/hola.txt");
    Path cible = Paths.get("C:/Users/Jorge/Desktop/hola.txt");
    try {
      Files.copy(source, cible);
    } catch (FileAlreadyExistsException e) {
      System.err.format("Copie impossible : le fichier %s existe déjà", e.getFile());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /*
  De nombreuses ressources utilisées par l'API NIO 2 telles que les channels ou les flux implémentent l'interface
  java.io.Closeable. Ceci permet leur prise en compte par l'opérateur try-with-ressource qui invoque leur méthode
  close() et libère ainsi les ressources devenues inutiles.

  Java 7 propose une fonctionnalité nommée Automatic Resource Management ou ARM. L'ARM propose de réduire la quantité
  de code à produire par le développeur pour gérer une ressource et surtout pour libérer les ressources qui lui sont
  associées.

  Des langages comme C, C++ ou Delphi, offrent aux développeurs un contrôle total sur l'allocation et la désallocation
  mémoire des objets créés en utilisant des opérateurs comme malloc, free, new, delete, ...

  Contrairement à eux, Java ne propose pas de contrôle sur le processus de désallocation des ressources d'un objet.
  La JVM propose un mécanisme nommé garbage collection ou ramasse-miettes qui assure la libération des ressources
  mémoires des objets qui ne sont plus utilisés.

  Il est possible de demander à la JVM de forcer l'exécution du ramasse-miettes en utilisant les méthodes System.gc()
  ou Runtime.getRuntime.gc() : ce ne sont que des suggestions de demandes que la JVM n'est pas obligée de suivre.

  Il n'est pas recommandé d'utiliser ces méthodes dans son code et dans tous les cas la logique des traitements ne
  doit pas reposer sur ces méthodes.
  */
}

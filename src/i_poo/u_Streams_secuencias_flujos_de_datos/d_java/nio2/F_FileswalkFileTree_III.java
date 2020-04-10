package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;

public class F_FileswalkFileTree_III {
  public static void main(String[] args) {
    /*
    L'énumération FileVisitOption ne contient que la valeur FOLLOW_LINKS qui permet de demander de suivre les
    liens rencontrés lors du parcours. Par défaut, les liens symboliques ne sont pas suivis par le WalkFileTree.
    Pour suivre les liens symboliques, il faut préciser l'utilisation de l'option FOLLOW_LINKS.
    */

    final Path repertoire = Paths.get("C:/Users/Jorge/Desktop/test2");
    //EnumSet est un Set
    EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

    try {
      Files.walkFileTree(repertoire, options, Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
        //**************************************************************************************************************
        //          Si l'option FOLLOW_LINK est utilisée, le walkFileTree est capable de détecter les références
        //          circulaires lors du parcours. Dans ce cas, la méthode visitFileFailed() sera invoquée et elle
        //          aura une exception de type FileSystemLoopException en paramètre.
        //**************************************************************************************************************
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException ioe) {
          if (ioe instanceof FileSystemLoopException) {
            System.err.println("Reference circulaire detectee : " + file);
          } else {
            ioe.printStackTrace();
          }
          return FileVisitResult.CONTINUE;
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
   /*
   Important : il n'est pas possible de présumer de l'ordre de parcours des répertoires.

   Si les traitements modifient le système de fichiers, il est important de faire particulièrement attention dans
   l'implémentation du FileVisitor. Par exemple :

   Si le parcours est utilisé pour supprimer une sous-arborescence, il est nécessaire de supprimer les fichiers
   contenus par un répertoire avant de supprimer le répertoire lui-même.

   Si le parcours est utilisé pour copier une sous-arborescence, il faut créer le sous-répertoire avant de copier
   les fichiers qu'il doit contenir
   */

  }
}

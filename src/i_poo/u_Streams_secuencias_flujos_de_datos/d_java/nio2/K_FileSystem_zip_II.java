package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;



import java.io.IOException;
import java.nio.file.*;

public class K_FileSystem_zip_II {
  public static void main(String[] args) throws IOException {
    // Création d'un système de fichiers en fonction d'un fichier ZIP
    try (FileSystem zipFS = FileSystems.newFileSystem(Paths.get("monFichier.zip"), null)) {

      //Suppression d'un fichier à l'intérieur du ZIP :
      Files.deleteIfExists( zipFS.getPath("test.txt") );

      //Création d'un fichier à l'intérieur du ZIP :
      Path path = zipFS.getPath("nouveau.txt");
      String message = "Hello World !!!";
      Files.write(path, message.getBytes());//getBytes metodo de String da un byte[]

      //Parcours des éléments à l'intérieur du ZIP :
      try (DirectoryStream<Path> stream = Files.newDirectoryStream(zipFS.getPath("/"))) {
        for (Path entry : stream) {
          System.out.println(entry);
        }
      }

      //Copie d'un fichier du disque vers l'archive ZIP :
      Files.copy(Paths.get("fichierSurDisque.txt"), zipFS.getPath("fichierDansZIP.txt"));
    }
  }
}
/*
  Il est également possible d'être averti via l'objetWatchServicelorsqu'un un fichier est modifié, de gérer des
  entrées/sorties asynchrones via les objets AsynchronousFileChannel,AsynchronousSocketChannel ou AsynchronousServerSocketChannel.

  Ceci permet de faire les actions en tâche de fond, sans bloquer le code pendant l'exécution. Il est aussi possible d'avoir accès aux attributs grâce à 6 vues permettant de voir plus ou moins d'informations, à savoir :

   .BasicFileAttributeViewpermet un accès aux propriétés généralement communes à tous les systèmes de fichiers ;

   .DosFileAttributeViewajoute le support des attributs MS-DOS (readonly,hidden,system,archive) à l'objet ci-dessus ;

   .PosixFileAttributeViewajoute les permissions POSIX du monde Unix au premier objet cité ;

   .FileOwnerAttributeViewpermet de manipuler le propriétaire du fichier ;

   .AclFileAttributeViewpermet de manipuler les droits d'accès au fichier ;

   .UserDefinedFileAttributeView: permet de définir des attributs personnalisés.
  */

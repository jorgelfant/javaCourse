package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class F_FileswalkFileTree_I {
  public static void main(String[] args) {

    Path repertoire = Paths.get(("C:/Users/Jorge/Desktop/CAF"));

    try {
      Files.walkFileTree(repertoire, new FileVisitor<Path>() {//sobreescribo los metodos ayudandome de clase anonima
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
          System.out.println("pre visit dir:" + dir);
          return FileVisitResult.CONTINUE;//ou TERMINATE       SKIP_SIBLINGS      SKIP_SUBTREE
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          System.out.println("visit file: " + file);
          return FileVisitResult.CONTINUE;//ou TERMINATE       SKIP_SIBLINGS      SKIP_SUBTREE
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
          System.out.println("visit file failed: " + file);
          return FileVisitResult.CONTINUE;//ou TERMINATE       SKIP_SIBLINGS      SKIP_SUBTREE
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
          System.out.println("post visit directory: " + dir);// Invoked for a directory after entries
          return FileVisitResult.CONTINUE;                   // in the directory, and all of their descendants, have been visited.
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*RESULTADO EJEMPLO
       pre visit dir:C:\Users\Jorge\Desktop\CAF
       visit file: C:\Users\Jorge\Desktop\CAF\ticket.pdf
       visit file: C:\Users\Jorge\Desktop\CAF\ticket2.pdf
       visit file: C:\Users\Jorge\Desktop\CAF\ticket3.pdf
       post visit directory: C:\Users\Jorge\Desktop\CAF    esto lo da al acabar de leer todos los archivos y directorios
                                                           de un directorio (asi como sus descendientes ) osea toodo lo que ta dentro

       La méthode Files.walkFileTree() permet de parcourir la hiérarchie d'un ensemble de répertoires en utilisant le
       motif de conception visiteur. Ce type de parcours peut être utilisé pour rechercher, copier, déplacer, supprimer,
       ... des éléments de la hiérarchie parcourue.

       Il faut écrire une classe qui implémente l'interface java.A_nio.file.FileVisitor<T>. Cette interface définit
       des méthodes qui seront des callbacks lors du parcours de la hiérarchie.
       Each of the methods in the FileVisitor implementation gets called at different times during traversal:

       The preVisitDirectory() method is called just before visiting any directory. The postVisitDirectory() method
       is called just after visiting a directory.

       The visitFile() mehtod is called for every file visited during the file walk. It is not called for
       directories - only files. The visitFileFailed() method is called in case visiting a file fails. For instance,
       if you do not have the right permissions, or something else goes wrong.

       Each of the four methods return a FileVisitResult enum instance. The FileVisitResult enum contains the
       following four options:

       CONTINUE
       TERMINATE
       SKIP_SIBLINGS
       SKIP_SUBTREE

       By returning one of these values the called method can decide how the file walk should continue.

       CONTINUE means that the file walk should continue as normal.

       TERMINATE means that the file walk should terminate now.

       SKIP_SIBLINGS means that the file walk should continue but without visiting any siblings of this file or directory.

       SKIP_SUBTREE means that the file walk should continue but without visiting the entries in this directory.
       This value only has a function if returned from preVisitDirectory(). If returned from any other methods
       it will be interpreted as a CONTINUE.
    */

  }
}

//**********************************************************************************************************************
//                                  Fuera de la clase
//**********************************************************************************************************************
   /*
    The Files.walkFileTree() method contains functionality for traversing a directory tree recursively.
    The walkFileTree() method takes a Path instance and a FileVisitor as parameters. The Path instance
    points to the directory you want to traverse. The FileVisitor is called during traversion.

    Before I explain how the traversal works, here is first the FileVisitor interface:
 -----------------------------------------------------------------------------------------------------------------------
          interface FileVisitor {
            //metodos abstractos
            FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException;

            FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException;

            FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException;

            FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException;
          }
-----------------------------------------------------------------------------------------------------------------------
*/
/*
You have to implement the FileVisitor interface yourself, and pass an instance of your implementation
to the walkFileTree() method. Each method of your FileVisitor implementation will get called at different times
during the directory traversal. If you do not need to hook into all of these methods, you can extend the
SimpleFileVisitor class, which contains default implementations of all methods in the FileVisitor interface.

Here is a walkFileTree() example: VER MAIN
*/


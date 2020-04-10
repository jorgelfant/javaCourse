package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class F_FileswalkFileTree_II {
  public static void main(String[] args) {
    //Searching For Files
    //Here is a walkFileTree() that extends SimpleFileVisitor to look for a file named README.txt :

    Path repertoire = Paths.get(("C:/Users/Jorge/Desktop/test2"));
    String fileToFind = File.separator + "README.txt";     // File.separator significa    / + "README.txt"= "/README.txt"

    try {
      Files.walkFileTree(repertoire, new SimpleFileVisitor<Path>() {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          String fileString = file.toAbsolutePath().toString();
          //System.out.println("pathString = " + fileString);

          if (fileString.endsWith(fileToFind)) {//ou (file.getFileName().toString().equals("README.txt"))
            System.out.println("file found at path: " + file.toAbsolutePath());
            return FileVisitResult.TERMINATE;//apenas lo encuentra termina
          }
          return FileVisitResult.CONTINUE;//el metodo lee y lee los files
        }
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    //******************************************************************************************************************
    //                           Deleting Directories Recursively
    //******************************************************************************************************************
    /*
    The Files.walkFileTree() can also be used to delete a directory with all files and subdirectories inside it.
    The Files.delete() method will only delete a directory if it is empty. By walking through all directories and
    deleting all files (inside visitFile()) in each directory, and afterwards delete the directory
    itself (inside postVisitDirectory()) you can delete a directory with all subdirectories and files.
    Here is a recursive directory deletion example:
    */
    Path repertoire2 = Paths.get(("C:/Users/Jorge/Desktop/test2/schemes_copia"));

    try {
      Files.walkFileTree(repertoire2, new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
          System.out.println("delete file: " + file.toString());
          Files.delete(file);
          return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
          Files.delete(dir);
          System.out.println("delete dir: " + dir.toString());
          return FileVisitResult.CONTINUE;
        }
      });
    } catch(IOException e){
      e.printStackTrace();
    }
    System.out.println();
   /*
    Additional Methods in the Files Class
    The java.A_nio.file.Files class contains many other useful functions, like functions for creating symbolic links,
    determining the file size, setting file permissions etc. Check out the JavaDoc for the java.A_nio.file.Files class
    for more information about these methods.
   */


  }
}

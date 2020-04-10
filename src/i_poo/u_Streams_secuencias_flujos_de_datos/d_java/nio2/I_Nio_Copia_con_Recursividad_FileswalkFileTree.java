package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class I_Nio_Copia_con_Recursividad_FileswalkFileTree {
  public static void main(String[] args) {
       /*
   Iterface de java.A_nio.file                      classes                               Enums
   -------------------------                      -------                               -----
   Interfaces                                     Files                                 AccessMode
   CopyOption                                     FileStore                             FileVisitOption
   DirectoryStream                                FileSystem                            FileVisitResult
   DirectoryStream.Filter                         FileSystems                           LinkOption
   FileVisitor                                    LinkPermission                        StandardCopyOption
   OpenOption                                     Paths                                 StandardOpenOption
   Path                                           SimpleFileVisitor
   PathMatcher                                    StandardWatchEventKinds
   SecureDirectoryStream
   Watchable
   WatchEvent
   WatchEvent.Kind
   WatchEvent.Modifier
   WatchKey
   WatchService
   -----------------------------------------------------------------------------------------------------------------------
   Aun es trabajoso recorrer un repertorio entero de esta forma( con Path, Files) vista en el ejemplo anterior ,
   podemos utilizar la nueva interface  FileVisitor, una implementacion del pattern Visitor , para recorrer toda
   la arborescence  de directorios de manera mas simple.

    Interface FileVisitor<T>
    All Known Implementing Classes:
     SimpleFileVisitor

     public interface FileVisitor<T>
      A visitor of files. An implementation of this interface is provided to the Files.walkFileTree  (walkFileTree metodo de Files) Walks a file tree.
      methods to visit each file in a file tree.

      public static Path walkFileTree(Path start, FileVisitor<? super Path> visitor) throws IOException

   los metodos de esta interface son:
   Modifier and Type	                                     Method and Description
   -------------------------------------------------------------------------------
   FileVisitResult	                                        postVisitDirectory(T dir, IOException exc)
                                                             Invoked for a directory after entries in the directory,
                                                             and all of their descendants, have been visited.

   FileVisitResult	                                       preVisitDirectory(T dir, BasicFileAttributes attrs)
                                                            Invoked for a directory before entries in the directory are visited.

   FileVisitResult	                                       visitFile(T file, BasicFileAttributes attrs)
                                                            Invoked for a file in a directory.

   FileVisitResult	                                       visitFileFailed(T file, IOException exc)
                                                            Invoked for a file that could not be visited.

        .preVisitDirectory             llamado antes de entrar en un directorio

        .postVisitDirectory            llamado despues de pasar por toodos los archivos/subDirectorios de un directorio

        .visitFile                     llamado para cada archivo

        .visitFileFailed               llamado en el caso de que ocurra una  exception en alguno de los otros 2 metodos
   ------------------------------------------------------------------------------------------------------------------------

   Todos estos metodos retornan un  FileVisitResult, um enum com os las opciones para continuar o no recorriendo una arborrescence
   de directorios

   Vamos entonces a implementar un  FileVisitor para copiar nuestro directorio. No siempre necesitamos de todos los metodos
   de la interface ; en este caso, podemos extender la classe SimpleFileVisitor y apenas sobreescribir los métodos que realmente
   necesitamos:

   */
   /*
      .Path walkFileTree(Path start, FileVisitor<? super Path> visitor)

       .Path walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, FileVisitor<? super Path> visitor)
  */

    Path source = Paths.get("C:/Users/Jorge/Desktop/test2");
    Path target = Paths.get("C:/Users/Jorge/Desktop/test2_nuevo");
    try {                       //SimpleFileVisitor o FileVisitor<T>
      Files.walkFileTree(source, new CopiadorDeArchivos(source, target));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
//**********************************************************************************************************************
//                                       Clase EXTERNA
//**********************************************************************************************************************
//de los 4 metodos de la interface FileVisitor podemos implementar solo los que queramos gracias a que los vamos a usar
//a traves de la clase SimpleFileVisitor que implementa a esta interface

//public class SimpleFileVisitor<T> extends Objectimplements FileVisitor<T>
//SimpleFileVisitor es una clase de java.A_nio.file que implementa FileVisitor
class CopiadorDeArchivos extends SimpleFileVisitor<Path> {
  private Path source;
  private Path target;

  public CopiadorDeArchivos(Path source, Path target) {
    this.source = source;
    this.target = target;
  }

  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    copiaPath(dir);
    return FileVisitResult.CONTINUE;//return un enum FileVisitResult
  }

  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    copiaPath(file);
    return FileVisitResult.CONTINUE;//return un enum FileVisitResult
  }
  //estos metodos tratan con el interior del dossier que queremos copiar  Files y Directories
  //porque .Path walkFileTree(Path start, FileVisitor<? super Path> visitor) ya pone en 1er parametro el Path a copiar la fuente
  private void copiaPath(Path entrada) throws IOException {
    // encuentra el camino equivalente a la arborescence de la copia
    //  PRIMERO         "C:/Users/Jorge/Desktop/test2- "C:/Users/Jorge/Desktop/test2  = ""  osea nada
    //  ASI LUEGO       "C:/Users/Jorge/Desktop/test2/subArchivo - "C:/Users/Jorge/Desktop/test2  = subArchivo                               1er target seria:
    Path nuevoDirectorio = target.resolve(source.relativize(entrada));//target "C:/Users/Jorge/Desktop/test2_nuevo" + "" nada   osea "C:/Users/Jorge/Desktop/test2_nuevo"
    Files.copy(entrada, nuevoDirectorio);                           //asi luego //target "C:/Users/Jorge/Desktop/test2_nuevo" + /subArchivo
  }
}
/*
en la clase de arriba, usamos apenas 2 métodos, el visitFile, llamado para copiar cada archivo existente en la arborecencia,
y el  preVisitDirectory, chamado para crear el diretório. Para executar la copia hariamos, haríamos:  VER EL MAIN ^
*/

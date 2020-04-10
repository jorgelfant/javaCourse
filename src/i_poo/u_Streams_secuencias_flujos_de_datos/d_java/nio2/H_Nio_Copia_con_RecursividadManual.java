package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class H_Nio_Copia_con_RecursividadManual {
  public static void main(String[] args) {
    //*******************************************COPIAR CON RECURSIVIDAD**************************************************
    Path source = Paths.get("C:/Users/Jorge/Desktop/test2");
    Path target = Paths.get("C:/Users/Jorge/Desktop/test2_nuevo");
    try {//al tener el metodo en sui declararion throws IOException esto nos obliga a implementar esto en el main el try catch
      copyDirectory(source, target);//es una manera diferente de los otros 2 metodos, que tenian el try catch dentro
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //********************************************************************************************************************
  //                                        COPIAR CON RECURSIVIDAD CON NIO
  //********************************************************************************************************************
  // La méthode resolve() permet de combiner deux chemins. Elle attend en paramètre un chemin partiel qui ne doit pas
  // commencer par un élément racine du système de fichiers. Si le chemin fourni en paramètre contient un élément racine,
  // alors la méthode resolve() renvoie le chemin fourni en paramètre.
  public static void copyDirectory(Path source, Path target) throws IOException {//atrapo la exception en el metodo con throws
    if (Files.isDirectory(source)) {
      Files.createDirectory(target);//creamos entonces el target  ou     Files.copy(source, target);
      DirectoryStream<Path> listaS = Files.newDirectoryStream(source);//lista de elementos de la source

      for (Path elem : listaS) {//luego concatenamos los elementos a la source y target
        Path newSource = source.resolve(elem.getFileName());//le agrego a la source C:/Users/Jorge/Desktop/test2/nombre_subElemento
        Path newTarget = target.resolve(elem.getFileName());//y no target.resolve(newSource);   C:/Users/Jorge/Desktop/test2_nuevo/nombre_subElemento
        //invocamos el metodo recursivo
        copyDirectory(newSource, newTarget);
      }
    } else {
      Files.copy(source, target);//el tercer parametro podria ser  StandardCopyOption.REPLACE_EXISTING u otro del enum StandardCopyOption.
    }
  }// apenas llamamos al método Files.copy, sin precisas ya trabajar con  streams e channels en estos casos.

  //********************************************************************************************************************
  //                                        COPIAR CON RECURSIVIDAD ANTIGUO
  //********************************************************************************************************************
/***************************************** MANERA ANTIGUA SIN NIO: File y no Path *****************************************
 public static void copyDirectory(File source, File target) throws IOException {
 if (source.isDirectory()) {
 target.mkdir();

 for (String f : source.list()) {
 copyDirectory(new File(source, f), new File(target, f));//recursividad
 }
 } else {
 try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(target)) {
 byte[] buf = new byte[1024];
 while ((in.read(buf)) > 0) {
 out.write(buf);
 }
 }
 }
 }
 *********************************************************************************************************************/
}

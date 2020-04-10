package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicLong;

public class F_RECURSIVITE {
  public static void main(String[] args) {
    /*
    Les fonctionnalités offertes par la classe Files ne s'appliquent pas de manière récursive :
    il est nécessaire de parcourir l'arborescence en utilisant une des deux techniques ci-dessus pour
    réaliser des opérations sur un répertoire.

    Par exemple, la méthode size() de la classe Files ne s'applique que sur un fichier. Pour déterminer
    la taille d'un répertoire (en fait la taille des fichiers qu'il contient), il faut écrire du code qui
    va parcourir son contenu et cumuler les tailles des fichiers qu'il contient.

    Il est possible de télécharger séparément les exemples du JDK : plusieurs de ces exemples situés dans le
    sous-répertoire sample/A_nio/file concernent des fonctionnalités utilisant des opérations récursives avec l'API NIO2.
    */

    Path repertoire = Paths.get("C:/Users/Jorge/Desktop/FonoPapa");
    //System.out.println(Files.size(repertoire);); Esto no da el verdadero pero
    try {//hay que escribir un poco de codigo y sumar el peso de cada elemento
      System.out.println(getDirectorySize(repertoire));//entre parentesir porque return un long , para afficher el size
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  //********************************************************************************************************************
  //                             FUERA DEL MAIN
  //********************************************************************************************************************
  public static long getDirectorySize(Path repertoire) throws IOException {
    AtomicLong size = new AtomicLong();
    if (!Files.isDirectory(repertoire)) {
      throw new IllegalArgumentException(//en caso de que el argumento no sea un repertorio que lanze la exception aqui
        "Le chemin n'est pas celui d'un répertoire");
    }

    Files.walkFileTree(repertoire, new SimpleFileVisitor<Path>() {

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (Files.isRegularFile(file)) {
          size.addAndGet(attrs.size());
        }
        return FileVisitResult.CONTINUE;
      }

      //Estariamos contando solo el peso de los files y no de los dir
      @Override//un repertorio en si pesa 0, cuando tiene contenido ahi es cuando tiene peso 1 2 3 etc megabytes
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        FileVisitResult resultat = FileVisitResult.CONTINUE;
        if (!dir.equals(repertoire)) {//osea si no es la carpeta test2, con esto queremos que no tome en cuenta test2
          size.addAndGet(getDirectorySize(dir));//reiniciara size y agregara el peso de los files del direc..... pero..
          resultat = FileVisitResult.SKIP_SUBTREE;//...SKIP_SUBTREE para que tenga en cuenta solo el direc y no su contenido
        }
        return resultat;
      }
    });//despues del Files.walkFileTree  recuperamos la suma con size.get
    return size.get();
  }
}

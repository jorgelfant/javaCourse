package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

public class T_Gestion_Des_Attributs_III_FileTime {
  public static void main(String[] args) {
    /*
        Les attributs creationTime, lastModifiedTime et lastAccessTime encapsulés dans la classe BasicFilesAttributes
        sont de type java.nio.file.attribute.FileTime qui encapsule un horodatage.

        Il est possible de créer une instance de la classe FileTime en utilisant les méthodes :

             .from(long, TimeUnit) : créer une instance à partir de la valeur et de l'unité fournies en paramètre
             .fromMillis(long) : créer une instance à partir du nombre de millisecondes fourni en paramètre

        La méthode fileKey() renvoie un objet qui encapsule une clé unique du fichier dans le système de fichiers
        si celui-ci supporte cette fonctionnalité sinon elle renvoie null.
    */
    try {
      testSetLastModifiedTime();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public static void testSetLastModifiedTime() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    long currentTime = System.currentTimeMillis();
    FileTime ft = FileTime.fromMillis(currentTime);
    Files.setLastModifiedTime(fichier, ft);
  }
}

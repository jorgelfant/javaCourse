package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class T_Gestion_Des_Attributs_IV_VUES_B_DOS {
  public static void main(String[] args) {
    //La classe DosFileAttributes encapsule les attributs d'un élément d'un système de fichiers de type DOS :
    // read only, hidden, archive et system.


    try {
      testDosFileAttributes();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*
    isReadOnly = false
    isHidden   = false
    isArchive  = true
    isSystem   = false
    */
    /*
    Il est aussi possible d'utiliser les méthodes getAttribute() et setAttribute() de la classe Files.
    L'inconvénient de ces méthodes est que l'attribut concerné est fourni sous la forme d'une chaîne de caractères.
    Celle-ci doit être composée du nom de la vue suivi du caractère deux points suivi du nom de l'attribut.
    */
  }
  public static void testDosFileAttributes() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try {
      DosFileAttributes attr = Files.readAttributes(fichier, DosFileAttributes.class);//agreegamos 4 tipo de operacion propio a DosFileAttributes
      System.out.println("isReadOnly = " + attr.isReadOnly());
      System.out.println("isHidden   = " + attr.isHidden());
      System.out.println("isArchive  = " + attr.isArchive());
      System.out.println("isSystem   = " + attr.isSystem());
    } catch (UnsupportedOperationException ueo) {
      ueo.printStackTrace();
    }
  }
}

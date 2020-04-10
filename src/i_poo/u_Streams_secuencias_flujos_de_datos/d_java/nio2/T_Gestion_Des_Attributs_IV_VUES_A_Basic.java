package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class T_Gestion_Des_Attributs_IV_VUES_A_Basic {
  public static void main(String[] args) {
    /*
      Les différents types de systèmes de fichiers possèdent des attributs communs mais possèdent aussi des attributs
      spécifiques. La notion de vue regroupe plusieurs attributs ce qui permet d'obtenir ces attributs en une fois.
      L'API propose en standard plusieurs vues qui sont spécialisées :

      1) BasicFileAttributeView :   permet un accès aux propriétés généralement communes à tous les systèmes de fichiers ;

      2) DosFileAttributeView :     propose une vue qui permet un support des quatre attributs spécifiques à un système
                                    de fichiers de type DOS (readonly,hidden,system,archive)

      3) PosixFileAttributeView :   propose une vue qui permet un support des attributs spécifiques à un système de
                                    fichiers de type Posix notamment la gestion des droits pour le propriétaire, le
                                    groupe et les autres utilisateurs.

      4) FileOwnerAttributeView :   permet de manipuler le propriétaire du fichier ;

      5) AclFileAttributeView   :   permet de manipuler les droits d'accès au fichier ;

      6) UserDefinedFileAttributeView: permet de définir des attributs personnalisés.


      Une vue peut permettre un accès en lecture seule aux données ou permettre leur mise à jour.

      Un système de fichiers ne peut être supporté que par la BasicFileAttributeView ou être supporté par plusieurs vues.
      Un système de fichiers peut même proposer une ou plusieurs vues spécifiques qui ne sont pas fournies en standard
      par l'API.

      Pour obtenir une vue spécifique, il faut utiliser la méthode getFileAttributeView() de la classe Files en précisant
      le type de la vue souhaitée.

      Les informations de la vue basic peuvent aussi être obtenues en utilisant la classe Files :
      cependant l'utilisation de la vue permet d'obtenir toutes les informations avec un seul accès à l'élément du système d'exploitation.
    */
    try {
      testBasicFileAttributeView();
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*
     isRegularfile    true
     isDirectory      false
     isSymbolicLink   false
     isOther          false
     size             4069979
     creationTime     2019-03-13T14:30:04.280728Z
     lastAccesstime   2019-03-26T10:05:15.715046Z
     lastModifiedTime 2019-03-26T10:05:14.182Z
    */
  }
  public static void testBasicFileAttributeView() throws IOException {
    Path path = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    BasicFileAttributeView basicView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

    if (basicView != null) {
      BasicFileAttributes basic = basicView.readAttributes();

      System.out.println("isRegularfile    " + basic.isRegularFile());
      System.out.println("isDirectory      " + basic.isDirectory());
      System.out.println("isSymbolicLink   " + basic.isSymbolicLink());
      System.out.println("isOther          " + basic.isOther());
      System.out.println("size             " + basic.size());
      System.out.println("creationTime     " + basic.creationTime());
      System.out.println("lastAccesstime   " + basic.lastAccessTime());
      System.out.println("lastModifiedTime " + basic.lastModifiedTime());
    }

  }
}

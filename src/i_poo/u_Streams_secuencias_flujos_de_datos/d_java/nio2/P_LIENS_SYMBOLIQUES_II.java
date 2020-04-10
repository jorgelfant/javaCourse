package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P_LIENS_SYMBOLIQUES_II {
  public static void main(String[] args) throws IOException {
    //******************************************************************************************************************
    //                                  La création d'un lien symbolique
    //******************************************************************************************************************
    /*La méthode createSymbolicLink() de la classe Files permet de créer un lien symbolique. Le premier paramètre de
    type Path est le chemin du lien symbolique. Le second paramètre de type Path est le chemin vers le fichier ou
    le répertoire cible. Le paramètre de type varargs FileAttributes permet de préciser les options du lien qui seront
    utilisées lors de sa création.*/

    Path lien = Paths.get("/home/jm/monlien");
    Path cible = Paths.get("/home/jm/monfichier.txt");
    Files.createSymbolicLink(lien, cible);

    if (Files.isSameFile(lien, cible)) {
      System.out.println("Identique");
    } else {
      System.out.println("Non identique");
    }
  }
  //********************************************************************************************************************
  //                             METODO FUERA DEL MAIN
  //********************************************************************************************************************
   /*L'utilisation des liens symboliques est conditionnée par le fait que le système d'exploitation sous-jacent propose
    un support de ces liens. Si le système sous-jacent ne supporte pas les liens symboliques, une exception de type
    UnsupportedOperationException est levée lors de l'invocation de la méthode createSymbolicLink().

    Exemple sous Windows XP*/

  public static void testSymbolicLink() {
    Path newLink = Paths.get("C:/test_link");
    Path target = Paths.get("C:/Users/test");
    try {
      Files.createSymbolicLink(newLink, target);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (UnsupportedOperationException uoe) {
      // Le systeme de fichiers ne supporte pas les liens symboliques.
      uoe.printStackTrace();
    }
  }
  /*Le support des liens symboliques est aussi contrôlé par un SecurityManager en utilisant l'option
  LinkPermission("symbolic") : leur support est désactivé par défaut. Une exception de type SecurityException
  peut donc être levée si un SecurityManager est utilisé et que les droits adéquats ne sont pas activés.*/

  //********************************************************************************************************************
  //                             L'utilisation des liens et des liens symboliques
  //********************************************************************************************************************
  /*La méthode toRealPath() de l'interface Path permet de retourner un chemin dont les liens symboliques contenus
    dans le chemin sont résolus.

    La méthode isSymbolicLink() de l'interface Path permet de déterminer si l'élément précisé par le chemin est un
    lien symbolique ou non.

    La méthode readSymbolicLink() de la classe Files renvoie le chemin de la cible du lien symbolique ou lève une
    exception de type NotLinkException si l'élément dont le chemin fourni en paramètre n'est pas un lien symbolique.

    La suppression d'un lien se fait en utilisant la méthode delete() de la classe Files : dans ce cas, c'est le lien
    qui est supprimé et non le fichier cible.

    Certaines méthodes de la classe Files attendent en paramètre un varargs de type LinkOption. L'option
    LinkOption.NOFOLLOW_OPTIONS permet de demander de ne pas suivre les liens pour réaliser l'action demandée.*/
}

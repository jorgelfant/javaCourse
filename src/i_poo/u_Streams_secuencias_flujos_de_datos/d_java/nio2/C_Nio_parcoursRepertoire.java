package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;
//import javafx.scene.shape.Path;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class C_Nio_parcoursRepertoire {
  public static void main(String[] args) {
    //******************************************************************************************************************
    //                               Le parcours du contenu de répertoires
    //******************************************************************************************************************
    /*
    Les solutions proposées par NIO2 pour le parcours du contenu d'un répertoire remplacent avantageusement
    les méthodes list() et listfiles() de la classe java.io.File. Ces méthodes offraient de piètres performances
    notamment avec des répertoires contenant de nombreux fichiers et consommaient beaucoup de ressources.

    NIO2 propose plusieurs solutions pour parcourir le contenu d'un répertoire : elles sont plus complexes
    à mettre en oeuvre par rapport à la classe java.io.File mais sont aussi beaucoup plus performantes surtout
    avec des répertoires qui contiennent de nombreux fichiers.
    */

    //******************************************************************************************************************
    //                               Le parcours d'un répertoire
    //******************************************************************************************************************
    /*
    Il est possible d'utiliser une instance de l'interface java.A_nio.file.DirectoryStream qui permet de parcourir
    un répertoire en réalisant une itération sur les éléments qu'il contient.

    public interface DirectoryStream<T> extends Closeable, Iterable<T>

    An object to iterate over the entries in a directory. A directory stream allows for the convenient
    use of the for-each construct to iterate over a directory.

    La méthode newDirectoryStream() de la classe Files attend en paramètre un objet de type Path qui correspond
    au répertoire à parcourir et permet d'obtenir une instance de type DirectoryStream<Path>.

    La méthode iterator() retourne une instance d'un itérateur sur les éléments du répertoire : fichiers, liens, sous-répertoires, ...

    L'itération sur les éléments permet de meilleures performances et une consommation réduite en ressources pour
    obtenir les mêmes résultats que l'invocation des méthodes list() et listFiles() de la classe java.io.File.

    Attention : il est très important d'invoquer la méthode close() de l'instance de type DirectoryStream pour
    libérer les ressources utilisées.

    La classeFiles vous permet aussi de lister le contenu d'un répertoire mais via un objet DirectoryStream qui
    est un itérateur. Ceci évite de charger tous les fichiers en mémoire pour récupérer leurs informations.
    Voici comment procéder :
    */
    Path var = Paths.get("C:/Users/Jorge/Desktop/test2");
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(var)) {
      Iterator<Path> iterator = stream.iterator();//iterator() es un metodo de DirectoryStream<T>
      while (iterator.hasNext()) {
        Path p = iterator.next();
        System.out.println(p);//ou System.out.println(iterator.next());
      }
    } catch (IOException e) {//Files.newDirectoryStream(var) puede provocar una exception
      e.printStackTrace();
    }
    System.out.println();
    //imprimir( var);
    //imprimirBis( var);

    /*
     La classe Files vous permet aussi de lister le contenu d'un répertoire mais via un objet DirectoryStream qui
     est un itérateur. Ceci évite de charger tous les fichiers en mémoire pour récupérer leurs informations.
     Voici comment procéder :
     */
    //On récupère maintenant la liste des répertoires dans une collection typée
    //Via l'objet FileSystem qui représente le système de fichier de l'OS hébergeant la JVM
    Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
    //Maintenant, il ne nous reste plus qu'à parcourir
    for (Path chemin : roots) {
      System.out.println(chemin);
      try (DirectoryStream<Path> listing = Files.newDirectoryStream(chemin)) {
        int i = 0;
        for (Path nom : listing) {//C y D son linsting
          System.out.print("\t\t" + ((Files.isDirectory(nom)) ? nom + "/" : nom));
          i++;
          if (i % 4 == 0) System.out.println("\n");
        }
        System.out.println();//una vez que acaba con c da salto de linea y pasa a D
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  //********************************************************************************************************************
  //                                        IMPRIMIR CON RECURSIVIDAD fuera del main
  //********************************************************************************************************************
  public static void imprimir(Path var) throws IOException {//ingreso el Path es decir el chemin se imprimira o se hara una collection
    if (Files.isDirectory(var)) {         //DirectoryStream<Path>  con el metodo Files.newDirectoryStream(var)
      System.out.println(var.getFileName());
      DirectoryStream<Path> stream = Files.newDirectoryStream(var);
      Iterator<Path> iterator = stream.iterator();//iterator() es un metodo de DirectoryStream<T>
      while (iterator.hasNext()) {
        imprimir(iterator.next());
      }
    } else {
      System.out.println("  " + var.getFileName());
    }
  }
  //**************************************Con recursividad y for each***************************************************

  //no necesito hacer try catch adentro ya que en la funcion misma atrapo la exception
  public static void imprimirBis(Path chemin) throws IOException {//ingreso el Path es decir el chemin se imprimira o se hara una collection
    if (Files.isDirectory(chemin)) {         //DirectoryStream<Path>  con el metodo Files.newDirectoryStream(var)
      System.out.println(chemin.getFileName());
      DirectoryStream<Path> listing = Files.newDirectoryStream(chemin);
      for (Path nom : listing) {
        imprimirBis(nom);
      }
    } else {
      System.out.println("  " + chemin.getFileName());
    }
  }

}



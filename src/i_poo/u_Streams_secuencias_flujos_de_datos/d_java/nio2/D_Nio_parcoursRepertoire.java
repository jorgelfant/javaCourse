package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

//import javafx.scene.shape.Path;


import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

public class D_Nio_parcoursRepertoire {
  public static void main(String[] args) {
    /*
    Attention : l'implémentation de l'interface Iterable de l'instance de type DirectoryStream ne propose pas
    le support de la méthode remove() et son invocation lève une exception de type UnsupportedOperationException.

    L'interface DirectoryStream hérite des interfaces Closeable et Iterable. Il est donc pratique de
    déclarer l'instance de type DirectoryStream<Path> dans une instruction try avec ressources qui se
    chargera d'invoquer automatiquement sa méthode close(). Le parcours des éléments peut se faire dans
    une instruction for aussi.
    */
    Path var = Paths.get("C:/Users/Jorge/Desktop/test2");
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(var)) {
      Iterator<Path> iterator = stream.iterator();//iterator() es un metodo de DirectoryStream<T>
      while (iterator.hasNext()) {
        Path p = iterator.next();
        System.out.println(p);//ou System.out.println(iterator.next());
        // iterator.remove();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    //******************************************************************************************************************
    //                                            OU AVEC FOR
    //******************************************************************************************************************
    Path var2 = Paths.get("C:/Users/Jorge/Desktop/test2");
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(var2)) {
      for (Path entry : stream) {
        System.out.println(entry);
      }
    } catch (IOException | DirectoryIteratorException e) {
      e.printStackTrace();
    }
  }
}
// Si une exception est levée durant l'itération, alors elle est encapsulée dans une exception unchecked de
// type DirectoryIteratorException.

// Il est aussi possible de fournir un paramètre qui est une chaîne de caractères au format glob pour
// filtrer la liste des éléments retournés en fonction de leurs noms.

//Attention : il n'est possible de n'obtenir qu'un seul itérateur d'une même instance de type DirectoryStream.
// Une seconde invocation de la méthode iterator() lève une exception de type IllegalStateException.
//Iterator<Path> secondIterator = stream.iterator();

/*RESULTADO:
             C:\Users\Jorge\Desktop\test2\monRepetoire22
             C:\Users\Jorge\Desktop\test2\monRepetoire33
             C:\Users\Jorge\Desktop\test2\monRepetoireNuevo
             C:\Users\Jorge\Desktop\test2\schemes
*/

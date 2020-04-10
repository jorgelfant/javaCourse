package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class E_Nio_B_parcoursRepertoire_con_FILTRE {
  public static void main(String[] args) {
  /*
    Il est possible de définir un filtre qui sera appliqué sur chacun des éléments du répertoire pour déterminer
    s'il doit être retourné ou non lors du parcours.

    Pour cela, il faut créer une instance de type DirectoryStream.Filter<Path> et la fournir en paramètre à la
    méthode newDirectoryStream(). Le code du filtre doit se trouver dans la méthode accept() qui prend en paramètre
    un objet de type Path et renvoie un boolean qui est le résultat de l'application du filtre.
  */
    Path vari = Paths.get("C:/Users/Jorge/Desktop/MUSICA");
    //Filter es una "FunctionalInterface" estatica con un solo metodo "public static interface Filter<T>" entro de "DirectoryStream"
    DirectoryStream.Filter<Path> filtre = new DirectoryStream.Filter<Path>() {//clase anonima la abrimos pa desarrollar el metodo
      public static final long HUIT_MEGABYTES = 8 * 1024 * 1024;

      @Override
      public boolean accept(Path element) throws IOException {
        return Files.size(element) >= HUIT_MEGABYTES;//return true or false   osea puede ser una condicion
                   //size() pide path en argumento
      }
    };

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(vari, filtre)) {//(path , filtro)
      for (Path entry : stream) {
        System.out.println(entry);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
   /*elementos superiores a 8 mgbts
   C:\Users\Jorge\Desktop\MUSICA\Alan Walker - Faded.mp3
   C:\Users\Jorge\Desktop\MUSICA\Amir - J'ai Cherché.mp3
   C:\Users\Jorge\Desktop\MUSICA\Amistades Peligrosas - Me Quedaré Solo.mp3
   C:\Users\Jorge\Desktop\MUSICA\Tove Lo - Habits.mp3
   */
  }
}

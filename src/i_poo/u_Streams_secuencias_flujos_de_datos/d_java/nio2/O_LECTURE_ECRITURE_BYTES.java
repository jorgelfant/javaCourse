package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class O_LECTURE_ECRITURE_BYTES {
  public static void main(String[] args) {
    /*Les méthodes newInputStream() et newOutputStream() permettent d'obtenir une instance de type InputStream
    et une instance de type OutputStream sur le fichier dont le chemin est fourni en paramètre :

    Méthode                                                              Rôle
    ---------------------------------------------------------------------------------------------------------
    InputStream newInputStream(Path path, OpenOption... options)         Créer un objet de type InputStream

    OutputStream newOutputStream(Path path, OpenOption... options)       Créer un objet de type OutputStream

*/
    try {
      testNewInputStream();
    } catch (IOException e) {
      e.printStackTrace();
    }


    try {
      testNewOutputStream();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



  //********************************************************************************************************************
  //                                         NewInputStream()
  //********************************************************************************************************************
  /*Les méthodes newInputStream() et newOutputStream() attendent en paramètres un objet de type Path et un var args de type OpenOption.
    La méthode newInputStream() ouvre un fichier pour des lectures sans tampon. Elle retourne un objet de type InputStream. */

  public static void testNewInputStream() throws IOException {
    Path path = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try (InputStream in = Files.newInputStream(path);//InputStream<-----FileInputStream  hereda  //BufferedInputStream tb (a traves de FilterInputStream)
         BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {//Reader<----InputStreamReader <-----  de FileReader

      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException x) {
      System.err.println(x);
    }
  }
  //********************************************************************************************************************
  //                                         NewOutputStream()
  //********************************************************************************************************************
  /*La méthode newOutputStream() ouvre un fichier pour des écritures sans tampon. Elle retourne un objet de type OutputStream.
  Si aucun paramètre de type OpenOption n'est précisé, la méthode va utiliser les paramètres CREATE et TRUNCATE_EXISTING
  par défaut (créer le fichier s'il n'existe pas et le vider s'il existe).*/

  public static void testNewOutputStream() throws IOException {
    Path path = Paths.get("C:/Users/Jorge/Desktop/test2/nuevoTexto.txt");
    try (OutputStream out = Files.newOutputStream(path, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE)) {
      out.write('X');
    }
  }
}
/*
    ""public enum StandardOpenOption extends Enum<StandardOpenOption> implements OpenOption""

    L'énumération StandardOpenOption implémente l'interface OpenOption et définit les options d'ouverture
    standard d'un fichier :

    Enum constantes

    Valeur                                      Rôle
   -----------------------------------------------------------------------------
   APPEND                                       Si le fichier est ouvert en écriture alors les données sont ajoutées
                                                au fichier. Cette option doit être utilisée avec les options CREATE ou WRITE

   CREATE                                       Créer un nouveau fichier s'il n'existe pas sinon le fichier est ouvert

   CREATE_NEW                                   Créer un nouveau fichier : si le fichier existe déjà alors une exception
                                                est levée

   DELETE_ON_CLOSE                              Supprimer le fichier lorsque son flux associé est fermé : cette option
                                                est utile pour des fichiers temporaires

   DSYNC                                        Demander l'écriture synchronisée des données dans le système de
                                                stockage sous-jacent (pas d'utilisation des tampons du système)

   READ                                         Ouvrir le fichier en lecture

   SPARSE                                       Indiquer au système que le fichier est clairsemé ce qui peut lui
                                                permettre de réaliser certaines optimisations si l'option est supportée
                                                par le système de fichiers (c'est notamment le cas avec NTFS)

   SYNC                                         Demander l'écriture synchronisée des données et des métadonnées dans
                                                le système de stockage sous-jacent

   TRUNCATE_EXISTING                            Si le fichier existe et qu'il est ouvert en écriture alors il est vidé.
                                                Cette option doit être utilisée avec l'option WRITE

   WRITE                                        Ouvrir le fichier en écriture

   Ces options sont utilisables avec toutes les méthodes qui ouvrent des fichiers. Elles ne sont pas toutes
   mutuellement exclusives.
*/

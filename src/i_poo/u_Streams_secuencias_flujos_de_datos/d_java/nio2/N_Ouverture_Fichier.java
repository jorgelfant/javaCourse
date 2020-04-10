package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class N_Ouverture_Fichier {
  public static void main(String[] args) {
    /*
    Les options d'ouverture d'un fichier
    -----------------------------------

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

   //*******************************************************************************************************************
   //                       La lecture et l'écriture de l'intégralité d'un fichier
   //*******************************************************************************************************************

   La classe Files propose les méthodes readAllLines() et readAllBytes() qui renvoient respectivement une collection
   de type List<String> et un tableau d'octets contenant l'intégralité d'un fichier texte ou binaire.
   Bien sûr l'utilisation de ces méthodes est à réserver pour des fichiers de petites tailles.

   La méthode readAllLines() de la classe Files permet de lire l'intégralité d'un fichier et de renvoyer son contenu
   sous la forme d'une collection de chaînes de caractères.
    */
    //******************************************************************************************************************
    //                                               readAllLines()
    //******************************************************************************************************************

    List<String> lignes = null;
    try {
      lignes = Files.readAllLines(FileSystems.getDefault().getPath("C:/Users/Jorge/Desktop/dictionnaire.txt"), StandardCharsets.ISO_8859_1);
      for(String ligne:lignes){
        System.out.println(ligne);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    /*La méthode readAllLines() attend en paramètre un objet de type Path qui encapsule le chemin du fichier à lire
    et un objet de type Charset qui précise le jeu d'encodage de caractères du fichier. Elle s'occupe d'ouvrir le
    fichier, lire le contenu et fermer le flux.*/

    //******************************************************************************************************************
    //                                               readAllBytes()
    //******************************************************************************************************************

    /*La méthode readAllBytes() de la classe Files permet de lire l'intégralité d'un fichier et renvoyer son
      contenu sous la forme d'un tableau d'octets.*/

    Path file = FileSystems.getDefault().getPath("C:/Users/Jorge/Desktop/dictionnaire.txt");
    try {
      byte[] contenu = Files.readAllBytes(file);//me devuelve el fichier sous forme d'un tab de Bytes
      //Files.write(path, byte[], OpenOptions);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //******************************************************************************************************************
    //                                               write()
    //******************************************************************************************************************

    /*La méthode write() permet d'écrire le contenu d'un fichier. Elle possède deux surcharges :

      Path           write(Path path, byte[] bytes, OpenOption... options)
      Path           write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options) */


    final Path pathSource = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    final Path pathCible = Paths.get("C:/Users/Jorge/Desktop/test2/nuevoDico.txt");

    final List<String> ligness;
    try {
      ligness = Files.readAllLines(pathSource, Charset.forName("ISO_8859_1"));
      Files.write(pathCible, ligness, Charset.defaultCharset());
    } catch (IOException e) {
      e.printStackTrace();
    }
    //******************************************************************************************************************
    //                                               write()
    //******************************************************************************************************************
    final Path pathSourcee = Paths.get("c:/java/source.bin");
    final Path pathCiblee = Paths.get("c:/java/cible.bin");
    // lire et écrire tout le fichier
    final byte[] bytes;
    try {
      bytes = Files.readAllBytes(pathSource);
      Files.write(pathCible, bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}

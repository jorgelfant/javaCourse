package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P_LIENS_SYMBOLIQUES {
  public static void main(String[] args) throws IOException {
    //Les liens et les liens symboliques
    /*
    Il existe deux types de liens :

      .iens physiques (hard links) : ils permettent de faire référence à un élément physique du système
      de fichiers qui doit exister. Si le fichier cible est modifié alors le lien est aussi modifié.

      .iens symboliques (symbolic links) : ils permettent de faire référence à un autre élément du système de fichiers.
      Si l'élément cible est supprimé alors le lien existe toujours mais il est invalide.

    La classe Files propose deux méthodes pour créer des liens physiques et des liens symboliques.

    Méthode                                      Rôle
    --------------------------------------------------------------------------------------------------------------------
    Path                                         createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs)
                                                     Créer un lien symbolique vers un élément

    Path                                         createLink(Path link, Path existing)
                                                     Créer un lien physique

  //********************************************************************************************************************
  //                                 La création d'un lien physique
  //********************************************************************************************************************

  Les liens physiques (hard links) possèdent quelques restrictions :

      .le fichier cible doit exister
      .le fichier cible doit être sur la même partition
      .il possède les mêmes attributs que le fichier cible

  Pour créer un lien, il faut invoquer la méthode createLink() de la classe Files qui attend en paramètres
  deux objets de type Path : le premier est le chemin du lien, le second est le chemin du fichier cible qui
  s'il n'existe pas lèvera une exception de type NoSuchFileException.*/
  }
  //******************************************************************************************************************
  //                                 Methode hors du main
  // *****************************************************************************************************************
  public static void testCreateLink() throws IOException {
    Path lien = Paths.get("c:/java/test/monlien.lnk");
    Path cible = Paths.get("c:/java/test/monfichier.txt");

    Files.createLink(lien, cible);
  }

}

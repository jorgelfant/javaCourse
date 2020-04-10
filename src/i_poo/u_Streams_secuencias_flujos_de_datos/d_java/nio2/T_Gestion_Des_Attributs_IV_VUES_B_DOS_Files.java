package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class T_Gestion_Des_Attributs_IV_VUES_B_DOS_Files {
  public static void main(String[] args) {
    /*
    Il est aussi possible d'utiliser les méthodes getAttribute() et setAttribute() de la classe Files.
    L'inconvénient de ces méthodes est que l'attribut concerné est fourni sous la forme d'une chaîne de caractères.
    Celle-ci doit être composée du nom de la vue suivi du caractère deux points suivi du nom de l'attribut.
    */
    //*************************************************Atributos********************************************************
    try {
      testGetFileAttribute();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    //*****************************************Modificacion de atributos************************************************
    try {
      testSetFileAttribute();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //**************************************Atributos despues de modificarlo********************************************
    try {
      testGetFileAttribute();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println();
    //********************************************EXCEPTION*************************************************************
    try {
      testGetFileAttribute2();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  //********************************************************************************************************************
  //                                             Files.getAttribute
  //********************************************************************************************************************
  public static void testGetFileAttribute() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try {
      System.out.println("isReadOnly = " + Files.getAttribute(fichier,"dos:readonly", LinkOption.NOFOLLOW_LINKS));
      System.out.println("isHidden   = " + Files.getAttribute(fichier,"dos:hidden", LinkOption.NOFOLLOW_LINKS));
      System.out.println("isArchive  = " + Files.getAttribute(fichier,"dos:archive", LinkOption.NOFOLLOW_LINKS));
      System.out.println("isSystem   = " + Files.getAttribute(fichier,"dos:system", LinkOption.NOFOLLOW_LINKS));
    } catch (UnsupportedOperationException ueo) {
      ueo.printStackTrace();
    }
  }
  //********************************************************************************************************************
  //Si le nom de l'attribut fourni en paramètre n'est pas supporté alors une exception de type IllegalArgumentException
  //est levée.
  //********************************************************************************************************************
  public static void testGetFileAttribute2() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try {
      System.out.println("isReadOnly = " + Files.getAttribute(fichier,"dos:readolny", LinkOption.NOFOLLOW_LINKS));
    } catch (UnsupportedOperationException ueo) {
      ueo.printStackTrace();
    }
  }
  //********************************************************************************************************************
  //                                             setAttribute()
  //********************************************************************************************************************
  /*
  La méthode setAttribute() de la classe Files permet de modifier un attribut d'un élément du système de fichiers.
  */
  public static void testSetFileAttribute() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    try {
      Files.setAttribute(fichier,"dos:hidden", true);
    } catch (UnsupportedOperationException ueo) {
      ueo.printStackTrace();
    }
  }
}

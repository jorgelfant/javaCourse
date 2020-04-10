package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class T_Gestion_Des_Attributs_I_individuel {
  public static void main(String[] args) {
    /*Il est aussi possible d'avoir accès aux attributs grâce à 6 vues permettant de voir plus ou moins d'informations, à savoir :

      .BasicFileAttributeView :   permet un accès aux propriétés généralement communes à tous les systèmes de fichiers ;

      .DosFileAttributeView :     ajoute le support des attributs MS-DOS (readonly,hidden,system,archive) à l'objet ci-dessus ;

      .PosixFileAttributeView :   ajoute les permissions POSIX du monde Unix au premier objet cité ;

      .FileOwnerAttributeView :   permet de manipuler le propriétaire du fichier ;

      .AclFileAttributeView   :   permet de manipuler les droits d'accès au fichier ;

      .UserDefinedFileAttributeView: permet de définir des attributs personnalisés.

      //****************************************************************************************************************

      Les éléments d'un système de fichiers possèdent des métadonnées généralement nommées attributs : le type
      d'éléments (fichier, répertoire, lien), la taille, la date de création et de modification, les permissions
      d'utilisation, ... Le nombre de ces métadonnées et la façon dont elles sont gérées sont dépendants du système
      d'exploitation.

      NIO 2 permet de gérer les permissions sur les fichiers. Malheureusement, ces permissions sont dépendantes du
      système de fichiers sous-jacent. NIO 2 propose des classes dédiées pour chaque système de fichiers supporté qui
      sont regroupées dans le package java.nio.file.attribute.

      L'accès aux métadonnées a été enrichi avec NIO 2 : certains attributs de base sont accessibles par la classe
      Files d'autres sont accessibles au travers de vues.

      L'implémentation par défaut propose plusieurs vues pour les principaux types de système d'exploitation :

         .Basic : cette vue est commune à tous les systèmes d'exploitation
         .Dos : cette vue est dédiée aux systèmes d'exploitation Windows
         .Posix : cette vue est dédiée aux systèmes d'exploitation de type Unix like avec notamment une gestion sur
          des permissions adaptées à ce type de système

      Il est aussi possible qu'une implémentation spécifique soit fournie par un tiers ou encore, de développer sa
      propre implémentation.

      //****************************************************************************************************************
      //                                  La gestion individuelle des attributs
      //****************************************************************************************************************

       La classe Files propose plusieurs méthodes pour obtenir individuellement certains de ces attributs pour
       un élément dont le chemin est fourni en paramètre.


       Méthode                                                      Rôle
       -----------------------------------------------------------------------------------------------------------------
       boolean isDirectory(Path, LinkOption)                | Renvoyer un booléen qui précise si l'élément est un répertoire
       -----------------------------------------------------------------------------------------------------------------
       boolean isRegularFile(Path, LinkOption...)           | Renvoyer un booléen qui précise si l'élément est un fichier
       -----------------------------------------------------------------------------------------------------------------
       boolean isSymbolicLink(Path)                         | Renvoyer un booléen qui précise si l'élément est un lien symbolique
       -----------------------------------------------------------------------------------------------------------------
       boolean isHidden(Path)                               | Renvoyer un booléen qui précise si l'élément est caché
       -----------------------------------------------------------------------------------------------------------------
       FileTime getLastModifiedTime(Path, LinkOption...)    | Renvoyer la date/heure de dernière modification de l'élément
       -----------------------------------------------------------------------------------------------------------------
       Path setLastModifiedTime(Path, FileTime)             | Modifier la date de dernière modification de l'élément
       -----------------------------------------------------------------------------------------------------------------
       UserPrincipal getOwner(Path, LinkOption...)          | Renvoyer le propriétaire du fichier
       -----------------------------------------------------------------------------------------------------------------
       Path setOwner(Path, UserPrincipal)                   | Modifier le propriétaire du fichier
       -----------------------------------------------------------------------------------------------------------------
       Set<PosixFilePermission> getPosixFilePermissions(Path, LinkOption...) | Renvoyer les droits d'un élément d'un système de type Unix
       -----------------------------------------------------------------------------------------------------------------
       Path setPosixFilePermissions(Path, Set<PosixFilePermission>)      | Modifier les droits d'un élément d'un système de type Unix
       -----------------------------------------------------------------------------------------------------------------
       Object getAttribute(Path, String, LinkOption...)                  | Obtenir la valeur d'un attribut de l'élément
       -----------------------------------------------------------------------------------------------------------------
       Path setAttribute(Path, String, Object, LinkOption...)            | Modifier la valeur d'un attribut de l'élément
       -----------------------------------------------------------------------------------------------------------------
       boolean isExecutable()                                            | Renvoyer un booléen qui précise si l'élément peut être exécuté
       -----------------------------------------------------------------------------------------------------------------
       boolean isReadable()                                              | Renvoyer un booléen qui précise si l'élément peut être lu
       -----------------------------------------------------------------------------------------------------------------
       boolean isWritable()                                              | Renvoyer un booléen qui précise si l'élément peut être modifié
       -----------------------------------------------------------------------------------------------------------------
       long size(Path)                                                   | Renvoyer la taille en octets d'un fichier
       -----------------------------------------------------------------------------------------------------------------

       Il est possible d'utiliser la méthode getOwner(Path) de la classe Files pour obtenir un objet de type
       UserPrincipal qui encapsule le propriétaire du fichier.                                                        */
    try {
      testGetOwner();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //RESULTADO:  DESKTOP-99B7OTT\JORGE (User)
  }
  public static void testGetOwner() throws IOException {
    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    UserPrincipal owner = Files.getOwner(fichier);
    System.out.println(owner);
  }
}

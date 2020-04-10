package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T_Gestion_Des_Attributs_IV_VUES_C_Posix {
  public static void main(String[] args) throws IOException {
    /*
    La gestion des permissions de type Posix se fait sur trois niveaux : propriétaire, groupe et autres utilisateurs.

    Avant Java 7, la modification des attributs d'un fichier sur système POSIX devait se faire en utilisant la méthode
    System.exec() ou en invoquant une méthode native.

    Avec NIO 2, il faut utiliser les classes PosixFilePermission et PosixFilePermissions pour gérer les permissions
    des systèmes de fichiers respectant la norme POSIX.
    */

         Path monFichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
         Set<PosixFilePermission> filePermissions = PosixFilePermissions.fromString("rw-rw-r--");

         FileAttribute<Set<PosixFilePermission>> fileAttribute = PosixFilePermissions.asFileAttribute(filePermissions);

         Files.createFile(monFichier, fileAttribute);
    //******************************************************************************************************************
    /*Attention : les attributs réellement positionnés sur le fichier peuvent être différents en fonction de
    règles définies sur le système de fichiers comme par exemple l'utilisation d'un umask sous un système de type Unix.

    L'interface PosixFileAttributes qui hérite de l'interface BasicFileAttributes propose des méthodes pour obtenir le
    propriétaire, le groupe de l'élément du système de fichiers et les permissions.

    Méthode                                         Rôle
    --------------------------------------------------------------------------------------------------------------------
    UserPrincipal                                   owner()
                                                     Renvoyer le propriétaire

                                                    GroupPrincipal()
                                                     Renvoyer le groupe

    Set<PosixFilePermission>                        permissions()
                                                     Renvoyer les permissions de lecture/écriture/exécution du
                                                     propriétaire, du groupe et des autres                            */

    Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");

    PosixFileAttributes attrs = Files.readAttributes(fichier, PosixFileAttributes.class);
    UserPrincipal owner = attrs.owner();
    GroupPrincipal group = attrs.group();

    System.out.println("Le fichier appartient à " + owner + ":" + group);

   //*******************************************************************************************************************
    /*L'énumération PosixFilePermission contient des valeurs pour gérer les droits de lecture, écriture et exécution
      pour le propriétaire, le groupe et les autres : OWNER_READ, OWNER_WRITE, OWNER_EXECUTE, GROUP_READ, GROUP_WRITE,
      GROUP_EXECUTE, OTHERS_READ, OTHERS_WRITE, OTHERS_EXECUTE.

      Les permissions sont encapsulées dans une collection de type Set d'éléments de type PosixFilePermission.
      */

    PosixFilePermission[] permissionsArray = {PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE,
                                              PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_WRITE };

    Set<PosixFilePermission> newPermissions = new HashSet<>(Arrays.asList(permissionsArray));

    //******************************************************************************************************************
    //Les gestions des permissions peut se faire en manipulant directement la collection.
    Set<PosixFilePermission> permissions = attrs.permissions();
    permissions.add(PosixFilePermission.OTHERS_READ);
    permissions.remove(PosixFilePermission.GROUP_WRITE);
    Files.setPosixFilePermissions(fichier, permissions);

    //******************************************************************************************************************
    /*La classe Files propose la méthode getPosixFilePermissions(Path, LinkOption ...) qui renvoie une collection de
    type Set<PosixFilePermission> encapsulant les permissions de lecture/écriture/exécution du propriétaire, du groupe
    et des autres pour l'élément dont le chemin est fourni en paramètre.

    La classe PosixFilePermissions propose des méthodes pour faciliter la manipulation d'un ensemble de permissions.

    Méthode                                                     Rôle
    --------------------------------------------------------------------------------------------------------------------
    static FileAttribute<Set<PosixFilePermission>>              asFileAttribute(Set<PosixFilePermission> perms)
                                                                  Créer une instance de type FileAttribute qui encapsule
                                                                  l'ensemble des permissions fournies en paramètre

    static Set<PosixFilePermission>                             fromString(String perms)
                                                                  Renvoyer un ensemble de permissions à partir d'une
                                                                  chaîne de caractères au format rwxrwxrwx

    static String                                               toString(Set<PosixFilePermission> perms)
                                                                  Renvoyer une représentation de l'ensemble des
                                                                  permissions sous la forme d'une chaîne de caractères
                                                                  au format rwxrwxrwx
    */

    //La méthode toString() de la classe PosixFilePermissions renvoie une chaîne de caractères qui représente les permissions.

    Path fichiero = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    PosixFileAttributes attr = Files.readAttributes(fichiero, PosixFileAttributes.class);
    Set<PosixFilePermission> permission = attr.permissions();
    System.out.println(PosixFilePermissions.toString(permission));

    //Inversement, la méthode fromString() permet de renvoyer une collection de permissions à partir de leur
    // représentation sous la forme d'une chaîne de caractères.

    Path fichie = Paths.get("/home/jm/test.txt");
    Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-rw-rw-");
    FileAttribute<Set<PosixFilePermission>> att = PosixFilePermissions.asFileAttribute(perms);
    Files.createFile(fichie, att);

    // La méthode setPosixFilePermission(Path, Set<PosixFilePermission>) de la classe Files permet de modifier
    // les permissions sur un élément du système de fichiers dont le chemin est fourni en paramètre sous réserve
    // que les droits actuels sur le fichier le permettent.

    Set<PosixFilePermission> permi = PosixFilePermissions.fromString("rw-rw-r--");
    Files.setPosixFilePermissions(fichier, permi);

  }
}

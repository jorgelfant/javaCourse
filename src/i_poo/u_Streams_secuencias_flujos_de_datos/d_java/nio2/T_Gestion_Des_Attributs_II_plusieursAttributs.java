package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class T_Gestion_Des_Attributs_II_plusieursAttributs {
  public static void main(String[] args) {/*
    //******************************************************************************************************************
    //                                   La gestion de plusieurs attributs
    //******************************************************************************************************************
    Si l'application a besoin de plusieurs attributs d'un même élément, il est plus efficace d'utiliser une des
    surcharges de la méthode readAttributes() qui renvoie un objet encapsulant des attributs d'une même famille.
    Les performances peuvent être dégradées si le système de fichiers est consulté plusieurs fois pour obtenir
    des attributs.

                                                                     Méthode
    --------------------------------------------------------------------------------------------------------------------
    Map<String, Object>                                              readAttributes(Path, String, LinkOption...)
                                                                      	Renvoyer une collection d'attributs lus en une
                                                                      	seule opération

    <A extends BasicFileAttributes> A                                readAttributes(Path, Class<A>, LinkOption...)
                                                                        Renvoyer un objet qui encapsule les attributs
                                                                        lus en une seule opération. Le type de cet objet
                                                                        est précisé en paramètre



    //BasicFileAttributeView   permet un accès aux propriétés généralement communes à tous les systèmes de fichiers ;

    Pour obtenir une instance de type BasicFileAttributes, il faut invoquer la méthode readAttributes() de la
    classe Files en lui passant en paramètre le chemin du fichier et une instance de type Class pour la classe
    BasicFileAttributes. Il est aussi possible de préciser des options sous la forme d'un varargs de l'énumération
    de type LinkOption.

    La valeur LinkOption.NOFOLLOW_LINKS indique de ne pas suivre les liens symboliques.

    La méthode readAttributes() permet de lire en une seule opération plusieurs attributs encapsulés dans l'objet
    retourné lors de son invocation, ce qui est plus efficace que de lire ces attributs un par un.

    Les attributs creationTime, lastModifiedTime et lastAccessTime encapsulés dans la classe BasicFilesAttributes
    sont de type java.nio.file.attribute.FileTime qui encapsule un horodatage.                                        */

    //USAMOS EL METODO
    lectureBasicAttributs();
    /*REULTADO:
      creationTime     = 2019-03-13T14:30:04.280728Z
      lastAccessTime   = 2019-03-16T14:50:32.476631Z
      lastModifiedTime = 2019-03-11T18:34:03.523416Z
      isDirectory      = false
      isOther          = false
      isRegularFile    = true
      isSymbolicLink   = false
      size             = 4069979
      fileKey          = null                       */
  }
  //FUERA DEL MAIN
  public static void lectureBasicAttributs() {
    Path monFichier = Paths.get("C:/Users/Jorge/Desktop/test2/dictionnaire.txt");
    BasicFileAttributes basicAttrs;
    try {
      basicAttrs = Files.readAttributes(monFichier, BasicFileAttributes.class);//<A extends BasicFileAttributes> A       readAttributes(Path, Class<A>, LinkOption...)

      System.out.println("creationTime     = " + basicAttrs.creationTime());
      System.out.println("lastAccessTime   = " + basicAttrs.lastAccessTime());
      System.out.println("lastModifiedTime = " + basicAttrs.lastModifiedTime());
      System.out.println("isDirectory      = " + basicAttrs.isDirectory());
      System.out.println("isOther          = " + basicAttrs.isOther());
      System.out.println("isRegularFile    = " + basicAttrs.isRegularFile());
      System.out.println("isSymbolicLink   = " + basicAttrs.isSymbolicLink());
      System.out.println("size             = " + basicAttrs.size());
      System.out.println("fileKey          = " + basicAttrs.fileKey());
      /*OU OBTENER TOODOS LOS ATRIBUTOS SIN HACER VARIOS System.out.print, seria con un map , es decir con el 1er
        "Map<String, Object>                                           readAttributes(Path, String, LinkOption...)"
        Map f  = Files.readAttributes(monFichier, "*");
        System.out.println(f);                                                                                        */
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

}

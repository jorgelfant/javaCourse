package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class A_Nio_Path {
  public static void main(String[] args) {
        /*
        L'API NIO 2 a été développée sous la JSR 203 et a été ajoutée au JDK dans la version 7 de Java SE.
        NIO 2 est une API plus moderne et plus complète pour l'accès au système de fichiers. Son but est en
        partie de remplacer la classe File de la très ancienne API IO.

        NIO 2 propose d'étendre les fonctionnalités relatives aux entrées/sorties : l'utilisation du système de fichiers
        de manière facile et les lectures/écritures asynchrones.

        L'API FileSystem simplifie grandement la manipulation de fichiers et répertoires d'un système de fichiers
        et ajoute des fonctionnalités attendues depuis longtemps. La nouvelle API de gestion et d'accès au système de
        fichiers est contenue dans le package java.A_nio.file et ses sous-packages.

        L'une des grandes nouveautés de Java 7 réside dans NIO.2 avec un nouveau packagejava.A_nio.file en remplacement
        de la classejava.io.File. Voici un bref listing de quelques nouveautés :

          .une meilleure gestion des exceptions : la plupart des méthodes de la classe File se contentent de renvoyer
           une valeur nulle en cas de problème, avec ce nouveau package, des exceptions seront levées permettant de
           mieux cibler la cause du (ou des) problème(s) ;

          .un accès complet au système de fichiers (support des liens/liens symboliques, etc.) ;

          .l'ajout de méthodes utilitaires tels que le déplacement/la copie de fichier, la lecture/écriture binaire ou texte…

          .récupérer la liste des fichiers d'un répertoire via un flux ;

          .remplacement de la classejava.io.Filepar l'interfacejava.A_nio.file.Path.

          //************************************************************************************************************
          NIO2 est probablement l'API de Java 7 qui sera la plus utilisée par les développeurs tant elle facilite
          la mise en oeuvre de fonctionnalités courantes d'entrées/sorties sur un système de fichiers.
          //************************************************************************************************************

          L'API NIO 2 est une API plus moderne qui propose plusieurs caractéristiques :

          .la séparation des responsabilités : un chemin (Path) représente un élément du système de fichiers (FileSystem)
           stocké dans un système de stockage (FileStorage) et est manipulé en utilisant la classe Files

          .la gestion de toutes les erreurs se fait avec des exceptions

          .l'utilisation de fabriques permet de créer les différentes instances de l'API et de la rendre extensible

          La classe java.io.File n'est pas deprecated mais à partir de Java 7, il est recommandé d'utiliser les
          classes et interfaces de l'API NIO 2 dans la mesure du possible : ceci doit être le cas dans les nouveaux
          développements d'autant que, pour faciliter l'intégration dans le code existant, il existe des fonctionnalités
          pour convertir un objet de type File en un objet de type Path et vice versa.

          NIO 2 repose sur plusieurs classes et interfaces dont les principales sont :
          //************************************************************************************************************
          Path : encapsule un chemin dans le système de fichiers
          Files : contient des méthodes statiques pour manipuler les éléments du système de fichiers
          FileSystemProvider : service provider qui interagit avec le système de fichiers sous-jacent
          FileSystem : encapsule un système de fichiers
          FileSystems : fabrique qui permet de créer une instance de FileSystem

          Ces classes et interfaces sont regroupées dans le package java.A_nio.file et ses sous-packages :

          java.A_nio.file
          java.A_nio.file.attribute

          Les méthodes de l'interface Path permettent uniquement de manipuler les éléments qui composent le chemin :
          elles n'ont aucune action sur le système de fichiers sous-jacent du chemin.

          La classe FileStorage encapsule un système de stockage de fichiers. Elle permet d'obtenir des informations
          sur le système de stockage comme l'espace total ou l'espace libre. Une instance de type FileStorage est
          obtenue en invoquant la méthode Files.getFileStore() en lui passant en paramètre un objet de type Path
          encapsulant un élément du système de stockage.


          //************************************************************************************************************

          Je vous propose maintenant de jouer avec quelques nouveautés. Commençons par le commencement :
          ce qui finira par remplacer la classe File.

          Afin d'être le plus souple et complet possible, les développeurs de la plateforme ont créé une interface
          java.A_nio.file.Path dont le rôle est de récupérer et manipuler des chemins de fichiers de dossier et une une
          classejava.A_nio.file.Files qui contient tout un tas de méthodes qui simplifient certaines actions
          (copie, déplacement, etc.) et permet aussi de récupérer tout un tas d'informations sur un chemin.

          Le chemin peut concerner plusieurs types d'éléments :

           .Un fichier
           .Un répertoire
           .Un lien symbolique : permet de faire référence à un fichier ou un autre répertoire
           .Un sous-chemin

          Il n'est pas possible de créer une instance de type Path sans utiliser une fabrique ou un helper qui invoque une fabrique.
          Il existe plusieurs manières de créer un objet de type Path :

           .invoquer la méthode getPath() d'une instance de type FileSystem
           .invoquer la méthode Paths.get() qui invoque la méthode FileSystems.getDefault().getPath("ponemos el C:...")
           .invoquer la méthode toPath() sur un objet de type java.io.File

          La classe Paths est un helper qui permet de créer facilement des instances de type Path : c'est une fabrique
          proposant deux surcharges de sa méthode get() qui attendent respectivement en paramètres un nombre variable
          d'objets de type String qui sont les éléments du chemin ou une URI.

          L'interface Path propose plusieurs méthodes pour retrouver un élément particulier ou un sous-chemin composé
          de plusieurs éléments en utilisant les index.

          Afin d'illustrer ce nouveau mode de fonctionnement, je vous propose de reprendre le premier exemple de
          ce chapitre, celui qui affichait différentes informations sur notre fichier de test.
        */
    Path path = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    System.out.println("Chemin absolu du fichier : " + path.toAbsolutePath());
    System.out.println("Est-ce qu'il existe ? " + Files.exists(path));
    System.out.println("Nom du fichier : " + path.getFileName());
    System.out.println("Est-ce un répertoire ? " + Files.isDirectory(path));
    System.out.println();
    Path path2 = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    System.out.println("toString()     = " + path2.toString());//retourne le chemin C:\Users\Jorge\Desktop\dictionnaire.txt
    System.out.println("getFileName()  = " + path2.getFileName());//dictionnaire.txt
    System.out.println("getRoot()      = " + path2.getRoot());//C:\
    System.out.println("getName(0)     = " + path2.getName(0));//Users      C:\Users\Jorge\Desktop  ya que Users es 0 Jorge 1 etc
    System.out.println("getNameCount() = " + path2.getNameCount());//4   ya que hay 4 files en la ruta Users\Jorge\Desktop\dictionnaire
    System.out.println("getParent()    = " + path2.getParent());//C:\Users\Jorge\Desktop
    System.out.println("subpath(0,3)   = " + path2.subpath(0, 3));//Users\Jorge\Desktop
    //Le chemin peut aussi être relatif.
    System.out.println();
    Path path3 = Paths.get("Jorge/Desktop/dictionnaire.txt");
    System.out.println("toString()     = " + path3.toString());
    System.out.println("getFileName()  = " + path3.getFileName());//etc
    System.out.println();
    //Une instance de type Path implémente l'interface Iterator qui permet de réaliser une itération sur les éléments du chemin.
    for (Path name : path) {
      System.out.println(name);
    }
    System.out.println();
    //******************************************************************************************************************
    //L'interface Path propose plusieurs méthodes pour manipuler les chemins :
    //La méthode normalize() permet d'expliciter un chemin en éliminant les éléments comme « . » et « .. »
    Path path4 = Paths.get("C:/Users/Jorge/Desktop/./dictionnaire.txt");
    System.out.println("normalize()   = " + path4.normalize());

    path4 = Paths.get("C:/Users/Jorge/Desktop/  ./../dictionnaire.txt");
    System.out.println("normalize()   = " + path4.normalize());
    System.out.println();
    //daria:
    /*
       normalize()   = C:\Users\jm\AppData\Local\Temp\monfichier.txt
       normalize()   = C:\Users\jm\AppData\Local\Temp\monfichier.txt
    */
    //La méthode normalize() effectue une opération purement syntaxique : elle ne vérifie pas dans le système
    // de fichiers le chemin qu'elle produit.
    //******************************************************************************************************************

    // La méthode resolve() permet de combiner deux chemins. Elle attend en paramètre un chemin partiel qui ne doit pas
    // commencer par un élément racine du système de fichiers. Si le chemin fourni en paramètre contient un élément racine,
    // alors la méthode resolve() renvoie le chemin fourni en paramètre.

    Path patho = Paths.get("C:/Users/Jorge/");
    Path nouveauPatho = patho.resolve("Desktop/dictionnaire.txt");
    System.out.println(nouveauPatho);
    nouveauPatho = path.resolve("C:/Temp");
    System.out.println(nouveauPatho);

    System.out.println();
    //daria:
    /*
       "C:/Users/Jorge/Desktop/./dictionnaire.txt"
       C:\Temp
    */
    //******************************************************************************************************************

    //La méthode Path.relativize() permet d'obtenir le chemin relatif à celui encapsulé dans l'instance de type Path.
    // Ceci permet de définir le chemin relatif entre deux Path du système de fichiers.
    //La méthode relativize() effectue l'inverse de la méthode resolve() : elle ajoute au besoin dans le chemin
    // qu'elle renvoie des éléments ./ ou ../

     /*
    Path path5 = Paths.get("C:/Users/jm");
    Path path6 = Paths.get("C:/Users/test");
    Path path1VersPath2 = path5.relativize(path6);
    System.out.println(path1VersPath2);
    Path path2VersPath1 = path6.relativize(path5);
    System.out.println(path2VersPath1);

    resultado:
       ..\test
       ..\jm

     Dans cet exemple, les deux chemins ont le même répertoire père : le résultat de l'invocation de la méthode
     relativize() renvoie simplement un chemin qui remonte au répertoire père et descend au répertoire cible.

      Path path1 = Paths.get("C:/");
      Path path2 = Paths.get("C:/Users/test");
      Path path1VersPath2 = path1.relativize(path2);
      System.out.println(path1VersPath2);
      Path path2VersPath1 = path2.relativize(path1);
      System.out.println(path2VersPath1);

      resultado:

      Users\test
      ..\..


      Une exception est levée si un chemin relatif et un chemin absolu sont utilisés lors de l'invocation de la méthode relativize().

      Path path1 = Paths.get("test");
      Path path2 = Paths.get("C:/Users/test");
      Path path1VersPath2 = path1.relativize(path2);
      System.out.println(path1VersPath2);
      Path path2VersPath1 = path2.relativize(path1);
      System.out.println(path2VersPath1);

      Exception in thread "main" java.lang.IllegalArgumentException: 'other' is different type of Path
    */

    //******************************************************************************************************************
    //La comparaison de chemins

    /*
    Une instance de type Path redéfinit la méthode equals() pour permettre de tester l'égalité de l'instance avec une autre instance.
    L'interface Path hérite de l'interface Comparable, ce qui permet de trier des objets de type Path.
    L'interface Path propose également des méthodes permettant de comparer le début ou la fin de deux chemins

    Attention : une instance de type Path est dépendante du système de fichiers : il n'est donc pas possible de
    comparer deux instances de type Path associées à deux systèmes de fichiers différents.

    L'interface Path propose les méthodes startsWith() et endsWith() qui permettent respectivement de tester
    si le chemin commence ou se termine par la chaîne de caractères fournie en paramètre.

    */
    Path patho1 = Paths.get("C:/Users/Jorge");
    Path patho2 = Paths.get("C:/");

    System.out.println(patho1.startsWith("C:/"));
    System.out.println(patho1.startsWith("C:/Users"));
    System.out.println(patho1.startsWith(patho2));
    System.out.println(patho1.startsWith("C:"));
    System.out.println(patho1.startsWith("Users"));
    System.out.println(patho1.startsWith("/Users"));
    System.out.println();
   /*
   da:
    true
    true
    true
    false
    false
    false
   */
    //******************************************************************************************************************
    //La méthode Path.toAbsolutePath() permet d'obtenir le chemin absolu du chemin encapsulé dans l'instance de type Path.
    //La méthode toRealPath() renvoie un chemin dans lequel les liens symboliques du chemin fourni en paramètre ont été
    // résolus par rapport au système de fichiers.

    path = Paths.get("C:/Users/Jorge/Desktop/dictionnaire.txt");
    System.out.println("toUri()          = " + path.toUri());//conduce al archivo abriendolo en eclipse o idea
    path = Paths.get("src/dictionnaire.txt");
    System.out.println("toAbsolutePath() = " + path.toAbsolutePath());
    System.out.println();
    /*
    Da:
      toUri()          = file:///C:/Users/Jorge/Desktop/dictionnaire.txt
      toAbsolutePath() = C:\Users\JORGE\Desktop\NEW_WEB_TUTORIAL\3.COURS DE JAVA\CoursDeJava\dictionnaire.txt
    */


  }
}

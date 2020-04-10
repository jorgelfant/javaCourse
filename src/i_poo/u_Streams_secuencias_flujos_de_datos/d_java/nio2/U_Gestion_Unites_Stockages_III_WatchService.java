package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;

public class U_Gestion_Unites_Stockages_III_WatchService {
  public static void main(String[] args) throws IOException {
    //******************************************************************************************************************
    //                          La surveillance d'un répertoire
    //******************************************************************************************************************
    /*L'implémentation de la classe WatchService s'appuie généralement sur le mécanisme d'événements sous-jacent
      du système d'exploitation (ChangeNotification sous Windows, inotify sous Linux, FSEvents sous Mac OS X).
      Si un tel mécanisme n'existe pas alors l'implémentation va utiliser un mécanisme de polling. Dans tous les cas,
      cette implémentation est spécifique à chaque JVM et système d'exploitation.

      Pour obtenir une instance de type WatchService, il faut invoquer la méthode newWatchService() de la classe FileSystem.*/
                      //da un FileSystem que usa su metodo newWatchService()
      WatchService watcher = FileSystems.getDefault().newWatchService();

    /*Un objet de type WatchService peut s'utiliser sur un objet qui implémente l'interface Watchable. L'interface
      Path hérite de l'interface Watchable. L'interface Watchable définit deux surcharges de la méthode register()
      qui attendent en paramètre une instance de type WatchService et les types d'événements qui doivent être capturés.

      Il faut donc créer une instance de type Path qui encapsule le chemin du répertoire que l'on souhaite surveiller.
      La surveillance d'un répertoire se fait en enregistrant l'objet de type WatchService auprès de l'objet de type
      Path qui encapsule le chemin du répertoire.                                                                     */

    final Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2");
                   //path herite de watchable et peut donc utiliser ses methodes (register por ejemplo)
    WatchKey key = fichier.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                                    StandardWatchEventKinds.ENTRY_MODIFY);

    /*La méthode register() attend en paramètre un objet de type WatchService et un ensemble de varargs de type
      WatchEvent.Kind qui permet de préciser les types d'événements à revecoir. La méthode register() attend donc
      en paramètre l'instance de type WatchService et accepte plusieurs types événements définis dans la classe
      java.nio.file.StandardWatchEventKinds.

      Les types d'événements concernant les modifications dans un répertoire sont définis dans la classe
      StandardWatchEventKinds sous la forme de champs statiques de type WatchEvent.Kind<Path>.

      -----------------------------------------------------------------------------------------------------------------

      WatchEvent.Kind<Path>                                    ENTRY_CREATE
                                                                un nouvel élément est créé ou renommé dans le répertoire

      WatchEvent.Kind<Path>                                    ENTRY_MODIFY
                                                                 un élément du répertoire est modifié

      WatchEvent.Kind<Path>                                    ENTRY_DELETE
                                                                 un élément du répertoire est supprimé ou renommé.
                                                                 Les modifications/suppressions du répertoire lui-même
                                                                 ne sont pas concernées

      WatchEvent.Kind<Object>                                  OVERFLOW
                                                                 indique qu'un ou plusieurs événements peuvent avoir
                                                                 été perdus ou manqués

     -------------------------------------------------------------------------------------------------------------------

     Lors de l'enregistrement d'un répertoire, il faut préciser les types d'événements auxquels on souhaite s'abonner.
     Les événements de type OVERFLOW sont reçus automatiquement : il n'est pas nécessaire de préciser le type OVERFLOW
     lors de l'enregistrement.

     La méthode register() renvoie un objet de type WatchKey qui encapsule l'enregistrement du chemin avec l'objet de
     type WatchService.

     L'interface WatchKey définit les méthodes d'un jeton qui représente l'enregistrement d'un objet WatchService sur
     un objet de type Watchable.

     Un objet de type WatchKey reste valide jusqu'à ce que :

           .Il soit annulé en invoquant sa méthode cancel()
           .L'objet de type Watchable n'existe plus
           .La méthode close() de l'objet WatchService() est invoquée

     Un objet de type WatchKey possède un état qui peut prendre plusieurs valeurs :

           .ready : l'objet peut recevoir de nouveaux événements. C'est l'état de l'objet lors de sa création
           .signaled : l'objet possède un ou plusieurs événements à traiter. Pour revenir à l'état ready, il faut
            invoquer la méthode reset()
           .invalid : l'objet n'est plus actif. Cet état est obtenu en invoquant sa méthode cancel(), en invoquant
            la méthode close() de l'objet de type WatchService ou si le répertoire n'est plus accessible

     Un objet de type WatchKey encapsule le résultat de l'enregistrement du WatchService sur l'objet de type Path.

     Après l'enregistrement, l'objet de type WatchKey est dans l'état ready et y reste jusqu'à ce que :

           .la méthode cancel() de l'objet WatchKey soit invoquée
           .la méthode close() de l'objet WatchService soit invoquée
           .le répertoire n'est plus accessible

     Les objets de type WatchKey sont thread-safe.

     Pour arrêter l'émission des événements, il faut invoquer la méthode cancel() de la classe WatchKey ou la méthode
     close() de la classe WatchService.

     La méthode watchable() de la classe WatchKey renvoie un objet de type Path qui encapsule le chemin du répertoire
     sur lequel l'abonnement aux notifications a été réalisé.






    */


  }
}

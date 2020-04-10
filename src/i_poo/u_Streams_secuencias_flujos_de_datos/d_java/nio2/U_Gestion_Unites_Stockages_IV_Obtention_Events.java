package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class U_Gestion_Unites_Stockages_IV_Obtention_Events {
  public static void main(String[] args) throws IOException {
    //******************************************************************************************************************
    //                                     L'obtention des événements
    //******************************************************************************************************************
    /*La réception des événements ne se fait pas par un mécanisme asynchrone comme enregistrer un callback de type
      listener : il est nécessaire de créer son propre polling pour obtenir les événements.

      Le traitement des événements doit ainsi se faire dans un thread dédié pour ne pas bloquer le thread courant.

      Lorsqu'un changement est détecté, l'état de l'objet WatchKey passe à signaled. Pour obtenir le ou les événements
      non traités liés à ces changements, il faut invoquer la méthode poll() ou take() de l'objet WatchService :

      Méthode                                                Role
      ------------------------------------------------------------------------------------------------------------------
      poll()                                                 Retourne le prochain WatchKey ou null si aucun n'est présent

      poll(long timeout, TimeUnit unit)                      Retourne le prochain WatchKey en attendant le temps fourni
                                                             en paramètre sous la forme d'une durée et d'une unité sinon
                                                             retourne null

      take()                                                 Retourne le prochain WatchKey en attendant indéfiniment
                                                             jusqu'à ce qu'un ou plusieurs événements soient disponibles

      Il faut utiliser une boucle qui invoque l'une de ces méthodes pour obtenir les événements à traiter.

                                          while(true) {

                                              WatchKey key = watcher.take();

                                              // ...

                                           }

      Si un changement est détecté dans un ou plusieurs éléments du répertoire, alors l'état de l'instance du WatchKey
      passe à « signaled » et l'événement est mis dans une queue pour traitement.

         */
    WatchService watcher = FileSystems.getDefault().newWatchService();
    //final Path fichier = Paths.get("C:/Users/Jorge/Desktop/test2");
    WatchKey key;
    boolean running = true;
    // ...
    while (running) {
      try {
        // key = watcher.take();
        key = watcher.poll(1000, TimeUnit.MILLISECONDS);
        if (key != null) {
          for (final WatchEvent<?> event : key.pollEvents()) {// key.pollEvents() = List<WatchEvent< ?>>
            final Path name = (Path) event.context();//context() da el path el chemin
            System.out.format(event.kind() + " " + "%s\n", name);
          }
          key.reset();
        }
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
    }
    /*
    La méthode pollEvents() de l'interface WatchKey permet d'obtenir tous les événements qui sont stockés dans l'objet.

    Il est important d'invoquer la méthode reset() de l'interface WatchKey pour permettre de remettre son état à ready :
    elle renvoie un booléen qui précise si l'objet de type WatchKey est toujours valide et actif. L'invocation de la
    méthode reset() sur un objet de type WatchKey annulé ou déjà dans l'état ready n'a aucun effet.

    Attention : lorsqu'un événement est reçu, il n'y a aucune garantie que l'opération qui est à l'orgine de l'événement
    soit terminée.
    */

  }
}

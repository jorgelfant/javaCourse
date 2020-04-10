package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardCopyOption.*;

public class U_Gestion_Unites_Stockages_VI_ExempleComplet {
  public static void main(String[] args) {
    //Cette section propose un exemple complet de mise en oeuvre de l'API WatchService.

    final Path source = Paths.get("C:/Users/Jorge/Desktop/test2/hola.txt");
    final Path copie = Paths.get("C:/Users/Jorge/Desktop/test2/hola_copie.txt");
    final Path renomme = Paths.get("C:/Users/Jorge/Desktop/test2/hola_nouveau.txt");

    final MonWatcher monWatcher = new MonWatcher();//la clase monWatcher hereda de Thread
    monWatcher.start();//este metodo es heredado de Thread, creo que este metodo tiene dentro el metodo run() que reescribimos
    //a partir de aqui se producen los cambios
    try {
      Thread.sleep(1000);
      System.out.println("Copie " + source + " -> " + copie);
      Files.copy(source, copie, REPLACE_EXISTING, COPY_ATTRIBUTES);

      Thread.sleep(2000);
      System.out.println("Deplacement " + copie + " -> " + renomme);
      Files.move(copie, renomme, REPLACE_EXISTING, ATOMIC_MOVE);

      Thread.sleep(2000);
      System.out.println("Supression fichier " + renomme);
      Files.deleteIfExists(renomme);

      Thread.sleep(5000);
    } catch (final IOException | InterruptedException ioe) {
      ioe.printStackTrace();
    }
    //aqui terminan
    monWatcher.setRunning(false);
  }
}
/*RESULTADO
       Copie C:\Users\Jorge\Desktop\test2\hola.txt -> C:\Users\Jorge\Desktop\test2\hola_copie.txt
       ENTRY_CREATE hola_copie.txt
       ENTRY_MODIFY hola_copie.txt
       Deplacement C:\Users\Jorge\Desktop\test2\hola_copie.txt -> C:\Users\Jorge\Desktop\test2\hola_nouveau.txt
       ENTRY_DELETE hola_copie.txt
       ENTRY_CREATE hola_nouveau.txt
       Supression fichier C:\Users\Jorge\Desktop\test2\hola_nouveau.txt
       ENTRY_DELETE hola_nouveau.txt
*/

//**********************************************************************************************************************
//                                              CLASE HORS MAIN
//**********************************************************************************************************************
class MonWatcher extends Thread {

  private boolean running = true;

  public boolean isRunning() {
    return running;
  }

  public void setRunning(final boolean running) {
    this.running = running;
  }

  @Override
  public void run() {//Overrides method en Thread
    WatchService watcher;
    try {
      watcher = FileSystems.getDefault().newWatchService();
      final Path dir = Paths.get("C:/Users/Jorge/Desktop/test2");//"c:/java/test"

      WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                                           StandardWatchEventKinds.ENTRY_MODIFY);
      while (running) {
        try {
          // key = watcher.take();
          key = watcher.poll(1000, TimeUnit.MILLISECONDS);//Retrieves and removes the next watch key,
        } catch (final InterruptedException e) {                 //waiting if necessary up to the specified wait time if none are yet present.
          e.printStackTrace();
        }

        if (key != null) {
          for (final WatchEvent<?> event : key.pollEvents()) {
            final Path name = (Path) event.context();
            System.out.format(event.kind() + " " + "%s\n", name);
          }
          boolean reset = key.reset();//para que vuelva al estado ready y siga vigilando futuros cambios eventos
          if (!reset) {
            running = false;
          }
        }
      }
    } catch (final IOException ioe) {
      ioe.printStackTrace();
    }
  }
}
/***********************************************************************************************************************
 //*********************************************************************************************************************
 //                          L'utilisation et les limites de l'API WatchService
 //*********************************************************************************************************************

 L'API WatchService permet d'être notifié des changements qui surviennent sur les éléments d'une entité, par exemple
 sur un répertoire d'un système de fichiers.

 Cette fonctionnalité est intéressante mais elle présente quelques limites qu'il est important de connaitre :

 .Aucun événements n'est émis concernant les sous-répertoires du répertoire observé : dans ce cas, il faut parcourir
 les sous-répertoires et enregistrer un objet de type WatchService sur chacun d'entre-eux.

 .Les performances et l'ordre des événements sont dépendants de l'implémentation.

 .Lorsqu'un evénement est reçu, il n'y a pas de garantie que les traitements à l'origine de l'événement soient terminés.

 OSEA QUE HABRIA QUE HACERLO RECURSIVAMENTE
 */

package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

import java.io.IOException;
import java.nio.file.*;

public class U_Gestion_Unites_Stockages_VI_ExempleComplet_II {
  public static void main(String[] args) throws IOException, InterruptedException {
    WatchService watchService = FileSystems.getDefault().newWatchService();

    Path path = Paths.get(System.getProperty("user.home"));

    path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
      StandardWatchEventKinds.ENTRY_MODIFY);

    WatchKey key;
    while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event : key.pollEvents()) {
        System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
      }
      key.reset();
    }
    /*
    Et c’est tout ce que nous devons vraiment faire. Vous pouvez maintenant lancer le cours pour commencer à regarder
    un répertoire.

      Lorsque vous accédez au répertoire de base de l’utilisateur et effectuez une opération de manipulation de fichier,
      telle que la création d’un fichier ou d’un répertoire, la modification du contenu d’un fichier ou même la
      suppression d’un fichier, tout sera consigné sur la console.

      Par exemple, si vous accédez à la page d’accueil de l’utilisateur, cliquez avec le bouton droit de la souris sur
      l’espace, sélectionnez ` _new → file` pour créer un nouveau fichier, puis nommez-le testFile_ .

      Ensuite, vous ajoutez du contenu et enregistrez. La sortie sur la console ressemblera à ceci:

      Event kind:ENTRY__CREATE. File affected: New Text Document.txt.
      Event kind:ENTRY__DELETE. File affected: New Text Document.txt.
      Event kind:ENTRY__CREATE. File affected: testFile.txt.
      Event kind:ENTRY__MODIFY. File affected: testFile.txt.
      Event kind:ENTRY__MODIFY. File affected: testFile.txt.

      N’hésitez pas à modifier le chemin pour qu’il pointe vers le répertoire que vous souhaitez regarder.
    */
  }
}

/*
//**********************************************************************************************************************
//                                                 La WatchKey
//**********************************************************************************************************************
 Cette classe représente l’enregistrement d’un répertoire avec le service de surveillance. Son instance nous est
 renvoyée par le service de surveillance lorsque nous enregistrons un répertoire et lorsque nous lui demandons si
 des événements pour lesquels nous nous sommes enregistrés se sont produits.

Le service de surveillance ne nous propose aucune méthode de rappel qui est appelée chaque fois qu’un événement se
produit. Nous ne pouvons l’interroger que de différentes manières pour trouver cette information.

*****Nous pouvons utiliser l’API poll :

     WatchKey watchKey = watchService.poll();
     Cet appel d’API revient immédiatement. Il renvoie la clé de surveillance suivante en file d’attente dont l’un des
     événements s’est produit ou la valeur null si aucun événement enregistré ne s’est produit.

*****Nous pouvons également utiliser une version surchargée qui prend un argument timeout :

     WatchKey watchKey = watchService.poll(long timeout, TimeUnit units);
     Cet appel d’API est similaire au précédent en valeur de retour. Cependant, il bloque pendant timeout les unités
     de temps pour donner plus de temps pendant lequel un événement peut se produire au lieu de renvoyer la valeur null
     immédiatement.

*****Enfin, nous pouvons utiliser l’API take :

     WatchKey watchKey = watchService.take();
     Cette dernière approche bloque simplement jusqu’à ce qu’un événement se produise.

Nous devons noter quelque chose de très important ici: lorsque l’instance WatchKey est renvoyée par l’une des API
poll ou take , elle ne capturera plus d’événements si son API de réinitialisation n’est pas appelée:

******watchKey.reset();
Cela signifie que l’instance de clé de surveillance est supprimée de la file d’attente du service de surveillance
chaque fois qu’elle est renvoyée par une opération d’interrogation. L’appel d’API reset le remet en file d’attente
pour attendre d’autres événements.



L’application la plus pratique du service d’observation nécessiterait une boucle au sein de laquelle nous vérifions
en permanence les modifications apportées au répertoire surveillé et procédons en conséquence. Nous pouvons utiliser
l’idiome suivant pour implémenter ceci:


                                WatchKey key;
                                while ((key = watchService.take()) != null) {
                                    for (WatchEvent<?> event : key.pollEvents()) {
                                       //process
                                    }
                                    key.reset();
                                }


Nous créons une clé de surveillance pour stocker la valeur de retour de l’opération d’interrogation.

La boucle while restera bloquée jusqu’au retour de l’instruction conditionnelle avec une clé watch ou null.

Lorsque nous obtenons une clé de surveillance, la boucle while exécute le code qu’il contient. Nous utilisons
l’API WatchKey.pollEvents pour renvoyer une liste des événements survenus. Nous utilisons ensuite une boucle
for each pour les traiter un par un.

Une fois tous les événements traités, nous devons appeler l’API reset pour remettre la clé de surveillance
en file d’attente.
 */

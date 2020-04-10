package i_poo.u_Streams_secuencias_flujos_de_datos.d_java.nio2;

public class U_Gestion_Unites_Stockages_V_Traitement_Events {
  public static void main(String[] args) {
    /*
    Le ou les événements sont encapsulés dans un objet qui implémente l'interface WatchKey. Pour obtenir les événements,
    il faut invoquer la méthode pollEvents() de la classe WatchKey qui renvoie une collection de type List<WatchEvent< ?>>.
    Cette méthode supprime de l'objet WatchKey les événements qu'elle renvoie.

    Il faut itérer sur les éléments de la collection pour traiter chacun des événements encapsulés.

    Un objet de type WatchEvent<?> est typé avec un type qui sera utilisé comme contexte de l'événement.
    */

/*-----------------------------------------------------------------------------------
                               WatchEvent<Path> evenement = (WatchEvent<Path>) event;
                               Path chemin = evenement.context();
                   ---------------------------------------------------------------------------------------------------*/

    /*Un événement obtenu par un objet de type WatchService est encapsulé dans un objet qui implémente l'interface
    WatchEvent<T> qui possède trois méthodes :

    Méthode                                                   Role
    --------------------------------------------------------------------------------------------------------------------
    T                                                         context()
                                                               Renvoyer le contexte de l'événement

    int                                                       count()
                                                                Retourner le nombre d'occurences de l'événement

    WatchEvent.Kind<T> kind                                   Renvoyer le type de l'événement
    --------------------------------------------------------------------------------------------------------------------

    Pour chaque événement à traiter, il est possible de connaître :

        .le type de l'événement en invoquant la méthode kind() de l'objet de type WatchEvent

        .en invoquant la méthode context() de l'objet de type WatchEvent, le chemin relatif au répertoire enregistré
         qui est encapsulé dans le Path sur lequel l'événement (création, suppression ou mise à jour) a eu lieu

        .le chemin du répertoire concerné (c'est notamment pratique si plusieurs répertoires ont été enregistrés) en
         invoquant la méthode watchable() de l'objet de type WatchKey

    La méthode kind() permet d'obtenir le type de l'événement sous la forme d'une interface de type WatchEvent.Kind<T>.

    La méthode count() permet de savoir combien de fois l'événement a été émis.

    La méthode context() permet de renvoyer un objet qui encapsule le contexte associé à l'événement.

    */

   /*-------------------------------------------------------------------------------
                               for (final WatchEvent<?> event : key.pollEvents()) {
                                 final Path name = (Path) event.context();
                                 System.out.format(event.kind() + " " + "%s\n", name);
                               }
                               key.reset();

                               --------------------------------------------------------------------------------------*/

    /*Attention : une fois que les événements ont été traités, il est important de remettre l'objet de type WatchKey
    dans l'état ready en invoquant sa méthode reset(). Si la méthode reset() renvoie false, alors l'objet de type
    WatchKey n'est plus valide et il faut donc interrompre les traitements d'écoute des événements.*/
  }
}

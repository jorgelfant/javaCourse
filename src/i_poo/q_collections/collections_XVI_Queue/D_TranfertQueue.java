package i_poo.q_collections.collections_XVI_Queue;

public class D_TranfertQueue {
    public static void main(String[] args) {
        //INTERFACE TransferQueue<E>
        //Cette interface et son implémentation n'existent que depuis Java 7 !

        //Comme vous vous en doutez, cette dernière est faite pour travailler en environnement multithread.
        // La nouveauté rajoutée revient à bloquer l'ajout d'un élément jusqu'à ce que celui-ci soit utilisé
        // par un autre thread. Elle ajoute donc quelques méthodes qui permettent cette gestion, voici un
        // tableau récapitulatif :

        /*
        Méthode                                            |   Definition
        ----------------------------------------------------------------------------------------------------------------
                                                           | Transfère l'élément à un thread consommateur en attente de
        transfer(E e)                                      | cet élément, ou si aucun thread n'attend, attend qu'un
                                                           | thread réclame l'élément.
        ----------------------------------------------------------------------------------------------------------------
                                                           | Cette méthode n'attend pas qu'un thread veuille récupérer
         tryTransfer(E e)                                  | l'élément et retournera true si un thread attend et
                                                           | false dans le cas contraire.
        ----------------------------------------------------------------------------------------------------------------
                                                           | Tente d'envoyer l'élément immédiatement à un thread s'il
         tryTransfer(E e,long timeout, TimeUnit unit)      | en existe un qui attend. Dans le cas contraire, la méthode
                                                           | ne renverra false  que s'il n'y a toujours pas de thread
                                                           | attendant la valeur au bout de la durée spécifiée en paramètre.
        ----------------------------------------------------------------------------------------------------------------

        Cette interface définit un comportement très proche de l'objet SynchronousQueue<E> ...

        Tout à fait. Le mode opératoire est le même mais cette collection est plus souple d'utilisation :
        vous avez le choix d'attendre un thread consommateur ou non.

        */

    }
}

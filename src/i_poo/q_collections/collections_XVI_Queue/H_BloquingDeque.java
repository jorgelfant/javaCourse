package i_poo.q_collections.collections_XVI_Queue;

public class H_BloquingDeque {
    public static void main(String[] args) {
        //Interface que hereda de la INTERFACE Deque
        // BloquingDeque<E>

        /*
        Cette interface ajoute la notion de blocage lors des interactions avec la collection, ce qui la
        rend thread-safe. Il existe des méthodes qui interagissent avec la collection mais qui ont des
        comportements différents en retour. Nous avons vu précédemment que certaines méthodes lèvent une
        exception alors que d'autres renvoient seulement une valeur null. Avec cette interface, certaines
        méthodes vont bloquer le thread appelant tant que l'objet collection n'est pas disponible et ceci
        indéfiniment ou selon une durée paramétrée (Time out).

        Vous aurez remarqué que cette interface implémente aussi l'interface BlockingQueue<E>... En fait,
        vous pouvez voir cette interface comme une version FIFO de BlockingQueue<E> et donc que notre objet
        interagit de la même manière aux accès concurrents de son contenu.

        Voici un tableau récapitulatif des méthodes usuelles et de leurs comportements. Le premier tableau
        correspond aux méthodes utilisées sur les premiers éléments d'une collection alors que le second se
        base sur les méthodes travaillant avec les derniers éléments :

        Méthodes sur les premiers éléments:
        ----------------------------------

       Type de Methode    |   Lève une exception   | Retourne une valeur  | Bloque le thread  |  Bloque le thread
                          |                        |                      |  indéfiniment     |  pendant une durée
     -------------------------------------------------------------------------------------------------------------------
                          |                         |                     |                   |
         Méthode          |    addFirst(E elem)     |  offerFirst(E elem) | putFirst(E elem)  |  offerFirst(E elem, long timeout, TimeUnit unit)
         d'insertion      |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |   removeFirst()         |    pollFirst()      |  takeFirst()      | pollFirst(long timeout, TimeUnit unit)
         avec suppression |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |                         |                     |                   |
         sans             |    getFirst()           |    peekFirst()      |                   |
         suppression      |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------


        Méthodes sur les derniers éléments:
        -----------------------------------

             Méthodes sur les premiers éléments:
        ----------------------------------

       Type de Methode    |   Lève une exception   | Retourne une valeur  | Bloque le thread  |  Bloque le thread
                          |                        |                      |  indéfiniment     |  pendant une durée
     -------------------------------------------------------------------------------------------------------------------
                          |                         |                     |                   |
         Méthode          |    addLast(E elem)      |  offerLast(E elem)  | putLast(E elem)   | offerLast(E elem, long timeout, TimeUnit unit)
         d'insertion      |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |   removeLast()          |    pollFirst()      |  takeLast()       | pollLast(long timeout, TimeUnit unit)
         avec suppression |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------
         Méthode de       |                         |                     |                   |
         récupération     |                         |                     |                   |
         sans             |    getLast()            |    peekLast(E elem) |                   |
         suppression      |                         |                     |                   |
     -------------------------------------------------------------------------------------------------------------------
        */
    }
}

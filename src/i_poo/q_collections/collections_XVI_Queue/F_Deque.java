package i_poo.q_collections.collections_XVI_Queue;

public class F_Deque {
    public static void main(String[] args) {
        //INTERFACE Deque
        /*
        Le terme "deque" est une abréviation de "double ended queue". La particularité principale de cette interface
        est qu'elle permet d'insérer et de retirer des éléments dans les deux sens de la pile. De ce fait, il existe
        des méthodes qui permettent d'ajouter et de retirer des éléments aux deux extrémités. Voici un récapitulatif
        de ces méthodes :
        */
        /*
                              Methode                |               Definition
     -------------------------------------------------------------------------------------------------------------------
     addFirst(E e)                                   | Insère l'élément au début la file. Si l'insertion
                                                     | échoue, une exception de type
                                                     | IllegalStateException sera levée.
     -------------------------------------------------------------------------------------------------------------------
     addLast(E e)                                    | Insère l'élément à la fin la file. Si l'insertion échoue
                                                     | une exception de type IllegalStateException sera
                                                     | levée.
     -------------------------------------------------------------------------------------------------------------------
     offerFirst(E e)                                 | Idem que la méthode addFirst(E e) mais au lieu
                                                     | de lever une exception, la méthode retournera
                                                     | false.
     -------------------------------------------------------------------------------------------------------------------
     offerLast(E e)                                  | Idem que la méthode addLast(E e) mais au lieu de
                                                     | lever une exception, la méthode retournera false.
     -------------------------------------------------------------------------------------------------------------------
                                                     | Retourne le premier élément de la collection, en le
     removeFirst()                                   | supprimant. S'il n'y a plus d'éléments lors de l'appel
                                                     | à cette méthode, celle-ci retournera une exception
                                                     | de type NoSuchElementException.
     -------------------------------------------------------------------------------------------------------------------
     removeLast()                                    | Retourne le dernier élément de la collection, en le
                                                     | supprimant. S'il n'y a plus d'éléments lors de l'appel
                                                     | à cette méthode, celle-ci retournera une exception
                                                     | de type NoSuchElementException.
     -------------------------------------------------------------------------------------------------------------------
     pollFirst()                                     | Idem que la méthode removeFirst() mais au lieu de lever
                                                     | une exception, la méthode retournera null.
     -------------------------------------------------------------------------------------------------------------------
                                                     | Idem que la méthode removeLast() mais au lieu de
     pollLast()                                      | lever une exception, la méthode retournera null.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     getFirst()                                      | Retourne le premier élément de la file sans le
                                                     | supprimer. Si aucun élément n'est trouvé, une
                                                     | exception de type NoSuchElementException sera levée.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     getLast()                                       | Retourne le dernier élément de la file sans le
                                                     | supprimer. Si aucun élément n'est trouvé, une
                                                     | exception de type NoSuchElementException sera levée.
     -------------------------------------------------------------------------------------------------------------------
                                                     | Idem que la méthode getFirst() mais au lieu de
     peekFirst()                                     | lever une exception, la méthode retournera null.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     peekLast()                                      | Idem que la méthode getLast() mais au lieu de
                                                     | lever une exception, la méthode retournera null.
     -------------------------------------------------------------------------------------------------------------------
     removeFirstOccurrence(Object o)                 | Supprime la première occurence de l'élément passé
                                                     | en paramètre. Cette méthode retourne un boolean
                                                     | qui sera à true si la file a subi une modification.
     -------------------------------------------------------------------------------------------------------------------
                                                     |
     removeLastOccurrence(Object o)                  | Idem que la méthode ci-dessus mais pour le dernier
                                                     | élément cette fois.
     -------------------------------------------------------------------------------------------------------------------
     descendingIterator()                            | Renvoie un itérateur parcourant la file dans le sens inverse
                                                     | de son sens naturel.
     -------------------------------------------------------------------------------------------------------------------

     Vous avez pu voir que seulement deux objets concrets implémentent directement cette interface,
     je vous propose maintenant de les passer en revue.

        */
    }
}

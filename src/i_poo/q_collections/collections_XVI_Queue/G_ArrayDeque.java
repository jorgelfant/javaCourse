package i_poo.q_collections.collections_XVI_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class G_ArrayDeque {
    public static void main(String[] args) {
        //clase que hereda de Deque
        //ArrayDeque<E>
        /*
        Cet objet représente un tableau redimensionnable, sans restrictions de capacité mais non thread-safe.
        Les valeurs null y sont proscrites. Les actions faites sur ce type d'objets sont relativement constantes,
        dans le sens où il n'y a pas de ralentissement notable même si la collection est importante.
        Voici un petit code d'exemple :
        */

        Deque<String> deque = new ArrayDeque<String>();
        deque.offerLast("tete");
        deque.offerFirst("toto");
        deque.offer("titi");
        deque.offerFirst("tata");
        System.out.println(deque);

        Boolean bool = deque.removeFirstOccurrence("tyty");
        System.out.println(bool);
        bool = deque.removeFirstOccurrence("tyty");
        System.out.println(deque);

        System.out.println("\n suppression du dernier élément 'tata' : ");
        deque.offerLast("tata");
        System.out.println(deque);
        bool = deque.removeLastOccurrence("tata");
        System.out.println(bool);
        System.out.println(deque);

        System.out.println("\n Parcours de la file : ");
        for (String str : deque) {
            System.out.println(str);
        }

        System.out.println("\n Parcours de la file dans le sens inverse : ");
        for (Iterator<String> it = deque.descendingIterator(); it.hasNext(); )
            System.out.println(it.next());
    }
}
/*
C'est très simple d'utilisation, n'est-ce pas ?
Ceci étant fait, je vous propose de voir la deuxième interface de cette catégorie d'objets.
*/

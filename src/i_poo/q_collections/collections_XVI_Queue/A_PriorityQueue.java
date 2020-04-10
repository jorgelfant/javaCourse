package i_poo.q_collections.collections_XVI_Queue;

import java.util.*;

public class A_PriorityQueue {
    public static void main(String[] args) {
        //PriorityQueue<E> et ConcurrentLinkedQueue<E>

        /*
        Ces deux classes héritent de la classe AbstractQueue<E> mais n'implémentent pas d'autres interfaces que Queue<E>.
        */

        //L'objet PriorityQueue<E>

        /*
        Une queue de priorité récupère les éléments triés, après insertion dans un ordre quelconque. Cependant
        ceci n'est pas le cas lorsque vous parcourez ce type de collection. En fait, la méthode remove() va vous
        fournir le plus petit élément de la collection mais ce n'est pas forcément celui qui est en première position.

        Cet objet fonctionne avec ce qu'on appelle un "tas". Il s'agit d'une arborescence binaire dans laquelle les
        méthodes remove() et add() place les éléments les plus petits autour de la racine, sans vraiment faire le
        tri complet de son contenu.

        Ce genre d'objet est tout indiqué pour planifier des tâches, gérer des priorités etc.

        Voici un code qui vous montre l'utilisation de l'objet PriorityQueue<E> :
        */

        Queue<Integer> q = new PriorityQueue<>();
        //On tente de retirer un élément inexistant
        Integer nb = q.poll();
        //ce qui nous retourne "null"
        System.out.println(nb);

        Random r = new Random();

        //Nous allons ajouter des entiers de façon aléatoire
        for (int i = 0; i < 10; i++) {
            q.offer(r.nextInt(20));
        }
        System.out.println("Affichage du contenu de la queue");
        System.out.println(q);

        //Nous allons parcourir notre collection
        //Et mettre son ordre dans une liste
        List<Integer> list = new ArrayList<>();

        Iterator<Integer> it = q.iterator();
        while (it.hasNext()) {//recorro el priorityQueue
            list.add(it.next());//por eso puedo agregar elementos en lista ya que no estoy recorriendo list
        }
        //Nous affichons la liste
        System.out.println("Affichage de l'ordre de la queue");
        System.out.println(list);

        //On supprime tout le contenu de notre liste
        list.removeAll(q);
        //nous allons maintenant voir comment les objets
        //sont dépilés de notre collection
        for (int i = 0; i < 10; i++) {
            list.add(q.remove());//remove va retornandolo y eliminando del mas pequeno almas grande
        }
        System.out.println("Affichage de l'ordre de dépilage");
        System.out.println(list);
        /*
        IMPRIME
            null
            Affichage du contenu de la queue
            [1, 1, 2, 1, 16, 18, 8, 19, 10, 16]
            Affichage de l'ordre de la queue
            [1, 1, 2, 1, 16, 18, 8, 19, 10, 16]
            Affichage de l'ordre de dépilage
            [1, 1, 1, 2, 8, 10, 16, 16, 18, 19]
        */

        /*
        Ayant utilisé des données pseudo-aléatoires, vous aurez sans doute un résultat différent mais avec la même finalité.

        Vous pouvez constater que les éléments ne sont pas triés au sein de la collection mais que ceux-ci sont
        dépilés par ordre croissant.
        Vous avez aussi la possibilité de définir un ordre de sortie. Voici un exemple :
        */
        System.out.println();
        System.out.println();
        //Le premier paramètre défini la taille initiale de la collection
        //Le deuxième le comparateur à utiliser, ici par ordre décroissant
        Queue<Integer> t = new PriorityQueue<>(10, new Comparator<Integer>(){
            public int compare(Integer int1, Integer int2) {
                return int2.compareTo(int1);
            }
        });

        Random rr = new Random();

        for(int i=0; i < 10; i++)
            t.offer(rr.nextInt(20));

        System.out.println(t);

        List<Integer> lista = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            lista.add(t.remove());//en orden decreciente

        System.out.println("Affichage de l'ordre de dépilage");
        System.out.println(lista);

        //Que se passe-t-il lorsque nous dépassons la taille initiale ?
        //Rien du tout, la collection grandit de façon dynamique. :)
        //Passons maintenant au deuxième objet.
    }
}

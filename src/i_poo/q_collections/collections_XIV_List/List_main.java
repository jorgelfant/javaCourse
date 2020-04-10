package i_poo.q_collections.collections_XIV_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class List_main {
    public static void main(String[] args) {
        /*
        L'interface List<E>
        -------------------
        Dans ce chapitre nous parlerons de l'interface List et de ses implémentations.
        Nous verrons les avantages de ces objets par rapport à des tableaux et nous verrons comment les utiliser.

        L'interface List représente une collection ordonnée de données qui peuvent être des doublons (données identiques).
        Elle peut apparaître comme un tableau qui n'aurait pas la contrainte de taille lorsque vous récupérez ou y
        ajoutez des éléments.

        En plus des actions globales à l'interface Collection, l'interface List permet également :

        .d'accéder à une donnée à partir de sa position ;

        .de récupérer la position d'un objet dans la liste.


                                        INTERFACE                                                       INTERFACE
                         *********************************************            extends         **********************
                         *                 Lis<E>                    *--  --  --  --  --  --  --> *    Iterator<E>     *
                         *********************************************                            **********************
                         * add(index: int, element: E): void         *                            * hasNext(): boolena *
                         *********************************************                            **********************   extends
                         * get(index: int): E                        *                            * next(): E          *<------------
                         *********************************************                            **********************            |
                         * indexOf(o : Object): void                 *                            * remove(): void     *            |
                         *********************************************                            **********************            |
                         * listIterator(): ListIteratot<E>           *                                                          Interface
                         *********************************************                                                  **************************
                         * listIterator(index; int): ListIteratot<E> *                                                  *      ListIterator<E>   *
                         *********************************************                    extends                       **************************
                         * remove(index: int): E                     *--  --  --  --  --  --  --  --  --  --  --  ----> * add(elem: E: void      *
                         *********************************************                                                  **************************
                         * set(index: int, elem: E): E               *                                                  * hasPrevious(): boolean *
                         * *******************************************                                                  **************************
                         *  subList(from : int, to: int) List<E>     *                                                  * nextIndex(): int       *
                         *********************************************                                                  **************************
                            ^           ^                       ^   ^                                                   * previous(): E          *
               implements   |           |                       |   |            implements                             **************************
          ------------------            |                       |   -----------------------------------------           * set(elem: E): void     *
          |                             | implements implements |                                           |           **************************
          |                             |                       |                                           |
          |                             |                       |                                           |
        class                       Abstract class              |   Abstract class                        class
 ********************           ********************         *****************************        **********************
 *   ArrayList<E>   *           *   AbstractList   *         * AbstractSequentialList<E> *        * CopyOnWriteList<E> *
 ********************  extends  ******************** extends *****************************        **********************
 *                  * --------> *                  * <------ *                           *        *                    *
 ********************           ********************         *****************************        **********************
 *                  *           *                  *         *                           *        *                    *
 ********************           ********************         *****************************        **********************
            ^                                                             ^
            |    extends                                                  |
            -------------                                                 |extends
                         |                                                |
    ----------------------------------------                              |
    |                    |                  \                           class
****************   ************   **********************         ********************
* AttributList *   * RoleList *   * RoleUnresolvedList *         *     LinkedList   *
****************   ************   **********************         ********************
*              *   *          *   *                    *         *                  *
****************   ************   **********************         ********************
*              *   *          *   *                    *         *                  *              Interface
****************   ************   **********************         *********************       ***********************
                                                                      |           |          *        Deque<E>     *
                                               Interface              |           |          ***********************
                                             *************   extends  |           | extends  *                     *
                                             *  Queue<E> *  <---------            ---------> ***********************
                                             *************                                   *                     *
                                             *           * <-------------------------------- ***********************
                                             *************              extends
                                             *           *
                                             *************

Les éléments en jaune représentent les interfaces, les éléments roses sont des classes abstraites et les autres sont
les classes que vous pouvez instancier. Comme vous pouvez le constater, il y a donc 6 classes que vous pouvez utiliser.

Nous pouvons donc en déduire que les objets implémentant cette interface, en plus d'avoir toutes les méthodes de
l'interface Collection, travailleront essentiellement avec des indices, via les méthodes suivantes:

  .la méthode add(E elem) ;

  .la méthode get(int index) ;

  .la méthode set(int index, E elem) ;

  .la méthode remove(int index).

************************************************************************************************************************

Dans cette interface, il y a une autre nouveauté, l'ajout d'un nouvel itérateur appelé ListIterator<E> qui vous permet
de parcourir la liste dans les deux sens, d'ajouter un élément, ou d'en redéfinir un pendant le parcours.

Vous aurez pu constater qu'il existe deux méthodes pour récupérer un tel objet. La première, sans argument, retourne
un itérateur positionné au début de la liste, alors que la seconde méthode retourne un itérateur positionné à l'index
passé en paramètre.

Il existe aussi une méthode qui permet de récupérer une partie de la liste : subList(int from, int to).

Dans le chapitre précédent, je vous avais parlé de la classe Collections, qui permet, entre autres, de trier une
collection de type List<E>. Il est temps de vous présenter les autres méthodes utilisables sur ce genre d'objets:

              Methode                               |               Definition
   ---------------------------------------------------------------------------------------------------------------------
   binarySearch(List<? extends Comparable           |   Recherche un élément dans une liste en utilisant l'algorithme
   <? super T>> list, T key)                        |   l'algorithme de recherche binaire.
                                                    |   Ce mode de recherche se base sur l’ordre naturel des objets.
                                                    |   Si ce fonctionnement ne vous convient pas, vous avez à disposition
                                                    |   la même méthode avec un paramètre supplémentaire : un comparateur.
   ---------------------------------------------------------------------------------------------------------------------
   checkedList(List<E> list, Class<E> type)         |   Tri du plus petit au plus grand en se
                                                    |   servant de ma représentation numérique
                                                    |   du caractère.
   ---------------------------------------------------------------------------------------------------------------------
   copy(List<? super T> dest, List<? extends T> src)|   Copie la liste source dans la liste de destination.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   fill(List<? super T> list, T obj)                |   Remplace tous les éléments de la liste par l'élément
                                                    |   passé en deuxième paramètre.
   ---------------------------------------------------------------------------------------------------------------------
                                                    |   Retourne la position de départ (première occurence) de la
    indexOfSubList(List<?> source, List<?> target)  |   première occurence de la sous-liste passée en paramètre.
                                                    |   Cette méthode renverra -1 si aucun élément n'a été trouvé.
   ---------------------------------------------------------------------------------------------------------------------
    lastIndexOfSubList(List<?> source, List<?> target)| Identique à la méthode ci-dessus mais retourne l'index
                                                     |de la dernière occurence. Renvoie -1 si aucun élément n'a été trouvé.
   ---------------------------------------------------------------------------------------------------------------------
   replaceAll(List<T> list, T oldVal, T newVal)     | Remplace toutes les occurrences d'une certaine valeur par une autre.
   ---------------------------------------------------------------------------------------------------------------------
    reverse(List<?> list)                           | Renverse l'ordre des éléments de la liste.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
                                                    | Opère une rotation entre les éléments d'une liste à une certaine
                                                    | distance. Par exemple, si j'ai une liste qui contient ces éléments
    rotate(List<?> list, int distance)              | dans l'ordre : a, b, c, d, e, f et que j'invoque cette méthode :
                                                    | Collections.rotate(list, 2)., 'obtiendrai ceci e, f, a, b, c, d.
                                                    | Une rotation de deux éléments s'est opérée : les deux derniers
                                                    | sont maintenant les deux premiers.
   ---------------------------------------------------------------------------------------------------------------------
    shuffle(List<?> list)                           | Permute de façon aléatoire les éléments de la liste.
   ---------------------------------------------------------------------------------------------------------------------
    swap(List<?> list, int i, int j)                | Échange les éléments de la liste aux positions spécifiées.
   ---------------------------------------------------------------------------------------------------------------------
                                                    | Retourne une vue non modifiable de la liste passée en paramètre.
    unmodifiableList(List<? extends T> list)        |
   ---------------------------------------------------------------------------------------------------------------------
        */

        //**************************************************************************************************************
        //                                          ArrayList<E> and co !
        //**************************************************************************************************************

        /*
        Nous allons commencer par l'une des collections les plus utilisées : ArrayList<E>. Son succès provient
        du fait qu'elle fonctionne comme un tableau traditionnel mais sans leurs inconvénients
        (taille fixe, dépassement de taille, etc.) car sa taille évolue de façon dynamique lorsqu'on ajoute
        ou supprime un élément.

        Les objets ArrayList<E> ont tout de même un inconvénient : ils ne sont pas synchronisés, ce qui rend
        leur utilisation dans un environnement multithread très délicat... En fait, si vous êtes un ancien de
        la programmation Java, vous vous souvenez peut-être de la vieille classe Vector... Cette classe représente
        aussi un tableau dynamique, mais qui, lui, a toutes ses méthodes synchronisées. Donc, si vous êtes dans un
        milieu multithread, préférez la classe Vector.

        Nous avons pu voir qu'il existe des sous-classes héritant de ArrayList, mais la plupart du temps,
        il y a fort à parier que ce sera la classe-mère ArrayList que vous utiliserez.

        Pour être franc, il n'y a pas beaucoup de choses à dire sur cet objet... Je vous propose donc un code
        d'exemple pour vous montrer son utilisation :
        */
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        //On met la liste dans le désordre
        Collections.shuffle(list);
        System.out.println(list);

        //On la remet dans l'ordre
        Collections.sort(list);
        System.out.println(list);

        Collections.rotate(list, -1);
        System.out.println(list);

        //On récupère une sous-liste
        List<String> sub = list.subList(2, 5);//del indice 2 al indice 5
        System.out.println(sub);
        Collections.reverse(sub);
        System.out.println(sub);

        //On récupère un ListIterator
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("d"))
                it.set("v_design_patterns");
        }
        while (it.hasPrevious())
            System.out.print(it.previous());

       /* IMPRIME
          [b, d, f, e, a, c]
          [a, b, c, d, e, f]
          [b, c, d, e, f, a]
          [d, e, f]
          [f, e, d]
          azefcb
       */

       /*
         Voyons maintenant rapidement les différences entre la classe ArrayList et ses enfants, des listes qui sont
         utilisées dans certains cas très spécifiques. Comme je vous l'ai déjà dit, à priori vous n'aurez pas besoin
         de vous en servir beaucoup, mais on ne sait jamais !

         Classe                                           |            Spécialités
         ---------------------------------------------------------------------------------------------------------------
         AttributeList                                    | Travaille avec des MBean , signifiant "Bean Managé",
                                                          | et désignant un objet qui représente une ressource comme
                                                          | une application, un service, ou encore un port...
         ---------------------------------------------------------------------------------------------------------------
         RoleList                                         | Représente une liste d'objets Role.
         ---------------------------------------------------------------------------------------------------------------
         RoleUnresolvedList                               | Représente une liste d'objets RoleUnresolved.
         ---------------------------------------------------------------------------------------------------------------
       */
        //**************************************************************************************************************
        //                                          LinkedList
        //**************************************************************************************************************
        /*
           Une LinkedList, d'après son appellation anglaise, c'est une liste chaînée. Je m'explique : comme dans une
           chaîne, chaque élément de la liste est lié à ses voisins. Comme ce n'est pas une boucle, une liste chaînée
           doit bien commencer et se terminer quelque part, donc avant le premier élément et après le dernier élément
           de la liste, on retrouve la valeur null.

           Il y a une différence importante entre les listes chaînées et les collections. En effet, de par sa nature,
           une liste chaînée est une collection où la position des éléments est très importante car chaque objet
           référence aussi son prédécesseur et son successeur. Par défaut, l'ajout d'éléments, via la méthode
           add(E elem) insère un nouvel élément à la fin de la liste car c'est le rôle des itérateurs de définir
           la position actuelle dans une liste donc c'est via les itérateurs que nous allons pouvoir insérer un
           nouvel élément en milieu de liste.

           Pour faire simple, ce sont eux qui ont les liens et qui doivent les modifier en cas d'ajout ou de
           suppression : c'est donc via un objet de type ListIterator que nous allons pouvoir ajouter des éléments
           en milieu de liste chaînée mais aussi en tout début.

           L'un des intérêts de cet objet, c'est qu'il peut supprimer très rapidement un élément qui se trouve au
           milieu d'une collection contenant une grande quantité d'infos. Si la rapidité d'exécution n'est pas un
           critère privilégié, utilisez plutôt un objet ArrayList.

        //**************************************************************************************************************
        //                                         CopyOnWriteArrayList<E>
        //**************************************************************************************************************
           Cet objet est une variante thread-safe de l'objet ArrayList.
           L'utilisation de cet objet est généralement très coûteuse en temps et en mémoire car une copie des données
           est faite, mais c'est très efficace dans un environnement multithread.

           En fait, si vous avez des accès concurrents sur une ArrayList (un accès en lecture et un accès en écriture
           par exemple), vous pouvez voir surgir une exception de type ConcurrentModificationException et ceci même au
           sein d'un unique thread. Pour être tout à fait clair, vous ne pouvez pas modifier la structure d'un objet
           ArrayList si un itérateur travaille dessus... Voici un code qui lève une telle exception :
        */
        /*
        System.out.println();
        List<String> lista = new ArrayList<String>();
        lista.add("a");
        lista.add("b");
        lista.add("c");

        ListIterator<String> it2 = lista.listIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
            lista.add("toto");//esto daria error porque durante la ejecucion debemos usar el iterador pa agregar un elemento
        }                     // it2.add("toto")
        System.out.println(lista);
*/

        //Une solution à ce problème revient à utiliser l'objet CopyOnWriteArrayList<E>. Ce code est donc fonctionnel :
        //UN CopyOnWriteArrayList permet d'ajouter un element pendant l'iteration avec la list elle meme (et pas l'iterator)
        // sauf que dans ce cad tout ce qu'on rajoute se met à la fin de la list et pas juste apres l'element en cours
        System.out.println();
        List<String> lista2 = new CopyOnWriteArrayList<String>();
        lista2.add("a");
        lista2.add("b");
        lista2.add("c");

        ListIterator<String> it3 = lista2.listIterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
            lista2.add("toto");
        }
        System.out.println(lista2);
        /*IMPRIME
           a
           b
           c
           [a, b, c, toto, toto, toto]
        */

        /*
        Alors, que s’est-il passé ? En fait, avec cet objet, lorsque vous modifiez son contenu directement, ce
        n'est pas le contenu de la liste qui est modifié mais une copie et cette dernière. Cette copie prendra
        la place de l'original une fois que le(s) itérateur(s) seront libérés. C'est pour cela que, lors du
        parcours dans notre code, les ajouts de la valeur "toto" n'apparaissent pas.

        Par contre, cela a une autre incidence : vous ne pouvez pas supprimer le contenu d’un objet CopyOnWriteArrayList
        avec un itérateur. Si vous faites cela, une exception de type : UnsupportedOperationException sera levée, pour
        la simple raison que l'itérateur travaille avec l'original de la liste et non la copie.

        Voilà, vous savez tout.

        Comme vous avez pu le remarquer, l'interface List<E> est relativement facile à manipuler car ses implémentations
        sont peu nombreuses et très faciles d'utilisation. Continuons donc notre tour d'horizon avec l'interface Set.

        */

    }
}

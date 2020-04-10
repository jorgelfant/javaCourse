package i_poo.q_collections.collections_XV_Set;

import java.util.*;

public class Set_main {
    public static void main(String[] args) {
        /*  L'interface Set<E>

        Dans ce chapitre, nous parlerons donc de l'interface Set.
        Comme toutes les interfaces dont nous parlons dans ce cours, l’interface Set permet de gérer des données sous
        forme de collection. Mais vous allez vite vous rendre compte que ses objets ont une façon de fonctionner bien
        particulière par rapport aux objets de l’interface List vue dans le chapitre précédent.

        GENERALITEES
        ------------

        Une collection de type Set représente une structure qui ne supporte pas les valeurs dupliquées. Par rapport
        aux collections vues précédemment, ce genre d'objets a une interaction très forte avec les méthode equals()
        et hashcode(), qui permet de savoir si une collection est égale à une autre, permettant ainsi de savoir si
        deux Set sont identiques, c’est-à-dire si elles contiennent les mêmes objets même s’ils sont rangés avec des
        implémentations différentes.

        Avant de continuer, voici un diagramme de classes représentant les principales implémentations de cette
        interface :


                                                INTERFACE
                                 *********************************************
                                 *              Collection<E>                *
                                 *********************************************
                                 * add(elem: E): boolean                     *
                                 *********************************************
                                 * addAll(col: Collection<? extends E>): void*
                                 *********************************************
                                 * clear(): void                             *
                                 *********************************************
                                 * contains(o: Object): void                 *
                                 *********************************************
                                 * containsAll(col): void                    *
                                 *********************************************
                                 * hashCode(): int                           *
                                 *********************************************
                                 * isEmpty(): boolean                        *
                                 * *******************************************
      Interface                  * remove(o: Object) : boolean               *
**********************           *********************************************
*     Iterator<E>    *           * removeAll(col): boolean                   *
**********************           *********************************************
* hasNext(): boolean *           * retainsAll(col): boolean                  *                 Abstract class
**********************           *********************************************            ******************************
* next(): E          *           * size(): int                               *     -------*           Abstract<E>      *
**********************           *********************************************     |      ******************************
* remove(): void     *             ^                                               |      *                            *
**********************             |                                               |      ******************************
          ^                        |                                               |   ---*                            *<-------------------------------------------
          |                        |                                               |   |  ******************************<--------                                   |
          |                        |                                               |   |        ^              ^      ^          |                                  |
          |                        |                                               |   |        |              |      |          |                                  |
          |     Interface          |                                               |   |        |              |      |          |                                  |
    ***********************************                                            |   |        |              |      |          |                                  |
    *             Set<E>              *<-------------------------------------------    |        |              |      ---------- | ----------------                 |
    ***********************************                Interface                       |        |              | class           |                 |                |
    *                                 *<----------********************                 |        |             **************     |                 |                |
    ***********************************           *   SortedSet<E>   *<---------------------------------------* TreeSet<E> *     |                 |                |
                     ^                            ********************                 |        |             **************     |                 |                |
                     |                            *                  *                 |        |             *            *     |            class|                |
                     |                            ********************                 |        |             **************     |    ***************************   |
                     |                            *                  *                 |        |                                |    * copyOnWriteArrayList<E> *   |
                     |                            ********************                 |        |     Class                      |    ***************************   |
                     |                                ^           ^                     |      ************************           |    *                         *   |
                     |                                |           ----------------------------*ConcurrentSkipList<E> *           |    ***************************   |
                     |                                |                                |      ************************           |                                  |
                     |                                |                                |      *                      *           |                            Class |
                     |                                |                                |      ************************           |                        ***************
                     |           Interface            |                                |                                         |                        *  HashSet<E> *
********************************************************************************************************                         |                        ***************
*                                           NavigableSet<E>                                            *                    Class|                        *             *
********************************************************************************************************         ******************************           ***************
* ceiling(e: E): E                                                                                     *         * EnumSet<E extends Enum<E>> *                    ^
********************************************************************************************************         ******************************                    |
* descendingIterator(): Iterator<E>                                                                    *         *                            *                    |
********************************************************************************************************         ******************************                    |
* descendingSet(): NavigableSet<E>                                                                     *                                                   Class   |
********************************************************************************************************                                           ********************
* floor(): E                                                                                           *                                           * LinkedHashSet<E> *
********************************************************************************************************                                           ********************
* headSet( to: E, inclusive: boolean): Navigable<E>                                                    *                                           *                  *
********************************************************************************************************                                           ********************
* higher( elem: E): E                                                                                  *
********************************************************************************************************
* lower( elem: E): E                                                                                   *
********************************************************************************************************
* pollFirst(): E                                                                                       *
********************************************************************************************************
* pollLast(): E                                                                                        *
********************************************************************************************************
* subSet( fromElement: E, fromInclusive: boolean, toElement: E, toInclusive: boolean): NavigableSet<E> *                                                              *
********************************************************************************************************
* tailSet( fromElement: E, inclusive: boolean): NavigableSet<E>                                        *                                                                *
********************************************************************************************************
        */
/*
Nous pouvons donc voir qu'il existe plusieurs implémentations disponibles pour cette interface. Chacune ajoute
son lot de particularités et de restrictions : nous verrons que, à l'instar des implémentations de l'interface List,
certaines implémentations de l'interface Set ont des restrictions sur certains types d'objets.

Vous pouvez déjà retenir une chose : l'interface Set propose trois implémentations générales utilisables facilement :

  .HashSet<E> : stocke ses éléments dans une table de hachage. C'est de loin l'implémentation la plus performante ;

  .TreeSet<E> : stocke ses éléments triées selon leurs valeurs ;

  .LinkedHashSet<E> : est un doux mixage entre l'objet HashSet et une liste chaînée.

  Nous parlerons rapidement des autres implémentations mais vous verrez qu'elles sont plus ciblées...

Je vous propose maintenant de voir les méthodes utilitaires de l'objet Collections applicable aux implémentations
de cette interface :

              Methode                               |               Definition
   ---------------------------------------------------------------------------------------------------------------------
   checkedSet(Set<E> s, Class<E> type)              |   Retourne un Set typé dynamiquement avec le
                                                    |   type spécifié en deuxième paramètre.
   ---------------------------------------------------------------------------------------------------------------------
   checkedSortedSet(SortedSet<E> s, Class<E> type)  |   Idem que précédemment mais avec un Set trié.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   synchronizedSet(Set<T> s)                        |   Retourne un objet, de type Set<E>, thread-safe
                                                    |   (utilisable en environnement multithread)
                                                    |   basé sur la collection passée en paramètre.
   ---------------------------------------------------------------------------------------------------------------------
   synchronizedSortedSet(SortedSet<T> s)            |   Idem que précédemment mais l'objet sera trié.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
                                                    |
    unmodifiableSet(Set<? extends T> s)             |   Retourne une vue non modifiable du Set<E> passée en paramètre.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
    unmodifiableSortedSet(SortedSet<T> s)           | Idem que la méthode ci-dessus mais retourne un objet trié.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------




Les implémentations de l'interface Set<E> héritent tous de l'objet AbstractSet<E>  implémente une autre interface,
NavigableSet<E>, qui apporte, elle aussi, sa contribution. Faisons un peu le tour du propriétaire.

L'interface NavigableSet<E>
---------------------------
Voici la liste des méthodes apportées par cette interface :

              Methode                               |               Definition
   ---------------------------------------------------------------------------------------------------------------------
   ceiling(E e)                                     |   Retourne le plus petit élément de la collection plus grand
                                                    |   ou égal avec l'élément passé en paramètre.
   ---------------------------------------------------------------------------------------------------------------------
   descendingIterator()                             |   Retourne un itérateur parcourant la collection dans le sens
                                                    |   inverse du sens naturel de tri (implémentation de base de
                                                    |   l'interface Comparable).
   ---------------------------------------------------------------------------------------------------------------------
   descendingSet()                                  |   Retourne un objet de type NavigableSet<E> trié dans le sens inverse.
                                                    |
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   floor(E e)                                       |   Retourne le plus grand élément de cet ensemble inférieur ou
                                                    |   égal à l'élément passé en paramètre, ou null en l'absence
                                                    |   d'un tel élément.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
                                                    |   Retourne un objet de type SortedSet<E> contenant tous les
   headSet(E toElement)                             |   éléments plus petits que l'élément passé en paramètre.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   higher(E e)                                      | Retourne le plus petit élément strictement plus grand que
                                                    | le paramètre passé à la méthode.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   lower(E e)                                       | Retourne le plus grand élément strictement plus petit
                                                    | que le paramètre passé à la méthode.
   ---------------------------------------------------------------------------------------------------------------------
   pollFirst()                                      | Retrouve et retire le plus petit élément de la collection.
   ---------------------------------------------------------------------------------------------------------------------
   pollLast()                                       | Retrouve et retire le plus grand élément de la collection.
   ---------------------------------------------------------------------------------------------------------------------
   subSet(E fromElement, boolean fromInclusive,     | Retourne un objet NavigableSet<E> contenant la portion
   E toElement, boolean toInclusive)                | définie en paramètre avec les limites inclusives ou
                                                    | exclusives de bornes minimum et maximum.
   ---------------------------------------------------------------------------------------------------------------------

   Tout ceci est donc utilisable sur les implémentations que nous allons voir maintenant.
*/

//**********************************************************************************************************************
//                                               TreeSet<E>
//**********************************************************************************************************************
   /*
   Nous savons maintenant que cet objet implémente plusieurs interfaces. Sa particularité vient du fait que ses éléments
   sont triés, car elle implémente une interface qui permet ce comportement : SortedSet<E>.

   L'interface SortedSet<E> complémente l'interface Set<E> sur deux points :

   Elle stipule que l'itérateur généré devra parcourir la collection dans le sens ascendant ;

   Elle comporte certaines méthodes supplémentaires comme first(), last() etc.

   Mais gardez bien à l'esprit que les éléments seront triés selon leur ordre naturel
   (vu dans le premier chapitre de cette partie). Cela signifie donc que tous les éléments ajoutés devront
   implémenter l'interface Comparable<E>, sinon vous aurez une belle exception de type ClassCastException.


   Comment sont triés les éléments ?

   Comme je vous l'avais expliqué dans le premier chapitre de cette partie, le tri peut s'effectuer de deux manières :

     .sur la comparaison qui est implémentée dans l'objet contenu dans la collection ;

     .via un comparateur spécifique à notre besoin.

   Ainsi, lorsque nous ajoutons un élément dans la collection, l'objet l'insère à l'endroit correspondant à son rang.
   Cette façon de faire s'appelle un arbre rouge-noir, je ne détaillerai pas cette notion ici car il s'agit d'un
   algorithme de tri, très utilisé, mais hors propos ici. Je vous propose de voir le contenu supplémentaire de
   l'interface SortedSet<E>.

   Le fait que les éléments soient triés est très pratique mais ceci a un impact sur les performances de votre
   application, car plus il y a d'éléments dans ce type de collection, plus l'objet mettra du temps à l'utiliser !

//**********************************************************************************************************************
//                                           SortedSet<E>
//**********************************************************************************************************************

                 Methode                            |               Definition
   ---------------------------------------------------------------------------------------------------------------------
   comparator()                                     |   Retourne le comparateur utilisé pour ranger les éléments ou
                                                    |   null s'il utilise l'ordre naturel des éléments.
   ---------------------------------------------------------------------------------------------------------------------
   first()                                          |   Retourne le premier élément de la collection, donc le plus petit.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
   headSet(E toElement)                             |   Retourne un objet de type SortedSet<E> contenant tous les
                                                    |   éléments plus petits que l'élément passé en paramètre.
   ---------------------------------------------------------------------------------------------------------------------
   last()                                           |   Retourne le dernier élément de la collection, donc le plus grand.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
                                                    |
    subSet(E fromElement, E toElement)              |   Retourne un objet SortedSet<E> contenant la portion définie en paramètre.
                                                    |
   ---------------------------------------------------------------------------------------------------------------------
    tailSet(E fromElement)                          |  Retourne un objet SortedSet<E> contenant les éléments plus
                                                    |  grands que les paramètres passés à la méthode.
   ---------------------------------------------------------------------------------------------------------------------

   */

        //Maintenant que nous savons tout ceci, je vous propose un code d'exemple, comme d'habitude. :

        TreeSet<Double> set = new TreeSet<Double>();
        set.add(12.52d);
        set.add(-5d);
        set.add(102.56d);
        set.add(75d);
        set.add(-52d);
        //Vous pouvez voir que, malgré l'insertion dans le désordre
        //L'affichage se fait dans l'ordre
        System.out.println(set);

        Double d = set.ceiling(12.52d);
        System.out.println(d); //Retourne bien 12.52

        d = set.higher(12.52d);
        System.out.println(d); //Retourne bien 75.0

        //on extrait une sous-section de notre objet
        NavigableSet<Double> nSet = set.subSet(12.52d, true, 75d, false);
        System.out.println(nSet);//Mais ne contient qu'un élément... ^^

        //On retire le plus petit élément
        set.pollFirst();
        System.out.println(set);

        //On retire le plus grand élément
        set.pollLast();
        System.out.println(set);

        /*IMPRIME
           [-52.0, -5.0, 12.52, 75.0, 102.56]
           12.52
           75.0
           [12.52]
           [-5.0, 12.52, 75.0, 102.56]
           [-5.0, 12.52, 75.0]

        */
        /*
        Il existe un objet qui ressemble comme deux gouttes d'eau à l'objet TreeSet<E> : l'objet

        ConcurrentSkipListSet<E>.

        La différence avec sa petite cousine réside dans le fait qu'avec ce dernier, toutes les opérations faites
        (ajout, suppression etc.) sont thread-safe, donc utilisables dans un environnement multithread sans crainte.

        Je vous propose maintenant de voir un nouvel objet...
        */

        //******************************************************************************************************************
        //                                HashSet<E> et LinkedHashSet<E>
        //******************************************************************************************************************

        // Comme vous avez pu le constater, ces deux objets sont liés car LinkedHashSet<E> hérite de HashSet<E>.
        // Je vais donc commencer par l'objet de plus haut niveau dans la hiérarchie de classe... ^^


        /*
                                                          Class
                                                    ***************
                                                    *  HashSet<E> *
                                                    ***************
                                                    *             *
                                                    ***************
                                                          ^
                                                          |
                                                          |
                                                          |
                                                  Class   |
                                                ********************
                                                * LinkedHashSet<E> *
                                                ********************
                                                *                  *
                                                ********************
        */

        //L'objet HashSet<E>
        /*
        Comme je vous le disais précédemment, c'est l'un des objets est les plus utilisés implémentant
        l'interface Set<E> et, comme son nom l'indique, celui-ci utilise le principe de "table de hachage".

        Ces fameuses tables de hachages sont un procédé qui permet de stocker des données, ça vous vous en serez douté,
        mais la spécificité réside dans la manière dont elles sont stockées. Première spécificité, les données sont
        gérées sous la forme clé-valeur. Deuxième spécificité, au lieu d'ajouter les données bout à bout
        (comme dans un tableau ou dans une List), les données sont éparpillées le plus uniformément possible.
        Cette façon de stocker les données fait appel à deux éléments :

         .des buckets (ou seaux en français) ;

         .un bucket array (ou tableau de seaux), qui pourrait se représenter de cette manière :

                                                    BUCKET ARRAY
                       ----------------------------------------------------------------------------
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                                                                  |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                       Clé - Valeur                               |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                                                                  |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                10236548 - ma donnée 1                            |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                                                                  |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |             45674651384 - ma donnée 2                            |   |
                       |   --------------------------------------------------------------------   |
                       |   |  Bucket                                                          |   |
                       |   |                                                                  |   |
                       |   --------------------------------------------------------------------   |
                       |---------------------------------------------------------------------------


                Mais les données ne sont pas rangées au petit bonheur la chance... Elles sont rangées en
                fonction d'un critère : leur code de hachage, retourné par la méthode hashcode() de chaque objet

                C'est pour ça qu'il est important de redéfinir la méthode hashcode() dans nos objets ?

                Exactement, cette méthode sert à catégoriser nos objets dans ce genre de collections. Lorsque nous
                allons tenter d'ajouter un élément dans ce genre de collection, via la méthode add(E elem), une
                recherche vérifie la présence du code de hachage.

                Vous expliquer comment fonctionnent les hachages pourrait faire l'objet d'un cours à part entière,
                je ne vais donc pas m’étendre dessus, mais je voulais quand même le mentionner pour que vous compreniez
                mieux l'importance de la méthode hashcode().

                Je vous propose maintenant de voir comment utiliser l’objet HashSet<E> en pratique avec un petit code
        */
        System.out.println();
        System.out.println();
        HashSet<Double> seti = new HashSet<Double>();
        seti.add(12.52d);
        seti.add(-5d);
        seti.add(102.56d);
        seti.add(75d);
        seti.add(-52d);
        //Vous pouvez voir que, malgré l'insertion dans le désordre
        //L'affichage se fait dans l'ordre
        System.out.println(seti);

        Iterator<Double> it = seti.iterator();
        while (it.hasNext()) {
            Double a = it.next();
        }

        //*****************************************************************************************************************
        //                                HashSet<E> et LinkedHashSet<E>
        //*****************************************************************************************************************
/*
        L'objet LinkedHashSet<E>

        Cet objet est un peu l'intermédiaire entre le HashSet<E> et le TreeSet<E> car il stocke les données sous la
        forme de table de hachage mais gère aussi l'insertion de façon ordonnée, en améliorant les performances en
        lecture et écriture par rapport à l'objet HashSet<E>.

        Cet objet s'utilisant de la même façon que l'objet vu ci-dessus, je vous fais grâce du code d'exemple. :)

     //*****************************************************************************************************************
     //                                      an Others
     //*****************************************************************************************************************

     Les deux dernières implémentations étant très marginales, je vous les présente rapidement.

          CopyOnWriteArraySet<E>

     Cet objet fonctionne de la même façon que l'objet CopyOnWriteArrayList<E> et possède les mêmes vertus.
     Je ne m'étendrai donc pas dessus.

          EnumSet<E>

     Cet objet est spécialement conçu pour travailler avec des objets de type Enum. Tous les éléments de cet objet
     devront être du même type que l'énumération paramétrée. Cette implémentation offre tout de même son lot de méthodes :


                      Methode                        |               Definition
     -------------------------------------------------------------------------------------------------------------------
     allOf(Class<E> elementType)                     |   Créé un objet EnumSet<E> contenant tous les éléments de
                                                     |   l'énumération spécifiée.
     -------------------------------------------------------------------------------------------------------------------
     clone()                                         |   Retourne une copie de l'objet.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     complementOf(EnumSet<E> s)                      |   Crée un EnumSet<E> du même type que l'élément passé
                                                     |   en paramètre mais le remplit en excluant les valeurs de la
                                                     |   collection en paramètre.
     -------------------------------------------------------------------------------------------------------------------
     copyOf(EnumSet<E> s)                            |   Crée un objet identique à celui passé en paramètre.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
                                                     |   Crée un EnumSet<E> contenant uniquement l'élément
     of(E e)                                         |   passé en paramètre. Cette méthode se décline avec 1, 2, 3,
                                                     |   4, 5 ou n paramètres (autant que vous voulez !).
     -------------------------------------------------------------------------------------------------------------------
     range(E from, E to)                             |  Crée un EnumSet<E> contenant tous les éléments entre
                                                     |  les deux extrémités définies en paramètre.
     -------------------------------------------------------------------------------------------------------------------

     */
        System.out.println();
        System.out.println();
        //Voici un exemple d'utilisation de la classe EnumSet<E> :
        //On récupère une instance de cette classe
        //via une méthode statique

        EnumSet<Days> es = EnumSet.allOf(Days.class);
        System.out.println(es);

        //On crée une sous collection
        EnumSet<Days> es2 = es.range(Days.MARDI, Days.VENDREDI);
        System.out.println(es2);

        //On crée une sous collection en prenant les
        //éléments non présents dans le set es2
        EnumSet<Days> es3 = es.complementOf(es2);
        System.out.println(es3);

        /*IMPRIME
           [Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche]
           [Mardi, Mercredi, Jeudi, Vendredi]
           [Lundi, Samedi, Dimanche]
        */

        //J'ose espérer que je vous ai appris quelques nouveautés sur l'interface Set<E>, sur ses implémentations
        //et leurs cas d'utilisation.

        //Maintenant, afin de parfaire votre connaissance du monde des collections, en route pour le monde magique
        // et envoûtant des Queue<E>.
    }
}

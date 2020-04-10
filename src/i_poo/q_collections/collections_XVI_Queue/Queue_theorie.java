package i_poo.q_collections.collections_XVI_Queue;

public class Queue_theorie {
    public static void main(String[] args) {
        //L'interface Queue<E>
        /*
        Nous allons maintenant voir une nouvelle interface.
        Nous verrons que cette dernière s'apparente à une file d'attente dont la gestion est assurée
        à l'aide de tout un lot de méthodes.

        Pas besoin d'une intro à rallonge, plongeons-nous directement dans le vif du sujet !
        */

        //Généralités
        //-----------

        /*
        L'interface Queue<E> représente une collection gérée comme une file d'attente. Elle permet donc de
        prioriser les tâches de traitement des données qu'elle contient. Ces objets utilisent généralement
        (mais pas obligatoirement) un mode de gestion de type FIFO, ce qui signifie que le premier élément
        ajouté à la collection sera le premier à en sortir. En fait, lorsque vous ajouterez des éléments
        dans ce type de collection, ils seront ajoutés à la fin de la collection, tandis que lorsque vous
        retirerez des éléments, ce seront les premiers insérés qui seront retirés en premier.

        Ce type de collection peut également prendre en compte la notion de taille disponible, et par exemple
        générer des exceptions en cas de dépassement.

        Avant de continuer à vous présenter cette interface, voici un diagramme de classes :
              TROP GROS, voir

              https://openclassrooms.com/fr/courses/1826586-java-et-les-collections/2666413-linterface-queue-e

        */

        /*
        Vous pouvez voir qu'il y a beaucoup d'objets différents dans ce type de collection... Nous allons en passer
        un certain nombre en revue mais, avant cela, regardons ce que nous offre l'interface Queue<E>.
        */

        /*
                              Methode                |               Definition
     -------------------------------------------------------------------------------------------------------------------
     add(E e)                                        |   Insère l'élément dans la file si c'est possible.
                                                     |   Dans le cas contraire, une exception de type
                                                     |   IllegalStateException sera levée
     -------------------------------------------------------------------------------------------------------------------
     element()                                       |   Retourne le premier élément de la collection, sans le supprimer.
                                                     |   S'il n'y a plus d'éléments lors de l'appel à cette méthode,
                                                     |   celle-ci retournera une exception de type NoSuchElementException.
     -------------------------------------------------------------------------------------------------------------------
     offer(E e)                                      |   Idem que la méthode add(E e) mais au lieu de lever une exception,
                                                     |    la méthode retournera false.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     peek()                                          |   Idem que la méthode element() mais au lieu de lever une exception,
                                                     |   la méthode retournera null.
     -------------------------------------------------------------------------------------------------------------------
                                                     |   Retourne le premier element de la collection, en le supprimant cette fois.
     remove()                                        |   S'il n'y a plus d'éléments lors de l'appel à cette méthode, celle-ci
                                                     |   retournera une exception de type NoSuchElementException.
     -------------------------------------------------------------------------------------------------------------------
     poll()                                          |  Idem que la méthode remove() mais au lieu de lever une exception,
                                                     |  la méthode retournera null.
     -------------------------------------------------------------------------------------------------------------------
        */

        /*
        Voilà donc pour les fonctionnalités de l’interface Queue<E>. Mais comme vous l’avez remarqué sur le diagramme,
        la plupart des objets utilisables par cette interface implémentent d’autres interfaces, ou bien héritent de la
        classe AbstractQueue<E>.

        Cette classe, tout comme les classes AbstractList<E>, AbstractSet<E> et AbstractMap<K, V>, définit un
        comportement de base pour tous les objets. Ainsi, si vous avez besoin de créer votre propre implémentation,
        vous n'avez pas à implémenter toutes les interfaces, faites un héritage et redéfinissez ce dont vous avez besoin.

        Je vous propose maintenant de vous présenter les différentes implémentations, en commençant par celles qui
        ont le moins d'interfaces...
        */

    }
}

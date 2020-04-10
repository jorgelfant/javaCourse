package i_poo.q_collections.collections_XVII_Map;

public class Map_main {
    public static void main(String[] args) {
        /*
        Ce type d'objets gère ses données avec un système de clé-valeur.
        Elle diverge donc franchement des autres collections vues précédemment, et c'est pourquoi
        ses interfaces et ses objets n'héritent pas de l'objet Collection<E>.

        Je ne vais pas vous faire une introduction magistrale sur ces objets vu que nous allons
        tout de suite voir ce qui les caractérise !
        En route moussaillons !

        GENERALITES
        -----------

        Comme je vous le disais dans l'introduction, les collections de type Map<K,V> stockent leurs contenus
        sous la forme clé-valeur : on pourrait dire qu'il s'agit d'une collection de paires. Ceci signifie donc
        qu'il ne peut pas y avoir deux fois la même clé dans ce genre de collection. Par contre, la même valeur
        peut-être présente dans deux clés différentes. L'avantage de ce genre d'objets est qu’ils permettent de
        retrouver rapidement une valeur en fonction de leur clé.

        Ces objets sont donc tout indiqués pour gérer des annuaires, des dictionnaires etc.

        Comme à l'accoutumée, voici un petit topo sur les grandes fonctionnalités de ce type d'objets.
        Je vous propose de voir tout de suite le diagramme de classes concernant cette l'interface Map<K,V> :

        VER HIERARCHIE

        https://openclassrooms.com/fr/courses/1826586-java-et-les-collections/2666737-linterface-map-k-v

        Nous avons beaucoup de choses à voir avec cette partie du framework Collections. Nous avons donc des
        implémentations de base, héritant de l'objet AbstractMap<K,V>, et des interfaces qui ajoutent, encore
        une fois, des restrictions ou des fonctionnalités à ce type d'objets. Commençons par détailler le
        contenu de l'interface Map<K,V> :

                      Methode                        |               Definition
     -------------------------------------------------------------------------------------------------------------------
     containsKey(Object key)                         |   Retourne true si l'objet passé en paramètre correspond
                                                     |   à une clé de la collection.
     -------------------------------------------------------------------------------------------------------------------
     containsValue(Object value)                     |   dem que ci-dessus mais sur une valeur cette fois.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     entrySet()                                      |   Retourne un objet de type Set<Map.Entry<K,V>
                                                     |   représentant le contenu de la collection. Comme vu dans le
                                                     |   premier chapitre de cette partie, ce type d'objet nous donne
                                                     |   une vue du contenu de la collection et est tout indiqué pour
                                                     |   la parcourir lorsque vous avez besoin des clés et des valeurs.
     -------------------------------------------------------------------------------------------------------------------
     get(Object key)                                 |   Retourne la valeur associée à la clé passée en paramètre
                                                     |   ou null si cette clé n'existe pas.
     -------------------------------------------------------------------------------------------------------------------
                                                     |
     keySet()                                        |   Retourne un objet de type Set<K> représentant la liste
                                                     |   des clés contenues dans la collection.
     -------------------------------------------------------------------------------------------------------------------
     put(K key, V value)                             |  Ajoute la clé et la valeur dans la collection en retournant
                                                     |  la valeur insérée. Si la clé existe déjà, sa valeur sera
                                                     |  écrasée par celle passée en paramètre de la méthode.
     -------------------------------------------------------------------------------------------------------------------
     putAll(Map<? extends K,? extends V> m)          |  Ajoute le contenu de la collection en paramètre
                                                     |  dans la collection appelante.
     -------------------------------------------------------------------------------------------------------------------
     remove(Object key)                              |  Supprime le couple clé-valeur associé à la clé passée
                                                     |  en paramètre et retourne la valeur supprimée.
     -------------------------------------------------------------------------------------------------------------------
     values()                                        |  Retourne une objet de type Collection<V> contenant toutes
                                                     |  les valeurs de la collection.
     -------------------------------------------------------------------------------------------------------------------

     Le langage vous propose trois implémentations de bases :

      .HashMap<K,V> : implémentation utilisant une table de hachage pour stocker ses éléments,
                      mais cet objet n'est pas thread-safe ;

      .TreeMap<K,V> : implémentation qui stocke les éléments triés, de façon naturelle par défaut,
                      mais utilisable avec un comparateur ;

      .LinkedHashMap<K,V> : implémentation qui combine table de hachage et liens chaînés pour stocker ses éléments,
                            ce qui facilite leur insertion et leur suppression.


Ces trois implémentations ressemblent beaucoup à leurs cousines : HashSet<E>, TreeSet<E>  et LinkedHashSet<E>
dans leurs comportements et leurs performances.

       */
    }
}

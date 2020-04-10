package i_poo.q_collections.collections_XVII_Map;

public class E_SortedMap_NavigableMap {
    public static void main(String[] args) {
        /*
        Les interfaces SortedMap<K,V> et NavigableMap<K,V>

        Comme vous vous en doutez maintenant, ces deux interfaces ajoutent des comportements à notre interface de base.
        Ces deux interfaces n'ont qu'une implémentation directe, l'objet TreeMap<K,V>, ce chapitre lui sera donc
        consacré mais, avant cela, voyons un peu ce qu'il y a dans nos deux interfaces.

        L'interface SortedMap<K,V>
        --------------------------
        Comme son nom l'indique, cette interface permet d'avoir une collection dont les éléments sont triés selon
        leur ordre naturel ou via un comparateur et ce tri sera directement visible lorsque vous parcourrez votre
        collection.

        C'est un peu comme l'interface SortedSet<K> ?

        Tout à fait. Vous avez compris. Cette interface joue le même rôle pour l'interface Map<K,V>
        que l'interface SortedSet<K> pour l'interface Set<K>.

        Que les choses soient claires, le tri s'effectue sur les clés. Ce seront donc les objets utilisés
        comme clé qui devront implémenter l'interface Comparable<T> ! Sauf si vous utilisez un comparateur, bien entendu.

        Voici un tableau qui liste les méthodes qu'offre cette interface :

                      Methode                        |               Definition
     -------------------------------------------------------------------------------------------------------------------
     comparator()                                    |  Retourne le comparateur utilisé pour ranger les clé de la
                                                     |  collection, ou null si celle-ci utilise l'ordre naturel des clés.
     -------------------------------------------------------------------------------------------------------------------
     entrySet()                                      |   Nous l'avons vu dans le premier chapitre de cette partie. Cette
                                                     |   méthode retourne un Set<Map.Entry<K,V>> représentant une vue
                                                     |   des couple clé-valeur de la collection.
     -------------------------------------------------------------------------------------------------------------------
     firstKey()                                      |
                                                     |   Retourne la première clé de la collection.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     headMap(K toKey)                                |   Retourne une partie de la collection allant du début
                                                     |   jusqu'au paramètre, exclu.
     -------------------------------------------------------------------------------------------------------------------
                                                     |
     lastKey()                                       |   Retourne la plus grande de la collection.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     subMap(K fromKey, K toKey)                      |  Retourne une sous-collection ou les clés sont comprisent
                                                     |  entre le premier paramètre, inclus, et le deuxième paramètre, exclu.
     -------------------------------------------------------------------------------------------------------------------
     tailMap(K fromKey)                              |  Retourne une collection où les clés sont supérieures
                                                     |  ou égales au paramètre.
     -------------------------------------------------------------------------------------------------------------------
     values()                                        |  Retourne une collection contenant la liste des valeurs.
                                                     |
     -------------------------------------------------------------------------------------------------------------------

     //L'interface NavigableMap<K,V> hereda de SortedMAp
       ------------------------------
       Cette interface rajoute toute une batterie de méthodes qui permettent la navigation dans votre collection.
       Elle permet aussi et surtout de pouvoir naviguer dans votre collection dans les deux sens mais gardez en
       tête que le parcours ascendant est un peu plus rapide que le parcours descendant.

       Certaines méthodes, comme nous le verrons dans le tableau récapitulatif, sont surchargées et acceptent
       des arguments supplémentaires, notamment les méthodes qui retournent des sous-collections.

       Allez, le tableau des méthodes de cette interface :

                      Methode                        |               Definition
     -------------------------------------------------------------------------------------------------------------------
     ceilingEntry(K key)                             |  Retourne un objet Map.Entry<K,V> correspondant à la
                                                     |  plus petite clé supérieure ou égale au paramètre, ou null
                                                     |  s'il n'y a pas de clé.
     -------------------------------------------------------------------------------------------------------------------
     ceilingKey(K key)                               |  Retourne la plus petite clé supérieure ou égale
                                                     |  au paramètre, ou null s'il n'y a pas de clé.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     descendingKeySet()                              |  Retourne un objet NavigableSet<K> correspondant aux
                                                     |  clés de la collection, mais dans l'ordre inverse de celui de la
                                                     |  collection.
     -------------------------------------------------------------------------------------------------------------------
     descendingMap()                                 |   Retourne un objet NavigableMap<K,V> contenant notre
                                                     |   collection dans l'ordre inverse.
     -------------------------------------------------------------------------------------------------------------------
                                                     |   Retourne un objet Map.Entry<K,V> représentant le couple
     firstEntry()                                    |   clé-valeur de la plus petite clé de la collection, ou null s'il
                                                     |   n'y a pas de clé.
     -------------------------------------------------------------------------------------------------------------------
     floorEntry(K key)                               |  Idem que ci-dessus, mais sur la clé la plus grande
                                                     |  inférieure ou égale au paramètre
     -------------------------------------------------------------------------------------------------------------------
     floorKey(K key)                                 |  Retourne la plus grande clé inférieure ou égale au paramètre,
                                                     |  ou null s'il n'y a pas de clé.
     -------------------------------------------------------------------------------------------------------------------
     headMap(K toKey, boolean inclusive)             |  Retourne un objet NavigableMap<K,V> qui contiendra tous
                                                     |  les couples clé-valeur dont la clé est inférieure au
                                                     |  paramètre (ou égale si le deuxième paramètre est à true)
     -------------------------------------------------------------------------------------------------------------------
     higherEntry(K key)                              |  Retourne un objet Map.Entry<K,V> représentant le couple
                                                     |  clé-valeur de la plus petite clé de la collection strictement
                                                     |  supérieure au paramètre, ou null s'il n'y a pas de clé.
     -------------------------------------------------------------------------------------------------------------------
                                                     |
     higherKey(K key)                                |   Idem que ci-dessus mais retourne uniquement la clé.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     lastEntry()                                     |  Retourne un objet Map.Entry<K,V> représentant le couple
                                                     |  clé-valeur de la plus grande clé de la collection, ou null
                                                     |   s'il n'y a pas de clé.
     -------------------------------------------------------------------------------------------------------------------
     lowerEntry(K key)                               |  Idem que ci-dessus mais pour la plus petite clé de la collection.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     lowerKey(K key)                                 |  Retourne la plus grande clé strictement plus petite que le paramètre.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     navigableKeySet()                               |  Retourne un objet NavigableSet<K> représentant
                                                     |  une vue des clés de la collection.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     pollFirstEntry()                                |  Retourne un objet Map.Entry<K,V> correspondant à la
                                                     |  plus petite clé, tout en supprimant cette entrée de la
                                                     |  collection. Renvoie null si la clé n'existe pas.
     -------------------------------------------------------------------------------------------------------------------
                                                     |
     pollLastEntry()                                 |   Idem que ci-dessus mais pour la plus grande clé de la collection.
                                                     |
     -------------------------------------------------------------------------------------------------------------------
     subMap(K fromKey, boolean fromInclusive,        |  Retourne une portion de la collection délimitée par les clés
            K toKey, boolean toInclusive)            |  passées en paramètre et où les booléens servent à
                                                     |  déterminer si les limites sont inclusives ou exclusives.
     -------------------------------------------------------------------------------------------------------------------
     tailMap(K fromKey, boolean inclusive)           |  Retourne un objet NavigableMap<K,V> qui contiendra tous
                                                     |  les couples clé-valeur dont la clé est strictement
                                                     |  supérieure au paramètre (ou supérieure ou égale si le
                                                     |  deuxième paramètre est à true).
     -------------------------------------------------------------------------------------------------------------------


     Il y a beaucoup de méthodes, on est bien d'accord ! Et la plupart nous retourne soit une entrée de la
     collection soit une collection contenant tout ou parti de la collection d'origine. Maintenant que vous
     connaissez le contenu de ces deux interfaces voyons comment utiliser l'objet qui les implémente directement :
     l'objet TreeMap<K,V>.
         */
    }
}

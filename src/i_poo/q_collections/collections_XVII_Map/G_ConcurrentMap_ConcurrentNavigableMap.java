package i_poo.q_collections.collections_XVII_Map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class G_ConcurrentMap_ConcurrentNavigableMap {
    public static void main(String[] args) {
        /*
        Comme je vous l'avais dit et comme vous vous en doutiez sûrement déjà, ces deux interfaces sont implémentées
        par des objets qui seront utilisables dans un environnement où la concurrence multithread sera rude...

        Chacune de ces deux interfaces possède une implémentation héritant aussi de la classe AbstractMap<K,V>.
        Je vous propose de les passer en revue.

        L'interface ConcurrentMap<K,V>

        Celle-ci ajoute quelques méthodes à l'interface Map<K,V> :

                      Methode                        |               Definition
     -------------------------------------------------------------------------------------------------------------------
     putIfAbsent(K key, V value)                     |  Si la clé spécifiée en paramètre n'est pas déjà présente dans la
                                                     |  collection, le couple clé/valeur sera inséré dans la collection.
                                                     |  Cette méthode retourne la valeur correspondant à la clé passée,
                                                     |  donc si la valeur existe déjà, ce sera la valeur présente dans
                                                     |  la collection qui sera retournée et non la valeur en paramètre.
     -------------------------------------------------------------------------------------------------------------------
     remove(Object key, Object value)                |  Méthode supprimant le couple clé/valeur passée en paramètre. Si
                                                     |  ce couple n'est pas présent, aucune suppression n'est faite. Cette
                                                     |  méthode retourne un booléen si la suppression est effective
     -------------------------------------------------------------------------------------------------------------------
     replace(K key, V value)                         |   Fonctionne globalement comme la méthode ci-dessus mais ne
                                                     |   supprime pas le couple clé/valeur, la méthode remplace la valeur
                                                     |   de la clé et cette méthode ne retourne pas un booléen mais la
                                                     |   valeur modifiée et donc null si la clé n'existe pas.
     -------------------------------------------------------------------------------------------------------------------
     replace(K key, V oldValue, V newValue)          |   Comme la méthode ci-dessus mais contrôle l'existence du couple
                                                     |   clé/valeur. Retourne un booléen représentant le résultat.
     -------------------------------------------------------------------------------------------------------------------

     L'objet implémentant cette interface se nomme ConcurrentHashMap<K,V>. Cette implémentation autorise autant
     de lectures que vous le voulez en environnement multithread donc aucune exception de type
     ConcurrentModificationException ne sera levée.

     Voyons tout de suite son utilisation.

        */
        //On crée un objet et on y met une entrée
        ConcurrentMap<Integer, String> concurent = new ConcurrentHashMap<>();
        concurent.putIfAbsent(10, "toto");

        //On récupère la valeur
        String str = concurent.putIfAbsent(10, "titi");
        //Affiche toto car 10 est déjà présent
        System.out.println(str);

        System.out.println("Test de suppression de valeur");
        System.out.println("-----------------------------");
        //On tente de supprimer
        boolean bool = concurent.remove(10, "titi");
        //Et ça ne fonctionne pas
        System.out.println(bool);

        //Ici, ça fonctionnera
        bool = concurent.remove(10, "toto");
        System.out.println(bool);

        System.out.println("Test de replacement de valeur");
        System.out.println("-----------------------------");
        //On rajoute une entrée
        concurent.putIfAbsent(10, "tutu");
        //On tente le remplacement
        System.out.println(concurent.replace(20, "tata"));
        System.out.println(concurent.replace(10, "tata"));

        System.out.println(concurent.replace(10, "tutu", "tyty"));
        System.out.println(concurent.replace(10, "tata", "tyty"));
    }
}
/*  L'interface ConcurrentNavigableMap<K,V>

Cette interface permet de lier l'interface ConcurrentNavigableMap<K,V> vue ci-dessus et l'interface NavigableMap<K,V>.
Ceci permet donc d'avoir une collection qui a les propriétés de ces deux interfaces : l'utilisation en milieu
multithread et toute une panoplie de méthodes qui permettent de naviguer dans votre collection.

Je ne vais pas détailler le contenu de cette interface car elle reprend la plupart des méthodes l'interface
NavigableMap<K,V>, mais au lieu de retourner un objet NavigableMap<K,V>, elle retourne un objet ConcurrentNavigableMap<K,V>.

Une implémentation de cette interface est disponible : l'objet ConcurrentSkipListMap<K,V>. Ce dernier est une collection
triée selon l'ordre naturel de ses clés (sauf si vous utilisez un comparateur), et n'accepte pas de valeur null.

Comme je vous ai déjà présenté le mode de fonctionnement de ces interfaces, je ne vais pas me répéter...
je m'arrête donc là pour cet objet.

Encore un chapitre rondement mené. :-°

Voilà, vous venez de voir les derniers objets de ce framework Collections.
Ces derniers sont aussi très utiles et permettent de gérer certaines données plus simplement qu'avec
une collection conventionnelle.

J'espère que ce chapitre vous aura appris plein de choses et que les Map<K,V> n'auront plus de secrets pour vous.

Bon, maintenant les collections ne devraient plus avoir de secrets pour vous.
Comme je vous le disais, cette partie n'était pas très difficile en soi, mais elle est tout de même importante,
donc vous pouvez vous féliciter d'en être arrivés à bout. :)

*/
package i_poo.q_collections.collections_XVII_Map;

import java.util.*;
import java.util.Map.Entry;

public class F_TreeMap {
    public static void main(String[] args) {
        /*TreeMap<K,V> que implementa NavigableMap(que hereda de SortedMap)

        Comme vous vous en doutez déjà, cet objet est donc trié selon l'ordre naturel des clés le constituant,
        mais vous avez aussi la possibilité d'utiliser un comparateur si cet ordre ne vous convient pas. ;)

        Par contre, gardez en tête que cet objet n'est pas synchronisé : il existe d'autres objets qu'il faut
        préférer utiliser en milieu multithread, nous les aborderons dans la prochaine section de ce chapitre.

        Je vous propose un petit code d'exemple utilisant cet objet, vous allez voir, il est très simple d'utilisation :
        */

        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(10, "10");
        tm.put(50, "50");
        tm.put(20, "20");
        tm.put(40, "40");
        tm.put(30, "30");
        //Cette instruction affiche le contenu trié de la collection
        System.out.println(tm);

        //Exemple de méthodes de l'interface SortedMap<K,V>
        //-----------------------------------------------------
        //Retourne les deux premiers éléments de la collection
        System.out.println(tm.headMap(22));
        //Retourne les trois derniers éléments de la collection
        System.out.println(tm.tailMap(22));
        //retourne la liste des valeurs
        System.out.println(tm.values());

        //Exemple de méthodes de l'interface NavigableMap<K,V>
        //-----------------------------------------------------
        //Retourne le couple correspondant à la clé 40
        System.out.println(tm.ceilingEntry(32));
        //Retourne la première entrée de la collection
        System.out.println(tm.firstEntry());
        //Retourne la clé 50
        System.out.println(tm.lowerKey(61));
        //Retourne les couples correspondant aux clés 30 et 40
        System.out.println(tm.subMap(20, false, 40, true));

        System.out.println("Nous allons parcourir cette collection");
        Set<Entry<Integer, String>> set = tm.entrySet();
        Iterator<Entry<Integer, String>> it = set.iterator();

        //Nous créons une nouvelle collection avec un comparateur
        //pour trier dans le sens inverse
        TreeMap<Integer, String> tm2 = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //On parcourt notre itérateur
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry);
            //Et on insère dans notre nouvelle collection
            tm2.put(entry.getKey(), entry.getValue());
        }

        //La collection s'affiche bien dans le sens inverse de la précédente
        System.out.println(tm2);

        //une autre méthode pour parcourir une collection de ce type
        //mais cette fois, les éléments sont retirés au fur et à mesure...
        System.out.println("Dépilage de la deuxième collection :");
        Entry<Integer, String> entry = null;
        while ((entry = tm2.pollFirstEntry()) != null)
            System.out.println(entry);

        //A ce moment du programme, il n'y a plus rien dans la seconde collection
        System.out.println(tm2);
    }
}
/*
Pratique, n'est-ce pas ? Je vous propose maintenant de voir les deux dernières interfaces de ce
type de collection et leurs implémentations. Vous verrez que ces dernières ressemblent beaucoup à leurs cousines...
*/

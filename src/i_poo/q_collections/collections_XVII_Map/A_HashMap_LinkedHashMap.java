package i_poo.q_collections.collections_XVII_Map;

import java.util.*;
import java.util.Map.Entry;

public class A_HashMap_LinkedHashMap {
    public static void main(String[] args) {
        /*
        HashMap<K,V> et LinkedHashMap<K,V>

        Comme vous avez pu le voir dans le diagramme de classes vu précédemment, il y a cinq objets qui héritent
        de la classe AbstractMap<K,V>, elle-même implémentant directement l'interface Map<K,V>, sans autres
        interfaces supplémentaires. Beaucoup de ces objets travaillent sous forme de table de hachage, ce qui est
        logique vu qu'ils contiennent "Hash" dans leur nom... :-°

        Ces objets représentent donc une forme de base de cette interface et nous allons maintenant les
        voir plus en détail.

        Comme dit précédemment, ces deux objets sont deux des plus utilisés. Ils travaillent sous forme de
        table de hachage et leur principale différence réside dans le fait qu'un des deux gère en plus des
        liens chaînés (vous avez deviné duquel je parle...), ce qui fait que ce dernier permet de parcourir l
        es éléments de la collection dans l'ordre d'insertion alors que le second ne le permet pas...

        ///////////La valeur null est autorisée comme clé ou comme valeur.

        Voici un code d'exemple utilisant ces deux objets :
        */
        //La fameuse syntaxe en diamant de Java 7
        Map<Integer, String> hm = new HashMap<>();
        hm.put(10, "1");
        hm.put(20, "2");
        hm.put(30, "3");
        hm.put(40, "4");
        hm.put(50, "5");
        //Ceci va écraser la valeur 5
        hm.put(50, "6");

        System.out.println("Parcours de l'objet HashMap : ");
        Set<Entry<Integer, String>> setHm = hm.entrySet();
        Iterator<Entry<Integer, String>> it = setHm.iterator();
        while (it.hasNext()) {
            Entry<Integer, String> e = it.next();
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("Valeur pour la clé 8 : " + hm.get(8));

        Map<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(10, "1");
        lhm.put(20, "2");
        lhm.put(30, "3");
        lhm.put(40, "4");
        lhm.put(50, "5");

        System.out.println("Parcours de l'objet LinkedHashMap : ");
        Set<Entry<Integer, String>> setLhm = lhm.entrySet();
        Iterator<Entry<Integer, String>> it2 = setLhm.iterator();
        while (it2.hasNext()) {
            Entry<Integer, String> e = it2.next();
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
/*IMPRIME
  Parcours de l'objet HashMap :
   50 : 6
   20 : 2
   40 : 4
   10 : 1
   30 : 3
   Valeur pour la clé 8 : null
   Parcours de l'objet LinkedHashMap :
   10 : 1
   20 : 2
   30 : 3
   40 : 4
   50 : 5
*/
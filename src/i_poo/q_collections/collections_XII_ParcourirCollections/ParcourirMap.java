package i_poo.q_collections.collections_XII_ParcourirCollections;

import java.util.*;
import java.util.Map.Entry;

public class ParcourirMap {
    public static void main(String[] args) {
        //**************************************************************************************************************
        //                        Parcourir une implémentation de type MAp :
        //**************************************************************************************************************
        /* *************************************************************************************************************
        En fait, les objets implémentant cette interface sont un peu particuliers de par leur nature à gérer des
        couples d’éléments. Du coup, les concepteurs du langage vous proposent 3 MANIERES de parcourir une telle
        collection, en implémentant des méthodes de l’interface Collection :

        1) la méthode keySet() qui retourne une collection de type Set<K> lorsque "K" est le type de la clé de
           notre Map<K, V>.

        2) la méthode entrySet() qui retourne elle aussi une implémentation de l'interface Set, mais de type différent.
           La collection retournée sera définie ainsi Set<Entry<K, V>>. Ce sera donc une collection d'objets qui
           contiendra tous les couples clé - valeur de notre Map. Cet objet est en fait une classe interne à l'interface
           Map et contient quelques méthode utiles pour récupérer des informations.

        3) et enfin la méthode values() qui retourne ce type d'objet Collection<String>, c'est-à-dire la liste de nos valeurs.
        ***************************************************************************************************************/


        /* *
         * @param args
        */
            Map<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "toto");
            map.put(2, "titi");
            map.put(3, "tutu");
            map.put(4, "tete");
            map.put(5, "tata");
    //***************************************************1**************************************************************
            //Nous récupérons un Set contenant des entiers
            Set<Integer> setInt = map.keySet();
            //Utilisation d'un itérateur générique
            Iterator<Integer> it = setInt.iterator();
            System.out.println("Parcours d'une Map avec keySet : ");

            //ensuite vous savez faire
            while (it.hasNext()) {
                int key = it.next();
                System.out.println("Valeur pour la clé " + key + " = " + map.get(key));
            }
            System.out.println("-----------------------------------");

    //***************************************************2**************************************************************
            Set<Entry<Integer, String>> setEntry = map.entrySet();
            //Utilisation d'un iterateur générique
            Iterator<Entry<Integer, String>> itEntry = setEntry.iterator();
            System.out.println("Parcours d'une Map avec setEntry : ");

            //ensuite vous savez faire
            while (itEntry.hasNext()) {
                Map.Entry<Integer, String> entry = itEntry.next();
                System.out.println("Valeur pour la clé " + entry.getKey() + " = " + entry.getValue());
            }
            System.out.println("-----------------------------------");

    //**************************************************3***************************************************************
            Collection<String> col = map.values();

            Iterator<String> itString = col.iterator();
            System.out.println("Parcours de la liste des valeurs d'une Map avec values : ");

            //ensuite vous savez faire
            while (itString.hasNext()) {
                String value = itString.next();
                System.out.println("Valeur : " + value);
            }
            System.out.println("-----------------------------------");

            /*IMPRESION
            Parcours d'une Map avec keySet :
            Valeur pour la clé 1 = toto
            Valeur pour la clé 2 = titi
            Valeur pour la clé 3 = tutu
            Valeur pour la clé 4 = tete
            Valeur pour la clé 5 = tata
            -----------------------------------
            Parcours d'une Map avec setEntry :
            Valeur pour la clé 1 = toto
            Valeur pour la clé 2 = titi
            Valeur pour la clé 3 = tutu
            Valeur pour la clé 4 = tete
            Valeur pour la clé 5 = tata
            -----------------------------------
            Parcours de la liste des valeurs d'une Map avec values :
            Valeur : toto
            Valeur : titi
            Valeur : tutu
            Valeur : tete
            Valeur : tata
            -----------------------------------
            */

            //Du coup, quand doit-on utiliser telle ou telle méthode ?????
        /*
             En fait, tout dépend de ce que vous allez faire et de quelles données vous devrez manipuler.

             Si vous avez uniquement besoin des valeurs, préférez de loin la méthode values().

             Si vous n'avez que les clés à manipuler, utilisez la méthode keySet().

             Si vous avez besoin à la fois des clés et des valeurs de vos données, utilisez entrySet().
             Même si vous avez la possibilité de récupérer les valeurs d'une Map en fonction d'une clé,
             utilisez tout de même cette méthode car vous solliciterez moins la JVM.

             Voilà, vous savez maintenant parcourir des collections. :)
        */
        }
    }

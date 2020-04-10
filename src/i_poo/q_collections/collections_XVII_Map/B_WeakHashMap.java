package i_poo.q_collections.collections_XVII_Map;

import java.util.WeakHashMap;

public class B_WeakHashMap {
    public static void main(String[] args) {
        /*
         WeakHashMap<K,V>
         Cet objet embarque un mode de fonctionnement un peu particulier car les références contenues seront
         automatiquement supprimées dès lors que les clés utilisées sont considérées comme caduque — et par caduque
         je veux dire inaccessible car éliminée de la mémoire.

         La valeur null est autorisée comme clé ou comme valeur.

         Vous n'êtes pas sans savoir que Java utilise un Garbage Collector (ramasse-miettes) pour gérer sa mémoire
         et ainsi supprimer de celle-ci les objets qui ne servent plus à rien. Cette collection supprime automatiquement
         les entrées référencées par un objet qui est détruit par le ramasse-miettes.

         Un exemple sera plus parlant :
        */
        WeakHashMap<MyKey, String> whm = new WeakHashMap<>();
        MyKey key1 = new MyKey(1), key2 = new MyKey(2), key3 = new MyKey(3);
        whm.put(key1, "Valeur de toto");
        whm.put(key2, "Valeur de titi");
        whm.put(key3, "Valeur de tutu");

        //On affiche la collection
        System.out.println(whm);

        key1 = null;
        //On force le passage du ramasse-miettes
        //ce qui va détruire l'objet en mémoire
        //et donc dans la collection
        System.gc();
        System.out.println("\nAprès la destruction de la clé 1 par le ramasse-miettes : ");
        System.out.println(whm);

        key3 = null;
        System.gc();
        System.out.println("\nAprès la destruction de la clé 3 par le ramasse-miettes : ");
        System.out.println(whm);
    }
}//Vous pouvez voir qu'après la destruction de nos clés, la collection se vide d'elle-même...
//**********************************************************************************************************************
//                                Classe exterieur au ArrayLista_teoria
//**********************************************************************************************************************

/**
 * Cette objet sert uniquement comme exemple
 * Il contient un simple entier
 */
class MyKey {
    private int key = 0;

    public MyKey(int key) {
        this.key = key;
    }

    public String toString() {
        return "[MyKey:" + key + "]";
    }
}


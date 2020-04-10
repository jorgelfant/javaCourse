package i_poo.q_collections.collections_XVII_Map;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class C_IdentityHashMap {
    public static void main(String[] args) {
    /*
    Cet objet est aussi particulier dans le sens où il viole la contrainte de base des objets de types Map<K,V>
    car ce dernier n'utilise pas un système d'égalité par objet mais par référence.

    Je m'explique. D'ordinaire, ce genre de collection utilise l'égalité via la méthode equals(), mais cet objet
    utilise l'égalité par référence avec ==. La valeur null est autorisée comme clé ou comme valeur.

    Cet objet s'utilise dans de rares cas et ne définit pas un comportement normal comme les autres Map<K,V> !

    Pour bien comprendre, rien de tel qu'un bon exemple :
    */
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);

        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(i1, "toto");
        hm.put(i2, "titi");
        //Ici, vu que i1.equals(i2) == true
        //nous n'aurons qu'un seule entrée dans la collection
        System.out.println(hm);
        //Ces trois instructions renverront la même valeur
        System.out.println(hm.get(i1));
        System.out.println(hm.get(i2));
        System.out.println(hm.get(1));//objectKey

        System.out.println("----------------------------------");
        System.out.println("Maintenant avec IdentityHashMap : ");
        System.out.println("----------------------------------");
        IdentityHashMap<Integer, String> ihm = new IdentityHashMap<>();
        ihm.put(i1, "toto");
        ihm.put(i2, "titi");
        //Ici, vu que i1 == i2 => false
        //nous aurons deux entrées dans la collection
        System.out.println(ihm);
        //Ces trois instructions seront différentes
        System.out.println(ihm.get(i1));
        System.out.println(ihm.get(i2));
        System.out.println(ihm.get(1));

    }//Vous devez mieux saisir le caractère sensible de ce genre de collections...
}
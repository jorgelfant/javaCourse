package i_poo.q_collections.collections_XVII_Map;

import java.util.EnumMap;

public class D_enumMap {
    public static void main(String[] args) {
        //EnumMap<K,V>

        /*
        Cet objet se distingue par sa gestion des clés qui la constituent. Toutes les clés doivent provenir
        de l'énumération définie lors de l'instanciation de l'objet. De ce fait, la valeur null n'est pas
        autorisée comme clé.

        Voici un exemple simple :
        */
        EnumMap<Days, String> em = new EnumMap<>(Days.class);
        em.put(Days.LUNDI, null);
        em.put(Days.MARDI, "Métro");
        em.put(Days.MERCREDI, "Boulot");
        em.put(Days.JEUDI, "Dodo");
        em.put(Days.VENDREDI, "Boulot et apéro !");
        em.put(Days.SAMEDI, "Dodo et apéro !");
        em.put(Days.DIMANCHE, "apéro ! apéro ! apéro !");

        //affichage
        System.out.println(em);

        //Parcours de la collection
        for (Days d : Days.values())
            System.out.println(em.get(d));
    }
}//Pour cet exemple j'ai réutilisé la même énumération que dans le chapitre précédent. que yo cree aqui

enum Days {
    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE;
}
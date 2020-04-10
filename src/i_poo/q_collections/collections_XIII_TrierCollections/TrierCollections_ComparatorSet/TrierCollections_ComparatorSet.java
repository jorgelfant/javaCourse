package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparatorSet;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TrierCollections_ComparatorSet {
    public static void main(String[] args) {
        //Set TreeSet
        /*
        Déjà, si vous voulez avoir une implémentation de Set triée, je vous invite à utiliser l’objet
        TreeSet ou SortedSet. Pour pouvoir trier les objets que vous insérerez dans ce genre de collections,
        il faudra que ces objets implémentent l'interface Comparable, ou bien que vous passiez par un comparateur
        dans le constructeur. Voici un code d'exemple
        */
        Set<CD> set1 = new TreeSet<CD>();
        set1.add(new CD("Les arcandiers", "7€", 7d));
        set1.add(new CD("Frank Zappa", "Tinseltown rebellion", 10.25d));
        set1.add(new CD("Frank Zappa", "Bongo Fury", 10.25d));
        set1.add(new CD("King Crimson", "red", 15.30d));
        set1.add(new CD("Joe Zawinul", "World tour", 12.15d));

        Iterator<CD> it = set1.iterator();

        while (it.hasNext())
            System.out.println(it.next());

        //On crée directement un nouvel objet
        //en lui spécifiant sa façon de ranger les objets

        Set<CD> set2 = new TreeSet<CD>(new Comparator<CD>() {
            public int compare(CD cd1, CD cd2) {
                Double prix1 = (Double) cd1.getPrix();
                Double prix2 = (Double) cd2.getPrix();
                int result = prix1.compareTo(prix2);
                //dans le cas ou 2 CD auraient le même prix...
                if (result == 0) {
                    return cd1.compareTo(cd2);
                }
                return result;
            }
        });

        //On ajoute le contenu de la première collection
        //dans la deuxième
        set2.addAll(set1);

        System.out.println("-------------------------------");
        it = set2.iterator();

        while (it.hasNext())
            System.out.println(it.next());
    }
    /*
    Nous avons donc bien des implémentations de Set qui se comportent différemment selon les cas : challenge réussi !
    */
}

//class de TEST
class CD implements Comparable {

    private String auteur, titre;
    private double prix;

    public CD(String auteur, String titre, double prix) {
        this.auteur = auteur;
        this.titre = titre;
        this.prix = prix;
    }

    //metodo de Comparable*******************************************************************************
    public int compareTo(Object o) {
        if (o instanceof CD) {//ou if(this.getClass().equals(CD.class))
            CD otro = (CD) o;
            //En caso tengamos un CD con mismo autor, en 2 objetos diferentes on trie sur le nom du titre
            if ((this.auteur.compareTo(otro.getAuteur()) == 0)) {//si los autores son iguales (el mismo)
                return this.titre.compareTo(otro.getTitre());
            }
            return this.auteur.compareTo(otro.getAuteur());//nombre del artista
        }
        return -1;
    }

    //***************************************************************************************************
    public String toString() {
        return "CD [auteur=" + auteur + ", titre=" + titre + ", prix=" + prix
                + "]";
    }

    public String getAuteur() {
        return auteur;
    }

    public String getTitre() {
        return titre;
    }

    public double getPrix() {
        return prix;
    }

}
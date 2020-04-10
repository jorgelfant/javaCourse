package i_poo.q_collections.collections_XIII_TrierCollections.TrierCollections_ComparableComparator;

import java.util.*;

public class TrierCollections_ComparableComparator {
    public static void main(String[] args) {
        /*
        Alors, dans cette section, nous allons aborder une nouveauté. Déjà, vous devez savoir que certaines
        implémentations de l'interface Collection savent naturellement trier leur contenu, c'est le cas des
        objets TreeSet. Voyez plutôt :
        */
        //String ya tiene implementada la interface Comparable que tiene un unico metodo compareTo
        //asi como los Wrappers de la API JAVA o clases predefinidas de la biblioteca de java
        Set<String> tree = new TreeSet<>();
        tree.add("André");
        tree.add("Gislain");
        tree.add("Matthieu");
        tree.add("Cyrille");
        tree.add("Zoé");
        tree.add("Thierry");

        Iterator<String> it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    /*IMPRIME
       André
       Cyrille
       Gislain
       Matthieu
       Thierry
       Zoé        */

        //*****************************************************************************************************************
        //     Normalment las clases genericas de la Api JAva (String , Wrappers, ec)
        //     que ponemeos en un treeSet<> de Set<>  se ordenan automaticamente
        //     ya que implementan par defaut el methodo compareTo() de la Interface Comparable<E>
        //     y TreeSet<> tiene creo un metodo que permite usar este metodo de sus elementos , un espece de sort
        //     para ordenarlos en orden ascendente, OSEA ORDENARLOS COMO DEBE SER.
        //
        //*****************************************************************************************************************
        System.out.println();

        //*****************************************************************************************************************
        //       Mais vous avez aussi la possibilité d'utiliser la METHODE sort() de la clase COLLECTIONS, ainsi :
        //*****************************************************************************************************************

        //avec methode static sort() de la interface Collections
        //este metodo estatico pertenece a Collection y es estatica, no fue reescrita en las clases hijas
        List<Double> list = new ArrayList<Double>();
        list.add(-0.25d);
        list.add(12.52d);
        list.add(56.25d);
        list.add(-45.12d);
        list.add(-100.11d);
        list.add(0.005d);
        //Esto nos permite ordenar elementos de la lista , en orden ascendente
        //se usa en este caso para las Clases genericas (Wrappers, String..etc) de la API JAVA que ya par defaut
        //implementan la interface Comparable y su metodo compareTo()
        //el metodo sort() de Collection se sirve de este metodo para ordenarlos en orden
        //esto en el caso de las listas / Maps / Set que vienen desordenados, en la mayoria de sus subclases,

        //**************************************************************************************************************
        //ArrayList // LinkedList que se ordenan por insercion (orden de llegada)
        //HashSet  desordenado            //LinkedHashSet  ordenado por insercion    //treeSet ordenado (con clases de la API)
        //HashMap  ordenado por key       // LinkedHashMap  ordenado por insercion    //TreeMap  ordenado (con clases de la API)
        //**************************************************************************************************************

        //Esta funcion de la clase collections permite ordenar entonces a los objetos de un Set List , que en caso de que ya
        //las clases para defaut de la API ya implementen el metodo comparaTo de Comparable, no tienen el metro Sort
        //en su clase padre como si seria el caso de TreeSet<String> TreeSeet ya tiene el Set dentro, y String dentro el comparaTo()

        Collections.sort(list);

        Iterator<Double> itd = list.iterator();
        while (itd.hasNext()) {
            System.out.println(itd.next());
        }

        /*
        Vous pouvez aussi utiliser la méthode Arrays.sort(monTableau) pour trier des tableaux.
        */

        /* *************************************************************************************************************
          Voici un tableau récapitulatif des objets implémentant cette interface Comparable<T> et de leur mode de tri:
        **************************************************************************************************************/
        /*
                        Objet                            |                         Tri
        -------------------------------------------------------------------------------------------------
        Byte, Long, Integer, Short, Double, Float        |       Tri du plus petit au plus grand.
        BigInteger, BigDecimal                           |
        -------------------------------------------------------------------------------------------------
        Character                                        |       Tri du plus petit au plus grand en se
                                                         |       servant de ma représentation numérique
                                                         |       du caractère.
        -------------------------------------------------------------------------------------------------
        Boolean                                          |       Tri du plus petit au plus grand, avec false
                                                         |       plus petit que True.
        --------------------------------------------------------------------------------------------------
        String                                           |       Tri par ordre alphabetique.
        --------------------------------------------------------------------------------------------------
                                                         |       Dépend des chemins d'accès aux fichiers et
         File                                            |       donc du système d'exploitation, mais se
                                                         |       base sur l'ordre alphabétique des chemins.
        ---------------------------------------------------------------------------------------------------
         Date                                            |       Tri chronologique.
        ---------------------------------------------------------------------------------------------------
        CollationKey                                     |       Spécifique aux paramètres lexicographiques.
        ----------------------------------------------------------------------------------------------------
        */

        /*
        Vous pouvez donc trier des collections en utilisant ces objets selon leurs règles de tri prédéfinies
        dans le tableau ci-dessus… mais vous pouvez également définir vos propres règles de tri en utilisant
        des objets perso qui implémentent l'interface Comparable.

        Attends ! Tu veux dire que nous ne pouvons pas trier des chaînes de caractères par leur taille par exemple ?

        Si, bien sûr, mais avant de vous expliquer comment définir une façon de comparer spécifique,
        nous allons nous attarder à créer des objets et implémenter l'interface Comparable.
        */
        System.out.println();
        //*******************************************************************************************************************
        //En el ArrayLista_teoria implementamos la classe CD

        List<CD> lista = new ArrayList<>();
        lista.add(new CD("Les arcandiers", "7€", 7d));
        lista.add(new CD("Frank Zappa", "Tinseltown rebellion", 10.25d));
        lista.add(new CD("Artur Sanchez", "Bongo Fury", 10.25d));
        lista.add(new CD("Frank Zappa", "Adios amigos", 10.25d));
        lista.add(new CD("King Crimson", "red", 15.30d));
        lista.add(new CD("Joe Zawinul", "World tour", 12.15d));

        System.out.println("Avant le tri : ");
        Iterator<CD> itl = lista.iterator();
        while (itl.hasNext()) {
            System.out.println(itl.next());
        }
        //Collections tiene 2 metodos sort()
        /*
        static <T extends Comparable<? super T>>  void             sort(List<T> list)
        Sorts the specified list into ascending order,
                according to the natural ordering of its elements.

        static <T> void                                            sort(List<T> list, Comparator<? super T> c)
        Sorts the specified list according to the order
        induced by the specified comparator.
        */
        //nous créons une classe anonyme ici, mais rien ne vous empêche d'en créer une dans un fichier séparé

        Collections.sort(lista, new Comparator<CD>() {

            public int compare(CD o1, CD o2) {
                Double prix1 = (Double) o1.getPrix();//convierto double en Double
                Double prix2 = (Double) o2.getPrix();//el precio se vuelve un objeto Double prix
                int result=prix1.compareTo(prix2);
                //compareTo() funciona con objetos, razon para el castin double Double da 0 1 o -1
                //dans le cas ou 2 CD auraient le même prix...
                if (result==0) {//compara precios, si son los mismos entonces..
                    return o1.compareTo(o2);//...compara uno de los otros atributos, autor, luego titre
                }                           //mismo precio y autor entonces intentara con titre
                return prix1.compareTo(prix2);
            }
        });
        //CD que es una clase propia ( y no generica como String, Integer, etc)
        //y que no tiene implementada la interface Comparable<T> , metodo comparaTo()
        System.out.println("Après le tri avec notre Comparator: ");
        itl = lista.iterator();
        while (itl.hasNext()) {
            System.out.println(itl.next());
        }
    }
    /*
      Et voilà ! Le tour est joué !
      Ici, nous n'avons défini qu'une façon très simple de comparer nos objets. Vous aurez remarqué que,
      pour un même auteur, nous pouvons avoir plusieurs albums...

      Pour arranger cela, nous n’avons qu'à gérer ce cas dans notre méthode compareTo()
    */

    /* *****************************************************************************************************************
      Voyons maintenant comment la méthode Collections.sort() fonctionne. Déjà, vous pourrez constater que la signature
      de cette méthode est très... étrange... La voici pour ceux qui ne l’auraient pas remarqué :

                       ______________________________________________
                      |                                             |
      public static <T extends Comparable<? super T>> void sort(List<T> list)
                       ------------------   --------
                               ^                ^                 ^
                               |                |                 |
                     ----------                 |                 -------------
                   /                            |                              \
           Ceci signifie que T          Et ceci indique que              Ah oui! Seul le type List
           doit être de type            le contenu de la                 (et ses souclasses) est accepté !
           Comparable                   liste accepte le
                                        type T et toutes
                                        ses sous-classes

     La méthode attend donc un certain type d'objet et se sert des résultats retournés par la méthode
     compareTo() pour ranger les éléments.

     Collections.sort(List<T> lista)  solo funciona con listas este metodo y no con Set o Map

     Attends ! Tu nous dis que nous ne pourrons trier que des List ?

     De cette manière, oui. Mais vous devez savoir que certaines implémentations de l'interface Set sont déjà triées,
     toujours parce que les objets qu’elles contiennent implémentent l'interface Comparable<T>.

     Par contre, pour pouvoir trier des collections de type Map nous allons utiliser une autre interface qui permet,
     en plus, de trier de façon différente des objets implémentant déjà l'interface Comparable<T>.
    *******************************************************************************************************************/

    //Comparable sert surtout pour ordonner les Collections de type List<T>  compareTo()    Collections.sort(List<T> lista)

    // pour pouvoir trier des collections de type Map nous allons utiliser une autre interface qui permet,
    // en plus, de trier de façon différente des objets implémentant déjà l'interface Comparable<T>.


    /* *****************************************************************************************************************
    //                                                COMPARATOR
    //******************************************************************************************************************
      Précédemment, nous avons vu comment rendre un objet comparable à un autre afin de pouvoir trier nos collections,
      de type List. Mais maintenant, si nous souhaitons de temps en temps trier nos CD non plus en fonction de leur
      auteur et leur nom mais en fonction de leur prix, c'est là que l'interface Comparator<T> entre en jeu !

      Osea pa tener 2 ordenadores en funcion de lo que quiero ya que compareTo() slo puede ser implementada una vez

      En fait, il existe une autre méthode sort() dans la classe Collections qui, elle, prend une collection et
      un objet de type Comparator<T> en paramètre.
      ----------------------------------------------------------------------------------------------------------------
      static <T extends Comparable<? super T>>  void             sort(List<T> list)
                                                                 Sorts the specified list into ascending order,
                                                                 according to the natural ordering of its elements.

      static <T> void                                            sort(List<T> list, Comparator<? super T> c)
                                                                 Sorts the specified list according to the order
                                                                 induced by the specified comparator.
      ----------------------------------------------------------------------------------------------------------------
      Que contient cette interface ?

      Elle contient une méthode equals(Object o) et une méthode compare(T el1, T el2). C'est cette dernière qui va nous
      intéresser ici. Elle fonctionne de la même manière que sa petite cousine compareTo() dans le sens où elle renvoie
      un entier négatif, positif ou égal à 0 dans les différents cas, comme vu précédemment.

      Ce que je vous propose, c'est de voir comment trier notre liste de CD par prix, tout en conservant la
      méthode compareTo() dans la classe CD. Voici le code qui permet de faire cela :

      ***************************************************************************************************************/


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
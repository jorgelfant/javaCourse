package i_poo.q_collections.collections_XII_ParcourirCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class ParcourirCollections {
    public static void main(String[] args) {
        /*
        Comme vous le savez déjà, il y a deux façons de parcourir une collection, en fonction de son type :

        1) soit avec un ITERATOR ou un SIMPLE BOUCLE pour les collections de type COLLECTION ;

        2) soit avec une COLLECTION pour les COLLECTION de type MAP.

        Je vous propose de refaire un point rapide sur la façon de procéder. Promis, ça ne sera pas long et ça
        vous sera bien utile pour la suite. :)
        */

        //**************************************************************************************************************
        //                        Parcourir une implémentation de type Collection :
        //**************************************************************************************************************

        //Comme je vous le disais, ce type d'interface comporte un objet bien pratique : un Iterator. Voici les
        // méthodes présentes dans cette interface :
        /*
                                        public interface Iterator<E> {
                                            boolean hasNext();
                                            E next();
                                            void remove();
                                       }
        */
        /* *************************************************************************************************************
        .parcourir une collection, via la méthode hasNext(). Cette méthode retourne true s'il reste des éléments à
         parcourir ;

        .récupérer un élément, grâce à la méthode next(). Celle-ci retourne l'élément courant dans l'itérateur. Si vous
         invoquez cette méthode plusieurs fois dans une boucle de parcours, cela vous fait avancer dans la lecture de
         la collection, un peu comme si vous incrémentiez plusieurs fois le compteur d'une boucle for ;

        .supprimer un élément, en utilisant la méthode remove(). Cette méthode n'est utilisable qu'après avoir utilisé
         la méthode next() et n'est utilisable qu'une seule fois par appel à la méthode next().

        ***************************************************************************************************************/

        //Lorsque vous parcourez une collection, vous ne pouvez supprimer qu'un seul élément par tour de boucle,
        //         sinon une exception sera levée !

        //EJEMPLO:

        //nous créons une collection basique
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");

        //Un petit compteur pour récupérer les tours de boucle
        int nbTourDeBoucle = 0;
        int nbTourDeBoucle2 = 0;

        //Nous récupérons notre itérateur OU "Iterator<String> it=list.iterator();"  esto evita el posterior cast
        Iterator it = list.iterator();//on l'a pas crééer avec iterator() on récupere un objet de typy Iterator<E>
        //qu'on est en train de mettre dans nobre objet de type Iterator

        //tant qu'il y a des éléments à parcourir
        while (it.hasNext()) {

            nbTourDeBoucle++;
            //nous récupérons l’élément courant
            String str = (String) it.next();//it es de tipo iterador por eso hacemos el cast
            //si nous sommes sur l'élément 4, nous le retirons de la collection
            if (str.equals("4"))
                it.remove();
        }
        //nous reparcourons un nouvel itérateur

        //pour nous assurer que tout a fonctionné
        it = list.iterator();//reinicia el iterador

        while (it.hasNext()) {

            nbTourDeBoucle2++;
            System.out.println(it.next());//1  5
            System.out.println(it.next());//2  6
            System.out.println(it.next());//3  7
        }
        //Habian al inicio 7 elementos, al entrar a la 2da boucle hay solo 6 (se borro uno en el 1er while)
        System.out.println("Nombre de tours de boucle N°1 : " + nbTourDeBoucle);//da 7 vueltas (en una de ellas borra un elem)
        System.out.println("Nombre de tours de boucle N°2 : " + nbTourDeBoucle2);//2 vueltas
        /*IMPRESSION
        1
        2
        3
        5
        6
        7
        Nombre de tours de boucle N°1 : 7
        Nombre de tours de boucle N°2 : 2
        */

        /* *************************************************************************************************************
        Comme nos collections sont construites pour pouvoir travailler avec des types génériques, nous pouvons aussi
        récupérer un itérateur générique. Je ne l'ai pas fait ici mais vous auriez pu faire ceci :

                                     Iterator<String> it = list.iterator();

        ce qui évite d'avoir à caster les résultats retournés par la méthode next().

        Je ne vous conseille pas d'utiliser plusieurs fois la méthode next() dans une boucle. Pour comprendre pourquoi,
        je vous invite à initialiser la liste avec seulement 6 éléments au lieu de 7...  Normalement, vous allez voir une
        belle exception de levée : java.util.NoSuchElementException.
         **************************************************************************************************************/

        System.out.println();

        /* *************************************************************************************************************
        Les trois méthodes de l'interface Iterator que nous avons vues ci-dessus travaillent de concert et gèrent
        toutes les opérations entre elles. Lorsque vous supprimez un élément pendant le parcours, le contenu de
        l'itérateur ainsi que la méthode hasNext() sont mis à jour automatiquement. La méthode hasNext() sera donc
        automatiquement au courant qu'un élément n'est plus présent... J'ajouterai que la méthode remove() est la
        seule façon sûre de supprimer un élément d'une collection pendant un parcours.
        ***************************************************************************************************************/

        //Je vous disais aussi que vous pouvez parcourir ce genre de collection grâce à une boucle traditionnelle,
        // voici comment procéder :
        for (String element : list) {
            System.out.println(element);
        }
        System.out.println();

        //Ou encore
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        /* *************************************************************************************************************
        Vous avez donc deux méthodes différentes (les itérateurs et les boucles) pour parcourir ce genre de collections,
        mais préférez tout de même l'itérateur dans les cas suivants :

         .quand vous devez supprimer des éléments de la collection ;

         .quand vous devez parcourir plusieurs collections en parallèle.
        ***************************************************************************************************************/

    }
}

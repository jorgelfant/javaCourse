package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.IV_Iterateur;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Exemple_I {

  public static Iterator<Integer> range(int start, int end) {
    return new Iterator<Integer>() {
      private int index = start;

      @Override
      public boolean hasNext() {
        return index < end;
      }

      @Override
      public Integer next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return index++;
      }
    };
  }


  public static void main(String[] args) {

    Iterator iterator = range(0, 10);
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // or using a lambda
    iterator.forEachRemaining(System.out::println);
  }
}
//======================================================================================================================
//                           Parcourir un ensemble d'objets à l'aide d'un objet de contexte
//======================================================================================================================
/*
L'itérateur est un patron de conception comportemental.

Un itérateur est un objet qui permet de parcourir tous les éléments contenus dans un autre objet, le plus souvent
un conteneur (liste, arbre, etc.). Un synonyme d'itérateur est curseur, notamment dans le contexte des bases de données
*/

//======================================================================================================================
//                                                 Description
//======================================================================================================================
/*
Un itérateur ressemble à un pointeur disposant essentiellement de deux primitives : accéder à l'élément pointé en
cours (dans le conteneur), et se déplacer pour pointer vers l'élément suivant. En sus, il faut pouvoir créer un
itérateur pointant sur le premier élément ; ainsi que déterminer à tout moment si l'itérateur a épuisé la totalité
des éléments du conteneur. Diverses implémentations peuvent également offrir des comportements supplémentaires.

Le but d'un itérateur est de permettre à son utilisateur de parcourir le conteneur, c'est-à-dire d'accéder
séquentiellement à tous ses éléments pour leur appliquer un traitement, tout en isolant l'utilisateur de la
structure interne du conteneur, potentiellement complexe. Ainsi, le conteneur peut stocker les éléments de la
façon qu'il veut, tout en permettant à l'utilisateur de le traiter comme une simple liste. Le plus souvent
l'itérateur est conçu en même temps que la classe-conteneur qu'il devra parcourir, et ce sera le conteneur
lui-même qui créera et distribuera les itérateurs pour accéder à ses éléments.
*/
//======================================================================================================================
//                                        Différences avec l'indexation
//======================================================================================================================
/*
Dans les langages procéduraux on utilise souvent un index dans une simple boucle, pour accéder séquentiellement
à tous les éléments, notamment d'un tableau. Quoique cette approche reste possible en programmation objet pour
certains conteneurs, l'utilisation des itérateurs a certains avantages :

.Un simple compteur dans une boucle n'est pas adapté à toutes les structures de données, en particulier :
     .celles qui n'ont pas de méthode d'accès à un élément quelconque,
     .celles dont l'accès à un élément quelconque est très lent (c'est le cas des listes chaînées et des arbres).

.Les itérateurs fournissent un moyen cohérent d'itérer sur toutes sortes de structures de données, rendant ainsi
 le code client plus lisible, réutilisable, et robuste même en cas de changement dans l'organisation de la structure
 de données.

.Une structure arborescente peut fournir différents types d'itérateurs retournant les nœuds de l'arbre dans un
  ordre différent : parcours récursif, parcours par niveau, ...

.Un itérateur peut implanter des restrictions additionnelles sur l'accès aux éléments, par exemple pour empêcher
 qu'un élément soit « sauté », ou qu'un même élément soit visité deux fois.

.Un itérateur peut dans certains cas permettre que le conteneur soit modifié, sans être invalidé pour autant.
 Par exemple, après qu'un itérateur s'est positionné derrière le premier élément, il est possible d'insérer d'autres
 éléments au début du conteneur avec des résultats prévisibles. Avec un index on aurait plus de problèmes, parce que
 la valeur de l'index devrait elle aussi être modifiée en conséquence.

*Important : il est indispensable de bien consulter la documentation d'un itérateur pour savoir dans quels cas il
 est invalidé ou non.

La possibilité pour un conteneur de se voir modifié pendant une itération s'est imposée comme nécessaire dans la
programmation objet moderne, où les relations entre objets et l'effet de certaines opérations peut devenir un
casse-tête. En utilisant un tel itérateur « robuste », ces désagréments nous sont épargnés.
*/

//======================================================================================================================
//                                     Utilisation d'un itérateur explicite
//======================================================================================================================


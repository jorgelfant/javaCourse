package i_poo.t_LambdasII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class LambdasII {
    public static void main(String[] args) {
        /*
        //**************************************************************************************************************
        //                           Le package java.util.function
        //**************************************************************************************************************

        Ce package qui fait également parti des nouveautés de Java 8 embarque une quarantaine
        d'interfaces fonctionnelles qui peuvent répondre à vos besoins sans que soyez obligé de
        faire votre propre interface notamment car celui-ci tire un grand avantage des génériques.

        Parmi toutes les interfaces disponibles, voici cinq des interfaces utilisant des génériques
        et représentant un type de traitement :

        .java.util.function.Function<T,R>  : sa méthode fonctionnelle a la signature R  apply(T t)  .
         Elle permet donc de traité un paramètre T et de renvoyer un type R.

        .java.util.function.Predicate<T>  : sa méthode   boolean test(T t)  permet, comme vous vous
         en doutez, de faire un test sur le paramètre et de retourner un  boolean  en fonction du résultat.

        .java.util.function.Consumer<T>  : Cette interface fonctionnelle est un peu particulière car
         c'est la seule qui a pour vocation de modifier les données qu'elle reçoit. Sa méthode fonctionnelle
         void accept(T t)  est faite pour appliquer des traitements au paramètre passer et ne retourne rien.

        .java.util.function.Supplier<T>  : Celle-ci permet de renvoyer un élément de type T sans prendre de
         paramètre via la méthode fonctionnelle  T get().

        .java.util.function.BinaryOperation  : S'utilise pour les opération de type reduce comme additionner
         deux  int  par exemple (on y reviendra lorsque nous parlerons des streams). Sa méthode   T apply(T t, T t2)
         prend deux T en paramètre et renvoi un  T (T BynaryOperation(T,T).

        Attention : dans ces interfaces, je n'ai mentionné que leur méthode fonctionnelle. Elles peuvent avoir
        des méthodes par défauts.

        Il existe des dérivées de ces interfaces qui spécifient un peut plus leur fonctionnement. Par exemple
        il existe une interface  IntFunction  dont la signature de la méthode  apply  est la suivante :
        R apply(int value)  . L'interface renverra un type generique mais prendra un entier en paramètre.
        Il existe un bon nombre de ces interfaces et, en général, elles sont présentent pour chaque type mentionné
        ci-dessus. En voici une liste non exhaustive

        IntFunction, IntSupplier, IntBinaryOperation, IntConsumer, IntToDoubleConsumer, IntToDoubleFunction, …

        Comme je vous le disais, il y a de forte chance que vous trouviez ce dont vous avez besoin dans toutes
        ces interfaces fonctionnelles. Comme rien ne vaut la pratique, nous allons tout de suite utiliser ce
        package et, pour avoir des exemples simples, nous allons utiliser une classe très minimaliste :
        */

        /*    java.util.function.Function<T,R>
              ********************************
              Nous pouvons par exemple transformer une collection de Personne en collection de String représentant
              leurs noms ou en collection d'entier représentant leurs ages. Voici un code illustrant ceci :
        */
        List<Personne> lPersonne = Arrays.asList(
                new Personne(10, "toto"),
                new Personne(20, "titi"),
                new Personne(30, "tata"),
                new Personne(40, "tutu")
        );
        //           T       R          Elle permet donc de traité un paramètre T et de renvoyer un type R.  apply(T t)
       /*
        Function<Personne, String> f1 = (Personne p) -> p.getNom();
        Function<Personne, Integer> f2 = (Personne p) -> p.getAge() * 2;
        System.out.println(transformToListString(lPersonne, f1));
        System.out.println(transformToListInt(lPersonne, f2));
       */
       /*
        Et ce code nous donne le résultat suivant :
        [toto, titi, tata, tutu]
        [20, 40, 60, 80]

        C'est un code d'exemple, rien d'extravagant... Je vais en profiter pour vous montrer aussi comment surcharger
        une méthode par défaut de ces interfaces fonctionnelles. Par exemple, dans celle que nous venons d'utiliser,
        il y a la méthode  addThen  qui permet d'appliquer une fonction après le traitement. Par exemple, nous obtenons
        exactement le même résultat que précédemment avec ce code :                                                  */

        Function<Personne, String> f1 = (Personne p) -> p.getNom();
        // On ne multiplie plus l'age par 2
        Function<Personne, Integer> f2 = (Personne p) -> p.getAge();
        // Nous définissons un traitement supplémentaire sur l'âge
        Function<Integer, Integer> f3 = (Integer a) -> a * 2;
        System.out.println(transformToListString(lPersonne, f1));
        System.out.println(transformToListInt(lPersonne, f2.andThen(f3)));

    }
    //******************************************************************************************************************
    //                                       Metodos fuera del main
    //******************************************************************************************************************
    //estos metodos usans 2 parametros; el segundo que es une interface funcional es necesario pa usar su metodo apply
    //es decir que el segundo paramtro no lo uso directamente sino su metodo
    public static List<String> transformToListString(List<Personne> list, Function<Personne, String> func) {
        List<String> ls = new ArrayList<>();
        for (Personne p : list) {
            ls.add(func.apply(p));
            //func.apply(p) retournera ici le nom de l'objet Personne
        }
        return ls;
    }

    public static List<Integer> transformToListInt(List<Personne> list, Function<Personne, Integer> func) {
        List<Integer> ls = new ArrayList<>();
        for (Personne p : list) {
            ls.add(func.apply(p));
            //func.apply(p) retournera ici l'âge multiplié par 2 de l'objet Personne
        }
        return ls;
    }
}

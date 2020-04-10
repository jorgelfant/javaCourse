package i_poo.t_ReferencesDeMethodes;

import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class ReferenceDeMethodes {
    public static void main(String[] args) {
        /*
        Une référence de méthode sert a définir une méthode abstraite d'une interface fonctionnelle.
        Cette magie opère grâce à un nouvel opérateur «   ::   ». La méthode qui va être implémenter
        dans l'interface fonctionnelle par ce biais ne devra pas être soumis à aucune ambiguïté et devra,
        vous l'aurez compris, correspondre à la signature de la méthode abstraite.

        Pour simplifier au maximum, une référence de méthode est une lambda ultra simplifiée en utilisant
        ni plus ni moins qu'une méthode déjà existante dans une interface (méthode statique) classe (méthode statique ou constructeur)
        ou encore une méthode d'une instance de classe. Voici comment la syntaxe est faite :

        « classe, interface ou instance » ::  « Nom de la méthode »

        Tout cela semble barbare mais c'est très simple en fait, vous comprendrez beaucoup mieux avec l'exemple de
        code ci dessous (nous en profiterons pour voir d'autres interfaces fonctionnelles présentes dans Java 8)  :
        */


        //Conversion d'un String en Double avec une référence à une méthode statique
        //clase y luego el metodo
        ToDoubleFunction<String> stringToDoubleLambda = (s) -> Double.parseDouble(s);
        ToDoubleFunction<String> stringToDoubleRef = Double::parseDouble;
        System.out.println(stringToDoubleLambda.applyAsDouble("0.1234567"));
        System.out.println(stringToDoubleRef.applyAsDouble("0.1234567"));

        //Utilisation d'une référence à une méthode d'instance (println)
        //de l'instance out de la classe 'System'
        Consumer<String> stringPrinterLambda = (s) -> System.out.println(s);
        Consumer<String> stringPrinterRef = System.out::println;
        stringPrinterLambda.accept("Bonjour !");
        stringPrinterRef.accept("Bonjour !");

        //Ici, nous utilisons carrément un constructeur
        //Notre interface fonctionnelle devient une fabrique d'Integer !

        ToIntFunction<String> testNew = Integer::new;//define lo que va a hacer el metodo
        Integer i = testNew.applyAsInt("1235");
        System.out.println("New Integer created : " + i.getClass());
        /*
        Les commentaires se suffisent à eux-mêmes. Le code ci-dessus nous fournit la sortie suivante :

        0.1234567
        0.1234567
        Bonjour !
        Bonjour !
        New Integer created : class java.lang.Integer

        Ce chapitre touche maintenant à sa fin, j'espère que celui-ci ne vous a pas trop donner
        mal à la tête et que vous êtes prêt pour une autre nouveauté de Java 8, et pas des moindres : les streams !

        En résumé:

        .Les classes anonymes, les lambdas et les références de méthodes permettent de réduire la taille de votre code.

        .Les lambdas, les interfaces fonctionnelles, le package  java.util.function  et les références de méthode
         existent depuis Java 8.

        .Une interface fonctionnelle est une interface n'ayant qu'une seule méthode abstraite.

        .Une lambda permet de redéfinir une méthode d'une interface fonctionnelle très simplement de façon moins
         verbeuse qu'une classe anonyme.

        .Il y a de très forte chance que vous trouviez une interface fonctionnelle qui remplisse votre besoin dans le
         java.util.function  .
        */
    }
}

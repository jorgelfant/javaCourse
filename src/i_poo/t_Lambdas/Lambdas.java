package i_poo.t_Lambdas;

public class Lambdas {
    public static void main(String[] args) {
        //Encore moins de code avec les lambdas !
    /*
    Avant Java 8, il n’existait que deux types de références, des valeurs primitives (char c = 'C' ;) et
    des références vers des objets (String s = new String("Hello");).

    Dans d'autres langages par contre, il existe des références vers ce qu'on appelle des closures :
    des morceaux de codes anonymes. Jusqu'en Java 7, la seul façon d'avoir ce type de référence revenait a
    faire une classe anonyme comme vu précédemment.

    Depuis Java 8, les closures existent et s'appellent les lambdas. Le parallèles avec les classes/méthodes anonymes
    est volontaire car les deux se conçoivent de la même manière : elles peuvent prendre des arguments et
    retourne un résultat. Pour simplifier au maximum, une lambda est la redéfinition d'une méthode d'une interface
    fonctionnelle sans avoir à faire une classe anonyme, donc gain de ligne de code et de visibilité.

    Ainsi, nous allons pouvoir rencontrer un nouvel opérateur : ->.
    Gardez en mémoire qu'une lambda permet de redéfinir une méthode abstraite d'une interface fonctionnelle donc,
    par conséquent, elle doit répondre à la signature de la méthode concernée.Voici concrètement comment se construit
    une expression lambda :

      () -> faire une action;
      (param1, param2) -> faire une action;
      (param1, param2, param3) -> {traitements ; retourne une valeur;} ;

     Le plus simple pour appréhender ce nouvel opérateur est de vous le faire découvrir par le biais de plusieurs
     exemples pour vous expliquer cette syntaxe un peu spéciale...
    */

    /*
    () -> 1337 ;

     Ici, notre lambda ne prend aucun paramètre et retourne tout le temps 1337. Ca doit être la lambda la plus simple...
     Notez qu'ici, la lambda retourne la valeur 1337 alors que nous n'avons pas utilisé le mot clé return" : ceci est
     dû au fait que notre lambda ne fait qu'une et une seule tâche dans ce cas et uniquement dans ce cas, le mot clé
     return  ainsi que les accolades '{ }' sont facultatif. Par contre, il faut toujours terminer un lambda par un ';'.
     Cette lambda peut donc être utilisée pour remplacer une méthode fonctionnelle qui retourne un
     nombre (  int  ,  double  ,  float  ,  long  ) et ne prend pas de paramètre. Continuons avec d'autres exemples.

     () -> { System.out.println("Bonjour lambda !") ; return 1337} ;

     Ici, la lambda est presque identique à la précédente à l'exception près que là, nous affichons un message dans
     la console avant de retourner un entier. Ici nous avons donc plusieurs actions dans le corps de notre lambda,
     de ce fait, nous devons entourer tout le corps avec des accolades, sans oublier le ' ;' final ! Allez, un dernier
     exemple pour la route :

     (a, b) -> {System.out.println("coucou"); return a + b;};

     Ici, vous l'aurez compris, notre lambda sera à utiliser pour une interface fonctionnelle ayant une
     méthode abstraite attendant deux paramètres et retournant un type numérique.

     Maintenant que vous êtes familier de la syntaxe des lambdas nous allons l'utiliser et, pour cela, nous
     allons avoir besoin d'une interface fonctionnelle : ça tombe bien, on en a justement quelques unes sous
     la main grâce au chapitre précédent mais, pour l'aspect pédagogique, nous allons créer une nouvelle interface,
     disons :

     @FunctionalInterface
      public interface Dialoguer {
          public abstract void parler(String question);
      }

      Et pour bien vous montrer la différence de code, voici comment nous aurions dû redéfinir ceci avec les
      classes anonymes :
    */

        //Classe anonyme
        Dialoguer d = new Dialoguer() {
            public void parler(String question) {
                System.out.println("Tu as dis : " + question);
            }
        };
        d.parler("Bonjour");


        //Et voilà le même code avec une lambda :
        // ou         (String s)
        Dialoguer e = (s) -> System.out.println("Tu as dis : " + s);
        e.parler("Bonjour");



        /*
        Et voilà, votre première lambda. Vous venez de redéfinir la méthode abstraite de l'interface fonctionnelle
        Dialoguer  et vous l'avez utilisez. Notez bien que n'avez fait que redéfinir la méthode, pour l'utiliser
        vous devez l'invoquer.

        Afin de décrire rapidement la signature d'une méthode abstraite présente dans une interface fonctionnelle,
        Java 8 a introduit le terme « Descripteur de fonction » qui permet de traduire la méthode en lambda. Ainsi,
        la description de fonction de notre interface d'exemple est : (String) -> void. Elle prend un paramètre de
        type String et ne retourne rien.  Pour terminer, deux petites recommandations :

         .Les lambdas doivent êtres concises, sinon le code ne sera pas plus lisible qu'avec une classe anonyme habituelle ;

         .elles doivent être simple à comprendre pour que le débogage reste trivial en cas de problème.

         .Ce sont deux choses à avoir à l'esprit sous peine de complexifier votre travail au lieu de le simplifier.
        */

    }
}
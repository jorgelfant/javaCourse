package i_poo.o_exceptiones.except_openclassroom;

public class Except_3_exceptions_personnalisées {
    public static void main(String[] args) {
        /*
        Nous allons perfectionner un peu la gestion de nos objets Ville et Capitale. Je vous propose de mettre en œuvre
        une exception de notre cru afin d'interdire l'instanciation d'un objet Ville ou Capitale présentant un nombre
        négatif d'habitants

        La procédure pour faire ce tour de force est un peu particulière. En effet, nous devons :

          1.créer une classe héritant de la classe Exception : NombreHabitantException (par convention,
            les exceptions ont un nom se terminant par « Exception ») ;

          2.renvoyer l'exception levée à notre classe NombreHabitantException ;

          3.ensuite, gérer celle-ci dans notre classe NombreHabitantException.
        */

        //ALLER à a_ville_heritage_capital

        /*
        Maintenant que nous avons vu la création d'une exception, il serait de bon ton de pouvoir récolter plus de
        renseignements la concernant. Par exemple, il serait peut-être intéressant de réafficher le nombre d'habitants
        que l'objet a reçu. Pour ce faire, nous n'avons qu'à créer un deuxième constructeur dans notre classe
        NombreHabitantException qui prend un nombre d'habitants en paramètre :
        */
        /*
        LA GESTION DE PLUSIEURS EXCEPTIONS
        -----------------------------------
        Bien entendu, ceci est valable pour toutes sortes d'exceptions, qu'elles soient personnalisées ou inhérentes à Java !
        Supposons que nous voulons lever une exception si le nom de la ville fait moins de 3 caractères. Nous allons répéter
        les premières étapes vues précédemment, c'est-à-dire créer une classe NomVilleException:
        */

        //VOLVEMOS A a_ville_heritage_capital !!!!

    }
}

//Exception personnalisée 1
class NombreHAbitantException extends Exception {

    public NombreHAbitantException() {//Constructeur par default
        System.out.println("Vous essayez d'instancier une classe Ville avec un nombre d'habitants négatif !");
    }

    public NombreHAbitantException(int nbr) {////deuxième constructeur dans notre classe NombreHabitantException qui prend un nombre d'habitants en paramètre
        System.out.println("Instanciation avec un nombre d'habitants négatif");
        System.out.println("\t => " + nbr);
    }
}

//Exception personnalisée 2
class NomVilleException extends Exception {
    public NomVilleException() {//Constructeur par default

    }

    public NomVilleException(String message) {
        super(message);
    }
}
/*  Lorsque plusieurs exceptions sont gérées par une portion de code, pensez
     bien à mettre dans un ordre pertinent. las primeras tendran prioridad si es que son ciertas


     .Lorsqu'un événement que la JVM ne sait pas gérer apparaît, une exception est levée (exemple : division par zéro).
      Une exception correspond donc à une erreur.

     .La superclasse qui gère les exceptions s'appelle Exception.

     .Vous pouvez créer une classe d'exception personnalisée : faites-lui hériter de la classe Exception.

     .L'instruction qui permet de capturer des exceptions est le bloc try{…}catch{}.

     .Si une exception est levée dans le bloc try, les instructions figurant dans le bloc catch seront exécutées pour
      autant que celui-ci capture la bonne exception levée.

     .Vous pouvez ajouter autant de blocs catch que vous le voulez à la suite d'un bloc try, mais respectez l'ordre :
      du plus pertinent au moins pertinent.

     .Dans une classe objet, vous pouvez prévenir la JVM qu'une méthode est dite « à risque » grâce au mot clé throws.

     .Vous pouvez définir plusieurs risques d'exceptions sur une même méthode. Il suffit de séparer les déclarations par une virgule.

     .Dans cette méthode, vous pouvez définir les conditions d'instanciation d'une exception et lancer cette dernière
      grâce au mot clé throw suivi de l'instanciation.

     .Une instanciation lancée par le biais de l'instruction throw doit être déclarée avec throws au préalable !
*/


package i_poo.l_interface.animal_con_interface_Rintintin;

public class Main {
    public static void main(String[] args) {
        //El polimorphisme permet de hacer esto
        //Avec cette reference, vous pouvez utiliser les methodes de l'interface I
        I var = new A();
        //Avec cette reference, vous pouvez utiliser les methodes de l'interface I
        I2 var2 = new A();

        var.A();//var y var2 objetos de tipo interface contienens objetos A (su clase hija o subclase que la simplementa)
        //los metodos estan entonces en la interface que hace de superclase y su subclase A (que tiene los metodos
        //A B de la interdace uno y C y D de la interface 2
        var2.C();

        /*--------------------------------------------------------------------------------------------------------------
        Implémentation de l'interface "Rintintin"
        Voilà où nous en sommes :

           .nous voulons que nos chiens puissent être amicaux ;

           .nous voulons définir un supertype pour utiliser le polymorphisme ;

           .nous voulons pouvoir continuer à utiliser nos objets comme avant.

        Comme le titre de cette sous-section le stipule, nous allons créer l'interface Rintintin pour ensuite
        l'implémenter dans notre objetChien.

        Sous Eclipse, vous pouvez faireFile > New > Interface, ou simplement cliquer sur la flèche noire à côté
        du «C» pour la création de classe, et choisir interface, comme à la figure suivante. Voici son code : en Chien
        une fois los metodos de Rintintin implementados en Chien vamos a hacer estes
         -------------------------------------------------------------------------------------------------------------*/

        /*--------------------------------------------------------------------------------------------------------------
                                     LES METHODES D'UN CHIEN
         -------------------------------------------------------------------------------------------------------------*/

        Chien perrito = new Chien("Gris", 20);
        perrito.boire();
        perrito.manger();
        perrito.deplacement();
        perrito.crier();
        System.out.println(perrito.toString());

        System.out.println();

        /*--------------------------------------------------------------------------------------------------------------
                                     LES METHODES DE L'INTERFACE
         -------------------------------------------------------------------------------------------------------------*/

        perrito.faireCalin();
        perrito.faireLeBeau();
        perrito.faireLechouille();

        System.out.println();
        /*--------------------------------------------------------------------------------------------------------------
                                 UTILIZAMOS EL POLIMORFISMO DE NUESTRA INTERFACE
         -------------------------------------------------------------------------------------------------------------*/

        Rintintin nuevoPerrito=new Chien();
        nuevoPerrito.faireCalin();
        nuevoPerrito.faireLeBeau();
        nuevoPerrito.faireLechouille();

        /*
        Objectif atteint ! Nous sommes parvenus à définir deux superclasses afin de les utiliser comme supertypes
        et de jouir pleinement du polymorphisme.

        Dans la suite de ce chapitre, nous verrons qu'il existe une façon très intéressante d'utiliser les interfaces
        grâce à une technique de programmation appelée « pattern strategy ». Sa lecture n'est pas indispensable,
        mais cela vous permettra de découvrir à travers un cas concret comment on peut faire évoluer au mieux
        un programme Java.
        */
    }
}

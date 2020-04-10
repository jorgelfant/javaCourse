package i_poo.r_genericité.D_generite_OpenClassRoom;

public class Genericite_plusLoin {
    public static void main(String[] args) {
//Plus loin dans la généricité !
        /*
          Vous devez savoir que la généricité peut être multiple ! Nous avons créé une classe Solo,
          mais rien ne vous empêche de créer une classe Duo, qui elle prend deux paramètres génériques !
          Voilà le code source de cette classe :
        */
        //Afin de mieux comprendre son fonctionnement, voici un code que vous pouvez tester :
        Duo<String, Boolean> dual = new Duo<String, Boolean>("toto", true);
        System.out.println("Valeur de l'objet dual : val1 = " + dual.getValeur1() + ", val2 = " + dual.getValeur2());

        Duo<Double, Character> dual2 = new Duo<Double, Character>(12.2585, 'C');
        System.out.println("Valeur de l'objet dual2 : val1 = " + dual2.getValeur1() + ", val2 = " + dual2.getValeur2());
        /*IMPRIMIRIA:
           Valeur de l'objet dual : val1 = toto, val2 = true
           Valeur de l'objet dual2 : val1 = 12.2585, val2 = C

           Vous voyez qu'il n'y a rien de bien méchant ici. Ce principe fonctionne exactement comme dans
           l'exemple précédent. La seule différence réside dans le fait qu'il n'y a pas un,
           mais deux paramètres génériques !

           Attends une minute… Lorsque je déclare une référence de type Duo<String, Boolean>,
           je ne peux plus la changer en un autre type !

           En fait, non. Si vous faites:

           Duo<String, Boolean> dual = new Duo<String, Boolean>("toto", true);
           System.out.println("Valeur de l'objet dual: val1 = " + dual.getValeur1() + ", val2 = " + dual.getValeur2());
           dual = new Duo<Double, Character>();

        */

        /*
        … vous violez la contrainte que vous avez émise lors de la déclaration du type de référence !
        Vous ne pourrez donc pas modifier la déclaration générique d'un objet. Donc si vous suivez bien,
        on va pouvoir encore corser la chose !
        */
    }
}
//**********************************************************************************************************************
//                                           Clase generica Duo
//**********************************************************************************************************************

class Duo<T, S> {
    //Variable d'instance de type T
    private T valeur1;
    //Variable d'instance de type S
    private S valeur2;

    //Constructeur par défaut
    public Duo() {
        this.valeur1 = null;
        this.valeur2 = null;
    }

    //Constructeur avec paramètres
    public Duo(T val1, S val2) {
        this.valeur1 = val1;
        this.valeur2 = val2;
    }

    //Méthodes d'initialisation des deux valeurs
    public void setValeur(T val1, S val2) {
        this.valeur1 = val1;
        this.valeur2 = val2;
    }

    //Définit la valeur T
    public void setValeur1(T valeur1) {
        this.valeur1 = valeur1;
    }

    //Retourne la valeur T
    public T getValeur1() {
        return valeur1;
    }

    //Définit la valeur S
    public void setValeur2(S valeur2) {
        this.valeur2 = valeur2;
    }

    //Retourne la valeur S
    public S getValeur2() {
        return valeur2;
    }

/*
Vous voyez que cette classe prend deux types de références qui ne sont pas encore définis.
*/
}


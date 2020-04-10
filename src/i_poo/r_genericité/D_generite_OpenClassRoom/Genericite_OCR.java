package i_poo.r_genericité.D_generite_OpenClassRoom;

public class Genericite_OCR {
    public static void main(String[] args) {
        //La généricité en Java
        /*
         Pour assimiler ce concept, ajouté au JDK depuis la version 1.5, nous allons essentiellement travailler
         avec des exemples tout au long de ce chapitre. Le principe de la généricité est de faire des classes
         qui n'acceptent qu'un certain type d'objets ou de données de façon dynamique !

         Avec ce que nous avons appris au chapitre précédent, vous avez sûrement poussé un soupir de soulagement
         lorsque vous avez vu que ces objets acceptent tous les types de données. Par contre, un problème de taille
         se pose : lorsque vous voudrez travailler avec ces données, vous allez devoir faire un cast ! Et peut-être
         même un cast de cast, voire un cast de cast de cast…

         C'est là que se situe le problème… Mais comme je vous le disais, depuis la version 1.5 du JDK, la généricité
         est là pour vous aider !

         PRINCIPE DE BASE
         ****************

         Bon, pour vous montrer la puissance de la généricité, nous allons tout de suite voir un cas de classe
         qui ne l'utilise pas.

         Il existe un exemple très simple que vous pourrez retrouver aisément sur Internet, car il s'agit d'un
         des cas les plus faciles permettant d'illustrer les bases de la généricité. Nous allons coder une
         classe Solo. Celle-ci va travailler avec des références de type String. Voici le diagramme de classe
         de cette dernière en figure suivante.

                                                 ********************************
                                                 *              Solo            *
                                                 ********************************
                                                 *        valeur: String        *
                                                 ********************************
                                                 * setValeur(val: String): void *
                                                 * getValeur(): String          *
                                                 * Solo(): void                 *
                                                 * Solo(val: String): void      *
                                                 ********************************

                                                    Diagramme de la classe Solo


        Vous pouvez voir que le code de cette classe est très rudimentaire. On affecte une valeur, on peut
        la mettre à jour et la récupérer… Maintenant, si je vous demande de me faire une classe qui permet
        de travailler avec n'importe quel type de données, j'ai une vague idée de ce que vous allez faire.
        Ne serait-ce pas quelque chose s'approchant de la figure suivante ?

                                                 ********************************
                                                 *              Solo            *
                                                 ********************************
                                                 *        valeur: Object        *
                                                 ********************************
                                                 * setValeur(val: Object): void *
                                                 * getValeur(): Object          *
                                                 * Solo(): void                 *
                                                 * Solo(val: Object): void      *
                                                 ********************************

                                               Classe Solo travaillant avec des Object

        J'en étais sûr. Créez la classe Solo, ainsi qu'une classe avec une méthode main. Si vous voulez
        utiliser les données de l'objet Solo, vous allez devoir faire un cast. Testez ce code dans votre main :
        */
        /*
        Solo val = new Solo(12);
        int nbre = (Integer) val.getObj();//tendremos que hacer un casting pa que la machine virtuel sepa que el object es un int
        */
        /*
        Vous constatez que vous essayez vainement de mettre un objet de type Object dans un objet de type Integer :
        c'est interdit ! La classe Object est plus globale que la classe Integer, vous ne pouvez donc pas effectuer
        cette opération, sauf si vous castez votre objet en Integer.

        Pour le moment, on peut dire que votre classe peut travailler avec tous les types de données, mais les choses
        se corsent un peu à l'utilisation. Vous serez donc sans doute tentés d'écrire une classe par type de donnée
        (SoloInt, SoloString, etc.). Et c'est là que la généricité s'avère utile, car avec cette dernière, vous pourrez
        savoir ce que contient votre objet Solo et n'aurez qu'une seule classe à développer ! Voilà le diagramme de
        classe de cet objet en figure suivante.


                                                 ********************************
                                                 *            Solo              *
                                                 ********************************
                                                 *        valeur: T             *
                                                 ********************************
                                                 * setValeur(val: T): void      *
                                                 * getValeur(): T               *
                                                 * Solo(): void                 *
                                                 * Solo(val: T): void           *
                                                 ********************************

                                                       Objet générique

        */
        //Exemple de code :

        Solo<Integer> val1 = new Solo<Integer>(12);
        int nbre1 = val1.getObj();

        //Ce code fonctionne très bien, mais si vous essayez de faire ceci :
        //Solo<Integer> val2 = new Solo<Integer>("toto");//error porque le he dicho que trabajamos con Int y le toy poniendo
        //int nbre2 = val2.getObj();                         //String
        //Ici, on essaie de mettre une chaîne de caractères à la place d'un entier


        //… ou encore ceci :

        //Solo<Integer> val3 = new Solo<Integer>(12);//pareil qu'avant
        //val3.setObj(12.2f);
        //Ici, on essaie de mettre un nombre à virgule flottante à la place d'un entier

        /*
        … vous obtiendrez une erreur dans la zone de saisie. Ceci vous indique que votre objet ne reçoit pas
        le bon type d'argument, il y a donc un conflit entre le type de données que vous avez passé à votre
        instance lors de sa création et le type de données que vous essayez d'utiliser dans celle-ci ! Par contre,
        vous devez savoir que cette classe ne fonctionne pas seulement avec des Integer. Vous pouvez utiliser tous
        les types que vous souhaitez !
        */

        //Voici une démonstration de ce que j'avance :
        Solo<Integer> val = new Solo<Integer>();
        Solo<String> valS = new Solo<String>("TOTOTOTO");
        Solo<Float> valF = new Solo<Float>(12.2f);
        Solo<Double> valD = new Solo<Double>(12.202568);

        // Vous avez certainement remarqué que je n'ai pas utilisé ici les types de données que vous employez
        // pour déclarer des variables de type primitif ! Ce sont les classes de ces types primitifs.

        /*
        En effet, lorsque vous déclarez une variable de type primitif, vous pouvez utiliser ses classes enveloppes
        (on parle aussi de classe wrapper) ; elles ajoutent les méthodes de la classe Object à vos types primitifs
        ainsi que des méthodes permettant de caster leurs valeurs, etc. À ceci, je dois ajouter que depuis Java 5,
        est géré ce qu'on appelle l'autoboxing, une fonctionnalité du langage permettant de transformer automatiquement
        un type primitif en classe wrapper (on appelle ça le boxing) et inversement, c'est-à-dire une classe wrapper en
        type primitif (ceci s'appelle l'unboxing). Ces deux fonctionnalités forment l'autoboxing. Par exemple :
        */
        int i = new Integer(12);         //Est équivalent à int i = 12
        double d = new Double(12.2586);  //Est équivalent à double d = 12.2586

        Double dob = 12.0;
        Character c = 'C';
        /*
        al = new ArrayList();
        //Avant Java 5 il fallait faire al.add(new Integer(12))
        //Depuis Java 5 il suffit de faire
        al.add(12);
        //…
        */


    }
}

//**********************************************************************************************************************
// Et voici son code                       Classe Solo GENERICA
//**********************************************************************************************************************
/*
Impressionnant, n'est-ce pas ? Dans cette classe, le T n'est pas encore défini. Vous vous en occuperez à
l'instanciation de la classe. Par contre, une fois instancié avec un type, l'objet ne pourra travailler
qu'avec le type de données que vous lui avez spécifié !
*/
class Solo<T> {
    //Variable d'instance
    private T obj;

    //Constructeur par defaut
    public Solo() {
        this.obj = null;
    }

    //Constructeur avec paramètre inconnu pour linstant
    public Solo(T obj) {
        this.obj = obj;
    }

    //Définit la valeur avec le paramètre
    public void setObj(T obj) {
        this.obj = obj;
    }

    //Retourne la valeur déjà « castée » par la signature de la méthode !
    public T getObj() {
        return obj;
    }


}
package i_poo.a_ville;

public class Main {
    public static void main(String[] args) {
        //**************************************************************************************************************
        //                             CREATION DE LOS OBJETOS CON EL CONSTRUCTOR Ville
        //**************************************************************************************************************
       /* Scanner sc = new Scanner(System.in);  ESTO LO HICE PA LLENAR UN TAB DE VILLES CON VILLES
        Ville[] tab = new Ville[5];
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ciudad");
            tab[i] = new Ville(sc.nextLine(), sc.nextLine(), sc.nextInt() );
            sc.nextLine(); esto para que funcione la siguiente saisi, recondemos que el 3er parametro es un sc.nextInt()
        }*/
        Ville ville1 = new Ville();//avec constructeur 1
        Ville ville2 = new Ville("Lima", "Pérou", 1000000);
        Ville ville3 = new Ville("Berlin", "Deutschland", 2000000);
        //Les variables d'instances ne doivent pas être accessibles dans le principal car je pourrais les changer ici
        /*System.out.println(ville.nomVille);      daria inconnu que es lo que puse
        ville.nomVille = "arequipa";               cambio el nombre
        System.out.println(ville.nomVille);        se cambio el nombre a arequipa */
        //**************************************************************************************************************
        //                                             IMPRESSION
        //**************************************************************************************************************
        System.out.println("\n" + "ville1 = " + ville1.getNomVille() + " ville située au " + ville1.getNomPays() + " a " +
                ville1.getNbreHabitants() + " d'habitants");
        System.out.println("ville2 = " + ville2.getNomVille() + " ville située au " + ville2.getNomPays() + " a " +
                ville2.getNbreHabitants() + " d'habitants");
        System.out.println("ville3 = " + ville3.getNomVille() + " ville située en " + ville3.getNomPays() + " a " +
                ville3.getNbreHabitants() + " d'habitants");
        //**************************************************************************************************************
        //                             INTERCAMBIO DE 2 VILLES POR INTERMEDIO DE OTRO OBJETO Ville
        //**************************************************************************************************************
        //nous allons interchanger les villes ville1 et ville2 par l'intermédiaire d'un autre objet ville
        // Ville villeTemp = new Ville();        new Ville() es redudante asi que podemos poner solo
        Ville villeTemp;

        villeTemp = ville1;//y aqui ya la llenamos
        ville1 = ville2;
        ville2 = villeTemp;
        //**************************************************************************************************************
        //                                  IMPRESSION DESPUES DEL CAMBIO
        //**************************************************************************************************************

        System.out.println("\n" + "ville1 = " + ville1.getNomVille() + " ville située au " + ville1.getNomPays() + " a " +
                ville1.getNbreHabitants() + " d'habitants");

        System.out.println("ville2 = " + ville2.getNomVille() + " ville située au " + ville2.getNomPays() + " a " +
                ville2.getNbreHabitants() + " d'habitants");

        //**************************************************************************************************************
        //                              CAMBIO DE NOMBRES GRACIAS A LOS SETTERS
        //**************************************************************************************************************
        ville1.setNomVille("Arequipa");
        ville2.setNomVille("Frankfurt");
        //**************************************************************************************************************
        //                                  IMPRESSION DESPUES DEL CAMBIO DE NOMBRES
        //**************************************************************************************************************
        System.out.println("\n" + "ville1 = " + ville1.getNomVille() + " ville située au " + ville1.getNomPays() + " a " +
                ville1.getNbreHabitants() + " d'habitants");

        System.out.println("ville2 = " + ville2.getNomVille() + " ville située au " + ville2.getNomPays() + " a " +
                ville2.getNbreHabitants() + " d'habitants \n");

        //**************************************************************************************************************
        //                    Par contre, pour afficher le contenu, on pourrait faire plus simple,                    //
        //                    comme par exemple créer une méthode qui se chargerait de faire tout ceci…               //
        //                    Je sais ce que vous vous dites : « Mais les accesseurs, ce ne sont pas des méthodes ? ».//
        //                    Bien sûr que si, mais il vaut mieux bien distinguer les différents types de             //
        //                    méthodes dans un objet :                                                                //
        //                                                                                                            //
        //                    1. les constructeurs -> méthodes servant à créer des objets ;                           //
        //                                                                                                            //
        //                    2. les accesseurs -> méthodes servant à accéder aux données des objets ;                //
        //                                                                                                            //
        //                    3. les méthodes d'instance → méthodes servant à la gestion des objets.                  //
        //                                                                                                            //
        //                    Avec nos objetsVille, notre choix est un peu limité par le nombre de méthodes           //
        //                    possibles, mais nous pouvons tout de même en faire une ou deux pour l'exemple           //
        //                                                                                                            //
        //                   .faire un système de catégories de villes par rapport à leur nombre d'habitants          //
        //                    ( <1000 -> A, <10 000 -> B…).                                                           //
        //                    Ceci est déterminé à la construction ou à la redéfinition du nombre d'habitants :       //
        //                    ajoutons donc une variable d'instance de typecharà notre classe et appelons-lacategorie.//
        //                    Pensez à ajouter le traitement aux bons endroits.                                       //                                 //
        //                                                                                                            //
        //                    .faire une méthode de description de notre objetVille;                                  //
        //                    .une méthode pour comparer deux objets par rapport à leur nombre d'habitants.           //
        //                                                                                                            //
        //                    Nous voulons que la classe Ville gère la façon de déterminer la catégorie elle-même,  //
        //                    et non que cette action puisse être opérée de l'extérieur. La méthode qui fera ceci     //
        //                    sera donc déclarée private.                                                             //
        //                                                                                                            //
        //                    Par contre, un problème va se poser ! Vous savez déjà qu'en Java, on appelle les        //
        //                    méthodes d'un objet comme ceci :monString.subString(0,4);. Cependant, vu qu'il va       //
        //                    falloir qu'on travaille depuis l'intérieur de notre objet, vous allez encore avoir      //
        //                    un mot clé à retenir : cette fois, il s'agit du...... mot-cléthis!                      //
        //                                                                                                            //
        //                    Pour simplifier,thisfait référence à l'objet courant ! Bien que la traduction anglaise  //
        //                    exacte soit « ceci », il faut comprendre « moi ». À l'intérieur d'un objet, ce mot clé  //
        //                    permet de désigner une de ses variables ou une de ses méthodes.                         //
        //************************************************************************************************************//


        Ville v = new Ville();
        Ville v1 = new Ville("Marseille", "France", 1236);
        Ville v2 = new Ville("Rio", "Brésil", 321654);

        System.out.println("\n" + v.decrisToi());
        System.out.println(v1.decrisToi());
        System.out.println(v2.decrisToi());

        System.out.println(v1.comparer(v2) + "\n");

        /*
        Dans cette méthode, nous voulons comparer le nombre d'habitants de chacun des deux objetsVille. Pour accéder
        à la variable nbreHabitantsde l'objet ville3, il suffit d'utiliser la syntaxe Ville3.getNombreHabitants();
        nous ferons donc référence à la propriétén breHabitants de l'objet Ville3. l'objet ville2, lui, est l'objet appelant
        de cette méthode.Pour se servir de ses propres variables, on utilise alors this.nbreHabitants, ce qui a pour effet
        de faire appel à la variable nbreHabitants de l'objet exécutant la méthodecomparer(Ville V).
        */

        //**************************************************************************************************************
        //         Je viens d'avoir une idée : et si nous essayions de savoir combien de villes nous avons créées ?
        //                              Comment faire ? Avec une VARIABLES DE CLASSE!
        //
        //      Comme je vous le disais au début de ce chapitre, il y a plusieurs types de variables dans une classe.
        //      Nous avons vu les variables d'instance qui forment la carte d'identité d'un objet ; maintenant, voici
        //      les variables de classe.
        //
        // Celles-ci peuvent s'avérer très utiles. Dans notre exemple, nous allons compter le nombre d'instances de
        // notre classe Ville, mais nous pourrions les utiliser pour bien d'autres choses (un taux de TVA dans une
        // classe qui calcule le prix TTC, par exemple).
        // La particularité de ce type de variable, c'est qu'elles seront communes à toutes les instances de la classe !

        // Créons sans plus attendre notre compteur d'instances. Il s'agira d'une variable de type nt que nous
        // appellerons nbreInstance, et qui sera public; nous mettrons aussi son homologue en private en place et
        // l'appellerons nbreInstanceBis(il sera nécessaire de mettre un accesseur en place pour cette variable).
        // Afin qu'une variable soit une variable de classe, elle doit être précédée du mot clé static.
        // Cela donnerait dans notre classeVille:

        //On les appelle des méthodes de classe, car il n'y en a qu'une pour toutes vos instances.
        // Par contre ce n’est plus une méthode de classe si celle-ci utilise des variables d'instance en plus
        // de variables de classe…
        //**************************************************************************************************************
        Ville villeC1 = new Ville();
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());

        Ville villeC2 = new Ville("Marseille", "France", 1236);
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());

        Ville villeC3 = new Ville("Rio", "Brésil", 321654);
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.nbreInstances);
        System.out.println("Le nombre d'instances de la classe Ville est : " + Ville.getNombreInstancesBis());

        /*
        Lorsque vous avez vu les méthodes, vous les avez déclarées public. Vous auriez également pu les déclarer private,
        mais attention, dans les deux cas, il faut aussi qu'elles soient static, car elles sont exécutées dans un
        contextestatic: la méthode principal.
        * */


    }
}

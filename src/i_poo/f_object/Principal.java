package i_poo.f_object;
/*
Vous devez savoir encore une chose sur l'héritage. Lorsque vous créez une classe (Ville, par exemple), celle-ci hérite,
de façon tacite, de la classe Object présente dans Java.

Toutes nos classes héritent donc des méthodes de la classe Object, comme equals()qui prend un objet en paramètre et qui
permet de tester l'égalité d'objets.
*/

public class Principal {
    public static void main(String[] args) {

        Ville[] villes = new Ville[6];//esto podria ser un tableau de classe Object de quien heredan ville y capital

        ////Définition d'un tableau de noms de villes et un autre de nombres d'habitants
        //**************************************************************************************************************
        //                DECLARAMOS 2 ARREGLOS UNO CON SRING de ciudades y el otro con INT habitantes
        // *************************************************************************************************************
        String[] tabVilles = {"Marseille", "Llile", "Caen", "Lyon", "Paris", "Nantes"};
        int[] tabNbreHabt = {123456, 78456, 654987, 75832165, 1594, 213};

        //Les trois premiers éléments du tabVilles seront des villes etle reste des capitales
        //**************************************************************************************************************
        //                                   LLENAMOS EL ARREGLO CON VILLES Y CAPITALES
        // *************************************************************************************************************

        for (int i = 0; i < 6; i++) {
            if (i < 3) {
                Ville V = new Ville(tabVilles[i], "France", tabNbreHabt[i]);
                villes[i] = V;//A cada pasada va llenando cada objeto
            } else {
                Capital C = new Capital(tabVilles[i], "France", tabNbreHabt[i], "Tour Eiffel");
                villes[i] = C;//A cada pasada va llenando cada objeto
                //ou villes[i]=new Capital(tabVilles[i], "France", tabNbreHabt[i], "Tour Eiffel");
            }
        }
        //**************************************************************************************************************
        //                                  IMPRESION DEL arreglo villes de objetos ville
        // *************************************************************************************************************
        for (Object indice : villes) {//Classe superior Object
            System.out.println(indice.toString() + "\n");//Si quitamos el toString y solo dejamos indice igual se imprime
        }                              //toString() porque es el metodo heredado de Object que hemos redefinido (POLIMORPHé)
        /*
        Vous pouvez constater qu'il fait exactement la même chose que le code précédent ; nous n'avons pas à nous
        soucier du type d'objet pour afficher sa description. Je pense que vous commencez à entrevoir la puissance de Java !

        //**************************************************************************************************************
        //      Attention : si vous ne redéfinissez pas ou ne « polymorphez » pas la méthode d'une classe mère dans une
        //      classe fille (exemple de toString()), à l'appel de celle-ci avec un objet fille, c'est la méthode de la
        //      classe mère qui sera invoquée !
        // *************************************************************************************************************

        La méthode de la classe Object la plus souvent redéfinie est toString(): elle retourne un String décrivant l'objet
        en question (comme notre méthode decrisToi()). Nous allons donc copier la procédure de la méthode decrisToi() dans
        une nouvelle méthode de la classe Ville:toString().
        */

        // Une précision s'impose : si vous avez un objet v de type Ville, par exemple, que vous n'avez pas redéfini la
        // méthode toString()et que vous testez ce code :

        //  System.out.println(v);

        //… on appelle automatiquement la méthode toString()de la classe Object! Mais ici, comme vous avez redéfini la
        // méthode toString()dans votre classeVille, ces deux instructions sont équivalentes :

        Ville v = new Ville("prueba", "prueba", 5000);

        System.out.println(v.toString());
        //Est équivalent à
        System.out.println(v);//igual me imprime el contenido de toString()
        //de Object redefinido o polimorphé en Ville es ToString()
        //Pour plus de clarté, je conserverai la première syntaxe, mais il est utile de connaître cette alternative.

        /*Pour clarifier un peu tout ça, vous avez accès aux méthodes public et protected de la classe Object dès que vous
        créez une classe objet (grâce à l'héritage tacite). Vous pouvez donc utiliser les dites méthodes ; mais si vous
        ne les redéfinissez pas, l'invocation se fera sur la classe mère avec les traitements de la classe mère.

        Si vous voulez un exemple concret de ce que je viens de vous dire, vous n'avez qu'à retirer la méthode toString()
        dans les classes Ville et Capitale: vous verrez que le code de la méthode mai nfonctionne toujours, mais que le
        résultat n'est plus du tout pareil, car à l'appel de la méthode toString(), la JVM va regarder si celle-ci existe
        dans la classe appelante et, comme elle ne la trouve pas, elle remonte dans la hiérarchie jusqu'à arriver à la
        classe Object…

        //Vous devez savoir qu'une méthode n'est « invocable » par un objet que si celui-ci définit ladite méthode.*/

        //AINSI CE CODE NE FONCTIONNE PAS
        /*
        for (Object indice : villes) {
            System.out.println(indice.decrisToi());
        }
        */
        // car decrisToi() appartient à Ville mais non a sa super classe (mère) Object
        //contrairement à ToString que appartient à Object et a été rédefinie en Ville
        //decrisToi() n'existe pas en Object et c'est pour cela que Object ne peut pas l'appeler
        //los hijos disponen del contenido de los padres pero los padres no del de los hijos!!!

        /*
        Pour qu'il fonctionne, vous devez dire à la JVM que la référence de type Object est en fait une référence de
        type Ville, comme ceci :((Ville)v).decrisToi();. Vous transtypez la référence indice en Ville par cette syntaxe.

        vous transtypez la référence indice en Ville; vous appliquez la méthode decrisToi()à la référence appelante,
        c'est-à-dire, ici, une référence Object changée en Ville.
        */
        for (Object indice : villes) {
            System.out.println(((Ville)indice).decrisToi());//on trasforme la reference Object en reference Ville
        }//porque lo que esta en el arreglo son objetos Ville esto posibilita el cambio a Ville

        /*
        VOUS VOYEZ DONC L'INTERET DES METHODES POLYMORPHES : GRACE A ELLES, ON A PLUS A SE SOUCIER DU TYPE
        DE VARIABLE APPELANTE. CEPENDANT, N'UTILISEZ LE TYPE Object QU'AVEC PARCIMONIE.
        */



    }
}

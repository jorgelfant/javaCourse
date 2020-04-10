package i_poo.n_enumerations;

import java.util.Scanner;


public class PrincipalEnum {
    public static void main(String[] args) {
        //Los tipos enumerados estan en la classe "enum" de l'api de JAVA; que nos permite crear tipos enumerados

        /*
        Plusieurs fois apparait la nécessité de stocker dans une variable, une série de valeurs, mais on ne veux pas
        que dans cette variable puissent être stockés d’autres valeurs dans le futur ! ou que les valeurs existantes
        puissent être modifiés.

        *Imaginons que l’on a besoin de stocker dans une variable de type String taille une série de tailles
        *On déclare la variable de type String, et plus tard, dans notre programme au fur et à mesure
        * qu’on ait en ait besoin:

            Taille= "petite" ;
            *Ou plus tard dans le code si l’on a besoin
            Taille= "moyenne" ;
            *Et ainsi de suite, toute les fois que l’on veut
            Taille= "grand" ;

        Cependant, quand on veut élaborer des programmes de ce type, on peut aussi faire la chose suivante
        Taille="bleu";

        Et cela n'a plus beaucoup de sens car bleu n'est pas une taille mais une couleur.

        *Plein de fois apparaît la nécessité de CREER UNE ESPECE DE VARIABLE ou on peu s'assurer qu'il ne puissent
         être stockés qu'un nombre déterminé de VALEURS! ou un TYPE déterminé de VALEURS.

         PAR EXEMPLE :
         ---------------------------------------------------------------------------------------------------------------
             Une variable taille dans laquelle pourrait être stockée, "petite", "moyenne", "grande","tres grande"
         ---------------------------------------------------------------------------------------------------------------
         mais que l’on ne puisse pas stocker rien de différent à ces 4 valeurs, c’est-à-dire que si
         l’on essayer par exemple de stocker la valeur « bleu » dans cette variable le programme ne le permette pas.

        */
        /*
        String taille;

        taille="Petite";
        taille="moyenne";
        taille="grande";
        taille="bleu";
        */
        /*C'EST DANS DES CAS COMME CELA QUE L'ON UTILISE LE TYPE ENUMERE*/
        /*
        Type énuméré = une variable objet de type enu dans laquelle on peut stocker un groupe de valeurs
        et seul ce groupe de valeurs pourra être stocké et aucun autre.
        */

        //La première chose à savoir est que quand on va déclarer un type énuméré ON NE PEUT PAS LE FAIRE DANS LE MAIN.
        //On doit le faire en dehors du MAIN. Tantôt dans la classe tantôt hors de la classe ou dans une autre classe
        //Enum taille {valeurs, pouvant, se, stocker, dans, cette_variable} ;
        //Qui est la classe   ensuite nom
        //De l’API java         de la variable

        //Comment si on créait un objet, Pas d’espaces entre les mots, mais _

        //--------------------------------------------------------------------------------------------------------------
        //      DESPUES DE CREAR EL OBJETO DE la CLASS enum , venimos al main2
        //--------------------------------------------------------------------------------------------------------------
        //SYNTAXE 1. :
        // 1:etape
        // enum talla {CHICO, MEDIANO, GRANDE, MUY_GRANDE};
        //--------------------------------------------------------------------------------------------------------------
        //2: etape
        //talla s = talla.CHICO;//On voit qu’ils sont tous statiques = on doit utiliser le nom de la classe. Pour pouvoir les utiliser
        //talla m = talla.MEDIANO;
        //talla l = talla.GRANDE;
        //talla xl = talla.MUY_GRANDE;
        //--------------------------------------------------------------------------------------------------------------
        //on voit apparaitre un nouveau type de syntaxe:

        // class:class<PrincipalEnum.talla>     vemos los  < >
        //Ceci veut dire que là on admet un paramètre d’une CLASSE GENERIQUE
        //si intentamos crear una variable de tipo talla y poner un valor diferente a los que hemos definido da error
        //talla xxl=talla.ENORME;
        //El programa puede evolucionar de diferentes formas en funcion de necesidades de cada uno
        //podriamos pedir de ingresar una talla y con un if evaluar si esta forma parte de los valores permitidos

        //Les types énumérés permettent l’usage ou la programmation de constructeurs, et la programmation
        //de méthodes setters et getters.
        //Mais seulement si l’on en a besoin.

        //EXEMPLE :
        //Au moment de créer l’objet de type enum, on crée un constructeur, et à la fois on lui passe comme paramètre
        //taille c’est-à-dire s, m, l, xl et ensuite à travers des méthodes getter et setter d’un côté donner
        //l’abréviation s a la taille mini, m à la taille moyenne et avec un getter lui dire de retourner la taille
        // en fonction de l’abréviation.

        //--------------------------------------------------------------------------------------------------------------
        //SYNTAXE 2. :
        // enum talla {
        //        //2. construction objetos
        //        CHICO("S"), MEDIANO("M"), GRANDE("L"), MUY_GRANDE("XL");
        //
        //        private String abreviation;
        //        //1.CONSTRUCTOR
        //        private talla(String abreviation) {
        //            this.abreviation = abreviation;
        //        }
        //    }
        //--------------------------------------------------------------------------------------------------------------
        //talla s = talla.CHICO;//On voit qu’ils sont tous statiques = on doit utiliser le nom de la classe. Pour pouvoir les utiliser
        //talla m = talla.MEDIANO;
        //talla l = talla.GRANDE;
        //talla xl = talla.MUY_GRANDE;
        //--------------------------------------------------------------------------------------------------------------

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar talla: CHICO, MEDIANO, GRANDE, MUY GRANDE");
        String entrada = sc.nextLine().toUpperCase();//pasamos a mayuscula lo que escribimos
        //On va dans la API et on chercher les methodes de enum
        //tenemos por ex :      static <Textends Enum<T>>                        valueOf(class<T> enumType, String name)
        // returns the enum constant of the specified enum type with the specified name

        /*
         Return le nom de la constante enum et en plus est static
         On retourne dans le main2
         On declare une variable de type taille, et ce sera = à la methode static.valueof(class ?, saisieAuClavier) ;
        */
        talla miTalla = talla.valueOf(talla.class, entrada);
        System.out.println("La talla es : " + miTalla);//optional
        System.out.println("Abreviacion : " + miTalla.getName());//optional
        /*
        Avec ceci , avec la méthode valueOf qui retourne le nom de la constante de type enum à laquelle
        appartient la saisie( le texte qu’on va introduire)

        Imaginos que l’on saisi GRANDE, ceci sera stocké en entrada, et valueOf détecte à quel type appartient ce string saisi
        //Los valors en MAYUSCULAS SON CONSTANTES ENUMERADAS, por eso estan en mayusculas
        */
    }

    //pdria ser aqui fuera del main2
    //enum talla {CHICO, MEDIANO, GRANDE, MUY_GRANDE}

      /*On est en train de créer un objet appartenant à la classe enum, et on est en train de lui dire que
      cette variable objet taille pourra seulement stocker seulement ces valeurs.
       Es como si dijeramos que avec la class enum crearemos un tipo INTEGER o CHARACTER (wraps) solo que aqui hablamos de objetos

       EJEMPLO : enum int {A,B,C,D}

       INTEGER hola= INTEGER.xxxx;//variables staticas

      Une fois que l’on a déclaré notre variable objet de type enum on retourne dans le main2 et on peut maintenant
      faire des choses comme la suivante :

      Taille nom_objet = objet.valeur
    */
    //--------------------------------------------------------------------------------------------------------------
    //                                              enum con CONSTRUCTOR
    //on pourrait le faire en une seule ligne comme avant ou en plusieurs lignes
    //ici comme dans   future on utilisera un constructeur alors la première chose à faire serait créer ce constructeur.

    //--------------------------------------------------------------------------------------------------------------
    public enum talla {//OBJETOS DE TIPO talla
        CHICO("S"),
        MEDIANO("M"),
        GRANDE("L"),
        MUY_GRANDE("XL");

        private String name = "";

        //Constructor
        talla(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }//CHICO= objet        S=abréviation

    //*POURQUOI private dans le CONSTRUCTEUR ?
    //Une des caractéristiques qu’ont les types enum est qu’ils n’admettent pas la création d’objets
    //es decir, no podemos invocar un constructor y crear como si fueran objetos pertenecientes a la class enum !

    //On peut donc pas dire :
    //talla miTalla= new taille()        dans le main2
    //Du a cela, si l’on crée un constructeur il devra être private pour que le constructeur
    // ne puisse pas être appelé depuis l’extérieur et qu’on ne puisse pas créer objets !!

    //DEPUES VAMOS AL MAIN para poder utilizar ce type enum , es como si con enum crearamos otro tipo de classe
    //con la cual podemos definir ciertos valores que seran los unicos que se podran utilizar
}

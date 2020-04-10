package i_poo.a_ville;

//Une méthode publique peut être appelée depuis n'importe quel endroi du programme
//PRIVATE indique que la méthode(ou variable) ne pourra être appelée que depuis l'intérieur de la classe dans laquelle elle se trouve
//Les méthodes déclarées private correspondent souvent à des mécanismes internes à une classe que les développeurs souhaitent
// « cacher » ou simplement ne pas rendre accessibles de l'extérieur de la classe…
public class Ville {//el nombre de la class debe comenzar con mayuscula ejemplo Ville
    //******************************************************************************************************************
    //               Variables d'instance en private pour pas qu'ils soient accessibles de l'extérieur
    // *****************************************************************************************************************
    private String nomVille;
    private String nomPays;
    private int nbreHabitants;
    private char categorie;

    //Variables publiques qui comptent les instances
    public static int nbreInstances = 0;

    //Variable privée qui comptera aussi les instances
    private static int nbreInstancesBis = 0;//il faudra un getter car il est en private

    //Les autres variables n'ont pas changé
   /*il y a trois grands types de variables dans une classe objet :

   1 Les variables d'instance : ce sont elles qui définiront les caractéristiques de notre objet.

   2 Les variables de classe : celles-ci sont communes à toutes les instances de votre classe.

   3 Les variables locales : ce sont des variables que nous utiliserons pour travailler dans notre objet. */

    //Une fois les variables définies on va créer notre objet à l'aide de constructeurs
    //qui est une méthode d'instance qui va se charger de créer l'objet

    //******************************************************************************************************************
    //                                               CONSTRUCTEURS
    // *****************************************************************************************************************
    public Ville() {//constructeur 1 sans paramètres
        /*Un constructeur est une méthode d'instance qui va se charger de créer un objet et, le cas échéant, d'initialiser
        ses variables de classe !*/
        System.out.println("Création d'une ville");
        nomVille = "Inconnu";
        nomPays = "Inconnu";
        nbreHabitants = 0;
        this.setCategorie();

        //On incrémente nos variables à chaque appel aux constructeurs
        nbreInstances++;
        nbreInstancesBis++;
        //Le reste ne change pas.
    }

    //UN OJET PEUT AVOIR PLUSIEURS CONSTRUCTEURS --Il s'agit de la même méthode mais SURCHARGEE
    public Ville(String pNom, String pPays, int pNbre) {
        System.out.println("Création d'une ville avec paramètres");
        nomVille = pNom;
        nomPays = pPays;
        nbreHabitants = pNbre;
        this.setCategorie();

        //On incrémente nos variables à chaque appel aux constructeurs
        nbreInstances++;
        nbreInstancesBis++;
        //Le reste ne change pas
    }
    //NOUS DEVONS POUVOIR ACCEDER DE L'EXTERIEUR QUAND MEME A NOS VARIABLES PRIVATE EN LECTURE
    //SETTERS pour accéder aux variables de nos objets en lecture et le modifier
    //GETTERS pour faire le même mais en écriture  LES 2 EN PUBLIQUE pour y accéder depuis une autre clsse (le MAIN par ex)

    //******************************************************************************************************************
    //                                       SETTERS AND GETTERS
    // *****************************************************************************************************************
    //***************************************cuenta el numero de objetos creados***************************************
    public static int getNombreInstancesBis()//la metode getter de una variable static es tambien static C'EST UNE REGLE
    {//Par contre ce n’est plus une méthode de classe si celle-ci utilise des variables d'instance en plus de variables de classe…
        return nbreInstancesBis;
    }
    //***************************************définir et retourner nom de la ville***************************************

    public void setNomVille(String pNom) {
        nomVille = pNom;
    }

    public String getNomVille() {
        return nomVille;
    }

    //******************************************définir et retourner nom du pays****************************************

    public void setNomPays(String pPays) {
        nomPays = pPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    //****************************************définir et retourner nombre d'habitants***********************************

    public void setNbreHabitants(int pNbre) {
        nbreHabitants = pNbre;
        this.setCategorie();//CUANDO DE EL NOMBRE DE HABITANTES ESTO LLAMARA A LA OTRA FUNCION  this.setCategorie() QUE DARA LA CATEGORIA
    }                       //Elle détermine dans quelle tranche se trouve la ville grâce au nombre d'habitants

    // de l'objet appelant , obtenu au moyen du mot cléthis
    public int getNbreHabitants() {
        return nbreHabitants;
    }

    //******************************************************************************************************************
    //                                      Definir categoria de la ville
    //******************************************************************************************************************

    private void setCategorie() {//private porque este calculo se va a hacer internamente cuando yo pongo el nbr de habitantes
        int[] bornesSuperieures = {0, 1000, 10000, 100000, 500000, 1000000, 5000000, 10000000};//al ingresar el parametro
        char[] categories = {'?', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};//nbr de habitantes esto llamara a la funcion setCategorie.

        int i = 0;
        while (i < bornesSuperieures.length && nbreHabitants > bornesSuperieures[i]) {
            i++;//esto renvoi a la siguiente posicion del categories[i] ya que al salir del while i aumenta de 1
        }
        this.categorie = categories[i];//recupera el valor (i++)
    }

    public char getCategorie() {
        return categorie;
    }

    //***************************funcion para Retornar una descripcion de la ville**************************************

    public String decrisToi() {
        return "\t" + this.getNomVille() + " est une ville située au/en " + this.getNomPays() + " et quicomporte " +
                this.nbreHabitants + " habitants, elle est donc de catégorie " + this.getCategorie() + "\n";
    }

    //***************************Retourne une chaîne de caractères en fonction du résultat de la comparaison************
    public String comparer(Ville ville) {
        String str;//OU  String str = new String() pero es redundanteporque el str lo lleno en el if y else

        if (ville.getNbreHabitants() > this.nbreHabitants) {
            str = ville.getNomVille() + " est une ville plus peuple que " + this.nomVille;
        } else {
            str = this.nomVille + " est une ville plus peuple que " + ville.getNomVille();
        }
        return str;//esto me permite enviar uno ou otro lo que no podria hacer con System.out.println()
    }

}

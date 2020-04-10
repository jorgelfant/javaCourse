package i_poo.f_object;

//java.util.Objects la importamos pa poder utilizar 2 funcionalidades que permiten redefinir de manera
//mas simple los methodos  hashCode() y equals()

//Une méthode publique peut être appelée depuis n'importe quel endroi du programme
//PRIVATE indique que la méthode(ou variable) ne pourra être appelée que depuis l'intérieur de la classe dans laquelle elle se trouve
//Les méthodes déclarées private correspondent souvent à des mécanismes internes à une classe que les développeurs souhaitent
// « cacher » ou simplement ne pas rendre accessibles de l'extérieur de la classe…
public class Ville {//el nombre de la class debe comenzar con mayuscula ejemplo Ville
    //******************************************************************************************************************
    //               Variables d'instance en private pour pas qu'ils soient accessibles de l'extérieur
    // *****************************************************************************************************************
    //Variables publiques qui comptent les instances
    public static int nbreInstances = 0;
    //Variable privée qui comptera aussi les instances
    protected static int nbreInstancesBis = 0;//il faudra un getter car il est en private
    protected String nomVille;
    protected String nomPays;
    protected int nbreHabitants;
    protected char categorie;
    //CAMBIAMOS PRIVATE POR PROTECTED Y CON ESTO LO UNICO QUE CAMBIA ES QUE LAS CLASES HIJAS PODRAN ACCEDER A ESTAS VARIABLES

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
        return "\t" + this.nomVille + " est une ville située au/en " + this.nomPays + " et quicomporte " +
                this.nbreHabitants + " habitants, elle est donc de catégorie " + this.categorie + "\n";
    }

    //***************************Retourne une chaîne de caractères en fonction du résultat de la comparaison************
    public String comparer(i_poo.a_ville_heritage_capital.Ville ville) {
        String str;//OU  String str = new String() pero es redundanteporque el str lo lleno en el if y else

        if (ville.getNbreHabitants() > this.nbreHabitants) {
            str = ville.getNomVille() + " est une ville plus peuple que " + this.nomVille;
        } else {
            str = this.nomVille + " est une ville plus peuple que " + ville.getNomVille();
        }
        return str;//esto me permite enviar uno ou otro lo que no podria hacer con System.out.println()
    }

    //******************************************************************************************************************
    //                 ToString()  Methode de la classe Object dont héritent tous nos objets
    // *****************************************************************************************************************
    public String toString() {
        return "\t" + this.nomVille + " est une ville de " + this.nomPays + ", elle comporte : " + this.nbreHabitants +
                " => elle est donc de catégorie : " + this.categorie;
    }

    //******************************************************************************************************************
    //                 SUPER IMPORTANTE 2 METHODES DE Object MUY USADOS: equals() y hashCode
    // *****************************************************************************************************************
         /*Il y a deux autres méthodes qui sont très souvent redéfinies :

        .public boolean equals(Object o), qui permet de vérifier si un objet est égal à un autre ;

        .public int hashCode(), qui attribue un code de hashage à un objet. En gros, elle donne un identifiant à un objet.

         Notez que cet identifiant sert plus à catégoriser votre objet qu'à l'identifier formellement.*/

    /*Il faut garder en tête que ce n'est pas parce que deux objets ont un même code de hashage qu'ils sont égaux
    (en effet, deux objets peuvent avoir la même « catégorie » et être différents…) ; par contre,
    deux objets égaux ont forcément le même code de hashage ! En fait, la méthode hashcode() est utilisée
    par certains objets (que nous verrons avec les collections) afin de pouvoir classer les objets entre eux.

    La bonne nouvelle, c'est qu'Eclipse vous permet de générer automatiquement ces deux méthodes, via le
    menu Source/Generate hashcode and equals.*/

    //******************************************************************************************************************
    //           VOILA A QUOI POURRAIENT RESSEMBLER CES 2 METHODES POUR NOTRE OBJECT VILLE
    //******************************************************************************************************************

    //***************************************************METODO 1*******************************************************

    public int hashCode() {
        //On définit un multiplication impair, de préférence un nombre premier(primo), Ceci afin de garantir l'unicité du résultat final
        final int prime = 31;//primo divisible por 1 y 31
        //On définit un résultat qui sera renvoyé au final
        int result = 1;
        //On ajoute en eux la multiplication des attributs et du multiplicateur
        result = result * prime + categorie;
        result = result * prime + nbreHabitants;
        //Lorsque vous devez gérer des hashcodes avec des objets dans le mode de calcul
        //Vous devez vérifier si l'objet n'est pas null, sinon vous aurez une erreur
        result = result * prime + ((nomPays == null) ? 0 : nomPays.hashCode());//creo que aqui se usa el metodo hashcode del padre Object
        result = result * prime + ((nomVille == null) ? 0 : nomVille.hashCode());//creo que aqui se usa el metodo hashcode del padre Object
        return result;                                                           //para dar algo en el else en caso el objeto no es nulo
    }

    //***************************************************METODO 2*******************************************************

    public boolean equals(Object obj) {
        //On vérifie si les références d'objets sont identiques
        if (this == obj)
            return true;

        //On vérifie si l'objet passé en paramètre est null
        if (obj == null)
            return false;

        //On s'assure que les objets sont du même type, ici de type Ville
        //La méthode getClass retourne un objet Class qui représente la classe de votre objet
        //Nous verrons ça un peu plus tard...
        if (getClass() != obj.getClass())//por ejemplo Ville es igual a Capital??
            return false;

        //***************************Maintenant, on compare les attributs de nos objets*********************************

        Ville other = (Ville) obj;
        if (categorie != other.categorie)
            return false;
        if (nbreHabitants != other.nbreHabitants)
            return false;
        if (nomPays == null) {
            if (other.nomPays != null)
                return false;
        } else if (!nomPays.equals(other.nomPays))
            return false;

        if (nomVille == null) {
            if (other.nomVille != null)
                return false;
        } else if (!nomVille.equals(other.nomVille))
            return false;

        return true;
    }

    //******************************************************************************************************************
    //                                          PARA TERMINAR
    //******************************************************************************************************************

    /*Il existe encore un type de méthodes dont je ne vous ai pas encore parlé : le type final. Une méthode signée final
    est figée, vous ne pourrez jamais la redéfinir (la méthode getClass() de la classe Object est un exemple de ce type de
    méthode : vous ne pourrez pas la redéfinir).*/

    /*
    public final int maMethode(){
        //Méthode ne pouvant pas être surchargée
    }
    */

    /*Il existe aussi des classes déclarées final. Vous avez compris que ces classes sont immuables. Et vous ne pouvez
    donc pas faire hériter un objet d'une classe déclarée final!

    Il en va de même pour les variables déclarées de la sorte.*/

    //******************************************************************************************************************
    //                           DEPUIS JAVA 7 : la classe Objects
    //******************************************************************************************************************

   /* Nous avons vu précédemment que les méthode equals() et hashcode() sont souvent redéfinies afin de pouvoir gérer
   l'égalité de vos objets et de les catégoriser. Vous avez pu vous rendre compte que leur redéfinition n'est pas
   des plus simples (si nous le faisons avec nos petits doigts).

   Avec Java 7, il existe une classe qui permet de mieux gérer la redéfinitions de ces méthodes : java.util.Objects.
   Attention, il ne s'agit pas de la classe java.lang.Object dont tous les objets héritent ! Ici il s'agit d'Objects
   avec un « s » ! Ce nouvel objet ajoute deux fonctionnalités qui permettent de simplifier la redéfinition des méthodes
   vues précédemment.

   Nous allons commencer par la plus simple : hashcode(). La classe Objects propose une méthode hash(Object… values).
   Cette méthode s'occupe de faire tout le nécessaire au calcul d'un code de hashage en vérifiant si les attributs
   sont null ou non et tutti quanti. C'est tout de même sympa. Voici à quoi ressemblerait notre méthode hashcode()
   avec cette nouveauté : Objects.hash(x,y,v_design_patterns)  */

    //******************************************************************************************************************
    //      public int hashCode() {
    //         return Objects.hash(categorie, nbreHabitants, nomPays, nomVille);
    //       }
    //******************************************************************************************************************

    //Il faudra, bien sûr, penser à importer la classe pour pouvoir l'utiliser.   java.util.Objects    //


    /*Ce nouvel objet intègre aussi une méthode equals() qui se charge de vérifier si les valeurs passées en paramètre
      sont null ou non. Du coup, nous aurons un code beaucoup plus clair et lisible. Voici à quoi ressemblerait notre
      méthode equals() de l'objetVille:*/

    /*******************************************************************************************************************

    public boolean equals(Object obj) {
        //On vérifie si les références d'objets sont identiques
        if (this == obj)
            return true;

        //On s'assure que les objets sont du même type, ici de type Ville
        if (getClass() != obj.getClass())
            return false;

        //Maintenant, on compare les attributs de nos objets
        Ville other = (Ville) obj;

        return Objects.equals(other.getCategorie(), this.getCategorie()) &&
                Objects.equals(other.getNOM(), this.getNOM()) &&
                Objects.equals(other.getNombreHabitants(), this.getNombreHabitants()) &&
                Objects.equals(other.getNomPays(), this.getNomPays());
    }

     ******************************************************************************************************************/

    //Avouez que c'est plus clair et plus pratique…...

    //******************************************************************************************************************
    //                                                 RESUMEN
    //******************************************************************************************************************

    /*Une classe hérite d'une autre classe par le biais du mot cléextends.

      .Une classe ne peut hériter que d'une seule classe.

      .Si aucun constructeur n'est défini dans une classe fille, la JVM en créera un et appellera automatiquement
       le constructeur de la classe mère.

      .La classe fille hérite de toutes les propriétés et méthodespublicetprotectedde la classe mère.

      .Les méthodes et les propriétésprivated'une classe mère ne sont pas accessibles dans la classe fille.

      .On peut redéfinir une méthode héritée, c'est-à-dire qu'on peut changer tout son code.

      .On peut utiliser le comportement d'une classe mère par le biais du mot clésuper.

      .Grâce à l'héritage et au polymorphisme, nous pouvons utiliser la covariance des variables.

      .Si une méthode d'une classe mère n'est pas redéfinie ou « polymorphée », à l'appel de cette méthode par le biais
       d'un objet enfant, c'est la méthode de la classe mère qui sera utilisée.

      .Vous ne pouvez pas hériter d'une classe déclaréefinal.

      .Une méthode déclaréefinaln'est pas redéfinissable.
    */
}



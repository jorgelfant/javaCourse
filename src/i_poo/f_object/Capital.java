package i_poo.f_object;

  /* Notons un point important avant de continuer. Contrairement au C++, Java ne gère pas les héritages multiples :
        une classe dérivée (aussi appelée classe fille) ne peut hériter que d'une seule classe mère !
        Vous n'aurez donc jamais ce genre de classe :

        class AgrafeuseBionique extends AgrafeuseAirComprime, AgrafeuseManuelle{

        }
        La raison est toute simple : si nous admettons que nos classesAgrafeuseAirComprime et AgrafeuseManuelle ont
        toutes les deux une méthodeagrafer()et que vous ne redéfinissez pas cette méthode dans l'objetAgrafeuseBionique,
        la JVM ne saura pas quelle méthode utiliser et, plutôt que de forcer le programmeur à gérer les cas d'erreur,
        les concepteurs du langage ont préféré interdire l'héritage multiple.
        */

public class Capital extends Ville {//HERITE le contenu (propriétés méthodes, de ville)
    //On a pour l'instant le constructeur (ou les constructeurs de ville) mais si Capital crée son propre constructeur
    //alors java prendre le constructeur de Capital

    //C'est ICI que le nouveau mot PROTECTED fait son entrée.
    //EN FAIT,seules les méthodes et les variables déclarées PUBLIC ou PROTECTED peuvent être utilisées dans
    //une CLASSE HERITEE. LE compilateur rejette cotre demande lorsque vous tentez d'accéder à des ressources
    //PRIVATE d'une CLASSE MERE.

    //PROTECTED IMPIDE QUE PODAMES CAMBIAR EL VALOR DE UNA VARIABLE EN EL MAIN (como con PRIVATE)
    //PERO CONTRARIAMENTE A PRIVATE (QUE IMPIDE QUE LA CLASE HIJA ACCEDA A LAS PROPIEDADES O METODOS PRIVATE
    //DE LA CLASE MADRE) PROTECTED PERMITE A LAS CLASES HIJAS ACCEDER A LAS VARIABLES Y METODOS PROTECTED
    //DE LA CLASSE MADRE

    //Asi no tenemos que declarar de nuevo en Capital la variable nomVille por ejemplo, ya estaria declarada y
    //lista a inicializar en el constructor si queremos

    /*
    public Capital() {
        this.nomVille = "toto";//esto daba un error porque no podemos utilizar directamente las variables (propiedades)
                               //de la clase Ville (classe mère) car les variables de Ville estaban déclarées PRIVATE
    }
    */

    //BREF CE QUI VA DIFFERENCIER NOS OBJETS CAPITAL DE NOS OBJETS VILLES SERA LA PRESENCE D'UN NOUVEL ATTRIBUT
    //el nombre de un monumento, esto implica que debamos crear un constructor par défaut y un constructor
    //d'initialisation pour notre objet capital

    //******************************************************************************************************************
    //                                       CONSTRUCTEUR 1 PAR DEFAUT DE CAPITAL
    // *****************************************************************************************************************

    /*
     il faut que vous sachiez que nous pouvons faire appel aux variables de la classe mère dans nos constructeurs
     grâce au mot clé SUPER. Cela aura pour effet de récupérer les éléments de l'objet de base, et de les envoyer à
     notre objet
    */
    private String monument;

    public Capital() {//CONSTRUCTEUR PAR DEFAUT
        super();//en este ejemplo podria no poner super (facultativo) ya que al tener el padre un constructor sin parametros
        //el constructor hijo pointe directamente hacia el constructor sin paramentros (considerado par defaut)

        //Ce mot clé appelle le constructeur de la classe mère
        //importa lo que se inicializo en el constructor de la classe madre Ville (obligatorio cuando el constructor
        // del padre que importamos tiene parametros)
        monument = "aucun";//y asi solo tendria que agregar esta nueva variable inicializada par defaut
    }
    /*
    OJO: LA IMPORTACION DE PROPIEDADES DE MI CONSTRUCTOR CAPITAL DESDE EL CONSTRUCTOR DE LA CLASSE PARENT
         SE EFECTUA INCLUSO SIN "SUPER();" cuando el constructor par defaut de la classe padre no tiene parametros ()

    //******************************************************************************************************************
                           super() sert à appeler un constructeur de la classe madre.
                     Ceci est rendu nécessaire lorsque qu'on déclare une classe hija , et que celle-ci
                               ne possède pas de constructeur avec les mêmes parametres.

                               Il faudrait savoir qu'il y a un appel implicite au CONSTRUCTEUR SANS ARGUMENTS
                               de la classe mère qui se fait. dans ce premier cas, ce super() est facultatif
                               vu que le constructeur de la classe Ville sera appelé implicitement.
    //******************************************************************************************************************
    CON SUPER ESTARIAMOS IMPORTANDO EL CONTENIDO sin tener que declararlo de nuevo ya que estamos en el constructor de
    Capital:

    public Ville() {//constructeur 1 par defaut sans paramètres

    System.out.println("Création d'une ville");
    nomVille = "Inconnu";
    nomPays = "Inconnu";
    nbreHabitants = 0;
    this.setCategorie();

    nbreInstances++;
    nbreInstancesBis++;
}
    */

    //******************************************************************************************************************
    //                                       CONSTRUCTEUR 2 DE INITIALISATION de CAPITAL
    // *****************************************************************************************************************
    public Capital(String nomVille, String nomPays, int nbreHabitants, String monument) {
        super(nomVille, nomPays, nbreHabitants);
        this.monument = monument;
    }
    //SIN EMBARGO NUESTRO METODO decrisToi() no tiene esta nueva variable monument. SUPER() funciona tambien
    //con los metodos de classe (metodos definidos en la classe) lo cual nos daria un metodo decrisToi() un poco
    //diferente ya que agregaremos monumento

    //******************************************************************************************************************
    //                                       METODO REESCRITO "POLIMORPHISMO"
    // *****************************************************************************************************************

    public String decrisToi() {//reescribo el metodo de la clase mère
        String str = super.decrisToi() + "\t" + this.monument + " est un monument";
        return str;//2
    }
    //SUPERCLASS  class mere

    //******************************************************************************************************************
    //                            SETTER GETTER DU MONUMENT
    // *****************************************************************************************************************
    public void setMonument(String monument) {
        this.monument = monument;
    }

    public String getMonument() {
        return monument;
    }
    //******************************************************************************************************************
    //                                        ToString()  redefinie
    // *****************************************************************************************************************
    public String toString(){
        String str = super.toString() + "\n \t ==>>" + this.monument + " en est un monument";
        return str;
    }


}


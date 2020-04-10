package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.III_ejemplo;

public class Main {
  public static void main(String[] args) {
    /*
    Dans la programmation orientée objet, il arrive que l'on doive cloner un objet. Le "clonage" d'un objet pourrait
    se définir comme la création d'une copie par valeur de cet objet. Dans ce tutoriel, nous allons voir comment est
    implémenté ce concept dans le langage Java.

    Remarque : pour bien comprendre ce tutoriel, il est nécessaire de connaître la différence entre un objet immuable et
    un objet non immuable (cf Classes et objets immuables).
    */
    /*=====================================================================================================================
                                           II. L'interface Cloneable
    =====================================================================================================================*/
   /*
   Pour pouvoir être clonée, une classe doit implémenter l'interface Cloneable. Celle-ci indique que la classe peut
   réécrire la méthode clone() héritée de la classe Object afin que ses instances puissent procéder à une copie de
   ses attributs vers une nouvelle instance (copie de l'objet par valeur).

   Par convention, les classes implémentant l'interface Cloneable doivent réécrire la méthode Object.clone() (qui est protected)
   avec une visibilité public.

   Notez que l'interface Cloneable ne contient PAS la méthode clone(). Par conséquent, il est impossible de cloner un
   objet si sa classe ne fait qu'implémenter cette interface. Même si la méthode clone() est appelée par réflexion,
   son succés n'est pas garanti.

   Une classe implémentant l'interface Cloneable doit nécessairement réécrire la méthode clone() pour pouvoir être clonée ;
   à l'inverse, une classe réécrivant la méthode clone() doit implémenter l'interface Cloneable sous peine de se retrouver
   avec une CloneNotSupportedException.
   */
    /*=====================================================================================================================
                                           III. La méthode clone()
    =====================================================================================================================*/
   /*
   Comme nous l'avons vu, une classe implémentant l'interface Cloneable doit réécrire la méthode clone(). La méthode
   clone() doit retourner une copie de l'objet que l'on veut cloner. Cette copie dépend de la classe de l'objet,
   cependant elle doit respecter des conditions (dont certaines par convention).

   Pour un objet "clonable" x :

   l'expression

               x.clone() != x

   doit renvoyer true ;

   l'expression

               x.clone().getClass() == x.getClass()

   doit renvoyer true (par convention) ;

   l'expression

               x.clone().equals(x)

   doit renvoyer true (par convention).

   Par convention, l'objet retourné doit être obtenu par un appel à la méthode super.clone() .
   Si une classe et toutes ses classes parentes (exceptée la classe Object) respectent cette convention, alors l'expression

               x.clone().getClass() == x.getClass()

   renvoie bien true.
   Par convention, l'objet retourné doit être indépendant de l'objet cloné, c'est à dire que tous les attributs non
   immuables devront être eux aussi clonés.

   Il faut aussi connaître l'implémentation par défaut de la méthode clone() (méthode clone() de la classe Object).
   La méthode clone() de la classe Object effectue une opération de clonage spécifique. Dans un premier temps, si la classe
   de l'objet n'implémente pas l'interface Cloneable alors une CloneNotSupportedException est levée. Dans le cas contraire,
   une nouvelle instance de la classe de l'objet est créée puis les attributs sont initialisés avec ceux de l'objet cloné.
   Cependant la copie de ces attributs se fait par référence et non par valeur (ils ne sont pas clonés !).

   On appelle ce procédé une "copie de surface" ("shallow copy") opposée à la "copie en profondeur" ("deep copy") qui, elle,
   correspond au processus de clonage décrit précédemment.

   Donc, pour résumer, les points importants de la réécriture de la méthode clone() sont :

            .récupérer l'objet à renvoyer en appelant la méthode super.clone(),
            .cloner les attributs non immuables afin de passer d'une copie de surface à une copie en profondeur de l'objet.
   */


    //Voici un code pour mettre en pratique ces classes :
    Personne personne1 = new Personne(new Patronyme("Jean", "Dupond"), 30);
    Personne personne2 = (Personne) personne1.clone();
    System.out.println(personne1);
    System.out.println(personne2);
    Enfant enfant1 = new Enfant(new Patronyme("Pierre", "Dupond"), 10, new Jouet("Teddy bear"));
    Enfant enfant2 = (Enfant) enfant1.clone();
    System.out.println(enfant1);
    System.out.println(enfant2);

    /*
       Ce qui donne la chose suivante :

       Personne@923e30
       Personne@130c19b
       Enfant@11b86e7
       Enfant@35ce36
    */

   /*===================================================================================================================
                                          VI. Remarques
   ===================================================================================================================*/
   /*
   Précisons que la classe Object n'implémente pas l'interface Cloneable, donc appeler la méthode clone() sur un objet
   dont la classe est Object lèvera invariablement une CloneNotSupportedException.

   Notons également que les tableaux sont considérés comme implémentant l'interface Cloneable. Cependant c'est la
   méthode clone() par défaut qui est utilisée (copie de surface), les objets contenus dans les deux tableaux sont
   donc copiés par référence.
   */
  }
}
//Voici quelques classes illustrant ces propos :
 /*=====================================================================================================================
                                        Patronyme
 =====================================================================================================================*/

class Patronyme implements Cloneable {//lo hacemos clonable

  private String prenom;
  private String nom;

  public Patronyme(String prenom, String nom) {
    this.prenom = prenom;
    this.nom = nom;
  }

  public Object clone() {
    Object o = null;
    try {
      // On récupère l'instance à renvoyer par l'appel de la
      // méthode super.clone()
      o = super.clone();
    } catch (CloneNotSupportedException cnse) {
      // Ne devrait jamais arriver car nous implémentons
      // l'interface Cloneable
      cnse.printStackTrace(System.err);
    }
    // on renvoie le clone
    return o;
  }
}

/*=====================================================================================================================
                                          Personne
=====================================================================================================================*/
class Personne implements Cloneable {//lo hacemos clonable

  private Patronyme patronyme;
  private int age;

  public Personne(Patronyme patronyme, int age) {//los parametros de entrada puedenb hacer el objeto non immuable
    this.patronyme = patronyme; // (Patronyme)patronyme.clone() podriamos hacerlo aqui pa hacerlo immuable
    this.age = age;
  }

  public Object clone() {
    Personne personne = null;
    try {
      // On récupère l'instance à renvoyer par l'appel de la
      // méthode super.clone()
      personne = (Personne) super.clone();
    } catch (CloneNotSupportedException cnse) {
      // Ne devrait jamais arriver car nous implémentons
      // l'interface Cloneable
      cnse.printStackTrace(System.err);
    }

    // On clone l'attribut de type Patronyme qui n'est pas immuable.
    personne.patronyme = (Patronyme) patronyme.clone();//podemos clonar patronyme porque , lo volvimos clonable

    // on renvoie le clone
    return personne;//enviamos la copia con una copia (atributo immuable) que podria ser modificado
  }                 //al enviar esta copia con un atributo immuable copia, si lo modificamos, esto no cambiaria
}                   //el valor original de este objeto atributo immuable ya que es una copia tambien
 /*=====================================================================================================================
                                           Jouet
 =====================================================================================================================*/

class Jouet implements Cloneable {//lo hacemos clonable

  private String nom;

  public Jouet(String nom) {
    this.nom = nom;
  }

  public Object clone() {
    Object o = null;
    try {
      // On récupère l'instance à renvoyer par l'appel de la
      // méthode super.clone()
      o = super.clone();
    } catch (CloneNotSupportedException cnse) {
      // Ne devrait jamais arriver car nous implémentons
      // l'interface Cloneable
      cnse.printStackTrace(System.err);
    }
    // on renvoie le clone
    return o;
  }
}

/*=====================================================================================================================
                                           Enfant
=====================================================================================================================*/
class Enfant extends Personne {

  private Jouet jouetPrefere;

  public Enfant(Patronyme patronyme, int age, Jouet jouetPrefere) {
    super(patronyme, age);
    this.jouetPrefere = jouetPrefere;
  }

  public Object clone() {
    // On récupère l'instance à renvoyer par l'appel de la
    // méthode super.clone() (ici : Personne.clone())
    Enfant enfant = (Enfant) super.clone();//copio el objeto

    // On clone l'attribut de type Jouet qui n'est pas immuable.
    enfant.jouetPrefere = (Jouet) jouetPrefere.clone();//y le agrego este atributo Jouet a esta clase Enfant que hereda de Person

    // on renvoie le clone
    return enfant;
  }
}



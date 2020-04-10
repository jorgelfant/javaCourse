package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.IV_ejemplo;

public class Main {
  public static void main(String[] args) {

   /*===================================================================================================================
                                        IV. Enfant
   ===================================================================================================================*/
    /*
    Dans le cas où votre classe possède un attribut non immuable et non clonable, vous ne pouvez tout simplement pas
    le cloner. Bien que vous puissiez utiliser un constructeur par copie de votre attribut (s'il en possède un), vous
    pouvez vous retrouver dans le cas où vos deux objet (original et clone) possède le même attribut (même instance).

    Notez que cette situation n'est pas "anormale" (ne paniquez pas si elle se présente à vous), il est en effet
    possible que l'on veuille délibérément garder la même instance d'un attribut.

    Après tout, ce n'est peut être pas pour rien qu'il n'implémente pas l'interface Cloneable.
    */

  /*====================================================================================================================
                                  V. Hériter d'une classe non clonable
  ====================================================================================================================*/
  /*
    Dans le cas où votre classe hérite d'une classe non clonable, sachez que l'appel à la méthode super.clone() revient
    à éxécuter la méthode clone() par défaut (copie de surface). Cela veut dire que les attributs non immuables de la
    classe parente ne seront pas clonés !

    C'est à vous qu'il revient de les cloner, à moins qu'ils soient inaccessibles (déclarés private) ou non clonables.
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

    Personne personne1 = new Personne(new Patronyme("Pierre", "Dupond"), 31);
    Personne personne2 = new Personne(new Patronyme("Paul", "Dupond"), 32);

    Personne[] array1 = {personne1, personne2};
    Personne[] array2 = array1.clone();

    System.out.println("array1 : " + array1);
    System.out.println("array2 : " + array2);
    System.out.println("array1[0] : " + array1[0]);
    System.out.println("array2[0] : " + array2[0]);
    /*
    La sortie générée doit ressembler à ceci :

    array1 : [LPersonne;@923e30
    array2 : [LPersonne;@130c19b
    array1[0] : Personne@1f6a7b9
    array2[0] : Personne@1f6a7b9
    */

    /*
    On voit bien que les deux tableaux sont deux instances différentes, mais on remarque aussi que les objets
    contenus pointent vers la même instance, ils n'ont donc pas été clonés.
    --------------------------------------------------------------------------------------------------------------------
    PARA EVITAR ESTO podriamos hacer una copia por valor , por ejemplo con un for copiar en cada elemento del
    arreglo 2 una copia de cada elemento del arreglo 1 !
    --------------------------------------------------------------------------------------------------------------------
    Une dernière remarque, depuis Java 5 il est possible de changer le type de retour d'une méthode que l'on réécrit
    à condition que celui-ci dérive du type original. Dans notre cas cette fonctionnalité se révèle particulièrement
    intéressante car cela nous permet d'éviter les transtypages lors de l'appel à la méthode clone().

    */
    System.out.println();
    //******************************************************************************************************************

    //et voici le nouveau code pour cloner nos objets :
    Personne personneI = new Personne(new Patronyme("Jean", "Dupond"), 30);
    // Plus besoin de transtyper pour cloner la personne.
    Personne personneII = personneI.clone();
    System.out.println(personneI);
    System.out.println(personneII);

    Enfant enfant1 = new Enfant(new Patronyme("Pierre", "Dupond"), 10, new Jouet("Teddy bear"));
    // Plus besoin de transtyper pour cloner l'enfant.
    Enfant enfant2 = enfant1.clone();
    System.out.println(enfant1);
    System.out.println(enfant2);
  }
}

/*********************************************************************************************************************
 Voici les nouvelles méthodes clone() de nos classes :
 *********************************************************************************************************************/

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

  // Méthode clone() de la classe Patronyme
  // Renvoie maintenant un objet de type Patronyme et non plus de type Object
  public Patronyme clone() {//Object
    Patronyme patronyme = null; //Object o = null;
    try {
      // On récupère l'instance à renvoyer par l'appel de la
      // méthode super.clone()
      patronyme = (Patronyme) super.clone();
    } catch (CloneNotSupportedException cnse) {
      cnse.printStackTrace(System.err);
    }
    // on renvoie le clone
    return patronyme;
  }
}

/*=====================================================================================================================
                                          Personne
=====================================================================================================================*/
class Personne implements Cloneable {//lo hacemos clonable

  private Patronyme patronyme;
  private int age;

  public Personne(Patronyme patronyme, int age) {
    this.patronyme = patronyme;
    this.age = age;
  }

  // Méthode clone() de la classe Personne
  // Renvoie maintenant un objet de type Personne et non plus de type Object
  public Personne clone() {
    Personne personne = null;
    try {
      personne = (Personne) super.clone();
    } catch (CloneNotSupportedException cnse) {
      cnse.printStackTrace(System.err);
    }
    // Plus besoin de transtyper pour cloner le patronyme.
    personne.patronyme = patronyme.clone();//podemos clonar patronyme porque , lo volvimos clonable
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

  // Méthode clone() de la classe Jouet
  // Renvoie maintenant un objet de type Jouet et non plus de type Object
  public Jouet clone() {
    Jouet jouet = null;
    try {
      // On récupère l'instance à renvoyer par l'appel de la
      // méthode super.clone()
      jouet = (Jouet) super.clone();
    } catch (CloneNotSupportedException cnse) {
      // Ne devrait jamais arriver car nous implémentons
      // l'interface Cloneable
      cnse.printStackTrace(System.err);
    }
    // on renvoie le clone
    return jouet;
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

  // Méthode clone() de la classe Enfant
  // Renvoie maintenant un objet de type Enfant et non plus de type Object
  //ESTO DEBE ENVIAR UNA COPIA DEL OBJETO Y UNA COPIA DE OBJETOS QUE NO SON IMMUTABLES ( osea alterables)
  //al enviar la copia esto evitara que modifiquemos el original
  //*****************************************************************************************************
  public Enfant clone() {
    // On récupère l'instance à renvoyer par l'appel de la
    // méthode super.clone() (ici : Personne.clone())
    Enfant enfant = (Enfant) super.clone();//crea o va enviar  un objeto copia
    // Plus besoin de transtyper pour cloner le jouet.
    enfant.jouetPrefere = jouetPrefere.clone();//este objeto copio tendra un atributo (clase Jouet) que sera tb una copia
    // on renvoie le clone
    return enfant;//este objeto copia tendra atributos (clases hechas por mi) copia
  }
}


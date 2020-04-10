package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.I_ejemplo;

/*=====================================================================================================================
                                           Classe utilisatrice
=====================================================================================================================*/
class CookieMachine {
  /*
  ====================================================================================================================
                                          PROTOTYPE
  ====================================================================================================================

  Simplifier la création d'une instance d'une classe en recopiant un objet existant

  Le patron de conception prototype est utilisé lorsque la création d'une instance est complexe ou consommatrice
  en temps. Plutôt que créer plusieurs instances de la classe, on copie la première instance et on modifie la copie
  de façon appropriée.

  Pour implanter ce patron il faut déclarer une classe abstraite spécifiant une méthode abstraite (virtuelle pure en C++)
  appelée clone(). Toute classe nécessitant un constructeur polymorphique dérivera de cette classe abstraite et
  implantera la méthode clone().

  Le client de cette classe, au lieu d'écrire du code invoquant directement l'opérateur "new" sur une classe
  explicitement connue, appellera la méthode clone() sur le prototype ou passera par un mécanisme fourni par un autre
  patron de conception (par exemple une méthode de fabrique avec un paramètre désignant la classe concrète à instancier).

  ====================================================================================================================
                                          STRUCTURE
  ====================================================================================================================

  Le diagramme UML de classes est le suivant :

                             -------------------------
                             |       PROTOTYPE       |
                             -------------------------
                             |                       |
                             -------------------------
                             | + clone() : Prototype |
                             -------------------------
                                        /\
                                        |
                                        |
                             -------------------------
                            |                         |
                ------------------------         ------------------------
                | PrototypeA           |         | PrototypeB           |
                -----------------------          ------------------------
                |                      |         |                      |
                ------------------------         ------------------------
                |+ clone() : Prototype |         |+ clone() : Prototype |
                ------------------------         ------------------------

              Diagramme UML des classes du patron de conception prototype

 La classe Prototype sert de modèle principal pour la création de nouvelles copies. Les classes PrototypeA et
 PrototypeB viennent spécialiser la classe Prototype en venant par exemple modifier certains attributs.
 La méthode clone() doit retourner une copie de l'objet concerné. Les sous-classes peuvent hériter ou surcharger
 la méthode clone(). La classe utilisatrice va se charger d'appeler les méthodes de clonage de la classe Prototype.
  */
  private Cookie cookie; // peut aussi être déclaré comme : private Cloneable cookie;

  public CookieMachine(Cookie cookie) {//cuando creo un objeto de tipo cookieMachine, esto inicia un objeto cookie n parametro
    this.cookie = cookie;
  }

  public Cookie makeCookie() {//y con esta funcion obtenemos un clon del objeto creado Cookie en el parametre
    return cookie.clone();
  }

  public static void main(String args[]) {
    Cookie tempCookie = null;
    Cookie prot = new CoconutCookie();
    CookieMachine cm = new CookieMachine(prot);//esto crear una CookieMachine y con su parametro se entra el valor del Cookie

    for (int i = 0; i < 100; i++){
      tempCookie = cm.makeCookie();//haria falto un sout para ver el resultado de cada uno, se envia un clon diferente a
    }                              //cada iteracion osea con una referencia diferente , lo cual esta bien
  }
}

/*=====================================================================================================================
                                        Classe Prototype
 =====================================================================================================================*/
class Cookie implements Cloneable {
  public Cookie clone() {
    try {
      Cookie copy = (Cookie) super.clone();
      // Dans une implémentation réelle de ce patron de conception, il faudrait
      // créer la copie en dupliquant les objets contenus et en attribuants des
      // valeurs valides (exemple : un nouvel identificateur unique pour la copie).
      return copy;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
/*=====================================================================================================================
                                     Prototype concrets à copier
=====================================================================================================================*/

class CoconutCookie extends Cookie {//este hijo podria ser enriquecido agregandole mas atributos etc

}

/*=====================================================================================================================
                                              EXEMPLES
=====================================================================================================================*/
/*
Exemple où prototype s'applique : supposons une classe pour interroger une base de données. À l'instanciation de
cette classe on se connecte et on récupère les données de la base avant d'effectuer tous types de manipulation.
Par la suite, il sera plus performant pour les futures instances de cette classe de continuer à manipuler ces données
que de réinterroger la base. Le premier objet de connexion à la base de données aura été créé directement puis initialisé.
Les objets suivants seront une copie de celui-ci et donc ne nécessiteront pas de phase d'initialisation.
*/

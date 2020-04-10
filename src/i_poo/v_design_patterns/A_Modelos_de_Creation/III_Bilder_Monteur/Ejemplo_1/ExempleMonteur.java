package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Bilder_Monteur.Ejemplo_1;

public class ExempleMonteur {
  public static void main(String[] args) {
    //Ce patron permet la construction d'objets complexes en construisant chacune de ses parties sans
    // dépendre de la représentation concrète de celles-ci.

    /* Construire un objet complexe partie par partie, à l'aide de différents monteurs possibles

    Le monteur (builder) est un patron de conception utilisé pour la création d'une variété d'objets complexes
    à partir d'un objet source. L'objet source peut consister en une variété de parties contribuant individuellement
    à la création de chaque objet complet grâce à un ensemble d'appels à l'interface commune de la classe abstraite
    Monteur.

    Un exemple d'objet source est une liste de caractères ou d'images dans un message devant être codé. Un objet
    directeur est nécessaire pour fournir les informations à propos de l'objet source vers la classe Monteur.
    La classe Monteur abstraite pourrait être une liste d'appel de l'interface que la classe directeur utilise comme
    par exemple handleCharacter() ou handleImage(). Chaque version concrète de la classe Monteur pourrait implémenter
    une méthode pour ces appels ou bien simplement ignorer l'information si appelée. Un exemple de monteur concret
    serait enigmaBuilder qui chiffrerait le texte, mais ignorerait les images.

    Dans l'exemple précédent, le logiciel va créer une classe Monteur spécifique, enigmaBuilder. Cet objet est passé
    à un objet directeur simple qui effectue une itération à travers chaque donnée du message principal de l'objet
    source. La classe monteur crée, incrémentalement, son projet final. Finalement, le code principal va demander
    l'objet final depuis le Monteur et ensuite détruire celui-ci et l'objet directeur. Par la suite, si jamais un
    remplacement de la technique de cryptage de enigmaBuilder par une autre se faisait sentir, une nouvelle classe
    Monteur pourrait être substituée avec peu de changements pour la classe directeur et le code principal. En effet,
    le seul changement serait la classe Monteur actuelle passée en paramètre au directeur.

    But : Séparer la construction d'un objet complexe de la représentation afin que le même processus de construction
    puisse créer différentes représentations.

    La structure des classes du patron de conception Monteur peut être représenté par le diagramme de classes UML
    suivant :


               ---------------------------------              -------------------------
              |        Directeur               |             |        Monteur         |
              |--------------------------------|             -------------------------   construit     ---------
              |  - monteur : Monteur           |<>---------  |                        | ---------->   | Object |
              |--------------------------------|             -------------------------                ---------
              | + construireObjet()            |             | + getObject() : object |
              | + getProduitB() : objet        |             | + monterPartieB()      |
              ---------------------------------              | + monterPartieB()      |
                                                             -------------------------
                                                                        /\
                                                                       ---
                                                                        |
                                                    ----------------------------------------
                                                    |                                      |
                                      ---------------------------------      ---------------------------------
                                     |   Monteur1                     |     |   Monteur2                     |
                                     | -------------------------------|     |--------------------------------|
                                     | + monterPartieA()              |     | + monterPartieA()              |
                                     | + monterPartieB()              |     | + monterPartieB()              |
                                     ---------------------------------      ---------------------------------


   .Monteur
       .interface abstraite pour construire des objets
   .Monteur1 et Monteur2
       .fournissent une implémentation de Monteur
       .construisent et assemblent les différentes parties des objets
   .Directeur
       .construit un objet en appelant les différentes méthodes afin de construire chaque partie de l'objet complexe
   .Objet
       .l'objet complexe en cours de construction
    */
    /* Un client commandant une pizza. */

    Serveur serveur = new Serveur();
    MonteurPizza monteurPizzaHawaii = new MonteurPizzaHawaii();
    MonteurPizza monteurPizzaPiquante = new MonteurPizzaPiquante();

    serveur.setMonteurPizza(monteurPizzaHawaii);
    serveur.construirePizza();

    Pizza pizza = serveur.getPizza();

    //HECHO POR MI PARA RECUPERAR LAS CARACTERISTICAS DE LA PIZZA
    System.out.println(monteurPizzaHawaii.toString());
  }
}

//**********************************************************************************************************************
//                                            Produit (OBJETO)
//**********************************************************************************************************************
class Pizza {
  private String pate = "";
  private String sauce = "";
  private String garniture = "";

  public void setPate(String pate) {
    this.pate = pate;
  }

  public void setSauce(String sauce) {
    this.sauce = sauce;
  }

  public void setGarniture(String garniture) {
    this.garniture = garniture;
  }

 //HECHO POR MI PARA RECUPERAR LAS CARACTERISTICAS DE LA PIZZA
  public String getPate() {
    return pate;
  }
  public String getSauce() {
    return sauce;
  }
  public String getGarniture() {
    return garniture;
  }

}

//**********************************************************************************************************************
//                                            Monteur
//**********************************************************************************************************************
abstract class MonteurPizza {
  protected Pizza pizza;//la variable  objeto no se puede creo modificar directamente en el main; por eso podemos ponerlo en protected
                        //pa que sus hijos puedan usarla
  public Pizza getPizza() {
    return pizza;
  }

  public void creerNouvellePizza() {
    pizza = new Pizza();
  }

  public String toString() {
    return this.getClass().getSimpleName() +" La pizza esta compuesta de una pasta : " + pizza.getPate() + ", una salsa : " + pizza.getSauce() +
      " y una garniture : " + pizza.getGarniture();
  }

  public abstract void monterPate();
  public abstract void monterSauce();
  public abstract void monterGarniture();
}

//**********************************************************************************************************************
//                                            Monteur Concret
//**********************************************************************************************************************
class MonteurPizzaHawaii extends MonteurPizza {
  public void monterPate() {
    pizza.setPate("croisée");
  }

  public void monterSauce() {
    pizza.setSauce("douce");
  }

  public void monterGarniture() {
    pizza.setGarniture("jambon+ananas");
  }
}

//**********************************************************************************************************************
//                                            Monteur Concret
//**********************************************************************************************************************
class MonteurPizzaPiquante extends MonteurPizza {
  public void monterPate() {
    pizza.setPate("feuilletée");
  }

  public void monterSauce() {
    pizza.setSauce("piquante");
  }

  public void monterGarniture() {
    pizza.setGarniture("pepperoni+salami");
  }
}

//**********************************************************************************************************************
//                                            Directeur
//**********************************************************************************************************************
class Serveur {
  private MonteurPizza monteurPizza;

  public void setMonteurPizza(MonteurPizza mp) {//elijo  MonteurPizzaHawaii ou MonteurPizzaPiquante que heredan de MonteurPizza
    monteurPizza = mp;
  }

  public Pizza getPizza() {
    return monteurPizza.getPizza();
  }

  public void construirePizza() {
    monteurPizza.creerNouvellePizza();//construye la pizza    public void creerNouvellePizza() {pizza = new Pizza(); }
    monteurPizza.monterPate();//para asi dentro de cada uno de los metodos siguientes definir su contenido pizza.setPate("") etc
    monteurPizza.monterSauce();
    monteurPizza.monterGarniture();
  }
}

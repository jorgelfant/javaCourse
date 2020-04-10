package i_poo.v_design_patterns.A_Modelos_de_Creation.I_factory;

public class B_Factory {
  public static void main(String[] args) {
    /*
    Il est possible d'implémenter la fabrique sous la forme d'une classe qui possède une méthode chargée de
    renvoyer l'instance voulue. La création de cette instance est alors réalisée en fonction de données du contexte
    (valeurs fournies en paramètres de la méthode, fichier de configuration, paramètres de l'application, ...).

    Dans l'exemple ci-dessous, la méthode getProduitA() attend en paramètre une constante qui précise le type
    d'instance à créer.

                                          ---------------------------------
                                         |              Client            |
                                         |--------------------------------|
                                         |                                |
                                         |                                |
                                         | + main(String[])               |
                                         ---------------------------------
                                                |                       |
                                                |                       |
                                                |                       |
                                                |                      \/
             ----------------------------       |                     ---------------------------------
            |        ProduitA           |       |                    |   ProduitFactory               |
            |---------------------------| <-----                     |--------------------------------|
            |                           |                            |                                |
            | + methodeA()              |                            | # getProduitA(int) : ProduitA  |
            ----------------------------                             ---------------------------------
                          /\                                                   |               |
                          |                                      instancie     |               |
               --------------------------------------        -------------------               |
               |                                    |        |                                 |
               |                                    |        |                                 |
               |                                    |        |                                 |
               |                                    |        |                                 |
               |                                    |        |                                 |
               |                                    |       \/                                 |
               |                                 -------------------                           |
               |                                |    ProduitA2      |                          | instancie
               |                                |------------------|                           |
               |                                |                  |                           |
               |                                | + methodeA()     |                           |
               |                                -------------------                            |
               |                                                                               |
               |                                                                               |
       -------------------                                                                     |
      |    ProduitB      |                                                                     |
      |------------------| <-------------------------------------------------------------------
      |                  |
      | + methodeA()     |
      -------------------

    */
    ProduittFactory produittFactory = new ProduittFactory();

    ProduittA produitA = null;

    produitA = produittFactory.getProduittA(ProduittFactory.TYPE_PRODUITA1);
    produitA.methodeA();

    produitA = produittFactory.getProduittA(ProduittFactory.TYPE_PRODUITA2);
    produitA.methodeA();

    produitA = produittFactory.getProduittA(3);
    produitA.methodeA();
    /*
      ProduitA1.methodeA()
      ProduitA2.methodeA()
      Exception in thread "main" java.lang.IllegalArgumentException: Type de produit inconnu
	    at poo.v_design_patterns.A_Modelos_de_Creation.a_factory.ProduittFactory.getProduittA(B_Factory.java:89)
	    at poo.v_design_patterns.A_Modelos_de_Creation.a_factory.B_Factory.main(B_Factory.java:65)
    */
  }
}

//**********************************************************************************************************************
//                                    CLASES EXTERNAS
//**********************************************************************************************************************

abstract class ProduittA {

  public abstract void methodeA();
}

class ProduittA1 extends ProduittA {
  public void methodeA() {
    System.out.println("ProduitA1.methodeA()");
  }
}

class ProduittA2 extends ProduittA {
  public void methodeA() {
    System.out.println("ProduitA2.methodeA()");
  }
}

//**********************************************************************************************************************

class ProduittFactory {//esto crea el objeto segun el tipo que ponga como argumento ( )

  public static final int TYPE_PRODUITA1 = 1;
  public static final int TYPE_PRODUITA2 = 2;

  public ProduittA getProduittA(int typeProduit) {
    ProduittA produitA = null;

    switch (typeProduit) {
      case TYPE_PRODUITA1:
        produitA = new ProduittA1();
        break;
      case TYPE_PRODUITA2:
        produitA = new ProduittA2();
        break;
      default:
        throw new IllegalArgumentException("Type de produit inconnu");
    }
    return produitA;
  }
}

/*
 Cette implémentation est plus légère à mettre en oeuvre.

      Remarque : c'est une bonne pratique de toujours respecter la même convention de nommage dans le nom des
      fabriques et dans le nom de la méthode qui renvoie l'instance.
*/

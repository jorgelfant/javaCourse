package i_poo.v_design_patterns.A_Modelos_de_Creation.I_factory;

public class A_Factory {
  public static void main(String[] args) {
    /*

    La fabrique permet de créer un objet dont le type dépend du contexte : cet objet fait partie d'un ensemble de
    sous-classes. L'objet retourné par la fabrique est donc toujours du type de la classe mère mais grâce au
    polymorphisme les traitements exécutés sont ceux de l'instance créée.

    Ce motif de conception est utilisé lorsqu'à l'exécution il est nécessaire de déterminer dynamiquement quel
    objet d'un ensemble de sous-classes doit être instancié.

    Il est utilisable lorsque :

        .Le client ne peut déterminer le type d'objet à créer qu'à l'exécution
        .Il y a une volonté de centraliser la création des objets

    L'utilisation d'une fabrique permet de rendre l'instanciation d'objets plus flexible que l'utilisation de
    l'opérateur d'instanciation new.

    Ce design pattern peut être implémenté sous plusieurs formes dont les deux principales sont :

        .Déclarer la fabrique abstraite et laisser une de ses sous-classes créer l'objet
        .Déclarer une fabrique dont la méthode de création de l'objet attend les données nécessaires pour déterminer le
    type de l'objet à instancier.

    Il est possible d'implémenter la fabrique sous la forme d'une classe abstraite et de définir des sous-classes
    chargées de réaliser les différentes instanciations.


                        ---------------------------------                                  -------------------
                       |   ProduitFactory               |                                 |    Client        |
                       |--------------------------------|                                 |------------------|
                       |                                | <------------------------------ | + main(String[]) |
                       | # createProduitA() : ProduitA  |                                 |                  |
                       | + getProduitA(): ProduitA      |                                 -------------------
                       ---------------------------------                                            |
                                       /\                                                           |
                                      ---                                                           |
                                       |                                                            |
                 ----------------------------------------------                                     |
                 |                                            |                                     |
  ---------------------------------            ---------------------------------                    |
 |   ProduitFactory               |           |   ProduitFactory               |                    |
 |--------------------------------|           |--------------------------------|                    |
 |                                |           |                                |                    |
 | # createProduitA() : ProduitA  |           | # createProduitA() : ProduitA  |                   \/
 ---------------------------------            ---------------------------------            -------------------
                              |                                           |               |     ProduitA     |
                              |                                           |               -------------------
                              |                                           |   instancie   | + methodeA()     |
                              |                                           |               --------------------
                              |                                           |                        |
                              |  instancie                                |                        |
                              |                                           |     ---------------------------
                              |                                          \/    |                          |
                              |                                  -------------------                      |
                              |                                 |    Client        |                      |
                              |                                 |------------------|                      |
                              |                                 |                  |                      |
                              |                                 | + methodeA()     |                      |
                              |                                 -------------------                       |
                              |                                                                           |
                              |                                                                    -------------------
                              ------------------------------------------------------------------> |     ProduitA     |
                                                                                                  -------------------
                                                                                                  | + methodeA()     |
                                                                                                  --------------------

   La classe ProduitFactory propose la méthode getProduitA() qui se charge de retourner l'instance créée par la
   méthode createProduitA().

   Les classes ProduitFactory1 et ProduitFactory2 sont les implémentations concrètes de la fabrique. Elles redéfinissent
   la méthode createProduitA() pour qu'elle renvoie l'instance du produit.

   La classe ProduitA est la classe abstraite mère de tous les produits.

   Les classes ProduitA1 et ProduitA2 sont des implémentations concrètes de produits.*/


    ProduitFactory produitFactory1 = new ProduitFactory1();
    ProduitFactory produitFactory2 = new ProduitFactory2();

    ProduitA produitA = null;

    System.out.println("Utilisation de la premiere fabrique");
    produitA = produitFactory1.getProduitA();
    produitA.methodeA();

    System.out.println("Utilisation de la seconde fabrique");
    produitA = produitFactory2.getProduitA();
    produitA.methodeA();

    /*
     Utilisation de la premiere fabrique
     ProduitA1.methodeA()
     Utilisation de la seconde fabrique
     ProduitA2.methodeA()
   */


  }
}

abstract class ProduitA {//o interface
  public abstract void methodeA();
}

class ProduitA1 extends ProduitA {
  public void methodeA() {
    System.out.println("ProduitA1.methodeA()");
  }
}

class ProduitA2 extends ProduitA {
  public void methodeA() {
    System.out.println("ProduitA2.methodeA()");
  }
}

//**********************************************************************************************************************

abstract class ProduitFactory {
  public ProduitA getProduitA() {
    return createProduitA();
  }

  protected abstract ProduitA createProduitA();
}

class ProduitFactory1 extends ProduitFactory {
  protected ProduitA createProduitA() {
    return new ProduitA1();
  }
}

class ProduitFactory2 extends ProduitFactory {
  protected ProduitA createProduitA() {
    return new ProduitA2();
  }
}




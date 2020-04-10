package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_1;

public class Client {
  public static void main(String[] args) {
    /*
    Ce patron permet la création d'un objet dont la classe dépend des paramètres de construction
    (un nom de classe par exemple).

    Le motif de conception Abstract Factory (fabrique abstraite) permet de fournir une interface unique pour
    instancier des objets d'une même famille sans avoir à connaître les classes à instancier.

    L'utilisation de ce motif est pertinente lorsque :

        .Le système doit être indépendant de la création des objets qu'il utilise
        .Le système doit être capable de créer des objets d'une même famille

    Le principal avantage de ce motif de conception est d'isoler la création des objets retournés par la fabrique.
    L'utilisation d'une fabrique abstraite permet de facilement remplacer une fabrique par une autre selon les besoins.

    Le motif de conception fabrique abstraite peut être interprété et mis en oeuvre de différentes façons.
    Le diagramme UML ci-dessous propose une mise en oeuvre possible avec deux familles de deux produits.
                                      I
                      ---------------------------------
                     |   ProduitFactory               |
                     |--------------------------------|            import               -------------------
                     |                                | <------------------------------ |     Client       |
                     | + getProduitA() : ProduitA     |                                 |                  |
                     | + getProduitB() : ProduitB     |                                 -------------------
                     ---------------------------------                                            |     |
                                     /\                                                           |     |
                                    ---                                                           |     |
                                     |                                                    import  |     |
               ----------------------------------------                                  ---------      |
               |                                      |                                  |              |
 ---------------------------------      ---------------------------------                |              | import
|   ProduitFactory1              |     |   ProduitFactory2              |                |              |
| -------------------------------|     |--------------------------------|               \/              |
| + getProduitA() : ProduitA     |     | + getProduitA() : ProduitA     |        ----------------       |
| + getProduitB() : ProduitB     |     | + getProduitB() : ProduitB     |        | ProduitB     |       |
---------------------------------      ---------------------------------         ---------------        |
        |     |                           |          |                           | + methodeB() |       |
        |     |                           |          |                           ---------------        |
        |     |                           |          |                              /\                  -----------
        |     |         instancie         |          |                              |                             |
        |     -------------------------------------------------          ---------------------                    |
        |                                 |          |        |          |                   |                   \/
        |                                 |          |       \/          |                   |            ----------------
        |                                 |          |      -------------------    -------------------   |    ProduitA   |
        |                                 |          |     |    ProduitB1     |   |    ProduitB2     |   |---------------|
        |                                 |          |     |------------------|   |------------------|   |               |
        |                                 |          |     |                  |   |                  |   | + methodeA()  |
        |                                 |          |     | + methodeB()     |   | + methodeB()     |   ----------------
        |                                 |instancie |     -------------------    -------------------           /\
        |                                 |          |                                     /\                   |
        |                                 |          |           instancie                 |       ------------------------
        |                                 |          --------------------------------------        |                      |
        |                                 |                                                        |                      |
        |                                 |                                               ------------------     ------------------
        |                                 |                                               |   ProduitA2    |     |     ProduitA1  |
        |                                 ----------------------------------------------> -----------------      -----------------
        |                                                                                 | + methodeA()   |     | + methodeA()   |
        |                                                                                 ------------------     ------------------
        |                                                                                                                    /\
        |                                                   instancie                                                        |
        ---------------------------------------------------------------------------------------------------------------------


    Dans cet exemple, les classes suffixées par un chiffre correspondent aux classes relatives à une famille donnée.

    Les classes misent en oeuvre sont :

         .IProduitFactory : interface pour les fabriques de création d'objets. Elle définit donc les méthodes nécessaires
          à la création des objets

         .ProduitFactory1 et ProduitFactory2 : fabriques qui réalisent la création des objets

         .ProduitA et ProduitB : interfaces des deux familles de produits (En Java, cela peut être une classe abstraite
          ou une interface)

         .ProduitA1, ProduitA2, ProduitB1 et ProduitB2 : implémentations des produits des deux familles

         .Client : classe qui utilise la fabrique pour obtenir des objets

    C'est une des classes filles de la fabrique qui se charge de la création des objets d'une famille. Ainsi tous les
    objets créés doivent hériter d'une classe abstraite qui sert de modèle pour toutes les classes de la famille.

    Le client utilise une implémentation concrète de la fabrique abstraite pour obtenir une instance d'un produit créé
    par la fabrique

    Cette instance est obligatoirement du type de la classe abstraite dont toutes les classes concrètes héritent. Ainsi
    des objets concrets sont retournés par la fabrique mais le client ne peut utiliser que leur interface abstraite.

    Comme il n'y a pas de relation entre le client et la classe concrète retournée par la fabrique, celle-ci peut renvoyer
    n'importe quelle classe qui hérite de la classe abstraite.

    Ceci permet facilement :

           .De remplacer une classe concrète par une autre.
           .D'ajouter de nouveaux types d'objets qui héritent de la classe abstraite sans modifier le code utilisé
            par la fabrique.

    Pour prendre en compte une nouvelle famille de produit dans le code client, il suffit simplement d'utiliser la
    fabrique dédiée à cette famille. Le reste du code client ne change pas. Ceci est beaucoup plus simple que d'avoir
    à modifier dans le code client l'instanciation des classes concrètes concernées.
    */

    //estos 2 ProduitFactory podriamos evitarlos si usamos los metodos estaticos de factoria1 y 2 que son estaticos
    //ProduitFactory1.giveProduitA();
    //ProduitFactory1.giveProduitB();
    ProduitFactory produitFactory1 = new ProduitFactory1();//sin esto si es que usamos luego el estatico
    ProduitFactory produitFactory2 = new ProduitFactory2();

    ProduitA produitA = null;
    ProduitB produitB = null;

    System.out.println("Utilisation de la premiere fabrique");
    produitA = produitFactory1.getProduitA();// ProduitFactory1.giveProduitA();  estatico
    produitB = produitFactory1.getProduitB();// ProduitFactory1.giveProduitB();
    produitA.methodeA();//ou ProduitFactory1.giveProduitA().methodeA();
    produitB.methodeB();

    System.out.println("Utilisation de la seconde fabrique");
    produitA = produitFactory2.getProduitA();// ProduitFactory2.giveProduitA();  estatico
    produitB = produitFactory2.getProduitB();// ProduitFactory2.giveProduitB();
    produitA.methodeA();
    produitB.methodeB();

    //Une fabrique concrète est généralement un singleton.

  }
}

























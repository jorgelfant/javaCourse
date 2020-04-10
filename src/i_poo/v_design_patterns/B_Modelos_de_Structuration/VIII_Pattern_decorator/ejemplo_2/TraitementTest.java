package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_2;

public class TraitementTest {
  public static void main(String[] args) {
    /*
    Le motif de conception décorateur (decorator en anglais) permet d'ajouter des fonctionnalités à un objet
    en mettant en oeuvre une solution plus souple que l'héritage : il permet d'ajouter des fonctionnalités à
    une ou plusieurs méthodes existantes d'une classe dynamiquement.

    La programmation orientée objet propose l'héritage pour ajouter des fonctionnalités à une classe, cependant
    l'héritage présente quelques contraintes et il n'est pas toujours possible de le mettre en oeuvre
    (par exemple si la classe est finale). L'héritage crée une nouvelle classe qui reprend les fonctionnalités
    de  la classe mère et les modifie ou les enrichie. Mais il présente quelques inconvénients :

            .Il n'est pas toujours possible (par exemple pour une classe déclarée finale)
            .Cela peut faire augmenter le nombre de classes pour définir tous les cas de figure requis
            .L'ajout des fonctionnalités est statique

    Avec l'héritage, il serait nécessaire de définir autant de classes filles que de cas ce qui peut vite devenir
    ingérable. Avec l'utilisation d'un décorateur, il suffit de définir un décorateur pour chaque fonctionnalité
    et de les utiliser par combinaison en fonction des besoins. L'héritage ajoute des fonctionnalités de façon
    statique (à la compilation) alors que le décorateur ajoute des fonctionnalités de façon dynamique (à l'exécution).

    Le modèle de conception décorateur apporte une solution à ces trois inconvénients et propose donc une alternative
    à l'héritage.

    Le motif de conception décorateur permet de définir un ensemble de classes possédant une base commune mais
    proposant chacune des variantes sans utiliser l'héritage qui est le mécanisme de base par la programmation
    orientée objet. Ceci permet d'enrichir une classe avec des fonctionnalités supplémentaires.

    Ce motif est dédié à la création de variantes d'une classe plutôt que d'avoir une seule classe prenant en
    compte ces variantes. Il permet aussi de réaliser des combinaisons de plusieurs variantes.

    Ce motif de conception est donc généralement utilisé lorsqu'il n'est pas possible de prédéfinir le nombre de
    combinaisons induites par l'ajout de nombreuses fonctionnalités ou si ce nombre est trop important. Le principe
    du motif de conception décorateur est d'utiliser la composition : le décorateur contient un objet décoré.
    L'appel d'une méthode du décorateur provoque l'exécution de la méthode correspondante du décoré et des
    fonctionnalités ajoutées par le décorateur.

    Le motif décorateur repose sur deux entités :

            .le décoré : interface ou classe qui définit les fonctionnalités de base
            .le décorateur : classe enrichie qui contient les fonctionnalités de base plus celles ajoutées

    Le décorateur encapsule le décoré dont l'instance est généralement fournie dans les paramètres d'un constructeur.
    Il est important que l'interface du décorateur reprenne celle de l'objet décoré. Pour permettre de combiner les
    décorations, le décoré et le décorateur doivent implémenter une interface commune.

                                        <Interface>
                                      ----------------
                                     | Decorable     |
                                     |---------------|
                                     | + operation() |<---------------------------------------------
                                     ----------------                                              |
                                      ^            ^                                               |
                                      |            |                                               |
                                      |            |                                               |
                                C     |            |                   C                           |
                         ----------------         ------------------------------------             |
                        |     Decore    |         |   Decorateur                     |             |
                        |---------------|         |----------------------------------|<>-----------
                        | + operation() |         | + operation()                    |
                        ----------------          |                                  |
                                                  | + Decorateur( decore: Decorable) |
                                                  -----------------------------------

      La combinaison peut alors être répétée pour construire un objet qui va contenir les différentes fonctionnalités
      proposées par les décorateurs utilisés.

      Le motif de conception décorateur est particulièrement utile dans plusieurs cas :

            .définition de fonctionnalités génériques qui peuvent prendre plusieurs formes
            .définition de plusieurs fonctionnalités optionnelles

      Il permet de créer un objet qui va être composé des fonctionnalités requises par ajouts successifs des
      différents décorateurs proposant les fonctionnalités requises.


                                                <Interface>
                                              ----------------
                                             |  Traitement   |
                                             |---------------|
                                             | + operation() |<-----------------------
                                             ----------------                        |
                                                    ^                                |
                                                    |                                |
                                                    |                                |
                                                    |                   C            |
                                    ------------------------------------             |
                                    |           Decorateur             |             |
                                    |----------------------------------|<>-----------
                                    | # traitement: Traitement         |
                                    |                                  |
                                    |                                  |
                                    | + operation()                    |
                                    |                                  |
                                    | + Decorateur( decore: Decorable) |
                                    |                                  |
                                    | + operation()                    |
                                    ------------------------------------
                                                      ^
                                                      |
              -------------------------------------------------------------------------------
             |                                        |                                     |
             |                                        |                                     |
   ----------------------------              -----------------------------              -----------------------------
  | TraitementDecorateur3     |             |  TraitementDecorateur2     |              | TraitementDecorateur1     |
  |---------------------------|             |----------------------------|              |---------------------------|
  | + operation()             |             | + operation()              |              | + operation()             |
  |                           |             |                            |              |                           |
  | + TraitementDecorateur3() |             | + TraitementDecorateur2()  |              | + TraitementDecorateur1() |
  |                           |             |                            |              |                           |
  | + TraitementDecorateur3() |             | + TraitementDecorateur2()  |              | + TraitementDecorateur1() |
  ----------------------------              -----------------------------               ----------------------------

  Un des avantages de ce motif de conception est de n'avoir à créer qu'une seule classe pour proposer des
  fonctionnalités supplémentaires aux classes qui mettent en oeuvre ce motif. Avec l'héritage, il serait nécessaire
  de créer autant de classes filles que de classes concernées ou de gérer la fonctionnalité dans une classe mère en
  modifiant cette dernière pour prendre en compte cet ajout avec tous les risques que cela peut engendrer.

  Il est possible de fournir une classe d'implémentation par défaut.

  Il est pratique d'utiliser le motif de conception fabrique pour construire l'objet décoré finale. Dans ce cas,
  une implémentation par défaut de l'interface peut être utile.

    L'API de base de Java utilise le motif de conception décorateur notamment dans l'API IO                                                                                                                  */
    System.out.println("traitement 1 2 3");
    Traitement traitement123 = new TraitementDecorateur3(new TraitementDecorateur2(new TraitementDecorateur1()));
    traitement123.Operation();

    System.out.println("traitement 1 3");
    Traitement traitement13 = new TraitementDecorateur3(new TraitementDecorateur1());
    traitement13.Operation();
    /*
    RESULTADO

    traitement 1 2 3
    TraitementDecorateur1.Operation()
    TraitementDecorateur2.Operation()
    TraitementDecorateur3.Operation()
    traitement 1 3
    TraitementDecorateur1.Operation()
    TraitementDecorateur3.Operation()
    */

  }
}
//Pour mettre en oeuvre ce motif, il faut :

//********************************************************************************************************************
//                  1) définir une interface qui va déclarer toutes les fonctionnalités des décorés.
//********************************************************************************************************************
interface Traitement {
  public void Operation();
}

//********************************************************************************************************************
//                  2) définir un décorateur de base qui implémente l'interface et possède une référence
//                     sur une instance de l'interface. Cette référence est le décoré qui va être enrichi
//                     des fonctionnalités du décorateur.
//********************************************************************************************************************
abstract class TraitementDecorateur implements Traitement {
  protected Traitement traitement;

  public TraitementDecorateur() {
  }

  public TraitementDecorateur(Traitement traitement) {
    this.traitement = traitement;
  }

  public void Operation() {
    if (traitement != null) {
      traitement.Operation();
    }
  }
}

//********************************************************************************************************************
//                  3) définir les décorateurs qui héritent du décorateur de base et implémentent
//                     les fonctionnalités supplémentaires qu'ils sont chargés de proposer.
//********************************************************************************************************************

//*********************************** TraitementDecorateur1 ***********************************************************
class TraitementDecorateur1 extends TraitementDecorateur {
  public TraitementDecorateur1() {
    super();
  }

  public TraitementDecorateur1(Traitement traitement) {
    super(traitement);
  }

  @Override
  public void Operation() {
    if (traitement != null) {//esto se podria remplazar con super
      traitement.Operation();
    }
    System.out.println("TraitementDecorateur1.Operation()");
  }
}

//*********************************** TraitementDecorateur2 ***********************************************************

class TraitementDecorateur2 extends TraitementDecorateur {

  public TraitementDecorateur2() {
    super();
  }

  public TraitementDecorateur2(Traitement traitement) {
    super(traitement);
  }

  @Override
  public void Operation() {
    if (traitement != null) {//esto se podria remplazar con super
      traitement.Operation();
    }

    System.out.println("TraitementDecorateur2.Operation()");
  }
}

//*********************************** TraitementDecorateur3 ***********************************************************

class TraitementDecorateur3 extends TraitementDecorateur {

  public TraitementDecorateur3() {
    super();
  }

  public TraitementDecorateur3(Traitement traitement) {
    super(traitement);
  }

  @Override
  public void Operation() {//esto se podria remplazar con super
    if (traitement != null) {
      traitement.Operation();
    }
    System.out.println("TraitementDecorateur3.Operation()");
  }
}

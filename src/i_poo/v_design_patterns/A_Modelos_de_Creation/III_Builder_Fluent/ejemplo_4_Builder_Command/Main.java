package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_4_Builder_Command;

public class Main {
  public static void main(String[] args) {

    //******************************************************************************************************************
    //           Le builder Command : beaucoup de setter, un seul build() (mais qui fait beaucoup)
    //******************************************************************************************************************
    /*Relativement similaire au builder-fluent décrit ci-dessus, la principale différence est qu’un traitement
      est effectué au sein de la méthode build.(transformer un nom en Human)   */

    new BoatBuilder().withOwnerName("Hadock").build();
    /*
    Ce pattern permet ainsi des traitement plus complexes lors de la conception: l’objet généré est plus que la
    somme des paramètres passés en entrée.

    L’avantage principal est que nous n’avons pas à construire d’objets complexes avant de les passer en entrée :
    ces traitements peuvent être faits au sein du build.
    */
  }
}

class Human {
  String owner;

  public Human(String owner) {
    this.owner = owner;
  }
}

//*******************************************
class Boat {
  Human captain;

  public void setCaptain(Human human) {
  }
  //...
}

//*******************************************
class BoatBuilder {
  String ownerName;

  BoatBuilder withOwnerName(String ownerName) {
    //...
    return this;
  }

  Boat build() {
    Boat boat = new Boat();
    boat.setCaptain(new Human(ownerName));
    return boat;
  }
}






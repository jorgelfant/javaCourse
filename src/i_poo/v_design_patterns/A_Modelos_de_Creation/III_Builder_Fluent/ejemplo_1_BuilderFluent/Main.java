package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_1_BuilderFluent;

public class Main {
  public static void main(String[] args) {


    //********************************************************************************************************************
    //                     Design pattern : Builder et Builder sont dans un bateau
    //********************************************************************************************************************

  /*
    On ne présente plus le patron builder, l’un des plus connus des patrons de conception…
    Mais parle-t-on toujours de la même chose?


  //********************************************************************************************************************
  //                           Qu’est-ce que le design pattern builder ?
  //********************************************************************************************************************

  Le Gang Of Four nous donne la définition suivante du design pattern « builder » :



  « Le pattern Builder est utilisé pour la création d’objets complexes dont les différentes parties doivent être
    créées suivant un certain ordre ou algorithme spécifique. Une classe externe contrôle l’algorithme de construction »


  On a également le rôle de ce design pattern :

  « Separate the construction of a complex object from its representation so that the same construction process can
    create different representations. »


  « dissocier la construction d’un objet de sa représentation, afin que le même processus de construction ait la
    possibilité de créer des représentations différentes »


  Typiquement, ce design pattern sera préconisé dans les situations où au moins :

    . l’objet final est imposant, et sa création complexe ;

    . beaucoup d’arguments doivent être passés à la construction de l’objet, afin d’avoir un design lisible ;

    . certains de ces arguments sont optionnels (par ex. : un bateau n’a pas forcément de capitaine, mais toujours une taille),
      ou ont plusieurs variations (la taille peut par exemple être passée en mètres ou en pieds).

  //********************************************************************************************************************
  //               Le builder fluent : beaucoup de méthodes chainées, un seul build
  //********************************************************************************************************************

   C’est l’image que l’on se fait le plus souvent du builder :
   Une suite de méthodes chainées, suivie d’un build final qui agrège les données, généralement dans une innerClass

                                                                                                                      */
    Boat hey;
    hey = Boat.BoatBuilder.newInstance().withSize(2).build();

  }
}

class Boat {
  int size;

  Boat(int size) {
    //...
  }

  static class BoatBuilder {//clases internas no pueden tener metodos static salvo si la clase es estatica
    int size;

    //metodo
    BoatBuilder withSize(int size) {
      this.size = size;
      return this;
    }

    //metodo
    static BoatBuilder newInstance() {
      return new BoatBuilder();
    }

    //metodo
    Boat build() {
      return new Boat(size);
    }
  }
}

/*
Ce builder permet ainsi facilement d’avoir des paramètres optionnels, à la différence d’un constructeur de base.
Mais les paramètres passés sont injectés tels quels dans les attributs de classes, sans traitements.
*/

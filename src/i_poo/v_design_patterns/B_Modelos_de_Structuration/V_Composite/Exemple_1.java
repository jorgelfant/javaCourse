package i_poo.v_design_patterns.B_Modelos_de_Structuration.V_Composite;

import java.util.ArrayList;

public class Exemple_1 {
  public static void main(String[] args) {
    //Initialise quatre ellipses
    Ellipse ellipse1 = new Ellipse();
    Rectangle rectangle = new Rectangle();
    Carré carré = new Carré();
    Ellipse ellipse2 = new Ellipse();
    Ellipse ellipse3 = new Ellipse();

    //Initialise three graphiques composites   que serian como dossiers
    CompositeGraphic graphic = new CompositeGraphic();
    CompositeGraphic graphic1 = new CompositeGraphic();
    CompositeGraphic graphic2 = new CompositeGraphic();

    //Composes les graphiques
    graphic1.add(ellipse1);
    graphic1.add(rectangle);
    graphic1.add(carré);

    graphic2.add(ellipse2);

    graphic.add(graphic1);
    graphic.add(graphic2);
    graphic.add(ellipse3);

    //Imprime le graphique complet (quatre fois la chaîne "Ellipse").
    graphic.print();
  }
}
//======================================================================================================================
//                                          Objet composite
//======================================================================================================================
/*
Créer une classe de manipulation de composants en utilisant la même interface commune que les composants

Dans ce patron de conception, un objet composite est constitué d'un ou de plusieurs objets similaires
(ayant des fonctionnalités similaires). L'idée est de manipuler un groupe d'objets de la même façon que s'il
s'agissait d'un seul objet. Les objets ainsi regroupés doivent posséder des opérations communes, c'est-à-dire
un "dénominateur commun".
*/

//======================================================================================================================
//                                          Quand l'utiliser
//======================================================================================================================
/*
Vous avez l'impression d'utiliser de multiples objets de la même façon, souvent avec des lignes de code identiques
ou presque. Par exemple, lorsque la seule et unique différence entre deux méthodes est que l'une manipule un objet de
type Carré, et l'autre un objet Cercle. Lorsque, pour le traitement considéré, la différenciation n'a pas besoin d'exister,
il serait plus simple de considérer l'ensemble de ces objets comme homogène.
*/

//======================================================================================================================
//                                              Un exemple
//======================================================================================================================
/*

Un exemple simple consiste à considérer l'affichage des noms de fichiers contenus dans des dossiers :

         .Pour un fichier, on affiche ses informations.
         .Pour un dossier, on affiche les informations des fichiers qu'il contient.

Dans ce cas, le patron composite est tout à fait adapté :

         .L'Objet est de façon générale ce qui peut être contenu dans un dossier : un fichier ou un dossier,
         .L'ObjetSimple est un fichier, sa méthode affiche() affiche simplement le nom du fichier,
         .L'ObjetComposite est un dossier, il contient des objets (c'est à dire des fichiers et des dossiers).
          Sa méthode affiche() parcourt l'ensemble des objets qu'il contient (fichier ou dossier) en appelant
          leur méthode affiche().
*/
//======================================================================================================================
//                                      Diagramme de classes UML
//======================================================================================================================
/*
Le patron de conception Objet composite peut être représenté par le diagramme de classes UML suivant :

                                      --------------------
                                      |      Objet       |
                                      --------------------
                                      |                  |---------------------------------------------
                                      --------------------                                            |
                                      | + operation()    |                                            |
                                      --------------------                                            |
                                               /\                                                     |
                                               |                                                      |
                                               |                                                      |
                        ----------------------------------------------------                          |
                        |                                                  |                          |
             ---------------------                            ----------------------------            |
             |   ObjetSimple     |                            |    ObjetComposite        |<>-----------
             ---------------------                            ----------------------------
             |                   |                            |                          |
             ---------------------                            ----------------------------
             | + operation()     |                            | + operation()            |
             ---------------------                            | + ajouter(objet : Objet) |
                                                              | + retirer(objet : Objet) |
                                                              ----------------------------

                         Diagramme des classes UML du patron de conception Objet composite

.Objet
    .déclare l'interface pour la composition d'objets
    .met en œuvre le comportement par défaut

.ObjetSimple
    .représente les objets manipulés, ayant une interface commune

.ObjetComposite
    .définit un comportement pour les composants ayant des enfants
    .stocke les composants enfants
    .met en œuvre la gestion des composants enfants

La classe utilisatrice manipule les objets de la composition à travers l'interface Objet.

//======================================================================================================================
//                                      Implémentations
//======================================================================================================================
/*
L'exemple qui suit, écrit en Java, met en œuvre une classe graphique qui peut être ou bien une ellipse ou
une composition de différents graphiques. Chaque graphique peut être imprimé.

Il pourrait être étendu en y ajoutant d'autres formes (rectangle etc.) et méthodes (translation etc.).
*/
interface Graphic {
  //Imprime le graphique.
  public void print();
}

//***********************************************
class CompositeGraphic implements Graphic {
  //Collection de graphiques enfants.
  private ArrayList<Graphic> mChildGraphics = new ArrayList<Graphic>();

  //Imprime le graphique.
  public void print() {
    for (Graphic graphic : mChildGraphics) {
      graphic.print();
    }
  }

  //Ajoute le graphique à la composition.
  public void add(Graphic graphic) {
    mChildGraphics.add(graphic);
  }

  //Retire le graphique de la composition.
  public void remove(Graphic graphic) {
    mChildGraphics.remove(graphic);
  }
}

//***********************************************
class Ellipse implements Graphic {
  //Imprime le graphique.
  public void print() {
    System.out.println("Ellipse");
  }
}

class Rectangle implements Graphic {
  //Imprime le graphique.
  public void print() {
    System.out.println("Rectangle");
  }
}

class Carré implements Graphic {
  //Imprime le graphique.
  public void print() {
    System.out.println("Carré");
  }
}

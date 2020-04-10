package i_poo.v_design_patterns.B_Modelos_de_Structuration.II_Bridge;

public class Exemple_1 {
  public static void main(String[] args) {

    Shape[] shapes = new Shape[2];
    shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI1());
    shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI2());

    for (Shape shape : shapes) {
      shape.resizeByPercentage(2.5);
      shape.draw();
    }
    /*
    RESULTADO:
       API1.cercle position 1,000000:2,000000 rayon 7,500000
       API2.cercle position 5,000000:7,000000 rayon 27,500000
    */
  }
}
//==================================================================================================================
//                         Découpler l'interface d'une classe de son implémentation
//==================================================================================================================

/*
Le pont est un patron de conception qui permet de découpler l'interface d'une classe et son implémentation.
Ainsi l'interface et l'implémentation peuvent varier séparément.

Attention, à ne pas confondre ce patron avec l'adaptateur. En effet, l'adaptateur est utilisé pour adapter
l'interface d'une classe vers une autre interface (donc pour faire en sorte que l'interface d'une ou plusieurs
classes ressemble à l'interface d'une classe en particulier).

Le pont est lui utilisé pour découpler l'interface de l'implémentation. Ainsi, vous pouvez modifier ou changer
l'implémentation d'une classe sans devoir modifier le code client (si l'interface ne change pas bien entendu).


//==================================================================================================================
//                                       Exemple : formes géométriques
//==================================================================================================================
Considérons une classe représentant la classe de base de formes géométriques, et ses classes
(cercles, rectangles, triangles, ...). Tous les types de formes ont des propriétés communes (une couleur par exemple)
et des méthodes abstraites communes (calcul de surface par exemple) implémentées par les classes dérivées
(comment calculer la surface d'un cercle, ...).

Toutes les formes peuvent également se dessiner à l'écran. Mais la façon de dessiner dépend de l'environnement
graphique et du système d'exploitation. Plutôt que d'ajouter une méthode par environnement possible à chacune
des formes, le patron de conception Pont suggère de créer une interface séparée pour les primitives de dessin.
Cette interface est utilisée par les différentes formes qui alors ne dépendent pas de l'implémentation.

//==================================================================================================================
//                                       Diagramme de classes UML
//==================================================================================================================

     Le patron de conception Pont peut être représenté par le diagramme de classes UML suivant :

       ---------------------------                       -------------------------
       |     Abstraction         |<>-------------------- |   Implementation      |
       --------------------------                        -------------------------
       | + impl : Implementation |                       |                       |
       | + fonction()            |                       | + faireImplementation |
       ---------------------------                       -------------------------
                 /\                                    ^              /\
                 |                                   /                |
                 |                                /                   |
                 |                             /                      |
                 |                utilise   /                  -----------------
                 |                --------                     |               |
                 |              /                              |               |
         -----------------------               -------------------------        -------------------------
         | AbstractionRaffinéé |               |   Implementation1     |        |   Implementation2     |
         -----------------------               -------------------------        -------------------------
         |                     |               |                       |        |                       |
         | + fonction()        |               | + faireImplementation |        | + faireImplementation |
         ----------------------               --------------------------        -------------------------

                            Diagramme UML de classes du patron de conception Pont


*/
//======================================================================================================================
//                                       "Implémentation"
//======================================================================================================================
interface DrawingAPI {
public void drawCircle(double x, double y, double radius);
}

/**
 * "Implémentation1"
 */
class DrawingAPI1 implements DrawingAPI {
  public void drawCircle(double x, double y, double radius) {
    System.out.printf("API1.cercle position %f:%f rayon %f\n", x, y, radius);
  }
}

/**
 * "Implémentation2"
 */
class DrawingAPI2 implements DrawingAPI {
  public void drawCircle(double x, double y, double radius) {
    System.out.printf("API2.cercle position %f:%f rayon %f\n", x, y, radius);
  }
}

//======================================================================================================================
//                                       "Abstraction"
//======================================================================================================================
interface Shape {
  public void draw();                             // bas niveau
  public void resizeByPercentage(double pct);     // haut niveau
}

//======================================================================================================================
//                                       "AbstractionRaffinée"
//======================================================================================================================
class CircleShape implements Shape {
  private double x, y, radius;
  private DrawingAPI drawingAPI;

  public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.drawingAPI = drawingAPI;
  }

  // bas niveau, càd spécifique à une implémentation
  public void draw() {
    drawingAPI.drawCircle(x, y, radius);
  }

  // haut niveau, càd spécifique à l'abstraction
  public void resizeByPercentage(double pct) {
    radius *= pct;
  }
}

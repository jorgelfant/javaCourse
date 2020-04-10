package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_3;

public class Main {
  public static void main(String[] args) {
    Window decoratedWindow = new HorizontalScrollBarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));

    // afficher la description
    System.out.println(decoratedWindow.getDescription());
    /*
      fenêtre simple, avec une barre verticale de défilement, avec une barre horizontale de défilement
    */
  }
}
//------------------------------------------------------------------------------------------------------------------
//            Attribuer dynamiquement de nouveaux comportements ou responsabilités à un objet
//------------------------------------------------------------------------------------------------------------------
    /*
    Un décorateur est le nom d'un patron de conception de structure.

    Un décorateur permet d'attacher dynamiquement de nouveaux comportements ou responsabilités à un objet.
    Les décorateurs offrent une alternative assez souple à l'héritage pour composer de nouvelles fonctionnalités.
    */
//------------------------------------------------------------------------------------------------------------------
//                                       Objectifs
//------------------------------------------------------------------------------------------------------------------
    /*
    Beaucoup de langages de programmation orientés objets ne permettent pas de créer dynamiquement des classes,
    et la conception ne permet pas de prévoir quelles combinaisons de fonctionnalités sont utilisées pour créer
    autant de classes.

    Exemple : Supposons qu'une classe de fenêtre Window ne gère pas les barres de défilement. On créé une sous-classe
    ScrollingWindow. Maintenant, il faut également ajouter une bordure. Le nombre de classes croît rapidement si on
    utilise l'héritage : on créé les classes WindowWithBorder et ScrollingWindowWithBorder.

    Par contre, les classes décoratrices sont allouées dynamiquement à l'utilisation, permettant toutes sortes de
    combinaisons. Par exemple, les classes d'entrées-sorties de Java permettent différentes combinaisons
    (FileInputStream + ZipInputStream, ...).

    En reprenant l'exemple des fenêtres, on créé les classes ScrollingWindowDecorator et BorderedWindowDecorator
    sous-classes de Window stockant une référence à la fenêtre à « décorer ». Étant donné que ces classes décoratives
    dérivent de Window, une instance de ScrollingWindowDecorator peut agir sur une instance de Window ou une instance
    de BorderedWindowDecorator.
    */

//------------------------------------------------------------------------------------------------------------------
//                             Ce programme illustre l'exemple des fenêtres ci-dessus.
//------------------------------------------------------------------------------------------------------------------
// interface des fenêtres
interface Window {
  public void draw(); // dessine la fenêtre
  public String getDescription(); // retourne une description de la fenêtre
}

//------------------------------------------------------------------------------------------------------------------
//                        implémentation d'une fenêtre simple, sans barre de défilement
//------------------------------------------------------------------------------------------------------------------

// implémentation d'une fenêtre simple, sans barre de défilement
class SimpleWindow implements Window {
  public void draw() {
    // dessiner la fenêtre
  }

  public String getDescription() {
    return "fenêtre simple";
  }
}

//------------------------------------------------------------------------------------------------------------------
// Les classes suivantes contiennent les décorateurs pour toutes les classes de fenêtres, y compris les décorateurs eux-mêmes.
//------------------------------------------------------------------------------------------------------------------
// classe décorative abstraite, implémente Window
abstract class WindowDecorator implements Window {
  protected Window decoratedWindow; // la fenêtre décorée

  public WindowDecorator(Window decoratedWindow) {
    this.decoratedWindow = decoratedWindow;
  }
}

//------------------------------------------------------------------------------------------------------------------
//                              décorateur concret ajoutant une barre verticale de défilement
//------------------------------------------------------------------------------------------------------------------
class VerticalScrollBarDecorator extends WindowDecorator {
  public VerticalScrollBarDecorator(Window decoratedWindow) {
    super(decoratedWindow);
  }

  public void draw() {
    drawVerticalScrollBar();
    decoratedWindow.draw();
  }

  private void drawVerticalScrollBar() {
    // afficher la barre verticale de défilement
  }

  public String getDescription() {
    return decoratedWindow.getDescription() + ", avec une barre verticale de défilement";
  }
}

//------------------------------------------------------------------------------------------------------------------
//                    décorateur concret ajoutant une barre horizontale de défilement
//------------------------------------------------------------------------------------------------------------------
class HorizontalScrollBarDecorator extends WindowDecorator {
  public HorizontalScrollBarDecorator(Window decoratedWindow) {
    super(decoratedWindow);
  }

  public void draw() {
    drawHorizontalScrollBar();
    decoratedWindow.draw();
  }

  private void drawHorizontalScrollBar() {
    // afficher la barre horizontale de défilement
  }

  public String getDescription() {
    return decoratedWindow.getDescription() + ", avec une barre horizontale de défilement";
  }
}

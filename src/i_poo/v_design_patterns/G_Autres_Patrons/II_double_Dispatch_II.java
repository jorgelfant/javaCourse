package i_poo.v_design_patterns.G_Autres_Patrons;

public class II_double_Dispatch_II {
  public static void main(String[] args) {
// Le test :
    java.lang.Object book = new SimpleObject("book");
    java.lang.Object card = new SimpleObject("card");
    Display disp = new SimpleDisplay();
    disp.display(book, card); // -> SimpleDisplay.display(Object, Object)

    /*Resultado
         A simple display for object (a simple book) and object (a simple card)

       L'exemple précédent démontre que le langage Java ne permet pas nativement le multiple-dispatch.
       Dans le cas contraire, la méthode SimpleDisplay.display(SimpleObject, SimpleObject) aurait été appelée
       et l'affichage aurait été le suivant :

         A simple display for simple object (a simple book) and simple object (a simple card)
    */
  }
}
/*
La plupart des langages de programmation orientés objet (C++, Java) se limitent à cela concernant la résolution
dynamique de types (donc à l'exécution plutôt qu'à la compilation). Ils ne permettent pas, par exemple, d'utiliser
le type dynamique pour les arguments et déterminer quelle méthode surchargée appeler. Ces langages implémentent
donc le simple-dispatch (un seul type résolu dynamiquement, celui de l'objet de l'appel à la méthode).

D'autres langages de programmation orientés objet permettent la résolution de type dynamique des arguments et la
méthode surchargée appelée dépend du type réel et non du type de référence passé en argument. Cette fonctionnalité
est appelée multiple-dispatch.
*/
//======================================================================================================================
//                       Exemple en Java où il n'existe que le simple-dispatch :
//======================================================================================================================
// NB: Les classes Object et SimpleObject de l'exemple précédent sont également
//     utilisées ici. Voir l'exemple précédent pour leur code source.

// Une classe Display pour afficher Object et SimpleObject
class Display {
  public void display(java.lang.Object o1, java.lang.Object o2) {
    System.out.println("A display for object (" + o1 + ") and object (" + o2 + ")");
  }

  public void display(java.lang.Object o1, SimpleObject o2) {
    System.out.println("A display for object (" + o1 + ") and simple object (" + o2 + ")");
  }

  public void display(SimpleObject o1, java.lang.Object o2) {
    System.out.println("A display for simple object (" + o1 + ") and object (" + o2 + ")");
  }

  public void display(SimpleObject o1, SimpleObject o2) {
    System.out.println("A display for simple object (" + o1 + ") and simple object (" + o2 + ")");
  }
}

//======================================================================================================================
// Une classe SimpleDisplay pour afficher simplement Object et SimpleObject
//======================================================================================================================
class SimpleDisplay extends Display {
  public void display(java.lang.Object o1, java.lang.Object o2) {
    System.out.println("A simple display for object (" + o1 + ") and object (" + o2 + ")");
  }

  public void display(java.lang.Object o1, SimpleObject o2) {
    System.out.println("A simple display for object (" + o1 + ") and simple object (" + o2 + ")");
  }

  public void display(SimpleObject o1, java.lang.Object o2) {
    System.out.println("A simple display for simple object (" + o1 + ") and object (" + o2 + ")");
  }

  public void display(SimpleObject o1, SimpleObject o2) {
    System.out.println("A simple display for simple object (" + o1 + ") and simple object (" + o2 + ")");
  }
}
/*
L'exemple précédent démontre que le langage Java ne permet pas nativement le multiple-dispatch. Dans le cas contraire,
la méthode SimpleDisplay.display(SimpleObject, SimpleObject) aurait été appelée et l'affichage aurait été le suivant :

             A simple display for simple object (a simple book) and simple object (a simple card)
*/

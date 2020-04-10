package i_poo.v_design_patterns.G_Autres_Patrons;

public class II_Double_Dispatch_III {
  public static void main(String[] args) {
// Le test :
    Objectt book = new SimpleObjectt("book");
    Displayy disp = new SimpleDisplayy();
    book.display(disp); // SimpleObject.display(Display) -> SimpleDisplay.display(SimpleObject)
    /*
       A simple display for simple object (a simple book)
    */
  }
}

//======================================================================================================================
//                                            Double-dispatch
//======================================================================================================================
/*
Le double-dispatch est un patron de conception utilisant le patron Visiteur pour implémenter partiellement
le multiple-dispatch, étendant le simple-dispatch en utilisant le type dynamique de l'un des arguments.

Le principe est d'ajouter une méthode dans les classes des arguments, appelée grâce au polymorphisme
(le simple-dispatch). Cette méthode appelant la méthode originale, avec le pointeur this en argument dont le type
réel est connu à la compilation.

Exemple en Java :
*/
// Une classe Object comportant un attribut : le nom de l'objet
class Objectt {
  protected String name;

  public Objectt(String name) {
    this.name = name;
  }

  public String toString() {
    return "a " + name;
  }

  // méthode ajoutée pour implémentation du double-dispatch:
  public void display(Displayy d) {
    d.display(this);
  } // this de type Object
}

// Une classe SimpleObject précisant que l'objet est simple
class SimpleObjectt extends Objectt {
  public SimpleObjectt(String name) {
    super(name);
  }

  public String toString() {
    return "a simple " + name;
  }

  // méthode ajoutée pour implémentation du double-dispatch:
  public void display(Displayy d) {
    d.display(this);
  } // this de type SimpleObject
}

// Une classe Display pour afficher Object et SimpleObject
class Displayy {
  public void display(Objectt o1) {
    System.out.println("A display for object (" + o1 + ")");
  }

  public void display(SimpleObjectt o1) {
    System.out.println("A display for simple object (" + o1 + ")");
  }
}

// Une classe SimpleDisplay pour afficher simplement Object et SimpleObject
class SimpleDisplayy extends Displayy {
  public void display(Objectt o1) {
    System.out.println("A simple display for object (" + o1 + ")");
  }

  public void display(SimpleObjectt o1) {
    System.out.println("A simple display for simple object (" + o1 + ")");
  }
}

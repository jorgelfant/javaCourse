package i_poo.v_design_patterns.G_Autres_Patrons;

public class II_Double_Dispatch_I {
  public static void main(String[] args) {
    // Le test :
    Object book = new SimpleObject("book");
   // référence de type Object mais objet de type SimpleObject
    System.out.println(book.toString()); // SimpleObject.toString
    /*Resultado
      a simple book
    */
  }
}

//======================================================================================================================
//             Permettre l'appel à une méthode surchargée en recourant au type dynamique d'un argument
//======================================================================================================================
/*
Ce patron de conception est lié à la notion de surcharge de méthode, et au polymorphisme. Il utilise le patron
de conception Visiteur.
*/
//======================================================================================================================
//                                        Introduction : notion de dispatch
//======================================================================================================================
/*
Une classe peut définir une méthode qui peut être redéfinie dans une sous-classe (en C++ il s'agit de méthodes
virtuelles, en Java toutes les méthodes sont virtuelles). La méthode réellement appelée est celle correspondant
au type dynamique de l'objet (résolution à l'exécution, via une table de méthodes (vtable) par exemple), même si
une référence à la classe de base est utilisée.
*/
//======================================================================================================================
//                                                 Exemple en Java
//======================================================================================================================
// Une classe Object comportant un attribut : le nom de l'objet
class Object {
  protected String name;

  public Object(String name) {
    this.name = name;
  }

  public String toString() {
    return "a " + name;
  }
}

// Une classe SimpleObject précisant que l'objet est simple
class SimpleObject extends Object {
  public SimpleObject(String name) {
    super(name);
  }

  public String toString() {
    return "a simple " + name;
  }
}



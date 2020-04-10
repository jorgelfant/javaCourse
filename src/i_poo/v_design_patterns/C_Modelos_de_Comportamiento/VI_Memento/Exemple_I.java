package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VI_Memento;

import java.util.ArrayList;

public class Exemple_I {
  public static void main(String[] args) {
    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();
    originator.set("State1");
    originator.set("State2");
    caretaker.addMemento(originator.saveToMemento());
    originator.set("State3");
    caretaker.addMemento(originator.saveToMemento());
    originator.set("State4");

    originator.restoreFromMemento(caretaker.getMemento(1));
    /*
       Originator : état affecté à : State1
       Originator : état affecté à : State2
       Originator : sauvegardé dans le mémento.
       Originator : état affecté à : State3
       Originator : sauvegardé dans le mémento.
       Originator : état affecté à : State4
       Originator : État après restauration : State3
    */
  }
}
//======================================================================================================================
//                     Memento : Mémoriser l'état actuel d'un objet pour le restaurer ensuite
//======================================================================================================================

/*
Le patron mémento est un patron de conception qui fournit la manière de renvoyer un objet à un état précédent
(retour arrière) sans violer le principe d'encapsulation.

Le mémento est utilisé par deux objets : le créateur et le gardien. Le créateur est un objet ayant un état interne
(état à sauvegarder). Le gardien agira sur le créateur, tout en conservant la possibilité de revenir en arrière.
Le gardien demande alors au créateur l'objet mémento pour enregistrer son état actuel. Il effectue l'opération
(ou séquence d'opérations) souhaitée. Afin de permettre le retour arrière dans l'état d'avant les opérations,
le mémento est retourné au créateur. L'objet mémento même est opaque (le gardien ne peut, ou ne devrait pas, le modifier).
Lors de l'utilisation de ce patron, une attention toute particulière doit être prise si le créateur modifie d'autres
objets ou ressources : Le patron mémento n'opère que sur un seul objet.

Il faut souligner que le fait de sauvegarder l'état interne de l'objet créateur doit s'effectuer sans casser le
principe d'encapsulation. Cela n'est pas toujours possible (exemple : SmallTalk ne le permet pas de façon directe).

Des exemples classiques du patron mémento incluent le générateur de nombres pseudo-aléatoires, la machine à états
finis, la fonction "Annulation" / "Undo".
*/
//======================================================================================================================
//                                         Diagramme de classes
//======================================================================================================================

/*Le patron de conception Mémento peut être représenté par le diagramme de classes UML suivant :

                                    -------------------------------
                                    |          Créateur           |
                                    -------------------------------
                                    | - state                     |
                                    -------------------------------
                                    | + setMemento (Memento)      |
                                    | + createMemento() : Memento |
                                    -------------------------------
                                                  |
                                                  | instancie et utilise
                                                  |
                                                 \/
                                         -------------------               -----------------
                                         |    Memento      |-------------<>|    Gardien    |
                                         -------------------               -----------------
                                         | - state         |
                                         -------------------
                                         | + getState()    |
                                         -------------------

                         Diagramme de classes UML du patron de conception Mémento
*/
//======================================================================================================================
//                                              Exemples
//======================================================================================================================

//Cet exemple illustre l'usage du pattern Mémento pour réaliser une commande de type annuler.

class Originator {
  private String state;

  public void set(String state) {
    System.out.println("Originator : état affecté à : " + state);
    this.state = state;
  }

  public Object saveToMemento() {
    System.out.println("Originator : sauvegardé dans le mémento.");
    return new Memento(state);
  }

  public void restoreFromMemento(Object m) {
    if (m instanceof Memento) {
      Memento memento = (Memento) m;
      state = memento.getSavedState();
      System.out.println("Originator : État après restauration : " + state);
    }
  }
  //CLASS INTERNE
  private static class Memento {
    private String state;

    public Memento(String stateToSave) {
      state = stateToSave;
    }

    public String getSavedState() {
      return state;
    }
  }
}

//======================================================
class Caretaker {
  private ArrayList savedStates = new ArrayList();

  public void addMemento(Object m) {
    savedStates.add(m);
  }

  public Object getMemento(int index) {
    return savedStates.get(index);
  }
}

//Cet exemple utilise la classe String pour l'état (state dans l'exemple), or cette classe est un type immuable en Java.
// Lorsque l'état n'est pas un objet immuable, il devra être cloné avant d'être ajouté dans le memento.

 /*
                    private Memento(State state)
                      {
                      // state doit être cloné avant d'être ajouté au memento,
                      // sinon plusieurs memento retournerons tous une référence sur le même objet
                      this.mementoState = state.clone();
                     }
*/











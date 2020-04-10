package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VI_Memento;

import java.util.ArrayList;
import java.util.List;

public class Exemple_II {
  public static void main(String[] args) {
    Originatorr originator = new Originatorr();
    CareTaker careTaker = new CareTaker();

    originator.setState("State #1");
    originator.setState("State #2");
    careTaker.add(originator.saveStateToMemento());

    originator.setState("State #3");
    careTaker.add(originator.saveStateToMemento());

    originator.setState("State #4");
    System.out.println("Current State: " + originator.getState());

    originator.getStateFromMemento(careTaker.get(0));
    System.out.println("First saved State: " + originator.getState());
    originator.getStateFromMemento(careTaker.get(1));
    System.out.println("Second saved State: " + originator.getState());
    /*
       Current State: State #4
       First saved State: State #2
       Second saved State: State #3
    */
  }
}

/*
Memento pattern is used to restore state of an object to a previous state. Memento pattern falls under
behavioral pattern category.
*/
//======================================================================================================================
//                                           Implementation
//======================================================================================================================
/*
Memento pattern uses three actor classes. Memento contains state of an object to be restored. Originator creates
and stores states in Memento objects and Caretaker object is responsible to restore object state from Memento.
We have created classes Memento, Originator and CareTaker.

MementoPatternDemo, our demo class, will use CareTaker and Originator objects to show restoration of object states.

                              --------------------------------------------------------------------------------------
                              |                                                                                    |
                              | -----------------------------------                                                |
                              | |           Originator            |                                                |
                              | -----------------------------------                                                |
                              | |  - state : String               | ------------------------                       |
                              | -----------------------------------                        |                       |
                              | | + setState() : void             |                        |                       |
                              | | + getState() : String           |                        |                       |
                              | | + saveStateToMemento(): Memento |                       \/                       |
-------------------           | | + getStateFromMemento() : void  |            -------------------------           |
|    Main         |           | -----------------------------------            |      Memento          |           |
-------------------   uses    |                                                -------------------------           |
|                 |---------> |                                                | - state : String      |           |
-------------------           |                                                -------------------------           |
| + main() : void |           |                                                | + Memento()           |           |
-------------------           |                                                | + getState() ; String |           |
                              |                                                -------------------------           |
                              |                                                            /\                      |
                              |                                                            |                       |
                              |                                                            |                       |
                              |                                                            |                       |
                              |                                             --------------------------------       |                                                                             |
                              |                                             |           CareTaker          |       |                                                                             |
                              |                                             --------------------------------       |                                                                             |
                              |                                             | - menuToList : List<Memento> |       |
                              |                                             --------------------------------       |
                              |                                             | + add() : void               |       |
                              |                                             | + get() : Memento            |       |
                              |                                             --------------------------------       |
                              |                                                                                    |
                              --------------------------------------------------------------------------------------
*/
//======================================================================================================================
//                                           1) Create Memento class.
//======================================================================================================================
class Memento {
  private String state;

  public Memento(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }
}

//======================================================================================================================
//                                           2) Create Originator class
//======================================================================================================================
class Originatorr {
  private String state;

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return state;
  }

  public Memento saveStateToMemento() {
    return new Memento(state);
  }

  public void getStateFromMemento(Memento memento) {
    state = memento.getState();
  }
}

//======================================================================================================================
//                                           3) Create CareTaker class
//======================================================================================================================
class CareTaker {
  private List<Memento> mementoList = new ArrayList<Memento>();

  public void add(Memento state) {
    mementoList.add(state);
  }

  public Memento get(int index) {
    return mementoList.get(index);
  }
}

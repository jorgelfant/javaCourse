package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VII_Observateur;

import java.util.ArrayList;
import java.util.List;

public class Exemple_II {
  public static void main(String[] args) {
//======================================================================================================================
//                        4) Use Subject and concrete observer objects.
//======================================================================================================================
    Subject subject = new Subject();

    new HexaObserver(subject);
    new OctalObserver(subject);
    new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);
    System.out.println("Second state change: 10");
    subject.setState(10);
    /*Result:
      First state change: 15
      Hex String: F
      Octal String: 17
      Binary String: 1111
      Second state change: 10
      Hex String: A
      Octal String: 12
      Binary String: 1010
    */
  }
}

/*
Observer pattern is used when there is one-to-many relationship between objects such as if one object is modified,
its depenedent objects are to be notified automatically. Observer pattern falls under behavioral pattern category.
*/
//======================================================================================================================
//                                        Implementation
//======================================================================================================================
/*
Observer pattern uses three actor classes. Subject, Observer and Client. Subject is an object having methods
to attach and detach observers to a client object. We have created an abstract class Observer and a concrete
class Subject that is extending class Observer.

ObserverPatternDemo, our demo class, will use Subject and concrete class object to show observer pattern in action.

                                     ---------------------------
                                     |         Observer        |
                                     ---------------------------
                                     | + subject : Subject     |
                                     ---------------------------
                                     |                         |
                                     | + update() : void       |
                                     ---------------------------
                                                  |
                                                  | asks
                                                  |
                                                 \/
   --------------------------------------------------------------------------------------------------------------------
   |                                         <<Abstract>>                                                             |
   |                                  ---------------------------                 ----------------------------------  |
   |                                  |         Observer        |        USES     |             Subject            |  |
   |                                  --------------------------- <-------------- ----------------------------------  |
   |                                  | + subject : Subject     |                 | - observers : List<Observer>   |  |
   |                                  ---------------------------                 | - state : int                  |  |
   |                                  |                         |                 ----------------------------------  |
   |                                  | + update() : void       |                 | + getState() : int             |  |
   |                                  ---------------------------                 | + setState() : void            |  |
   |                                              /\                              | + attach() : void              |  |
   |                                              |                               | + notifyAllObservers() : void  |  |
   |                                              |                               ----------------------------------  |
   |                                              | extends                                                           |
   |             --------------------------------------------------------------                                       |
   |             |                                |                            |                                      |
   |             |                                |                            |                                      |
   |             |                                |                            |                                      |
   |             |                                |                            |                                      |                             |
   |  ---------------------------     --------------------------     --------------------------                       |                                                          |
   |  |      BinaryObserver     |     |      OctalObserver     |     |     HexaObserver       |                       |                                                          |
   |  ---------------------------     --------------------------     --------------------------                       |                                                          |
   |  | + subject : Subject     |     | + subject : Subject    |     | + subject : Subject    |                       |
   |  ---------------------------     --------------------------     --------------------------                       |
   |  |                         |     |                        |     |                        |                       |
   |  | + update() : void       |     | + update() : void      |     | + update() : void      |                       |
   |  ---------------------------     --------------------------     --------------------------                       |
   |                                                                                                                  |
   --------------------------------------------------------------------------------------------------------------------
*/
//======================================================================================================================
//                                   1) Create Subject class.
//======================================================================================================================
class Subject {

  private List<Observerr> observers = new ArrayList<Observerr>();
  private int state;

  public int getState() {
    return state;
  }
  //PA CAMBIAR DE ESTADO
  public void setState(int state) {
    this.state = state;
    notifyAllObservers();//VA IR AL METODO QUE ACTUALIZARA CADA OBJETO OBERSVER
  }

  public void attach(Observerr observer) {
    observers.add(observer);
  }

  public void notifyAllObservers() {
    for (Observerr observer : observers) {
      observer.update();
    }
  }
}

//======================================================================================================================
//                                   2) Create Observer class
//======================================================================================================================

abstract class Observerr {
  protected Subject subject;

  public abstract void update();
}

//======================================================================================================================
//                             3) Create concrete observer classes
//======================================================================================================================

class BinaryObserver extends Observerr {

  public BinaryObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
  }
}

//=================================================================

class OctalObserver extends Observerr {

  public OctalObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
  }
}

//=================================================================

class HexaObserver extends Observerr {

  public HexaObserver(Subject subject) {
    this.subject = subject;
    this.subject.attach(this);
  }

  @Override
  public void update() {
    System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
  }
}

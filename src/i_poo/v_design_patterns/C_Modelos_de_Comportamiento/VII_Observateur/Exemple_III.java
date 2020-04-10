package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VII_Observateur;

import java.util.LinkedList;
import java.util.List;

public class Exemple_III {
  public static void main(String[] args) {

    Subjectt subject = new Subjectt("Hello World");

    new CapsObserver(subject);
    new LengthObserver(subject);
    new WordsObserver(subject);

    subject.notifyObservers();

    subject.setState("Testing the Observer Design Pattern");
    subject.setState("");
    /*
       Current State: Hello World

       Upper Case Chars: 2
       Lower Case Chars: 8
       Length: 11
       Words: 2

       Current State: Testing the Observer Design Pattern

       Upper Case Chars: 4
       Lower Case Chars: 27
       Length: 35
       Words: 5

       Current State:

       Upper Case Chars: 0
       Lower Case Chars: 0
       Length: 0
       Words: 0
    */
  }
}

//======================================================================================================================
//                                        SUBJECT (OBSERVABLE)
//======================================================================================================================
class Subjectt {

  List<Observerrr> observers;
  private String state;

  public Subjectt(String state) {
    observers = new LinkedList();
    setState(state);
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
    System.out.println("\nCurrent State: " + state + "\n");
    notifyObservers();
  }

  public void removeObserver(Observerrr observer) {
    observers.remove(observer);
  }

  public void registerObserver(Observerrr... observers) {
    for (Observerrr o : observers)
      this.observers.add(o);
  }

  public void notifyObservers() {
    for (Observerrr o : observers)
      o.update();
  }

}

//======================================================================================================================
//                                     Abstract OBSERVER
//======================================================================================================================
abstract class Observerrr {

  protected Subjectt subject;
  public abstract void update();

}

//======================================================================================================================
//                                           1) WordsObserver
//======================================================================================================================
class WordsObserver extends Observerrr {

  public WordsObserver(Subjectt subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
  }

  @Override
  public void update() {
    System.out.println("Words: " + countWords());

  }

  private int countWords() {
    String str = subject.getState();
    int count = 1;

    if (str.isEmpty())
      return 0;

    for (int i = 0; i <= str.length() - 1; i++) {
      if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ')
        count++;
    }
    return count;
  }
}

//======================================================================================================================
//                                              2) CapsObserver
//======================================================================================================================
class CapsObserver extends Observerrr {

  public CapsObserver(Subjectt subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
  }

  @Override
  public void update() {
    System.out.println("Upper Case Chars: " + countUpperCase());
    System.out.println("Lower Case Chars: " + countLowerCase());
  }

  private int countLowerCase() {
    String str = subject.getState();
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (Character.isLowerCase(str.charAt(i)))
        count++;
    }
    return count;
  }

  private int countUpperCase() {
    String str = subject.getState();
    int count = 0;

    for (int i = 0; i < str.length(); i++) {
      if (Character.isUpperCase(str.charAt(i)))
        count++;
    }
    return count;

  }
}

//======================================================================================================================
//                                         3) LengthObserver
//======================================================================================================================
class LengthObserver extends Observerrr {

  public LengthObserver(Subjectt subject) {
    this.subject = subject;
    this.subject.registerObserver(this);
  }

  @Override
  public void update() {
    System.out.println("Length: " + subject.getState().length());
  }
}

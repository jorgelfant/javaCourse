package i_poo.v_design_patterns.B_Modelos_de_Structuration.V_Composite;

import java.util.ArrayList;
import java.util.List;

public class Exemple_3 {
  public static void main(String[] args) {
    Person p1 = new Person("George V", "King", 70);

    Person p2 = new Person("George VI", "King", 56);
    Person p3 = new Person("Henry", "Prince / Duke of Gloucester", 74);
    Person p4 = new Person("George", "Prince / Duke of Kent", 39);

    p1.add(p2, p3, p4);

    Person p5 = new Person("Elizabeth II", "Queen", 89);
    p2.add(p5);

    Person p6 = new Person("Richard", "Prince / Duke of Gloucester", 71);
    p3.add(p6);

    Person p7 = new Person("Edward", "Prince / Duke of Kent", 80);
    Person p8 = new Person("Alexandra", "Princess", 79);
    Person p9 = new Person("Michael", "Prince", 73);

    p4.add(p7, p8, p9);

    //Print the family three    esto funcionaria mejor con recursivdad en caso de que los hijos de los hijos quieren continuar el arbol
    System.out.println(p1);

    for (Person child : p1.getChildren()) {
      System.out.println(child);

      for (Person child1 : child.getChildren()) {
        System.out.println(child1);
      }
    }
    /*RESULTADO
       Person [name=George V, title=King, age=70]
       Person [name=George VI, title=King, age=56]
       Person [name=Elizabeth II, title=Queen, age=89]
       Person [name=Henry, title=Prince / Duke of Gloucester, age=74]
       Person [name=Richard, title=Prince / Duke of Gloucester, age=71]
       Person [name=George, title=Prince / Duke of Kent, age=39]
       Person [name=Edward, title=Prince / Duke of Kent, age=80]
       Person [name=Alexandra, title=Princess, age=79]
       Person [name=Michael, title=Prince, age=73]
    */
  }
}
//======================================================================================================================
//
//======================================================================================================================

class Person {

  private String name;
  private String title;
  private int age;

  private List<Person> children;

  public Person(String name, String title, int age) {
    this.name = name;
    this.title = title;
    this.age = age;

    children = new ArrayList();
  }

  public Person(String name, int age) {
    this(name, "", age);
  }

  public void add(Person... persons) {
    for (Person p : persons) //o sinon children.addAll(Arrays.asList(persons));
      children.add(p);
  }

  public void remove(Person p) {
    children.remove(p);
  }

  public List<Person> getChildren() {
    return children;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", title=" + title + ", age=" + age + "]";
  }

}

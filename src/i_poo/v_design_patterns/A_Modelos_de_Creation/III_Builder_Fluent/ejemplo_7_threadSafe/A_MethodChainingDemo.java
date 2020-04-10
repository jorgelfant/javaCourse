package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_7_threadSafe;

public class A_MethodChainingDemo {
  public static void main(String[] args) {/*
  Method Chaining:

  In java, Method Chaining is used to invoke multiple methods on the same object which occurs as a
  single statement. Method-chaining is implemented by a series of methods that return the this reference for a class
  instance.

  Implementation:

  As return values of methods in a chain is this reference, this implementation allows us to invoke
  methods in chain by having the next method invocation on the return value of the previous method in the chain.      */
    Student student1 = new Student();
    Student student2 = new Student();

    student1.setId(1).setName("Ram").setAddress("Noida");
    student2.setId(2).setName("Shyam").setAddress("Delhi");

    System.out.println(student1);
    System.out.println(student2);
    /*
      id = 1, name = Ram, address = Noida
      id = 2, name = Shyam, address = Delhi
    */
  }
}
//**********************************************************************************************************************
//                         Java code to demonstrate method chaining
//**********************************************************************************************************************

final class Student {

  // instance fields
  private int id;
  private String name;
  private String address;

  // Setter Methods
  // Note that all setters method
  // return this reference
  public Student setId(int id) {
    this.id = id;
    return this;
  }

  public Student setName(String name) {
    this.name = name;
    return this;
  }

  public Student setAddress(String address) {
    this.address = address;
    return this;
  }

  @Override
  public String toString() {
    return "id = " + this.id + ", name = " + this.name +
      ", address = " + this.address;
  }
}
/*
Need of Builder Pattern : Method chaining is a useful design pattern but however if accessed concurrently, a thread
may observe some fields to contain inconsistent values. Although all setter methods in above example are atomic, but
calls in the method chaining can lead to inconsistent object state when the object is modified concurrently. The below
example can lead us to a Student instance in an inconsistent state, for example, a student with name Ram and address Delhi.
*/

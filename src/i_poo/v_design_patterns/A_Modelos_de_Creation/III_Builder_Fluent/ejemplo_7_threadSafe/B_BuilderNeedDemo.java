package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_7_threadSafe;

public class B_BuilderNeedDemo {
  public static void main(String[] args) {
    /*Need of Builder Pattern : Method chaining is a useful design pattern but however if accessed concurrently,
      a thread may observe some fields to contain inconsistent values. Although all setter methods in above example
      are atomic, but calls in the method chaining can lead to inconsistent object state when the object is modified
      concurrently. The below example can lead us to a Student instance in an inconsistent state, for example, a student
      with name Ram and address Delhi.
    */
    StudentReceiver sr = new StudentReceiver();
    System.out.println(sr.getStudent2());
    /*
     id = 2, name = Shyam, address = Noida
     Another inconsistent output may be

     id = 0, name = null, address = null
    */

  }
}

// Java code to demonstrate need of Builder Pattern

// Server Side Code
final class Student2 {

  // instance fields
  private int id;
  private String name;
  private String address;

  // Setter Methods
  // Note that all setters method
  // return this reference
  public Student2 setId(int id) {
    this.id = id;
    return this;
  }

  public Student2 setName(String name) {
    this.name = name;
    return this;
  }

  public Student2 setAddress(String address) {
    this.address = address;
    return this;
  }

  @Override
  public String toString() {
    return "id = " + this.id + ", name = " + this.name +
      ", address = " + this.address;
  }
}

//**********************************************************************************************************************
//                                         Client Side Code
//**********************************************************************************************************************
class StudentReceiver {

  private final Student2 student2 = new Student2();//o poner esto en el metodo

  public StudentReceiver() {//al crear uno objeto StudentReceiver el contenido se ejecuta, y se llenan los campos

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        student2.setId(1).setName("Ram").setAddress("Noida");
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        student2.setId(2).setName("Shyam").setAddress("Delhi");
      }
    });

    t1.start();
    t2.start();
  }
  /*alternativa
   public StudentReceiver hola() {
    student2.setId(1).setName("Ram").setAddress("Noida");
    return this;
  }
  */
  public Student2 getStudent2() {
    return student2;//return new Student2()
  }
}

/*Note : Try running main method statements in loop(i.e. multiple requests to server simultaneously).

To solve this problem, there is Builder pattern to ensure the thread-safety and atomicity of object creation.

Implementation : In Builder pattern, we have a inner static class named Builder inside our Server class with instance
fields for that class and also have a factory method to return an new instance of Builder class on every invocation.
The setter methods will now return Builder class reference. We will also have a build method to return instances of
Server side class, i.e. outer class.                                                                                  */

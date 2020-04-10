package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_7_threadSafe;

public class C_BuilderDemo {
  public static void main(String[] args) {
    /*
    To solve this problem, there is Builder pattern to ensure the thread-safety and atomicity of object creation.

    Implementation : In Builder pattern, we have a inner static class named Builder inside our Server class with instance
    fields for that class and also have a factory method to return an new instance of Builder class on every invocation.
    The setter methods will now return Builder class reference. We will also have a build method to return instances of
    Server side class, i.e. outer class.
    */
    StudentReceiver2 sr = new StudentReceiver2();
    System.out.println(sr.getStudent3());


    /*
    Output is guaranteed to be one of below:    ESTO LO QUE ASEGURA  ES QUE LLENANDO LOS parametros con threads, ocurrencias
                                                se escojera el primer valor o el segundo y no NULL
    id = 1, name = Ram, address = Noida
    OR
    id = 2, name = Shyam, address = Delhi

    The Builder.newInstance() factory method can also be called with any required arguments to obtain a Builder instance
    by overloading it. The object of Student class is constructed with the invocation of the build() method.

    The above implementation of Builder pattern makes the Student class immutable and consequently thread-safe.

    Also note that the student field in client side code cannot be declared final because it is assigned a new immutable
    object. But it be declared volatile to ensure visibility of shared reference to immutable objects. Also private members
    of Builder class maintain encapsulation.

    Please have a look at append method of StringBuilder class in java.lang package to understand implementations of
    Builder pattern more.

                                                                                                                     */
  }
}

//**********************************************************************************************************************
//                                  Java code to demonstrate Builder Pattern
//**********************************************************************************************************************
// Server Side Code
final class Student3 {

  // final instance fields
  private final int id;
  private final String name;
  private final String address;

  public Student3(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.address = builder.address;
  }


  // Static class Builder
  public static class Builder {

    /// instance fields
    private int id;
    private String name;
    private String address;

    public static Builder newInstance() {
      return new Builder();
    }

    private Builder() {
    }

    // Setter methods*********************************
    public Builder setId(int id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setAddress(String address) {
      this.address = address;
      return this;
    }

    // build method to deal with outer class
    // to return outer instance
    public Student3 build() {
      return new Student3(this);
    }
  }

  @Override
  public String toString() {
    return "id = " + this.id + ", name = " + this.name + ", address = " + this.address;
  }
}

//**********************************************************************************************************************
// Client Side Code
//**********************************************************************************************************************
class StudentReceiver2 {
  // volatile student instance to ensure visibility
  // of shared reference to immutable objects
  private Student3 student;

  public StudentReceiver2() {

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        student= Student3.Builder.newInstance().setId(1).setName("Ram").setAddress("Noida").build();
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        student= Student3.Builder.newInstance().setId(2).setName("Shyam").setAddress("Delhi").build();
      }
    });

    t1.start();
    t2.start();
  }

  public Student3 getStudent3() {
    return  student;
  }

}
/*
The Builder.newInstance() factory method can also be called with any required arguments to obtain a Builder instance
by overloading it. The object of Student class is constructed with the invocation of the build() method.
The above implementation of Builder pattern makes the Student class immutable and consequently thread-safe.

Also note that the student field in client side code cannot be declared final because it is assigned a new immutable object.
But it be declared volatile to ensure visibility of shared reference to immutable objects. Also private members of
Builder class maintain encapsulation.

Please have a look at append method of StringBuilder class in java.lang package to understand implementations of Builder
pattern more.
*/

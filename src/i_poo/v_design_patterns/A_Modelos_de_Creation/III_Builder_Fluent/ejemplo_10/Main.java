package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_10;

public class Main {
  public static void main(String[] args) {
    /*
    While Considering the builder pattern you need to look weather the object is having

    Complex constructor.
    -------------------
    Multiple constructor having combinations of multiple parameter with nested objects

    Large number of parameters.
    --------------------------
    having large number of field parameter is also the key point to consider.

    Immutability.
    ------------
    You can force the immutability to the object once you are done with creation of object.

    Builder pattern is a creational design pattern it means its solves problem related to object creation.
    Best example would be an AlertDialog class from AOSP, StringBuilder, DocumentBuilder best to see how the
    compex object can be created.

    It typically solve problem in object oriented programming i.e determining what constructor to use.
    Often we write many constructor and it is really hard to manage them. The multiple constructor with combination
    of multiple parameters variation is called the telescoping constructor.

    Builder pattern is used to create instance of very complex object having telescoping constructor in easiest way.

    Constructors in Java are used to create object and can take parameters required to create object. Lets see an
    example and learn how to implement builder pattern. Consider a pojo of Person below.
    */


    Person person = new Person.Builder().setAge(5).setFirstName("Bob").setHeight(6).setAge(19).build();
    //System.out.println(person);
  }
}
/*VAMOS A CONVERTIR ESTO EN BUILDER
class Person {
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;

  public Person(String firstName, String middleName, String lastName, int age) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
  }

  public Person(String firstName, String lastName, int age) {
    this(firstName, null, lastName, age);
  }

  public Person(String firstName, int age) {
    this(firstName, null, age);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
*/
/*
Things are simple if there are only 4 fields but, lets say if you want to add more fields to the pojo then it becomes
hectic to maintain complex pojo plus the order of the minimum fields to required to create the object. Also it can
leads to bugs in code base.
*/

//**********************************************************************************************************************
//                             Convert to Builder Pattern
//**********************************************************************************************************************
/*
Let’s now add some extra fields fathersName, mothersName, height, weight to the pojo and convert it to the Builder pattern.
Create static anonymous inner class named Builder to the pojo, why static because we want to return/use current object.
Add same fields to it from pojo. Also add the empty constructor and setter of each filed with return type of Builder class.
And last but not least add method build which will return the new Person object instance.
*/
class Person {
  private String firstName;
  private String middleName;
  private String lastName;
  private int age;
  private String fathersName;
  private String mothersName;
  private double height;
  private double weight;

  //o en lugar de tener tantos parametros ponemos el builder como argumento para copiar los valores de sus parametros
  // public Person(Builder builder)
  public Person(String firstName, String middleName, String lastName, int age, String fathersName, String mothersName, double height, double weight) {
    this.firstName = firstName;//builder.firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    this.fathersName = fathersName;
    this.mothersName = mothersName;
    this.height = height;
    this.weight = weight;
  }

  public static class Builder {
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String fathersName;
    private String mothersName;
    private double height;
    private double weight;

    public Builder() {
    }

    public Builder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder setMiddleName(String middleName) {
      this.middleName = middleName;
      return this;
    }

    public Builder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setFathersName(String fathersName) {
      this.fathersName = fathersName;
      return this;
    }

    public Builder setMothersName(String mothersName) {
      this.lastName = mothersName;
      return this;
    }

    public Builder setHeight(double height) {
      this.height = height;
      return this;
    }

    public Builder setWeight(double weight) {
      this.weight = weight;
      return this;
    }

    public Person build() {
      return new Person(firstName, middleName, lastName, age, fathersName, mothersName, height, weight);
    }
  }
}
/*
Pros
----
1) Code is more maintainable if number of fields required to create object is more than 4 or 5.

2) Object Creation code less error-prone as user will know what they are passing because of explicit method call.

3) Builder pattern increase robustness, as only fully constructed object will be available to client.

4) You can force immutability to the object once its created.


Cons
----
1) Builder pattern is verbose and requires code duplication as Builder needs to copy all fields from Original or Item class.
*/

package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.V_classes_immutables_final;

public class Exemplo_2 {
  public static void main(String[] args) {
    Age age = new Age();
    age.setDay(1);
    age.setMonth(1);
    age.setYear(1992);

    ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
    System.out.println("Alex age year before modification = " + student.getAge().getYear());

    age.setYear(1993);
    System.out.println("Alex age year after modification = " + student.getAge().getYear());
    /*
      After running the above test, we get the following output:

      Alex age year before modification = 1992
      Alex age year after modification = 1993
    */
  }
}

/*
An object is immutable if its state cannot change after construction. Immutable objects don’t expose any way
for other objects to modify their state; the object’s fields are initialized only once inside the constructor
and never change again.

In this article, we'll define the typical steps for creating an immutable class in Java and also shed light on the
common mistakes which are made by developers while creating immutable classes.

//==================================================================================================================
//                                1. Usage of Immutable Classes
//==================================================================================================================

Nowadays, the “must-have” specification for every software application is to be distributed and
multi-threaded—multi-threaded applications always cause headaches for developers since developers are required
to protect the state of their objects from concurrent modifications of several threads at the same time, for this
purpose, developers normally use the Synchronized blocks whenever they modify the state of an object.

With immutable classes, states are never modified; every modification of a state results in a new instance,
hence each thread would use a different instance and developers wouldn’t worry about concurrent modifications.

//==================================================================================================================
//                                2. Some Popular Immutable Classes
//==================================================================================================================

String is the most popular immutable class in Java. Once initialized its value cannot be modified.
Operations like trim(), substring(), replace() always return a new instance and don’t affect the current instance,
that’s why we usually call trim() as the following:

       String alex = "Alex";
       alex = alex.trim();

Another example from JDK is the wrapper classes like: Integer, Float, Boolean … these classes don’t modify their
state, however they create a new instance each time you try to modify them.

       Integer a =3;
       a += 3;

After calling a += 3, a new instance is created holding the value: 6 and the first instance is lost.

//==================================================================================================================
//                                3. How Do We Create an Immutable Class
//==================================================================================================================

In order to create an immutable class, you should follow the below steps:

1. Make your class final, so that no other classes can extend it.

2. Make all your fields final, so that they’re initialized only once inside the constructor and never modified afterward.

3. Don’t expose setter methods.

4. When exposing methods which modify the state of the class, you must always return a new instance of the class.

5. If the class holds a mutable object:

   . Inside the constructor, make sure to use a clone copy of the passed argument and never set your mutable field
     to the real instance passed through constructor, this is to prevent the clients who pass the object from
     modifying it afterwards.

   .  Make sure to always return a clone copy of the field and never return the real object instance.

//==================================================================================================================
//                                3.1. Simple Immutable Class
//==================================================================================================================

Let’s follow the above steps and create our own immutable class (ImmutableStudent.java).
*/
final class ImmutableStudent {
  private final int id;
  private final String name;
  private final Age age;//al ponerle final al objeto debemos inicialiarlo en el constructor, porque?

  //porque con final le decimos que que no cambie sin embargo Age es un objeto mutable
  //desde el main con sus metodos podriamos modificar sus atributos
  public ImmutableStudent(int id, String name, Age age) {
    this.name = name;
    this.id = id;
    //this.age = age; //si la Age implementara la interface clonable y el metodo clone desarrolado podriamos  =age.clone() poner directo la copia
    //pero como no es asi crearemos un nuevo objeto el cual sera enviado para evitar que modifiquemos el original
    Age cloneAge = new Age();//creamos un nuevo objeto lleno con los mismos parametros que el original
    cloneAge.setDay(age.getDay());//llenamos
    cloneAge.setMonth(age.getMonth());//llenamos
    cloneAge.setYear(age.getYear());//llenamos
    this.age = cloneAge;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  /*
  public Age getAge() {
    return age;
  }
  */

  public Age getAge() {//enviamos una copia el age que estamos usando en la clase, un nuevo age con los mismos valores
    Age cloneAge = new Age();
    cloneAge.setDay(this.age.getDay());
    cloneAge.setMonth(this.age.getMonth());
    cloneAge.setYear(this.age.getYear());
    return cloneAge;
  }
}

/*
The above class is a very simple immutable class which doesn’t hold any mutable object and never expose its fields
in any way; these type of classes are normally used for caching purposes.
*/
//==================================================================================================================
//                                3.2. Passing Mutable Objects to Immutable Class
//==================================================================================================================
/*
Now, let’s complicate our example a bit, we create a mutable class called Age and add it as a field to ImmutableStudent:
*/
class Age {
  private int day;
  private int month;
  private int year;

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
/*
So, we added a new mutable field of type Age to our immutable class and assign it as normal inside the constructor.
Let’s create a simple test class and verify that ImmutableStudent is no more immutable:

                              VAMOS AL MAIN..

We claim that ImmutableStudent is an immutable class whose state is never modified after construction, however
in the above example we are able to modify the age of Alex even after constructing Alex object. If we go back to
the implementation of ImmutableStudent constructor, we find that age field is being assigned to the instance of the
Age argument, so whenever the referenced Age is modified outside the class, the change is reflected directly on the
state of Alex.

Check out my Pass by value OR pass by reference article to more deeply understand this concept

In order to fix this and make our class again immutable, we follow step #5 from the steps that we mention above
for creating an immutable class. So we modify the constructor in order to clone the passed argument of Age and
use a clone instance of it.

Now, if we run our test, we get the following output:

Alex age year before modification = 1992
Alex age year after modification = 1992

Asi al querer modificar en el main algun atributo del objeto atributo, esto modificara la copia y no el original
dentro de la clase los 2 tienen obvio los mismos valores

esto es una alternativa a lo que vimos en los ejemplos con clone() en el cual hacemos el proceso de clonacion dentro
de la clase al implementar el metodo clone() de la interface clonable , el metodo clone() viene de Object

As you see now, the age of Alex is never affected after construction and our class is back to immutable.

//==================================================================================================================
//                                3.2. Passing Mutable Objects to Immutable Class
//==================================================================================================================

However, our class still has a leak and is not fully immutable, let’s take the following test scenario:


               Age age = new Age();
               age.setDay(1);
               age.setMonth(1);
               age.setYear(1992);
               ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
               System.out.println("Alex age year before modification = " + student.getAge().getYear());
               student.getAge().setYear(1993);
               System.out.println("Alex age year after modification = " + student.getAge().getYear());

               Output:

                Alex age year before modification = 1992
                Alex age year after modification = 1993


        ya que al llamar al metodo getAge() con Student, estamos llamando al age original de Student y luego con su metodo
        setYear() lo estariamos modificando

        Es decir que con la primera modificacion que inicmos en el constructor para volver immutable a age
        ya no podremos cambiar desde el main los atributos de este objeto tratandolo directamente en el main
        ya que al utilizar un constructor age de Student es lenado con una copia, lo que tenemos es una copia
        con los mismos valores que el original.

        Al modificar el original en el main que pusimos como parametro esto no tendra incidencia en el age que pusimos
        como argumento en nuestro constructor ya que este tiene una copia y no el original

        sin embargo al llamar al metodo getAge() con Student, estamos obteniendo el objeto age nuevo (osea la copia)
        que tenia los valores del original, y al querer modificarlo estariamos modificando el nuevo objeto de age
        que ta dentro de Student

        Again according to step #4, when returning mutable fields from immutable object, you should return a clone
        instance of them and not the real instance of the field.

        So we modify getAge() in order to return a clone of the object’s age:

        VER LA CLASE...

        Now the class becomes fully immutable and provides no way or method for other objects to modify its state.

        Alex age year before modification = 1992
        Alex age year after modification = 1992

//==================================================================================================================
//                                           4. Conclusion
//==================================================================================================================
Immutable classes provide a lot of advantages especially when used correctly in a multi-threaded environment.
The only disadvantage is that they consume more memory than the traditional class since upon each modification
of them a new object is created in the memory... but, a developer should not overestimate the memory consumption
as its negligible compared to the advantages provided by these type of classes.

Finally, an object is immutable if it can present only one state to the other objects, no matter how and when they
call its methods. If so it’s thread safe by any definition of thread-safe.

*/



package i_poo.l_interface.u_java_8_ou_la_revolution_des_interfaces;

public class Alien implements Pondre, Mitose {
    public void reproduire() {//reescribo el metodo de las 2 interface que tienen ambas el mismo nombre
        System.out.println("Je suis un alien et : ");
        Pondre.super.reproduire();
        Mitose.super.reproduire();
    }
}
/*
Si la Interface abuela reproduction tuviera un metodo abstract, Pondre y Mitoso no la implementan porque son interfaces
es la clase que hereda de esta interfaces hijas que debla inizializarla

In java8, we are using interface.super.

Considering the below points:

1. There are 2 interfaces but none of the interfaces inherit to another.
2. There is implementation class which is inheriting both of those 2 interfaces.
3. Each interface has a default method but the name is same for both of those methods.

Now in this scenario, in the implementation class it is forcing me to override the default reproduire() method.

If you inherit from two interfaces Pondre and Mitose, then Pondre.super.reproduire() calls the foo (default) method
of the Pondre interface.

------------------------------------------------------------------------------------------------------------------------
When you implement TWO INTERFACES which each have DEFAULT METHODS with the SAME NAME, it's AMBIGOUS.
------------------------------------------------------------------------------------------------------------------------

You need to resolve that AMBIGUITY by explicitly stating WHICH of the two DEFAULT METHODS you'd like
your implementation to use. You do this by OVERRIDING the method in question and calling the "parent"
interface's implementation directly. You do this with the NEW SYNTAX: ParentInterfaceName.super.methodName();

One more thing : there is no ambiguity when overriding method as accepted answer is saying, you have to use
Pondre.super or Mitose.super only if you want to REUSE default implementation , then you tell which reproduction() you want
to use as they are two. You can omit calling any of default methods and write completely new implementation
or even make that method (and class) abstract.

Java 8 , allows interfaces to have default implementation, this functionality had been given as a privilege for
those who were using abstract class and want to replace them with CODE TO INTERFACE,

The least concrete class is forced to have its own implementation in case of any ambiguity. If there is no ambiguity
then it simply uses its parents behaviour and does not forces to implement.

By using the same method name here we have created ambiguity.

------------------------------------------------------------------------------------------------------------------------
     SI NO DESEAMOS REESCRIBIR EL METODO AMBIGUO (con el mismo nombre) EN LA CLASE QUE HERITA ESTA 2 INTERFACES
     PODRIAMOS HACER LO SIGUIENTE

      If we implement hierarchical dependency.it will work.
     Asi ya no estariamos obligados a reescribir el metodo en Alien para salir de la ambiguedad

     interface Pondre{
        default void reproduire() {
            System.out.println("Je me divise !");
        }
     }
                 ^
                 |
                 |
     interface Mitose extends Pondre {
          default void reproduire() {
             System.out.println("Je pond des oeufs !");
          }
     }

     La ambiguedad desaparece en el sentido que la clase Alien que hereda esta 2 interfaces, ve que una intenface tiene
     1 metodo static , un metodo default y que el 2 metodo static, un metodo default  + el metodo heredado del 1er metodo

     Asi Alien va a ver que la primera interface tiene 2 metodos mientras la 2da interface tiene 2 +1 =3 metodos
     LA AMBIGUEDAD DESAPARECE aunque el defaut de ambos metodos tenga el mismo nombre xq ya una interface tiene 2 metodos
     y el otro 3

public class Alien implements Pondre, Mitose {
    public static void main2(String[] args) {

        Alien multipleInterfaces = new Alien();
        Pondre one = new Alien();  //padre=hijo
        Mitose two = new Alien();  //padre=hijo
        multipleInterfaces.print();
        one.print();
        two.print();

    }
}

To invoke an interface’s default method, you need to use the name of that interface as well. A class (or an interface)
can invoke a default method of an interface that is explicitly mentioned in the class’s implements clause
(or the interface’s extends clause) by using the same syntax i.e.

                                     <InterfaceName>.super.<methodName>

However, this technique cannot be used to invoke a default method provided by an interface that is not directly
implemented (or extended) by the caller.
------------------------------------------------------------------------------------------------------------------------
Here is an example:


public class F implements InterfaceB {
  public void m1() {
    //super.m1();//This is NOT valid.
    //InterfaceA.super.hello(); //This is NOT valid because F does not implement InterfaceA.
    InterfaceB.super.m1(); //This is valid.
  }
}

interface InterfaceA {
  default void m1() {}
}

interface InterfaceB extends InterfaceA {
  default void m1() {
    //super.hello(); //This is NOT valid.
    InterfaceA.super.m1(); //This is valid.
  }
}

In the case of overriden default method of an interface you have to specify the specific interface which
default implementation you want to invoke

EN OTRAS PALABRAS SOLO SE USA <InterfaceName>.super.<methodName> para llamar al metro de una clase padre directa
que estamos reescribiendo.

si quisieramos llamar al default metodo de una clase padre en una clase hija sin reescribirla, es decir en otro metodo
entonces no necesitariamos <InterfaceName>.super.<methodName> .

basta con poner el nombre del metodo    hola() dentro del metodo de la hija

------------------------------------------------------------------------------------------------------------------------
                                 <InterfaceName>.super.<methodName>

solo cuando reescribimos el default metodo  de la clase padre en la clase hija esta syntaxe es necesaria, para el polimorfismo
si queremos usar el metodo de la clase padre en una clase o interface hija que tiene otro nombre , es decir sin reescribirla
el nombre del metodo es suficiente    hola()

public interface A{

   default void uno(){
      System.out.println("Hola que tal");
      }

   default void hola(){
      System.out.println("Bien y tu?");
   }

}

public interface B extends A{
   default void uno(){
      A.super.uno(); //cuando reescribimos el metodo en la interface hija
      hola();        //cuando solo usamos el metodo sin reescribirlo
   }
}
------------------------------------------------------------------------------------------------------------------------
*/

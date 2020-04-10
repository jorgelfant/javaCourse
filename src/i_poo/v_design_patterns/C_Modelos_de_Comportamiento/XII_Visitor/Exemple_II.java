package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.XII_Visitor;

public class Exemple_II {
  public static void main(String[] args) {
    ComputerPart computer = new Computer();
    computer.accept(new ComputerPartDisplayVisitor());
    /*
       Displaying Mouse.
       Displaying Keyboard.
       Displaying Monitor.
       Displaying Computer.
    */
  }
}
/*
In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class. By this way,
execution algorithm of element can vary as and when visitor varies. This pattern comes under behavior pattern category.
As per the pattern, element object has to accept the visitor object so that visitor object handles the operation on
the element object.
*/
//======================================================================================================================
//                                        Implementation
//======================================================================================================================
/*
We are going to create a ComputerPart interface defining accept opearation.Keyboard, Mouse, Monitor and Computer
are concrete classes implementing ComputerPart interface. We will define another interface ComputerPartVisitor which
will define a visitor class operations. Computer uses concrete visitor to do corresponding action.

VisitorPatternDemo, our demo class, will use Computer and ComputerPartVisitor classes to demonstrate use of
visitor pattern.

      <<Interface>>
------------------------------          ------------------------------
|      ComputerPartVisitor   |          | ComputerPartDisplayvisitor |
------------------------------          ------------------------------
| +visit(Computer) :void     |<---------| +visit(Computer) :void     |
| +visit(Mouse) :void        |          | +visit(Mouse) :void        |<----------------
| +visit(Keyboard) :void     |          | +visit(Keyboard) :void     |                 |
| +visit(Monitor) :void      |          | +visit(Monitor) :void      |                 |          -------------------
------------------------------          ------------------------------                 |          |     Main        |
                                                                                       |    uses  -------------------
                                                                                       |----------| + main() : void |
                                                             <<Interface>>             |          -------------------
                                                         ----------------------        |
                                                         |    ComputerPart    |        |
                                                         ----------------------        |
                                                         |                    |<-------
                                                         | + accept() : void  |
                                                         ----------------------
                                                                   /\
                                                                   |
                                                                   | implement
             ---------------------------------------------------------------------------------
             |                              |                      |                         |
-----------------------------     ---------------------   ---------------------   ---------------------
|          Computer         |     |  Keyboard         |   |       Mouse       |   |      Monitor      |
-----------------------------     ---------------------   ---------------------   ---------------------
| - Parts [] : ComputerPart |     |                   |   |                   |   |                   |
-----------------------------     ---------------------   ---------------------   ---------------------
| + Computer()              |     | + accept() : void |   | + accept() : void |   | + accept() : void |
| + accept() : void         |     ---------------------   ---------------------   ---------------------
-----------------------------

*/

//======================================================================================================================
//                            1) Define an interface to represent element.
//======================================================================================================================
interface ComputerPart {
  void accept(ComputerPartVisitor computerPartvisitor);
}

//======================================================================================================================
//                            2) Define an interface to represent visitor
//======================================================================================================================
class Mouse implements ComputerPart {
  public void accept(ComputerPartVisitor computerPartvisitor) {
    computerPartvisitor.visit(this);
  }
}

//================================================================
class Keyboard implements ComputerPart {
  public void accept(ComputerPartVisitor computerPartvisitor) {
    computerPartvisitor.visit(this);
  }
}

//================================================================
class Monitor implements ComputerPart {
  public void accept(ComputerPartVisitor computerPartvisitor) {
    computerPartvisitor.visit(this);
  }
}

//================================================================
class Computer implements ComputerPart {

  ComputerPart[] parts;


  public Computer() {
    parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
  }

  public void accept(ComputerPartVisitor computerPartvisitor) {
    for (ComputerPart part : parts) {
      part.accept(computerPartvisitor);//las partes se comportant en funcion del contexto que ira entre parentesis
    }
    computerPartvisitor.visit(this);
  }
}

//======================================================================================================================
//                            3) Define an interface to represent visitor.((CONTEXTO))
//======================================================================================================================

interface ComputerPartVisitor {
  void visit(Mouse mouse);

  void visit(Keyboard keyboard);

  void visit(Monitor monito);

  void visit(Computer computer);
}
//======================================================================================================================
//                         4) Create concrete visitor implementing the above class.
//======================================================================================================================

//(Contexto 1)

class ComputerPartDisplayVisitor implements ComputerPartVisitor {

 @Override
 public void visit(Computer computer) {
   System.out.println("Displaying Computer.");
 }

 @Override
 public void visit(Mouse mouse) {
   System.out.println("Displaying Mouse.");
 }

 @Override
 public void visit(Keyboard keyboard) {
   System.out.println("Displaying Keyboard.");
 }

 @Override
 public void visit(Monitor monitor) {
   System.out.println("Displaying Monitor.");
 }
}

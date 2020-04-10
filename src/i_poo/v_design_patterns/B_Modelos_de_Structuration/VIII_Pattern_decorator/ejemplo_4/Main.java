package i_poo.v_design_patterns.B_Modelos_de_Structuration.VIII_Pattern_decorator.ejemplo_4;

public class Main {
  public static void main(String[] args) {
//===================================================================================================================
//                       5) Use the RedShapeDecorator to decorate Shape objects.
//===================================================================================================================
    Shape circle = new Circle();
    Shape redCircle = new RedShapeDecorator(new Circle());
    Shape redRectangle = new RedShapeDecorator(new Rectangle());

    System.out.println("Circle with normal border");
    circle.draw();

    System.out.println("\nCircle of red border");
    redCircle.draw();

    System.out.println("\nRectangle of red border");
    redRectangle.draw();
    /*
       Circle with normal border
       Shape: Circle

       Circle of red border
       Shape: Circle
       Border Color: Red

       Rectangle of red border
       Shape: Rectangle
       Border Color: Red
    */

  }
}
   /*
    Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
    This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.

    This pattern creates a decorator class which wraps the original class and provides additional functionality
    keeping class methods signature intact.

    We are demonstrating the use of decorator pattern via following example in which we will decorate a shape with
    some color without alter shape class.
    */
   //===================================================================================================================
   //                                       Implementation
   //===================================================================================================================
   /*
   We're going to create a Shape interface and concrete classes implementing the Shape interface. We will then create
   an abstract decorator class ShapeDecorator implementing the Shape interface and having Shape object as its instance
   variable.

   RedShapeDecorator is concrete class implementing ShapeDecorator.

   DecoratorPatternDemo, our demo class will use RedShapeDecorator to decorate Shape objects.


                       Interface
                -----------------------                                                          -----------------------
                |        Shape        |                                                          |        Main         |
                -----------------------                                                          -----------------------
                |                     | <---------------                                         |                     |
                -----------------------                |                                         -----------------------
                | + draw() : void     |                |                                         | + main() : void     |
                -----------------------                | decorates                               -----------------------
                          /\                           |                                                    |
                          |                            |                 -----------------------            |
                          |                            |                 |    ShapeDecorator   |            | asks
                          |                            |                 -----------------------            |
          --------------------------------              -----------------|  + shape : Shape    | <-----------
         |                               |                               -----------------------
         |                               |                               | + ShapeDecorator()  |
         |                               |                               | + draw() : void     |
         |                               |                               -----------------------
         |                               |                                          /\
-----------------------        -----------------------                              |
|        Circle       |        |      Rectangle      |                              |
-----------------------        -----------------------                              | implements
|                     |        |                     |                              |
-----------------------        -----------------------                              |
| + draw() : void     |        | + draw() : void     |                    -----------------------
-----------------------        -----------------------                    |        Shape        |
                                                                          -----------------------
                                                                          |                     |
                                                                          -----------------------
                                                                          | + draw() : void     |
                                                                          -----------------------
   */
//===================================================================================================================
//                                      1) Create an interface.
//===================================================================================================================

interface Shape {
 void draw();
}
//===================================================================================================================
//                          2) Create concrete classes implementing the same interface.
//===================================================================================================================

class Rectangle implements Shape {

 @Override
 public void draw() {
   System.out.println("Shape: Rectangle");
 }
}

//=========================================
 class Circle implements Shape {

  @Override
  public void draw() {
    System.out.println("Shape: Circle");
  }
}

//===================================================================================================================
//                       3) Create abstract decorator class implementing the Shape interface.
//===================================================================================================================
 abstract class ShapeDecorator implements Shape {
  protected Shape decoratedShape;

  public ShapeDecorator(Shape decoratedShape){
    this.decoratedShape = decoratedShape;
  }

  public void draw(){
    decoratedShape.draw();
  }
}

//===================================================================================================================
//                       4) Create concrete decorator class extending the ShapeDecorator class.
//===================================================================================================================
 class RedShapeDecorator extends ShapeDecorator {

  public RedShapeDecorator(Shape decoratedShape) {
    super(decoratedShape);
  }

  @Override
  public void draw() {
    decoratedShape.draw();
    setRedBorder(decoratedShape);
  }

  private void setRedBorder(Shape decoratedShape){
    System.out.println("Border Color: Red");
  }
}











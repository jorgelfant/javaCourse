package i_poo.v_design_patterns.B_Modelos_de_Structuration.IV_fachada.ejemplo_3;

public class Main {
  public static void main(String[] args) {
   //==================================================================================================================
   //                      4) Use the facade to draw various types of shapes
   //==================================================================================================================
    ShapeMaker shapeMaker = new ShapeMaker();

    shapeMaker.drawCircle();
    shapeMaker.drawRectangle();
    shapeMaker.drawSquare();
    /*RESULTADO
        Circle::draw()
        Rectangle::draw()
        Square::draw()
    */

  }
}
    /*
    Facade pattern hides the complexities of the system and provides an interface to the client using which
    the client can access the system. This type of design pattern comes under structural pattern as this pattern adds
    an interface to existing system to hide its complexities.

    This pattern involves a single class which provides simplified methods required by client and delegates calls to
    methods of existing system classes.
    */
//==================================================================================================================
//                                     Implementation
//==================================================================================================================
    /*
    We are going to create a Shape interface and concrete classes implementing the Shape interface.
    A facade class ShapeMaker is defined as a next step.

    ShapeMaker class uses the concrete classes to delegate user calls to these classes. FacadePatternDemo,
    our demo class, will use ShapeMaker class to show the results.


----------------------------------------------------------------------------
|                            -----------------                             |                     -----------------
|                            |    Shape      |     <<Interface>>           |                     |     Exemple_1      |
|                            -----------------                             |                     -----------------
|                            |               |                             |                     |               |
|                            -----------------                             |                     -----------------
|                            | +draw() :void |                             |                     | +main() : void|
|                            -----------------                             |                     -----------------
|                                   |                                      |                             | asks
|             --------------------- | ------------------------             |                            \/
|            |                      |                         \            |                ----------------------------
|           |                       |                          \           |                |         shapeMaker       |
|   -----------------        -----------------        -----------------    |                ----------------------------
|   |    Circle     |        |    Rectangle  |        |    Square     |    |      Creates   | - circle : Shape         |
|   -----------------        -----------------        -----------------    | <--------------| - rectangle : Shape      |
|   |               |        |               |        |               |    |                | - square : Shape         |
|   -----------------        -----------------        -----------------    |                ----------------------------
|   | +draw() :void |        | +draw() :void |        | +draw() :void |    |                | + ShapeMaker()           |
|   -----------------        ----------------         -----------------    |                | + drawCircle() : void    |
|                                                                          |                | + drawRectangle() : void |
----------------------------------------------------------------------------                | + drawSquare() : void    |
                                                                                            ----------------------------
    */

//==================================================================================================================
//                                     1) Create an interface.
//==================================================================================================================
 interface Shape {
  void draw();
}

//==================================================================================================================
//                     2) Create concrete classes implementing the same interface.
//==================================================================================================================
 class Rectangle implements Shape {

  @Override
  public void draw() {
    System.out.println("Rectangle::draw()");
  }
}

class Square implements Shape {

 @Override
 public void draw() {
   System.out.println("Square::draw()");
 }
}

class Circle implements Shape {

 @Override
 public void draw() {
   System.out.println("Circle::draw()");
 }
}

//==================================================================================================================
//                                  3) Create a facade class
//==================================================================================================================
 class ShapeMaker {
  private Shape circle;
  private Shape rectangle;
  private Shape square;

  public ShapeMaker() {
    circle = new Circle();
    rectangle = new Rectangle();
    square = new Square();
  }

  public void drawCircle(){
    circle.draw();
  }
  public void drawRectangle(){
    rectangle.draw();
  }
  public void drawSquare(){
    square.draw();
  }
}

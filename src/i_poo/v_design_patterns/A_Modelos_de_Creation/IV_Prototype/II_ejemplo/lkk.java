package i_poo.v_design_patterns.A_Modelos_de_Creation.IV_Prototype.II_ejemplo;

import java.util.Hashtable;

public class lkk {
  public static void main(String[] args) {
    /*
    Prototype pattern refers to creating duplicate object while keeping performance in mind. This type of design pattern
    comes under creational pattern as this pattern provides one of the best ways to create an object.

    This pattern involves implementing a prototype interface which tells to create a clone of the current object.
    This pattern is used when creation of object directly is costly. For example, an object is to be created after
    a costly database operation. We can cache the object, returns its clone on next request and update the database
    as and when needed thus reducing database calls

    //==================================================================================================================
    //                                   Implementation
    //==================================================================================================================

    We're going to create an abstract class Shape and concrete classes extending the Shape class. A class ShapeCache
    is defined as a next step which stores shape objects in a Hashtable and returns their clone when requested.

    PrototypPatternDemo, our demo class will use ShapeCache class to get a Shape object.

 ------------------------------------------------------------------------------------------------
 |                                  -------------------------                                   |
 |                                  |         Shape         |                                   |
 |                                  -------------------------                                   |
 |                                  | - id : String         |                                   |
 |                                  | + type : String       |                                   |                        ------------------------
 |                                  -------------------------                                   |                        | PrototypePatternDemo |
 |                                  | + getType() : void    |                                   |                        |                      |
 |                                  | + getId() : String    |                                   |                        | +main() : void       |
 |                                  | + setId() : void      |                                   |                        ------------------------
 |                                  | + clone() : Object    |                                   |                                    |
 |                                  -------------------------                                   |                                    | ASKS
 |                                              /\                                              |                                    |
 |                                              | extends                                       |                                   \/
 |                                              |                                               |                         ------------------------
 |                 -----------------------------------------------------------                  |                         |      ShapeCache      |
 |                |                             |                            |                  |          CLONES         ------------------------
 |                |                             |                            |                  | <-----------------------| -ShapeMap : HashMap  |
 |  -------------------------        -------------------------     -------------------------    |                         ------------------------
 |  |         Circle        |        |       Rectangle       |     |        Square         |    |                         | -getshape : shape    |
 |  -------------------------        -------------------------     -------------------------    |                         | +getShape() : void   |
 |  | + type : String       |        | + type : String       |     | + type : String       |    |                         ------------------------
 |  -------------------------        -------------------------     -------------------------    |
 |  | + getType() : void    |        | + getType() : void    |     | + getType() : void    |    |
 |  | + getId() : String    |        | + getId() : String    |     | + getId() : String    |    |
 |  | + setId() : void      |        | + setId() : void      |     | + setId() : void      |    |
 |  | + clone() : Object    |        | + clone() : Object    |     | + clone() : Object    |    |
 |  -------------------------        -------------------------     -------------------------    |
 |                                                                                              |
 |                                                                                              |
 ------------------------------------------------------------------------------------------------

    */
//======================================================================================================================
//                   STEP 4 : PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a Hashtable.
//======================================================================================================================
    ShapeCache.loadCache();

    Shape clonedShape =  ShapeCache.getShape("1");
    System.out.println("Shape : " + clonedShape.getType());

    Shape clonedShape2 =  ShapeCache.getShape("2");
    System.out.println("Shape : " + clonedShape2.getType());

    Shape clonedShape3 =  ShapeCache.getShape("3");
    System.out.println("Shape : " + clonedShape3.getType());

    /* STEP 5 : Verify the output.
       RESULTADO
       Shape : Circle
       Shape : Square
       Shape : Rectangle
    */
  }
}
//======================================================================================================================
//                   STEP 1 : Create an abstract class implementing Clonable interface.
//======================================================================================================================

abstract class Shape implements Cloneable {
  private String id;
  protected String type;

  abstract void draw();

  public String getType() {
    return type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Object clone() {
    Object clone = null;

    try {
      clone = super.clone();

    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }

    return clone;
  }
}


//======================================================================================================================
//                   STEP 2 : Create concrete classes extending the above class.
//======================================================================================================================
class Rectangle extends Shape {

  public Rectangle() {
    type = "Rectangle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Rectangle::draw() method.");
  }
}

//****************************************************************
class Square extends Shape {

  public Square() {
    type = "Square";
  }

  @Override
  public void draw() {
    System.out.println("Inside Square::draw() method.");
  }
}

//****************************************************************
class Circle extends Shape {

  public Circle() {
    type = "Circle";
  }

  @Override
  public void draw() {
    System.out.println("Inside Circle::draw() method.");
  }
}

//======================================================================================================================
//                   STEP 3 : Create a class to get concrete classes from database and store them in a Hashtable.
//======================================================================================================================
class ShapeCache {

  private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

  public static Shape getShape(String shapeId) {
    Shape cachedShape = shapeMap.get(shapeId);
    return (Shape) cachedShape.clone();
  }

  // for each shape run database query and create shape
  // shapeMap.put(shapeKey, shape);
  // for example, we are adding three shapes

  public static void loadCache() {
    Circle circle = new Circle();
    circle.setId("1");
    shapeMap.put(circle.getId(), circle);

    Square square = new Square();
    square.setId("2");
    shapeMap.put(square.getId(), square);

    Rectangle rectangle = new Rectangle();
    rectangle.setId("3");
    shapeMap.put(rectangle.getId(), rectangle);
  }
}




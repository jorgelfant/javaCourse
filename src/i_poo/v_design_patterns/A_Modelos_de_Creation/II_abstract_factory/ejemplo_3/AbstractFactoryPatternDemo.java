package i_poo.v_design_patterns.A_Modelos_de_Creation.II_abstract_factory.ejemplo_3;

public class AbstractFactoryPatternDemo {
  public static void main(String[] args) {
    //get rounded shape factory
    AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
    //get an object of Shape Rounded Rectangle
    Shape shape1 = shapeFactory.getShape("RECTANGLE");
    //call draw method of Shape Rectangle
    shape1.draw();
    //get an object of Shape Rounded Square
    Shape shape2 = shapeFactory.getShape("SQUARE");
    //call draw method of Shape Square
    shape2.draw();
    //get rounded shape factory
    AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
    //get an object of Shape Rectangle
    Shape shape3 = shapeFactory1.getShape("RECTANGLE");
    //call draw method of Shape Rectangle
    shape3.draw();
    //get an object of Shape Square
    Shape shape4 = shapeFactory1.getShape("SQUARE");
    //call draw method of Shape Square
    shape4.draw();
  }
}

/*RESULTADO
  Inside Rectangle::draw() method.
  Inside Square::draw() method.
  Inside RoundedRectangle::draw() method.
  Inside RoundedSquare::draw() method.
 */
//**********************************************************************************************************************
//      1) Create an interface for Shapes and Colors.
//**********************************************************************************************************************
 interface Shape {
  void draw();
}

//**********************************************************************************************************************
//     2) Create concrete classes implementing the same interface.
//**********************************************************************************************************************
 class RoundedRectangle implements Shape {
  @Override
  public void draw() {
    System.out.println("Inside RoundedRectangle::draw() method.");
  }
}

class RoundedSquare implements Shape {
 @Override
 public void draw() {
   System.out.println("Inside RoundedSquare::draw() method.");
 }
}

class Rectangle implements Shape {
 @Override
 public void draw() {
   System.out.println("Inside Rectangle::draw() method.");
 }
}

class Square implements Shape {
 @Override
 public void draw() {
   System.out.println("Inside Square::draw() method.");
 }
}

//**********************************************************************************************************************
//     3) Create an Abstract class to get factories for Normal and Rounded Shape Objects.
//**********************************************************************************************************************
 abstract class AbstractFactory {
  abstract Shape getShape(String shapeType) ;
}

//**********************************************************************************************************************
//     4) Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.
//**********************************************************************************************************************
class ShapeFactory extends AbstractFactory {
  @Override
  public Shape getShape(String shapeType){
    if(shapeType.equalsIgnoreCase("RECTANGLE")){
      return new Rectangle();
    }else if(shapeType.equalsIgnoreCase("SQUARE")){
      return new Square();
    }
    return null;
  }
}

class RoundedShapeFactory extends AbstractFactory {
 @Override
 public Shape getShape(String shapeType){
   if(shapeType.equalsIgnoreCase("RECTANGLE")){
     return new RoundedRectangle();
   }else if(shapeType.equalsIgnoreCase("SQUARE")){
     return new RoundedSquare();
   }
   return null;
 }
}

//**********************************************************************************************************************
//     5) Create a Factory generator/producer class to get factories by passing an information such as Shape
//**********************************************************************************************************************
 class FactoryProducer {
  public static AbstractFactory getFactory(boolean rounded){
    if(rounded){//true
      return new RoundedShapeFactory();
    }else{//false
      return new ShapeFactory();
    }
  }
}


package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.XII_Visitor;

public class Exemple_I {
  public static void main(String[] args) {

    Car myCar = new Car();

    //Conexto1
    CarElementVisitor contexto1 = new CarElementPrintVisitor();//ojo hubiera podido poner el car como argumento
    contexto1.visitCar(myCar);          //new CarElementDoVisitor(myCar) si asi lo hubiera definido

    System.out.println();

    //Conexto2
    CarElementVisitor contexto2=new CarElementDoVisitor();//ojo hubiera podido poner el car como argumento
    contexto2.visitCar(myCar);   //new CarElementDoVisitor(myCar) si asi lo hubiera definido
  }
}

//======================================================================================================================
//                          Découpler classes et traitements, afin de pouvoir ajouter de nouveaux
//                          traitements sans ajouter de nouvelles méthodes aux classes existantes
//======================================================================================================================
/*
Un visiteur est le nom d'une des structures de patron de conception comportemental.

Le visiteur est une manière de séparer un algorithme d'une structure de données. Un visiteur possède une méthode
par type d'objet traité. Pour ajouter un nouveau traitement, il suffit de créer une nouvelle classe dérivée de la
classe Visiteur. On n'a donc pas besoin de modifier la structure des objets traités, contrairement à ce qu'il aurait
été obligatoire de faire si on avait implémenté les traitements comme des méthodes de ces objets.

L'avantage du patron visiteur est qu'un visiteur peut avoir un état. Ce qui signifie que le traitement d'un type
d'objet peut différer en fonction de traitements précédents. Par exemple, un visiteur affichant une structure
arborescente peut présenter les nœuds de l'arbre de manière lisible en utilisant une indentation dont le niveau est
stocké comme valeur d'état du visiteur.
*/
//======================================================================================================================
//                                               EXEMPLE
//======================================================================================================================
/*
L'exemple suivant montre comment afficher un arbre de nœuds (les composants d'une voiture). Au lieu de créer des
méthodes d'affichage pour chaque sous-classe (Wheel, Engine, Body, et Car), une seule classe est créée
(CarElementPrintVisitor) pour afficher les éléments. Parce que les différentes sous-classes requièrent différentes
actions pour s'afficher proprement, la classe CarElementPrintVisitor répartit l'action en fonction de la classe de
l'argument qu'on lui passe.
*/

/*
Haciendolo solo
================

   . Vampa tener una clase ""un auto"", es decir una clase Car

   . De que esta compuesto ese auto? pues de Wheel, Engine, Bosy

   . Como queremos dar un comportamiento diferente a estos componenetes de Car en funcion del contexto
     haremos una interface que contenga un metodo que estos componentes heredaran y que cambiaran  en funcion
     del contexto en el que se encuentran.

   . Los contextos deben entonces influenciar a Wheel, Engine, Body

   .Lo cual quiere decir que pueden haber varios contextos
*/

//======================================================================================================================
//                                                    Contextos
//======================================================================================================================
//como podemos tener varios contextos, seria bueno tener una interface
//cobre quienes va repercutir el contexto, pues sobre el auto y sus componenentes
//a partir de esta interface podemos definir los contextos que influenciaran a estos elementos (parametros)

interface CarElementVisitor {
  void visit(Wheel wheel);

  void visit(Engine engine);

  void visit(Body body);

  void visitCar(Car car);
}

//Contexto 1 chequeamos el auto y componenetes===============
class CarElementPrintVisitor implements CarElementVisitor {
  public void visit(Wheel wheel) {
    System.out.println("Visiting " + wheel.getName() + " wheel");
  }

  public void visit(Engine engine) {
    System.out.println("Visiting engine");
  }

  public void visit(Body body) {
    System.out.println("Visiting body wheel");
  }

  public void visitCar(Car car) {
    System.out.println("\nVisiting car");
    for (CarElement carElement : car.getElements()) {
      carElement.accept(this);//me imprimira el comportamiento de cada elemento, que defini aqui en esta
    }                                      //misma clase
    System.out.println("Visited Car");
  }
}

//Contexto 2 arrancamos el auto==============================
class CarElementDoVisitor implements CarElementVisitor {
  public void visit(Wheel wheel) {
    System.out.println("Kicking my " + wheel.getName());
  }

  public void visit(Engine engine) {
    System.out.println("Starting engine");
  }

  public void visit(Body body) {
    System.out.println("Moving my body");
  }

  public void visitCar(Car car) {
    System.out.println("\nStarting my car");
    for (CarElement carElement : car.getElements()) {
      carElement.accept(this);//me imprimira el comportamiento de cada elemento, que defini aqui en esta
    }                                       //misma clase
    System.out.println("Started Car");
  }
}

//antes de definir completamento estos contextos debemos crear paralelamente, los elementos sobre los que van a influir
//======================================================================================================================
//                                                 CarElement
//======================================================================================================================
//que tienen en comun estas clases, pues que son las 3 componentes del auto, por lo cual podemos tener una interface
//de elementos con un metodo a implementar en cada componenente

interface CarElement {
  //cada uno de estos elementos se comporta diferente o es influenciado en funcion del contexto , por eso tenra el contexto
  // en parametro para que cambie segun sea necesario
  void accept(CarElementVisitor CarElementVisitor);
}

class Wheel implements CarElement {
  private String name;

  public Wheel(String name) {//porque hay 4 ruedas, pa darle nombre a cada rueda
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void accept(CarElementVisitor CarElementVisitor) {//el elemento Wheel se comporta de cierta forma en funcion del contexto
    CarElementVisitor.visit(this);//el contexto influye en el elemento Wheel
  }
}

//============================================================
class Engine implements CarElement {//solo un motor

  public void accept(CarElementVisitor CarElementVisitor) {
    CarElementVisitor.visit(this);
  }
}

//============================================================
class Body implements CarElement {//solo una estructura o carroseria

  public void accept(CarElementVisitor CarElementVisitor) {
    CarElementVisitor.visit(this);
  }
}

//tenemos los elementos del objecto principal Car, ahora creamos el Car que esta compuesto pues de estos elementos
//======================================================================================================================
//                                                 Car
//======================================================================================================================

class Car {
  CarElement[] elements; //el Car esta formado por ciertos elementos

  //constructor
  public Car() {//al crear el auto el auto tendra iniciados sus componenetes
    elements = new CarElement[]{
      new Wheel("front left"),
      new Wheel("front right"),
      new Wheel("back left"),
      new Wheel("back right"),
      new Engine(),
      new Body()
    };
  }

  public CarElement[] getElements() {
    return this.elements.clone();// Retourne une copie du tableau de références.
  }
}
//TENEMOS EL AUTO Y SUS COMPOENENTES AHORA TERMINEMOS CON LOS CONTEXTOS

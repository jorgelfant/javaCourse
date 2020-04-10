package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_12_Builder_varios_constructores;

import java.util.LinkedList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    /*
    Design Patterns can make our work a lot easier. They are a generic solution for recurring design problem.
    For example some of classes have many attributes with different properties. It requires many constructors
    and they can be really difficult to use. To solve this problem we can implement the Builder Design Pattern.

    Let’s asume that we are working on an Auto-Management software and we want to write an Auto class with
    the following attributes:
    */
    //METODO CLASICO
    Owner o1 = new Owner("Tony");
    Owner o2 = new Owner("Sam");
    Owner o3 = new Owner("Matt");

    Auto auto = new Auto("Nisan Lift", 25000, 2015, Color.Red, 180);
    auto.addOwner(o1);
    auto.addOwner(o3);
    System.out.println(auto);

    //METODO  con Builder
    BetterAuto hola = new AutoBuilder5("Lamborgini").color(Color.Red).maxSpeed(5).price(55).year(2500).addOwners(new Owner("Safm")).build();
    System.out.println(hola);

  }
}
//**********************************************************************************************************************
//                                   Clase y atributos manera clasica
//**********************************************************************************************************************

class Auto {

  private final String name; //required
  private double price;
  private int year;
  private Color color;
  private double maxSpeed;
  private List<Owner> owners;

  // Constructors //
  public Auto(String name, double price, int year, Color color, double maxSpeed) {
    this.name = name;
    this.price = price;
    this.year = year;
    this.color = color;
    this.maxSpeed = maxSpeed;
    owners = new LinkedList<Owner>();//inicia la lista que trabajara con la clase Owner
  }

  public Auto(String name, double price, int year, Color color) {
    this(name, price, year, color, 0.0);
  }

  public Auto(String name, double price, int year) {
    this(name, price, year, Color.Red);
  }

  public Auto(String name, double price) {
    this(name, price, 1925);
  }

  public Auto(String name) {
    this(name, 0.0);
  }

  // Getters & Setters //
  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  //***********************************
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  //***********************************
  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  //***********************************
  public double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  //***********************************
  public List<Owner> getOwners() {
    return owners;
  }

  public void setOwners(List<Owner> owners) {
    this.owners = owners;
  }

  //***********************************
  public String getName() {
    return name;
  }

  //***********************************
  // Other Methods //
  public void addOwner(Owner o) {
    owners.add(o);
  }

  //***********************************
  public String getOwnersString() {
    String str = "";
    for (Owner o : owners)
      str += o.toString() + " ";
    return str;
  }

  //***********************************
  @Override
  public String toString() {
    return "Auto [name=" + name + ", price=" + price + ", year=" + year + ", color=" + color + ", maxSpeed="
      + maxSpeed + ", owners=" + getOwnersString() + "]";
  }
}
//**********************************************************************************************************************
//                                  CON BUILDER
//**********************************************************************************************************************

enum Color {
  Black, Blue, Green, Grey, Red, White, Yellow
}

class Owner {
  private String name;

  public Owner(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Owner [name=" + name + "]";
  }
}

//**********************************************************************************************************************

class BetterAuto {

  private String name; //required
  private double price;
  private int year;
  private Color color;
  private double maxSpeed;
  private List<Owner> owners = new LinkedList<>();//necesitamos que la lista este ya iniciada incluso antes de crear el objeto

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  //*************************************
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  //*************************************
  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  //*************************************
  public double getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(double maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  //*************************************
  public List<Owner> getOwners() {
    return owners;
  }

  public void setOwners(List<Owner> owners) {
    this.owners = owners;
  }

  public void addOwner(Owner o) {
    this.owners.add(o);
  }

  //*************************************
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  //*************************************


  public String getOwnersString() {
    String str = "";
    for (Owner o : owners)
      str += o.toString() + " ";
    return str;
  }

  @Override
  public String toString() {
    return "BetterAuto [name=" + name + ", price=" + price + ", year=" + year + ", color=" + color
      + ", maxSpeed=" + maxSpeed + ", owners=" + getOwnersString() + "]";
  }
}

//*********************************************************************************************
//                           BUILDER
//*********************************************************************************************
abstract class AutoBuilder {
  protected BetterAuto car;

  public AutoBuilder(String name) {//constructor
    car = new BetterAuto();
    this.car.setName(name);
  }

  //metodos
  public AutoBuilder addOwners(Owner... owners) {
    for (Owner o : owners)//seria mas corto     this.owners.addAll(Arrays.asList(owners));
      car.addOwner(o);
    return this;
  }

  public AutoBuilder testContenu() throws Exception {
    if (car.getOwners().size() > 0) {
      return this;
    } else {
      throw new Exception("We need at least one owner!");
    }
  }

  //build
  public BetterAuto build() {
    return this.car;
  }
}

//*********************************************************************************************
//                  IMPLEMENTACIONES DE AUTOBUILDER
//*********************************************************************************************
//1
class AutoBuilder1 extends AutoBuilder {
  public AutoBuilder1(String name) {//constructor
    super(name);
  }
}

//2
class AutoBuilder2 extends AutoBuilder {
  public AutoBuilder2(String name) {//constructor
    super(name);
  }

  public AutoBuilder2 price(double price) {
    this.car.setPrice(price);
    return this;
  }
}

//3
class AutoBuilder3 extends AutoBuilder {
  public AutoBuilder3(String name) {//constructor
    super(name);
  }

  public AutoBuilder3 price(double price) {
    this.car.setPrice(price);
    return this;
  }

  public AutoBuilder3 year(int year) {
    this.car.setYear(year);
    return this;
  }
}

//4
class AutoBuilder4 extends AutoBuilder {
  public AutoBuilder4(String name) {//constructor
    super(name);
  }

  public AutoBuilder4 price(double price) {
    this.car.setPrice(price);
    return this;
  }

  public AutoBuilder4 year(int year) {
    this.car.setYear(year);
    return this;
  }

  public AutoBuilder4 color(Color color) {
    this.car.setColor(color);
    return this;
  }
}

//5
class AutoBuilder5 extends AutoBuilder {
  public AutoBuilder5(String name) {//constructor
    super(name);
  }

  public AutoBuilder5 price(double price) {
    this.car.setPrice(price);
    return this;
  }

  public AutoBuilder5 year(int year) {
    this.car.setYear(year);
    return this;
  }

  public AutoBuilder5 color(Color color) {
    this.car.setColor(color);
    return this;
  }

  public AutoBuilder5 maxSpeed(double maxSpeed) {
    this.car.setMaxSpeed(maxSpeed);
    return this;
  }
}

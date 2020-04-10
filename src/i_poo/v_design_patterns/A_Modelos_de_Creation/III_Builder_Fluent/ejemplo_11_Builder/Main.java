package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_11_Builder;

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

    Auto auto =  new Auto("Nisan Lift", 25000, 2015, Color.Red,180);
    auto.addOwner(o1);
    auto.addOwner(o3);

    //METODO CON BUILDER
    BetterAuto betterAuto = null;  //public BetterAuto(AutoBuilder builder)
    try {//             owners(new Owner("Sam"))   metodo del Builder para agregar owners
      betterAuto = new BetterAuto(new BetterAuto.AutoBuilder("Tesla Model S").color(Color.White).maxSpeed(300).price(70000)
        .year(2014)                             //esto va a dar un Builder que Better auto usa como parametro en su constructor
        .owners(o1,o2)
        .owners(o3)
        .build());
    } catch (Exception e) {}

    System.out.println(auto);
    System.out.println(betterAuto);

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

   public Auto(String name, double price, int year, Color color){
       this(name,price,year,color,0.0);
   }

   public Auto(String name, double price, int year){
       this(name,price,year, Color.Red);
   }

   public Auto(String name, double price){
       this(name,price,1925);
   }

   public Auto(String name){
       this(name,0.0);
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
   public void addOwner(Owner o){
       owners.add(o);
   }
  //***********************************
  public String getOwnersString(){
    String str = "";
    for(Owner o: owners)
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
/*
But as you can see it isn’t flexible at all. We can’t choose for example a constructor with the attributes name
and price. We would need an additional constructor for that. That’s why I would recommend you the this Design Pattern.*/

//**********************************************************************************************************************
//                                   Step 1: Create a static Builder class
//**********************************************************************************************************************
/*
The first step consist in writing a static class with in our class. In our example the AutoBuilder class.
This builder class should have the same attributes as the regular class.
*/
//**********************************************************************************************************************
//                                   Step 2: Add a Builder constructor
//**********************************************************************************************************************
/*
Our builder class need a constructor just as any other class. But the only parameters that we are using this time
are the required attributes. In this constructor we can also initialise our list or other important (fixed) values.
*/


//**********************************************************************************************************************
//                                   Step 3: Add a Builder setter for each optional attribute
//**********************************************************************************************************************
/*
For all the remaining attributes we should write a setter method in order to being able to give them a value.
The only difference between this setters and a regular one is that we use our builder class as the return parameter
and not void. To accomplish this we must return the our builder class after setting the value.
*/

//**********************************************************************************************************************
//                                   Step 4: Implement the build method
//**********************************************************************************************************************
/*
The last step for our builder class is to implement a build method. It should just return it self. But we have
the option to add some extra functionality. For example in our Auto-Management software we want that all instances
of the Auto class have at least one owner.
*/


//**********************************************************************************************************************
//                                   Step 5: Add a class constructor
//**********************************************************************************************************************
/*
Our final step is to add a constructor to our main class. It should use only have a Builder class as input parameter
and it should copy all the information of it.
*/

//**********************************************************************************************************************
//                                   Step 6: Use it!
//**********************************************************************************************************************
/*
To create an instance of our class Auto. We just need to create a new instance of our builder and add all the
properties that we want. After that we invoque our build method in other to materialise it. In this particular
case we have to handle an invalid object exception because we want to create Autos with at least one Owner.
*/

enum Color {
  Black,Blue,Green,Grey,Red,White,Yellow
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

  private final String name; //required
  private double price;
  private int year;
  private Color color;
  private double maxSpeed;
  private List<Owner> owners;

  public BetterAuto(AutoBuilder builder){
    this.name = builder.name;
    this.price = builder.price;
    this.year = builder.year;
    this.color = builder.color;
    this.maxSpeed = builder.maxSpeed;
    this.owners = builder.owners;
  }

  static class AutoBuilder{

    private final String name; //required
    private double price;
    private int year;
    private Color color;
    private double maxSpeed;
    private List<Owner> owners;

    public AutoBuilder(String name){//constructor
      this.name = name;
      owners = new LinkedList<>();
    }

    public AutoBuilder price(double price){
      this.price = price;
      return this;
    }

    public AutoBuilder year(int year){
      this.year = year;
      return this;
    }

    public AutoBuilder color(Color color){
      this.color = color;
      return this;
    }

    public AutoBuilder maxSpeed(double maxSpeed){
      this.maxSpeed = maxSpeed;
      return this;
    }

    public AutoBuilder owners(Owner...owners){
      for(Owner o: owners)//seria mas corto     this.owners.addAll(Arrays.asList(owners));
        this.owners.add(o);
      return this;
    }
    //build
    public AutoBuilder build() throws Exception {
      if(owners.size() > 0){
        return this;
      }else{
        throw new Exception("We need at least one owner!");
      }
    }
  }

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
  //*************************************
  public String getName() {
    return name;
  }
  //*************************************
  public String getOwnersString(){
    String str = "";
    for(Owner o: owners)
      str += o.toString() + " ";
    return str;
  }

  @Override
  public String toString() {
    return "BetterAuto [name=" + name + ", price=" + price + ", year=" + year + ", color=" + color
      + ", maxSpeed=" + maxSpeed + ", owners=" + getOwnersString() + "]";
  }


}


package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.II_Command;

import java.util.LinkedList;
import java.util.List;

public class Exemple_III {
  public static void main(String[] args) {
    Product iPad = new Product("iPad Air", 399);
    Product iPhone = new Product("iPhone 6", 599);
    Product beatsSolo = new Product("Beats Solo", 150);

    Store appleStore = new Store();

    //Buying Orders
    Orderr o1 = new BuyProduct(iPad, 10);
    Orderr o2 = new BuyProduct(iPhone, 15);
    Orderr o3 = new BuyProduct(beatsSolo, 5);

    //Selling Orders
    Orderr o4 = new SellProduct(iPad, 2);
    Orderr o5 = new SellProduct(iPhone, 3);
    Orderr o6 = new SellProduct(beatsSolo, 4);

    appleStore.takeOrders(o3, o2, o1, o5, o6, o4);
    appleStore.executeOrders();
    /*RESULTAT
         SOLD: 5x Product [name=Beats Solo, price=150.0]
         SOLD: 15x Product [name=iPhone 6, price=599.0]
         SOLD: 10x Product [name=iPad Air, price=399.0]
         SOLD: 3x Product [name=iPhone 6, price=599.0]
         SOLD: 4x Product [name=Beats Solo, price=150.0]
         SOLD: 2x Product [name=iPad Air, price=399.0]
    */
  }
}

class Product {

  private String name;
  private double price;

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void buy(int quantity) {
    System.out.println("BOUGHT: " + quantity + "x " + this);
  }

  public void sell(int quantity) {
    System.out.println("SOLD: " + quantity + "x " + this);
  }//                                                |

  //                                       ---------
  @Override                      //        |
  public String toString() {     //       \/
    return "Product [name=" + name + ", price=" + price + "]";
  }

}

//****************************************************************
interface Orderr {
  public void execute();
}

//****************************************************************
class BuyProduct implements Orderr {

  private Product product;
  private int quantity;

  public BuyProduct(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  @Override
  public void execute() {
    product.buy(quantity);
  }

}

//****************************************************************
class SellProduct implements Orderr {

  private Product product;
  private int quantity;

  public SellProduct(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
  }

  @Override
  public void execute() {
    product.sell(quantity);
  }
}

//****************************************************************
class Store {

  private List<Orderr> orders;

  public Store() {
    orders = new LinkedList();
  }

  public void takeOrders(Orderr... orders) {
    for (Orderr o : orders)//this.orders.addAll(Arrays.asList(orders));
      this.orders.add(o);
  }

  public void executeOrders() {
    for (Orderr o : orders)
      o.execute();
    orders.clear();
  }

}

package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.VIIII_Null_Object;

public class Exemple_II {
  public static void main(String[] args) {
//======================================================================================================================
//                        4) Use the CustomerFactory to get either RealCustomer or
//                        NullCustomer objects based on the name of customer passed to it.
//======================================================================================================================
    AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
    AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
    AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
    AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

    System.out.println("Customers");
    System.out.println(customer1.getName());
    System.out.println(customer2.getName());
    System.out.println(customer3.getName());
    System.out.println(customer4.getName());
    /*
       Customers
       Rob
       Not Available in Customer Database
       Julie
       Not Available in Customer Database
    */
  }
}
/*
In Null Object pattern, a null object replaces check of NULL object instance. Instead of putting if check for
a null value, Null Object reflects a do nothing relationship. Such Null object can also be used to provide
default behaviour in case data is not available.

In Null Object pattern, we create an abstract class specifying various operations to be done, concrete classes
extending this class and a null object class providing do nothing implemention of this class and will be used
seemlessly where we need to check null value.
*/

//======================================================================================================================
//                                            Implementation
//======================================================================================================================
/*
We are going to create a AbstractCustomer abstract class defining opearations. Here the name of the customer
and concrete classes extending the AbstractCustomer class. A factory class CustomerFactory is created to return
either RealCustomer or NullCustomer objects based on the name of customer passed to it.

NullPatternDemo, our demo class, will use CustomerFactory to demonstrate the use of Null Object pattern.


------------------------------------------------------------------------
|                              <<Abstract>>                            |                ------------------------
|                        ------------------------                      |                |         Main         |
|                        |    AbstractCustomer  |                      |                ------------------------
|                        ------------------------                      |                | + main() : void      |
|                        | # name : String      |                      |                ------------------------
|                        ------------------------                      |                           |
|                        | + isNull() : Boolean |                      |                           |
|                        | + getName() : String |                      |                          \/
|                        ------------------------                      |         --------------------------------------
|                                   /\                                 |         |          CustomerFactory           |
|                                   | implements                       | creates --------------------------------------
|                                   |                                  | <------ |                                    |
|                --------------------------------------                |         |-------------------------------------
|                |                                    |                |         |                                    |
|     ------------------------             ------------------------    |         | + getCustomer() : AbstractCustomer |
|     |      RealCustomer    |             |      NullCustomer    |    |         --------------------------------------
|     ------------------------             ------------------------    |
|     | # name : String      |             | # name : String      |    |
|     |-----------------------             |-----------------------    |
|     | + RealCustomer()     |             | + NullCustomer()     |    |
|     | + isNull() : Boolean |             | + isNull() : Boolean |    |
|     | + getName() : String |             | + getName() : String |    |
|     ------------------------             ------------------------    |
|                                                                      |
------------------------------------------------------------------------
*/
//======================================================================================================================
//                                      1) Create an abstract class.
//======================================================================================================================
abstract class AbstractCustomer {
  protected String name;

  public abstract boolean isNull();
  public abstract String getName();
}

//======================================================================================================================
//                          2) Create concrete classes extending the above class.
//======================================================================================================================

class RealCustomer extends AbstractCustomer {

  public RealCustomer(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isNull() {
    return false;
  }
}

//=====================================================
class NullCustomer extends AbstractCustomer {

  @Override
  public String getName() {
    return "Not Available in Customer Database";
  }

  @Override
  public boolean isNull() {
    return true;
  }
}

//======================================================================================================================
//                                3) Create CustomerFactory Class.
//======================================================================================================================
class CustomerFactory {

  public static final String[] names = {"Rob", "Joe", "Julie"};

  public static AbstractCustomer getCustomer(String name) {

    for (int i = 0; i < names.length; i++) {
      if (names[i].equalsIgnoreCase(name)) {
        return new RealCustomer(name);
      }
    }
    return new NullCustomer();
  }
}






package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_13;

public class Main {
  public static void main(String[] args) {
  /*In my two immediately previous posts, I looked at reducing the number of parameters required for a constructor or
  method invocation via custom types and parameter objects. In this post, I look at use of the builder pattern to reduce
  the number of parameters required for a constructor with some discussion on how this pattern can even help with
  non-constructor methods that take too many parameters.

  In the Second Edition of Effective Java, Josh Bloch introduces use of the builder pattern in Item #2 for dealing with
  constructors that require too many parameters. Bloch not only demonstrates how to use the Builder, but explains it
  advantages over constructors accepting a large number of parameters. I will get to those advantages at the end of this
  post, but think it's important to point out that Bloch has devoted an entire item in his book to this practice.

  To illustrate the advantages of this approach, I'll use the following example Person class. It doesn't have all the
  methods I would typically add to such a class because I want to focus on its construction.                          */


  //********************************************************************************************************************
  //                                 Person.java (without Builder Pattern)
  //********************************************************************************************************************


  }
}

class Person {
  private final String lastName;
  private final String firstName;
  private final String middleName;
  private final String salutation;
  private final String suffix;
  private final String streetAddress;
  private final String city;
  private final String state;
  private final boolean isFemale;
  private final boolean isEmployed;
  private final boolean isHomewOwner;

  public Person(final String newLastName, final String newFirstName, final String newMiddleName, final String newSalutation,
                final String newSuffix, final String newStreetAddress, final String newCity, final String newState, final boolean newIsFemale,
                final boolean newIsEmployed, final boolean newIsHomeOwner) {

    this.lastName = newLastName;
    this.firstName = newFirstName;
    this.middleName = newMiddleName;
    this.salutation = newSalutation;
    this.suffix = newSuffix;
    this.streetAddress = newStreetAddress;
    this.city = newCity;
    this.state = newState;
    this.isFemale = newIsFemale;
    this.isEmployed = newIsEmployed;
    this.isHomewOwner = newIsHomeOwner;
  }
}

/**********************************************************************************************************************
  This class's constructor works, but it is difficult for client code to use properly. The Builder pattern can be used
  to make the constructor easier to use. NetBeans will refactor this for me as I have written about previously. An
  example of the refactored code is shown next (NetBeans does this by creating all new Builder class).
***********************************************************************************************************************/
 class PersonBuilder {
  private String newLastName;
  private String newFirstName;
  private String newMiddleName;
  private String newSalutation;
  private String newSuffix;
  private String newStreetAddress;
  private String newCity;
  private String newState;
  private boolean newIsFemale;
  private boolean newIsEmployed;
  private boolean newIsHomeOwner;

  public PersonBuilder()
  {
  }

  public PersonBuilder setNewLastName(String newLastName) {
    this.newLastName = newLastName;
    return this;
  }

  public PersonBuilder setNewFirstName(String newFirstName) {
    this.newFirstName = newFirstName;
    return this;
  }

  public PersonBuilder setNewMiddleName(String newMiddleName) {
    this.newMiddleName = newMiddleName;
    return this;
  }

  public PersonBuilder setNewSalutation(String newSalutation) {
    this.newSalutation = newSalutation;
    return this;
  }

  public PersonBuilder setNewSuffix(String newSuffix) {
    this.newSuffix = newSuffix;
    return this;
  }

  public PersonBuilder setNewStreetAddress(String newStreetAddress) {
    this.newStreetAddress = newStreetAddress;
    return this;
  }

  public PersonBuilder setNewCity(String newCity) {
    this.newCity = newCity;
    return this;
  }

  public PersonBuilder setNewState(String newState) {
    this.newState = newState;
    return this;
  }

  public PersonBuilder setNewIsFemale(boolean newIsFemale) {
    this.newIsFemale = newIsFemale;
    return this;
  }

  public PersonBuilder setNewIsEmployed(boolean newIsEmployed) {
    this.newIsEmployed = newIsEmployed;
    return this;
  }

  public PersonBuilder setNewIsHomeOwner(boolean newIsHomeOwner) {
    this.newIsHomeOwner = newIsHomeOwner;
    return this;
  }

  public Person createPerson() {
    return new Person(newLastName, newFirstName, newMiddleName, newSalutation, newSuffix, newStreetAddress, newCity, newState, newIsFemale, newIsEmployed, newIsHomeOwner);
  }
}
/*
  I prefer to have my Builder as a nested class inside the class whose object it builds, but the NetBeans automatic
  generation of a standalone Builder is very easy to use. Another difference between the NetBeans-generated Builder
  and the Builders I like to write is that my preferred Builder implementations have required fields provided in the
  Builder's constructor rather than provide a no-arguments constructor
*/

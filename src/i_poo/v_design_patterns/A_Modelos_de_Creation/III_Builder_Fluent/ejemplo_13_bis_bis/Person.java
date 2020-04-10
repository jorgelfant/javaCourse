package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_13_bis_bis;

public class Person {
  private final FullName name;
  private final Address address;
  private final Gender gender;
  private final EmploymentStatus employment;
  private final HomeownerStatus homeOwnerStatus;

  /**
   * Parameterized constructor can be private because only my internal builder
   * needs to call me to provide an instance to clients.
   *
   * @param newName       Name of this person.
   * @param newAddress    Address of this person.
   * @param newGender     Gender of this person.
   * @param newEmployment Employment status of this person.
   * @param newHomeOwner  Home ownership status of this person.
   */
  private Person(final FullName newName, final Address newAddress, final Gender newGender, final EmploymentStatus newEmployment,
                 final HomeownerStatus newHomeOwner) {
    this.name = newName;
    this.address = newAddress;
    this.gender = newGender;
    this.employment = newEmployment;
    this.homeOwnerStatus = newHomeOwner;
  }

  public FullName getName() {
    return this.name;
  }

  public Address getAddress() {
    return this.address;
  }

  public Gender getGender() {
    return this.gender;
  }

  public EmploymentStatus getEmployment() {
    return this.employment;
  }

  public HomeownerStatus getHomeOwnerStatus() {
    return this.homeOwnerStatus;
  }

  /**
   * Builder class as outlined in the Second Edition of Joshua Bloch's
   * Effective Java that is used to build a {@link Person} instance.
   */
  public static class PersonBuilder {
    private FullName nestedName;
    private Address nestedAddress;
    private Gender nestedGender;
    private EmploymentStatus nestedEmploymentStatus;
    private HomeownerStatus nestedHomeOwnerStatus;

    public PersonBuilder(final FullName newFullName, final Address newAddress) {
      //obligatorios porque tan como parametros
      this.nestedName = newFullName;
      this.nestedAddress = newAddress;
      //opcionales, esto lo agregue yo, si no agregamos estos tres en el main entonces este sera su valor por defecto
      //sin esto me daria null pa los 3 ultimos
      this.nestedGender = Gender.INCONNU;
      this.nestedEmploymentStatus = EmploymentStatus.INCONNU;
      this.nestedHomeOwnerStatus = HomeownerStatus.INCONNU;
    }

    public PersonBuilder name(final FullName newName) {
      this.nestedName = newName;
      return this;
    }

    public PersonBuilder address(final Address newAddress) {
      this.nestedAddress = newAddress;
      return this;
    }

    public PersonBuilder gender(final Gender newGender) {
      this.nestedGender = newGender;
      return this;
    }

    public PersonBuilder employment(final EmploymentStatus newEmploymentStatus) {
      this.nestedEmploymentStatus = newEmploymentStatus;
      return this;
    }

    public PersonBuilder homeOwner(final HomeownerStatus newHomeOwnerStatus) {
      this.nestedHomeOwnerStatus = newHomeOwnerStatus;
      return this;
    }

    public Person createPerson() {
      return new Person(nestedName, nestedAddress, nestedGender, nestedEmploymentStatus, nestedHomeOwnerStatus);
    }
  }

  @Override
  public String toString() {
    return this.name + " " + this.address + " " + this.gender + " " + this.employment + " " + this.homeOwnerStatus;
  }
}

/*
The last couple of code listings show how a Builder is typically used - to construct an object. Indeed, the item on
the builder (Item #2) in Joshua Bloch's Second Edition of Effective Java is in the chapter on creating (and destroying) object.
However, the builder can help indirectly with non-constructor methods by allowing an easier way to build parameters
objects that are passed to methods.

For example, in the last code listing, the methods have some parameters objects (FullName and Address) passed to them.
It can be tedious for clients to have to construct these parameters objects and the builder can be used to make that
process less tedious. So, although the builder is used for construction in each case, it indirectly benefits non-constructor
methods by allowing for easier use of the parameters objects that reduce a method's argument count.

The new definitions of the FullName and Address classes to be used as parameters objects and using the Builder themselves
are shown next.
*/

//**********************************************************************************************************************
//                                             FullName
//**********************************************************************************************************************

final class FullName {
  private final Name lastName;
  private final Name firstName;
  private final Name middleName;
  private final Salutation salutation;
  private final Suffix suffix;

  private FullName(final Name newLastName, final Name newFirstName, final Name newMiddleName, final Salutation newSalutation, final Suffix newSuffix) {
    this.lastName = newLastName;
    this.firstName = newFirstName;
    this.middleName = newMiddleName;
    this.salutation = newSalutation;
    this.suffix = newSuffix;
  }

  public Name getLastName() {
    return this.lastName;
  }

  public Name getFirstName() {
    return this.firstName;
  }

  public Name getMiddleName() {
    return this.middleName;
  }

  public Salutation getSalutation() {
    return this.salutation;
  }

  public Suffix getSuffix() {
    return this.suffix;
  }

  @Override
  public String toString() {
    return this.salutation + " " + this.firstName + " " + this.middleName + this.lastName + ", " + this.suffix;
  }

  public static class FullNameBuilder {
    private final Name nestedLastName;
    private final Name nestedFirstName;
    private Name nestedMiddleName;
    private Salutation nestedSalutation;
    private Suffix nestedSuffix;

    public FullNameBuilder(final Name newLastName, final Name newFirstName) {
      this.nestedLastName = newLastName;
      this.nestedFirstName = newFirstName;

      nestedSalutation = new Salutation("Desconocido");//EJEMPLO SOLO pa ve rlo que me devolveria..es esto o un ENUM con sus valores
      //se crea el objeto y al no recibir valor alguno en el parametro de FullNameBuilder, retorna el valor que tiene en su toString o null si no hay nada
    }

    public FullNameBuilder middleName(final Name newMiddleName) {
      this.nestedMiddleName = newMiddleName;
      return this;
    }

    public FullNameBuilder salutation(final Salutation newSalutation) {
      this.nestedSalutation = newSalutation;
      return this;
    }

    public FullNameBuilder suffix(final Suffix newSuffix) {
      this.nestedSuffix = newSuffix;
      return this;
    }

    public FullName createFullName() {
      return new FullName(nestedLastName, nestedFirstName, nestedMiddleName, nestedSalutation, nestedSuffix);
    }
  }

}


final class Name {
  private String name;

  public Name(String name) {
    this.name = name;
  }

  public String toString() {
    return this.name;
  }
}

//**********************************************************************************************************************

final class Salutation {
  private String name;

  public Salutation(String name) {
    this.name = name;
  }

  public String toString() {//como sobreescribo el to string el valor da este objeto sera lo que tenga el toString
    return this.name;
  }
}

final class Suffix {

}

//**********************************************************************************************************************
//                                             Adress
//**********************************************************************************************************************
final class Address {
  private final StreetAddress streetAddress;
  private final City city;
  private final State state;

  private Address(final StreetAddress newStreetAddress, final City newCity, final State newState) {
    this.streetAddress = newStreetAddress;
    this.city = newCity;
    this.state = newState;
  }

  public StreetAddress getStreetAddress() {
    return this.streetAddress;
  }

  public City getCity() {
    return this.city;
  }

  public State getState() {
    return this.state;
  }

  @Override
  public String toString() {//si cada clase que ta en los paramtetros define un toString, entonces este return funcionara
    return this.streetAddress + ", " + this.city + ", " + this.state;//y enviara lo que puse en el toString
  }

  public static class AddressBuilder {
    private StreetAddress nestedStreetAddress;
    private final City nestedCity;
    private final State nestedState;

    public AddressBuilder(final City newCity, final State newState) {
      this.nestedCity = newCity;
      this.nestedState = newState;
    }

    public AddressBuilder streetAddress(final StreetAddress newStreetAddress) {
      this.nestedStreetAddress = newStreetAddress;
      return this;
    }

    public Address createAddress() {
      return new Address(nestedStreetAddress, nestedCity, nestedState);
    }
  }
}

final class StreetAddress {

}

final class City {
  private String name;

  public City(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}

enum State {
  ID, GA, INCONNU
}

/*
With the above builders included in the classes, a Person instance can be created as shown in the next code listing.
A more traditional instantiation of a Person instance is shown after that for comparison. (VER EN EL MAIN)
*/
//**********************************************************************************************************************
//                                             Gender
//**********************************************************************************************************************
enum Gender {
  MALE, FEMALE, INCONNU
}

//**********************************************************************************************************************
//                                             EmploymentStatus
//**********************************************************************************************************************
enum EmploymentStatus {
  EMPLOYED, UNEMPLOYED, INCONNU
}

//**********************************************************************************************************************
//                                             HomeownerStatus
//**********************************************************************************************************************
enum HomeownerStatus {
  OWNER, NOTOWNER, INCONNU
}


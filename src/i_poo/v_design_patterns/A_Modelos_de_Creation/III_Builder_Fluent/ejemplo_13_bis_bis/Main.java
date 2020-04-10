package i_poo.v_design_patterns.A_Modelos_de_Creation.III_Builder_Fluent.ejemplo_13_bis_bis;

public class Main {
  public static void main(String[] args) {
    /*
    The Builder can be even nicer when enhanced through use of custom types and parameters objects as outlined
    in my first two posts on the "too many parameters" problem. This is shown in the next code listing
    */

    //******************************************************************************************************************
    //                  Two Examples of Client Code Instantiating a Person with Builders
    //******************************************************************************************************************
    //los parametros obligatorios son los que ponemos en el bilder, y los otros que agregamos como funciones serian OPCIONALEs
    final Person person1 = new Person.PersonBuilder(new FullName.FullNameBuilder(new Name("Dynamite"), new Name("Napoleon")).createFullName(),
      new Address.AddressBuilder(new City("Preston"), State.ID).createAddress()).createPerson();

    final Person person2 = new Person.PersonBuilder(new FullName.FullNameBuilder(new Name("Coltrane"), new Name("Rosco")).middleName(new Name("Purvis")).createFullName(),
      new Address.AddressBuilder(new City("Hazzard"), State.GA).createAddress()).gender(Gender.MALE).employment(EmploymentStatus.EMPLOYED).createPerson();

    System.out.println(person1);//si definimos bien los toString este deberia darme toutes les infos
    System.out.println();
    System.out.println(person1.getName());//null Napoleon nullDynamite, null
    System.out.println(person1.getAddress());//null, Preston, ID
    System.out.println(person1.getGender());//null
    System.out.println(person1.getEmployment());//null
    System.out.println(person1.getHomeOwnerStatus());//null
    //******************************************************************************************************************
    //                             Instantiating a Person Without a Builder
    //******************************************************************************************************************
    //constructor ejemplo_13
    /*
    final Person personNoBuilder = new Person("Coltrane", "Rosco", "Purvis", null,"Hazzard", "Georgia", false, true, true);
     */

    /*

    As the previous code snippets show, the client code for calling a traditional Java constructor is far less readable
    and far easier to mess up than use of the builder classes. The variety of the same types (strings and booleans) and
    the necessity to place nulls in the constructor call for optional attributes make provide many ways for this approach
    to end badly.

    --------------------------------------------------------------------------------------------------------------------
                                           Benefits and Advantages
    --------------------------------------------------------------------------------------------------------------------

    There is a considerable cost to the Builder pattern in that one must essentially double the number of lines of code
    each attribute and for setting those attributes. This price pays off, however, when the client code benefits greatly
    in terms of usability and readability. The parameters to the constructor are reduced and are provided in highly
    readable method calls.

    Another advantage of the Builder approach is the ability to acquire an object in a single statement and state without
    the object in multiple states problem presented by using "set" methods. I am increasingly appreciating the value of
    immutability in a multi-core world and the Builder pattern is perfectly suited for an immutable class when that class
    features a large number of attributes. I also like that there is no need to pass in null for optional parameters to
    the constructor.

    The Builder pattern not only makes the code more readable, but makes it even easier to apply an IDE's code completion
    feature. Further benefits of the Builder pattern when used with constructors are outlined in Item #2 of the Second
    Edition of Effective Java.

   ---------------------------------------------------------------------------------------------------------------------
                                         Costs and Disadvantages
   ---------------------------------------------------------------------------------------------------------------------

   As shown and mentioned above, the number of lines of code of a given class must be essentially doubled for "set" methods
   with the builder approach. Furthermore, although client code is more readable, the client code is also more verbose.
   I consider the benefit of greater readability worth the cost as the number of arguments increase or as more arguments
   share the same type or as the number of optional arguments increase.

   More lines of code in the class with the builder sometimes mean that developers may forget to add support for a new
   attribute to the builder when they add that attribute to the main class. To try to help with this, I like to nest my
   builders inside the class that they build so that it's more obvious to the developer that there is a relevant builder
   that needs to be similarly updated. Although there is still risk of the developer forgetting to add support for a new
   attribute to the builder, this is really no different than the risk of forgetting to add a new attribute to a class's
   toString(), equals(Object), hashCode() or other methods often based on all attributes of a class.

   In my implementation of the Builder, I made the client pass required attributes into the builder's constructor rather
   than via "set" methods. The advantage of this is that the object is always instantiated in a "complete" state rather
   than sitting in an incomplete state until the developer calls (if ever calls) the appropriate "set" method to set
   additional fields. This is necessary to enjoy the benefits of immutability. However, a minor disadvantage of that
   approach is that I don't get the readability advantages of methods named for the field I am setting.

   The Builder, as its name suggests, is really only an alternative to constructors and not directly used to reduce
   the number of non-constructor method parameters. However, the builder can be used in conjunction with parameters
   objects to reduce the number of non-constructor method arguments. Further arguments against use of the Builder for
   object construction can be found in a comment on the A dive into the Builder pattern post.

  ======================================================================================================================
                                              Conclusion
  ======================================================================================================================

   I really like the Builder pattern for constructing objects when I have a lot of parameters, especially if many of
   these parameters are null and when many of them share the same data type. A developer might feel that the extra code
   to implement a Builder might not justify its benefits for a small number of parameters, especially if the few parameters
   are required and of different types. In such cases, it might be considered desirable to use traditional constructors or,
   if immutability is not desired, use a no-argument constructor and require the client to know to call the necessary
   "set" methods.









    */

  }
}


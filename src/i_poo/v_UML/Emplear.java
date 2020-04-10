package i_poo.v_UML;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Emplear {
  public static void main(String[] args) {
/*
    Entreprise entreprise = new Entreprise();
    Poste poste = new Poste(TypePoste.DEVELOPPEUR);
    Poste poste2 = new Poste(TypePoste.TESTEUR);

    entreprise.addPoste(poste);
    entreprise.addPoste(poste2);
    System.out.println(entreprise.getPostesByDep(TypeDepartement.COMPTABILITE));
*/

/*
    for (Poste post : Poste.values()) {
      System.out.println(post);
    }

    System.out.println();

    Departement depa = new Departement(TypeDepartement.DEVELOPPEMENT);
    Poste.ARCHITECTE.setPlacesDispo(5);
    depa.consulterDisponibilitePostes();

 */
/*
    Departement depa = new Departement(TypeDepartement.DEVELOPPEMENT);
    System.out.println(depa.getPoste(Poste.CONCEPTEUR));
    System.out.println();
    depa.getPostes();
    System.out.println();

    Entreprise entreprise = new Entreprise();
    System.out.println(entreprise.getPoste(Poste.DIRECTEUR));
    System.out.println();
    entreprise.getPostes();

    System.out.println();

    Salarie salarie1 = new Salarie(Poste.SECRETAIRE);
    Salarie salarie2 = new Salarie(Poste.SECRETAIRE);
    System.out.println(Poste.SECRETAIRE.getPlacesDispo());
    Salarie salarie3 = new Salarie(Poste.SECRETAIRE);
    System.out.println(salarie3.getTypePoste());
*/
    Departement departement = new Departement(TypeDepartement.DIRECTION);
    departement.embaucherSalarie(new Salarie(Poste.DIRECTEUR));
    departement.embaucherSalarie(new Salarie(Poste.DIRECTEUR));
    departement.getSalaries();

    System.out.println();
    Departement departement1 = new Departement(TypeDepartement.DEVELOPPEMENT);
    departement1.embaucherSalarie(new Salarie(Poste.DEVELOPPEUR));
    departement1.embaucherSalarie(new Salarie(Poste.DEVELOPPEUR));

    departement1.getSalaries();
    System.out.println(Poste.DIRECTEUR.getPlacesDispo());
    System.out.println(Poste.DIRECTEUR.getStatusPoste());

    System.out.println(Poste.DEVELOPPEUR.getPlacesDispo());
    System.out.println(Poste.DEVELOPPEUR.getStatusPoste());
  }
}

class Person {
  private final FullName name;
  private final Address address;
  private final Gender gender;
  private final EmploymentStatus employment;

  private Person(final FullName newName, final Address newAddress, final Gender newGender, final EmploymentStatus newEmployment) {
    this.name = newName;
    this.address = newAddress;
    this.gender = newGender;
    this.employment = newEmployment;
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

  public static class PersonBuilder {
    private FullName nestedName;
    private Address nestedAddress;
    private Gender nestedGender;
    private EmploymentStatus nestedEmploymentStatus;

    public PersonBuilder(final FullName newFullName, final Address newAddress) {
      //obligatorios porque tan como parametros
      this.nestedName = newFullName;
      this.nestedAddress = newAddress;
      //opcionales, esto lo agregue yo, si no agregamos estos tres en el main entonces este sera su valor por defecto
      //sin esto me daria null pa los 3 ultimos
      this.nestedGender = Gender.INCONNU;
      this.nestedEmploymentStatus = EmploymentStatus.INCONNU;
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


    public Person createPerson() {
      return new Person(nestedName, nestedAddress, nestedGender, nestedEmploymentStatus);
    }
  }

  @Override
  public String toString() {
    return this.name + " " + this.address + " " + this.gender + " " + this.employment;
  }

}

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

//**********************************************************************************************************************
//                                             Name
//**********************************************************************************************************************

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
//                                             Salutation
//**********************************************************************************************************************

final class Salutation {
  private String name;

  public Salutation(String name) {
    this.name = name;
  }
}

//**********************************************************************************************************************
//                                             Suffix
//**********************************************************************************************************************
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
//**********************************************************************************************************************
//                                             StreetAdress
//**********************************************************************************************************************

final class StreetAddress {

}

//**********************************************************************************************************************
//                                             City
//**********************************************************************************************************************
final class City {
  private String name;

  public City(String name) {
    this.name = name;
  }

  public String toString() {
    return name;
  }
}

//**********************************************************************************************************************
//                                               State
//**********************************************************************************************************************
enum State {
  ID, GA, INCONNU
}

//**********************************************************************************************************************
//                                                Gender
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
//                                                  Mariage
//**********************************************************************************************************************
final class Mariage {
  private Calendar dateMariage;
  private final Person one;
  private final Person two;


  public Mariage(final Person one, final Person two) {
    this.one = one;
    this.two = two;
    this.dateMariage = GregorianCalendar.getInstance();
  }

  public Calendar getDateMariage() {
    return dateMariage;
  }
}

//**********************************************************************************************************************
//                                                  ENTREPRISE
//**********************************************************************************************************************
class Entreprise {

  private ArrayList<Departement> departaments = new ArrayList<>();

  public Entreprise() {
    addDepartement(new Departement(TypeDepartement.RESSOURCESHUMAINES));
    addDepartement(new Departement(TypeDepartement.COMPTABILITE));
    addDepartement(new Departement(TypeDepartement.DEVELOPPEMENT));
    addDepartement(new Departement(TypeDepartement.DIRECTION));

  }

  //*************************************************||gerSalaries||****************************************************
  public void getAllSalaries() {
    for (Departement depa : departaments) {
      depa.getSalaries();
    }
  }

  public Salarie getSalarieById(Integer id) {
    for (Departement depa : departaments) {
      depa.getSalarieById(id);
    }
    return null;
  }

  public Salarie getSalariesbyDep(Departement departement) {
    for (Departement depa : departaments) {
      if (depa.getTypeDepartement() == departement.getTypeDepartement())
        depa.getSalaries();
    }
    return null;
  }

  public Salarie getSalarieByPoste(Poste poste) {
    for (Departement depa : departaments) {
      depa.getSalarieByPoste(poste);
    }
    return null;
  }

  //*************************************************||embaucher||******************************************************

  public void embaucherSalarie(Salarie salarie) {//
    for (Departement departement : departaments) {
      departement.embaucherSalarie(salarie);
    }
  }

  //*************************************************||licencier||******************************************************
  public void licencierSalarie(Salarie salarie) {
    for (Departement departement : departaments) {
      departement.licencierSalarie(salarie);
    }
  }


  //**********************************************************************************************************************
  public void addDepartement(Departement departement) {
    this.departaments.add(departement);
  }

  public void effacerDepartement(Departement departement) {
    this.departaments.remove(departement);
  }

  //********************************************************************************************************************
  public void getdepartaments() {
    for (Departement depa : departaments) {
      System.out.println(depa);
    }
  }

  public void getdepartamentbyType(TypeDepartement typeDepartement) {
    for (Departement depa : departaments) {
      System.out.println(depa);
    }
  }

  //**********************************************************************************************************************
  /*
  public void addPoste(Poste poste) {
    for (Departement depa : departaments) {
      depa.addPoste(poste);
    }
  }
*/
  public void getPostesByDep(TypeDepartement typeDepartement) {
    for (Departement departement : departaments) {
      if (departement.getTypeDepartement() == typeDepartement) {
        departement.getPostes();
      }
    }
  }

  //********************************************||getPoste||******************************************************
  public Poste getPoste(Poste poste) {
    for (Departement departement : departaments) {
      if (departement.getTypeDepartement() == poste.getTypeDepartement()) {
        return departement.getPoste(poste);
      }
    }
    return null;
  }

  public void getPostes() {
    for (Departement departement : departaments) {
      departement.getPostes();
    }
  }


  //**************************************************||prime||*********************************************************
  public void prime(Salarie salarie) {

  }
}

//**********************************************************************************************************************
//                                                  TypeDepartement
//**********************************************************************************************************************
enum TypeDepartement {
  RESSOURCESHUMAINES, COMPTABILITE, DEVELOPPEMENT, DIRECTION
}

//**********************************************************************************************************************
//                                            DEPARTEMENT
//**********************************************************************************************************************

class Departement {
  private ArrayList<Salarie> salaries = new ArrayList<>();
  private TypeDepartement typeDepartement;
  private Poste typePoste;

  //constructor
  public Departement(TypeDepartement typeDepartement) {
    this.typeDepartement = typeDepartement;
  }

  //agregar departement a la empresa
  public Departement addDepartement(Entreprise entreprise) {
    entreprise.addDepartement(this);
    return this;
  }

  public TypeDepartement getTypeDepartement() {
    return this.typeDepartement;
  }

  public void getPostes() {
    for (Poste poste : Poste.values()) {
      if (this.typeDepartement == poste.getTypeDepartement()) {
        System.out.println(poste);
      }
    }
  }

  public Poste getPoste(Poste post) {
    if (this.typeDepartement == post.getTypeDepartement()) {
      return post;
    }
    return null;
  }


  public void consulterDisponibilitePostes() {
    for (Poste poste : Poste.values()) {
      if (poste.getPlacesDispo() > 0) {
        System.out.println(poste + ": Nombre de places disponibles pour ce poste: " + poste.getPlacesDispo());
      }
    }
  }

  public void consulterDisponibilitePoste(Poste post) {
    for (Poste poste : Poste.values()) {
      if (poste == post) {
        System.out.println("Nombre de places disponibles pour ce poste: " + post.getPlacesDispo());
      }
    }
  }

  public void getSalaries() {
    for (Salarie salarie : salaries) {
      if (this.typeDepartement == salarie.getTypeDepartement()) {
        System.out.println(salarie);
      }
    }
  }


  public Salarie getSalarieByPoste(Poste poste) {
    for (Salarie salarie : salaries) {
      if (salarie.getTypePoste() == poste) {
        return salarie;
      }
    }
    return null;
  }

  public Salarie getSalarieById(Integer id) {
    for (Salarie salarie : salaries) {
      if (salarie.getId() == id) {
        return salarie;
      }
    }
    return null;
  }

  //agregar Salarie
  public void embaucherSalarie(Salarie salarie) {
    if (this.typeDepartement == salarie.getTypeDepartement()) {
      if (salarie.getTypePoste().getPlacesDispo() != 0) {
        this.salaries.add(salarie);
        System.out.println("Ajout de " + salarie + " effectué avec succès");
        salarie.getTypePoste().setPlacesDispo(salarie.getTypePoste().getPlacesDispo() - 1);
      } else {
        System.out.println("Ajout de " + salarie + " impossible");
      }
    }
  }

  //Licencier Salarie
  public void licencierSalarie(Salarie salarie) {
    if (this.typeDepartement == salarie.getTypeDepartement()) {
      this.salaries.remove(salarie);
      System.out.println("suppression de " + salarie + " effectué avec succès");
    }
  }

  //********************************************************************************************************************
  @Override
  public String toString() {
    return this.typeDepartement.name();
  }
}

//**********************************************************************************************************************
//                                                   Poste
//**********************************************************************************************************************
enum Poste {
  SECRETAIRE(TypeDepartement.RESSOURCESHUMAINES, 1500, "Gerer l'agenda du directeur", 2),
  ASSISTANTE(TypeDepartement.RESSOURCESHUMAINES, 1800, "Aider la secretaire", 1),
  COMPTABLE(TypeDepartement.COMPTABILITE, 2000, "Gerer les comptes de l'entreprise", 1),
  GESTIONNAIRE(TypeDepartement.COMPTABILITE, 2500, "Gerer Les Dossiers", 1),
  DEVELOPPEUR(TypeDepartement.DEVELOPPEMENT, 3000, "Gérer le développement de l'application", 3),
  TESTEUR(TypeDepartement.DEVELOPPEMENT, 1500, "Tester le logiciel", 2),
  ARCHITECTE(TypeDepartement.DEVELOPPEMENT, 3500, "Gérer la structure de l'application", 2),
  CONCEPTEUR(TypeDepartement.DEVELOPPEMENT, 3000, "Concevoir l'application", 2),
  DIRECTEUR(TypeDepartement.DIRECTION, 5000, "Gérer l'entreprise", 1);

  private TypeDepartement typeDepartement;
  private Integer placesDispo;
  private Integer salaire;
  private String tache;
  private StatusPoste statusPoste = StatusPoste.VACANT;

  Poste(TypeDepartement typeDepartement, int salaire, String tache, Integer placesDispo) {
    this.typeDepartement = typeDepartement;
    this.salaire = salaire;
    this.tache = tache;
    this.placesDispo = placesDispo;
  }

  public TypeDepartement getTypeDepartement() {
    return typeDepartement;
  }

  public void setSalaire(int salaire) {
    this.salaire = salaire;
  }

  public Integer getSalaire() {
    return salaire;
  }

  public void setTache(String tache) {
    this.tache = tache;
  }

  public String getTache() {
    return tache;
  }

  public void setStatusPoste(StatusPoste statusPoste) {
    this.statusPoste = statusPoste;
  }

  public StatusPoste getStatusPoste() {
    if(placesDispo==0){
      return StatusPoste.OCCUPIED;
    }else{
      return this.statusPoste;
    }
  }

  public void setPlacesDispo(Integer placesDispo) {
    this.placesDispo = placesDispo;
  }

  public Integer getPlacesDispo() {
    return this.placesDispo;
  }

  public Poste getPoste() {
    return this;
  }

  public String toString() {
    return "Poste: " + this.name() + ", Departement: " + this.typeDepartement + ", Tâche: " + this.tache + ", Postes disponibles: " + this.placesDispo;
  }
}

//**********************************************************************************************************************
//                                                 StatusPoste
//**********************************************************************************************************************
enum StatusPoste {
  VACANT, OCCUPIED
}

//**********************************************************************************************************************
//                                                 Salarie
//**********************************************************************************************************************
class Salarie {
  private boolean prime;
  private Poste poste;
  private Person person;
  private static Integer idAssocie = 1;
  private Integer id;

  public Salarie(Poste poste) {
    this.poste = poste;
    this.id = idAssocie++;

  }

  public Salarie(Poste poste, Person person) {
    this.poste = poste;
    this.person = person;
    this.id = idAssocie++;

  }

  public Salarie addSalarie(Departement departement) {
    departement.embaucherSalarie(this);
    return this;
  }

  public int getId() {
    return this.id;
  }

  public TypeDepartement getTypeDepartement() {
    return poste.getTypeDepartement();
  }

  public Poste getTypePoste() {
    return this.poste;
  }

  public void setStatusPoste(StatusPoste statusPoste) {
    this.poste.setStatusPoste(statusPoste);
  }

  public StatusPoste getStatusPoste() {
    return this.poste.getStatusPoste();
  }

  public void setSalaire(int salaire) {
    this.poste.setSalaire(salaire);
  }

  public Integer getSalaire() {
    return this.poste.getSalaire();
  }

  public void setPrime(int prime) {
    setSalaire(prime + getSalaire());
  }

  public void setTache(String tache) {
    this.poste.setTache(tache);
  }

  public String getTache() {
    return this.poste.getTache();
  }

  @Override
  public String toString() {
    return this.poste.name();
  }
}



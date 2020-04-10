package i_poo.v_design_patterns.C_Modelos_de_Comportamiento.IV_Iterateur;

public class Exemple_II {
  public static void main(String[] args) {
//======================================================================================================================
//                       3) Use the NameRepository to get iterator and print names.
//======================================================================================================================
    NameRepository namesRepository = new NameRepository();

    for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
      String name = (String) iter.next();
      System.out.println("Name : " + name);
    }
    /*Resultat
       Name : Robert
       Name : John
       Name : Julie
       Name : Lora
    */
  }
}

/*
Iterator pattern is very commonly used design pattern in Java and .Net programming environment. This pattern
is used to get a way to access the elements of a collection object in sequential manner without any need to
know its underlying representation.

Iterator pattern falls under behavioral pattern category.
*/
//======================================================================================================================
//                                            Implementation
//======================================================================================================================
/*
We're going to create a Iterator interface which narrates navigation method and a Container interface which
retruns the iterator . Concrete classes implementing the Container interface will be responsible to implement
Iterator interface and use it

IteratorPatternDemo, our demo class will use NamesRepository, a concrete class implementation to print a Names
stored as a collection in NamesRepository.

                                                  Interface                             Interface
                                         ------------------------------           -------------------------
                                         |         Container          |           |    Iterator           |
                                         ------------------------------           -------------------------
                                         |                            |           |                       |
                                         ------------------------------           -------------------------
                                         |                            |           | + hasNext() : boolean |
                                         | + getIterator() : iterator |           | + next() : Object     |
                                         ------------------------------           -------------------------
                                                       /\                                     /\
                                                       |                                      |
                                                       | implements                           | implements
                                                       |                                      |
 ------------------------------          ------------------------------            -------------------------
 |          MAIN              |          |       NameRepository       |            |      NameIterator     |
 ------------------------------          ------------------------------            -------------------------
 |                            | -------> | - name : String[]          | ---------> |                       |
 ------------------------------          ------------------------------            -------------------------
 |                            |          | + getIterator() : Iterator |            | + hasNext() : boolean |
 | + getIterator() : iterator |          |                            |            | + next() : Object     |
 ------------------------------          ------------------------------            -------------------------
*/
//======================================================================================================================
//                                            1) Create interfaces.
//======================================================================================================================
interface Iterator {
  public boolean hasNext();
  public Object next();
}

interface Container {
  public Iterator getIterator();
}

//======================================================================================================================
//                     2) Create concrete class implementing the Container interface.
//                        This class has inner class NameIterator implementing the Iterator interface.
//======================================================================================================================
class NameRepository implements Container {
  public String names[] = {"Robert", "John", "Julie", "Lora"};

  @Override
  public Iterator getIterator() {
    return new NameIterator();
  }
  //class interne
  private class NameIterator implements Iterator {

    int index;

    @Override
    public boolean hasNext() {
      if (index < names.length) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      if (this.hasNext()) {
        return names[index++];
      }
      return null;
    }
  }
}
















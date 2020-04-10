package i_poo.q_collections.collections_VIII_IX_TreeSet_Comparable_Comparator;

import java.util.TreeSet;

public class TreeSet_principal {
    public static void main(String[] args) {

        //collection TreeSet , se utiliza bastante  arboles
    /*

                                                             INTERFACE
          VENTAJAS                                     ********************                        DESVENTAJAS
                                                       *   Collection     *
    *No permite elementos duplicados                   *******************          * no tiene acceso aleatorio
                                                                |
    *Uso sencillo del metodo add que                            |                   * Poca eficiencia a la hora de ordenar
     ademas asegura no elementos                             INTERFACE                 elementos (y no siempre se puede)
     duplicados.                                       ********************
                                                       *        Set       *
                                                       ********************
                                                                |
                                                                |
                                                                |
              /---------------------------------------------------------------------------------------------------\
            /                    |                     |              \                   \                       \
        Class                  Class                 Class             Class              Class                    Class
    ************        *******************       ***********       ***********      **************     ************************
      HashSet   *       *  LinkedHashSet  *       * TreeSet *       * EnumSet *      *CopyOnWrite *     *ConcurrentSkipListSet *
    ************        *******************       ***********      ************       ArraySet    *     ************************

    Rapida.             .Ordenacion x entrada.    .Es ordenado.    .La mejor para    .Especifico        .Especifico concurrencia.
                                                                    tipos enumer_     concurrencia.
    No duplicados.      .Eficiente al acceder.    .Poco eficient.   ados.                               .Admite ordenacion.
                                                                                     .Eficiente
    No ordenacion.      .No eficiente al                                              lectura.          .con muchos elementos no
                         agregar.                                                                        es suficiente.
    No acceso aleat.                                                                 .Poca eficien_
                                                                                      cia escritura.

                                                                                     .Poco eficiente
                                                                                      al eliminar.

    */

        //Vemos que en el caso de TreeSet si podemos ordenar los elementos que se encuentran en la collection y esta es una
        //diferencia en relacion a HashSet que vimos en los primeros ejemplos(que es desordenado)

        /*COMENTAMOS NUESTRO TreeSet String
        TreeSet<String> ordenarPersonas = new TreeSet<>();
        ordenarPersonas.add("Sandra");
        ordenarPersonas.add("Luis");
        ordenarPersonas.add("Raul");


        for (String indice : ordenarPersonas) {
            System.out.println(indice);
        }
        */
        //lo imprime en orden alfabetico  Luis Raul Sandra

        //ya que el TreeSet esta ordenado par default, y por defecto si se trata de Strings
        //el orden es Luis Raul Sandra  osea orden alfabetico

        //Y esto es porque la class String, implementa la Interface "Compabarable" y esta interface
        //tiene el metodo "compareTo"

        //La Collection de tipo TreeSeet utiliza la Interface del tipo de objeto que almacena en su interior
        //para comparar esos objetos entre si y asi compararlos

        /*
         Class String
            java.lang.Object
                 java.lang.String

            All Implemented Interfaces:
                  Serializable, CharSequence, Comparable<String>


         public final class String
         extends Object
         implements Serializable, Comparable<String>, CharSequence


        ****************************************************************************************************************
         TreeSet

         java.lang.Object
                java.util.AbstractCollection<E>
                        java.util.AbstractSet<E>
                                  java.util.TreeSet<E>

          Type Parameters:
                 E - the type of elements maintained by this set
          All Implemented Interfaces:
                  Serializable, Cloneable, Iterable<E>, Collection<E>, NavigableSet<E>, Set<E>, SortedSet<E>

          public class TreeSet<E>
          extends AbstractSet<E>
          implements NavigableSet<E>, Cloneable, Serializable

          A NavigableSet implementation based on a TreeMap. The elements are ordered using their natural ordering,
          or by a Comparator provided at set creation time, depending on which constructor is used.

          Note that the ordering maintained by a set (whether or not an explicit comparator is provided) must be
          consistent with equals if it is to correctly implement the Set interface. (See Comparable or Comparator
          for a precise definition of consistent with equals.) This is so because the Set interface is defined in
          terms of the equals operation, but a TreeSet instance performs all element comparisons using
          its compareTo (or compare) method, so two elements that are deemed equal by this method are, from the
          standpoint of the set, equal. The behavior of a set is well-defined even if its ordering is inconsistent
          with equals; it just fails to obey the general contract of the Set interface.
        */

        //que pasa si la clase de no es un String ( que ya tiene implementado el metodo comparaTo )
        //a traves de la interface Comparable<String>
        //sino otra hecha por nosotros .

        //Que hacer en ese caso ? Pues asegurarme que mi clase, implements comparable<T>
        //para iniciar su metodo compareTo()  que return un int en funcion de si un elemento es mayor menor o igual
        //al otro

        Articulo primero = new Articulo(1, "Primer Articulo");
        Articulo segundo = new Articulo(2, "Segundo Articulo");
        Articulo tercero = new Articulo(3, "Tercer Articulo");

        TreeSet<Articulo> articulos1 = new TreeSet<>();
        articulos1.add(tercero);
        articulos1.add(primero);
        articulos1.add(segundo);

        //Se ordenaran en funcion del numeroArticulo, no importa en que orden hayan sido ingresados a la Collection
        //ya que es asi como lo establecimos en el metodo compareTo de la class Articulo implements Comparable
        for (Articulo indice : articulos1) {
            System.out.println(indice.getDescription());
        }
        //Esto asi como lo vemos suele tener algun problema, que pasa si necesito crear otra Collection de tipo TreeSet
        //diferente de Articulos en la cual el ordenamiento no se produzca por numero de articulo, sino que el ordenamiento
        //lo haga en base a la description, es decir ordenamiento por orden alfabetico.

        //La cosa se pone complicada porque no podemos implementar 2 veces la Interface Comparable<T>
        //y tampoco podemos CREAR 2 METODOS compareTo()   uno para que ordene por numeroArticulo
        // y otro para que ordene por orden alfabetico

        //Y otro problema mas importante que pasa si necesitamos crear otra Collection de tipo TreeSet<> que almacene
        // en su interior objetos QUE NO IMPLEMENTAN LA INTERFACE Comparable<T>

        //Imaginemos que se otro programador ha creado unos objetos de una clase que funcionan bien, y que deseamos
        //almacenar esos objetos de esta clase, en un TreeSet<> pero que el programador que hizo esto, no implemento
        //en su clase, la Interface Comparable<T> poruq eNO PENSABA ORDENARLOS EN UN FUTURO EN UN TreeSet<>

        //Resumiendo : hacemos una clase con muchos metodos , parametros etc, pero nunca implementamos
        //Comparable<T> porqu eno pensabamos ponerla en una collection TreeSet<> luego pa ordenarlo.
        //( talvez con el metodo burbuja ? ) bref

        //QUE HACER?? PASAMOS A VIDEO IX
        //Habiamos creado un TreeSet<String> string par default ya tiene implementada la interface Comparable y definido
        //el metodo compareTo. Luego creamos una clase propia que implementaba Comparable<T>
        // iniciamos el metodo comparaTo y luego la pusimos en un TreeSet<> donde se ordenaba por numero de articulo

        //AHORA que hacer si queremos ordenar en funcion de otro criterio ( sabiendo que no podemos implementar 2 veces
        //Comparable<T> ni redefinir 2 veces el metodo  compareTo

        //Como hacemos si queremos ordenarlo por String.....y otra cosa como ordenar si nuestra clase no implementa
        //Comparable<T> que nos permite implementar el metodo compareTo()

        //**************************************************************************************************************
        //           ESTO LO HACEMOS IMPLEMENTANDO OTRA INTERFACE DIFERENTE A Comparable<T>
        //**************************************************************************************************************

        //Si volvemos a la class TreeSet<E>  vemos que esta clase tiene varios constructores
        /*
           El que hemos estado usando hasta ahora es el primer constructor por defecto
           y tiene otros constructores, si vemos el 3ro y vemos su description
           nos dice que construye un TreeSet vacio, ordenado de acuerdo con el Comparator especificado
           y si pulsamos en Comparator vemos que se trata de otra Interface
     *******************************************************************************************************************
           Interface Comparator<T>

           Type Parameters:
                T - the type of objects that may be compared by this comparator
           All Known Implementing Classes:
                Collator, RuleBasedCollator


           Methods
           -------
           Modifier and Type	                          Method and Description
           -----------------                              ----------------------
           int	                                          compare(T o1, T o2)   (no confundir con compareTo(T o) de Comparable<E>)
                                                          Compares its two arguments for order.

           boolean	                                      equals(Object obj)
                                                          Indicates whether some other object is "equal to" this comparator.


         si cliqueamos en el metodo Compare vemos que es exactamente el mismo que Comparable<T>
         Returns:
         a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.

         Asi gracias a que el tercer constructor de TreeSet<E> admite un comparator como argumento pues podemos
         crear un objeto de tipo Comparator<T> con el metodo compare(T o1, T o2) en su interior que trabaje como queremos
         y pasarse ese objeto a nuestra collection TreeSet(Comparator<? super E> comparator)  como argumento
         y de esta forma logramos ordenar nuestro TreeSet de acuerdo a otro criterio y asi solventar el problema de que
         si el objeto que estamos almacenando dentro del TreeSet NO IMPLEMENTS COMPARABLE pues de cualquier forma
         conseguir ORDENARLO.

         ASI VAMOS DE VUELTA A NUESTRA CLASE ARTICULOS

         TreeSet(Comparator<? super E> comparator)
         Constructs a new, empty tree set, sorted according to the specified comparator.
    ********************************************************************************************************************

         Constructors
         ------------
         Constructor and Description
         ---------------------------
         TreeSet()
         Constructs a new, empty tree set, sorted according to the natural ordering of its elements.

         TreeSet(Collection<? extends E> c)
         Constructs a new tree set containing the elements in the specified collection, sorted according to the natural ordering of its elements.

         TreeSet(Comparator<? super E> comparator)
         Constructs a new, empty tree set, sorted according to the specified comparator.

         TreeSet(SortedSet<E> s)
         Constructs a new tree set containing the same elements and using the same ordering as the specified sorted set.
        */
        System.out.println();

        //creamos un obeto de tipo Commparator<T> para pasarselo al TreeSet<> por parametro
        //No necesitamos un objeto articulo que tenga parametros, numeroArticulo y description
        //porque este objeto esta unicamente destinado a comparar utilizando la Interface Comparator<T> y el metodo
        // compare(t o1,t 02)

        //Por ese motivo hacemos en la clase Articulo un constructor par default (no es la solucion mas elegante)
        //MAS tarde veremos una forma mas eficaz


        Articulo comparadorArticulos = new Articulo();

        Articulo uno = new Articulo(1, "Polo");
        Articulo dos = new Articulo(2, "Chompa");
        Articulo tres = new Articulo(3, "Sweater");

/*
        TreeSet(Comparator<? super E> comparator)
        Constructs a new, empty tree set, sorted according to the specified comparator.
*/
        //Ahora creamos el TreeSet                    //Comparator por parametro
        TreeSet<Articulo> articulos2 = new TreeSet<Articulo>(comparadorArticulos);//En este treeSet se van a almacernar
        //conseguimos con esto decir al programas que en este TreeSet los objetos se van a almacenar ordenados, segun
        //lo que marque el Comparator del parametro

        articulos2.add(uno);                                       //ordenados segun lo que marque el Comparator
        articulos2.add(dos);
        articulos2.add(tres);
        //IMPRIME ORDENADO POR ORDEN ALFABETICO
        for (Articulo indice : articulos2) {
            System.out.println(indice.getDescription());
        }


        //Toodo lo que hicimos solventa parte de los problemas, podemos ordenar los elementos de 2 formas diferentes
        //implementado 2 interfaces Comparable<T>  y Comparator<T>  y sus metodos compareTo(T o )
        //y Comporator(T o1, T o2)

        //PERO AUN NO NOS ARREGLA EL PROBLEMA DE SABER QUE HACES SI SE CREA UN TreeSet y la clase generica que recible
        //en parametro  TreeSet<claseGenerica>   no hay implementado La Interface de ordenacion Comparable o Comparator
        //y entonces los objetos no se ordenan
        //Lo VEREMOS EN LA SIGUIENTE ETAPA creando una CLASE INTERNA
    }
}

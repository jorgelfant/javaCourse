package i_poo.q_collections.collections_VI_VII_linkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedList_principal {
    public static void main(String[] args) {

        //LinkedList   o listas enlazadas
        //ListIterator puede modificar en cualquier direccion , es decir hacia adelante o hacia atras
        //agrega y elimina rapido, accede lentamente a los elementos
        //Parecida a ArrayList, implementan ambas  ambas a la Interface List

        //Diferencia entre ArrayList y LinkedList: La EFICIENCIA , diferencia principal
        /*
               ArrayList                                                 LinkedList

    Almacenamos una serie de datos en                                 Un LinkedList funciona de manera diferente
    en cada una de las posiciones de este AL                          En vez de almacenar los elementos en posiciones
                                                                      adjacentes de la memoria, lo que hace es
    Los ArrayList cuando los construimos lo                           almacenarlo en lo que llamamos un "Nodo"
    que hacen es almacenar datos en posiciones                        Un "Nodo" consta de 3 partes :
    adjacentes (uno al lado del otro) de la
    memoria de nuestro pc.                                                     *******************************
                                                                Enlace---->    *     *      Dato       *     *   <----Enlace
    Es decir que se reserva un espacio en la memoria                           *******************************
    para almacenar cada uno de estos datos y estos                           \                                /
    espacios son adjacentes (pegados unos a otros)                             -------------------------------
                                                                                           Nodo
    cuando queremos eliminar uno de estos elementos.
    Una vez que lo eliminamos estamos obligados a                     La parte central para almacenar el dato, el
    cubrir ese espacio que ha dejado libre el elemento                elemento, y las 2 extremidades que corresponden
    eliminado. ES decir que todos los elementos que                   a los enlaces o links. Estos enlaces lo que
    le seguian deben subir para correrse de un espacio                hacen es apuntar al elemento anterior dentro
    y reordenar el AL. Y esto en terminos de memoria                  de la LinkedList y al elemento siguiente.
    es muy poco eficiente.                                            que no tiene porque estar en posiciones adjacentes
                                                                      de la memoria, de tal forma que si tenemos una
    Si quisiera suprimir por ejemplo el objeto del                    LinkedList de varios elementos estos quedan enlazados
    indice 2, los elementos que vienen despues se
    desplazan pa llenar el vacio: Esto consume
    muchos recursos.

            *************         *************                              ****************************
       0    *   Dato1   *         *   Dato1   *                              *    *      Dato1     *    *_______    2
            *************         *************                              ****************************      |
            *************         *************                        ________________________________________
       1    *   Dato2   *         *   Dato2   *                       |       ***************************
            *************         *************                       -------*    *      Dato2     *    *-------    D 1 y 3
            *************         *************                              ****************************      |
       2    *   Dato3   *         *   Dato4   *                        ----------------------------------------
            *************         *************                       |      ****************************
            *************         *************                       -------*    *      Dato3     *    *-------    2 y 4
       3    *   Dato4   *         *   Dato5   *                              ****************************      |
            *************         *************                         ---------------------------------------
            *************         *************                        |     ****************************
       4    *   Dato5   *         *   Dato6   *                        ------*    *      Dato4     *    *-------
            *************         *************                              ****************************      |     3 y 5
            *************         *************                         _______________________________________
       5    *   Dato6   *         *   Dato7   *                        |     ****************************
            *************         *************                         -----*    *      Dato5     *    *            4
            *************         *************                              ****************************
       6    *   Dato7   *         *   Dato8   *
            *************         *************                        A travez de estos enlaces un elemento enlaza otro
            *************                                              y para estos nos servimos de los enlaces o links
       7    *   Dato8   *
            *************                                              Imaginemos que por ejemplo queremos mover el
                                                                       elemento del medio a otro lugar? Pues daria igual
                                                                       ya que este seguiria enlazado (linked) al elemento
                                                                       anterior y al elemento siguiente.

                                                                       No es como con ArrayList donde el espacio vacio
                                                                       debia ser cubierto por los otros elementos.

                                                                       que ocurre si queremos eliminar un elemento de la
                                                                       LinkedList? pues lo unico que hay que hacer es
                                                                       actualizar los enlaces:
                                                                       ejemplo si eliminamos por ejemplo el elemento
                                                                       del medio , actualizamos los enlazes

                                                                       ****************************
                                                                       *    *      Dato1     *    *_______    Dato2
                                                                       ****************************      |
                                                                 ________________________________________
                                                                |       ***************************
                                                                -------*    *      Dato2     *    *-------    Dato 1 y 4
                                                                       ****************************      |
                                                                 ----------------------------------------
                                                                |
                                                                -------------------------------------------
                                                                                                          |
                                                                  ---------------------------------------
                                                                 |     ****************************
                                                                 ------*    *      Dato4     *    *-------
                                                                       ****************************      |    Dato 2 y 5
                                                                  _______________________________________
                                                                 |     ****************************
                                                                  -----*    *      Dato5     *    *            Dato4
                                                                       ****************************

                                                                 Y esto en terminos de eficiencia es mucho menos costoso
                                                                 que lo que tiene que hacer un ArrayList

                                                                 si estamos agregando por ejemplo constantemente elementos
                                                                 y eliminando, LinkedList sera mucho mas eficiente

         Api:

         java.lang.Object
                     java.util.AbstractCollection<E>
                                      java.util.AbstractList<E>
                                                   java.util.AbstractSequentialList<E>
                                                                       java.util.LinkedList<E>

         Type Parameters:
              E - the type of elements held in this collection

         All Implemented Interfaces:
              Serializable, Cloneable, Iterable<E>, Collection<E>, Deque<E>, List<E>, Queue<E>

         public class LinkedList<E>                             clase generica
              extends AbstractSequentialList<E>
              implements List<E>, Deque<E>, Cloneable, Serializable
         */

        //clase generica podemos trabajar con WRAPPERS , o clase String
        LinkedList<String> personas = new LinkedList<>();//los elementos se agregan al final cada vez por defecto
        personas.add("Maria");
        personas.add("Jorge");
        personas.add("July");
        personas.add("Jorge Emilio");
        personas.add("Gerardo");
        personas.add("Carol");
        personas.add("Claudia");

        //personas.add(1, "Teresa");//agregar en una posicion dada, facil cuando no hay muchos elementos
        //pero si hay muchos elementos lo mas probable es que no sepamos exactamente donde ponerlo
        //pero a lo mejor si sabemos al costado de que elemento quiero agregar al nuevo elemento
        // En ese casotendremos que trabajar con ITERADORES

        //En el video anterior manejamos unicamente Iterator, sin embargo
        //tambien existe el
        //ListIterator<E>

        /*
        ListIterator<E>	               listIterator(int index)
                                       Returns a list-iterator of the elements in this list (in proper sequence),
                                       starting at the specified position in the list.

        See Also:
          Collection, ListIterator, Iterable

        *Iterator solo tenia 3 metodos : esto funciona bien con listas de hashSet porque no llevan orden ninguno
          next()  hasNext()    remove

         Pero cuando estoy usando una lista que si lleva ordenamiento estos metodos no me sirven
         porque a lo mejor yo quiero moverme hacia atras y ninguno de los 3 metodos de la Interface Iterator
         me permiten moverme hacia atras, solo hacia adelante.

         A lo mejor yo quiero ver que elemento tengo en mi lista 2 posiciones atras....se me queda corta

         En la interface Iterator<E> se nos aconsejaba tambien mirar:
         See Also:
          Collection, ListIterator, Iterable

         Y si vamos a "ListIterator" esta interface ya si que tiene metodos que me permiten moverme al siguiente
         al anterior, eliminar un elemento, preguntar si hay un elemento mas etc:

                Modifier and Type	                Method and Description
                ----------------                    -----------------------
                void	                            add(E e)
                                                    Inserts the specified element into the list (optional operation).

                boolean	                            hasNext()
                                                    Returns true if this list iterator has more elements when
                                                    traversing the list in the forward direction.

                boolean	                            hasPrevious()
                                                    Returns true if this list iterator has more elements when
                                                    traversing the list in the reverse direction.

                E	                                next()
                                                    Returns the next element in the list and advances the cursor position.

               int	                                nextIndex()
                                                    Returns the index of the element that would be returned
                                                    by a subsequent call to next().

               E	                                previous()
                                                    Returns the previous element in the list and moves the cursor p
                                                    osition backwards.

               int	                                previousIndex()
                                                    Returns the index of the element that would be returned by a
                                                    subsequent call to previous().

               void	                                remove()
                                                    Removes from the list the last element that was returned by next()
                                                    or previous() (optional operation).

               void	                                set(E e)
                                                    Replaces the last element returned by next() or previous() with
                                                    the specified element (optional operation).

                                                    ListIterator<E>  extends de Iterator<E>

        */
        //*****************************************************************************************************************
        //MANERA MANUAL QUE SE ME OCURRIO ANTES DE DESCUBRIR ListIterator<E>
        /*
        Iterator<String> it = personas.iterator();//iterador de tipo interface iterador<T> de objetos genericos

        boolean siEsta = false;
        int count = 0;

        while (it.hasNext() && !siEsta) {
            String nombre = it.next();//seria el objeto en curso
            if (nombre.equals("Jorge Emilio")) {
                siEsta = true;
            }
            count++;
        }
        if (siEsta) {//tendremos el indice siguiente del objeto deseado y asi agregamos a su lado nuestro nuevo objeto
            personas.add(count, "Teresa");
        }
     */

        //*****************************************************************************************************************

        ListIterator<String> it = personas.listIterator();
        //Estas listas si estas ordenadas , no como las de hashSet asi que combiene usar un ListIterator<E>

        /*
        si quisieramos agregar un objeto de manera simple:

        it.next();
        it.add("desconocido"); //esta instruccion vendria a agrega "desconocido juste despues de nuestra 1ra persona"

        pero usamos el metodo add del iterador y no el de ArrayList

        personas.add("Maria");
        personas.add("desconocido");
        personas.add("Jorge");
        personas.add("July");
        personas.add("Jorge Emilio");
        personas.add("Gerardo");
        personas.add("Carol");
        personas.add("Claudia");
        */

        while (it.hasNext()) {//hasPrevious pa recorrer hacia atras
            String nombre = it.next();//contiene el objeto en curso    it.previous() pa recorrer hacer atras

            if (nombre.equals("Jorge Emilio")) {
                it.add("Teresa");//funciona utilizando el metodo add del LinkIterador<E> y no el de ArrayList
            }                    //esto lo que hace es agregar un elemento justo despues del elemento en curso (a su derecha)
        }                        //como haria el add de ArrayList que cuando agrega, lo hace de izquierda a derecha

        //en el otro Iterator no teniamos una funcion para obtener el indice tan facil
        //podiamos intentar con un iterador y funcionaba pero solo personas.set(i+1, "Teresa");
        //y no con personas.add(i, "Teresa");  ni personas.add(i+1, "Teresa");
        //porque para que funcione necesitariamos que a penas esta operacion se haga, i ya no avanze
        //ya que cuando la condicion se cumple el i avanzaria en el if y luego avanzaria tambien al salir
        //un break en el if o un boolean solucionaria el problema y funcionaria

        System.out.println("Numero de elementos: " + personas.size());

        for (String indice : personas) {
            System.out.println(indice);
        }
    }
}
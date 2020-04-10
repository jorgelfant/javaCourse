package i_poo.q_collections.collections_V_iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorPrincipal {
    public static void main(String[] args) {
        //Recojer una collection de objetos, elemento a elemento
        //Para poder recorrer la collection y poder construir un objeto de esas caracteristicas
        //debemos utilizar la interface IteratorPrincipal<I> de la API
        //Es una interface que recibe como parametro un GENERICO

        //Esta interface construye un objeto iterador que sera el encargado de recorrer elemento a elemento
        //una colection de objetos, DA IGUAL EL TIPO DE OBJETOS QUE TIENE ALMACENADA ESTA COLLECTION

        //Para poder hacer este recorrido, esta interface proporciona 3 metodos

        //           next()      Salta al sgte elemento de la collection
        //antes de comenzar a recorrer esta election nos encontramos al principio y lo que hacer el iterador el saltar
        //a la primera posicion dentro de la colection (ver schema) y una vez en esa posicion es capaz de examinarlo
        //Solamente es capaz de examinar el objeto que acabamos de pasar

        //este metodo next() lanza una exception si resulta que se encuentra en una posicion dentro de la collection
        //de objetos en la cual ya no hay a donde saltar  es decir cuando ya no hay mas elementos de esta collection
    /*
        E next()
        Returns the next element in the iteration.

        Returns:
        the next element in the iteration

        Throws:
        NoSuchElementException - if the iteration has no more elements
     */
    /*
       ___________________________________________________________________________________________
      |         |          |        |        |         |         |          |         |          |
      |        *****    *****    *****     *****     *****     ******     ******    *****        |
      x        *   *    *   *    *   *     *   *     *   *     *    *     *    *    *   *        x
               *****    *****    *****     *****     *****     ******     ******    *****

     En el momento en el que no hay mas elementos lanza una exception y es ahi donde entra en juego el siguiente
     metodo :

     hasnext()  ---> Este metodo devuelve un Boolean (true or false) true si hay un objeto siguiente
                     false si no lo hay.

                     Si lo llamaramos por ejemplo en el 3er elemento este metodo nos devolveria un TRUE
                     porque hay un siguient elemento, pero si nos encontraramos en el ultimo elemento de
                     la collection este devolveria FALSE porque no hay mas elementos dentro de la collection
                     asi jugando con estos 2 metodos next() y hasnext() somos capaces de recorrer elemento a elemento
                     una collection sin problema ya que podemos decirle cuando saltar o no. ASI la exception no se
                     produciria si manualmente lo hacemos nosotros.

     remove()  ---->Elimina objetos dentro de la collection

     Con for each podiamos recorrer facilmente una collection de manera facil
     pero sin embargo hay operaciones que son MAS SENCILLAS DE REALIZAR CON UN ITERATOR que con un boucle for each
     y VICEVERSA, hay otra mas facil con for each .  cada uno se adapta a un escenario concreto


     Interface Collection<E>
       Type Parameters:
         E - the type of elements in this collection
     All Superinterfaces:
        Iterable<E>

      vemos que Iterable<E> es una super clase de Collection
      collection hereda de Iterable<E>

      Iterable<E> tiene un solo metodo que lo que hace es:  (bueno ahora tiene 3)

       Modifier and Type	         Method and Description
      ------------------             ----------------------

       default void	                 forEach(Consumer<? super T> action)
                                       Performs the given action for each element of the Iterable until all elements
                                       have been processed or the action throws an exception.

       IteratorPrincipal<T>	           iterator()
                                       Returns an iterator over elements of type T.

       default Spliterator<T>	     spliterator()
                                       Creates a Spliterator over the elements described by this Iterable.


      .Y si cliqueamos en Iterator<T>  que es el tipo de objeto que return el metodo iterator()
       vemos que esta interface tiene los metodos de los que hablamos al principio (mas uno nuevo)

       Modifier and Type	         Method and Description
       -----------------             ----------------------

       default void	                 forEachRemaining(Consumer<? super E> action)
                                       Performs the given action for each remaining element until all
                                       elements have been processed or the action throws an exception.

       boolean	                     hasNext()
                                       Returns true if the iteration has more elements.

       E	                         next()
                                       Returns the next element in the iteration. (devuelve un generico)

       default void               	remove()
                                      Removes from the underlying collection the last element returned
                                      by this iterator (optional operation). (no devuelve nada)
    */


        Clientito cl1 = new Clientito("Jorge", "00001", 200_000);
        Clientito cl2 = new Clientito("Carol", "00002", 250_000);
        Clientito cl3 = new Clientito("Maria", "00003", 400_000);
        Clientito cl4 = new Clientito("Claudia", "00004", 80_000);
        //mismo cliente si nos basamos en que tiene el mismo numero de cuenta
        //el nombre y el saldo no tienen importancia, ya que eso se puede repetir, el factor determinante es n° cuenta
        Clientito cl5 = new Clientito("Jorge", "00001", 200_000);


        Set<Clientito> clientesBanco = new HashSet<>();//Set al ser una interface no puede ser instanciado, necesitamos


        clientesBanco.add(cl1);//agregamos clientes
        clientesBanco.add(cl2);
        clientesBanco.add(cl3);
        clientesBanco.add(cl4);
        //despues de reescribir equals y hashCode, add se dara cuenta cuando hay elementos repetidos y no los agregara
        clientesBanco.add(cl5);

        //RECORREMOS COLLECTION con un for , for each
        /*
        for (Clientito indice : clientesBanco) {
            System.out.println(" cliente: " + indice.getNombre() + ", N° Cuenta: " + indice.getNumeroCuenta() + ", Saldo: " +
                    indice.getSaldo() + ", hashCode: " + indice.hashCode());
        }
        */

        //HABIAMOS VISTO EN LA API, que lo que hace el metodo iterator() es return un objeto de interface IteratorPrincipal<T>
      /*
        Iterator<T>	                 iterator()
                                     Returns an iterator over elements of type T. (generico)
       */
        Iterator<Clientito> it = clientesBanco.iterator();//por convencion un iterador se suele llamar it
        //este metodo de Iterable<T> padre de Collection<E>  devuelve un iterador de genericos
        //de tipo Iteratot<T>
        //ya tenemos un objeto iteratot it

    //******************************************************************************************************************
/*
        while (it.hasNext()) {//= true ..mientras haya un siguiente elemento ....
            //cada vez que se llama una vez a next pues este avanza, al momento de leer el segundo next() ya no estariamos
            //el el mismo objeto sino en el siguiente ya que ya salto
            //                   1                             2                                   3
            // String datos = it.next().getNombre() + " " + it.next().getNumeroCuenta() + " " + it.next().getSaldo();
            String nombre_cliente = it.next().getNombre();
            System.out.println(nombre_cliente);
            //...imprimelo   (tambien podriamos imprimir de frente it.next().getNombre() )
        }//y asi mientras haya un elemento siguiente, imprimira los elementos
*/
        //Asi si queremos imprimir todos los datos , se hace completo porque a cada llamada de next() se pasa al siguiente
        //objeto. Podriamos pensar entonces que nos quedamos con for each y asunto solucionado.
        //Pero no siempre es asi, VEAMOS DE NUEVO EL FOR EACH

        //digamos que quiero eliminar un objeto de mi collection

        // clientesBanco.remove(cl1);//seleccionamos objeto a eliminar y luego imprimimos asi nos borra cl1 e imprime
        /*
           cliente: Maria, N° Cuenta: 00003, Saldo: 400000.0, hashCode: 45806674
           cliente: Claudia, N° Cuenta: 00004, Saldo: 80000.0, hashCode: 45806675
           cliente: Carol, N° Cuenta: 00002, Saldo: 250000.0, hashCode: 45806673
        */

    //******************************************************************************************************************

        //si intentamos eliminar un elemento en el curso de lectura de la coleccion nos dara un error
        /*
        for (Clientito indice : clientesBanco) {
            if (indice.getNombre().equals("Jorge") {
                clientesBanco.remove(indice);   //al ejecutar esto; nos lanza una exception ConcurrentModificationException
                //esta collection en la API nos dice que no podemos modificar una collection mientras la recorremos
            }
            System.out.println(" cliente: " + indice.getNombre() + ", N° Cuenta: " + indice.getNumeroCuenta() + ", Saldo: " +
             indice.getSaldo() + ", hashCode: " + indice.hashCode());
        }
        //es ahi que entra el juego un Iterator, ya que es mucho mas sencillo
        */

    //******************************************************************************************************************

        //usamos de nuevo el iterador que creamos antes
        //DE esta forma CONSEGUIMOS ELIMINAR OBJETOS DENTRO DE UNA COLECCION MIENTRAS LO RECORREMOS
        //POSSIBLE NO ITERATOR Y NO CON FOR EACH
        while (it.hasNext()) {//u aqui usamos el remove()
            String nombre_cliente = it.next().getNombre();
            if (nombre_cliente.equals("Jorge")) {//OU if (nombre_cliente.equals(cl1.getNombre())))
                it.remove();//se coje el objeto que esta siendo eximinado en este momento y se lo borra
            }
        }
        //**************************************************************************************************************
        //Lorsque vous parcourez une collection, vous ne pouvez supprimer qu'un seul élément par tour de boucle,
        // sinon une exception sera levée !
        //**************************************************************************************************************

        //ESTO IMPRIME YA HABIENDO SUPRIMIDO EL ELEMENTO DESEADO
        //ESTE FOR EACH SERIA MEJOR PARA LECTURA GENERAL y EL ITERADOR PARA UNA ACCION CONCRETA CON ELIMINAR UN ELEMENTO
        //DURANTE LA ITERACION
        for (Clientito indice : clientesBanco) {
            System.out.println(" cliente: " + indice.getNombre() + ", N° Cuenta: " + indice.getNumeroCuenta() + ", Saldo: " +
                    indice.getSaldo() + ", hashCode: " + indice.hashCode());
        }

    }
}

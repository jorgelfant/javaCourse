package i_poo.q_collections.collections_VI_VII_linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedList_PrincipalII {
    public static void main(String[] args) {
        //Ejemplo: Capitales paises, veremos si somos capaces de agregar a la LinkedList de paises, las capitales
        //de tal forma que al final nos quedara una linkedList de paises en la cual tendremos pais capital
        //seguidos

        List<String> paises = new LinkedList<>();
        paises.add("Espana");
        paises.add("Colombia");
        paises.add("Mexico");
        paises.add("Peru");


        List<String> capitales = new LinkedList<>();
        capitales.add("Madrid");
        capitales.add("Bogota");
        capitales.add("D.F");
        capitales.add("Lima");

        //En las colecciones los tipos de la API JAVA primitivos o String invocan a toString de manera explicita sin ponerlo
        //e imprimen los objetos de la coleccion, contrariamente a lo que pasa con los array o nuestras clases
        //propias, donde nos imprime las referencias de los elementos/objetos
        System.out.println(paises);
        System.out.println(capitales + "\n");


        //Iterador de listas
        ListIterator<String> itPaises = paises.listIterator();//esto devuelve un objeto interface de tipo ListIterator
        ListIterator<String> itCapitales = capitales.listIterator();//esto devuelve un objeto interface de tipo ListIterator

        //******************************************************************************************************************
        //                              AGREGAMOS LAS CAPITALES EN LOS PAISES
        //******************************************************************************************************************

        while (itCapitales.hasNext()) {//comprueba si hay un siguiente elemento en lista capital
            //declaramos el iterador.next(); para ubicarnos en el primer elemento (esto me da el elemento)
            //una vez que hasNext() dice que si existe
            if (itPaises.hasNext()) {//mira si hay un sgte elemento en paises
                itPaises.next();//me posiciono en el sgte elemento
            }
            itPaises.add(itCapitales.next());//que me agregue el next() de las capitales osea el elemento de capitales
        }
        //al final de esto el iterador se encuentra en la ultima posicion
        //si quiero suprimir capitales u otras cosas, tengo que cojer de nuevo este iterador y mandarlo de nuevo al
        //principio para poder recorrer la collection
        System.out.println(paises);

        //*****************************************************************************************************************

        //una forma de hacer esto es volver a iniciar el iterador asi volveria a su posicion inicial
        itCapitales = capitales.listIterator();//el iterador vuelve al inicio

        //Hariamos nuevamente un boucle while
        while (itCapitales.hasNext()) { //tenemos 4 elementos
            itCapitales.next();//positionate en el elemento sgte se posisiona en 0, en la segunda pasada se posisiona en 2

            if (itCapitales.hasNext()) {//hay un elemento siguiente ? si, es 1.....en la 2da pasada, hay elemento luego de 2? si ...es 3
                itCapitales.next();//nos positionamos en 1 ......2da pasada nos posicionamos en 3
                itCapitales.remove();//y lo borramos 1 en la 1ra pasada....y 3 en la segunda pasada
            }
        }
        //asi solo nos quedamos con el elemento 1 y 3  y borra el 2 y el 4

        System.out.println(capitales);//ahora solo tengo 2 capitales en mi coleccion de capitales
        System.out.println(paises);

        //si vamos a paises y le decimos que borre toodo lo que pertenece a la collection capitales
        //borrara solo 2 elementos, porque solo quedan2 elementos en capitales
        //osea en mi collection borra toodo lo que pertenece a la coleccion que va en argumento

        paises.removeAll(capitales);//removeAll permite eliminar collections   (Collection<?>)

        System.out.println(paises);//y asi cuando imprimimos paises vemos que ya no hay capitales


           /*
           por ejemplo si estamos en el primer elemento y agregamos otro, ese otro vendra a ponerse entre el 1ro y 2do
           Despues de toda una iteracion el iterador acaba al final


                         Madrid         Bogota      D.F        Lima
                           |              |
                  Espana   |  Colombia    |  Mexico   |  Peru   |
                  *****        ******        ******     ******
 iterador X---    * 1 *        *  2 *        *  3 *     *  4 *   ---X  iterador
                  *****        ******        ******     ******

           */


    }
}

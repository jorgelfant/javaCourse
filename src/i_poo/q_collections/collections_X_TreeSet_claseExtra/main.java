package i_poo.q_collections.collections_X_TreeSet_claseExtra;

import java.util.TreeSet;

public class main {
    public static void main(String[] args) {
        //Manera de solucionar el problema de ordenamiento, cuando utilizamos en una collection una clase
        //que no ha implementado Comparable o Comparator, y que no ordena los objetos

        //Veremos como programar de otra forma lo de videos anteriores para no necesitar que la clase que
        //construye el objeto , que almacenamos en el TreeSet , implement la interface Comparator<t>

        //Borramos la implementacion de Comparator anterior
        //Se trata de crear un nuevo Comparator<T>
        //Eso lo haremos creando una clase nueva  la clase ComparadorArticulos
        //y esta va a ser la que implemente la Interface Comparator

        //Con esa nueva clase no obligamos a la clase que construye los objetos ( y que va en parametro de TreeSet)
        //en nuestro caso Articulo, a implementar ninguna Interface

        //De esta forma si la clase articulo no la hemos creado nosotros, no habria problema
        //una vez esto implementamos el metodo de la interface Comparator y despues de eso ya aqui en el main2

        //Creacion del Comparator
        ComparadorArticulos compara_art=new ComparadorArticulos();//constructor par default (aunque no lo hayamos creado)

        Articulo one = new Articulo(1, "Pantalon");
        Articulo two = new Articulo(2, "Falda");
        Articulo three = new Articulo(3, "T-shirt");
        //Ahora debemos crear el TreeSet()
        TreeSet<Articulo> ordenaArt=new TreeSet<Articulo>(compara_art);
        ordenaArt.add(one);
        ordenaArt.add(two);
        ordenaArt.add(three);

        for (Articulo indice:ordenaArt){
            System.out.println(indice.getDescription());
        }
        //y funciona poniendo como parametro en el constructor de TreeSet() un objeto de tipo Comparator que viene
        //a dar un tipo de orden definido en el metodo sobreescrito compare(T o1, T o2) que hemos iniziado en la clase
        //ComparacionArticulos  que no tiene nada que ver con la clase que pusimos en el TreeSet que es Articulo.
        //ComparacionArticulos nos sirve solo para ordenar sin haber tenido que implementar Comparator<T> en Articulo
        //Asi no obligamos a la clase con la que trabajamos que puede ser de otra persona a haber implementado Comparator<T>

        /*IMPRESION  ordena como se estipulo en el metodo implementado en la clase ComparadorArticulos
          Falda
          Pantalon
          T-shirt
        */

        //PERO ESTO SE PUEDE HACER DE UNA FORMA INCLUSO MAS COMODA, podemos USAR LAS CLASE SINTERNAS ANONIMAS
        //COMO SERIA?

        //Ver el siguiente PACKAGE
    }
}

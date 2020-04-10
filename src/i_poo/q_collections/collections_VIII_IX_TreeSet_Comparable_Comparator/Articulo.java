package i_poo.q_collections.collections_VIII_IX_TreeSet_Comparable_Comparator;

import java.util.Comparator;

public class Articulo implements Comparable, Comparator {//comparable<T> para ordenar clases genericas Comparable<T>
    //Comparator<T> ya que no podemos implementar 2 veces la misma interface
    private int numeroArticulo;
    private String description;

    public Articulo() {//Constructor por defecto

    }

    public Articulo(int numeroArticulo, String description) {//Constructor
        this.numeroArticulo = numeroArticulo;//enumerar articulos
        this.description = description;//descripcion articulos (su nombre)
    }
    //******************************************************************************************************************
    //Metodo compareTo de la interface Comparable<T>   compareTo(T o)
    @Override
    public int compareTo(Object o) {//debe retornar 0 1 o -1   ordena objetos de clases genericas o de la Api
        Articulo otro = (Articulo) o;
        return this.numeroArticulo - otro.numeroArticulo;//esto hace justamente que me de 0 1 o -1 si hacer los if
    }//para que mis articulos sean ordenados luego , implementamos comparabme

    //******************************************************************************************************************
    //Metodo compareTo de la interface Comparator<T>   compare(T o1, T o2)
    @Override
    public int compare(Object o1, Object o2) {//si pusieramos Articulo en vez de Object no haria falta el casting
        Articulo otro1 = (Articulo) o1;
        Articulo otro2 = (Articulo) o2;

        String description1=otro1.getDescription();
        String description2=otro2.getDescription();

        return description1.compareTo(description2);//un String hereda por default Comparable<T> es por eso que podemos
    }                                               //usar el metodo description1.compareTo(T o)
    //******************************************************************************************************************
    //Metodo getter para dar la descripcion del articulo
    public String getDescription() {
        return this.description;
    }


}

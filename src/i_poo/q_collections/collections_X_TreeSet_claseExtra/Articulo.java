package i_poo.q_collections.collections_X_TreeSet_claseExtra;

public class Articulo implements Comparable {//comparable<T> para ordenar clases genericas Comparable<T>
    //Comparator<T> ya que no podemos implementar 2 veces la misma interface
    private int numeroArticulo;
    private String description;

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
    //Metodo getter para dar la descripcion del articulo
    public String getDescription() {
        return this.description;
    }


}

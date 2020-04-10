package i_poo.q_collections.collections_X_TreeSet_innerClass;

import java.util.Comparator;
import java.util.TreeSet;

public class main2 {
    public static void main(String[] args) {
        //Hacemos lo del package anterior con una clase interna para simplificar aun mas la sintaxis

        //ya no necesitamos crear este objeto de clase ComparadorArticulos qui implementa Comparator

        //ComparadorArticulos compara_art=new ComparadorArticulos();//constructor par default (aunque no lo hayamos creado)

        Articulo one = new Articulo(1, "Pantalon");
        Articulo two = new Articulo(2, "Falda");
        Articulo three = new Articulo(3, "T-shirt");
        //Ahora debemos crear el TreeSet()

        //Creariamos la clase interna donde va el argumento del constructor de TreeSet()
        /*
        TreeSet(Comparator<? super E> comparator)
               Constructs a new, empty tree set, sorted according to the specified comparator.
        */
     //*****************************************************************************************************************
                                                   //esto sale en negrita porque el programa nos dice
                                                   //que esto puede ser remplazado con "lambda"
        TreeSet<Articulo> ordenaArt = new TreeSet<>(new Comparator<Articulo>(){ //creacion clase interna
            //dentro de la clase interna conviene utilizar directamente el tipo en cuestion Articulo en parametro
            //del metodo y no Object con un cast public int compare(Object o1, Object o2)
            public int compare(Articulo o1, Articulo o2) {
                String desc1 = o1.getDescription();
                String desc2 = o2.getDescription();

                return desc1.compareTo(desc2);//esto envia el resultado de la comparacion 0 1 o -1
            }
        });
     //*****************************************************************************************************************
        ordenaArt.add(one);
        ordenaArt.add(two);
        ordenaArt.add(three);

        for (Articulo indice : ordenaArt) {
            System.out.println(indice.getDescription());
        }

    }
}

package i_poo.r_genericité.C_metodosGenericosPropios;

import java.util.GregorianCalendar;

public class MetodosGenericos {
    public static void main(String[] args) {
        //Metodos Genericos propios, como en clase generica pero en metodo
        //Es aquel que se adapta o que podemos utilizar con cualquier tipo de objeto

        // Los metodos genericos no tienen obligatoriamente que estar construidos en CLASSES GENERICA
        // LOS METODOS GENERICOS PUEDEN ESTAR CONSTRUIDOS
        // DENTRO DE "CLASES ORDINARIAS" O DENTRO DE "CLASES GENERICA"

        // LAS PODEMOS CREAR DONDE QUERRAMOS
        //La clase MisMatrices tendra dentro un metodo GENERICO que nos va a return un String
        //Al ser generico podra recibir cualquier tipo de Array, siempre nos va decir la longitud

        //no es necesario hacer este tipo de metodo generico pero es solo pa entender


        Integer[] miTab1 = new Integer[5];

        String talla1 = MisMatrices.longitud(miTab1);//metodo Static <T>

        //acceptaria cualquier tipo de array
        System.out.println(talla1);//o System.out.println(MisMatrices.longitud(miTab1));


        //Ojo es solo pa practicar, sin ser generico y poniendo en el metodo (Object[] o) tb funcionaria

        //En metodos GENERICOS mas complejos puede ser un problema justamente que el metodo sea generico y acepte
        //toodo tipo de parametro
        //Vamos a crear un segundo metodo generico que lo que hace es decirnos en el array que le pasemos por
        //argumento , cual es por ejemplo el elemento menor ordenado por orden alfabetico

        String[] nombres = {"Zara", "Ana", "Pepe"};
        System.out.println(MisMatrices.dameMenor(nombres));//solo funciona con los de la api, si quisiera hacer
                                                           //con clases propias (Empleado por ejemplo) no funcionaria
                                                           //ya que mis clases no implementan Comparable por defecto
                                                           //no sabe entonces en funcion de que criterio comparar

        //Geregorian Calendar tambien implementa por defaut Comparable
        GregorianCalendar[]fechas={new GregorianCalendar(2015,7,12),
                new GregorianCalendar(2014,7,12),
                new GregorianCalendar(2011,5,2)};
        System.out.println((MisMatrices.dameMenor(fechas)).getTime());
        //                  nos da referencia objeto       get time la fecha
    }
}

//**********************************************************************************************************************
//CLASE EXTERIORES CON SUS METODOS
//**********************************************************************************************************************
class MisMatrices {
    /*
    public static <T> int longitud(T[] tab) {
        return tab.length;
    }*/
    public static <T> String longitud(T[] tab) {
        return "El tamanio del tableau es = " + tab.length + " elementos.";
    }

    //metodo 2

    //Para que el metodo reconozca el metodo compareTo de Comparable, en lugar de implementar como hacemos siempre
    //y como en este caso estamos trabajando con genericos <T> vamos a declararlo dentro del generico <T extends Comparable>

    //EX:     String implements comparable     y asi implementa en el caso deciertas clases de la api, compareTo par defaut
    //este metodo es una especie de Arrays.sort(tab); y los elementos de tab de una clase determinada ya habran implementado compareTo() !
    //            Los elementos del tab T deben extend Comparable
    public static <T extends Comparable> T dameMenor(T[] tab) {//ahora ya no devuelve un String sino un tipo generico T (el elemento menor en este caso)

        if (tab == null || tab.length == 0) {
            return null;
        }
        T min = tab[0];
        for (int i = 1; i < tab.length; i++) { //o al reves if (tab[i].compareTo(min) < 0)
            if (min.compareTo(tab[i]) > 0) {//osea si es positivo, significa que el primer elemento es mayor 1  0  -1
                min = tab[i];               //significaria que el min del if es mayor, entonces tab[i] es menor
            }
        }//compareTo funciona al hacer el Extends porque se aplicara con objetos de tipo String Integer etc de la Api
        //que implementarn compareTo por defecto  es decir que ya la tienen implementada dentro por eso la pueden usar
        //una vez que hacemos el extends, el extends es como si viniera a activar el compareTo que tienen dentro
        // con nuestros propios objetos no funcionaria y daria un error porque ahi si debemos modificarla
        return min;   //despues de haberlo ordenado ya sabemos que el primero sera el menor
    }
}
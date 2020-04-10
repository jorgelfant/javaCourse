package i_poo.r_genericité.A_api_Java;

public class ArrayLista_teoria {

        //CLASES GENERICAS
        /*
        si estamos usando un ArrayList y no sabemos su capacidad inicial, y lo hemos estado llenando,
        pero al final ya sabemos cual es su capacidad y que no agregaremos mas elementos.

        asi si estamos seguros que ya no se agregaran mas elementos despues de haber agregado esos elementos
        lo que podemos hacer es agregar el metodo TabEmpleados.trim.toSize();  el nombre del Array list y el metodo

        ////Este metodo trimToSize() consigue cortar el exceso de memoria////

        Imaginemos que tenemos un ArrayList y en el metemos 14 valores y a lo mejor esos 14 elementos ocupan
        un cierto espacio en ese ArrayList, y nos queda un espacio que el programa ha ido creando.

        Pues este metodo trimToSize lo que hace es cojer la parte usada y recortar el espacio sobrante
        de esa memoria vacia para que finalmente el ArrayList quede con un tamanio apropiado a lo que almacena
        en su interior
        ---------------------
        |              |    |
        ---------------------

        despues de trimToSize()

        ----------------
        |              |
        ----------------

        Asi optimzamos los recursos
        ----------------------------------------------------------------------------------------------------------------

        Si despues de haber rellenado nuestro ArrayList queremos pasar a un array podriamos
        asi damos al array el tamanio del arrayList

        Empleado TabEmpleado=new Emplead[LisaEmpleados.size()];

        listaEmpleados.toArray(TabEmpleado); //y asi pasamos el ArrayList al array normal, osea copiamos los elementos
                                             //el contenido

       ou

       Empleado[] TabEmpleado=listaEmpleados.toArray()    //asi pasariamos toodo de una sola, elementos y tamanio


        */


}

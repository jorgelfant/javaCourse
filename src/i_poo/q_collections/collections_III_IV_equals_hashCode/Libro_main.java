package i_poo.q_collections.collections_III_IV_equals_hashCode;

import java.util.HashSet;
import java.util.Set;

public class Libro_main {
    public static void main(String[] args) {
        //METODOS equals() y hashCode() estos 2 metodos vimos que pertenecian a la superClass Object
        //Ellos son importantes cuando trabajamos con COLLECTIONS
        /*
        Ejemplo:

        int v_design_patterns=5;  5 se almacena en ma variable v_design_patterns que puede cambiar. Se reserva un espacio en la memoria de la pc
                  esta memoria se denomina "Stack" que es una memoria de acceso rapido, es decir que nuestro programa
                  java puede acceder muy rapidamente al contenido que hay en su interior

                       Stack
                  --------------------
                  |         v_design_patterns        |
                  |       ------     |
                  |      |  5  |     |
                  |      ------      |
                  |                  |
                  |                  |
                  |                  |
                  --------------------

         //Que ocurre cuando creamos una instancia perteneciente a una clase, imaginemos que creamos una clase
         //libro y que despues instanciamos la clase con un objeto libro1
         //Que OCURRE INTERNAMENTE ??

         Libro libro1=new Libro();
                      ------------
         Pues lo primero que se lee es la instruccion "new Libro();" e internamente nuestro programa java cuando
         lee esa informacion new Libro(); es decir CREAR UNA NUEVA INSTANCIA, lo que el programa hace es
         ACCEDER A LA MEMORIA DEL ORDENADOR pero NO A LA MISMA MEMORIA (Stack de acceso rapido) sino a
         otra memoria que es de ACCESO MAS LENTO y que se denomina "Heap"

                           Heap
                  --------------------
                  |                   |
                  |  ---------------  |
                  | |  Objeto libro|  |
                  | ----------------  |
                  |                   |
                  |                   |
                  |                   |
                  --------------------
        Y esta memoria lo que hace es "RESERVAR UN ESPACIO" para ALMACENAR "los objetos de tipo Libro"
        y una vez que ha hecho esto continua la lectura por el nombre que le hemos dado al objeto "libro1"
        y una vez que lee eso, ese nombre SI LO ALMACENA EN EL STACK!

                          Stack                                    Heap
                  --------------------                     ---------------------
                  |         v_design_patterns         |                    |         v_design_patterns         |
                  |       ------      |                    |  ---------------  |
                  |      |  5  |      |            ---------> | Objeto libro|  |
                  |      ------       |           |        |  ---------------  |
                  |      libro1       |          |         |                   |
                  |  ---------------  |         |          |                   |
                  | |Referencia a...|-----------           |                   |
                  | ----------------  |                    |                   |
                  |                   |                    |                   |
                  |                   |                    |                   |
                  ---------------------                    --------------------

       Asi cuando el espacio para los objetos de tipo libro esta reservado, luego el programa sigue leyendo y cuando
       llega al nombre del objeto , crea este nombre y lo pone en la memoria Stack de acceso rapido.
       Lo que ha hecho es crear una referencia desde el almacenamiento que tenemos en el stack al objeto
       que esta almacenado en el Heap.

       Es decir, a diferencia de lo que ocurre con un tipo primitivo en el cual se almacena su valor.
       Lo que ocurre con un objeto es que se almacena en la memoria una referencia, al objeto que esta localizado
       en otro lugar.

       Una referencia o un vinculo

       si nos da por crear otro objeto de la clase Libro

       Libro libro2=new Libro();

       el proceso se repite identicamente, es decir se reserva otro espacio en la memoria Heap para el objeto de
       tipo libro y luego en el stack se crea la referencia a ese espacio

                          Stack                                    Heap              localizacion del objeto
                  --------------------                     ---------------------       _  hashcode
                  |         v_design_patterns         |                    |                   |     /   654654654654
                  |       ------      |                    |  ---------------  |   /
                  |      |  5  |      |            ---------> | Objeto libro| <---
                  |      ------       |           |        |  ---------------  |
                  |      libro1       |          |         |                   |
                  |  ---------------  |         |          |                   |
                  | |Referencia a...|-----------           |                   |
                  | ----------------  |                    |                   |
                  |                   |                    |                   |
                  |      libro2       |                    |                   |
                  | -----------------                      |  ---------------- |
                  | | Referencia a..|-----------------------> | Objeto libro| <----
                  | -----------------                      |  ---------------- |   \
                  |                   |                    |                   |    \_____  hashcode
                  |                   |                    |                   |            4454545545
                  |                   |                    |                   |
                  ---------------------                    --------------------

       Y ASI OCURRE SUCCESIVAMENTE.

       que es el hashCode() ?  Es un numero de un monton de cifras que hace referencia a la localizacion
       del objeto que tenemos almacenado en la memoria Hype y esa localizacion esta identificada con un
       numero bastante largo que en principio no nos interesa.

       hascode ===> REFERENCIA A LA LOCALIZACION DEL OBJETO

       Que ocurre si despues de haber creado estas 2 instancias a nosotros en nuestro programa de java nos da
       por escribir lo siguiente:

       libro1=libro2;

                          Stack                                    Heap              localizacion del objeto
                  --------------------                     ---------------------       _  hashcode
                  |         v_design_patterns         |                    |                   |     /   654654654654
                  |       ------      |                    |  ---------------  |   /
                  |      |  5  |      |            ---------> | Objeto libro| <---
                  |      ------       |           |        |  ---------------  |
                  |      libro1       |          X         |                   |
                  |  ---------------  |                    |                   |
                  | |Referencia a...|--------\             |                   |
                  | ----------------  |       \            |                   |
                  |                   |        \           |                   |
                  |      libro2       |         \                              |
                  | -----------------            \         |  ---------------- |
                  | | Referencia a..|-----------------------> | Objeto libro| <----
                  | -----------------                      |  ---------------- |   \
                  |                   |                    |                   |    \_____  hashcode
                  |                   |                    |                   |            4454545545
                  |                   |                    |                   |
                  ---------------------                    --------------------

         Estamos diciendo a nuestro programa que nuestros 2 objetos son iguales, es decir que ahora
         la referencia de libro1 debe ser la misma que la de libro2 y por lo tanto apuntar al objeto 2
         Ahora los 2 objetos tienen la misma referencia y apuntan a un mismo objeto

         ISBN ==>  international standard book number, es un codigo internacional unico pa identificar un libro
                   como un DNI del libro.

         Imaginemos que escribimos un libro y una vez que lo termino pue slo mando a la editorial para que
         comienze la impresion en serie de las copias.

                                            *********     / titulo
                                            * Java  *  ---  autor
                                            *********     \ ISBN


        *********       *********          *********        *********        *********         *********   etc
        *  Java *       * Java  *          * Java  *        * Java  *        * Java  *         * Java  *
        *********       *********          *********        *********        *********         *********

        PREGUNTA: Una vez que la editorial saca al mercado un monton de copias de este libro,
                  Podemos decir que un libro por ejemplo comprado en la fnac es el mismo que otro
                  comprado en otra tienda ????

        Si, podemos decir que se trata del mismo libro y si miramos todas las copias que ha ido sacando la
        editorial al mercado podemos decir efectivamente que se trata del mismo libro.

        Y porque sabemos que se trata del mismo libro?? Porque todos apuntan al mismo libro de referencia
        y por eso sabemos que se trata del mismo libro.

                                            *********     / titulo
                                            * Java  *  ---  autor
                                            *********     \ ISBN
                                           /     | \____________
                                         /       |              \
                                  *********     *********        *********
                                  * Java  *     * Java  *        * Java  *
                                  *********     *********        *********

       y en el mundo editorial ademas todas estas copias llevarian el mismo ISBN, da igual que sean 4 copias
       o 4 millones de copias, todas deben tener el mismo ISBN

       Imaginemos que JAVA evoluciona y que en 2 anios mi libro de JAVA queda obsoleto, que hago yo como autor?
       Pues saco otro libro, y a ese libro pues tambien le doy un titulo, autor e ISBN .

       PREGUNTA: Este nuevo libro 2 anios despuespuede tener el mismo titulo? si, el mismo autor? si
                 el mismo ISBN? NON
                 No se permite que un nuevo libro pasado un tiempo tenga el mismo ISBN que el que creaste antes.

                 Bueno mando el libro a la editorial y esta vuelve a hacer las copias.

                 Asi tendremos a la venta el libro que escribimos hace 2 anios y el que escribi ahora
                 podemos decir que la copia de hace 2 anios es la misma que la actual ? pues no
                 porque el ISBN es diferente

    ********************************************************************************************************************
    *                                             ENTONCES                                                             *
    ********************************************************************************************************************

     Imaginemos que en Java creamos una clase Libro y que empezamos a crear instancias de esta clase.
     Podemos preguntarle al metodo equals() si 2 libros son iguales?? es decir por ejemplo si la copia de hace
     2 anios es igual a una actual?  las respuesta es NO.

     Porque el metodos no sabe nada de isbn, y eso el metodo equals() no lo sabe, el metodo equals() que viene el la
     API de JAVA es capaz de decernir si 2 objetos de la clase String son iguales o 2 objetos de la clase Date
     son o no iguales. Pero es capaz de hacer eso porque la clase Date y String son Clases predefinidas que ya vienen
     en la API de JAVA. Pero no es capaz de saber si 2 objetos de 2 clases que he creado yo y que tendran unas
     caracteristicas determinadas, son iguales o no !

    ********************************************************************************************************************
    *                                             CONCLUSION:                                                          *
    ********************************************************************************************************************

                 Va a ser muy frecuente cuando trabajamos con COLLECTIONS , tengamos que saber si 2 objetos almacenados
                 en una collection son IGUALES o NO. Y para poder averiguar eso, no me vale el metodo equals() que
                 viene en la clase de JAVA sino que DEBEMOS SOBREESCRIBIR el metodo equals() para que en lugar de
                 tener el comportamiento por defecto que es muy util para clases prdefinidas de la API (Date et String )
                 tenga el comportamiento que yo necesito para que me valga por ejemplo para objetos de tipo Libro.

                 Es decir que hay que decirle al metodo equals() por ejemplo que compare los ISBN de los libros
                 si son iguales sera el mismo objeto y sino pues no.

                 Y habra que hacer lo mismo con el METODO hashCode(), ya que este nos da la localization de un objeto
                 en la memoria Heap de una 'CLASE PREDEFINIDA' pero no funciona para las clases que hemos creado nosotros
        */

//**********************************************************************************************************************
//                                              EJEMPLO
//**********************************************************************************************************************
        Libro libro1 = new Libro("Java", "Jorge", 25);
        Libro libro2 = new Libro("Java", "Jorge", 25);

        //al haber ya cambiado el hascode ya sabe que aunque tengan diferente nombre, son el mismo basandose en el hashCode
        //solo agrega uno
        Set<Libro> tac = new HashSet<>();
        tac.add(libro1);
        tac.add(libro2);
        for( Libro inc: tac){
            System.out.println(inc.getAutor());
        }


        //Si intentamos comparar con equals() tal como viene en la API si 2 objetos de la clase Libro son iguales o no
        //nos va dar error

        //En teoria libro1 y libro2 son identicos! mismo titulo mismo autor y mismo codigo ISBN que es lo que a nosotros
        //nos importa...Sin embargo el metodo equals() no sabe nada de ISBN porque esta clase es mia

        //Una vez el metodo redefinido en la clase ahora si funciona la comparacion
        //libro1=libro2;  vendria a poner la referencia del bojeto 2 en el 1, los 2 tendrian el mismo hashCode
        if (libro1.equals(libro2)) {
            System.out.println("son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        } else {
            System.out.println("no son iguales");
            System.out.println(libro1.hashCode());
            System.out.println(libro2.hashCode());
        }

        //esta comparacion me dice que no son iguales
        //**************************************************************************************************************
        //                                              Solution
        //**************************************************************************************************************
        //Reescribir el metodo equals() en la clase Libro para que sea capaza de distinguir que es un ISBN

        //**************************************************************************************************************
        //     si no tuvieramos el equals() reescrito nos seguiria diciendo que son diferente
        //**************************************************************************************************************
        //Como son 2 objetos diferentes deberian tambien de tener 2 hashCode DIFFERENTES,
        //pero incluso cuando son iguales, nos da hashCode diferentes, PORQUE NO HEMOS SOBREESCRITO EL METODO hashCode()

        //siempre se deben sobreescribir los 2 metodos , cuando trabajamos con COLLECTIONS
        //el hasCode es como un identificador,un objeto con los mismos argumentos tiene el mismo hashCode

        //que hace referencia a su emplacement de memoria

        /*impresion
             141376079
             141376069
        */

        //En mi ejemplo si hubiera considerado en el equals solo el ISBN , solo el cambio de este parametro hubiera
        //hecho que los objetos ya no sean iguales, el titulo o autor no hubiera influenciado.
    }
}

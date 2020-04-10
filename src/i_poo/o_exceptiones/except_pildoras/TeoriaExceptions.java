package i_poo.o_exceptiones.except_pildoras;

public class TeoriaExceptions {
        //EXCEPTIONS o MANEJO DE ERRORES
        /*
                                              *************
                                              *   ERROR   *
                                              *************
                                                    |
                               |-------------------------------------|
                        *************                          *************
                        * Tiempo de *                          *   Tiempo  *
                        *Compilation*                          *     de    *
                        * (Sintaxe) *                          * ejecucion *
                        *************                          *************
                                                                     |
                                                               *************
                                                               * Throwable *
                                                               *************
                                                                     |
                                                        |--------------------------|
                                                 *************              *****************
                                                 *   Error   *              *  Exception    *
                                                 *************              *****************
                                                                                     |
                                                                     |-------------------------------|
                                                              ***************                *********************
                                                              * IOException *                *  RuntimeException *
                                                              ***************                *********************

                                              JERARQUIA DE ERRORES (clase que gestionan los errores)

         Cuando ocurre un error durante la ejecucion de un programa en JAVA realmente lo que pasa sin que lo veamos
         es que se crea un objeto (objeto de tipo error), como con los eventos por ejemplo.

         conviene saber a que clase pertenece ese error.

         Toodo empieza por un error y ese error puede ser de 2 tipos:

         1) un error de tiempo de compilation           O              2) Un error de tiempo de ejecution
             (que son errores de sintaxis)                                  (errores que no dependen de nous
             olvide una ; o una } etc                                               ni de nuestra escritura)
           Debemos escribir correctamente                                     sino de otros factores

                                                                         La logica del programa no tiene sentido
                                                                         es lo que se denomina error en tiempo de
                                                                         ejecucion. Es decir que cuando el codigo
                                                                         se ha compilado y se ha generado el fichero
                                                                         .class y este fichero entra en ejecucion
                                                                         es cuando ocurre el error.

                                                                         Osea cuando aplicamos en ejecutar, es en
                                                                         ese momento que ocurre el error y se
                                                                         genera un objeto (error)

                                                                         Y es a partir de la clase "Throwable"
                                                                         que tenemos la jerarquia de clases
                                                                         que manejan los errores en JAVA.

                                                                         Ese decir, toodo objeto error que se
                                                                         genera en un programa JAVA hereda de
                                                                         la classe Throwable.

                                                                         Y en la jerarquia de la herencia por
                                                                         debajo de la classe Throwable hay 2
                                                                         class: 1) class Error  2) Class Exception.

                                                                         cuando un objeto error hereda de la class
                                                                         Error normalement supone que ha ocurrido
                                                                         un error de HARDWARE, es decir:
                                                                         O HAY POCO ESPACIO EN EL DISCO DURO DEL PC
                                                                         O BIEN HAY UN ERROR EN LA MEMORIA DEL
                                                                         ORDENADOR. O HAY POCA MEMORIA DISPONIBLE.

                                                                         CON ESTO OCURRE lo mismo que con los errores
                                                                         de sintaxis, poco podemos hacer.

                                                                         Podemos hacer algo mas que con los errores de
                                                                         sintaxis para de alguna forma AVISAR AL USUARIO
                                                                         DE QUE HA OCURRIDO UN ERROR DE ESTE TIPO.
                                                                         Pero no mucho mas.

     El manejo de ERRORES y EXCEPTIONES EN JAVA se centra o focalisa en todos los objetos ERROR que heredan
     de la CLASS EXCEPTION porque estos errores si que podemos manejarlos de una forma mucho mas profunda,
     es decir que podemos jugar mucho mas con ellos.

     Y por debajo de la jerarquia en la class Exception tenemos 2 subclass: 1)IOException        2)RuntimeException

                                        *************
                                        * Throwable *
                                        *************
                                              |
                                 |--------------------------|
                          *************              *****************
                          *   Error   *              *  Exception    *
                          *************              *****************
                                                              |
                                              |-------------------------------|
                                  ***************                          *********************
                                  * IOException *                          *  RuntimeException *
                                  ***************                          *********************
                     ( Errores o EXCEPTIONES COMPROBADAS)                  (Exceptiones no comprobadas)
                      Es decir errores que no son culpa del                Estos son errores por parte del programador
                      programador de JAVA.                                 Java.

                      Por ejemplo: creamos un programa Java                Por ejemplo recorrer un array con mas
                      que debe buscar una imagen que se supone             posiciones de las que al inicio se declaro
                      debe estar en una carpeta.                           o intentar almacenar en una variable de
                                                                           tipo String, una variable de tipo entero.
                      Imaginemos que durante la ejecucion del
                      programa o antes de la ejecucion alaguien
                      mueve la imagen de esa carpeta.

                      Lo que ocurre es que nuestro programa al ir
                      a buscar esa imagen en la carpeta no la
                      encuentra y no es culpa del programador.
                      Eso se denomina un tipo de error
                      esception comprobado.
        */
}

package i_poo.r_genericité.C_metodosGenericosPropios.Herencia_TiposComodin;

public class Herencia_TiposComodin {
    public static void main(String[] args) {
        //HERENCUA y TIPOS COMODIN
    /*
    La HERENCIA no funciona con las CLASES GENERICAS de la misma forma qe como lo hace con las CLASES ORDINARIAS
    */

        //Ese funcionamiento diferente o ANOMALO nos va obligar en ocasiones a utilizar TIPOS COMODIN sobre
        //toodo a la hora de llamar metodos que han sido declarados dentro de una CLASE GENERICA

        //Ex: en las clases ordinarias
        /*
                                         **************
                                         *  Empleado  *
                                         **************
                                               ^
                                               | extends    Un Jefe "es un".... Empleado?
                                               |
                                         ***************
                                         *    Jefe     *
                                         ***************

        Este principio es un, nos permitia saber que clase hereda de que clase; si podemos decir que un jefe
        es siempre un empleado, eso quiere decir que Jefe puede heredad de Empleado.

        Y un Empleado pues no siempre es un JEFE, en ocasiones puede ser un administrativo coptable etc

        Este principio de substitution de la HERENCIA "NO FUNCIONA EN LAS CLASES GENERICAS"

        Si tenemos una clases GENERICA que recibe un tipo Empleado y una clase generica que recibe un tipo Jefe
        NO EXISTE RELACION ALGUNA entre estas 2 clases es decir que para JAVA no existe connexion alguna entre
        Clase tipo Empleado y clase tipo Jefe.

        Y esto supone una RESTRICCION a la hora de manejar algunos METODOS que estan definidos en las CLASES GENERICAS
        hace el sistema un poco rigido.

                                         *********************
                                         *  clase<Empleado>  *
                                         *********************

                                                   X

                                         *********************
                                         *    clase<Jefe>    *
                                         *********************

         Digamos que para salir de esta restriction, de esta rigides que existen con las clases Genericas
         existen los tipos COMODIN.

        public static <T extends Comparable> T dameMenor(T[] tab)

        En este ejemplo por ejemplo al decir que T extends Comparable significara que la clase T puede ser
        cualquier tipo que implemente la interface Comparable o sublcases de esa clase que herede de esta clase
        que implementa Comparable.
        */

        //VAMOS A TRABAJR CON 4 CLASES; Pareja / el main / Empleado / Jefe

        //Rappelons le principe de l'héritage
        /*
        Empleado Administrativa = new Empleado("Maria", 30, 2000);
        Jefe DirectoraComercial = new Jefe("Luisa", 30, 3000);

        //UN JEFE SIEMPRE ES UN EMPLEADO, gracias a este principio podemos:

        Empleado NuevoEmpleado = DirectoraComercial;//almacenas un objeto de tipo jefe en un objeto de tipo empleado
        */
        //ESTE PRINCIPIO NO ES ASI CUANDO MANEJAMOS CLASES GENERICAS

        //SI manejamos clases genericas, la cosa seria de la siguiente forma

        Pareja<Empleado> Administrativa = new Pareja<>();
        Pareja<Jefe> DirectoraComercial = new Pareja<>();

        //Si intentamos aplicar el principio de substitution vemos que no va a funcionar con las clases genericas
        //bueno estamos aqui trabajando con Pareja y es como si estuvieramos metiendo un Jefe en Pareja

        //Pareja<Empleado> nuevoEmpleado = new Jefe<>();//no puede convertir un jeve en un empleado

        //Vamos a la clase Pareja y ahi vamos a crear un nuevo metodo que imprima en concreto un Jefe o un Empleado
        //en concreto

        //luego volvemos aqui e intentamos llamar al metodo

        Pareja.imprimirTrabajador(Administrativa);//la clase es estatica y recibe en parametro un Generico que actua sobre<Empleado>

        //si preteno hacer lo mismo y pasarle un tipo generico Jefe va dar un error porque con genericos la herencia no funca igual es un
        Pareja.imprimirTrabajador(DirectoraComercial);//al modificar el metodo con <? extends Empleado>

        //COMO SOLUCIONAR ESTO? USAR TIPOS COMODIN que consiste en la definicion del metodo, si queremos que este metodo
        //sea utilizable para tipos empleados y cualquiera de sus subclases que pudiera tener esta clase Empleado
        //como por ejemplo Jefe, Comptable etc


         /*

            <T extends Parent> accepts either Parent or Child while <T super Parent> accepts either Parent or Grandparent.

            There are three types of wildcards:

            ? extends Type: Denotes a family of subtypes of type Type. This is the most useful wildcard.
               va al elemento y abajo en su jerarquia subclases

            ? super Type: Denotes a family of supertypes of type Type.
              va al elemento y arriba en su jerarquia superClass (padre)

            ?: Denotes the set of all types or any.

            ? significa el conjunto de toodos los tipos o algun tipo




    */




    }
}

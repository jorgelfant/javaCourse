package i_poo.r_genericité.C_metodosGenericosPropios.Herencia_TiposComodin;
//Como convertimos esta clase normal en una clase generica ?
//indicando entre <T> el tipo  entre corchetes, que en principio es generico
//al momento de definir estos argumentos de <T> tipo se suelen usar por convenio
//a la hora de programar letras mayusculas
// PUEDEN SER   <T>   <U>    <K>  por convencion

public class Pareja<T> {//asi ya hemos definido nuestra primera clase generica

    private T primero; //indicamos con T porque es generico, es decir que no sabemos cual sera

    //constructor
    public Pareja() {//el constructor dara un estado inicial al campo de clase primero=null, solo eso
        this.primero = null;
    }

    //metodo setter que cambie el valor que por defaut pusimos en null
    public void setPrimero(T primero) {
        this.primero = primero;
    }

    //metodo getter que nos devuelve el valor de tipo generico T que puede ser Empleado, String etc etc

    public T getPrimero() {
        return this.primero;
    }

    //Vamos a la clase Pareja y ahi vamos a crear un nuevo metodo que imprima en concreto un Jefe o un Empleado
    //en concreto

    //                  A la hora de especificar el elemento que va a recibir le decimos que tiene que ser :
     //                le estamos diciendo que puede recibir un tipo empleado y sus sublaces que heredan de el
    //aqui si el metodo fuera <T> generico hubieramos podido remplaza el parametro ? por T
    //este no es el caso porque sabemos con que generico collection trabajamos "Pareja"
    public static void imprimirTrabajador(Pareja<? extends Empleado> p) {//En parametro un generico de tipo Empleado
        Empleado primero = p.getPrimero();//dame ese objeto de tipo generico y almacenalo en Empleado pa decir que es empleado
        System.out.println(primero);
    }
    /*

    <T extends Parent> accepts either Parent or Child while <T super Parent> accepts either Parent or Grandparent.

    There are three types of wildcards:

    ? extends Type: Denotes a family of subtypes of type Type. This is the most useful wildcard.
    ? super Type: Denotes a family of supertypes of type Type.
    ?: Denotes the set of all types or any.

    */


}



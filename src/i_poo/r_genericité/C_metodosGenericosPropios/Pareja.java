package i_poo.r_genericité.C_metodosGenericosPropios;
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

    //******************************************************************************************************************
    //                            Metodos genericos propios
    //******************************************************************************************************************



    }



package i_poo.r_genericité.B_clasesGenericas_propias;
//Como convertimos esta clase normal en una clase generica ?
//indicando entre <T> el tipo  entre corchetes, que en principio es generico
//al momento de definir estos argumentos de <T> tipo se suelen usar por convenio
//a la hora de programar letras mayusculas
// PUEDEN SER   <T>   <U>    <K>  por convencion

public class Pareja<T> {//asi ya hemos definido nuestra primera clase generica

    private T primero; //indicamos con T porque es generico, es decir que no sabemos cual sera

    private Object[] tab;
    private int i = 0;
    private int a = 10;

    //constructor
    public Pareja() {//el constructor dara un estado inicial al campo de clase primero=null, solo eso
        //this.primero = null;
        tab = new Object[10];
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
    //                                 Variante mia para agregar sin limite
    //******************************************************************************************************************
    public void add(Object o) {
        if (i == tab.length) {
            a += 10;
            Object[] tabN = new Object[a];
            for (int j = 0; j < tab.length; j++) {
                tabN[j] = tab[j];
            }
            tab = tabN;
        }
        tab[i] = o;
        i++;
    }

    public void set(int i, Object o) {
        tab[i] = o;
    }

    public Object dameClass() {//return el objeto en tal indice
        return tab[0].getClass();
    }

    public Object get(int i) {//return el objeto en tal indice
        return tab[i];
    }

    public Object get(Object o) {//return indice de un objeto
        for (int j = 0; j < tab.length; j++) {
            if (tab[j] == o) {
                return j;
            }
        }
        return tab[i];
    }

    public int size() {
        int count = 0;
        for (int j = 0; j < tab.length; j++) {
            if (tab[j] != null) {
                count++;
            }
        }
        /*
        Object[] talla = new Object[count];
        for (int j = 0; j < talla.length; j++) {
            if (tab[j] != null) {
                talla[j] = tab[j];
            }
        }*/
        //return talla.length;
        return count;
    }
}

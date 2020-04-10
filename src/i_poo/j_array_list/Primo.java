package i_poo.j_array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Primo {
    public static void main(String[] args) {
        //Primo   OBTENER LOS FACTORES DE UN NUMERO, OSEA LOS NUMEROS QUE MULTIPLICADOS  dan COMO RESULTADO ESE NUMERO (los divisores)
        //esos numero deben ser primos (un numero primo es divisible por 1 y por el mismo)

        //osea que tenemos que obtener los numero primos dentro de un numero dado que multiplicados dan ese mismo numero
        //Ex 16= 16/2=8  8/2=4   4/2=2   2/2=1     tendriamos 2 * 2 * 2 * 2
        //100/2=50  50/2=25  25/2=? no entondes el denominador avanza 25/5=5    5/5=1
        Scanner sc = new Scanner(System.in);
        int numero;

        ArrayList<Integer> tab = new ArrayList<Integer>();
        int count = 0;
        System.out.println("Ingrese un numero");
        numero = sc.nextInt();

        int i = 2;//i va ir aumentando mientras numero va disminuyendo
        while (i <= numero) {//100 x ejemplo pasara de 100 a 50 a 25 a 5 a 5
            if (numero % i == 0) {
                tab.add(i);//se va poniendo el cociente dentro  100/2  50/2  25/2? no i se incrementa 25/5    5/5
                numero = numero / i;
            } else {
                i++;
            }
            count++;//no necesario solo pa contar iteraciones
        }
        /*PODEMOS IMPRIMIR DE MANERA CLASICA
        for (int j = 0; j < tab.size(); j++) {
            System.out.println(tab.get(j));
        }*/

        //O CON
        System.out.println(tab);  //100    daria    [2, 2, 5, 5]    solo con poner el nombre del tab  ,
        //tab es un objeto voilà y como todos los objetos que heredan de Object este retornara
        // toString()  que da el contenido del objeto

        //**************************************************************************************************************
        //  EN EL CASO DE UN TABLEAU DE OBJETOS , NOS REGRESARIA LA REFERENCIA DE CADA OBJETO EN EL TABLEAU
        //  PERO EN ESTE CASO RETORNA LOS INTEGERS PRESENTES EN EL TABLEAU QUE estan en ArrayList
        //  Se hace un llamado implicita y tacito de la funcion toString() (aun sin ponerlo) de la classe Object
        // A DIFERENCIA D EUN ARREGLO NORMAL EL ArraList no necesita un FOR para mostrar todos los elementos (indices)
        //CREO QUE ES PORQUE LA METODO toString() fue reescrita en la clase de la cual hereda ArrayList (o en ella misma)
        //**************************************************************************************************************

        // numero      100   50  25   25  25  25   5   1
        System.out.println("Numero de iteraciones = " + count); //daria 7 iteraciones  2   2   2    3   4   5    5   5  y la ultima seria la que haria salir del while
        //                                              este ya seria 5<=1?  no, entonces ya no entra y para al for
    }
}

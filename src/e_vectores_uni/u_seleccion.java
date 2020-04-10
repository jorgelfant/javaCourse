package e_vectores_uni;

import java.util.Scanner;

public class u_seleccion {
    public static void main(String[] args) {
    /*Se trata de buscar  el elementos mas pequenio y colocarlo en la 1ra posicion, despues el 2do mas pequenio
    y colocarlo en la segunda posicion, y asi sucesivamente hasta que el arreglo este ordenado
    es decir sacamos el mas pequenio, luego de los que quedan el mas pequenio, luego de los que quedan igual y asi
    sucesivamente

    Ex:     3 | 2 | 5 | 4 | 1
            0   1   2   3   4
            para recorrer esto lo primero seria tener un FOR
            que vaya del primero al penultimo ( no el ultimo) 0 < length-1

            esto significaria crear una variable min=i es decir que minimero tiene el indice 0 al inicio
            depues vamos a verifica de los elementos que nos faltan cual de estos es el menor de todos
            para esto vamos a utilizar otro ciclo FOR para verificar elemento por elemento de los que nos quedan
            cual de todos es el menor

            y de estos numeros el que sea el menor lo pondremos en la posicion de 3 (min) siempre y
            cuando este no sea el menor

            hay 2 ciclos anidados, el primero indica el numero de vueltas, el segundo el recorrido, el primero
            debera tener por lo tanto una iteracion menos para no salir del arreglo length-1
    */

    /*3 | 2 | 5 | 4 | 1
      0   1   2   3   4
    */
        //1  2  5  4  3  primera pasada j=0
        //1  2  5  4  3  segunda pasada j= 1
        //1  2  3  4  5  tercera pasada j= 2
        //1  2  3  4  5  cuarta pasada  j= 3
        int elementos;
        int min;
        int temp;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextInt();
        }

        for (int j = 0; j < tab.length - 1; j++) { //length-1 para que haga las iteraciones exactas y no salga del arreglo
            min = j;//primero indice                   el j comienza desde 0 hasta length-1 porque el for interior comienza por 1
            for (int k = (j + 1); k < tab.length; k++) {//4+1=5 se saldria del arreglo si el primer for fuera hasta length
                if (tab[k] < tab[min]) {//comparamos derecha con izquiera
                    min = k;
                }
            }
            temp = tab[j];
            tab[j] = tab[min];
            tab[min] = temp;
        }
        for (int indice : tab) {
            System.out.print(indice + " ");
        }
    }
}

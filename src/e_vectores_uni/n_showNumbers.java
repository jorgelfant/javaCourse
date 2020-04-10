package e_vectores_uni;

import java.util.Scanner;

public class n_showNumbers {
    public static void main(String[] args) {
    /*Leer 8 numeros enteros dentro de un arreglo.Debemos mostrarlos en el siguiente orden
    el 1ro
    el ultimo
    el segundo
    el penultimo
    el tercero,etc
    */

        int elementos;


        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero ");
            tab[i] = sc.nextInt();
        }

        //2 FORMAS
    /*LA 1ra del video
    for (int i = 0; i < tab.length / 2; i++) {
      System.out.print(tab[i] + " " + tab[tab.length - i - 1] + " "); //funciona con un tableau de numeros pares
      if (i == tab[i]){//esto permitiria imprimir el numero t[i] central si el numero de elmentos del arreglo es impar pero no funciona con for
        System.out.print(tab[i] );   //porque el numero de la division en enteros no tiene decimal
      }                              //todoo tendria que ser double asi si hubieran 9 numeros 9/2=4.5
    }                                //lo cual me permitiria hacer una vuelta mas car en el caso de 4<4.5
    */
        ////LA 12da  1  2  3  4  5  6  7  8  9
        //           0  1  2  3  4  5  6  7  8
        int j = 0;
        int k = tab.length - 1;//porque si por es no fuera -1 el tab tendria un indice de un numero que no existe t[FluentApiTest]
        while (j < k) {//si j <= FluentApiTest imprimiria 2 veces  el numero central, lo cual fue solucionado con el if
            System.out.print(tab[j] + " " + tab[k] + " ");// ou tab[tab.length - j - 1]o lieeu de tab[FluentApiTest]
            j++;
            k--;//se eliminaria remplazando tab[FluentApiTest] por tab[tab.length - j - 1]
            if (j == k) {//esto permite imprimir el numero t[i] entral si el numero de elmentos del arreglo es impar
                System.out.print(tab[j]); //este if podria ir dentro o fuera del while
            }
        }
    }
}

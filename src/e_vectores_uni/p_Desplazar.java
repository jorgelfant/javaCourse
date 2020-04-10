package e_vectores_uni;

import java.util.Scanner;

public class p_Desplazar {
    public static void main(String[] args) {
    /*Crear un programa que lea por teclado un arreglo de 6 numeros
    y la desplace una posicion hacia abajo: el primero pasa a ser el segundo
    el segundo pasa a ser el tercero y asi sucesivamente. El ultimo pasa a ser el primero.
    **/
        //al mover todoo a la derecha de una posicion el ultimpo numero se perderia
        int elementos;
        int temp;//solucion

        Scanner sc = new Scanner(System.in);
        //1 2 3 4 5   c ca que l'on veut  imaginemos que hay 5 elementos
        //1 2 3 5 4  se cambia el indice  4 con el 3
        //1 2 5 3 4   el  3 con el  2
        //1 5 2 4 4   el  2 con el 1
        //5 1 2 3 4   el 1 con el cero
        System.out.println("Ingrese el numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextInt();
        }
    /*ça incremento
    for (int i = 0; i < tab.length - 1; i++) {
      temp = tab[tab.length - 1 - i];
      tab[tab.length - i - 1] = tab[tab.length- i - 2];
      tab[tab.length- i - 2] = temp;
    }*/
        //ou ca decremento
        for (int i = tab.length - 1; i > 0; i--) {
            temp = tab[i];
            tab[i] = tab[i - 1];
            tab[i - 1] = temp;
        }
        for (int indices : tab) {
            System.out.print(indices + " ");
        }
    }
}

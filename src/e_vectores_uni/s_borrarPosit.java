package e_vectores_uni;

import java.util.Scanner;

public class s_borrarPosit {
    public static void main(String[] args) {
    /*Leer por teclado un arreglo de 5 elementos numericos y una posicion (entre 0 y 4).
    Eliminar el elemento situado en la posicion dada sin dejar huecos.
    */
        //tab[5]= 5 7 1 3 2
        //0 1 2 3 4
        int elementos;
        int posicion = 0;//funciona mas o menos como conteo hay que iniciarlo a 0 para recuperar el valor de j
        int numero;      //poder modificarlo dentro del chile y recuperar su valor fuera de este
        boolean siEsta = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar el numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingresar el numero");
            tab[i] = sc.nextInt();
        }
        System.out.println("Ingresar el numero que desea eliminar");
        while (!siEsta) {// esto permite asegurarse qque el numero esta en el tab y obtener su posicion
            numero = sc.nextInt();
            int j = 0;
            while (j < tab.length) {
                if (numero == tab[j]) {
                    siEsta = true;
                    posicion = j;
                }
                j++;
            }
            if (!siEsta) {
                System.out.println("El numero ingresado no esta en el tab, ingrese otro");
            }
        }
        //4 por el numero de iteraciones
        for (int i = posicion; i < (tab.length - 1); i++) {//ou (int i = 0; i < (tab.length - 1) - posicion; i++)
            tab[i] = tab[i + 1];                              //ou  tab[posicion + i] = tab[posicion + 1 + i];
        }
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.println("indice " + i + ": " + tab[i] + "\n");
        }
        //si borro la posicion 3 que contiene 1 debo hacer que los numeros avanzen
        //tab[5]= 5 7 _ 3 2  //el 3 y el 2 deben avanzar y asi al momento de imprimir al final el tab solo
        //tendria 4 elementos
        // si por ejemplo pongo posicion 2 tab[5]= 5 7 1 3 2
        //

    }
}

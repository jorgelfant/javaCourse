package e_vectores_uni;

import java.util.Scanner;

public class o_CresDecrDesor {
    public static void main(String[] args) {
/*Leer por teclado una serie de 5 numeros reales. El programa debe indicarnos si los
numeros estan ordenados de forma cresciente, decreciente o si estan desordenados
 */
        int elementos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite el numero de elementos ");
        elementos = sc.nextInt();
        double[] tab = new double[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextDouble();
        }
        //  0  1  2  3  4  5  6  7  8
        //  1  2  3  4  5  6  7  8  9
        //PRIMER METODO
        boolean cresciente = false;
        boolean decresciente = false;

        for (int j = 0; j < tab.length - 1; j++) {//en 5 numero hay por ejemplo 4 iteraciones 5-1=4      0<4 =4
            if (tab[j] < tab[j + 1]) {//cresciente 1 2 3 4 5 ...como no
                cresciente = true;//la condicion siempre debe tener este valor
            } else if (tab[j] > tab[j + 1]) {//decresciente 5 4 3 2 1 ...
                decresciente = true;//la condicion siempre debe tener este valor
            }
        }
        if (cresciente && !decresciente) {//es necesario las 2 porque sino esto indicaria creciendte tb  1 2 3 2 1 O solo !creciente significa que ta en decreciente xq nunk entro  etc
            System.out.println("El arreglo esta ordenado en orden cresciente");
        } else if (decresciente && !cresciente) {
            System.out.println("El arreglo esta ordenado en orden decresciente");
        } else {
            System.out.println("El arreglo esta desordenado");
        }
/*
   //SEGUNDO METODO QUE HIZE ANTES DE VER EL VIDEO
    int count1 = 0;
    int count2 = 0;
    int j = 0;
    int FluentApiTest = tab.length - 1;

    while (j < FluentApiTest) {
      if (tab[j] < tab[j + 1]) {
        count1++;
      } else if (tab[j] > tab[j + 1]) {
        count2++;
      }
      j++;
    }
    if (count1 == FluentApiTest) {
      System.out.println("El arreglo esta ordenado en orden creciente " + count1);
    }
    else if (count2 == FluentApiTest) {
      System.out.println("El arreglo esta ordenado en orden decreciente " + count2);
    } else {
      System.out.println("El arreglo esta desordenado");
    }
*/
    }
}

package g_vectores_Bid;

import java.util.Scanner;

public class g_diagonalPrincipal {
    public static void main(String[] args) {
        //Hacer un algoritmo que llene una matriz de 4*4 y que almacene
        //la diagonal ObjectA de un arreglo. Imprimir el arreglo resultante
        int filas;
        int columnas;
        int iter;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas");
        filas = sc.nextInt();
        System.out.println("Ahora ingrese el numero de columnas");
        columnas = sc.nextInt();

        int[][] tab = new int[filas][columnas];
        int[] diagonal = new int[filas];//o el numero que tenga filas y columnas debe ser igual
        //******************************************************************************************************************
        //                                INGRESO DE NUMEROS EN LOS INDICES tab [] []
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                System.out.println("Ingrese el indice tab [" + i + "]" + "[" + j + "]");
                tab[i][j] = sc.nextInt();
            }
        }
        //******************************************************************************************************************
        //                                IMPRESION
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println();
        }
        //******************************************************************************************************************
        //                             LLENAR LA DIAGONAL
        //******************************************************************************************************************
    /* 0 1 2 3 00
       5 6 7 8 11
       1 2 3 5 22
       2 5 8 6 33 */
        iter = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == j) {
                    diagonal[iter] = tab[i][j];
                    iter++;
                }
            }
        }
        System.out.println();
        //******************************************************************************************************************
        //                                IMPRIMIRLA
        //******************************************************************************************************************
        for (int i = 0; i < diagonal.length; i++) {//el for de adentro es solo pa imrpimir en la posicion diagonal
            System.out.print(diagonal[i]);
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print("\t");//2 espacios con t
            }
        }
    }
}

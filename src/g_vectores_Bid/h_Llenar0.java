package g_vectores_Bid;

import java.util.Scanner;

public class h_Llenar0 {
    public static void main(String[] args) {
        //MATRIZ DE IDENTIDAD
        //Hacer un algoritmo que llene una matriz de 5*5 y que almacene en la diagonal
        //ObjectA 1s y en las demas posiciones 0s
        int filas;
        int columnas;
        int iter;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas");
        filas = sc.nextInt();
        System.out.println("Ahora ingrese el numero de columnas");
        columnas = sc.nextInt();

        int[][] tab = new int[filas][columnas];
        //******************************************************************************************************************
        //                                LLENADO DE LOS INDICES tab [] [] AUTOMATICAMENTE
        //******************************************************************************************************************

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                if (i == j) {
                    tab[i][j] = i + 1;
                    tab[i][tab.length - i - 1] = tab.length - i;
                }//cuando trabajamos con tab de int los elementos no llenados son 0 automaticamente
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
/*    1	0	0	0	0
      0	1	0	0	0
      0	0	1	0	0
      0	0	0	1	0
      0	0	0	0	1
*/

    }
}

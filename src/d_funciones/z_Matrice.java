package d_funciones;

import java.util.Scanner;

public class z_Matrice {
    public static void main(String[] args) {

        int n;
        int conteo = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamanio de la matriz");
        n = sc.nextInt();
        int[][] tab = new int[n][n];

        //******************************************************************************************************************
        //                                                 LLENAR MATRIZ
        //******************************************************************************************************************
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = conteo++;
            }
        }
        //******************************************************************************************************************
        //                                                 IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (i == 0 || i == tab.length - 1 | j == tab.length - 1 || j == 0 || i == j) {
                    if (tab[i][j] < 10) {
                        System.out.print("0");
                    }
                    System.out.print(tab[i][j] + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}

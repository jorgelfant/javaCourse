package d_funciones;

import java.util.Scanner;

public class z_Matrice_espiralCaracol {
    public static void main(String[] args) {
        //MATRIZ EN CARACOL / ESPIRAl
        //Llenar una matriz cuadrada de n*n, con los valores del 1 à n
        //ordenandolos en forma ascendente en forma de espiral
        int n;
        int conteo = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamanio de la matrix");
        n = sc.nextInt();
        int[][] tab = new int[n][n];
        int a = 0;
        int b = tab.length - 1;
        //******************************************************************************************************************
        //                                                 LLENAR MATRIZ
        //******************************************************************************************************************
        while (a <= b) {//ou for el while se asegura de que se hagan el numero exacto de vueltas
            for (int j = a; j <= b; j++) {
                tab[a][j] = conteo++;
            }
            for (int j = a + 1; j <= b; j++) {
                tab[j][b] = conteo++;
            }
            for (int j = b - 1; j >= a; j--) {
                tab[b][j] = conteo++;
            }
            for (int j = b - 1; j > a; j--) {
                tab[j][a] = conteo++;
            }
            a++;
            b--;
        }
        //******************************************************************************************************************
        //                                                 IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j] < 10) {
                    System.out.print("0");
                }
                    System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
}

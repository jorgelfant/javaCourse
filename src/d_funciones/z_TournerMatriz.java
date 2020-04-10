package d_funciones;

import java.util.Scanner;

public class z_TournerMatriz {
    public static void main(String[] args) {
        //TOURNER UNE MATRIZ COMME SI C'ETAIT UNE PHOTO
        int n;
        int conteo = 1;
        int temp;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la matriz");
        n = sc.nextInt();
        int[][] tab = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tab[i][j] = conteo++;
            }
        }
        //******************************************************************************************************************
        //                                     IMPRESSION DE BASE
        //******************************************************************************************************************
        System.out.println("Matriz ObjectA");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tab[i][j] < 10) {
                    System.out.print("0");
                }
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("\t");
        }
        System.out.println();
        //******************************************************************************************************************
        //                    ETAPE 1: inverser chaque file tourner a gauche
        //******************************************************************************************************************
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = tab[i][j];
                tab[i][j] = tab[i][n - 1 - j];
                tab[i][n - 1 - j] = temp;
            }
        }
        //******************************************************************************************************************
        //                     ETAPE 2 inverser les elements de la 1ere file avec la 1ere colonne sans toucher le 1er indice
        //******************************************************************************************************************
        for (int i = 0; i < n - 1; i++) {//mismo numero que repeticiones
            for (int j = 1 + i; j < n; j++) {// que j = 1 j=2 j=3 porque se le suma i
                temp = tab[i][j];
                tab[i][j] = tab[j][i];
                tab[j][i] = temp;
            }
        }
        //******************************************************************************************************************
        //                                     IMPRESSION
        //******************************************************************************************************************
        System.out.println("Matriz girada a la izquierda");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tab[i][j] < 10) {
                    System.out.print("0");//el ultimo "" es solo pa que no me suligne como repetido
                }
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        //******************************************************************************************************************
        //                                     ETAPE 1 para restaurar la matriz y girarla a la derecha
        //******************************************************************************************************************
        for (int i = 0; i < n - 1; i++) {//mismo numero que repeticiones
            for (int j = 1 + i; j < n; j++) {// que j = 1 j=2 j=3 porque se le suma i
                temp = tab[i][j];
                tab[i][j] = tab[j][i];
                tab[j][i] = temp;
            }
        }
        //******************************************************************************************************************
        //                                     ETAPE 2 se reinvierte cada fila pa dejarla como estaba antes
        //******************************************************************************************************************
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = tab[i][j];
                tab[i][j] = tab[i][n - 1 - j];
                tab[i][n - 1 - j] = temp;
            }
        }
        //******************************************************************************************************************
        //                                     REIMPRESSION
        //******************************************************************************************************************
        System.out.println("Matriz girada a la derecha o restaurada");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tab[i][j] < 10) {
                    System.out.print("0");
                }
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }

    }
}

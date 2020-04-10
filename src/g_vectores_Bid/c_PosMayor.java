package g_vectores_Bid;

import java.util.Scanner;

public class c_PosMayor {
    public static void main(String[] args) {
        // hacer un algoritmo que llene una matriz de 4*4 y determine la posicion [fila, columna] del numero mayor
        //almacenado en la matriz

        int filas;
        int columnas;
        int max;
        int min;
        int posMaxF;
        int posMaxC;
        int posMinF;
        int posMinC;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas");
        filas = sc.nextInt();

        System.out.println("Ahora ingrese el numero de columnas");
        columnas = sc.nextInt();

        int[][] tab = new int[filas][columnas];
        //******************************************************************************************************************
        //                                INGRESO DE NUMEROS EN LOS INDICES tab [] []
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el numero del indice tab [" + i + "]" + "[" + j + "]");
                tab[i][j] = sc.nextInt();
            }
        }
        //******************************************************************************************************************
        //                                               IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.print("\n");//salto de linea
        }
        //******************************************************************************************************************
        //                                       NUMERO  MAYOR Y POSICION
        //******************************************************************************************************************
        max = tab[0][0];//ou 0
        min = tab[0][0];//ou 99999999
        posMaxF = 0; //posicion de fila de max
        posMaxC = 0; //posicion de columna de max
        posMinF = 0;
        posMinC = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tab[i][j] > max) {//max
                    max = tab[i][j];
                    posMaxF = i;
                    posMaxC = j;
                }
                if (tab[i][j] < min) {//min
                    min = tab[i][j];
                    posMinF = i;
                    posMinC = j;
                }
            }
        }
        System.out.println("el numero mayor es " + max + " y se encuentra en la posicion tab [" + posMaxF + "]" + "[" + posMaxC + "]");
        System.out.println("el numero menor es " + min + " y se encuentra en la posicion tab [" + posMinF + "]" + "[" + posMinC + "]");
    }
}

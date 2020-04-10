package g_vectores_Bid;

import java.util.Scanner;

public class f_maxSuma {
    public static void main(String[] args) {
        //Hacer un algoritmo que llene una matriz de 3*4
        //Sumar las columnas et imprimir que columna tuvo la maxima suma
        //y la suma de esa columna
        int filas;
        int columnas;
        int sumaC;
        int max;
        int pos;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numemro de filas");
        filas = sc.nextInt();
        System.out.println("Ahora ingrese el numemro de columnas");
        columnas = sc.nextInt();

        int tab[][] = new int[filas][columnas];
        int[] sumaColumnas = new int[columnas];
        //******************************************************************************************************************
        //                                INGRESO DE NUMEROS EN LOS INDICES tab [] []
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el indice tab [" + i + "]" + "[" + j + "]");
                tab[i][j] = sc.nextInt();
            }
        }
        //******************************************************************************************************************
        //                                                IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println();
        }
        //******************************************************************************************************************
        //                                                   SUMA
        //******************************************************************************************************************
        //esto pa encontrar todas las sumas, o hacer como con el ejercicio primos
        //es decir aqui hayariamos solo la suma de la 1 columna y luego harias 2 boucles anidados
        //con la condicion if (sumaC>max){max=suma_col} esto me sacaria el resultado de max
        //uno a uno sin haber almacenado primero todas las sumas en un tableau
        for (int j = 0; j < columnas; j++) {
            sumaC = 0;
            for (int i = 0; i < filas; i++) {
                sumaC = sumaC + tab[i][j];//ou  sumaC+=sumaC
            }
            sumaColumnas[j] = sumaC;
        }
        //******************************************************************************************************************
        //                                               MAYOR COLUMNA
        //******************************************************************************************************************
        max = sumaColumnas[0];
        pos = 0;

        for (int i = 0; i < sumaColumnas.length; i++) {
            if (sumaColumnas[i] > max) {
                max = sumaColumnas[i];
                pos = i;
            }
        }
        //******************************************************************************************************************
        //                                               IMPRESSION
        //******************************************************************************************************************
        System.out.println("La columna que tuvo la maxima suma es sumaColumnas[" + pos + "]");
        System.out.println("La suma es " + max);

    }
}
package d_funciones;

import java.util.Scanner;

public class v_MatrizPArametro {
    public static void main(String[] args) {
        //Disenie un algoritmo que contiene el sgte menu:
        //1 llenar una matriz de 4x4
        //2 Mostrar la matriz
        //Suma los elementos de la matriz
        //Salir
        int filas;
        int columnas;
        int suma;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las filas");
        filas = sc.nextInt();
        System.out.println("Ingrese las columnas");
        columnas = sc.nextInt();

        int[][] tab = new int[filas][columnas];
        //1
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese un numero");
                tab[i][j] = sc.nextInt();
            }
        }
        //2
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tab[i][j] + " ");

            }
            System.out.println();
        }
        //3
        suma = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma = suma + tab[i][j];
            }
        }
        System.out.println("La suma es " + suma);

    }
}
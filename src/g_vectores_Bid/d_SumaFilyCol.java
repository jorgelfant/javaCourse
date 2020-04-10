package g_vectores_Bid;

import java.util.Scanner;

public class d_SumaFilyCol {
    public static void main(String[] args) {
        //Hacer un algoritmo que llene una matriz de 4*4.
        //Calcular la suma de cada fila y almacenarla en un arreglo
        //calcular la suma de cada columna y almacenarla en otro arreglo

        int filas;
        int columnas;

        int sumaF;
        int sumaC;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de filas");
        filas = sc.nextInt();

        System.out.println("Ingrese el numero de columnas");
        columnas = sc.nextInt();

        int tab[][] = new int[filas][columnas];

        int[] sumaFilas = new int[filas];
        int[] sumaColumnas = new int[columnas];
        //******************************************************************************************************************
        //                                INGRESO DE NUMEROS EN LOS INDICES tab [] []
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.println("Ingrese el numero en el indice [" + i + "]" + "[" + j + "]");
                tab[i][j] = sc.nextInt();
            }
        }
        //******************************************************************************************************************
        //                                          IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tab[i][j] + "\t");
            }
            System.out.println(" ");//con "\n" se harian 2 saltos
        }

        System.out.println(" ");//con "\n" se harian 2 saltos
        //******************************************************************************************************************
        //                                            SUMAS
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {//SUMA DE CADA FILA
            sumaF = 0;//reset pa que no vaya acumulando todas las suma//inicializado dentro
            for (int j = 0; j < columnas; j++) {
                sumaF = sumaF + tab[i][j];
            }
            sumaFilas[i] = sumaF;//sumaFilas[pos] hubiera podido necesitar un iterador pero en este caso no
        }
        //INVERTIMOS
        for (int j = 0; j < columnas; j++) {//SUMA DE CADA COLUMNA
            sumaC = 0;//reset pa que no acumule todas las sumas//inicializado dentro
            for (int i = 0; i < filas; i++) {
                sumaC = sumaC + tab[i][j];//invierto j e i en los for esto me permitira sumar columna a columna
            }
            sumaColumnas[j] = sumaC;//sumaFilas[pos] hubiera podido necesitar un iterador pero en este caso no
        }
        //******************************************************************************************************************
        //                                              RESULTADO
        //******************************************************************************************************************
        for (int i = 0; i < filas; i++) {
            System.out.println("La suma de la fila " + i + " es " + sumaFilas[i]);
        }

        System.out.print("\n");//salto de linea

        for (int i = 0; i < columnas; i++) {
            System.out.println("La suma de la Columna " + i + " es " + sumaColumnas[i] + "\t");
        }
    }
}

package g_vectores_Bid;

import java.util.Scanner;

public class b_llenarMostrar {
  public static void main(String[] args) {
    /* ESTA SERIA LA MANERA MANUAL DE LLENAR UN ARREGLO BIDIMENSIONAL
    //------------------------------------------------------------------------------------------------------------------
    //                                                           METHODO 1
    //------------------------------------------------------------------------------------------------------------------
    //                                            int[][] tab={{1,2,3},{4,5,6},{7,8,9}}
    //                                         String[][] tab={{china,USA},{Pekin,Washington}}
    //                                OU       String[][] tab={{china,Pekin},{USA,Washington}}
    //------------------------------------------------------------------------------------------------------------------
    //                                                           METHODO 2
    //------------------------------------------------------------------------------------------------------------------
    int[][] tab = new int[3][3];  se puede jugar con los indices segun lo que se quiera imprimir

    tab[0][0]=1;                                     tab[0][0]=China;
    tab[0][1]=2;                                     tab[0][1]=USA;
    tab[0][2]=3;
                                                     tab[1][0]=Pekin;
    tab[1][0]=4;                                     tab[1][0]=Washington;
    tab[1][1]=5;
    tab[1][2]=6;                                          OU

    tab[3][0]=7;                                      tab[0][0]=China;
    tab[3][1]=8;                                      tab[0][1]=Pekin;
    tab[3][2]=9;                                      tab[1][0]=Usa;
    */                                         //     tab[1][1]=China;
    //******************************************************************************************************************
    //                                             METODO AUTOMATICO
    //******************************************************************************************************************

    int filas;
    int columnas;
    int numero;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese el numero de filas");
    filas = sc.nextInt();

    System.out.println("Ahora ingrese el numero de columnas");
    columnas = sc.nextInt();

    int[][] tab = new int[filas][columnas];
    //******************************************************************************************************************
    //                                INGRESO DE NUMEROS EN LOS INDICES tab [] []
    //******************************************************************************************************************
    for (int i = 0; i < filas; i++) {//FILAS
      for (int j = 0; j < columnas; j++) {//COLUMNAS por fila
        System.out.println("Ingrese el numero del indice tab[" + i + "]" + "[" + j + "]");
        tab[i][j] = sc.nextInt();
      }
    }
    //******************************************************************************************************************
    //                                              IMPRESSION
    //******************************************************************************************************************
    for (int i = 0; i < filas; i++) {
      for (int j = 0; j < columnas; j++) {
        System.out.print(tab[i][j] + "\t");
      }
      System.out.print("\n");//salto de linea
    }
    /*
       1	 2 	3
       4	 5	6
       7	 8	9  */
    //******************************************************************************************************************
    //                                       IMPRESSION CON FOR EACH
    //******************************************************************************************************************

    for (int ein[] : tab) {
      for (int zwei : ein) {
        System.out.print(zwei + "\t");
      }
      System.out.print("\n");//salto de linea
    }
  }
}

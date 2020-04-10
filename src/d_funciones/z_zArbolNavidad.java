package d_funciones;

import java.util.Scanner;

public class z_zArbolNavidad {
    public static void main(String[] args) {
        //ARBOLITO DE NAVIDAD
        /*
         *
         ***
         *****
         *******
         *********
         ***********
         *************
         *****
         *****
         */
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de niveles del arbol");
        n = sc.nextInt();
        int div = (n * 2) - 1;
        //******************************************************************************************************************
        //                                  IMPRESION ARBOL
        //******************************************************************************************************************
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < div; j++) {                  //j=0  8>=j<=8       8
                if (j >= (div / 2) - i && j <= (div / 2) + i) {//j=1  7>=j<=9     7 8 9
                    if (j % 2 == 0) {                            //j=2  6>=j<=10  6 7 8 9 10   etc
                        System.out.print("*");
                    } else {
                        System.out.print("o");
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //******************************************************************************************************************
        //                                  TRONCO AJUSTABLE
        //******************************************************************************************************************
        int a;
        a = (n > 10) ? 3 : 2;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < div; j++) {
                if (n < 10) {
                    if (j == div / 2 - 1) {
                        System.out.print("/|\\");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    if (j == div / 2 - 2) {
                        System.out.print("/|||\\");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        //******************************************************************************************************************
        //                                  BASE DEl TRONCO
        //******************************************************************************************************************
        for (int i = 0; i < n * 2; i++) {//0<18
            if (i == div / 2 - 2) {
                System.out.print("=====");
            } else {
                System.out.print(" ");
            }
        }

    }
}
/*
 OU
 int n
 for (int i = 0; i < n; i++) {
      for (int j = (n - i); j > 0; j--) {
        System.out.print(" ");
      }
        for (int FluentApiTest = n - (2 * i + 1); FluentApiTest < n; FluentApiTest++) {
          System.out.print(i % n);
        }
        System.out.println();
      }

* */

package d_funciones;

import java.util.Scanner;

public class y_MaxComunDivisor {
    public static void main(String[] args) {
/*
   Con dos arreglos numericos, sacar los divisores y encontrar "EL mayor Divisor Comun"
   y mostrarlo por Pantalla. por ejemplo arreglo de 90 y arreglo de 30
   el mayor divisor comun seria 30"﻿
*/
        int sizeT1;
        int sizeT2;
        int maxCD;

        Scanner sc = new Scanner(System.in);
        //******************************************************************************************************************
        //INGRESAMOS los 2 numeros
        //******************************************************************************************************************
        System.out.println("Ingrese el tamanio del primer arreglo");
        sizeT1 = sc.nextInt();
        int[] tab1 = new int[sizeT1];

        System.out.println("Ingrese el tamanio del segundo arreglo");
        sizeT2 = sc.nextInt();
        int[] tab2 = new int[sizeT2];
        //******************************************************************************************************************
        //no se cuantos divisores habran asi que al arreglo de divisores comunes
        //les dare un tamanio maximizado de tamanio del arreglo 1 + el arreglo 2
        //******************************************************************************************************************
        int[] divisores = new int[sizeT1 + sizeT2]; //aunque no hay tantos deno comunes
        //******************************************************************************************************************
        //LLENAMOS CADA UNO DE LOS 2 ARREGLOS CON SUS DIVISORES
        //******************************************************************************************************************
        for (int i = 1; i <= tab1.length; i++) {//en las divisiones el divisor debe empezar en 1
            if (sizeT1 % i == 0)
                tab1[i - 1] = i;
        }
        for (int i = 1; i <= tab2.length; i++) {//en las divisiones el divisor debe empezar en 1
            if (sizeT2 % i == 0)
                tab2[i - 1] = i;
        }
        //******************************************************************************************************************
        // MOSTRAMOS los divisores de ambos ARREGLOS ACCESORIO
        //******************************************************************************************************************
        for (int i = 0; i < tab1.length; i++) {
            if (tab1[i] != 0) {//para que no muestre los 0s
                System.out.print(tab1[i] + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < tab2.length; i++) {
            if (tab2[i] != 0) {//para que no muestre los 0s
                System.out.print(tab2[i] + " ");
            }
        }
        //******************************************************************************************************************
        //Aqui obtenemos todos los divisores comunes y los ponemos en un arreglos de divisores
        //******************************************************************************************************************
        for (int i = 0; i < tab1.length; i++) {//Funciona porque en cada tab cada divisor solo esta una vez
            for (int j = 0; j < tab2.length; j++) {
                if (tab1[i] == tab2[j]) {
                    divisores[i] = tab1[i];
                }
            }
        }
        System.out.println();
        //******************************************************************************************************************
        //BUSCAMOS EL MAYOR COMUN DIVISOR en el ARREGLO DE DIVISORES
        //******************************************************************************************************************
        maxCD = divisores[0];
        for (int i = 0; i < divisores.length; i++) {
            if (divisores[i] > maxCD) {
                maxCD = divisores[i];
            }
        }
        System.out.println("MAXCD = " + maxCD);
    }
}

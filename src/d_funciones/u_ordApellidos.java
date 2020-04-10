package d_funciones;

import java.util.Scanner;

public class u_ordApellidos {
    public static void main(String[] args) {
        //Disenar un algoritmo que pida al usuario 5 apellidos
        //los almacene en un arreglo y posteriormente muestre
        //apellidos ordenados alfabeticamente
        Scanner sc = new Scanner(System.in);
        int numero;
        String temp;

        System.out.println("Ingrese el numero de apellidos");
        numero = sc.nextInt();
        String[] apellidos = new String[numero];
        //****************************************************************************

        sc.nextLine();//important après un int
        for (int i = 0; i < apellidos.length; i++) {
            System.out.println("Ingrese el apellido " + i);
            apellidos[i] = sc.nextLine();
        }
        //**********************ORDENAR CON CUALQUIERA DE LOS METODOS DE ORDENAMIENTO******************
        boolean ordenado = false;
        int conteo = 0;
        while (!ordenado) {//este while replaza al for exterior
            ordenado = true;
            //for (int i = 0; i < apellidos.length; i++) {
            for (int j = 0; j < apellidos.length - 1; j++) {
                if (apellidos[j].charAt(0) > apellidos[j + 1].charAt(0)) {
                    temp = apellidos[j];
                    apellidos[j] = apellidos[j + 1];
                    apellidos[j + 1] = temp;
                    ordenado = false;
                }
            }
            if (!ordenado) {
                conteo++;
            }
            // }
        }
        //****************************************************************************
        for (int i = 0; i < apellidos.length; i++) {
            System.out.print(apellidos[i] + " ");
        }
        System.out.println();//salto de linea
        System.out.println("El arreglo se ordeno en " + conteo + " vueltas");

    }
}

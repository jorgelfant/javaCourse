package e_vectores_uni;

import java.util.Scanner;

public class u_BurbujaMejoradaDo {
    public static void main(String[] args) {
        //Burbuja mejorada con do While

        int elementos;
        int numero;
        boolean ordenado;
        int temp;
        int conteo = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de elementos del arreglo");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            numero = sc.nextInt();
            tab[i] = numero;
        }

        do {
            ordenado = true;
            for (int j = 0; j < tab.length - 1; j++) {
                if (tab[j] > tab[j + 1]) {
                    temp = tab[j];
                    tab[j] = tab[j + 1];
                    tab[j + 1] = temp;
                    ordenado = false;
                }
            }
            if (!ordenado) {//me cuenta las vueltas
                conteo++;
            }
        } while (!ordenado);

        System.out.println("El arreglo se ha ordenado en " + conteo + " vueltas");

        for (int indice : tab) {
            System.out.print(indice + " ");
        }

    }
}

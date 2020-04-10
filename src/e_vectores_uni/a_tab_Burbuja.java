package e_vectores_uni;

import java.util.Scanner;

public class a_tab_Burbuja {
    public static void main(String[] args) {
        //Rellenar un arreglo con 10 numeros y mostrarlos en orden ascendente
        //METODO BURBUJA
        int temp;
        int[] tab = new int[10];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextInt();
        }
        for (int j = 0; j < tab.length - 1; j++) {
            for (int k = 0; k < tab.length - 1; k++) {
                if (tab[k] > tab[k + 1]) {
                    temp = tab[k];
                    tab[k] = tab[k + 1];
                    tab[k + 1] = temp;
                }
            }
        }
        for (int indices : tab) {//affiche le tableau ordonné , el ultimo arreglo es bueno con for each
            System.out.print(indices + " ");
        }
    }
}

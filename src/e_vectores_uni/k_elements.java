package e_vectores_uni;

import java.util.Scanner;

public class k_elements {

    public static void main(String[] args) {
        //Crear un arreglo donde el usuario indique el tamanio por teclado, luego llenar
        //con numeros aleatorios entre 1-100 y por ultimo mostrar los elementos del arreglo
        Scanner sc = new Scanner(System.in);
        int elementos;

        do {
            System.out.println("Indique el numero de elementos (debe ser mayor a 0) ");
            elementos = sc.nextInt();
        } while (elementos <= 0);

        int[] tab = new int[elementos];

        for (int i = 0; i < tab.length; i++) {
            tab[i] = (int) (Math.random() * 100);//declarar el randon dentro de la boucle si es afuera saldria el mismo numero repetido
        }
        for (int indices : tab) {
            System.out.print(indices + " ");
        }

    }


}


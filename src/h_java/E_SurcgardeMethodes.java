package h_java;

import java.util.Scanner;

public class E_SurcgardeMethodes {
    public static void main(String[] args) {
        /*
        La surcharge de méthode consiste à garder le nom d'une méthode (donc un type de traitement à faire : pour nous,
         lister un tableau) et à changer la liste ou le type de ses paramètres. Dans le cas qui nous intéresse, nous
         voulons que notre méthode parcourirTableau puisse parcourir n'importe quel type de tableau. Nous allons donc
         surcharger notre méthode afin qu'elle puisse aussi travailler avec des int

         La surcharge de méthode fonctionne également en ajoutant des paramètres à la méthode.

         Por ejemplo si los 2 ultimos metodos uno de los 2 tiene un parametro suplementaire, ca marche aussi
        */
        Scanner sc = new Scanner(System.in);
        int tamanio;
        System.out.println("Ingrese el tamanio del arreglo");
        tamanio = sc.nextInt();

        int[] tabTransition = llenarTab(tamanio);//tabTransition contendria solo la referencia al tab del metodo
        parcourirTableau(tabTransition);

        //parcourirTableau(llenarTab(tamanio));en una sola linea

    }

    static int[] llenarTab(int taille) {//metodo para llenar un tableau
        Scanner sc = new Scanner(System.in);
        int[] tab = new int[taille];

        for (int i=0;i<tab.length;i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextInt();
        }
        return tab;//OU parcourirTableau(tab); en ese caso cambiariamos a void
    }

    static void parcourirTableau(String[] tab) {
        for (String str : tab)
            System.out.println(str);
    }

    static void parcourirTableau(int[] tab) {//este podria por ex tener un parametro adicional y igual funciona
        System.out.println("Impresion tableau");
        for (int str : tab)
            System.out.println(str);
    }
}
/*
EXEMPLO
String[] tabStr = {"toto", "titi", "tata"};
int[] tabInt = {1, 2, 3, 4};
String[][] tabStr2 = {{"1", "2", "3", "4"}, {"toto", "titi", "tata"}};

//La méthode avec un tableau de String sera invoquée
parcourirTableau(tabStr);

//La méthode avec un tableau d'int sera invoquée
parcourirTableau(tabInt);

//La méthode avec un tableau de String à deux dimensions sera invoquée
parcourirTableau(tabStr2);

*/

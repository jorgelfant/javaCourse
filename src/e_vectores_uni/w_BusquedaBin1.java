package e_vectores_uni;

import java.util.Scanner;

public class w_BusquedaBin1 {
    public static void main(String[] args) {
        //BUSQUEDA BINARIA
        // Para que se pueda aplicar la busqueda binaria a un arreglo, este debe estar previamente ordenado ascendentemente
        //es decir ORDENADO
        //Se trata de dividir el espacio de busqueda en sucesivas mitades hasta encontrar el elemento buscado o hasta que ya
        //no pueda hacer mas mitades

        //Primero hayamos el indice de la mitad del arreglo y miramos si el elemento coincide con el, si no coincide averiguamos
        //donde deberia estar el elemento buscado, si en la parte derecha o en la parte izquierda, y dentro de esa mitad
        //hago lo mismo succesivamente

        //EX: 3 4 5 6 7    5 elementos ordenados
        //    0 1 2 3 4
        int elementos;
        boolean ordenado = false;
        int temp;
        int conteo = 0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el numero de elementos");
        elementos = sc.nextInt();
        int[] tab = new int[elementos];

        //------------------------------------------------------------------------------------------
        //INGRESO LOS ELEMENTOS
        //------------------------------------------------------------------------------------------
        for (int i = 0; i < tab.length; i++) {
            System.out.println("Ingrese un numero");
            tab[i] = sc.nextInt();
        }
        //------------------------------------------------------------------------------------------
        //ORDENAMIENTO   porque no se sabe si estan ordenados
        //------------------------------------------------------------------------------------------
        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < tab.length - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    ordenado = false;
                }
            }
            if (!ordenado) {
                conteo++;
            }
        }
        //IMPRESSION
        if (conteo > 0) {//para que solo me diga en cuantas vueltas se arreglo el arreglo si es que hubo vueltas, que solo hay en caso de desorden
            System.out.println("El arreglo se ordeno en " + conteo + " vueltas");
        }//si este if no se cumple quiere decir que el arreglo fue insertado de manera ordenada, sin necesidad de ordenar
        else {
            System.out.println("El arreglo fue insertado de manera ordenada");
        }
        for (int indice : tab) {
            System.out.println(indice + " ");
        }
        //------------------------------------------------------------------------------------------
        //ENCONTRAR EL NUMERO DESEADO ---BUSQUEDA BINARIA
        //------------------------------------------------------------------------------------------
        boolean encontrado = false;
        int inf = 0;// primer indice del arreglo
        int sup = tab.length;//numero de elementos del arreglo
        int numero;//numero que voy a buscar
        int j = 0; //pour el while
        int pos = 0;
        int mitad = (inf + sup) / 2; // 5/2 por ejemplo seria 2 porque solo se coje la parte entera
        //las 2 primeras condiciones trabajando juntas evitan que hagamos mas vueltas que las necesarias
        //si solo pusiera j < tab.length habrian vueltas de mas
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        // 3  4  5  6  7
        // 0  1  2  3  4    si el numero buscado fuera 6
        System.out.println("Ingrese el numero que desea buscar");
        numero = sc.nextInt();
        //las 2 primeras condiciones evitan que se haga mas vueltas innecesarias de las que se debe
        while (inf <= sup && j < tab.length && !encontrado) {
            if (tab[mitad] == numero) {//1ra condicion a evluar, si el numero que busco ta en la mitad
                encontrado = true;
                //pos = mitad;//guardariamos la posicion en pos
            } else if (tab[mitad] > numero) {//2da condicion si esto se cumpliera el elemento que busco estaria a
                sup = mitad;                   //la izquierda de la mitad del tab
                mitad = (inf + sup) / 2;//1
            } else {//3ra condicion a evaluar
                inf = mitad;//2
                mitad = (inf + sup) / 2; //si el numero buscado fuera 6    2+5 = 7/2   3.5  osea 3
            }
            j++;
        }
        //IMPRESSION
        if (!encontrado) {//si el numero que busco no esta en el arreglo entonces esta condicion siempre sera falsa
            System.out.println("El numero ingresado no esta en el tab");
        } else {
            System.out.println("El numero se encontraba en la posicion " + mitad);//o pos
        }//el hecho de no buscar en cada indice reduce el tiempo de busqueda
    }
}
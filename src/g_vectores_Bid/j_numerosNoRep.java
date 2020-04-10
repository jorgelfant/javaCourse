package g_vectores_Bid;

import java.util.Scanner;

public class j_numerosNoRep {
    public static void main(String[] args) {
        //INGRESAR VALOR A UN ARREGLO DE TAMANIO N SIN QUE SE REPITAN
        int tamanioTab;
        int numero;
        int conteo = 0;
        boolean noEstaRep;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamanio del arreglo");
        tamanioTab = sc.nextInt();
        int[] tab = new int[tamanioTab];
        //******************************************************************************************************************
        //           un While porque solo va a avanzar cuando el numero no este repetido..numero de vueltas no conocido
        //******************************************************************************************************************
        while (conteo < tab.length) {//no for; porque el conteo solo va a aumentar cuando el numero no te repetido
            noEstaRep = true;
            System.out.println("Ingresar un numero");
            numero = sc.nextInt();

            for (int i = 0; i < conteo; i++) {//este for es como un filtro que nos permite saber si el numero se repite
                if (numero == tab[i]) {//si solo entra aqui es que el numero se repite y esto cambia el valor por default que es true
                    noEstaRep = false;
                }
            }
            //****************************************************************************************************************
            if (noEstaRep) {//si es verdadero , es decir el filtro for no ha cambiado nada
                tab[conteo] = numero;
                conteo++;
            } else {
                System.out.print("El numero ya fue ingresado, vuelva a ");
            }
        }
        //******************************************************************************************************************
        //                                       IMPRESSION
        //******************************************************************************************************************
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
    }
}

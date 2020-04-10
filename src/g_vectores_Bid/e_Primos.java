package g_vectores_Bid;

import java.util.Scanner;

public class e_Primos {

    public static void main(String[] args) {
        //hacer un algoritmo que lea n números y que almacene en un vector los 10 primeros números que sean
        // primos.El algoritmo deberá terminar cuando se llene el vector.

        int numero;
        int conteo;
        int iter = 0;
        int[] tab = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero ");
        numero = sc.nextInt();
        int i = 1;
        while (i <= numero && iter < tab.length) {//10
            conteo = 0;//reset de conteo
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    conteo++;
                }
            }//si utilisara i en vez de iter, este seguiria aumentando sea primo o no lo cual llena mi tab con numeros primos
            if (conteo <= 2) {                                                                               //y no primos
                tab[iter] = i;
                iter++;
            }
            i++;
        }
        //desde 0 solo cuando se entre a la condicion...del 1 a 10 solo hay 5 primos el resto seria relleno
        for (int k = 0; k < tab.length; k++) {
//      if (tab[FluentApiTest] != 0) { esto solo se aplica en un tab grande pa extraer la mitad de valores o que no sean 0
            System.out.print(tab[k] + "\t");
//      }
        }


    }
}

package e_vectores_uni;

import java.util.Scanner;

public class i_numMagico {
    public static void main(String[] args) {
        //NUMERO MAGICO
        int aleatorio = (int) (Math.random() * 100);
        int intentos = 0;
        int numero;//x=0
        int[] repeat = new int[100];//importante decir que hay 100 numeros

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero");

        do {//OU x==0 y si numero = aleatorio  x cambia a 1 y se acaba
            intentos++;
            numero = sc.nextInt();
            if (numero <= 100) {
                repeat[numero] += 1;
                if (numero > aleatorio) {
                    if (repeat[numero] > 1) {
                        System.out.println(numero + " ya fue ingresado, Inserte un numero mas pequenio");
                    } else {
                        System.out.println("Inserte un numero mas pequenio");
                    }
                }
                if (numero < aleatorio) {
                    if (repeat[numero] > 1) {
                        System.out.println(numero + " ya fue ingresado, Inserte un numero mas grande");
                    } else {
                        System.out.println("Inserte un numero mas grande");
                    }
                }
            } else {
                System.out.println("Inserte un numero entre 1 y 100");
            }
        } while (numero != aleatorio);

        System.out.println("El numero era " + numero + " y lo encontraste en " + intentos + " intentos");
    }
}

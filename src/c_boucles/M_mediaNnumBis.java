package c_boucles;

import java.util.Scanner;

public class M_mediaNnumBis {
    public static void main(String[] args) {
        //Programa que calcula la media de n numeros, se seguiran pidiendo numeros hasta que se introduzca 0
        int suma = 0;
        int numero = 1;
        int i = 0;
        char resp;
        Scanner sc = new Scanner(System.in);

        while (numero != 0) {
            System.out.println("Ingrese un numero");
            numero = sc.nextInt();
            suma = suma + numero;
            if (numero != 0) {//evita que cuente el 0 que pongo para que el programa se pare
                i++;
                if (i % 5 == 0) {
                    do {
                        System.out.println("Has ingresado ya " + i + " numeros, deseas continuar (Si/No)?");
                        sc.nextLine();
                        resp = sc.nextLine().charAt(0);//para que un string pueda ser insertado despues de un int
                    } while (resp != 's' && resp != 'n');

                    if (resp != 's') {//evita que cuente el 0 que pongo para que el programa se pare
                        numero = 0;
                    }
                }
            }
        }
        System.out.println("La media de " + i + " numeros es " + (suma / i));//sin el if hubiera puesto suma/i-1

    }
}

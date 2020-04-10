package d_funciones.m_divisible;

import java.util.Scanner;

public class Divisible {//determinar si un numero es divisible por otro e imprimir divisible o sino no divisible

    public static void main(String[] args) {
        int numero1;
        int numero2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero");
        numero1 = sc.nextInt();
        numero2 = sc.nextInt();

        div(numero1, numero2);
    }
    //FUNCION
    private static void div(int numero1, int numero2) {
        int div = numero1 % numero2;//ou div=numero1 % numero2
        if (div == 0) {//if (div == 0)
            System.out.println("El numero " + numero1 + " es divisible por " + numero2);
        } else {
            System.out.println("El numero " + numero1 + " no es divisible por " + numero2);
        }
    }
}

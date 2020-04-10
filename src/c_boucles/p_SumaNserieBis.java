package c_boucles;

import java.util.Scanner;

public class p_SumaNserieBis {
    public static void main(String[] args) {
        //Ingresar x real y n! entero positivo n es factorial
        // S=1+x/1! + x^2/2! + x^3/3! + ...,x^n/n
        int n;
        double x;
        double suma = 1;
        int i = 1;
        int factorial = 1;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero de iteraciones");
        n = sc.nextInt();
        System.out.println("Ingrese el numerador");
        x = sc.nextDouble();

        while (i <= n) {
            factorial = factorial * i;//almacena el valor
            suma = suma + (Math.pow(x, i) / factorial);
            i++;
        }
        System.out.println("La suma es " + suma + " " + Math.pow(x, i) + " " + factorial);//i tiene una iteracion de mas
    }
}

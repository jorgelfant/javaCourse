package c_boucles;

import java.util.Scanner;

public class p_SumaNserie {
    public static void main(String[] args) {
        //Calcular la suma de los N terminos de la siguiente serie
        //S= 1-1/2 + 1/3 - 1/4 + 1/5 -1/6 + ...1/N
//1:pedir n numeros
        //2: variable suma
        double n;
        double suma = 0;
        double invariante = 1;
        double i = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de terminos");
        n = sc.nextInt();

        while (n <= 0) {
            System.out.println("Ingrese el numero mayor que 0");
            n = sc.nextInt();
        }
        while (i <= n) {
            suma = suma + invariante / i;
            invariante = invariante * -1;
            i++;
        }

        System.out.println("La suma de los " + n + "elementos es " + suma);


    }
}

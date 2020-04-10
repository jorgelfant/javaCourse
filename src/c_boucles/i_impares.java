package c_boucles;

import java.util.Scanner;

public class i_impares {
  public static void main(String[] args) {
    /*Hacer un programa que imprima la suma de todos los numeros pares que hay desde 1 hasta n, y diga cuantos numeros hay*/

    int n;
    int suma = 0;
    int count = 0;
    Scanner sc = new Scanner(System.in);
    System.out.println("Cuantos numeros quiere ?");
    n = sc.nextInt();

    for (int i = 1; i <= n; i++) {//while(i<n)
      if (i % 2 != 0) {
        suma = suma + i;
        count++;
      }
    }
    System.out.println("La suma de los "+ count +" numeros pares es " + suma );
  }
}

package c_boucles;

import java.util.Scanner;

public class a_for5 {
  public static void main(String[] args) {
    //Suma de 5 numeros
    int n;
    int suma = 0;
    int numero;
    int i = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Cuantos numeros desea sumar?");
    n = sc.nextInt();
/*
    for (int i = 1; i <= n; i++) {
      suma = suma + i;
    }
    System.out.println("La suma de los " + n + " numeros es " + suma);
    */
/*
    for (int i = 0; i < n; i++) {
      System.out.println("Ingrese el numero " + (i + 1));
      numero = sc.nextInt();
      suma = suma + numero;
    }
    System.out.println("La suma de los 5 numeros es " + suma);
    OU
*/
    while (i < n) {
      System.out.println("Ingrese el numero " + (i + 1));
      numero = sc.nextInt();
      suma = suma + numero;
      i++;
    }
    System.out.println("La suma de los 5 numeros es " + suma);
  }
}

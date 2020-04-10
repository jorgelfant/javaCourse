package c_boucles;

import java.util.Scanner;

public class M_mediaNnum {
  public static void main(String[] args) {
    //Programa que calcula la media de n numeros
    int suma = 0;
    int n;
    int numero;
    Scanner sc = new Scanner(System.in);
    System.out.println("Cuantos numeros ?");
    n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      System.out.println("Digite un numero");
      numero = sc.nextInt();
      suma = suma + numero;
    }
    System.out.println("La media de  " + n + " numeros es " + (suma / n));
  }
}

package c_boucles;

import java.util.Scanner;

public class j_2numerosBis {

  public static void main(String[] args) {
    //Programa que pide 2 numeros y muestre todos los numeros que van del 1 al 2do. se debe controlar qu elos valores
    //sean correctos
    int n1, n2;

    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese 2 numeros");
    n1 = sc.nextInt();
    n2 = sc.nextInt();

    if (n1 < n2) {
      for (int i = n1; i <= n2; i++) {
        System.out.println(i);
      }
    } else {
      System.out.println("El primer numero debe ser inferior al segundo, vuelva a intentarlo");
    }
  }
}

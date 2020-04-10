package b_condicionales;

import java.util.Scanner;

public class m_3nCreciente {
  public static void main(String[] args) {
//Programa que pide 3 numeros y detecta si estan en orden creciente
    int n1, n2, n3;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el primer numero");
    n1 = sc.nextInt();
    System.out.println("Ingrese el primer numero");
    n2 = sc.nextInt();
    System.out.println("Ingrese el primer numero");
    n3 = sc.nextInt();

    if (n1 < n2 && n2 < n3) {
      System.out.println("Se han introducido en orden creciente");
    } else {
      System.out.println("No se han introducido en orden creciente");
    }
  }
}

package b_condicionales;

import java.util.Scanner;

public class f_posNeg {//Ingresar 2 numero e imprimir solo los positivos

  public static void main(String[] args) {
    int n1, n2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el primer numero ");
    n1 = sc.nextInt();
    System.out.println("Ingrese el segundo numero ");
    n2 = sc.nextInt();

    if (n1 > 0 && n2 > 0) {
      System.out.println("Ambos son positivos ");
    } else if (n1 < 0 && n2 < 0) {
      System.out.println("Ambos son negativos ");
    } else if (n1 > 0) {
      System.out.println("solo " + n1 + " es positivo ");
    } else  {
      System.out.println("solo " + n2 + " es positivo ");
    }

  }
}

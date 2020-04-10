package b_condicionales;

import java.util.Scanner;

public class d_parImpar {
  public static void main(String[] args) {//determinar si un numero es par impar o cero
    int numero;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero ");
    numero = sc.nextInt();

    if (numero == 0) {
      System.out.println("El numero es cero");
    } else if (numero % 2 == 0) {
      System.out.println("El numero es par");
    } else {
      System.out.println("El numero es impar");
    }
  }
}

package b_condicionales;

import java.util.Scanner;

public class m_3numerosM {
  public static void main(String[] args) {
//Programa que pide 3 numeros e indica si la multiplicacion de los 2 primero es igual al 3er
    int n1, n2, n3;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el primer numero");
    n1 = sc.nextInt();
    System.out.println("Ingrese el primer numero");
    n2 = sc.nextInt();
    System.out.println("Ingrese el primer numero");
    n3 = sc.nextInt();

    if (n1 * n2==n3) {
      System.out.println("El 3er numero " + n3 + " es igual a la multiplicacion del 1er " + n1 + " y el segundo " + n2);
    } else {
      System.out.println("No se cumple");
    }
  }
}

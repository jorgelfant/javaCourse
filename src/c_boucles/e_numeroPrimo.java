package c_boucles;

import java.util.Scanner;

public class e_numeroPrimo {
  public static void main(String[] args) {
//Digite un numero y determine si es primo o no
// numero primo si solo se puede dividir entre 1 y el mismo
    int n;
    int count = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese un numero");
    n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        count = count + 1;
      }
    }
    if (count <= 2) {
      System.out.println(n + " es un numero primo");
    } else {
      System.out.println(n + " no es un numero primo");
    }
  }
}

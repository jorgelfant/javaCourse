package c_boucles;

import java.util.Scanner;

public class d_SumarParesmn {
  public static void main(String[] args) {
    //SUMAR pares de n a m
    int n;
    int m;
    int suma = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresar el inicio");
    n = sc.nextInt();
    System.out.println("Ingresar el final");
    m = sc.nextInt();
    for (int i = n; i <= m; i++) {
      if (i % 2 == 0) {
        suma = suma + i;
      }
    }
    System.out.println("La suma de los numeros pares es " + suma);
  }
}

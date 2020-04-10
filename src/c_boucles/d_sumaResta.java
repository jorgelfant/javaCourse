package c_boucles;

import java.util.Scanner;

public class d_sumaResta {
  public static void main(String[] args) {
    //SUMAR 1-2+3-4
    int n;
    int suma=0;
//vemos que los numero pares son negativos y los impares positivos
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingresar un numero");
    n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      if (i % 2 == 0) {
        suma = suma - i;
      }
      else{
        suma = suma + i;
      }
    }
    System.out.println("La suma es "+suma);
  }
}

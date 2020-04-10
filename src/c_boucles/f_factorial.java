package c_boucles;

import java.util.Scanner;

public class f_factorial {
  public static void main(String[] args) {
//factorial de un numero 6*5*4*3*2*1   o1*2*3*4*5*6   factorial de 6
    int n;
    int factorial = 1;
    int suma = 0;
    Scanner sc = new Scanner(System.in);

    System.out.println("Ingrese un numero");
    n = sc.nextInt();

    for (int i = 1; i <= n; i++) {
      factorial = factorial * i;//comme avec multi factorial=factorial*i
      suma = suma + factorial;
    }
    System.out.println("El factorial de " + n + " es " + factorial);//ex fact de 4 = 1*2=2 2*3=6 6*4=24
    System.out.println("El factorial de los factoriales " + " es " + suma);//suma 1+2+6+24
  }
}

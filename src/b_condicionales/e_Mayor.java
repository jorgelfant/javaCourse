package b_condicionales;

import java.util.Scanner;

public class e_Mayor {
  public static void main(String[] args) {//determinar si un numero es par impar o cero
    int n1, n2, n3, mayor;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el primer numero ");
    n1 = sc.nextInt();
    System.out.println("Ingrese el segundo numero ");
    n2 = sc.nextInt();
    System.out.println("Ingrese el tercer numero ");
    n3 = sc.nextInt();

    if (n1 > n2 && n1 > n3 ) {
      mayor = n1;
    } else if (n2 > n1 && n2 > n3) {
      mayor = n2;
    } else {
      mayor = n3;
    }
    System.out.println("El mayor es " + mayor);
  }
}

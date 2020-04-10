package b_condicionales;

import java.util.Scanner;

public class q_ordenar4Numeros {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a, b, c, d, temp;

    System.out.println("Ingresar numero");
    a = sc.nextInt();
    System.out.println("Ingresar numero");
    b = sc.nextInt();
    System.out.println("Ingresar numero");
    c = sc.nextInt();
    System.out.println("Ingresar numero");
    d = sc.nextInt();

    if (a > b) {//cambio los valores
      temp = a;
      a = b;
      b = temp;
    }
    if (a > c) {
      temp = a;
      a = c;
      c = temp;
    }
    if (a > d) {
      temp = a;
      a = d;
      d = temp;
    }
    if (b > c) {
      temp = b;
      b = c;
      c = temp;
    }
    if (b > d) {
      temp = b;
      b = d;
      d = temp;
    }
    if (c > d) {
      temp = c;
      c = d;
      d = temp;
    }
    System.out.println(a + " " + b + " " + c + " " + d);
  }
}

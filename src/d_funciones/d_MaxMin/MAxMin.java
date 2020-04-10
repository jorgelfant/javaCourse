package d_funciones.d_MaxMin;

import java.util.Scanner;

public class MAxMin {
  public static void main(String[] args) {
    int numero;
    int numero2;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese dos numeros");
    numero = sc.nextInt();
    numero2 = sc.nextInt();

    MaxMin(numero,numero2);
  }

  private static void MaxMin(int numero, int numero2) {//public static void MaxMin ou public void MaxMin
    if (numero > numero2) {
      System.out.println("El mayor es el primero "+ numero);
    } else {
      System.out.println("El mayor es el segundo "+ numero2);
    }
  }
}

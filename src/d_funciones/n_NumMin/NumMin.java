package d_funciones.n_NumMin;

import java.util.Scanner;

public class NumMin {
  public static void main(String[] args) {
    int numero1;
    int numero2;
    int numero3;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese un numero");
    numero1 = sc.nextInt();
    numero2 = sc.nextInt();
    numero3 = sc.nextInt();

    System.out.println("El numero minimo es " + minimo(numero1,numero2,numero3));
  }

  private static int minimo(int numero1, int numero2, int numero3) {

    int min;
    /*
    if (numero1 < numero2) {
      min = numero1;
    } else {
      min = numero2;
    }
    if (numero3 < min) {
      min = numero3;
    }
    return min;
  }
*/
    if (numero1 < numero2 && numero1 < numero3) {
      min = numero1;
    } else if (numero2 < numero1 && numero2 < numero3) {
      min = numero2;
    } else {
      min = numero3;
    }
    return min;
  }


}
